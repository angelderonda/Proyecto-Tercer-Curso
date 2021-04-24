package es.uma.informatica.sii.ejb.practica.ejb;

import javax.ejb.Local;

import es.uma.informatica.sii.ejb.practica.ejb.exceptions.ObjetoNoExistenteException;
import es.uma.informatica.sii.ejb.practica.ejb.exceptions.ObjetoYaExistenteException;
import es.uma.informatica.sii.ejb.practica.entidades.Asignatura;
import es.uma.informatica.sii.ejb.practica.entidades.Asignatura.AsignaturaId;

@Local
public interface GestionAsignatura {
	
	//CRUD (CREAR, LEER, ACTUALIZAR Y ELIMINAR) ASIGNATURA

	public void createAsignatura(Asignatura asignatura) throws ObjetoYaExistenteException;

	public Asignatura readAsignatura(AsignaturaId idAsignatura) throws ObjetoNoExistenteException;

	public void updateAsignatura(Asignatura asignatura) throws ObjetoNoExistenteException;

	public void deleteAsignatura(AsignaturaId idAsignatura) throws ObjetoNoExistenteException;

}
