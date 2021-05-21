import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import es.uma.informatica.sii.ejb.practica.ejb.GestionAlumno;

@Named(value = "asignar")
@RequestScoped
public class Asignar {
	
	@Inject 
	private GestionAlumno alumno;
	
	
}
