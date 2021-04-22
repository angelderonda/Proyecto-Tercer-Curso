package es.uma.informatica.sii.ejb.practica;

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
import es.uma.informatica.sii.ejb.practica.entidades.Expediente;
import es.uma.informatica.sii.ejb.practica.entidades.Matricula;

public class AsignaturaPrueba {
/*
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
			Asignatura m = new Asignatura();
		}catch(ObjetoYaExistenteException e) {
			fail("No debería lanzarse excepción.");
		}
	}
	
	@Test
	public void testCrearAsignaturaYaExistente(){
		try {
			
		}catch(ObjetoYaExistenteException e) {
			//OK
		}
	}
	
	//RF 1 - READ
	
	@Test
	public void testLeerAsignatura(){
		try {
			
		}catch(ObjetoNoExistenteException e) {
			fail("No debería lanzarse excepción");
		}
	}
	
	@Test
	public void testLeerAsignaturaNoExistente(){
		try {
			
		}catch(ObjetoNoExistenteException e) {
			//OK
		}
	}
	
	//RF 1 - UPDATE
	
	@Test
	public void testModificarAsignatura(){
		try {
			
		}catch(ObjetoNoExistenteException e) {
			fail("No debería lanzarse excepción");
		}
	}
	
	@Test
	public void testModificarAsignaturaNoExistente(){
		try {
			
		}catch(ObjetoNoExistenteException e) {
			//OK
		}
	}
	
	//RF 1 - DELETE
	
	@Test
	public void testEliminarAsignatura(){
		try {
			
		}catch(ObjetoNoExistenteException e) {
			fail("No debería lanzarse excepción");
		}
	}
	
	@Test
	public void testEliminarAsignaturaNoExistente(){
		try {
			
		}catch(ObjetoNoExistenteException e) {
			//OK
		}
	}*/
}
