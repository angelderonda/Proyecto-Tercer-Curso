package es.uma.informatica.sii.ejb.practica;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import es.uma.informatica.sii.ejb.practica.ejb.GruposAsignaturaEJB;
import es.uma.informatica.sii.ejb.practica.ejb.exceptions.ObjetoNoExistenteException;
import es.uma.informatica.sii.ejb.practica.ejb.exceptions.ObjetoYaExistenteException;
import es.uma.informatica.sii.ejb.practica.entidades.Asignatura;
import es.uma.informatica.sii.ejb.practica.entidades.Asignatura.AsignaturaId;
import es.uma.informatica.sii.ejb.practica.entidades.Grupo;
import es.uma.informatica.sii.ejb.practica.entidades.GruposAsignatura;
import es.uma.informatica.sii.ejb.practica.entidades.GruposAsignatura.GruposAsignaturaId;
import es.uma.informatica.sii.ejb.practica.entidades.Titulacion;

public class GruposAsignaturaPrueba {

	private GruposAsignaturaEJB gestionGruposAsignatura;
	
	//RF 4 - CREATE
	
	@Test
	public void testCrearGrupoAsignatura(){
		try {
			GruposAsignatura ga = new GruposAsignatura();
			ga.setCursoAcademico("2020/2021");
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
	        gestionGruposAsignatura.createGruposAsignatura(ga); 
		}catch(ObjetoYaExistenteException e) {
			fail("No debería lanzarse excepción.");
		}
	}
	/*
	@Test
	public void testCrearGrupoAsignaturaYaExistente(){
		try {
			GruposAsignatura ga = new GruposAsignatura();
			ga.setCursoAcademico("2020/2021");
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
	        gestionGruposAsignatura.createGruposAsignatura(ga); 
	        fail("Debería lanzarse excepción.");
		}catch(ObjetoYaExistenteException e) {
			//OK
		}
	}
	
	//RF 4 - READ
	
	@Test
	public void testLeerGrupoAsignatura(){
		try {
			GruposAsignaturaId gai = new GruposAsignaturaId("2020/2021",1231546, new AsignaturaId(564846687,1041));
			GruposAsignatura ga = gestionGruposAsignatura.readGrupoAsignatura(gai);
			assertEquals(Integer.valueOf(2021),ga.getCursoAcademico());
			assertEquals('1',ga.getOferta());
			
		}catch(ObjetoNoExistenteException e) {
			fail("No debería lanzarse excepción");
		}
	}
	
	@Test
	public void testLeerGrupoAsignaturaNoExistente(){
		try {
			GruposAsignaturaId gai = new GruposAsignaturaId("2000/2001",1231543, new AsignaturaId(564846689,1042));
			GruposAsignatura ga = gestionGruposAsignatura.readGrupoAsignatura(gai);
			fail("Debería lanzarse excepción.");
		}catch(ObjetoNoExistenteException e) {
			//OK
		}
	}
	
	//RF 4 - UPDATE
	
	@Test
	public void testModificarGrupoAsignatura(){
		try {
			GruposAsignaturaId gai = new GruposAsignaturaId("2020/2021",1231546, new AsignaturaId(564846687,1041));
			GruposAsignatura ga = gestionGruposAsignatura.readGrupoAsignatura(gai);
			ga.setOferta('0');
			gestionGruposAsignatura.updateGrupoAsignatura(ga);
		}catch(ObjetoNoExistenteException e) {
			fail("No debería lanzarse excepción");
		}
	}
	
	@Test
	public void testModificarGrupoAsignaturaNoExistente(){
		try {
			GruposAsignaturaId gai = new GruposAsignaturaId("2020/2021",1231546, new AsignaturaId(564846687,1041));
			GruposAsignatura ga = gestionGruposAsignatura.readGrupoAsignatura(gai);
			ga.setCursoAcademico("2000/2001");
			gestionGruposAsignatura.updateGrupoAsignatura(ga);
			fail("Debería lanzarse excepción.");
		}catch(ObjetoNoExistenteException e) {
			//OK
		}
	}
	
	//RF 4 - DELETE
	
	@Test
	public void testEliminarGrupoAsignatura(){
		try {
			gestionGruposAsignatura.deleteGrupoAsignatura(new GruposAsignaturaId("2020/2021",12345, new AsignaturaId(564846687,1041)));
		}catch(ObjetoNoExistenteException e) {
			fail("No debería lanzarse excepción");
		}
	}
	
	@Test
	public void testEliminarGrupoAsignaturaNoExistente(){
		try {
			gestionGruposAsignatura.deleteGrupoAsignatura(new GruposAsignaturaId("2000/2001",12345, new AsignaturaId(564846687,1041)));
			fail("No deberia lanzarse excepcion");
		}catch(ObjetoNoExistenteException e) {
			//OK
		}
	}*/
}
