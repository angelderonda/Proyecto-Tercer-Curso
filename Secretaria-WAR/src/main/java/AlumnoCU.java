

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

@Named(value = "alumnocu")
@RequestScoped
public class AlumnoCU{
	
	@PersistenceContext(name = "Secretaria")
	private EntityManager em;
	private static final Logger LOGGER = Logger.getLogger(AsignaturaCU.class.getCanonicalName());
	
	@Inject 
	private GestionAlumno gestionAlumno;
	
	private Integer id;

	private String dni;

	private String nombre;

	private String apellido1;

	private String apellido2;

	private String emailInstitucional;

	private String emailPersonal;

	private String numeroArchivo;

	private String numeroMovil;

	private String numeroTelefono;

	private String direccion;

	private String localidad;

	private String provincia;

	private Integer cp;

	
	
	//getters y setters
	
	public GestionAlumno getGestionAlumno() {
		return gestionAlumno;
	}

	public void setGestionAlumno(GestionAlumno gestionAlumno) {
		this.gestionAlumno = gestionAlumno;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public String getEmailInstitucional() {
		return emailInstitucional;
	}

	public void setEmailInstitucional(String emailInstitucional) {
		this.emailInstitucional = emailInstitucional;
	}

	public String getEmailPersonal() {
		return emailPersonal;
	}

	public void setEmailPersonal(String emailPersonal) {
		this.emailPersonal = emailPersonal;
	}

	public String getNumeroArchivo() {
		return numeroArchivo;
	}

	public void setNumeroArchivo(String numeroArchivo) {
		this.numeroArchivo = numeroArchivo;
	}

	public String getNumeroMovil() {
		return numeroMovil;
	}

	public void setNumeroMovil(String numeroMovil) {
		this.numeroMovil = numeroMovil;
	}

	public String getNumeroTelefono() {
		return numeroTelefono;
	}

	public void setNumeroTelefono(String numeroTelefono) {
		this.numeroTelefono = numeroTelefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public Integer getCp() {
		return cp;
	}

	public void setCp(Integer cp) {
		this.cp = cp;
	}
	

	
	//métodos

	public String crearAlumno() {
		Alumno alumno = new Alumno();
		alumno.setId(id);
		alumno.setDni(dni);
		alumno.setNombreCompleto(nombre);
		alumno.setApellido1(apellido1);
		alumno.setApellido2(apellido2);
		alumno.setEmailInstitucional(emailInstitucional);
		alumno.setEmailPersonal(emailPersonal);
		alumno.setNumeroArchivo(numeroArchivo);
		alumno.setNumeroMovil(numeroMovil);
		alumno.setNumeroTelefono(numeroTelefono);
		alumno.setDireccion(direccion);
		alumno.setLocalidad(localidad);
		alumno.setProvincia(provincia);
		alumno.setCp(cp);
		
		try {
			gestionAlumno.createAlumno(alumno);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Alumno creado correctamente"));
		}catch(Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se ha podido crear el alumno"));
		}
		return null;
	}
	
	public String modificarAlumno() {
		Alumno alumno = new Alumno();
		alumno.setId(id);
		alumno.setDni(dni);
		alumno.setNombreCompleto(nombre);
		alumno.setApellido1(apellido1);
		alumno.setApellido2(apellido2);
		alumno.setEmailInstitucional(emailInstitucional);
		alumno.setEmailPersonal(emailPersonal);
		alumno.setNumeroArchivo(numeroArchivo);
		alumno.setNumeroMovil(numeroMovil);
		alumno.setNumeroTelefono(numeroTelefono);
		alumno.setDireccion(direccion);
		alumno.setLocalidad(localidad);
		alumno.setProvincia(provincia);
		alumno.setCp(cp);
		try {
			gestionAlumno.updateAlumno(alumno);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Alumno modificado correctamente"));
		}catch(Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se ha podido modificar el alumno"));
		}
		return null;
	}
	
}

