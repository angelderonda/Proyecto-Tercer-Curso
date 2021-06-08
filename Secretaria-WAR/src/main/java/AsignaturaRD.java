

import javax.inject.Named;
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
import javax.persistence.Column;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;

import es.uma.informatica.sii.ejb.practica.ejb.AsignaturaEJB;
import es.uma.informatica.sii.ejb.practica.ejb.GestionAlumno;
import es.uma.informatica.sii.ejb.practica.ejb.GestionAsignatura;
import es.uma.informatica.sii.ejb.practica.ejb.GestionGrupo;
import es.uma.informatica.sii.ejb.practica.ejb.GestionTitulacion;
import es.uma.informatica.sii.ejb.practica.ejb.TitulacionEJB;
import es.uma.informatica.sii.ejb.practica.ejb.exceptions.ObjetoNoExistenteException;
import es.uma.informatica.sii.ejb.practica.entidades.Alumno;
import es.uma.informatica.sii.ejb.practica.entidades.Asignatura;
import es.uma.informatica.sii.ejb.practica.entidades.Asignatura.AsignaturaId;
import es.uma.informatica.sii.ejb.practica.entidades.AsignaturasMatricula;
import es.uma.informatica.sii.ejb.practica.entidades.Clase;
import es.uma.informatica.sii.ejb.practica.entidades.Grupo;
import es.uma.informatica.sii.ejb.practica.entidades.GruposAsignatura;
import es.uma.informatica.sii.ejb.practica.entidades.Titulacion;


@Named(value = "asignaturard")
@RequestScoped
public class AsignaturaRD {
	@PersistenceContext(name = "Secretaria")
	private EntityManager em;
	
	@Inject 
	private GestionAsignatura gestionAsignatura;
	
	@Inject 
	private GestionTitulacion gestionTitulacion;
	
	private Integer referencia;
	
	private Integer titulacionAsignatura;
	
	private Asignatura asignatura;
	
	//private List<Clase> claseAsignatura;
	
	//private List<GruposAsignatura> gruposAsignaturaAsignatura;
	
	//private List<AsignaturasMatricula> asignaturasMatriculaAsignatura;
	
	
	//getters y setters

	public Integer getReferencia() {
		return referencia;
	}

	public void setReferencia(Integer referencia) {
		this.referencia = referencia;
	}

	public Integer getTitulacionAsignatura() {
		return titulacionAsignatura;
	}

	public void setTitulacionAsignatura(Integer titulacionAsignatura) {
		this.titulacionAsignatura = titulacionAsignatura;
	}
	
	
	
	public GestionAsignatura getGestionAsignatura() {
		return gestionAsignatura;
	}

	public void setGestionAsignatura(GestionAsignatura gestionAsignatura) {
		this.gestionAsignatura = gestionAsignatura;
	}

	public GestionTitulacion getGestionTitulacion() {
		return gestionTitulacion;
	}

	public void setGestionTitulacion(GestionTitulacion gestionTitulacion) {
		this.gestionTitulacion = gestionTitulacion;
	}

	//métodos
	
	
	public Asignatura getAsignatura() {
		return asignatura;
	}

	public void setAsignatura(Asignatura asignatura) {
		this.asignatura = asignatura;
	}

	public String leerAsignatura() {
		AsignaturaId id = new AsignaturaId(referencia,titulacionAsignatura);
		try {
			asignatura = gestionAsignatura.readAsignatura(id);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Asignatura leida correctamente"));
		}catch(Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se ha podido leer la asignatura"));
		}
		
		return null;
	}
	
	public String eliminarAsignatura() {
		AsignaturaId id = new AsignaturaId(referencia,titulacionAsignatura);
		
		try {
			gestionAsignatura.deleteAsignatura(id);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Asignatura eliminada correctamente"));
		}catch(Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se ha podido eliminar la asignatura"));
		}
		return null;
		
	}
	

}
