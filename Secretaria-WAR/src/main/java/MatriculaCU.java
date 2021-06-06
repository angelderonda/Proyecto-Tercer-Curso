
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Set;
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
import es.uma.informatica.sii.ejb.practica.ejb.GestionMatricula;
import es.uma.informatica.sii.ejb.practica.ejb.GestionTitulacion;
import es.uma.informatica.sii.ejb.practica.ejb.TitulacionEJB;
import es.uma.informatica.sii.ejb.practica.ejb.exceptions.ObjetoNoExistenteException;
import es.uma.informatica.sii.ejb.practica.entidades.Alumno;
import es.uma.informatica.sii.ejb.practica.entidades.Asignatura;
import es.uma.informatica.sii.ejb.practica.entidades.Asignatura.AsignaturaId;
import es.uma.informatica.sii.ejb.practica.entidades.AsignaturasMatricula;
import es.uma.informatica.sii.ejb.practica.entidades.Clase;
import es.uma.informatica.sii.ejb.practica.entidades.Expediente;
import es.uma.informatica.sii.ejb.practica.entidades.Grupo;
import es.uma.informatica.sii.ejb.practica.entidades.GruposAsignatura;
import es.uma.informatica.sii.ejb.practica.entidades.Matricula;
import es.uma.informatica.sii.ejb.practica.entidades.Titulacion;

@Named(value = "matriculacu")
@RequestScoped
public class MatriculaCU {

	@PersistenceContext(name = "Secretaria")
	private EntityManager em;

	@Inject
	private GestionMatricula gestionMatricula;

	private String cursoAcademico;
	private Integer nexpediente;
	private String turnoPreferente;
	private Integer numeroArchivo;
	private Integer ingreso;

	// getters and setters

	public String getCursoAcademico() {
		return cursoAcademico;
	}

	public void setCursoAcademico(String cursoAcademico) {
		this.cursoAcademico = cursoAcademico;
	}

	public Integer getNexpediente() {
		return nexpediente;
	}

	public void setNexpediente(Integer nexpediente) {
		this.nexpediente = nexpediente;
	}

	public String getTurnoPreferente() {
		return turnoPreferente;
	}

	public void setTurnoPreferente(String turnoPreferente) {
		this.turnoPreferente = turnoPreferente;
	}

	public Integer getNumeroArchivo() {
		return numeroArchivo;
	}

	public void setNumeroArchivo(Integer numeroArchivo) {
		this.numeroArchivo = numeroArchivo;
	}

	// métodos

	public String crearMatricula() {
		Matricula matricula = new Matricula();
		matricula.setCursoAcademico(cursoAcademico);
		matricula.setTurnoPreferente(turnoPreferente);
		matricula.setNumeroArchivo(numeroArchivo);

		matricula.setNuevoIngreso(ingreso);
		matricula.setEstado("Activo");
		matricula.setFechaMatricula(new java.util.Date());

		

		Expediente expediente = em.find(Expediente.class, nexpediente);
		if (expediente == null) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se ha encontrado el expediente"));
		} else {
			matricula.setExpedienteMatricula(expediente);
		}
		try {
			gestionMatricula.createMatricula(matricula);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Matricula creada correctamente"));
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se ha podido crear la matricula"));
		}
		return null;
	}

	public String modificarMatricula() {
		Matricula matricula = new Matricula();
		matricula.setCursoAcademico(cursoAcademico);
		matricula.setTurnoPreferente(turnoPreferente);
		matricula.setNumeroArchivo(numeroArchivo);
		
		matricula.setNuevoIngreso(ingreso);
		matricula.setEstado("Activo");
		matricula.setFechaMatricula(new java.util.Date());

		Expediente expediente = em.find(Expediente.class, nexpediente);
		if (expediente == null) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se ha encontrado el expediente"));
		} else {
			matricula.setExpedienteMatricula(expediente);
		}
		try {
			gestionMatricula.updateMatricula(matricula);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Matricula modificada correctamente"));
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage("No se ha podido modificar la matricula"));
		}
		return null;
	}

}
