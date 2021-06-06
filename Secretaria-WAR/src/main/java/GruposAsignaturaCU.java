

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
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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
import es.uma.informatica.sii.ejb.practica.entidades.Titulacion;

@Named(value = "gruposasignaturacu")
@RequestScoped
public class GruposAsignaturaCU{
	
	@PersistenceContext(name = "Secretaria")
	private EntityManager em;
	private static final Logger LOGGER = Logger.getLogger(AsignaturaCU.class.getCanonicalName());
	
	@Inject 
	private GestionAsignatura gestionAsignatura;
	
	@Inject 
	private GestionTitulacion gestionTitulacion;
	
	@Inject 
	private GestionGruposAsignatura gestionGruposAsignatura;
	
	@Inject 
	private GestionGrupo gestionGrupo;
	
	private String cursoAcademico;

	private char oferta;

	private Integer grupoGruposAsignatura;

	private Integer asignatura;
	
	private Integer titulacion;
	
	
	//getters and setters
	
	public String getCursoAcademico() {
		return cursoAcademico;
	}

	public void setCursoAcademico(String cursoAcademico) {
		this.cursoAcademico = cursoAcademico;
	}

	public char getOferta() {
		return oferta;
	}

	public void setOferta(char oferta) {
		this.oferta = oferta;
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


	//métodos
	
	public String crearGruposAsignatura() {
		GruposAsignatura gruposAsignatura = new GruposAsignatura();
		gruposAsignatura.setCursoAcademico(cursoAcademico);
		gruposAsignatura.setOferta(oferta);
		try {
			Grupo grupo = gestionGrupo.readGrupo(grupoGruposAsignatura);
			gruposAsignatura.setGrupoGruposAsignatura(grupo);
			
			AsignaturaId asignaturaId = new AsignaturaId(asignatura,titulacion);
			Asignatura asig = gestionAsignatura.readAsignatura(asignaturaId);
			gruposAsignatura.setAsignaturaGruposAsignatura(asig);
			
			gestionGruposAsignatura.createGruposAsignatura(gruposAsignatura);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Grupo-asignatura creado correctamente"));
		}catch(Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se ha podido crear el grupo-asignatura"));
		}
		return null;
	}
	
	public String modificarGruposAsignatura() {
		GruposAsignatura gruposAsignatura = new GruposAsignatura();
		gruposAsignatura.setCursoAcademico(cursoAcademico);
		gruposAsignatura.setOferta(oferta);
		try {
			Grupo grupo = gestionGrupo.readGrupo(grupoGruposAsignatura);
			gruposAsignatura.setGrupoGruposAsignatura(grupo);
			
			AsignaturaId asignaturaId = new AsignaturaId(asignatura,titulacion);
			Asignatura asig = gestionAsignatura.readAsignatura(asignaturaId);
			gruposAsignatura.setAsignaturaGruposAsignatura(asig);
			
			gestionGruposAsignatura.updateGrupoAsignatura(gruposAsignatura);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Grupo-asignatura modificado correctamente"));
		}catch(Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se ha podido modificar el grupo-asignatura"));
		}
		return null;
	}
	
}
