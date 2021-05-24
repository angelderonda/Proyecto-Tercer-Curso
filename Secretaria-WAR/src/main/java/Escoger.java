import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
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
import es.uma.informatica.sii.ejb.practica.entidades.Grupo;
import es.uma.informatica.sii.ejb.practica.entidades.GruposAsignatura;

@Named("escoger")
@RequestScoped
public class Escoger {
	
	private static final Logger LOGGER = Logger.getLogger(Escoger.class.getCanonicalName());
	
	@PersistenceContext(name = "Secretaria")
	private EntityManager em;
	
	private static Alumno a;
	
	private List<GruposAsignatura> listaGruposAsignatura;
	
	private List<AsignaturasMatricula> lista;
	
	private List<String> letras;
	
	private String letra;
	
	public String getLetra() {
		return letra;
	}

	public void setLetra(String letra) {
		this.letra = letra;
	}

	public List<String> getLetras() {
		return letras;
	}

	public void setLetras(List<String> letras) {
		this.letras = letras;
	}

	public List<AsignaturasMatricula> getLista() {
		try {
			listaGruposAsignatura = new ArrayList<>();
			TypedQuery<AsignaturasMatricula> query = em.createQuery("SELECT am FROM AsignaturasMatricula am, Alumno a, Expediente e, Matricula m WHERE " + 
			"a = :alumno AND e.alumnoExpediente.id = a.id AND m.expedienteMatricula.numeroExpediente = e.numeroExpediente AND am.mat = m", AsignaturasMatricula.class);
			query.setParameter("alumno", a);
			lista = query.getResultList(); 
			for(AsignaturasMatricula am : lista) {
				GruposAsignatura grupoAsig = new GruposAsignatura();
				grupoAsig.setAsignaturaGruposAsignatura(am.getAsignaturaAsignaturasMatricula());
				grupoAsig.setGrupoGruposAsignatura(am.getGrupoAsignaturasMatricula());
				listaGruposAsignatura.add(grupoAsig);
			}
		}catch (Exception e) {
			// TODO: handle exception
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("ERROR -- El alumno no tiene ningun grupo asignado"));
		}	
		return lista;
	}

	public void setLista(List<AsignaturasMatricula> lista) {
		this.lista = lista;
	}
	
	public static void setAlumno(Alumno al) {
		a = al;
	}
	
	public String mostrarGrupos(AsignaturasMatricula asigMatricula) {
		letras = new ArrayList<String>();
		TypedQuery<Grupo> query = em.createQuery("SELECT ga.grupoGruposAsignatura FROM GruposAsignatura ga WHERE ga.asig = :asignatura", Grupo.class);
		query.setParameter("asignatura", asigMatricula.getAsignaturaAsignaturasMatricula());
		for(Grupo g : query.getResultList()) {
			letras.add(g.getLetra()+"");
		}
		return null;
	}
	
	public String cambio() {
		return null;
	}
	/*
	public void metodoSelect() {
		LOGGER.info("ANGELETE ERES FEOOOOOOOOOOOOOOOOOOOOOOO LETRA: ");
	}*/
	
	public void valueChanged(ValueChangeEvent event) {
		LOGGER.info("ANGELETE ERES FEOOOOOOOOOOOOOOOOOOOOOOO LETRA: ");
	}
	
}
