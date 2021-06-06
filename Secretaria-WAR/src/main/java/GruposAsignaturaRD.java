

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
import es.uma.informatica.sii.ejb.practica.ejb.GestionGruposAsignatura;
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
import es.uma.informatica.sii.ejb.practica.entidades.GruposAsignatura.GruposAsignaturaId;
import es.uma.informatica.sii.ejb.practica.entidades.Titulacion;


@Named(value = "gruposasignaturard")
@RequestScoped
public class GruposAsignaturaRD {
	@PersistenceContext(name = "Secretaria")
	private EntityManager em;
	
	@Inject 
	private GestionGruposAsignatura gestionGruposAsignatura;
	
	private String cursoAcademico;

	private Integer grupoGruposAsignatura;

	private Integer asignatura;
	
	private Integer titulacion;
	
	private GruposAsignatura gruposAsignatura;

	
	//getters y setters

	public String getCursoAcademico() {
		return cursoAcademico;
	}

	public void setCursoAcademico(String cursoAcademico) {
		this.cursoAcademico = cursoAcademico;
	}

	public Integer getGrupoGruposAsignatura() {
		return grupoGruposAsignatura;
	}

	public void setGrupoGruposAsignatura(Integer grupoGruposAsignatura) {
		this.grupoGruposAsignatura = grupoGruposAsignatura;
	}

	public Integer getAsignatura() {
		return asignatura;
	}

	public void setAsignatura(Integer asignatura) {
		this.asignatura = asignatura;
	}

	public Integer getTitulacion() {
		return titulacion;
	}

	public void setTitulacion(Integer titulacion) {
		this.titulacion = titulacion;
	}

	public GruposAsignatura getGruposAsignatura() {
		return gruposAsignatura;
	}

	public void setGruposAsignatura(GruposAsignatura gruposAsignatura) {
		this.gruposAsignatura = gruposAsignatura;
	}

	//métodos
	

	public String leerGruposAsignatura() {
		AsignaturaId id = new AsignaturaId(asignatura,titulacion);
		GruposAsignaturaId gaId = new GruposAsignaturaId(cursoAcademico, grupoGruposAsignatura,id);
		
		try {
			gruposAsignatura = gestionGruposAsignatura.readGrupoAsignatura(gaId);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Grupo-Asignatura leido correctamente"));
		}catch(Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se ha podido leer el grupo-asignatura"));
		}
		
		return null;
	}
	
	public String eliminarGruposAsignatura() {
		AsignaturaId id = new AsignaturaId(asignatura,titulacion);
		GruposAsignaturaId gaId = new GruposAsignaturaId(cursoAcademico, grupoGruposAsignatura,id);
		
		try {
			gestionGruposAsignatura.deleteGrupoAsignatura(gaId);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Grupo-Asignatura eliminado correctamente"));
		}catch(Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se ha podido eliminar el grupo-asignatura"));
		}
		
		return null;
	}
	

}

