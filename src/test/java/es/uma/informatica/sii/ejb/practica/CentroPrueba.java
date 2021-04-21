package es.uma.informatica.sii.ejb.practica;

import static org.junit.Assert.fail;

import org.junit.Test;

import es.uma.informatica.sii.ejb.practica.ejb.CentroEJB;
import es.uma.informatica.sii.ejb.practica.ejb.exceptions.ObjetoNoExistenteException;
import es.uma.informatica.sii.ejb.practica.ejb.exceptions.ObjetoYaExistenteException;

public class CentroPrueba {

	private CentroEJB gestionCentro;
	

	//RF 8 - CREATE
	
	@Test
	public void testCrearCentro(){
		try {
			
		}catch(ObjetoYaExistenteException e) {
			fail("No debería lanzarse excepción.");
		}
	}
	
	@Test
	public void testCrearCentroYaExistente(){
		try {
			
		}catch(ObjetoYaExistenteException e) {
			//OK
		}
	}
	
	//RF 8 - READ
	
	@Test
	public void testLeerCentro(){
		try {
			
		}catch(ObjetoNoExistenteException e) {
			fail("No debería lanzarse excepción");
		}
	}
	
	@Test
	public void testLeerCentroNoExistente(){
		try {
			
		}catch(ObjetoNoExistenteException e) {
			//OK
		}
	}
	
	//RF 8 - UPDATE
	
	@Test
	public void testModificarCentro(){
		try {
			
		}catch(ObjetoNoExistenteException e) {
			fail("No debería lanzarse excepción");
		}
	}
	
	@Test
	public void testModificarCentroNoExistente(){
		try {
			
		}catch(ObjetoNoExistenteException e) {
			//OK
		}
	}
	
	//RF 8 - DELETE
	
	@Test
	public void testEliminarCentro(){
		try {
			
		}catch(ObjetoNoExistenteException e) {
			fail("No debería lanzarse excepción");
		}
	}
	
	@Test
	public void testEliminarCentroNoExistente(){
		try {
			
		}catch(ObjetoNoExistenteException e) {
			//OK
		}
	}

}
