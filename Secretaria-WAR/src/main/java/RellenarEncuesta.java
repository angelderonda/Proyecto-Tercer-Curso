import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;

import es.uma.informatica.sii.ejb.practica.ejb.GestionAlumno;
import es.uma.informatica.sii.ejb.practica.entidades.Alumno;
import es.uma.informatica.sii.ejb.practica.entidades.AsignaturasMatricula;
import es.uma.informatica.sii.ejb.practica.entidades.Grupo;
import es.uma.informatica.sii.ejb.practica.entidades.GruposAsignatura;


@Named(value = "encuesta")
@ViewScoped
public class RellenarEncuesta implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@PersistenceContext(name = "Secretaria")
	private EntityManager em;
	private List<Fila> listaFila;
	private List<GruposAsignatura> listaGruposAsignatura;
	private ArrayList<String> letras;
	private String dni;
	private Alumno alumno;
	
	private static final Logger LOGGER = Logger.getLogger(RellenarEncuesta.class.getCanonicalName());
	
	@Inject 
	private GestionAlumno gestionAlumno;

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public List<Fila> getListaFila() {
		return listaFila;
	}

	public void setListaFila(List<Fila> listaFila) {
		this.listaFila = listaFila;
	}
	
	public void init() {
		List<AsignaturasMatricula> lista;		
		List<Fila> listaDeFilas = new ArrayList<Fila>();
		try {
			listaGruposAsignatura = new ArrayList<>();
			TypedQuery<AsignaturasMatricula> query = em.createQuery(
					"SELECT am FROM AsignaturasMatricula am, Alumno a, Expediente e, Matricula m WHERE "
							+ "a = :alumno AND e.alumnoExpediente.id = a.id AND m.expedienteMatricula.numeroExpediente = e.numeroExpediente AND am.mat = m",
					AsignaturasMatricula.class);
			query.setParameter("alumno", alumno);
			lista = query.getResultList();
			
			for (AsignaturasMatricula am : lista) {
				GruposAsignatura grupoAsig = new GruposAsignatura();
				grupoAsig.setAsignaturaGruposAsignatura(am.getAsignaturaAsignaturasMatricula());
				grupoAsig.setGrupoGruposAsignatura(am.getGrupoAsignaturasMatricula());
				grupoAsig.setCursoAcademico(am.getMat().getCursoAcademico());
				listaGruposAsignatura.add(grupoAsig);

				letras = new ArrayList<String>();
				TypedQuery<Grupo> queryGrupo = em.createQuery(
						"SELECT ga.grupoGruposAsignatura FROM GruposAsignatura ga WHERE ga.asig = :asignatura",
						Grupo.class);
				queryGrupo.setParameter("asignatura", am.getAsignaturaAsignaturasMatricula());

				for (Grupo g : queryGrupo.getResultList()) {
					letras.add(g.getLetra() + "");
				}
				Fila f = new Fila();
				f.setAsignatura(am.getAsignaturaAsignaturasMatricula());
				//f.setLetra(am.getGrupoAsignaturasMatricula().getLetra() + "");
				f.setLetraSeleccionada(letras.get(0));
				f.setLetras(letras);
				//f.setGrupo(am.getGrupoAsignaturasMatricula());
				listaDeFilas.add(f);

			}

		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage("ERROR -- El alumno no tiene ningun grupo asignado"));
		}
		listaFila = listaDeFilas;		
	}
	
	public String enviarDniAlumno(){
		try {
			TypedQuery<Alumno> query = em.createQuery("SELECT a FROM Alumno a WHERE a.dni = :dni", Alumno.class);
			query.setParameter("dni", this.dni);
			setAlumno(query.getSingleResult()); 
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Alumno encontrado"));
			init();
		}catch(Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Alumno no encontrado"));
		}
		return null;
	}
	
	public void onRowEdit(RowEditEvent<Fila> event) {
		FacesMessage msg = new FacesMessage("Fila editada",
				"Asignatura " + String.valueOf(event.getObject().getAsignatura().getNombre()) + " cambiada al grupo "
						+ String.valueOf(event.getObject().getLetraSeleccionada()));
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void onRowCancel(RowEditEvent<Fila> event) {
		FacesMessage msg = new FacesMessage("No se ha modificado la fila");
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void onCellEdit(CellEditEvent<Fila> event) {
		Object oldValue = event.getOldValue();
		Object newValue = event.getNewValue();

		if (newValue != null && !newValue.equals(oldValue)) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cell Changed",
					"Old: " + oldValue + ", New:" + newValue);
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
	}
	
	public String rellenarEncuesta() {
		LOGGER.info("--------------------Entramos RELLENAR ENCUESTA --------------------");
		for (int i = 0; i < listaGruposAsignatura.size(); i++) {
			LOGGER.info("Grupo ASIG: " + listaGruposAsignatura.get(i));
			LOGGER.info("FILA: " + listaFila.get(i));
			TypedQuery<Grupo> queryGrupo = em
					.createQuery("SELECT g FROM Grupo g WHERE g.curso = :curso AND g.letra = :letra ", Grupo.class);
			String codigo = String.valueOf((listaFila.get(i).getAsignatura().getCodigo()));
			queryGrupo.setParameter("curso",  Integer.parseInt(codigo.substring(0, 1)));
			queryGrupo.setParameter("letra", listaFila.get(i).getLetraSeleccionada().toCharArray()[0]);
			
			LOGGER.info("CURSO: " + Integer.parseInt(codigo.substring(0, 1)) + " LETRA: " + listaFila.get(i).getLetraSeleccionada().toCharArray()[0]);
			
			listaGruposAsignatura.get(i).setGrupoGruposAsignatura(queryGrupo.getSingleResult());
		}
		try {
			gestionAlumno.rellenarEncuesta(alumno.getId(), listaGruposAsignatura);
		}catch(Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se ha podido rellenar la encuesta."));
			LOGGER.info(e.getMessage());
		}
		return null;
	}
}
