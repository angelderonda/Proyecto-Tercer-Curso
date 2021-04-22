package es.uma.informatica.sii.ejb.practica;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;


import es.uma.informatica.sii.ejb.practica.ejb.GrupoEJB;
import es.uma.informatica.sii.ejb.practica.ejb.exceptions.ObjetoNoExistenteException;
import es.uma.informatica.sii.ejb.practica.ejb.exceptions.ObjetoYaExistenteException;
import es.uma.informatica.sii.ejb.practica.entidades.Grupo;

public class GrupoPrueba {
	
	private GrupoEJB gestionGrupo;
	
	//RF 3 - CREATE
	
	@Test
	public void testCrearGrupo(){
		try {
			Grupo grupo = new Grupo();				
			grupo.setCurso(2021);
			/*grupo.setGrupoGrupo();
			grupo.setGrupoReflexiva();*/			
			grupo.setId(1231546);
			grupo.setIngles('0');
			grupo.setLetra('A');
			grupo.setPlazas("25");			
			grupo.setTurno_mañana_tarde("Mañana");
			gestionGrupo.createGrupo(grupo);
			
		}catch(ObjetoYaExistenteException e) {
			fail("No debería lanzarse excepción.");
		}
	}
	
	@Test
	public void testCrearGrupoYaExistente(){
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
		}catch(ObjetoYaExistenteException e) {
			//OK
		}
	}
	
	//RF 3 - READ
	
	@Test
	public void testLeerGrupo(){
		try {
			Grupo grupo = gestionGrupo.readGrupo(2021);				
			assertTrue(Integer.valueOf(2021).compareTo(grupo.getCurso())==0);
			assertTrue(Integer.valueOf(1231546).compareTo(grupo.getId())==0);
			assertEquals('0',grupo.getIngles());
			assertEquals('A',grupo.getLetra());
			assertEquals("25",grupo.getPlazas());
			assertEquals("Mañana",grupo.getTurno_mañana_tarde());			
		}catch(ObjetoNoExistenteException e) {
			fail("No debería lanzarse excepción");
		}
	}
	
	@Test
	public void testLeerGrupoNoExistente(){
		try {
			Grupo grupo = gestionGrupo.readGrupo(2021);	
			fail("Debería lanzarse una excepción");
		}catch(ObjetoNoExistenteException e) {
			//OK
		}
	}
	//RF 3 - UPDATE
	
	@Test
	public void testModificarGrupo(){
		try {
			Grupo grupo = new Grupo();				
			grupo.setCurso(2021);
			grupo.setId(1231546);
			grupo.setIngles('0');
			grupo.setLetra('A');
			grupo.setPlazas("25");			
			grupo.setTurno_mañana_tarde("Mañana");
			gestionGrupo.updateGrupo(grupo);
		}catch(ObjetoNoExistenteException e) {
			fail("No debería lanzarse excepción");
		}
	}
	
	@Test
	public void testModificarGrupoNoExistente(){
		try {
			Grupo grupo = gestionGrupo.readGrupo(1231546);				
			grupo.setId(2020);
			gestionGrupo.updateGrupo(grupo);
			
		}catch(ObjetoNoExistenteException e) {
			//OK
		}
	}
	
	//RF 3- DELETE
	
	@Test
	public void testEliminarGrupo(){
		try {
			
		}catch(ObjetoNoExistenteException e) {
			fail("No debería lanzarse excepción");
		}
	}
	
	@Test
	public void testEliminarGrupoNoExistente(){
		try {
			
		}catch(ObjetoNoExistenteException e) {
			//OK
		}
	}

	
	
	//RF 9

	@Test
	public void testGestionSolicitudCambioGrupo(){
		try {
			
		}catch(ObjetoNoExistenteException e) {
			fail("No debería lanzarse excepción");
		}
	}
	
	@Test
	public void testGestionSolicitudCambioGrupoNoExistente(){
		try {
			
		}catch(ObjetoNoExistenteException e) {
			//OK
		}
	}

}
