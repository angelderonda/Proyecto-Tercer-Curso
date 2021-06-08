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
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;
public class CRUDMatriculaSuiteIT {
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
  public void createMatriculaIT() {
    driver.get("http://localhost:8080/Secretaria-WAR/faces/gestionarEntidades.xhtml");
    driver.manage().window().setSize(new Dimension(810, 891));
    driver.findElement(By.cssSelector("body")).click();
    driver.findElement(By.cssSelector("input:nth-child(19)")).click();
    driver.findElement(By.id("j_idt6:cursoAcademico")).click();
    driver.findElement(By.id("j_idt6:cursoAcademico")).sendKeys("2022");
    {
      WebElement element = driver.findElement(By.id("j_idt6:expediente"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).clickAndHold().perform();
    }
    {
      WebElement element = driver.findElement(By.id("j_idt6:expediente"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }
    {
      WebElement element = driver.findElement(By.id("j_idt6:expediente"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).release().perform();
    }
    driver.findElement(By.id("j_idt6:expediente")).click();
    driver.findElement(By.id("j_idt6:expediente")).sendKeys("102474112");
    driver.findElement(By.id("j_idt6:turno")).click();
    driver.findElement(By.id("j_idt6:turno")).sendKeys("Tarde");
    driver.findElement(By.id("j_idt6:archivo")).click();
    driver.findElement(By.id("j_idt6:archivo")).sendKeys("123456");
    driver.findElement(By.name("j_idt6:j_idt20")).click();
    driver.findElement(By.cssSelector("li")).click();
    assertThat(driver.findElement(By.cssSelector("li")).getText(), is("Matricula creada correctamente"));
    driver.findElement(By.cssSelector("input:nth-child(4)")).click();
    driver.findElement(By.cssSelector("input:nth-child(20)")).click();
    driver.findElement(By.id("j_idt6:cursoAcademico")).click();
    driver.findElement(By.id("j_idt6:cursoAcademico")).sendKeys("2022");
    driver.findElement(By.id("j_idt6:expediente")).click();
    driver.findElement(By.id("j_idt6:expediente")).sendKeys("102474112");
    driver.findElement(By.name("j_idt6:j_idt15")).click();
    driver.findElement(By.cssSelector("body")).click();
    assertThat(driver.findElement(By.cssSelector("li")).getText(), is("Matricula leida correctamente"));
  }

@Test
  public void updateMatriculaIT() {
    driver.get("http://localhost:8080/Secretaria-WAR/faces/gestionarEntidades.xhtml");
    driver.manage().window().setSize(new Dimension(810, 891));
    driver.findElement(By.cssSelector("input:nth-child(19)")).click();
    driver.findElement(By.id("j_idt6:cursoAcademico")).click();
    driver.findElement(By.id("j_idt6:cursoAcademico")).sendKeys("2022");
    driver.findElement(By.id("j_idt6:expediente")).click();
    driver.findElement(By.id("j_idt6:expediente")).sendKeys("102474112");
    driver.findElement(By.id("j_idt6:turno")).click();
    driver.findElement(By.id("j_idt6:turno")).sendKeys("Mañana");
    driver.findElement(By.id("j_idt6:archivo")).click();
    driver.findElement(By.id("j_idt6:archivo")).sendKeys("123456");
    driver.findElement(By.name("j_idt6:j_idt21")).click();
    driver.findElement(By.cssSelector("ul")).click();
    assertThat(driver.findElement(By.cssSelector("li")).getText(), is("Matricula modificada correctamente"));
    driver.findElement(By.cssSelector("input:nth-child(4)")).click();
    driver.findElement(By.cssSelector("input:nth-child(20)")).click();
    driver.findElement(By.id("j_idt6:cursoAcademico")).click();
    driver.findElement(By.id("j_idt6:cursoAcademico")).sendKeys("2022");
    driver.findElement(By.id("j_idt6:expediente")).click();
    driver.findElement(By.id("j_idt6:expediente")).click();
    {
      WebElement element = driver.findElement(By.id("j_idt6:expediente"));
      Actions builder = new Actions(driver);
      builder.doubleClick(element).perform();
    }
    driver.findElement(By.id("j_idt6:expediente")).sendKeys("102474112");
    driver.findElement(By.name("j_idt6:j_idt15")).click();
    driver.findElement(By.cssSelector("ul")).click();
    assertThat(driver.findElement(By.cssSelector("li")).getText(), is("Matricula leida correctamente"));
  }

@Test
  public void deleteMatriculaIT() {
    driver.get("http://localhost:8080/Secretaria-WAR/faces/gestionarEntidades.xhtml");
    driver.manage().window().setSize(new Dimension(810, 891));
    driver.findElement(By.cssSelector("input:nth-child(20)")).click();
    driver.findElement(By.id("j_idt6:cursoAcademico")).click();
    driver.findElement(By.id("j_idt6:cursoAcademico")).sendKeys("2022");
    driver.findElement(By.id("j_idt6:expediente")).click();
    driver.findElement(By.id("j_idt6:expediente")).sendKeys("102474112");
    driver.findElement(By.name("j_idt6:j_idt14")).click();
    driver.findElement(By.cssSelector("li")).click();
    assertThat(driver.findElement(By.cssSelector("li")).getText(), is("Matricula eliminada correctamente"));
    driver.findElement(By.name("j_idt6:j_idt15")).click();
    driver.findElement(By.cssSelector("li")).click();
    assertThat(driver.findElement(By.cssSelector("li")).getText(), is("No se ha podido leer la Matricula"));
    driver.findElement(By.cssSelector("body")).click();
  }

}
