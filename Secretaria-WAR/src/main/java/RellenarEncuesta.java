import es.uma.informatica.sii.ejb.practica.entidades.Encuesta;
import es.uma.informatica.sii.ejb.practica.entidades.GruposAsignatura;

import java.util.List;
import java.util.logging.Logger;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import es.uma.informatica.sii.ejb.practica.ejb.GestionAlumno;
import es.uma.informatica.sii.ejb.practica.ejb.GestionGrupo;
import es.uma.informatica.sii.ejb.practica.ejb.TipoFiltro;
import es.uma.informatica.sii.ejb.practica.ejb.exceptions.ObjetoNoExistenteException;
import es.uma.informatica.sii.ejb.practica.ejb.exceptions.ProyectoException;
import es.uma.informatica.sii.ejb.practica.entidades.Alumno;
import es.uma.informatica.sii.ejb.practica.entidades.Encuesta;
import es.uma.informatica.sii.ejb.practica.entidades.Encuesta.EncuestaId;

@Named(value = "encuesta")
@RequestScoped
public class RellenarEncuesta {

	@PersistenceContext(name = "Secretaria")
	private EntityManager em;
	private Encuesta encuesta;
	private List<GruposAsignatura> lista;
	private String dni;
	private static final Logger LOGGER = Logger.getLogger(Escoger.class.getCanonicalName());
	private Alumno alumno;
	
	@Inject 
	private GestionAlumno gestionAlumno;
	
	public Encuesta getEncuesta() {
		return encuesta;
	}

	public void setEncuesta(Encuesta encuesta) {
		this.encuesta = encuesta;
	}

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

	public String enviarDniAlumno(){
		try {
			TypedQuery<Alumno> query = em.createQuery("SELECT a FROM Alumno a WHERE a.dni = :dni", Alumno.class);
			query.setParameter("dni", this.dni);
			setAlumno(query.getSingleResult()); 
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Alumno encontrado"));
			LOGGER.info("Alumno encontrado");
		}catch(Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Alumno no encontrado"));
			LOGGER.info("Alumno no encontrado");
		}
		return null;
	}
	
	public String rellenarEncuesta() {
		try {
			gestionAlumno.rellenarEncuesta(alumno.getId(), lista);
		}catch(Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se ha podido rellenar la encuesta."));
			LOGGER.info("No se ha podido rellenar la encuesta.");
		}
		return null;
	}
}
