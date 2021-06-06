import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import es.uma.informatica.sii.ejb.practica.ejb.GestionGrupo;
import es.uma.informatica.sii.ejb.practica.ejb.GestionTitulacion;
import es.uma.informatica.sii.ejb.practica.entidades.Grupo;

@Named(value = "grupord")
@RequestScoped
public class GrupoRD {
	

	@Inject
	private GestionGrupo gestionGrupo;
	
	@Inject 
	private GestionTitulacion gestionTitulacion;
	
	private Integer id;
	
	private Grupo grupo;

	//setters y getters
	
	public GestionGrupo getGestionGrupo() {
		return gestionGrupo;
	}

	public void setGestionGrupo(GestionGrupo gestionGrupo) {
		this.gestionGrupo = gestionGrupo;
	}

	public GestionTitulacion getGestionTitulacion() {
		return gestionTitulacion;
	}

	public void setGestionTitulacion(GestionTitulacion gestionTitulacion) {
		this.gestionTitulacion = gestionTitulacion;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}
	
	
	//métodos

	public String leerGrupo() {
		try {
		grupo = gestionGrupo.readGrupo(id);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Grupo leido correctamente"));
		}catch(Exception e) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se ha podido leer el Grupo"));
		}
	return null;
		
	}
	
	public String eliminarGrupo() {
		try {
			gestionGrupo.deleteGrupo(id);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Grupo eliminado correctamente"));
		}catch(Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se ha podido eliminar el grupo"));
		}
		return null;
	}
}
