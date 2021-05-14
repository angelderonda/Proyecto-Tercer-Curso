package es.uma.informatica.sii.ejb.practica;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.logging.Logger;

import javax.naming.NamingException;

import org.junit.Before;
import org.junit.Test;

import es.uma.informatica.sii.anotaciones.Requisitos;
import es.uma.informatica.sii.ejb.practica.ejb.CentroEJB;
import es.uma.informatica.sii.ejb.practica.ejb.GestionAsignatura;
import es.uma.informatica.sii.ejb.practica.ejb.GestionCentro;
import es.uma.informatica.sii.ejb.practica.ejb.GestionTitulacion;
import es.uma.informatica.sii.ejb.practica.ejb.exceptions.ObjetoNoExistenteException;
import es.uma.informatica.sii.ejb.practica.ejb.exceptions.ObjetoYaExistenteException;
import es.uma.informatica.sii.ejb.practica.entidades.Centro;
import es.uma.informatica.sii.ejb.practica.entidades.Titulacion;

public class CentroPrueba {
	private GestionCentro gestionCentro;

	// private static final Logger LOG =
	// Logger.getLogger(CentroPrueba.class.getCanonicalName());
	private static final String CENTRO_EJB = "java:global/classes/CentroEJB";
	private static final String UNIDAD_PERSISTENCIA_PRUEBAS = "SecretariaTest";

	@Before
	public void setUp() throws NamingException {
		gestionCentro = (GestionCentro) SuiteTest.ctx.lookup(CENTRO_EJB);
		BaseDatos.inicializaBaseDatos(UNIDAD_PERSISTENCIA_PRUEBAS);
	}

	@Requisitos({ "RF8" })
	@Test
	public void testCrearCentro() {
		try {
			Centro centro = new Centro();
			centro.setId(4969);
			centro.setDireccion("Calle Miramar");
			centro.setNombre("E.T.S.I");
			gestionCentro.createCentro(centro);
		} catch (ObjetoYaExistenteException e) {
			fail("No debería lanzarse excepción.");
		}
	}

	@Requisitos({ "RF8" })
	@Test
	public void testCrearCentroYaExistente() {
		try {
			Centro centro = new Centro();
			centro.setId(1041);
			gestionCentro.createCentro(centro);
			fail("No debería lanzarse excepción");
		} catch (ObjetoYaExistenteException e) {
			// OK
		}
	}

	@Requisitos({ "RF8" })
	@Test
	public void testLeerCentro() {
		try {
			Centro centro = gestionCentro.readCentro(1041);
			assertTrue(Integer.valueOf(1041).compareTo(centro.getId()) == 0);
			assertEquals("Calle Malaga", centro.getDireccion());
			assertEquals("Centro Informatica", centro.getNombre());
			assertEquals("690329116", centro.getTelefonoConserjeria());

		} catch (ObjetoNoExistenteException e) {
			fail("No debería lanzarse excepción");
		}
	}

	@Requisitos({ "RF8" })
	@Test
	public void testLeerCentroNoExistente() {
		try {
			Centro centro = gestionCentro.readCentro(5789);
			fail("Debería lanzarse una excepción");
		} catch (ObjetoNoExistenteException e) {
			// OK
		}
	}

	@Requisitos({ "RF8" })
	@Test
	public void testModificarCentro() {
		try {
			Centro centro = gestionCentro.readCentro(1041);
			centro.setNombre("Salud");
			centro.setTelefono_conserjeria("7458710");
			gestionCentro.updateCentro(centro);
		} catch (ObjetoNoExistenteException e) {
			fail("No debería lanzarse excepción");
		}
	}

	@Requisitos({ "RF8" })
	@Test
	public void testModificarCentroNoExistente() {
		try {
			Centro centro = gestionCentro.readCentro(1041);
			centro.setId(4178);
			gestionCentro.updateCentro(centro);
			fail("No debería lanzarse excepción");
		} catch (ObjetoNoExistenteException e) {
			// OK
		}
	}

	@Requisitos({ "RF8" })
	@Test
	public void testEliminarCentro() {
		try {
			gestionCentro.deleteCentro(1041);
		} catch (ObjetoNoExistenteException e) {
			fail("No debería lanzarse excepción");
		}
	}

	@Requisitos({ "RF8" })
	@Test
	public void testEliminarCentroNoExistente() {
		try {
			gestionCentro.deleteCentro(6574);
			fail("No debería lanzarse excepción");
		} catch (ObjetoNoExistenteException e) {
			// OK
		}
	}

}
