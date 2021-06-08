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

import es.uma.informatica.sii.anotaciones.Requisitos;

public class CRUDExpedienteSuiteIT {
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

	@Requisitos({ "RF5" })
	@Test
	public void createExpedienteIT() {
		driver.get("http://localhost:8080/Secretaria-WAR/faces/gestionarEntidades.xhtml");
		driver.manage().window().setSize(new Dimension(926, 861));
		driver.findElement(By.cssSelector("input:nth-child(16)")).click();
		driver.findElement(By.id("j_idt6:numeroExpediente")).click();
		driver.findElement(By.id("j_idt6:numeroExpediente")).click();
		driver.findElement(By.id("j_idt6:numeroExpediente")).sendKeys("102474190");
		driver.findElement(By.id("j_idt6:alumnoExpediente")).sendKeys("5");
		driver.findElement(By.id("j_idt6:titulacionExpediente")).sendKeys("1041");
		driver.findElement(By.id("j_idt6:creditosCF")).sendKeys("6");
		driver.findElement(By.id("j_idt6:creditosFB")).sendKeys("6");
		driver.findElement(By.id("j_idt6:creditosMO")).sendKeys("6");
		driver.findElement(By.id("j_idt6:creditosOP")).sendKeys("6");
		driver.findElement(By.id("j_idt6:creditosPE")).sendKeys("6");
		driver.findElement(By.id("j_idt6:creditosTF")).sendKeys("6");
		driver.findElement(By.id("j_idt6:notaMediaProvisional")).sendKeys("7.00");
		driver.findElement(By.name("j_idt6:j_idt31")).click();
		driver.findElement(By.cssSelector("li")).click();
		assertEquals(driver.findElement(By.cssSelector("li")).getText(), "Expediente creado correctamente");
		driver.findElement(By.cssSelector("input:nth-child(4)")).click();
		driver.findElement(By.cssSelector("input:nth-child(17)")).click();
		driver.findElement(By.id("j_idt6:numeroExpediente")).click();
		driver.findElement(By.id("j_idt6:numeroExpediente")).sendKeys("102474190");
		driver.findElement(By.name("j_idt6:j_idt12")).click();
		driver.findElement(By.cssSelector("label:nth-child(9)")).click();
		driver.findElement(By.id("j_idt6")).click();
		assertEquals(driver.findElement(By.id("j_idt6")).getText(),
				"Expediente\nNúmero de Expediente*\n\n\n\nNúmero de Expediente: 102474190\nCódigo de la titulación: 1041\nId del alumno: 5\nActivo: 1\nCréditos CF: 6\nCréditos FB: 6\nCréditos MO: 6\nCréditos OP: 6\nCréditos PE: 6\nCréditos TF: 6\nNota media provisional: 7.0");
		driver.findElement(By.cssSelector("li")).click();
		assertEquals(driver.findElement(By.cssSelector("li")).getText(), "Expediente leido correctamente");
		driver.findElement(By.cssSelector("input:nth-child(4)")).click();
	}
	
	@Requisitos({"RF5"})
	@Test
	public void updateExpedienteIT() {
		driver.get("http://localhost:8080/Secretaria-WAR/faces/gestionarEntidades.xhtml");
		driver.manage().window().setSize(new Dimension(926, 861));
		driver.findElement(By.cssSelector("input:nth-child(17)")).click();
		driver.findElement(By.id("j_idt6:numeroExpediente")).click();
		driver.findElement(By.id("j_idt6:numeroExpediente")).sendKeys("102474113");
		driver.findElement(By.name("j_idt6:j_idt12")).click();
		driver.findElement(By.cssSelector("ul")).click();
		assertEquals(driver.findElement(By.cssSelector("li")).getText(), "Expediente leido correctamente");
		driver.findElement(By.cssSelector("input:nth-child(4)")).click();
		driver.findElement(By.cssSelector("input:nth-child(16)")).click();
		driver.findElement(By.id("j_idt6:numeroExpediente")).click();
		driver.findElement(By.id("j_idt6:numeroExpediente")).sendKeys("102474113");
		driver.findElement(By.id("j_idt6:alumnoExpediente")).sendKeys("2");
		driver.findElement(By.id("j_idt6:titulacionExpediente")).sendKeys("1041");
		driver.findElement(By.id("j_idt6:creditosCF")).sendKeys("6");
		driver.findElement(By.id("j_idt6:creditosFB")).sendKeys("0");
		driver.findElement(By.id("j_idt6:creditosMO")).sendKeys("0");
		driver.findElement(By.id("j_idt6:creditosOP")).sendKeys("0");
		driver.findElement(By.id("j_idt6:creditosPE")).sendKeys("0");
		driver.findElement(By.id("j_idt6:creditosTF")).sendKeys("0");
		driver.findElement(By.id("j_idt6:notaMediaProvisional")).sendKeys("8.2");
		driver.findElement(By.name("j_idt6:j_idt32")).click();
		driver.findElement(By.cssSelector("li")).click();
		assertEquals(driver.findElement(By.cssSelector("li")).getText(), "Expediente modificado correctamente");
	}

	@Requisitos({"RF5"})
	@Test
	public void deleteExpedienteIT() {
		driver.get("http://localhost:8080/Secretaria-WAR/faces/gestionarEntidades.xhtml");
		driver.manage().window().setSize(new Dimension(926, 861));
		driver.findElement(By.cssSelector("input:nth-child(17)")).click();
		driver.findElement(By.id("j_idt6:numeroExpediente")).click();
		driver.findElement(By.id("j_idt6:numeroExpediente")).sendKeys("102474120");
		driver.findElement(By.name("j_idt6:j_idt12")).click();
		driver.findElement(By.cssSelector("li")).click();
		assertEquals(driver.findElement(By.cssSelector("li")).getText(), "Expediente leido correctamente");
		driver.findElement(By.name("j_idt6:j_idt11")).click();
		driver.findElement(By.cssSelector("ul")).click();
		assertEquals(driver.findElement(By.cssSelector("li")).getText(), "Expediente eliminado correctamente");
		driver.findElement(By.name("j_idt6:j_idt12")).click();
		driver.findElement(By.cssSelector("li")).click();
		assertEquals(driver.findElement(By.cssSelector("li")).getText(), "No se ha podido leer el expediente");
		driver.findElement(By.cssSelector("input:nth-child(4)")).click();
	}
}
