package es.uma.informatica.sii.ejb.practica;

import static org.junit.Assert.fail;

import org.junit.Test;

import es.uma.informatica.sii.ejb.practica.ejb.ExpedienteEJB;
import es.uma.informatica.sii.ejb.practica.ejb.exceptions.ObjetoNoExistenteException;
import es.uma.informatica.sii.ejb.practica.ejb.exceptions.ObjetoYaExistenteException;

public class ExpedientePrueba {

	private ExpedienteEJB gestionExpediente;
	
	//RF 5 - CREATE
	
	@Test
	public void testCrearExpediente(){
		try {
			
		}catch(ObjetoYaExistenteException e) {
			fail("No debería lanzarse excepción.");
		}
	}
	
	@Test
	public void testCrearExpedienteYaExistente(){
		try {
			
		}catch(ObjetoYaExistenteException e) {
			//OK
		}
	}
	
	//RF 5 - READ
	
	@Test
	public void testLeerExpediente(){
		try {
			
		}catch(ObjetoNoExistenteException e) {
			fail("No debería lanzarse excepción");
		}
	}
	
	@Test
	public void testLeerExpedienteNoExistente(){
		try {
			
		}catch(ObjetoNoExistenteException e) {
			//OK
		}
	}
	
	//RF 5 - UPDATE
	
	@Test
	public void testModificarExpediente(){
		try {
			
		}catch(ObjetoNoExistenteException e) {
			fail("No debería lanzarse excepción");
		}
	}
	
	@Test
	public void testModificarExpedienteNoExistente(){
		try {
			
		}catch(ObjetoNoExistenteException e) {
			//OK
		}
	}
	
	//RF 5 - DELETE
	
	@Test
	public void testEliminarExpediente(){
		try {
			
		}catch(ObjetoNoExistenteException e) {
			fail("No debería lanzarse excepción");
		}
	}
	
	@Test
	public void testEliminarExpedienteNoExistente(){
		try {
			
		}catch(ObjetoNoExistenteException e) {
			//OK
		}
	}

}
