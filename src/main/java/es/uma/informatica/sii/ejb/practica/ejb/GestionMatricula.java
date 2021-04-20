package es.uma.informatica.sii.ejb.practica.ejb;



import javax.ejb.Local;

import es.uma.informatica.sii.ejb.practica.ejb.exceptions.ObjetoNoExistenteException;
import es.uma.informatica.sii.ejb.practica.ejb.exceptions.ObjetoYaExistenteException;
import es.uma.informatica.sii.ejb.practica.entidades.Matricula;

@Local
public interface GestionMatricula {
	
	public void createMatricula(Matricula matricula) throws ObjetoYaExistenteException;
	public Matricula readMatricula(Integer idMatricula) throws ObjetoNoExistenteException;
	public void updateMatricula(Matricula matricula) throws ObjetoNoExistenteException;
	public void deleteMatricula(Integer idMatricula) throws ObjetoNoExistenteException;
	
	
	
	
}
