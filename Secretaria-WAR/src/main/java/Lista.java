import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import es.uma.informatica.sii.ejb.practica.ejb.AlumnoEJB;
import es.uma.informatica.sii.ejb.practica.ejb.GestionAlumno;
import es.uma.informatica.sii.ejb.practica.ejb.TipoFiltro;
import es.uma.informatica.sii.ejb.practica.ejb.exceptions.ProyectoException;
import es.uma.informatica.sii.ejb.practica.entidades.Alumno;

@Named(value = "lista")
@RequestScoped
public class Lista {
	
	@Inject 
	private GestionAlumno alumno;
	
	private String filtro;
	
	private float parametro;
	
	
	private List<Alumno> lista;
	
	

	public String getFiltro() {
		return filtro;
	}

	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}

	public float getParametro() {
		return parametro;
	}

	public void setParametro(float parametro) {
		this.parametro = parametro;
	}

	public List<Alumno> getLista() {
		return lista;
	}

	public void setLista(List<Alumno> lista) {
		this.lista = lista;
	}

	public String mostrar() {
		try {
			lista = alumno.listarAlumnos(TipoFiltro.valueOf(filtro), parametro);			
		} catch (ProyectoException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
}
