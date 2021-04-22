package es.uma.informatica.sii.ejb.practica;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Properties;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.NamingException;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


import java.util.logging.Logger;

import es.uma.informatica.sii.ejb.practica.ejb.GestionTitulacion;
import es.uma.informatica.sii.ejb.practica.ejb.exceptions.ObjetoNoExistenteException;
import es.uma.informatica.sii.ejb.practica.ejb.exceptions.ObjetoYaExistenteException;
import es.uma.informatica.sii.ejb.practica.entidades.Titulacion;

public class TitulacionPrueba {

	private GestionTitulacion gestionTitulacion;
	
	
	private static final Logger LOG = Logger.getLogger(TitulacionPrueba.class.getCanonicalName());
	private static final String TITULACION_EJB = "java:global/classes/TitulacionEJB";
	private static final String UNIDAD_PERSISTENCIA_PRUEBAS = "SecretariaTest";
	
	@Before
	public void setUp() throws NamingException{
		gestionTitulacion = (GestionTitulacion) SuiteTest.ctx.lookup(TITULACION_EJB);
		BaseDatos.inicializaBaseDatos(UNIDAD_PERSISTENCIA_PRUEBAS);
	}
	
	
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
	/*
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
			Titulacion t = gestionTitulacion.readTitulacion(123);
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
			Titulacion t = gestionTitulacion.readTitulacion(123);
			t.setCodigo(415);			
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
	*/
	
}
