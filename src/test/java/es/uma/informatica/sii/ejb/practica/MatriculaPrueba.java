package es.uma.informatica.sii.ejb.practica;

import static org.junit.Assert.fail;

import java.util.Date;
import java.util.logging.Logger;

import javax.naming.NamingException;

import org.junit.Before;
import org.junit.Test;

import es.uma.informatica.sii.ejb.practica.entidades.*;
import es.uma.informatica.sii.ejb.practica.entidades.Matricula.MatriculaId;
import es.uma.informatica.sii.ejb.practica.ejb.GestionMatricula;
import es.uma.informatica.sii.ejb.practica.ejb.GestionTitulacion;
import es.uma.informatica.sii.ejb.practica.ejb.MatriculaEJB;
import es.uma.informatica.sii.ejb.practica.ejb.exceptions.ObjetoNoExistenteException;
import es.uma.informatica.sii.ejb.practica.ejb.exceptions.ObjetoYaExistenteException;

public class MatriculaPrueba {


	
	private GestionMatricula gestionMatricula;
	
	
	private static final Logger LOG = Logger.getLogger(MatriculaPrueba.class.getCanonicalName());
	private static final String MATRICULA_EJB = "java:global/classes/MatriculaEJB";
	private static final String UNIDAD_PERSISTENCIA_PRUEBAS = "SecretariaTest";
	
	@Before
	public void setUp() throws NamingException{
		gestionMatricula = (GestionMatricula) SuiteTest.ctx.lookup(MATRICULA_EJB);
		BaseDatos.inicializaBaseDatos(UNIDAD_PERSISTENCIA_PRUEBAS);
	}
	
	
	//RF 6 - CREATE
	
		@Test
		public void testCrearMatricula(){
			try {
				Matricula m = new Matricula();
				m.setCursoAcademico("2020/2021");
				m.setEstado("estado");
				m.setFechaMatricula(new Date(22/04/2021));
				Expediente e = new Expediente();
				e.setNumeroExpediente(12345);
				m.setExpedienteMatricula(e);
				gestionMatricula.createMatricula(m);
			}catch(ObjetoYaExistenteException e) {
				fail("No debería lanzarse excepción.");
			}
		}
		
		@Test
		public void testCrearMatriculaYaExistente(){
			try {
				Matricula m = new Matricula();
				m.setCursoAcademico("2020/2021");
				m.setEstado("estado");
				m.setFechaMatricula(new Date(22/04/2021));
				Expediente e = new Expediente();
				e.setNumeroExpediente(12345);
				m.setExpedienteMatricula(e);
				gestionMatricula.createMatricula(m);
				fail("Debería lanzar excepción");
			}catch(ObjetoYaExistenteException e) {
				//OK
			}
		}
		
		//RF 6 - READ
		
		@Test
		public void testLeerMatricula(){
			try {
				MatriculaId mi = new MatriculaId("2020/2021",12345);	
				Matricula m = gestionMatricula.readMatricula(mi);		
			}catch(ObjetoNoExistenteException e) {
				fail("No debería lanzarse excepción");
			}
		}
		
		@Test
		public void testLeerMatriculaNoExistente(){
			try {
				MatriculaId mi = new MatriculaId("2020/2021",12346);	
				Matricula m = gestionMatricula.readMatricula(mi);
				fail("Debería lanzarse excepción");
			}catch(ObjetoNoExistenteException e) {
				//OK
			}
		}
		
		//RF 6 - UPDATE
		
		@Test
		public void testModificarMatricula(){
			try {
				MatriculaId mi = new MatriculaId("2020/2021",12345);	
				Matricula m = gestionMatricula.readMatricula(mi);	
				m.setEstado("estadoModificado");
				gestionMatricula.updateMatricula(m);
			}catch(ObjetoNoExistenteException e) {
				fail("No debería lanzarse excepción");
			}
		}
		
		@Test
		public void testModificarMatriculaNoExistente(){
			try {
				MatriculaId mi = new MatriculaId("2020/2021",12345);	
				Matricula m = gestionMatricula.readMatricula(mi);	
				m.setCursoAcademico("2020/2021");
				gestionMatricula.updateMatricula(m);
				fail("Debería lanzarse excepción");
			}catch(ObjetoNoExistenteException e) {
				//OK
			}
		}
		
		//RF 6 - DELETE
		
		@Test
		public void testEliminarMatricula(){
			try {
				MatriculaId mi = new MatriculaId("2020/2021",12345);
				gestionMatricula.deleteMatricula(mi);
			}catch(ObjetoNoExistenteException e) {
				fail("No debería lanzarse excepción");
			}
		}
		
		@Test
		public void testEliminarMatriculaNoExistente(){
			try {
				MatriculaId mi = new MatriculaId("2020/2021",12346);
				gestionMatricula.deleteMatricula(mi);
				fail("Debería lanzarse excepción");
			}catch(ObjetoNoExistenteException e) {
				//OK
			}
		}
		
}
