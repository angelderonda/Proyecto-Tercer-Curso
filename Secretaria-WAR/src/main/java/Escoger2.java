import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
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

import es.uma.informatica.sii.ejb.practica.ejb.GestionGrupo;
import es.uma.informatica.sii.ejb.practica.ejb.exceptions.ObjetoNoExistenteException;
import es.uma.informatica.sii.ejb.practica.entidades.Alumno;
import es.uma.informatica.sii.ejb.practica.entidades.AsignaturasMatricula;
import es.uma.informatica.sii.ejb.practica.entidades.Grupo;
import es.uma.informatica.sii.ejb.practica.entidades.GruposAsignatura;

@Named("escoger2")
@ViewScoped
public class Escoger2 implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@PersistenceContext(name = "Secretaria")
	private EntityManager em;

	@Inject
	private GestionGrupo grupoEJB;

	private List<Fila> listaFila;

	private List<GruposAsignatura> listaGruposAsignatura;

	private ArrayList<String> letras;

	private static Alumno a;

	@PostConstruct
	public void init() {
		List<AsignaturasMatricula> lista;		
		List<Fila> listaDeFilas = new ArrayList<Fila>();
		try {
			listaGruposAsignatura = new ArrayList<>();
			TypedQuery<AsignaturasMatricula> query = em.createQuery(
					"SELECT am FROM AsignaturasMatricula am, Alumno a, Expediente e, Matricula m WHERE "
							+ "a = :alumno AND e.alumnoExpediente.id = a.id AND m.expedienteMatricula.numeroExpediente = e.numeroExpediente AND am.mat = m",
					AsignaturasMatricula.class);
			query.setParameter("alumno", a);
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
				f.setLetra(am.getGrupoAsignaturasMatricula().getLetra() + "");
				f.setLetraSeleccionada(am.getGrupoAsignaturasMatricula().getLetra() + "");
				f.setLetras(letras);
				f.setGrupo(am.getGrupoAsignaturasMatricula());
				listaDeFilas.add(f);

			}

		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage("ERROR -- El alumno no tiene ningun grupo asignado"));
		}
		listaFila = listaDeFilas;		
	}

	public static void setAlumno(Alumno al) {
		a = al;
	}

	public List<Fila> getListaFila() {
		return listaFila;
	}

	public void setListaFila(List<Fila> listaFila) {
		this.listaFila = listaFila;
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

	public String confirmarCambio() {

		for (int i = 0; i < listaGruposAsignatura.size(); i++) {

			TypedQuery<Grupo> queryGrupo = em
					.createQuery("SELECT g FROM Grupo g WHERE g.curso = :curso AND g.letra = :letra ", Grupo.class);
			queryGrupo.setParameter("curso", listaFila.get(i).getGrupo().getCurso());
			queryGrupo.setParameter("letra", listaFila.get(i).getLetraSeleccionada().toCharArray()[0]);

			listaGruposAsignatura.get(i).setGrupoGruposAsignatura(queryGrupo.getSingleResult());
		}
		try {
			grupoEJB.gestionarCambioGrupo(a.getId(), listaGruposAsignatura, true);
		} catch (ObjetoNoExistenteException e) {
			e.printStackTrace();
		}
		return null;

	}
}
