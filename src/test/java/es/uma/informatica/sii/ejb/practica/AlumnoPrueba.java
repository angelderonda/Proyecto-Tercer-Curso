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

import es.uma.informatica.sii.ejb.practica.ejb.AlumnoEJB;
import es.uma.informatica.sii.ejb.practica.ejb.GestionAlumno;
import es.uma.informatica.sii.ejb.practica.ejb.GestionTitulacion;
import es.uma.informatica.sii.ejb.practica.ejb.GruposAsignaturaEJB;
import es.uma.informatica.sii.ejb.practica.ejb.exceptions.ObjetoNoExistenteException;
import es.uma.informatica.sii.ejb.practica.ejb.exceptions.ObjetoYaExistenteException;
import es.uma.informatica.sii.ejb.practica.ejb.exceptions.ProyectoException;
import es.uma.informatica.sii.ejb.practica.entidades.Alumno;
import es.uma.informatica.sii.ejb.practica.entidades.Asignatura;
import es.uma.informatica.sii.ejb.practica.entidades.Asignatura.AsignaturaId;
import es.uma.informatica.sii.ejb.practica.entidades.Grupo;
import es.uma.informatica.sii.ejb.practica.entidades.GruposAsignatura;
import es.uma.informatica.sii.ejb.practica.entidades.GruposAsignatura.GruposAsignaturaId;
import es.uma.informatica.sii.ejb.practica.entidades.Titulacion;

public class AlumnoPrueba {

	private GestionAlumno gestionAlumnos;
	
		
	
	private static final Logger LOG = Logger.getLogger(AlumnoPrueba.class.getCanonicalName());
	private static final String ALUMNO_EJB = "java:global/classes/AlumnoEJB";
	private static final String UNIDAD_PERSISTENCIA_PRUEBAS = "SecretariaTest";
	
	@Before
	public void setUp() throws NamingException{
		gestionAlumnos = (GestionAlumno) SuiteTest.ctx.lookup(ALUMNO_EJB);
		BaseDatos.inicializaBaseDatos(UNIDAD_PERSISTENCIA_PRUEBAS);
	}
	
	
	//RF 2 - CREATE
	
		@Test
		public void testCrearAlumno(){
			try {
				Alumno a = new Alumno();
				a.setId(12);
				a.setDni("678435610");
				a.setNombreCompleto("Alejandro");
				gestionAlumnos.createAlumno(a);
			}catch(ObjetoYaExistenteException e) {
				fail("No debería lanzarse excepción.");
			}
		}
		
		@Test
		public void testCrearAlumnoYaExistente(){
			try {
				Alumno a = new Alumno();
				a.setId(1);
				a.setDni("254789E");
				a.setNombreCompleto("Pepito");
				gestionAlumnos.createAlumno(a);
				fail("Debería lanzarse una excepción");
			}catch(ObjetoYaExistenteException e) {
				//OK
			}
		}
		
		//RF 2 - READ
		
		@Test
		public void testLeerAlumno(){
			try {
				Alumno a = gestionAlumnos.readAlumno(1);
				assertEquals("254789E",a.getDni());
				assertEquals("Pepito", a.getNombre());
				assertTrue(Integer.valueOf(1).compareTo(a.getId())==0);
				
			}catch(ObjetoNoExistenteException e) {
				fail("No debería lanzarse excepción");
			}
		}
		
		@Test
		public void testLeerAlumnoNoExistente(){
			try {
				Alumno a = gestionAlumnos.readAlumno(901);
				fail("Debería lanzarse una excepción");
			}catch(ObjetoNoExistenteException e) {
				//OK
			}
		}
			
		//RF 2 - UPDATE
		
		@Test
		public void testModificarAlumno(){
			try {
				Alumno a = gestionAlumnos.readAlumno(1);
				a.setNombreCompleto("Pablo");
				gestionAlumnos.updateAlumno(a);
				
			}catch(ObjetoNoExistenteException e) {
				fail("No debería lanzarse excepción");
			}
		}
		
		@Test
		public void testModificarAlumnoNoExistente(){
			try {
				Alumno a = gestionAlumnos.readAlumno(12);
				a.setId(10);			
				gestionAlumnos.updateAlumno(a);
				fail("Debería lanzarse una excepción");
			}catch(ObjetoNoExistenteException e) {
				//OK
			}
		}
			
		//RF 2 - DELETE
			
		@Test
		public void testEliminarAlumno(){
			try {
				gestionAlumnos.deleteAlumno(1);
			}catch(ObjetoNoExistenteException e) {
				fail("No debería lanzarse excepción");
			}
		}
		
		@Test
		public void testEliminarAlumnoNoExistente(){
			try {
				gestionAlumnos.deleteAlumno(1929);
				fail("Debería lanzarse una excepción");
			}catch(ObjetoNoExistenteException e) {
				//OK
			}
		}
		
		//RF 14
		
		@Test
		public void testRealizarEncuestaPreferencia(){
			try {
				GruposAsignaturaEJB gestionGruposAsignatura = new GruposAsignaturaEJB();
				Alumno a = gestionAlumnos.readAlumno(1);
				
				GruposAsignaturaId gai = new GruposAsignaturaId("2020/2021",1231546, new AsignaturaId(564846687,1041));
				GruposAsignatura ga = gestionGruposAsignatura.readGrupoAsignatura(gai);
				
				List<GruposAsignatura> listaGa = new ArrayList<GruposAsignatura>();
				listaGa.add(ga);

				gestionAlumnos.rellenarEncuesta(1, listaGa);
				
			}catch(ProyectoException e) {
				fail("No debería lanzarse excepción");
			}
		}
		
		@Test
		public void testRealizarEncuestaPreferenciaNoExistente(){
			try {
				GruposAsignatura ga = new GruposAsignatura();
				ga.setCursoAcademico("2019/2020");
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
				
			}catch(ProyectoException e) {
				//OK
			}
		}
		//RF 10
	/*	
		@Test
		public void testAsignarGrupo(){
			try {
				
			}catch(ObjetoNoExistenteException e) {
				fail("No debería lanzarse excepción");
			}
		}
		
		@Test
		public void testAsignarGrupoNoExistente(){
			try {
				
			}catch(ObjetoNoExistenteException e) {
				//OK
			}
		}
		//RF 11
		
		@Test
		public void testGestionarListadoAlumnos(){
			try {
				
			}catch(ObjetoNoExistenteException e) {
				fail("No debería lanzarse excepción");
			}
		}
		
		@Test
		public void testGestionarListadoAlumnosNoExistente(){
			try {
				
			}catch(ObjetoNoExistenteException e) {
				//OK
			}
		}
		
		//RF 12
		
		@Test
		public void testSolicitarCambioGrupo(){
			try {
				
			}catch(ObjetoNoExistenteException e) {
				fail("No debería lanzarse excepción");
			}
		}
		
		@Test
		public void testSolicitarCambioGrupoNoExistente(){
			try {
				
			}catch(ObjetoNoExistenteException e) {
				//OK
			}
		}

		//RF 13
		/*
		@Test
		public void testNotificarColisionHorario(){
			try {
				
			}catch(ObjetoNoExistenteException e) {
				fail("No debería lanzarse excepción");
			}
		}
		
		@Test
		public void testNotificarColisionHorarioNoExistente(){
			try {
				
			}catch(ObjetoNoExistenteException e) {
				//OK
			}
		}
		
		//RF 14
		
		@Test
		public void testRealizarEncuestaPreferencia(){
			try {
				
			}catch(ObjetoNoExistenteException e) {
				fail("No debería lanzarse excepción");
			}
		}
		
		@Test
		public void testRealizarEncuestaPreferenciaNoExistente(){
			try {
				
			}catch(ObjetoNoExistenteException e) {
				//OK
			}
		}*/
}
