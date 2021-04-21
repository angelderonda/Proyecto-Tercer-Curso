package es.uma.informatica.sii.ejb.practica;

import static org.junit.Assert.fail;

import org.junit.Test;

import es.uma.informatica.sii.ejb.practica.ejb.TitulacionEJB;
import es.uma.informatica.sii.ejb.practica.ejb.exceptions.ObjetoNoExistenteException;
import es.uma.informatica.sii.ejb.practica.ejb.exceptions.ObjetoYaExistenteException;
import es.uma.informatica.sii.ejb.practica.entidades.Titulacion;

public class TitulacionPrueba {

	private TitulacionEJB gestionTitulacion;
	
	
	//RF 7 - CREATE
	
	@Test
	public void testCrearTitulacion(){
		try {
		Titulacion t = new Titulacion();
		t.setCodigo(123);
		t.setCreditos(6);
		t.setNombre("pablo");
		gestionTitulacion.createTitulacion(t);
		}catch(ObjetoYaExistenteException e) {
			fail("No debería lanzarse excepción.");
		}
	}
	
	@Test
	public void testCrearTitulacionYaExistente(){
		try {
			
		}catch(ObjetoYaExistenteException e) {
			//OK
		}
	}
	
	//RF 7 - READ
	
	@Test
	public void testLeerTitulacion(){
		try {
			
		}catch(ObjetoNoExistenteException e) {
			fail("No debería lanzarse excepción");
		}
	}
	
	@Test
	public void testLeerTitulacionNoExistente(){
		try {
			
		}catch(ObjetoNoExistenteException e) {
			//OK
		}
	}
	
	//RF 7 - UPDATE
	
	@Test
	public void testModificarTitulacion(){
		try {
			
		}catch(ObjetoNoExistenteException e) {
			fail("No debería lanzarse excepción");
		}
	}
	
	@Test
	public void testModificarTitulacionNoExistente(){
		try {
			
		}catch(ObjetoNoExistenteException e) {
			//OK
		}
	}
	
	//RF 7 - DELETE
	
	@Test
	public void testEliminarTitulacion(){
		try {
			
		}catch(ObjetoNoExistenteException e) {
			fail("No debería lanzarse excepción");
		}
	}
	
	@Test
	public void testEliminarTitulacionNoExistente(){
		try {
			
		}catch(ObjetoNoExistenteException e) {
			//OK
		}
	}
	
	
}
