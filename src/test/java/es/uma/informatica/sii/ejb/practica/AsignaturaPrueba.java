package es.uma.informatica.sii.ejb.practica;

import static org.junit.Assert.fail;

import org.junit.Test;

import es.uma.informatica.sii.ejb.practica.ejb.AsignaturaEJB;
import es.uma.informatica.sii.ejb.practica.ejb.exceptions.ObjetoNoExistenteException;
import es.uma.informatica.sii.ejb.practica.ejb.exceptions.ObjetoYaExistenteException;

public class AsignaturaPrueba {

	private AsignaturaEJB gestionAsignatura;
	

	//RF 1 - CREATE
	
	@Test
	public void testCrearAsignatura(){
		try {
			
		}catch(ObjetoYaExistenteException e) {
			fail("No debería lanzarse excepción.");
		}
	}
	
	@Test
	public void testCrearAsignaturaYaExistente(){
		try {
			
		}catch(ObjetoYaExistenteException e) {
			//OK
		}
	}
	
	//RF 1 - READ
	
	@Test
	public void testLeerAsignatura(){
		try {
			
		}catch(ObjetoNoExistenteException e) {
			fail("No debería lanzarse excepción");
		}
	}
	
	@Test
	public void testLeerAsignaturaNoExistente(){
		try {
			
		}catch(ObjetoNoExistenteException e) {
			//OK
		}
	}
	
	//RF 1 - UPDATE
	
	@Test
	public void testModificarAsignatura(){
		try {
			
		}catch(ObjetoNoExistenteException e) {
			fail("No debería lanzarse excepción");
		}
	}
	
	@Test
	public void testModificarAsignaturaNoExistente(){
		try {
			
		}catch(ObjetoNoExistenteException e) {
			//OK
		}
	}
	
	//RF 1 - DELETE
	
	@Test
	public void testEliminarAsignatura(){
		try {
			
		}catch(ObjetoNoExistenteException e) {
			fail("No debería lanzarse excepción");
		}
	}
	
	@Test
	public void testEliminarAsignaturaNoExistente(){
		try {
			
		}catch(ObjetoNoExistenteException e) {
			//OK
		}
	}
}
