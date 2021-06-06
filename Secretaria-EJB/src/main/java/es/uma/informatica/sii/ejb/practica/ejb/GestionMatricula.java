package es.uma.informatica.sii.ejb.practica.ejb;

import java.util.List;

import javax.ejb.Local;

import es.uma.informatica.sii.ejb.practica.ejb.exceptions.ObjetoNoExistenteException;
import es.uma.informatica.sii.ejb.practica.ejb.exceptions.ObjetoYaExistenteException;
import es.uma.informatica.sii.ejb.practica.entidades.AsignaturasMatricula;
import es.uma.informatica.sii.ejb.practica.entidades.Matricula;
import es.uma.informatica.sii.ejb.practica.entidades.Matricula.MatriculaId;

@Local
public interface GestionMatricula {

	//CRUD (CREAR, LEER, ACTUALIZAR Y ELIMINAR) MATRICULA
	
	public void createMatricula(Matricula matricula) throws ObjetoYaExistenteException;

	public Matricula readMatricula(MatriculaId idMatricula) throws ObjetoNoExistenteException;

	public void updateMatricula(Matricula matricula) throws ObjetoNoExistenteException;

	public void deleteMatricula(MatriculaId idMatricula) throws ObjetoNoExistenteException;
	
	public List<AsignaturasMatricula> getAsignaturas(Matricula matricula) throws ObjetoNoExistenteException;

}
