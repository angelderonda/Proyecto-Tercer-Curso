import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import es.uma.informatica.sii.ejb.practica.ejb.GestionGrupo;
import es.uma.informatica.sii.ejb.practica.ejb.TipoFiltro;
import es.uma.informatica.sii.ejb.practica.ejb.exceptions.ObjetoNoExistenteException;
import es.uma.informatica.sii.ejb.practica.ejb.exceptions.ProyectoException;
import es.uma.informatica.sii.ejb.practica.entidades.Alumno;
import es.uma.informatica.sii.ejb.practica.entidades.Encuesta;
import es.uma.informatica.sii.ejb.practica.entidades.Encuesta.EncuestaId;

@Named(value = "gestion")
@RequestScoped
public class GestionarCambio {

	@Inject 
	private GestionGrupo grupoEJB;
	
	@PersistenceContext(name = "Secretaria")
	private EntityManager em;
	
	private Alumno alumno;
	
	private String dni;
		
	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public GestionGrupo getGrupoEJB() {
		return grupoEJB;
	}

	public void setGrupoEJB(GestionGrupo grupoEJB) {
		this.grupoEJB = grupoEJB;
	}
	
	public String buscarAlumno() {
		try {
			TypedQuery<Alumno> query = em.createQuery("SELECT a FROM Alumno a WHERE a.dni = :dni", Alumno.class);
			query.setParameter("dni", dni);
			alumno = query.getSingleResult(); 
			Escoger.setAlumno(alumno);
		}catch (Exception e) {
			// TODO: handle exception
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("DNI doesn´t exist"));
		}	
		return null;
	}
}
