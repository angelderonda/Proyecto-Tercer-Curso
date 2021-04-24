package es.uma.informatica.sii.ejb.practica.ejb;

import javax.ejb.Local;

import es.uma.informatica.sii.ejb.practica.ejb.exceptions.ObjetoNoExistenteException;
import es.uma.informatica.sii.ejb.practica.ejb.exceptions.ObjetoYaExistenteException;
import es.uma.informatica.sii.ejb.practica.entidades.Centro;

@Local
public interface GestionCentro {
	
	//CRUD (CREAR, LEER, ACTUALIZAR Y ELIMINAR) CENTRO

	public void createCentro(Centro centro) throws ObjetoYaExistenteException;

	public Centro readCentro(Integer idCentro) throws ObjetoNoExistenteException;

	public void updateCentro(Centro centro) throws ObjetoNoExistenteException;

	public void deleteCentro(Integer idCentro) throws ObjetoNoExistenteException;

}
