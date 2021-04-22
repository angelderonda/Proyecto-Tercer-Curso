package es.uma.informatica.sii.ejb.practica;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

import es.uma.informatica.sii.ejb.practica.ejb.ExpedienteEJB;
import es.uma.informatica.sii.ejb.practica.ejb.exceptions.ObjetoNoExistenteException;
import es.uma.informatica.sii.ejb.practica.ejb.exceptions.ObjetoYaExistenteException;
import es.uma.informatica.sii.ejb.practica.entidades.Expediente;
import es.uma.informatica.sii.ejb.practica.entidades.Titulacion;

public class ExpedientePrueba {

	private ExpedienteEJB gestionExpediente;
	
	//RF 5 - CREATE
	
	@Test
	public void testCrearExpediente(){
		try {
			Expediente e = new Expediente();
			e.setActivo('1');
			e.setNotaMediaProvisional(8.9f);
			e.setNumeroExpediente(12345);
			gestionExpediente.createExpediente(e);
		}catch(ObjetoYaExistenteException e) {
			fail("No debería lanzarse excepción.");
		}
	}
	
	@Test
	public void testCrearExpedienteYaExistente(){
		try {
			Expediente e = new Expediente();
			e.setActivo('1');
			e.setNotaMediaProvisional(8.9f);
			e.setNumeroExpediente(12345);
			gestionExpediente.createExpediente(e);
			fail("Debería lanzarse una excepción");
		}catch(ObjetoYaExistenteException e) {
			//OK
		}
	}
	
	//RF 5 - READ
	
	@Test
	public void testLeerExpediente(){
		try {
			Expediente e = gestionExpediente.readExpediente(102474112);
			assertTrue(e.getNotaMediaProvisional().compareTo(Float.valueOf(9.45f)) == 0);
		}catch(ObjetoNoExistenteException e) {
			fail("No debería lanzarse excepción");
		}
	}
	
	@Test
	public void testLeerExpedienteNoExistente(){
		try {
			Expediente e = gestionExpediente.readExpediente(1);
			fail("Debería lanzarse una excepción");
		}catch(ObjetoNoExistenteException e) {
			//OK
		}
	}
	
	//RF 5 - UPDATE
	
	@Test
	public void testModificarExpediente(){
		try {
			Expediente e = gestionExpediente.readExpediente(102474112);
			e.setNotaMediaProvisional(7.9f);
			gestionExpediente.updateExpediente(e);
		}catch(ObjetoNoExistenteException e) {
			fail("No debería lanzarse excepción");
		}
	}
	
	@Test
	public void testModificarExpedienteNoExistente(){
		try {
			Expediente e = gestionExpediente.readExpediente(102474112);
			e.setNumeroExpediente(1);
			gestionExpediente.updateExpediente(e);
			fail("Debería lanzarse una excepción");
		}catch(ObjetoNoExistenteException e) {
			//OK
		}
	}
	
	//RF 5 - DELETE
	
	@Test
	public void testEliminarExpediente(){
		try {
			gestionExpediente.deleteExpediente(102474112);
		}catch(ObjetoNoExistenteException e) {
			fail("No debería lanzarse excepción");
		}
	}
	
	@Test
	public void testEliminarExpedienteNoExistente(){
		try {
			gestionExpediente.deleteExpediente(1);
			fail("Debería lanzarse una excepción");
		}catch(ObjetoNoExistenteException e) {
			//OK
		}
	}

}
