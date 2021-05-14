package es.uma.informatica.sii.ejb.practica;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import javax.naming.NamingException;

import org.junit.Before;
import org.junit.Test;

import java.util.logging.Logger;

import es.uma.informatica.sii.anotaciones.Requisitos;
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
	public void setUp() throws NamingException {
		gestionTitulacion = (GestionTitulacion) SuiteTest.ctx.lookup(TITULACION_EJB);
		BaseDatos.inicializaBaseDatos(UNIDAD_PERSISTENCIA_PRUEBAS);
	}

	@Requisitos({ "RF7" })
	@Test
	public void testCrearTitulacion() {
		try {
			Titulacion t = new Titulacion();
			t.setCodigo(123);
			t.setCreditos(6);
			t.setNombre("pablo");
			gestionTitulacion.createTitulacion(t);
		} catch (ObjetoYaExistenteException e) {
			fail("No debería lanzarse excepción.");
		}
	}

	@Requisitos({ "RF7" })
	@Test
	public void testCrearTitulacionYaExistente() {
		try {
			Titulacion t = new Titulacion();
			t.setCodigo(1041);
			gestionTitulacion.createTitulacion(t);
			fail("Debería lanzarse una excepción");
		} catch (ObjetoYaExistenteException e) {
			// OK
		}
	}

	@Requisitos({ "RF7" })
	@Test
	public void testLeerTitulacion() {
		try {
			Titulacion t = gestionTitulacion.readTitulacion(1041);
			assertTrue(Integer.valueOf(240).compareTo(t.getCreditos()) == 0);
			assertEquals("Informatica", t.getNombre());
		} catch (ObjetoNoExistenteException e) {
			fail("No debería lanzarse excepción");
		}
	}

	@Requisitos({ "RF7" })
	@Test
	public void testLeerTitulacionNoExistente() {
		try {
			Titulacion t = gestionTitulacion.readTitulacion(291643562);
			fail("Debería lanzarse una excepción");
		} catch (ObjetoNoExistenteException e) {
			// OK
		}
	}

	@Requisitos({ "RF7" })
	@Test
	public void testModificarTitulacion() {
		try {
			Titulacion t = gestionTitulacion.readTitulacion(1041);
			t.setCreditos(9);
			t.setNombre("Tecno");
			gestionTitulacion.updateTitulacion(t);
		} catch (ObjetoNoExistenteException e) {
			fail("No debería lanzarse excepción");
		}
	}

	@Requisitos({ "RF7" })
	@Test
	public void testModificarTitulacionNoExistente() {
		try {
			Titulacion t = gestionTitulacion.readTitulacion(1041);
			t.setCodigo(415);
			gestionTitulacion.updateTitulacion(t);
			fail("Debería lanzarse una excepción");
		} catch (ObjetoNoExistenteException e) {
			// OK
		}
	}

	@Requisitos({ "RF7" })
	@Test
	public void testEliminarTitulacion() {
		try {
			gestionTitulacion.deleteTitulacion(1041);
		} catch (ObjetoNoExistenteException e) {
			fail("No debería lanzarse excepción");
		}
	}

	@Requisitos({ "RF7" })
	@Test
	public void testEliminarTitulacionNoExistente() {
		try {
			gestionTitulacion.deleteTitulacion(291643562);
			fail("Debería lanzarse una excepción");
		} catch (ObjetoNoExistenteException e) {
			// OK
		}
	}

}
