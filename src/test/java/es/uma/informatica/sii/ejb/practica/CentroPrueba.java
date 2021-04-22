package es.uma.informatica.sii.ejb.practica;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

import es.uma.informatica.sii.ejb.practica.ejb.CentroEJB;
import es.uma.informatica.sii.ejb.practica.ejb.exceptions.ObjetoNoExistenteException;
import es.uma.informatica.sii.ejb.practica.ejb.exceptions.ObjetoYaExistenteException;
import es.uma.informatica.sii.ejb.practica.entidades.Centro;

public class CentroPrueba {

	private CentroEJB gestionCentro;
	

	//RF 8 - CREATE
	
	@Test
	public void testCrearCentro(){
		try {
			Centro centro = new Centro();
			centro.setId(4969);
			centro.setDireccion("Calle Miramar");
			centro.setNombre("E.T.S.I");
			gestionCentro.createCentro(centro);
			
		}catch(ObjetoYaExistenteException e) {
			fail("No debería lanzarse excepción.");
		}
	}
	
	@Test
	public void testCrearCentroYaExistente(){
		try {
			Centro centro = new Centro();
			centro.setId(1842);
			centro.setDireccion("Calle Malaga");
			centro.setNombre("Centro Informatica");
			centro.setTelefono_conserjeria("690329116");
			gestionCentro.createCentro(centro);
			fail("No debería lanzarse excepción");
		}catch(ObjetoYaExistenteException e) {
			//OK
		}
	}
	
	//RF 8 - READ
	
	@Test
	public void testLeerCentro(){
		try {
			Centro centro = gestionCentro.readCentro(1842);
			assertTrue(Integer.valueOf(1842).compareTo(centro.getId())==0);			
			assertEquals("Calle Malaga",centro.getDireccion());
			assertEquals("Centro Informatica",centro.getNombre());
			assertEquals("690329116",centro.getTelefonoConserjeria());
		
		}catch(ObjetoNoExistenteException e) {
			fail("No debería lanzarse excepción");
		}
	}
	
	@Test
	public void testLeerCentroNoExistente(){
		try {
			Centro centro = gestionCentro.readCentro(5789);
			fail("Debería lanzarse una excepción");
		}catch(ObjetoNoExistenteException e) {
			//OK
		}
	}
	
	//RF 8 - UPDATE
	
	@Test
	public void testModificarCentro(){
		try {
			Centro centro = gestionCentro.readCentro(1842);
			centro.setNombre("Salud");
			centro.setTelefono_conserjeria("7458710");
			gestionCentro.updateCentro(centro);
		}catch(ObjetoNoExistenteException e) {
			fail("No debería lanzarse excepción");
		}
	}
	
	@Test
	public void testModificarCentroNoExistente(){
		try {
			Centro centro = gestionCentro.readCentro(1842);
			centro.setId(4178);
			gestionCentro.updateCentro(centro);
			fail("No debería lanzarse excepción");
		}catch(ObjetoNoExistenteException e) {
			//OK
		}
	}
	
	//RF 8 - DELETE
	
	@Test
	public void testEliminarCentro(){
		try {
			gestionCentro.deleteCentro(1842);
		}catch(ObjetoNoExistenteException e) {
			fail("No debería lanzarse excepción");
		}
	}
	
	@Test
	public void testEliminarCentroNoExistente(){
		try {
			gestionCentro.deleteCentro(6574);
			fail("No debería lanzarse excepción");
		}catch(ObjetoNoExistenteException e) {
			//OK
		}
	}

}
