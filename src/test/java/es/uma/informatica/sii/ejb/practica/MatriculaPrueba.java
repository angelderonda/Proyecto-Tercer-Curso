package es.uma.informatica.sii.ejb.practica;

import static org.junit.Assert.fail;

import java.util.Date;
import java.util.logging.Logger;

import javax.naming.NamingException;

import org.junit.Before;
import org.junit.Test;

import es.uma.informatica.sii.ejb.practica.entidades.*;
import es.uma.informatica.sii.ejb.practica.entidades.Matricula.MatriculaId;
import es.uma.informatica.sii.anotaciones.Requisitos;
import es.uma.informatica.sii.ejb.practica.ejb.GestionMatricula;
import es.uma.informatica.sii.ejb.practica.ejb.exceptions.ObjetoNoExistenteException;
import es.uma.informatica.sii.ejb.practica.ejb.exceptions.ObjetoYaExistenteException;

public class MatriculaPrueba {

	private GestionMatricula gestionMatricula;

	private static final Logger LOG = Logger.getLogger(MatriculaPrueba.class.getCanonicalName());
	private static final String MATRICULA_EJB = "java:global/classes/MatriculaEJB";
	private static final String UNIDAD_PERSISTENCIA_PRUEBAS = "SecretariaTest";

	@Before
	public void setUp() throws NamingException {
		gestionMatricula = (GestionMatricula) SuiteTest.ctx.lookup(MATRICULA_EJB);
		BaseDatos.inicializaBaseDatos(UNIDAD_PERSISTENCIA_PRUEBAS);
	}

	@Requisitos({ "RF6" })
	@Test
	public void testCrearMatricula() {
		try {
			Matricula m = new Matricula();
			m.setCursoAcademico("2015/2016");
			m.setEstado("Activo");
			m.setFechaMatricula(new Date(22 / 04 / 2021));

			// Creamos el mismo expediente que tenemos en BaseDatos.java
			Expediente expediente = new Expediente();
			expediente.setNumeroExpediente(102474112);
			m.setExpedienteMatricula(expediente);

			gestionMatricula.createMatricula(m);
		} catch (ObjetoYaExistenteException e) {
			fail("No debería lanzarse excepción.");
		}

	}

	@Requisitos({ "RF6" })
	@Test
	public void testCrearMatriculaYaExistente() {
		try {
			Matricula m = new Matricula();
			m.setCursoAcademico("2020/2021");
			m.setEstado("Activo");
			m.setFechaMatricula(new Date(14 / 11 / 2021));
			// Creamos el mismo expediente que tenemos en BaseDatos.java
			Expediente expediente = new Expediente();
			expediente.setNumeroExpediente(102474112);
			m.setExpedienteMatricula(expediente);
			gestionMatricula.createMatricula(m);
			fail("Debería lanzar excepción");
		} catch (ObjetoYaExistenteException e) {
			// OK
		}
	}

	@Requisitos({ "RF6" })
	@Test
	public void testLeerMatricula() {
		try {
			MatriculaId mi = new MatriculaId("2020/2021", 102474112);
			Matricula m = gestionMatricula.readMatricula(mi);
		} catch (ObjetoNoExistenteException e) {
			fail("No debería lanzarse excepción");
		}
	}

	@Requisitos({ "RF6" })
	@Test
	public void testLeerMatriculaNoExistente() {
		try {
			MatriculaId mi = new MatriculaId("1998/1999", 102474112);
			Matricula m = gestionMatricula.readMatricula(mi);
			fail("Debería lanzarse excepción");
		} catch (ObjetoNoExistenteException e) {
			// OK
		}
	}

	@Requisitos({ "RF6" })
	@Test
	public void testModificarMatricula() {
		try {
			MatriculaId mi = new MatriculaId("2020/2021", 102474112);
			Matricula m = gestionMatricula.readMatricula(mi);
			m.setEstado("estadoModificado");
			gestionMatricula.updateMatricula(m);
		} catch (ObjetoNoExistenteException e) {
			fail("No debería lanzarse excepción");
		}
	}

	@Requisitos({ "RF6" })
	@Test
	public void testModificarMatriculaNoExistente() {
		try {
			MatriculaId mi = new MatriculaId("2020/2021", 102474112);
			Matricula m = gestionMatricula.readMatricula(mi);
			m.setCursoAcademico("2014/2015");
			gestionMatricula.updateMatricula(m);
			fail("Debería lanzarse excepción");
		} catch (ObjetoNoExistenteException e) {
			// OK
		}
	}

	@Requisitos({ "RF6" })
	@Test
	public void testEliminarMatricula() {
		try {
			MatriculaId mi = new MatriculaId("2020/2021", 102474112);
			gestionMatricula.deleteMatricula(mi);
		} catch (ObjetoNoExistenteException e) {
			fail("No debería lanzarse excepción");
		}
	}

	@Requisitos({ "RF6" })
	@Test
	public void testEliminarMatriculaNoExistente() {
		try {
			MatriculaId mi = new MatriculaId("1981/1982", 102474112);
			gestionMatricula.deleteMatricula(mi);
			fail("Debería lanzarse excepción");
		} catch (ObjetoNoExistenteException e) {
			// OK
		}
	}

}
