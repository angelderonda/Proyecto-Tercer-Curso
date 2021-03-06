package es.uma.informatica.sii.ejb.practica;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.naming.NamingException;

import org.junit.Before;
import org.junit.Test;

import es.uma.informatica.sii.anotaciones.Requisitos;
import es.uma.informatica.sii.ejb.practica.ejb.GestionGrupo;
import es.uma.informatica.sii.ejb.practica.ejb.exceptions.ObjetoNoExistenteException;
import es.uma.informatica.sii.ejb.practica.ejb.exceptions.ObjetoYaExistenteException;
import es.uma.informatica.sii.ejb.practica.entidades.Asignatura;
import es.uma.informatica.sii.ejb.practica.entidades.Grupo;
import es.uma.informatica.sii.ejb.practica.entidades.GruposAsignatura;
import es.uma.informatica.sii.ejb.practica.entidades.Titulacion;

public class GrupoPrueba {

	private GestionGrupo gestionGrupo;

	private static final Logger LOG = Logger.getLogger(GrupoPrueba.class.getCanonicalName());
	private static final String GRUPO_EJB = "java:global/classes/GrupoEJB";
	private static final String UNIDAD_PERSISTENCIA_PRUEBAS = "SecretariaTest";

	@Before
	public void setUp() throws NamingException {
		gestionGrupo = (GestionGrupo) SuiteTest.ctx.lookup(GRUPO_EJB);
		BaseDatos.inicializaBaseDatos(UNIDAD_PERSISTENCIA_PRUEBAS);
	}

	@Requisitos({ "RF3" })
	@Test
	public void testCrearGrupo() {
		try {
			Grupo grupo = new Grupo();
			grupo.setCurso(2020);
			/*
			 * grupo.setGrupoGrupo(); grupo.setGrupoReflexiva();
			 */
			grupo.setId(745505);
			grupo.setIngles('0');
			grupo.setLetra('B');
			grupo.setPlazas("25");
			grupo.setTurno_mañana_tarde("Mañana");
			gestionGrupo.createGrupo(grupo);

		} catch (ObjetoYaExistenteException e) {
			fail("No debería lanzarse excepción.");
		}
	}

	@Requisitos({ "RF3" })
	@Test
	public void testCrearGrupoYaExistente() {
		try {
			Grupo grupo = new Grupo();
			grupo.setCurso(2021);
			grupo.setId(1231546);
			grupo.setIngles('0');
			grupo.setLetra('A');
			grupo.setPlazas("25");
			grupo.setTurno_mañana_tarde("Mañana");
			gestionGrupo.createGrupo(grupo);
			fail("Debería lanzarse una excepción");
		} catch (ObjetoYaExistenteException e) {
			// OK
		}
	}

	@Requisitos({ "RF3" })
	@Test
	public void testLeerGrupo() {
		try {
			Grupo grupo = gestionGrupo.readGrupo(1231546);
			assertTrue(Integer.valueOf(2021).compareTo(grupo.getCurso()) == 0);
			assertTrue(Integer.valueOf(1231546).compareTo(grupo.getId()) == 0);
			assertEquals('0', grupo.getIngles());
			assertEquals('A', grupo.getLetra());
			assertEquals("25", grupo.getPlazas());
			assertEquals("Mañana", grupo.getTurno_mañana_tarde());
		} catch (ObjetoNoExistenteException e) {
			fail("No debería lanzarse excepción");
		}
	}

	@Requisitos({ "RF3" })
	@Test
	public void testLeerGrupoNoExistente() {
		try {
			Grupo grupo = gestionGrupo.readGrupo(2021);
			fail("Debería lanzarse una excepción");
		} catch (ObjetoNoExistenteException e) {
			// OK
		}
	}

	@Requisitos({ "RF3" })
	@Test
	public void testModificarGrupo() {
		try {
			Grupo grupo = gestionGrupo.readGrupo(1231546);
			grupo.setIngles('1');
			grupo.setLetra('B');
			grupo.setPlazas("15");
			grupo.setTurno_mañana_tarde("Tarde");
			gestionGrupo.updateGrupo(grupo);
		} catch (ObjetoNoExistenteException e) {
			fail("No debería lanzarse excepción");
		}
	}

	@Requisitos({ "RF3" })
	@Test
	public void testModificarGrupoNoExistente() {
		try {
			Grupo grupo = gestionGrupo.readGrupo(1231546);
			grupo.setId(2019);
			gestionGrupo.updateGrupo(grupo);
			fail("No debería lanzarse excepción");
		} catch (ObjetoNoExistenteException e) {
			// OK
		}
	}

	@Requisitos({ "RF3" })
	@Test
	public void testEliminarGrupo() {
		try {
			gestionGrupo.deleteGrupo(1231546);
		} catch (ObjetoNoExistenteException e) {
			fail("No debería lanzarse excepción");
		}
	}

	@Requisitos({ "RF3" })
	@Test
	public void testEliminarGrupoNoExistente() {
		try {
			gestionGrupo.deleteGrupo(1);
			fail("Debería lanzarse una excepción");
		} catch (ObjetoNoExistenteException e) {
			// OK
		}
	}

	@Requisitos({ "RF9" })
	@Test
	public void testGestionSolicitudCambioGrupo() {
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
			gestionGrupo.gestionarCambioGrupo(1, listaGa, true);
		} catch (ObjetoNoExistenteException e) {
			fail("No deberia lanzarse esta excepcion");
		}
	}

}
