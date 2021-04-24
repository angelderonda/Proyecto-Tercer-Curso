package es.uma.informatica.sii.ejb.practica.ejb;

import javax.ejb.Local;

import es.uma.informatica.sii.ejb.practica.ejb.exceptions.ObjetoNoExistenteException;
import es.uma.informatica.sii.ejb.practica.ejb.exceptions.ObjetoYaExistenteException;
import es.uma.informatica.sii.ejb.practica.entidades.Titulacion;

@Local
public interface GestionTitulacion {

	//CRUD (CREAR, LEER, ACTUALIZAR Y ELIMINAR) TITULACION
	
	public void createTitulacion(Titulacion titulacion) throws ObjetoYaExistenteException;

	public Titulacion readTitulacion(Integer codigo) throws ObjetoNoExistenteException;

	public void updateTitulacion(Titulacion titulacion) throws ObjetoNoExistenteException;

	public void deleteTitulacion(Integer codigo) throws ObjetoNoExistenteException;

}
