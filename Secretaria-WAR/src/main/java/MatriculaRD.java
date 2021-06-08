
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
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
import es.uma.informatica.sii.ejb.practica.ejb.GestionMatricula;
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
import es.uma.informatica.sii.ejb.practica.entidades.Matricula;
import es.uma.informatica.sii.ejb.practica.entidades.Matricula.MatriculaId;
import es.uma.informatica.sii.ejb.practica.entidades.Titulacion;

@Named(value = "matriculard")
@RequestScoped
public class MatriculaRD {
	@PersistenceContext(name = "Secretaria")
	private EntityManager em;
	
	@Inject
	private GestionMatricula gestionMatricula;

	private String cursoAcademico;
	private Integer nexpediente;

	private Matricula matricula;
	
	private List<AsignaturasMatricula> lista;
	
	// getters y setters

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

	public Matricula getMatricula() {
		return matricula;
	}

	public void setMatricula(Matricula matricula) {
		this.matricula = matricula;
	}
	
	public List<AsignaturasMatricula> getLista() {
		try {
			if(matricula!=null) lista = gestionMatricula.getAsignaturas(matricula);
			else lista = null;
			return lista;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public void setLista(List<AsignaturasMatricula> lista) {
		this.lista = lista;
	}
	
	// métodos
	
	public String leerMatricula() {
		try {
			matricula = gestionMatricula.readMatricula(new MatriculaId(cursoAcademico, nexpediente));
			if(gestionMatricula.conGrupos(matricula)) FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Matricula leida correctamente, el alumno tiene grupos asignados."));
			else FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Matricula leida correctamente, el alumno no tiene grupos asignados."));
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se ha podido leer la Matricula"));
		}
		return null;
	}

	public String eliminarMatricula() {
		try {
			gestionMatricula.deleteMatricula(new MatriculaId(cursoAcademico, nexpediente));
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Matricula eliminada correctamente"));
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage("No se ha podido eliminar la Matricula"));
		}
		return null;
	}

}
