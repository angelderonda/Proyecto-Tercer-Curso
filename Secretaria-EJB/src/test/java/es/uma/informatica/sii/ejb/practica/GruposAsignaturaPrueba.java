package es.uma.informatica.sii.ejb.practica;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import es.uma.informatica.sii.anotaciones.Requisitos;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.naming.NamingException;

import org.junit.Before;
import org.junit.Test;

import es.uma.informatica.sii.ejb.practica.ejb.GestionGruposAsignatura;
import es.uma.informatica.sii.ejb.practica.ejb.exceptions.ObjetoNoExistenteException;
import es.uma.informatica.sii.ejb.practica.ejb.exceptions.ObjetoYaExistenteException;
import es.uma.informatica.sii.ejb.practica.entidades.Alumno;
import es.uma.informatica.sii.ejb.practica.entidades.Asignatura;
import es.uma.informatica.sii.ejb.practica.entidades.Encuesta;
import es.uma.informatica.sii.ejb.practica.entidades.Expediente;
import es.uma.informatica.sii.ejb.practica.entidades.Asignatura.AsignaturaId;
import es.uma.informatica.sii.ejb.practica.entidades.Grupo;
import es.uma.informatica.sii.ejb.practica.entidades.GruposAsignatura;
import es.uma.informatica.sii.ejb.practica.entidades.GruposAsignatura.GruposAsignaturaId;
import es.uma.informatica.sii.ejb.practica.entidades.Titulacion;

public class GruposAsignaturaPrueba {

	private GestionGruposAsignatura gestionGruposAsignatura;

	private static final Logger LOG = Logger.getLogger(GruposAsignaturaPrueba.class.getCanonicalName());
	private static final String GRUPOSASIGNATURA_EJB = "java:global/classes/GruposAsignaturaEJB";
	private static final String UNIDAD_PERSISTENCIA_PRUEBAS = "SecretariaTest";

	@Before
	public void setUp() throws NamingException {
		gestionGruposAsignatura = (GestionGruposAsignatura) SuiteTest.ctx.lookup(GRUPOSASIGNATURA_EJB);
		BaseDatos.inicializaBaseDatos(UNIDAD_PERSISTENCIA_PRUEBAS);
	}

	@Requisitos({ "RF4" })
	@Test
	public void testCrearGruposAsignatura() {
		try {
			Titulacion t = new Titulacion();
			t.setCodigo(1041);

			// Creamos el mismo expediente que tenemos en BaseDatos.java

			Alumno a = new Alumno();
			a.setId(1);
			a.setDni("254789E");
			a.setNombreCompleto("Pepito");

			Expediente expediente = new Expediente();
			expediente.setNumeroExpediente(102474112);
			expediente.setTitulacionExpediente(t);
			expediente.setAlumnoExpediente(a);

			// Encuesta
			Encuesta encuesta = new Encuesta();
			encuesta.setFechaEnvio(new Date(18 / 05 / 2021));
			encuesta.setExpedienteEncuesta(expediente);
			List<Encuesta> listaEncuesta = new ArrayList<Encuesta>();
			listaEncuesta.add(encuesta);

			GruposAsignatura ga = new GruposAsignatura();
			ga.setCursoAcademico("2020/2021");
			ga.setOferta('1');
			ga.setEncuestaGruposAsignatura(listaEncuesta);
			gestionGruposAsignatura.createGruposAsignatura(ga,1041,1231546,564846687);
		} catch (ObjetoYaExistenteException e) {
			fail("No debería lanzarse excepción.");
		}
	}

	@Requisitos({ "RF4" })
	@Test
	public void testCrearGruposAsignaturaYaExistente() {
		try {
			GruposAsignatura ga = new GruposAsignatura();
			ga.setCursoAcademico("2021");
			Titulacion t = new Titulacion();
			t.setCodigo(1041);
			t.setCreditos(240);
			t.setNombre("Informatica");
			gestionGruposAsignatura.createGruposAsignatura(ga,1041,1231546,564846687);
			fail("Debería lanzarse excepción.");
		} catch (ObjetoYaExistenteException e) {
			// OK
		}
	}

	@Requisitos({ "RF4" })
	@Test
	public void testLeerGruposAsignatura() {
		try {
			GruposAsignaturaId gai = new GruposAsignaturaId("2021", 1231546, new AsignaturaId(564846687, 1041));
			GruposAsignatura ga = gestionGruposAsignatura.readGrupoAsignatura(gai);
			assertEquals("2021", ga.getCursoAcademico());
			assertEquals('1', ga.getOferta());
		} catch (ObjetoNoExistenteException e) {
			fail("No debería lanzarse excepción");
		}
	}

	@Requisitos({ "RF4" })
	@Test
	public void testLeerGruposAsignaturaNoExistente() {
		try {
			GruposAsignaturaId gai = new GruposAsignaturaId("2000/2001", 1231543, new AsignaturaId(564846689, 1042));
			GruposAsignatura ga = gestionGruposAsignatura.readGrupoAsignatura(gai);
			fail("Debería lanzarse excepción.");
		} catch (ObjetoNoExistenteException e) {
			// OK
		}
	}

	@Requisitos({ "RF4" })
	@Test
	public void testModificarGruposAsignatura() {
		try {
			GruposAsignaturaId gai = new GruposAsignaturaId("2021", 1231546, new AsignaturaId(564846687, 1041));
			GruposAsignatura ga = gestionGruposAsignatura.readGrupoAsignatura(gai);
			ga.setOferta('0');
			gestionGruposAsignatura.updateGrupoAsignatura(ga);
		} catch (ObjetoNoExistenteException e) {
			fail("No debería lanzarse excepción");
		}
	}

	@Requisitos({ "RF4" })
	@Test
	public void testModificarGruposAsignaturaNoExistente() {
		try {
			GruposAsignaturaId gai = new GruposAsignaturaId("2021", 1231546, new AsignaturaId(564846687, 1041));
			GruposAsignatura ga = gestionGruposAsignatura.readGrupoAsignatura(gai);
			ga.setCursoAcademico("2000/2001");
			gestionGruposAsignatura.updateGrupoAsignatura(ga);
			fail("Debería lanzarse excepción.");
		} catch (ObjetoNoExistenteException e) {
			// OK
		}
	}

	@Requisitos({ "RF4" })
	@Test
	public void testEliminarGruposAsignatura() {
		try {
			gestionGruposAsignatura
					.deleteGrupoAsignatura(new GruposAsignaturaId("2021", 1231546, new AsignaturaId(564846687, 1041)));

		} catch (ObjetoNoExistenteException e) {
			fail("No debería lanzarse excepción");
		}
	}

	@Requisitos({ "RF4" })
	@Test
	public void testEliminarGrupoAsignaturaNoExistente() {
		try {
			gestionGruposAsignatura.deleteGrupoAsignatura(
					new GruposAsignaturaId("2000/2001", 12345, new AsignaturaId(564846687, 1041)));
			fail("No deberia lanzarse excepcion");
		} catch (ObjetoNoExistenteException e) {
			// OK
		}
	}
}
