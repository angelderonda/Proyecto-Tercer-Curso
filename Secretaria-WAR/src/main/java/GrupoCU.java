import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.Column;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import es.uma.informatica.sii.ejb.practica.ejb.GestionGrupo;
import es.uma.informatica.sii.ejb.practica.ejb.GestionTitulacion;
import es.uma.informatica.sii.ejb.practica.entidades.Grupo;
import es.uma.informatica.sii.ejb.practica.entidades.Titulacion;

@Named(value = "grupocu")
@RequestScoped
public class GrupoCU{

	@PersistenceContext(name = "Secretaria")
	private EntityManager em;

	@Inject
	private GestionGrupo gestionGrupo;
	
	@Inject 
	private GestionTitulacion gestionTitulacion;
	
	private Integer id;
	private String asignar;
	private Integer curso;
	private char ingles;
	private char letra;
	private String plazas;
	private String turno_mañana_tarde;
	private char visible;
	
	private Integer grupoReflexiva;
	private Integer titulacionGrupo;
	
	//GETTERS Y SETTERS
	
	public GestionGrupo getGestionGrupo() {
		return gestionGrupo;
	}
	
	public void setGestionGrupo(GestionGrupo gestionGrupo) {
		this.gestionGrupo = gestionGrupo;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getAsignar() {
		return asignar;
	}
	
	public void setAsignar(String asignar) {
		this.asignar = asignar;
	}
	
	public Integer getCurso() {
		return curso;
	}
	
	public void setCurso(Integer curso) {
		this.curso = curso;
	}
	
	public char getIngles() {
		return ingles;
	}
	
	public void setIngles(char ingles) {
		this.ingles = ingles;
	}
	
	public char getLetra() {
		return letra;
	}
	
	public void setLetra(char letra) {
		this.letra = letra;
	}
	
	public String getPlazas() {
		return plazas;
	}
	
	public void setPlazas(String plazas) {
		this.plazas = plazas;
	}
	
	public String getTurno_mañana_tarde() {
		return turno_mañana_tarde;
	}
	
	public void setTurno_mañana_tarde(String turno_mañana_tarde) {
		this.turno_mañana_tarde = turno_mañana_tarde;
	}
	
	public char getVisible() {
		return visible;
	}
	
	public void setVisible(char visible) {
		this.visible = visible;
	}
	
	public Integer getGrupoReflexiva() {
		return grupoReflexiva;
	}
	
	public void setGrupoReflexiva(Integer grupoReflexiva) {
		this.grupoReflexiva = grupoReflexiva;
	}
	
	public Integer getTitulacionGrupo() {
		return titulacionGrupo;
	}
	
	public void setTitulacionGrupo(Integer titulacionGrupo) {
		this.titulacionGrupo = titulacionGrupo;
	}
	
	//MÉTODOS
	
	public String crearGrupo(){
		
		Grupo grupo = new Grupo();
		grupo.setCurso(curso);
		grupo.setId(id);
		grupo.setIngles(ingles);
		grupo.setLetra(letra);
		grupo.setPlazas(plazas);
		grupo.setTurno_mañana_tarde(turno_mañana_tarde);
		grupo.setVisible(visible);
		grupo.setAsignar(asignar);
		
		try {
			Titulacion tit = gestionTitulacion.readTitulacion(titulacionGrupo);
			grupo.setTitulacionGrupo(tit);
			
			gestionGrupo.createGrupo(grupo);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Grupo creado correctamente"));
		}catch(Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se ha podido crear el grupo"));
		}
		return null;
	}
	public String modificarGrupo() {
		
		Grupo grupo = new Grupo();
		grupo.setCurso(curso);
		grupo.setId(id);
		grupo.setIngles(ingles);
		grupo.setLetra(letra);
		grupo.setPlazas(plazas);
		grupo.setAsignar(asignar);
		grupo.setTurno_mañana_tarde(turno_mañana_tarde);
		grupo.setVisible(visible);
		
		try {
			//Grupo gr = gestionGrupo.readGrupo(grupoReflexiva);
			//grupo.setGrupoReflexiva(gr);
			
			Titulacion tit = gestionTitulacion.readTitulacion(titulacionGrupo);
			grupo.setTitulacionGrupo(tit);
			
			gestionGrupo.updateGrupo(grupo);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Grupo modificado correctamente"));
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se ha podido modificar el grupo"));
		}
		return null;
	}
	
	
}
