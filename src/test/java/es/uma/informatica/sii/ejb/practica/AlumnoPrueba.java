package es.uma.informatica.sii.ejb.practica;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.naming.NamingException;

import org.junit.Before;
import org.junit.Test;

import es.uma.informatica.sii.anotaciones.Requisitos;
import es.uma.informatica.sii.ejb.practica.ejb.GestionAlumno;
import es.uma.informatica.sii.ejb.practica.ejb.TipoFiltro;
import es.uma.informatica.sii.ejb.practica.ejb.exceptions.ObjetoNoExistenteException;
import es.uma.informatica.sii.ejb.practica.ejb.exceptions.ObjetoYaExistenteException;
import es.uma.informatica.sii.ejb.practica.ejb.exceptions.ProyectoException;
import es.uma.informatica.sii.ejb.practica.entidades.Alumno;
import es.uma.informatica.sii.ejb.practica.entidades.Asignatura;
import es.uma.informatica.sii.ejb.practica.entidades.Expediente;
import es.uma.informatica.sii.ejb.practica.entidades.Encuesta.EncuestaId;
import es.uma.informatica.sii.ejb.practica.entidades.Grupo;
import es.uma.informatica.sii.ejb.practica.entidades.GruposAsignatura;
import es.uma.informatica.sii.ejb.practica.entidades.Titulacion;

public class AlumnoPrueba {

	private GestionAlumno gestionAlumnos;

	private static final Logger LOG = Logger.getLogger(AlumnoPrueba.class.getCanonicalName());
	private static final String ALUMNO_EJB = "java:global/classes/AlumnoEJB";
	private static final String UNIDAD_PERSISTENCIA_PRUEBAS = "SecretariaTest";

	@Before
	public void setUp() throws NamingException {
		gestionAlumnos = (GestionAlumno) SuiteTest.ctx.lookup(ALUMNO_EJB);
		BaseDatos.inicializaBaseDatos(UNIDAD_PERSISTENCIA_PRUEBAS);
	}

	@Requisitos({ "RF2" })
	@Test
	public void testCrearAlumno() {
		try {
			Alumno a = new Alumno();
			a.setId(12);
			a.setDni("678435610");
			a.setNombreCompleto("Alejandro");
			gestionAlumnos.createAlumno(a);
		} catch (ObjetoYaExistenteException e) {
			fail("No debería lanzarse excepción.");
		}
	}

	@Requisitos({ "RF2" })
	@Test
	public void testCrearAlumnoYaExistente() {
		try {
			Alumno a = new Alumno();
			a.setId(1);
			a.setDni("254789E");
			a.setNombreCompleto("Pepito");
			gestionAlumnos.createAlumno(a);
			fail("Debería lanzarse una excepción");
		} catch (ObjetoYaExistenteException e) {
			// OK
		}
	}

	@Requisitos({ "RF2" })
	@Test
	public void testLeerAlumno() {
		try {
			Alumno a = gestionAlumnos.readAlumno(1);
			assertEquals("254789E", a.getDni());
			assertEquals("Pepito", a.getNombre());
			assertTrue(Integer.valueOf(1).compareTo(a.getId()) == 0);

		} catch (ObjetoNoExistenteException e) {
			fail("No debería lanzarse excepción");
		}
	}

	@Requisitos({ "RF2" })
	@Test
	public void testLeerAlumnoNoExistente() {
		try {
			Alumno a = gestionAlumnos.readAlumno(901);
			fail("Debería lanzarse una excepción");
		} catch (ObjetoNoExistenteException e) {
			// OK
		}
	}

	@Requisitos({ "RF2" })
	@Test
	public void testModificarAlumno() {
		try {
			Alumno a = gestionAlumnos.readAlumno(1);
			a.setNombreCompleto("Pablo");
			gestionAlumnos.updateAlumno(a);

		} catch (ObjetoNoExistenteException e) {
			fail("No debería lanzarse excepción");
		}
	}

	@Requisitos({ "RF2" })
	@Test
	public void testModificarAlumnoNoExistente() {
		try {
			Alumno a = gestionAlumnos.readAlumno(12);
			a.setId(10);
			gestionAlumnos.updateAlumno(a);
			fail("Debería lanzarse una excepción");
		} catch (ObjetoNoExistenteException e) {
			// OK
		}
	}

	@Requisitos({ "RF2" })
	@Test
	public void testEliminarAlumno() {
		try {
			gestionAlumnos.deleteAlumno(1);
		} catch (ObjetoNoExistenteException e) {
			fail("No debería lanzarse excepción");
		}
	}

	@Requisitos({ "RF2" })
	@Test
	public void testEliminarAlumnoNoExistente() {
		try {
			gestionAlumnos.deleteAlumno(1929);
			fail("Debería lanzarse una excepción");
		} catch (ObjetoNoExistenteException e) {
			// OK
		}
	}

	@Requisitos({ "RF14" })
	@Test
	public void testRealizarEncuestaPreferencia() {
		try {
			Alumno a = new Alumno();
			a.setId(1);

			GruposAsignatura ga = new GruposAsignatura();
			ga.setCursoAcademico("2021");

			Grupo grupo = new Grupo();
			grupo.setCurso(2020);
			grupo.setId(1231546);
			grupo.setIngles('0');
			grupo.setLetra('A');
			grupo.setPlazas("25");
			grupo.setTurno_mañana_tarde("Mañana");

			ga.setGrupoGruposAsignatura(grupo);

			Asignatura asignatura = new Asignatura();
			asignatura.setCodigo(1456156);
			asignatura.setCreditosPracticas(6);
			asignatura.setCreditosTeoria(6);
			asignatura.setDuracion("1º cuatrimestre");
			asignatura.setNombre("Cálculo");
			asignatura.setOfertada("Si");
			asignatura.setReferencia(564846687);

			Titulacion t = new Titulacion();
			t.setCodigo(1041);
			t.setCreditos(240);
			t.setNombre("Informatica");

			asignatura.setTitulacionAsignatura(t);

			ga.setAsignaturaGruposAsignatura(asignatura);

			Expediente expediente = new Expediente();
			List<Expediente> listaExpediente = new ArrayList<Expediente>();
			listaExpediente.add(expediente);

			expediente.setActivo('1');
			expediente.setNotaMediaProvisional((float) 9.45);
			expediente.setNumeroExpediente(102474112);
			expediente.setAlumnoExpediente(a);
			expediente.setTitulacionExpediente(t);

			List<GruposAsignatura> listaGa = new ArrayList<GruposAsignatura>();
			listaGa.add(ga);

			a.setExpedienteAlumno(listaExpediente);
			gestionAlumnos.rellenarEncuesta(1, listaGa);

		} catch (ObjetoNoExistenteException e) {
			fail(e.getMessage());
		} catch (ObjetoYaExistenteException e) {
			fail("No debería lanzarse excepción 2");
		}
	}

	@Requisitos({ "RF14" })
	@Test
	public void testRealizarEncuestaPreferenciaNoExistente() {
		try {
			GruposAsignatura ga = new GruposAsignatura();
			ga.setCursoAcademico("2145");
			Grupo grupo = new Grupo();
			grupo.setCurso(2020);
			grupo.setId(1231546);
			grupo.setIngles('0');
			grupo.setLetra('A');
			grupo.setPlazas("25");
			grupo.setTurno_mañana_tarde("Mañana");
			ga.setGrupoGruposAsignatura(grupo);
			Asignatura asignatura = new Asignatura();
			asignatura.setCodigo(1456156);
			asignatura.setCreditosPracticas(6);
			asignatura.setCreditosTeoria(6);
			asignatura.setDuracion("1º cuatrimestre");
			asignatura.setNombre("Cálculo");
			asignatura.setOfertada("Si");
			asignatura.setReferencia(564846687);
			Titulacion t = new Titulacion();
			t.setCodigo(1041);
			t.setCreditos(240);
			t.setNombre("Informatica");
			asignatura.setTitulacionAsignatura(t);
			ga.setAsignaturaGruposAsignatura(asignatura);

			List<GruposAsignatura> listaGa = new ArrayList<GruposAsignatura>();
			listaGa.add(ga);

			gestionAlumnos.rellenarEncuesta(1, listaGa);
			fail("No debería lanzarse excepción");

		} catch (ProyectoException e) {
			// OK
		}
	}

	@Requisitos({ "RF10" })
	@Test
	public void testAsignarGrupoExistenteNoManual() {
		try {

			GruposAsignatura ga = new GruposAsignatura();
			ga.setCursoAcademico("2021");
			Grupo grupo = new Grupo();
			grupo.setCurso(2020);
			grupo.setId(1231546);
			grupo.setIngles('0');
			grupo.setLetra('A');
			grupo.setPlazas("25");
			grupo.setTurno_mañana_tarde("Mañana");
			ga.setGrupoGruposAsignatura(grupo);
			Asignatura asignatura = new Asignatura();
			asignatura.setCodigo(1456156);
			asignatura.setCreditosPracticas(6);
			asignatura.setCreditosTeoria(6);
			asignatura.setDuracion("1º cuatrimestre");
			asignatura.setNombre("Cálculo");
			asignatura.setOfertada("Si");
			asignatura.setReferencia(564846687);
			Titulacion t = new Titulacion();
			t.setCodigo(1041);
			t.setCreditos(240);
			t.setNombre("Informatica");
			asignatura.setTitulacionAsignatura(t);
			ga.setAsignaturaGruposAsignatura(asignatura);
			List<GruposAsignatura> listaGa = new ArrayList<GruposAsignatura>();
			listaGa.add(ga);
			gestionAlumnos.asignarGrupo(1, listaGa, new EncuestaId(new Date(18 / 05 / 2021), 102474112), false);
		} catch (ProyectoException e) {
			fail("No debería lanzarse excepción");
		}
	}

	@Requisitos({ "RF10" })
	@Test
	public void testAsignarGruponNoExistenteManual() {
		try {
			GruposAsignatura ga = new GruposAsignatura();
			ga.setCursoAcademico("1");
			Grupo grupo = new Grupo();
			grupo.setCurso(2020);
			grupo.setId(1231546);
			grupo.setIngles('0');
			grupo.setLetra('A');
			grupo.setPlazas("25");
			grupo.setTurno_mañana_tarde("Mañana");
			ga.setGrupoGruposAsignatura(grupo);
			Asignatura asignatura = new Asignatura();
			asignatura.setCodigo(1456156);
			asignatura.setCreditosPracticas(6);
			asignatura.setCreditosTeoria(6);
			asignatura.setDuracion("1º cuatrimestre");
			asignatura.setNombre("Cálculo");
			asignatura.setOfertada("Si");
			asignatura.setReferencia(564846687);
			Titulacion t = new Titulacion();
			t.setCodigo(1041);
			t.setCreditos(240);
			t.setNombre("Informatica");
			asignatura.setTitulacionAsignatura(t);
			ga.setAsignaturaGruposAsignatura(asignatura);

			List<GruposAsignatura> listaGa = new ArrayList<GruposAsignatura>();
			listaGa.add(ga);
			gestionAlumnos.asignarGrupo(1, listaGa, null, true);
			fail("No debería lanzarse excepción");
		} catch (ProyectoException e) {
			// Ok
		}
	}

	@Requisitos({ "RF11" })
	@Test
	public void testGestionarListadoAlumnos() {
		// Como solo hay un alumno en el banco de pruebas esto debe ser el alumno
		try {
			assertTrue(Integer.valueOf(1)
					.compareTo(gestionAlumnos.listarAlumnos(TipoFiltro.TODOS, -1).get(0).getId()) == 0);
		} catch (ProyectoException e) {
			fail("No debería lanzarse excepción");
		}
	}

}
