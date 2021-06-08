package es.uma.informatica.sii.Secretaria.tests;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import es.uma.informatica.sii.anotaciones.Requisitos;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;

public class ListarSuiteIT {
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

	@Requisitos({"RF11"})
	@Test
	public void listarSuiteIT() {
		driver.get("http://0.0.0.0:8080/Secretaria-WAR/faces/listarAlumno.xhtml");
		driver.manage().window().setSize(new Dimension(810, 881));
		driver.findElement(By.name("listaForm:j_idt8")).click();
		{
			WebElement dropdown = driver.findElement(By.name("listaForm:j_idt10"));
			dropdown.findElement(By.xpath("//option[. = 'Todos']")).click();
		}
		{
			WebElement element = driver.findElement(By.name("listaForm:j_idt10"));
			Actions builder = new Actions(driver);
			builder.moveToElement(element).clickAndHold().perform();
		}
		{
			WebElement element = driver.findElement(By.name("listaForm:j_idt10"));
			Actions builder = new Actions(driver);
			builder.moveToElement(element).perform();
		}
		{
			WebElement element = driver.findElement(By.name("listaForm:j_idt10"));
			Actions builder = new Actions(driver);
			builder.moveToElement(element).release().perform();
		}
		driver.findElement(By.name("listaForm:j_idt10")).click();
		driver.findElement(By.name("listaForm:j_idt17")).click();
		driver.findElement(By.cssSelector(".volver")).click();
	}
}
