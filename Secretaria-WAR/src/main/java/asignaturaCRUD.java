
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

@Named(value = "asignatura")
@RequestScoped
public class asignaturaCRUD {
	
	@PersistenceContext(name = "Secretaria")
	private EntityManager em;
	private static final Logger LOGGER = Logger.getLogger(asignaturaCRUD.class.getCanonicalName());
	
	@Inject 
	private GestionAsignatura gestionAsignatura;
	
	@Inject 
	private GestionTitulacion gestionTitulacion;
	
	private Integer referencia;

	private Integer codigo;

	private Integer curso;

	private Integer creditosTeoria;

	private Integer creditosPracticas;

	private String nombre;

	private String duracion;

	private String ofertada;

	private String tipo; 

	private String plazas;

	private String otro_idioma;
	
	public Integer getCodigo() {
		return codigo;
	}


	private Integer titulacionAsignatura;
	
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
	
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Integer getCurso() {
		return curso;
	}

	public void setCurso(Integer curso) {
		this.curso = curso;
	}

	public Integer getCreditosTeoria() {
		return creditosTeoria;
	}

	public void setCreditosTeoria(Integer creditosTeoria) {
		this.creditosTeoria = creditosTeoria;
	}

	public Integer getCreditosPracticas() {
		return creditosPracticas;
	}

	public void setCreditosPracticas(Integer creditosPracticas) {
		this.creditosPracticas = creditosPracticas;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDuracion() {
		return duracion;
	}

	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}

	public String getOfertada() {
		return ofertada;
	}

	public void setOfertada(String ofertada) {
		this.ofertada = ofertada;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getPlazas() {
		return plazas;
	}

	public void setPlazas(String plazas) {
		this.plazas = plazas;
	}

	public String getOtro_idioma() {
		return otro_idioma;
	}

	public void setOtro_idioma(String otro_idioma) {
		this.otro_idioma = otro_idioma;
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
	
	public String crearAsignatura() {
		Asignatura asignatura = new Asignatura();

		asignatura.setCodigo(codigo);
		asignatura.setCreditosPracticas(creditosTeoria);
		asignatura.setCreditosTeoria(creditosPracticas);
		asignatura.setCurso(curso);
		asignatura.setDuracion(duracion);
		asignatura.setNombre(nombre);
		asignatura.setOfertada(ofertada);
		asignatura.setOtro_idioma(otro_idioma);
		asignatura.setPlazas(plazas);
		asignatura.setReferencia(referencia);
		asignatura.setTipo(tipo);
		try {
			asignatura.setTitulacionAsignatura(gestionTitulacion.readTitulacion(titulacionAsignatura));
			gestionAsignatura.createAsignatura(asignatura);
			LOGGER.info("CREADO CORRECTAMENTE");
		}catch(Exception e) {
			LOGGER.info("NO CREADO");
		}
		return null;
	}
	
	public String leerAsignatura() {
		return null;
	}
	
	public String eliminarAsignatura() {
		AsignaturaId id = new AsignaturaId(referencia,titulacionAsignatura);
		
		try {
			gestionAsignatura.deleteAsignatura(id);
			LOGGER.info("ELIMINADO CORRECTAMENTE");
		}catch(Exception e) {
			LOGGER.info("NO ELIMINADO");
		}
		return null;
		
	}
	
	public String modificarAsignatura() {
		Asignatura asignatura = new Asignatura();

		asignatura.setCodigo(codigo);
		asignatura.setCreditosPracticas(creditosTeoria);
		asignatura.setCreditosTeoria(creditosPracticas);
		asignatura.setCurso(curso);
		asignatura.setDuracion(duracion);
		asignatura.setNombre(nombre);
		asignatura.setOfertada(ofertada);
		asignatura.setOtro_idioma(otro_idioma);
		asignatura.setPlazas(plazas);
		asignatura.setReferencia(referencia);
		asignatura.setTipo(tipo);
		try {
			asignatura.setTitulacionAsignatura(gestionTitulacion.readTitulacion(titulacionAsignatura));
			gestionAsignatura.updateAsignatura(asignatura);
			LOGGER.info("MODIFICADO CORRECTAMENTE");
		}catch(Exception e) {
			LOGGER.info("NO MODIFICADO");
		}
		return null;
	}
	
}
