package es.uma.informatica.sii.ejb.practica;

import java.util.Properties;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.*;
import org.junit.runners.*;
import org.junit.runners.Suite.SuiteClasses;

import es.uma.informatica.sii.ejb.practica.entidades.*;

@RunWith(Suite.class)
//@SuiteClasses({AlumnoPrueba.class, GruposAsignaturaPrueba.class, AsignaturaPrueba.class,CentroPrueba.class,ExpedientePrueba.class, GrupoPrueba.class, MatriculaPrueba.class, TitulacionPrueba.class})
@SuiteClasses({GruposAsignaturaPrueba.class})
public class SuiteTest {
	
	private static final String GLASSFISH_CONFIGI_FILE_PROPERTY = "org.glassfish.ejb.embedded.glassfish.configuration.file";
	private static final String CONFIG_FILE = "target/test-classes/META-INF/domain.xml";
	
	
	public static EJBContainer ejbContainer;
	public static Context ctx;
	
	//Método ejecutado al comienzo de todo
	@BeforeClass
	public static void setUpClass() {
		Properties properties = new Properties();
		properties.setProperty(GLASSFISH_CONFIGI_FILE_PROPERTY, CONFIG_FILE);
		ejbContainer = EJBContainer.createEJBContainer(properties);
		ctx = ejbContainer.getContext();
	}
	
	// Método ejecutado al terminar con todos los tests
	@AfterClass
	public static void tearDownClass() {
		if (ejbContainer != null) {
			ejbContainer.close();
		}
	}
	
}
