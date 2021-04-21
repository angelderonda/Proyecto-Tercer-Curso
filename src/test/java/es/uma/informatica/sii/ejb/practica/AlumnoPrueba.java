package es.uma.informatica.sii.ejb.practica;

import static org.junit.Assert.fail;

import org.junit.Test;

import es.uma.informatica.sii.ejb.practica.ejb.AlumnoEJB;
import es.uma.informatica.sii.ejb.practica.ejb.exceptions.ObjetoNoExistenteException;
import es.uma.informatica.sii.ejb.practica.ejb.exceptions.ObjetoYaExistenteException;

public class AlumnoPrueba {

	private AlumnoEJB gestionAlumnos;
	
	//RF 2 - CREATE
	
		@Test
		public void testCrearAlumno(){
			try {
				
			}catch(ObjetoYaExistenteException e) {
				fail("No debería lanzarse excepción.");
			}
		}
		
		@Test
		public void testCrearAlumnoYaExistente(){
			try {
				
			}catch(ObjetoYaExistenteException e) {
				//OK
			}
		}
		
		//RF 2 - READ
		
		@Test
		public void testLeerAlumno(){
			try {
				
			}catch(ObjetoNoExistenteException e) {
				fail("No debería lanzarse excepción");
			}
		}
		
		@Test
		public void testLeerAlumnoNoExistente(){
			try {
				
			}catch(ObjetoNoExistenteException e) {
				//OK
			}
		}
			
		//RF 2 - UPDATE
		
		@Test
		public void testModificarAlumno(){
			try {
				
			}catch(ObjetoNoExistenteException e) {
				fail("No debería lanzarse excepción");
			}
		}
		
		@Test
		public void testModificarAlumnoNoExistente(){
			try {
				
			}catch(ObjetoNoExistenteException e) {
				//OK
			}
		}
			
		//RF 2 - DELETE
			
		@Test
		public void testEliminarAlumno(){
			try {
				
			}catch(ObjetoNoExistenteException e) {
				fail("No debería lanzarse excepción");
			}
		}
		
		@Test
		public void testEliminarAlumnoNoExistente(){
			try {
				
			}catch(ObjetoNoExistenteException e) {
				//OK
			}
		}
		//RF 10
		
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
		}*/
		
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
		}
}
