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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CRUDGrupoSuiteIT {
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
	  public void createGrupoIT() {
	    driver.get("http://localhost:8080/Secretaria-WAR/faces/gestionarEntidades.xhtml");
	    driver.manage().window().setSize(new Dimension(926, 861));
	    driver.findElement(By.cssSelector("input:nth-child(10)")).click();
	    driver.findElement(By.id("j_idt6:id")).click();
	    driver.findElement(By.id("j_idt6:id")).sendKeys("1234567");
	    driver.findElement(By.id("j_idt6:curso")).click();
	    driver.findElement(By.id("j_idt6:curso")).sendKeys("1");
	    driver.findElement(By.id("j_idt6:ingles")).click();
	    driver.findElement(By.id("j_idt6:ingles")).sendKeys("0");
	    driver.findElement(By.id("j_idt6:letra")).click();
	    driver.findElement(By.id("j_idt6:letra")).sendKeys("C");
	    driver.findElement(By.id("j_idt6:plaza")).click();
	    driver.findElement(By.id("j_idt6:plaza")).sendKeys("36");
	    driver.findElement(By.id("j_idt6:turno")).click();
	    driver.findElement(By.id("j_idt6:turno")).sendKeys("Mañana");
	    driver.findElement(By.id("j_idt6:visible")).click();
	    driver.findElement(By.id("j_idt6:visible")).sendKeys("1");
	    driver.findElement(By.id("j_idt6:titulacion")).click();
	    driver.findElement(By.id("j_idt6:titulacion")).sendKeys("1041");
	    driver.findElement(By.id("j_idt6:asignar")).click();
	    driver.findElement(By.id("j_idt6:asignar")).sendKeys("Si");
	    driver.findElement(By.name("j_idt6:j_idt34")).click();
	    driver.findElement(By.cssSelector("li")).click();
	    assertEquals(driver.findElement(By.cssSelector("li")).getText(), "Grupo creado correctamente");
	    driver.findElement(By.cssSelector("input:nth-child(4)")).click();
	    driver.findElement(By.cssSelector("input:nth-child(11)")).click();
	    driver.findElement(By.id("j_idt6:id")).click();
	    driver.findElement(By.id("j_idt6:id")).sendKeys("1234567");
	    driver.findElement(By.name("j_idt6:j_idt12")).click();
	    driver.findElement(By.cssSelector("html")).click();
	    assertEquals(driver.findElement(By.id("j_idt6")).getText(), "Grupo\nId*\n\n\n\nId: 1234567\nAsignar: Si\nCurso: 1\nInglés: 0\nLetra: C\nPlazas: 36\nTurno: Mañana\nVisible: 1\nTitulación: 1041");
	    driver.findElement(By.cssSelector("body")).click();
	    assertEquals(driver.findElement(By.cssSelector("li")).getText(), "Grupo leido correctamente");
	    driver.findElement(By.cssSelector("input:nth-child(4)")).click();
	  }
	  
	  @Test
	  public void updateGrupoIT() {
	    driver.get("http://localhost:8080/Secretaria-WAR/faces/gestionarEntidades.xhtml");
	    driver.manage().window().setSize(new Dimension(926, 861));
	    driver.findElement(By.cssSelector("input:nth-child(10)")).click();
	    driver.findElement(By.id("j_idt6:id")).click();
	    driver.findElement(By.id("j_idt6:id")).sendKeys("1231546");
	    driver.findElement(By.id("j_idt6:curso")).click();
	    driver.findElement(By.id("j_idt6:curso")).sendKeys("1");
	    driver.findElement(By.id("j_idt6:ingles")).click();
	    driver.findElement(By.id("j_idt6:ingles")).sendKeys("1");
	    driver.findElement(By.id("j_idt6:letra")).click();
	    driver.findElement(By.id("j_idt6:letra")).sendKeys("A");
	    driver.findElement(By.id("j_idt6:plaza")).click();
	    driver.findElement(By.id("j_idt6:plaza")).sendKeys("25");
	    driver.findElement(By.id("j_idt6:turno")).click();
	    driver.findElement(By.id("j_idt6:turno")).sendKeys("Mañana");
	    driver.findElement(By.id("j_idt6:visible")).click();
	    {
	      WebElement element = driver.findElement(By.id("j_idt6:visible"));
	      Actions builder = new Actions(driver);
	      builder.doubleClick(element).perform();
	    }
	    driver.findElement(By.id("j_idt6:visible")).sendKeys("1");
	    driver.findElement(By.id("j_idt6:titulacion")).click();
	    driver.findElement(By.id("j_idt6:titulacion")).sendKeys("1041");
	    driver.findElement(By.id("j_idt6:asignar")).click();
	    driver.findElement(By.id("j_idt6:asignar")).sendKeys("Si");
	    driver.findElement(By.name("j_idt6:j_idt35")).click();
	    driver.findElement(By.cssSelector("ul")).click();
	    assertEquals(driver.findElement(By.cssSelector("li")).getText(), "Grupo modificado correctamente");
	    driver.findElement(By.cssSelector("input:nth-child(4)")).click();
	    driver.findElement(By.cssSelector("input:nth-child(11)")).click();
	    driver.findElement(By.id("j_idt6:id")).click();
	    driver.findElement(By.id("j_idt6:id")).sendKeys("1231546");
	    driver.findElement(By.name("j_idt6:j_idt12")).click();
	    driver.findElement(By.cssSelector("html")).click();
	    assertEquals(driver.findElement(By.id("j_idt6")).getText(), "Grupo\nId*\n\n\n\nId: 1231546\nAsignar: Si\nCurso: 1\nInglés: 1\nLetra: A\nPlazas: 25\nTurno: Mañana\nVisible: 1\nTitulación: 1041");
	    driver.findElement(By.cssSelector("body")).click();
	    assertEquals(driver.findElement(By.cssSelector("li")).getText(), "Grupo leido correctamente");
	    driver.findElement(By.cssSelector("input:nth-child(4)")).click();
	  }
	  
	  @Test
	  public void deleteGrupoIT() {
	    driver.get("http://localhost:8080/Secretaria-WAR/faces/gestionarEntidades.xhtml");
	    driver.manage().window().setSize(new Dimension(926, 861));
	    driver.findElement(By.cssSelector("input:nth-child(11)")).click();
	    driver.findElement(By.id("j_idt6:id")).click();
	    driver.findElement(By.id("j_idt6:id")).sendKeys("1234567");
	    driver.findElement(By.name("j_idt6:j_idt12")).click();
	    driver.findElement(By.id("j_idt6")).click();
	    assertEquals(driver.findElement(By.id("j_idt6")).getText(), "Grupo\nId*\n\n\n\nId: 1234567\nAsignar: Si\nCurso: 1\nInglés: 0\nLetra: C\nPlazas: 36\nTurno: Mañana\nVisible: 1\nTitulación: 1041");
	    driver.findElement(By.cssSelector("ul")).click();
	    assertEquals(driver.findElement(By.cssSelector("li")).getText(), "Grupo leido correctamente");
	    driver.findElement(By.name("j_idt6:j_idt11")).click();
	    driver.findElement(By.cssSelector("li")).click();
	    assertEquals(driver.findElement(By.cssSelector("li")).getText(), "Grupo eliminado correctamente");
	    driver.findElement(By.cssSelector("input:nth-child(4)")).click();
	  }
	  
}
