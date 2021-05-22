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

import es.uma.informatica.sii.ejb.practica.ejb.GestionAlumno;
import es.uma.informatica.sii.ejb.practica.ejb.TipoFiltro;
import es.uma.informatica.sii.ejb.practica.ejb.exceptions.ObjetoNoExistenteException;
import es.uma.informatica.sii.ejb.practica.ejb.exceptions.ProyectoException;
import es.uma.informatica.sii.ejb.practica.entidades.Alumno;
import es.uma.informatica.sii.ejb.practica.entidades.AsignaturasMatricula;
import es.uma.informatica.sii.ejb.practica.entidades.Encuesta;
import es.uma.informatica.sii.ejb.practica.entidades.Encuesta.EncuestaId;

@Named
@RequestScoped
public class Escoger {
	
	@PersistenceContext(name = "Secretaria")
	private EntityManager em;
	
	private static Alumno a;
	
	
	private List<AsignaturasMatricula> lista;

	public List<AsignaturasMatricula> getLista() {
		return lista;
	}

	public void setLista(List<AsignaturasMatricula> lista) {
		this.lista = lista;
	}
	
	public static void setAlumno(Alumno al) {
		a = al;
	}
	
	public String inicializarLista() {
		try {
			TypedQuery<AsignaturasMatricula> query = em.createQuery("SELECT am FROM AsignaturasMatricula am, Alumno a, Expediente e, Matricula m WHERE " + 
			"a = :alumno AND e.alumnoExpediente.id = a.id AND m.expedienteMatricula.numeroExpediente = e.numeroExpediente AND am.mat = m", AsignaturasMatricula.class);
			query.setParameter("alumno", a);
			lista = query.getResultList(); 
		}catch (Exception e) {
			// TODO: handle exception
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("ERROR -- El alumno no tiene ningun grupo asignado"));
		}	
		return "escogerGrupo.xhtml";
	}
	
	public String cambio() {
		return null;
	}
	
}
