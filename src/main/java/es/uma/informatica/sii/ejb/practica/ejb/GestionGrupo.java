package es.uma.informatica.sii.ejb.practica.ejb;



import javax.ejb.Local;

import es.uma.informatica.sii.ejb.practica.ejb.exceptions.ObjetoNoExistenteException;
import es.uma.informatica.sii.ejb.practica.ejb.exceptions.ObjetoYaExistenteException;
import es.uma.informatica.sii.ejb.practica.ejb.exceptions.ProyectoException;
import es.uma.informatica.sii.ejb.practica.entidades.Alumno;
import es.uma.informatica.sii.ejb.practica.entidades.Grupo;

@Local
public interface GestionGrupo {
	
	public void createGrupo(Grupo grupo) throws ObjetoYaExistenteException;
	public Grupo readGrupo(Integer idGrupo) throws ObjetoNoExistenteException;
	public void updateGrupo(Grupo grupo) throws ObjetoNoExistenteException;
	public void deleteGrupo(Integer idGrupo) throws ObjetoNoExistenteException;
	
	
	//RF 9
	public void gestionarCambioGrupo(Integer idAlumno, Integer idGrupo) throws ProyectoException;
	
	//RF 10
	public void incluirAlumno(Alumno alumno, Grupo grupo) throws ProyectoException;
	
	
}
