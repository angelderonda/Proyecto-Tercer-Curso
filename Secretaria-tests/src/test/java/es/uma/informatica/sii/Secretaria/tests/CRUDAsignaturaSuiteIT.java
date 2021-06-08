package es.uma.informatica.sii.Secretaria.tests;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CRUDAsignaturaSuiteIT {
	  private WebDriver driver;
	  private Map<String, Object> vars;
	  JavascriptExecutor js;
	  @Before
	  public void setUp() {
	    driver = new ChromeDriver();
	    js = (JavascriptExecutor) driver;
	    vars = new HashMap<String, Object>();
	  }
	  @After
	  public void tearDown() {
	    driver.quit();
	  }
	  @Test
	  public void createAsignaturaIT() {
	    driver.get("http://0.0.0.0:8080/Secretaria-WAR/faces/gestionarEntidades.xhtml");
	    driver.manage().window().setSize(new Dimension(926, 861));
	    driver.findElement(By.cssSelector("input:nth-child(4)")).click();
	    driver.findElement(By.id("j_idt6:referencia")).click();
	    driver.findElement(By.id("j_idt6:referencia")).sendKeys("56846499");
	    driver.findElement(By.id("j_idt6:titulacionAsignatura")).click();
	    driver.findElement(By.id("j_idt6:titulacionAsignatura")).sendKeys("1041");
	    driver.findElement(By.id("j_idt6:codigo")).click();
	    driver.findElement(By.id("j_idt6:codigo")).sendKeys("12345600");
	    driver.findElement(By.id("j_idt6:creditosTeoria")).click();
	    driver.findElement(By.id("j_idt6:creditosTeoria")).sendKeys("6");
	    driver.findElement(By.id("j_idt6:creditosPracticas")).click();
	    driver.findElement(By.id("j_idt6:creditosPracticas")).sendKeys("0");
	    driver.findElement(By.id("j_idt6:nombre")).click();
	    driver.findElement(By.id("j_idt6:nombre")).sendKeys("Procesadores de Lenguaje");
	    driver.findElement(By.id("j_idt6:duracion")).click();
	    driver.findElement(By.id("j_idt6:duracion")).sendKeys("1º cuatrimestre");
	    driver.findElement(By.id("j_idt6:ofertada")).click();
	    driver.findElement(By.id("j_idt6:ofertada")).sendKeys("Si");
	    driver.findElement(By.id("j_idt6:curso")).click();
	    driver.findElement(By.id("j_idt6:curso")).sendKeys("3");
	    driver.findElement(By.id("j_idt6:tipo")).click();
	    driver.findElement(By.id("j_idt6:tipo")).sendKeys("Obligatoria");
	    driver.findElement(By.id("j_idt6:plazas")).click();
	    driver.findElement(By.id("j_idt6:plazas")).sendKeys("100");
	    driver.findElement(By.id("j_idt6:otro_idioma")).click();
	    driver.findElement(By.id("j_idt6:otro_idioma")).sendKeys("Ingles");
	    driver.findElement(By.name("j_idt6:j_idt40")).click();
	    driver.findElement(By.cssSelector("li")).click();
	    assertEquals(driver.findElement(By.cssSelector("li")).getText(), "Asignatura creada correctamente");
	    driver.findElement(By.cssSelector("input:nth-child(4)")).click();
	    driver.findElement(By.cssSelector("input:nth-child(5)")).click();
	    driver.findElement(By.id("j_idt6:referencia")).click();
	    driver.findElement(By.id("j_idt6:referencia")).sendKeys("56846499");
	    driver.findElement(By.id("j_idt6:titulacionAsignatura")).click();
	    driver.findElement(By.id("j_idt6:titulacionAsignatura")).sendKeys("1041");
	    driver.findElement(By.name("j_idt6:j_idt15")).click();
	    driver.findElement(By.cssSelector("li")).click();
	    assertEquals(driver.findElement(By.cssSelector("li")).getText(), "Asignatura leida correctamente");
	    driver.findElement(By.cssSelector("input:nth-child(4)")).click();
	  }
	  
	  @Test
	  public void updateTitulacionIT() {
	    driver.get("http://0.0.0.0:8080/Secretaria-WAR/faces/gestionarEntidades.xhtml");
	    driver.manage().window().setSize(new Dimension(926, 861));
	    driver.findElement(By.cssSelector("input:nth-child(4)")).click();
	    driver.findElement(By.id("j_idt6:referencia")).click();
	    driver.findElement(By.id("j_idt6:referencia")).sendKeys("5648464");
	    driver.findElement(By.id("j_idt6:titulacionAsignatura")).click();
	    driver.findElement(By.id("j_idt6:titulacionAsignatura")).sendKeys("1041");
	    driver.findElement(By.id("j_idt6:codigo")).click();
	    driver.findElement(By.id("j_idt6:codigo")).sendKeys("1456142");
	    driver.findElement(By.id("j_idt6:creditosTeoria")).click();
	    driver.findElement(By.id("j_idt6:creditosTeoria")).sendKeys("6");
	    driver.findElement(By.id("j_idt6:creditosPracticas")).click();
	    driver.findElement(By.id("j_idt6:creditosPracticas")).sendKeys("6");
	    driver.findElement(By.id("j_idt6:nombre")).click();
	    driver.findElement(By.id("j_idt6:nombre")).sendKeys("Programación");
	    driver.findElement(By.id("j_idt6:duracion")).sendKeys("1º cuatrimestre");
	    driver.findElement(By.id("j_idt6:ofertada")).sendKeys("No");
	    driver.findElement(By.id("j_idt6:curso")).sendKeys("1");
	    driver.findElement(By.id("j_idt6:tipo")).sendKeys("Obligatoria");
	    driver.findElement(By.id("j_idt6:plazas")).sendKeys("40");
	    driver.findElement(By.id("j_idt6:otro_idioma")).sendKeys("Ingles");
	    driver.findElement(By.name("j_idt6:j_idt41")).click();
	    driver.findElement(By.cssSelector("li")).click();
	    assertEquals(driver.findElement(By.cssSelector("li")).getText(), "Asignatura modificada correctamente");
	    driver.findElement(By.cssSelector("input:nth-child(4)")).click();
	    driver.findElement(By.cssSelector("input:nth-child(5)")).click();
	    driver.findElement(By.id("j_idt6:referencia")).click();
	    driver.findElement(By.id("j_idt6:referencia")).sendKeys("5648464");
	    driver.findElement(By.id("j_idt6:titulacionAsignatura")).click();
	    driver.findElement(By.id("j_idt6:titulacionAsignatura")).sendKeys("1041");
	    driver.findElement(By.name("j_idt6:j_idt15")).click();
	    driver.findElement(By.cssSelector("li")).click();
	    assertEquals(driver.findElement(By.cssSelector("li")).getText(), "Asignatura leida correctamente");
	    driver.findElement(By.cssSelector("input:nth-child(4)")).click();
	  }
	  
	  @Test
	  public void deleteAsignaturaIT() {
	    driver.get("http://0.0.0.0:8080/Secretaria-WAR/faces/gestionarEntidades.xhtml");
	    driver.manage().window().setSize(new Dimension(926, 861));
	    driver.findElement(By.cssSelector("input:nth-child(5)")).click();
	    driver.findElement(By.id("j_idt6:referencia")).click();
	    driver.findElement(By.id("j_idt6:referencia")).sendKeys("5648464");
	    driver.findElement(By.id("j_idt6:titulacionAsignatura")).click();
	    driver.findElement(By.id("j_idt6:titulacionAsignatura")).sendKeys("1041");
	    driver.findElement(By.name("j_idt6:j_idt15")).click();
	    driver.findElement(By.cssSelector("ul")).click();
	    assertEquals(driver.findElement(By.cssSelector("li")).getText(), "Asignatura leida correctamente");
	    driver.findElement(By.name("j_idt6:j_idt14")).click();
	    driver.findElement(By.cssSelector("li")).click();
	    assertEquals(driver.findElement(By.cssSelector("li")).getText(), "Asignatura eliminada correctamente");
	    driver.findElement(By.name("j_idt6:j_idt15")).click();
	    driver.findElement(By.cssSelector("body")).click();
	    assertEquals(driver.findElement(By.cssSelector("li")).getText(), "No se ha podido leer la asignatura");
	    driver.findElement(By.cssSelector("input:nth-child(4)")).click();
	  }
}
