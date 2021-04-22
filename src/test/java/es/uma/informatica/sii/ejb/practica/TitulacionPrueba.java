package es.uma.informatica.sii.ejb.practica;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
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
			Titulacion t = new Titulacion();
			t.setCodigo(123);
			t.setCreditos(6);
			t.setNombre("pablo");
			gestionTitulacion.createTitulacion(t);
			fail("Debería lanzarse una excepción");
		}catch(ObjetoYaExistenteException e) {
			//OK
		}
	}
	
	//RF 7 - READ
	
	@Test
	public void testLeerTitulacion(){
		try {
			Titulacion t = gestionTitulacion.readTitulacion(123);
			assertTrue(Integer.valueOf(6).compareTo(t.getCreditos())==0);
			assertEquals("pablo", t.getNombre());
		}catch(ObjetoNoExistenteException e) {
			fail("No debería lanzarse excepción");
		}
	}
	
	@Test
	public void testLeerTitulacionNoExistente(){
		try {
			Titulacion t = gestionTitulacion.readTitulacion(291643562);
			fail("Debería lanzarse una excepción");
		}catch(ObjetoNoExistenteException e) {
			//OK
		}
	}
	
	//RF 7 - UPDATE
	
	@Test
	public void testModificarTitulacion(){
		try {
			Titulacion t = new Titulacion();
			t.setCodigo(123);
			t.setCreditos(9);
			t.setNombre("ale");
			gestionTitulacion.updateTitulacion(t);
		}catch(ObjetoNoExistenteException e) {
			fail("No debería lanzarse excepción");
		}
	}
	
	@Test
	public void testModificarTitulacionNoExistente(){
		try {
			Titulacion t = new Titulacion();
			t.setCodigo(291643562);
			gestionTitulacion.updateTitulacion(t);
			fail("Debería lanzarse una excepción");
		}catch(ObjetoNoExistenteException e) {
			//OK
		}
	}
	
	//RF 7 - DELETE
	
	@Test
	public void testEliminarTitulacion(){
		try {
			gestionTitulacion.deleteTitulacion(123);
		}catch(ObjetoNoExistenteException e) {
			fail("No debería lanzarse excepción");
		}
	}
	
	@Test
	public void testEliminarTitulacionNoExistente(){
		try {
			gestionTitulacion.deleteTitulacion(291643562);
			fail("Debería lanzarse una excepción");
		}catch(ObjetoNoExistenteException e) {
			//OK
		}
	}
	
	
}
