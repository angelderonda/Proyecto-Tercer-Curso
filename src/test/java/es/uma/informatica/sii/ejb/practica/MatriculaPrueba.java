package es.uma.informatica.sii.ejb.practica;

import static org.junit.Assert.fail;

import org.junit.Test;

import es.uma.informatica.sii.ejb.practica.ejb.MatriculaEJB;
import es.uma.informatica.sii.ejb.practica.ejb.exceptions.ObjetoNoExistenteException;
import es.uma.informatica.sii.ejb.practica.ejb.exceptions.ObjetoYaExistenteException;

public class MatriculaPrueba {

	private MatriculaEJB gestionMatricula;
	
	//RF 6 - CREATE
	
		@Test
		public void testCrearMatricula(){
			try {
				
			}catch(ObjetoYaExistenteException e) {
				fail("No debería lanzarse excepción.");
			}
		}
		
		@Test
		public void testCrearMatriculaYaExistente(){
			try {
				
			}catch(ObjetoYaExistenteException e) {
				//OK
			}
		}
		
		//RF 6 - READ
		
		@Test
		public void testLeerMatricula(){
			try {
				
			}catch(ObjetoNoExistenteException e) {
				fail("No debería lanzarse excepción");
			}
		}
		
		@Test
		public void testLeerMatriculaNoExistente(){
			try {
				
			}catch(ObjetoNoExistenteException e) {
				//OK
			}
		}
		
		//RF 6 - UPDATE
		
		@Test
		public void testModificarMatricula(){
			try {
				
			}catch(ObjetoNoExistenteException e) {
				fail("No debería lanzarse excepción");
			}
		}
		
		@Test
		public void testModificarMatriculaNoExistente(){
			try {
				
			}catch(ObjetoNoExistenteException e) {
				//OK
			}
		}
		
		//RF 6 - DELETE
		
		@Test
		public void testEliminarMatricula(){
			try {
				
			}catch(ObjetoNoExistenteException e) {
				fail("No debería lanzarse excepción");
			}
		}
		
		@Test
		public void testEliminarMatriculaNoExistente(){
			try {
				
			}catch(ObjetoNoExistenteException e) {
				//OK
			}
		}
		
}
