import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import es.uma.informatica.sii.ejb.practica.ejb.GestionAlumno;
import es.uma.informatica.sii.ejb.practica.ejb.TipoFiltro;
import es.uma.informatica.sii.ejb.practica.ejb.exceptions.ObjetoNoExistenteException;
import es.uma.informatica.sii.ejb.practica.ejb.exceptions.ProyectoException;
import es.uma.informatica.sii.ejb.practica.entidades.Alumno;
import es.uma.informatica.sii.ejb.practica.entidades.AsignaturasMatricula;
import es.uma.informatica.sii.ejb.practica.entidades.Encuesta;
import es.uma.informatica.sii.ejb.practica.entidades.Grupo;
import es.uma.informatica.sii.ejb.practica.entidades.GruposAsignatura;
import es.uma.informatica.sii.ejb.practica.entidades.Encuesta.EncuestaId;

@Named(value = "asignarManual")
@RequestScoped
public class AsignarManual {
	
	
	@Inject 
	private GestionAlumno alumnoEJB;
	@PersistenceContext(name = "Secretaria")
	private EntityManager em;
	private static Alumno alumno;
	private List<Fila> listaFila;
	private List<GruposAsignatura> listaGruposAsignatura;
	private ArrayList<String> letras;
	
	public List<Fila> getListaFila() {
		return listaFila;
	}

	public void setListaFila(List<Fila> listaFila) {
		this.listaFila = listaFila;
	}
	
	
	public static void setAlumnoId(Alumno al) {
		alumno = al;
	}
	
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
				f.setLetraSeleccionada(letras.get(0));
				f.setLetras(letras);
				listaDeFilas.add(f);
			}

		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage("ERROR -- El alumno no tiene ningun grupo asignado"));
		}
		listaFila = listaDeFilas;		
	}
	
	public String confirmar() {
		for (int i = 0; i < listaGruposAsignatura.size(); i++) {
			TypedQuery<Grupo> queryGrupo = em
					.createQuery("SELECT g FROM Grupo g WHERE g.curso = :curso AND g.letra = :letra ", Grupo.class);
			String codigo = String.valueOf((listaFila.get(i).getAsignatura().getCodigo()));
			queryGrupo.setParameter("curso",  Integer.parseInt(codigo.substring(0, 1)));
			queryGrupo.setParameter("letra", listaFila.get(i).getLetraSeleccionada().toCharArray()[0]);
			listaGruposAsignatura.get(i).setGrupoGruposAsignatura(queryGrupo.getSingleResult());
		}
		try {
			alumnoEJB.asignarGrupo(alumno.getId(), listaGruposAsignatura,null,true);
		}catch(Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se ha podido rellenar la encuesta."));
		}
		return null;
	}
	
}
