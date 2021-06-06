import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
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
import es.uma.informatica.sii.ejb.practica.entidades.Expediente;
import es.uma.informatica.sii.ejb.practica.entidades.Matricula;
import es.uma.informatica.sii.ejb.practica.entidades.Encuesta.EncuestaId;

@Named(value = "asignar")
@RequestScoped
public class Asignar {

	private static final Logger LOGGER = Logger.getLogger(Asignar.class.getCanonicalName());

	@Inject
	private GestionAlumno alumnoEJB;

	@PersistenceContext(name = "Secretaria")
	private EntityManager em;

	private List<Alumno> lista;

	public GestionAlumno getAlumno() {
		return alumnoEJB;
	}

	public void setAlumno(GestionAlumno alumno) {
		this.alumnoEJB = alumno;
	}

	public List<Alumno> getLista() {
		// try {
		lista = alumnoEJB.getAlumnoSinGrupo();
		/*
		 * List<Alumno> alumnos =
		 * alumnoEJB.listarAlumnos(TipoFiltro.ALUMNOS_POR_ASIGNAR, 0f); lista = new
		 * ArrayList<>(); for (Alumno a : alumnos) { TypedQuery<AsignaturasMatricula>
		 * query = em.
		 * createQuery("SELECT am FROM AsignaturasMatricula am, Alumno a, Expediente e, Matricula m WHERE "
		 * +
		 * "a = :alumno AND e.alumnoExpediente.id = a.id AND m.expedienteMatricula.numeroExpediente = e.numeroExpediente AND am.mat = m"
		 * , AsignaturasMatricula.class); query.setParameter("alumno", a);
		 * List<AsignaturasMatricula> listAm = query.getResultList(); int cont = 0; for
		 * (AsignaturasMatricula am : listAm) { if (am.getGrupoAsignaturasMatricula() ==
		 * null) cont++; } if (cont > 0 && cont == listAm.size()) lista.add(a); }
		 */
		// } catch (Exception e) {
		// TODO: handle exception
		// }
		return lista;
	}

	public void setLista(List<Alumno> lista) {
		this.lista = lista;
	}

	public String asignarAutomatico(Integer id) {
		LOGGER.info("Entramos en el metodo asignar Automatico, ID del alumno: " + id);
		try {
			Alumno a = em.find(Alumno.class, id);
			if (a != null) {
				List<Encuesta> listaEncuesta = a.getExpedienteActivo().getEncuestaExpediente();
				Encuesta encuesta = listaEncuesta.get(listaEncuesta.size() - 1);
				EncuestaId encuestaId = new EncuestaId(encuesta.getFechaEnvio(),
						encuesta.getExpedienteEncuesta().getNumeroExpediente());
				if (listaEncuesta != null)
					alumnoEJB.asignarGrupo(a.getId(), null, encuestaId, false);
			}
		} catch (ObjetoNoExistenteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	public String asignarManual(Alumno alumno) {
		AsignarManual.setAlumnoId(alumno);
		return "asignarManual.xhtml";
	}

}
