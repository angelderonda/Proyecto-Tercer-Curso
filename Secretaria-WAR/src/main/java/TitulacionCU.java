
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

@Named(value = "titulacioncu")
@RequestScoped
public class TitulacionCU {

	@PersistenceContext(name = "Secretaria")
	private EntityManager em;

	@Inject
	private GestionTitulacion gestionTitulacion;

	private Integer codigo;

	private Integer creditos;

	private String nombre;

	// getters y setters

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Integer getCreditos() {
		return creditos;
	}

	public void setCreditos(Integer creditos) {
		this.creditos = creditos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	// métodos

	public String crearTitulacion() {
		Titulacion titulacion = new Titulacion();
		titulacion.setCodigo(codigo);
		titulacion.setCreditos(creditos);
		titulacion.setNombre(nombre);
		try {
			gestionTitulacion.createTitulacion(titulacion);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Titulación creada correctamente"));
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se ha podido crear la titulación"));
		}
		return null;
	}

	public String modificarTitulacion() {
		Titulacion titulacion = new Titulacion();
		titulacion.setCodigo(codigo);
		titulacion.setCreditos(creditos);
		titulacion.setNombre(nombre);
		try {
			gestionTitulacion.updateTitulacion(titulacion);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Titulación modificada correctamente"));
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage("No se ha podido modificar la titulación"));
		}
		return null;
	}

}
