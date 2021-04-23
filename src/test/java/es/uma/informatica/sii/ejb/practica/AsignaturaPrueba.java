package es.uma.informatica.sii.ejb.practica;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.Date;
import java.util.logging.Logger;

import javax.naming.NamingException;

import org.junit.Before;
import org.junit.Test;

import es.uma.informatica.sii.ejb.practica.ejb.AsignaturaEJB;
import es.uma.informatica.sii.ejb.practica.ejb.GestionAsignatura;
import es.uma.informatica.sii.ejb.practica.ejb.GestionTitulacion;
import es.uma.informatica.sii.ejb.practica.ejb.exceptions.ObjetoNoExistenteException;
import es.uma.informatica.sii.ejb.practica.ejb.exceptions.ObjetoYaExistenteException;
import es.uma.informatica.sii.ejb.practica.entidades.Asignatura;
import es.uma.informatica.sii.ejb.practica.entidades.Asignatura.AsignaturaId;
import es.uma.informatica.sii.ejb.practica.entidades.GruposAsignatura.GruposAsignaturaId;
import es.uma.informatica.sii.ejb.practica.entidades.Expediente;
import es.uma.informatica.sii.ejb.practica.entidades.Matricula;
import es.uma.informatica.sii.ejb.practica.entidades.Titulacion;

public class AsignaturaPrueba {

	private GestionAsignatura gestionAsignatura;	
	
	
	
	private static final Logger LOG = Logger.getLogger(AsignaturaPrueba.class.getCanonicalName());
	private static final String ASIGNATURA_EJB = "java:global/classes/AsignaturaEJB";
	private static final String UNIDAD_PERSISTENCIA_PRUEBAS = "SecretariaTest";
	
	@Before
	public void setUp() throws NamingException{
		gestionAsignatura = (GestionAsignatura) SuiteTest.ctx.lookup(ASIGNATURA_EJB);
		BaseDatos.inicializaBaseDatos(UNIDAD_PERSISTENCIA_PRUEBAS);
	}
	

	//RF 1 - CREATE
	
	@Test
	public void testCrearAsignatura(){
		try {
			Asignatura a = new Asignatura();
			a.setReferencia(564846680);
			a.setCodigo(134590);
			a.setCreditosTeoria(6);
			a.setCreditosPracticas(0);
			a.setNombre("Matemáticas Discretas");
			a.setDuracion("1º cuatrimestre");
			a.setOfertada("Sí");
			Titulacion t = new Titulacion();
			t.setCodigo(123);
			t.setCreditos(240);
			t.setNombre("Informatica");
			a.setTitulacionAsignatura(t);
			gestionAsignatura.createAsignatura(a); 
			
		}catch(ObjetoYaExistenteException e) {
			fail("No debería lanzarse excepción.");
		}
	}
	
	@Test
	public void testCrearAsignaturaYaExistente(){
		try {
			Asignatura asignatura = new Asignatura();
	        asignatura.setCodigo(1456156);
	        asignatura.setCreditosPracticas(6);
	        asignatura.setCreditosTeoria(6);
	        asignatura.setDuracion("1º cuatrimestre");
	        asignatura.setNombre("Cálculo");
	        asignatura.setOfertada("Si");
	        asignatura.setReferencia(564846687);
	        
	        Titulacion titulacion = new Titulacion();
	        titulacion.setCodigo(1041);
			titulacion.setCreditos(240);
			titulacion.setNombre("Informatica");
	        asignatura.setTitulacionAsignatura(titulacion);     
	       
	        gestionAsignatura.createAsignatura(asignatura);
			fail("No debería lanzarse excepción");
		}catch(ObjetoYaExistenteException e) {
			//OK
		}
	}
	
	//RF 1 - READ
	
	@Test
	public void testLeerAsignatura(){
		try {
			AsignaturaId asignatura = new AsignaturaId(564846687,1041);
			Asignatura asigna = gestionAsignatura.readAsignatura(asignatura);
			assertEquals(Integer.valueOf(1041),asigna.getTitulacionAsignatura());
			assertEquals("Si",asigna.getOfertada());
		}catch(ObjetoNoExistenteException e) {
			fail("No debería lanzarse excepción");
		}
	}
	
	@Test
	public void testLeerAsignaturaNoExistente(){
		try {
			AsignaturaId asignatura = new AsignaturaId(564846680,1041);
			Asignatura asigna = gestionAsignatura.readAsignatura(asignatura);
			fail("Debería lanzarse excepción.");
		}catch(ObjetoNoExistenteException e) {
			//OK
		}
	}
	
	//RF 1 - UPDATE
	
	@Test
	public void testModificarAsignatura(){
		try {
			AsignaturaId asignatura = new AsignaturaId(564846687,1041);
			Asignatura asigna = gestionAsignatura.readAsignatura(asignatura);
			asigna.setOfertada("No");
			gestionAsignatura.updateAsignatura(asigna);
		}catch(ObjetoNoExistenteException e) {
			fail("No debería lanzarse excepción");
		}
	}
	
	@Test
	public void testModificarAsignaturaNoExistente(){
		try {
			AsignaturaId asignatura = new AsignaturaId(564846687,1041);
			Asignatura asigna = gestionAsignatura.readAsignatura(asignatura);
			asigna.setReferencia(5648460);
			gestionAsignatura.updateAsignatura(asigna);
			fail("Debería lanzarse excepción.");
		}catch(ObjetoNoExistenteException e) {
			//OK
		}
	}
	
	//RF 1 - DELETE
	
	@Test
	public void testEliminarAsignatura(){
		try {
			
			gestionAsignatura.deleteAsignatura(new AsignaturaId(564846687,1041));
			
		}catch(ObjetoNoExistenteException e) {
			fail("No debería lanzarse excepción");
		}
	}
	
	@Test
	public void testEliminarAsignaturaNoExistente(){
		try {
			gestionAsignatura.deleteAsignatura(new AsignaturaId(56484000,1043));
		}catch(ObjetoNoExistenteException e) {
			//OK
		}
	}
}
