

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
import es.uma.informatica.sii.ejb.practica.ejb.GestionExpediente;
import es.uma.informatica.sii.ejb.practica.ejb.GestionGrupo;
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
import es.uma.informatica.sii.ejb.practica.entidades.Titulacion;

@Named(value = "expedientecu")
@RequestScoped
public class ExpedienteCU{
	
	@PersistenceContext(name = "Secretaria")
	private EntityManager em;
	
	@Inject 
	private GestionExpediente gestionExpediente;
	
	@Inject 
	private GestionAlumno gestionAlumno;
	
	@Inject 
	private GestionTitulacion gestionTitulacion;
	
	private Integer numeroExpediente;
	
	private Integer creditosCF;
	
	private Integer creditosFB;
	
	private Integer creditosMO;
	
	private Integer creditosOP;
	
	private Integer creditosPE;
	
	private Integer creditosTF;
	
	private Float notaMediaProvisional;

	private Integer alumnoExpediente;
	
	private Integer titulacionExpediente;
	
	//getters y setters

	public GestionExpediente getGestionExpediente() {
		return gestionExpediente;
	}

	public void setGestionExpediente(GestionExpediente gestionExpediente) {
		this.gestionExpediente = gestionExpediente;
	}

	public Integer getNumeroExpediente() {
		return numeroExpediente;
	}

	public void setNumeroExpediente(Integer numeroExpediente) {
		this.numeroExpediente = numeroExpediente;
	}

	public Integer getCreditosCF() {
		return creditosCF;
	}

	public void setCreditosCF(Integer creditosCF) {
		this.creditosCF = creditosCF;
	}

	public Integer getCreditosFB() {
		return creditosFB;
	}

	public void setCreditosFB(Integer creditosFB) {
		this.creditosFB = creditosFB;
	}

	public Integer getCreditosMO() {
		return creditosMO;
	}

	public void setCreditosMO(Integer creditosMO) {
		this.creditosMO = creditosMO;
	}

	public Integer getCreditosOP() {
		return creditosOP;
	}

	public void setCreditosOP(Integer creditosOP) {
		this.creditosOP = creditosOP;
	}

	public Integer getCreditosPE() {
		return creditosPE;
	}

	public void setCreditosPE(Integer creditosPE) {
		this.creditosPE = creditosPE;
	}

	public Integer getCreditosTF() {
		return creditosTF;
	}

	public void setCreditosTF(Integer creditosTF) {
		this.creditosTF = creditosTF;
	}

	public Float getNotaMediaProvisional() {
		return notaMediaProvisional;
	}

	public void setNotaMediaProvisional(Float notaMediaProvisional) {
		this.notaMediaProvisional = notaMediaProvisional;
	}

	public Integer getAlumnoExpediente() {
		return alumnoExpediente;
	}

	public void setAlumnoExpediente(Integer alumnoExpediente) {
		this.alumnoExpediente = alumnoExpediente;
	}

	public Integer getTitulacionExpediente() {
		return titulacionExpediente;
	}

	public void setTitulacionExpediente(Integer titulacionExpediente) {
		this.titulacionExpediente = titulacionExpediente;
	}
	
	
	//métodos
	
	public String crearExpediente() {
		Expediente expediente = new Expediente();
		expediente.setActivo('1');
		expediente.setCreditosCF(creditosCF);
		expediente.setCreditosFB(creditosFB);
		expediente.setCreditosMO(creditosMO);
		expediente.setCreditosOP(creditosOP);
		expediente.setCreditosPE(creditosPE);
		expediente.setCreditosTF(creditosTF);
		expediente.setNotaMediaProvisional(notaMediaProvisional);
		expediente.setNumeroExpediente(numeroExpediente);
		
		
		try {
			Alumno alumno = gestionAlumno.readAlumno(alumnoExpediente);
			Titulacion titulacion = gestionTitulacion.readTitulacion(titulacionExpediente);
			expediente.setAlumnoExpediente(alumno);
			expediente.setTitulacionExpediente(titulacion);
			gestionExpediente.createExpediente(expediente);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Expediente creado correctamente"));
		}catch(Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se ha podido crear el expediente"));
		}
		return null;
	}
	
	public String modificarExpediente() {
		Expediente expediente = new Expediente();
		expediente.setActivo('1');
		expediente.setCreditosCF(creditosCF);
		expediente.setCreditosFB(creditosFB);
		expediente.setCreditosMO(creditosMO);
		expediente.setCreditosOP(creditosOP);
		expediente.setCreditosPE(creditosPE);
		expediente.setCreditosTF(creditosTF);
		expediente.setNotaMediaProvisional(notaMediaProvisional);
		expediente.setNumeroExpediente(numeroExpediente);
		try {
			Alumno alumno = gestionAlumno.readAlumno(alumnoExpediente);
			Titulacion titulacion = gestionTitulacion.readTitulacion(titulacionExpediente);
			expediente.setAlumnoExpediente(alumno);
			expediente.setTitulacionExpediente(titulacion);
			gestionExpediente.updateExpediente(expediente);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Expediente modificado correctamente"));
		}catch(Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se ha podido modificar el expediente"));
		}
		return null;
	}
	
}

