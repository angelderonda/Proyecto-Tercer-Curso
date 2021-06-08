package es.uma.informatica.sii.ejb.practica;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.logging.Logger;

import javax.naming.NamingException;

import org.junit.Before;
import org.junit.Test;

import es.uma.informatica.sii.anotaciones.Requisitos;
import es.uma.informatica.sii.ejb.practica.ejb.GestionExpediente;
import es.uma.informatica.sii.ejb.practica.ejb.exceptions.ObjetoNoExistenteException;
import es.uma.informatica.sii.ejb.practica.ejb.exceptions.ObjetoYaExistenteException;
import es.uma.informatica.sii.ejb.practica.entidades.Expediente;

public class ExpedientePrueba {

	private GestionExpediente gestionExpediente;

	private static final Logger LOG = Logger.getLogger(ExpedientePrueba.class.getCanonicalName());
	private static final String EXPEDIENTE_EJB = "java:global/classes/ExpedienteEJB";
	private static final String UNIDAD_PERSISTENCIA_PRUEBAS = "SecretariaTest";

	@Before
	public void setUp() throws NamingException {
		gestionExpediente = (GestionExpediente) SuiteTest.ctx.lookup(EXPEDIENTE_EJB);
		BaseDatos.inicializaBaseDatos(UNIDAD_PERSISTENCIA_PRUEBAS);
	}

	@Requisitos({ "RF5" })
	@Test
	public void testCrearExpediente() {
		try {
			Expediente e = new Expediente();
			e.setActivo('1');
			e.setNotaMediaProvisional(8.9f);
			e.setNumeroExpediente(12345);
			gestionExpediente.createExpediente(e);
		} catch (ObjetoYaExistenteException e) {
			fail("No debería lanzarse excepción.");
		}
	}

	@Requisitos({ "RF5" })
	@Test
	public void testCrearExpedienteYaExistente() {
		try {
			Expediente e = new Expediente();
			e.setActivo('1');
			e.setNotaMediaProvisional(8.9f);
			e.setNumeroExpediente(102474112);
			gestionExpediente.createExpediente(e);
			fail("Debería lanzarse una excepción");
		} catch (ObjetoYaExistenteException e) {
			// OK
		}
	}

	@Requisitos({ "RF5" })
	@Test
	public void testLeerExpediente() {
		try {
			Expediente e = gestionExpediente.readExpediente(102474112);
			assertTrue(e.getNotaMediaProvisional().compareTo(Float.valueOf(9.45f)) == 0);
		} catch (ObjetoNoExistenteException e) {
			fail("No debería lanzarse excepción");
		}
	}

	@Requisitos({ "RF5" })
	@Test
	public void testLeerExpedienteNoExistente() {
		try {
			Expediente e = gestionExpediente.readExpediente(1);
			fail("Debería lanzarse una excepción");
		} catch (ObjetoNoExistenteException e) {
			// OK
		}
	}

	@Requisitos({ "RF5" })
	@Test
	public void testModificarExpediente() {
		try {
			Expediente e = gestionExpediente.readExpediente(102474112);
			e.setNotaMediaProvisional(7.9f);
			gestionExpediente.updateExpediente(e);
		} catch (ObjetoNoExistenteException e) {
			fail("No debería lanzarse excepción");
		}
	}

	@Requisitos({ "RF5" })
	@Test
	public void testModificarExpedienteNoExistente() {
		try {
			Expediente e = gestionExpediente.readExpediente(102474112);
			e.setNumeroExpediente(1);
			gestionExpediente.updateExpediente(e);
			fail("Debería lanzarse una excepción");
		} catch (ObjetoNoExistenteException e) {
			// OK
		}
	}

	@Requisitos({ "RF5" })
	@Test
	public void testEliminarExpediente() {
		/*try {
			gestionExpediente.deleteExpediente(102474112);
		} catch (ObjetoNoExistenteException e) {
			fail("No debería lanzarse excepción");
		}*/
		//cuidado pruebaIT
	}

	@Requisitos({ "RF5" })
	@Test
	public void testEliminarExpedienteNoExistente() {
		try {
			gestionExpediente.deleteExpediente(1);
			fail("Debería lanzarse una excepción");
		} catch (ObjetoNoExistenteException e) {
			// OK
		}
	}

}
