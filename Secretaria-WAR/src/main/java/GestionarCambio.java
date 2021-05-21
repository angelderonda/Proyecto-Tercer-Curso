import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.TypedQuery;

import es.uma.informatica.sii.ejb.practica.ejb.GestionGrupo;
import es.uma.informatica.sii.ejb.practica.ejb.TipoFiltro;
import es.uma.informatica.sii.ejb.practica.ejb.exceptions.ObjetoNoExistenteException;
import es.uma.informatica.sii.ejb.practica.ejb.exceptions.ProyectoException;
import es.uma.informatica.sii.ejb.practica.entidades.Alumno;
import es.uma.informatica.sii.ejb.practica.entidades.Encuesta;
import es.uma.informatica.sii.ejb.practica.entidades.Encuesta.EncuestaId;

@Named(value = "gestionar")
@RequestScoped
public class GestionarCambio {

	@Inject 
	private GestionGrupo grupoEJB;

	public GestionGrupo getGrupoEJB() {
		return grupoEJB;
	}

	public void setGrupoEJB(GestionGrupo grupoEJB) {
		this.grupoEJB = grupoEJB;
	}
	
	public void aceptar(Alumno a) {
		
	}
	
	public void denegar(Alumno a){
		
	}
}
