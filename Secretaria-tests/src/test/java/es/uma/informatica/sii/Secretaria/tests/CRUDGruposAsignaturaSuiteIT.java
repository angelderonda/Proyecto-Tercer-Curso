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
public class CRUDGruposAsignaturaSuiteIT {
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
  public void createGruposAsignaturaIT() {
    driver.get("http://localhost:8080/Secretaria-WAR/faces/gestionarEntidades.xhtml");
    driver.manage().window().setSize(new Dimension(1651, 911));
    driver.findElement(By.cssSelector("input:nth-child(13)")).click();
    driver.findElement(By.id("j_idt6:cursoAcademico")).click();
    driver.findElement(By.id("j_idt6:cursoAcademico")).sendKeys("2022");
    driver.findElement(By.id("j_idt6:titulacion")).click();
    driver.findElement(By.id("j_idt6:titulacion")).sendKeys("1041");
    driver.findElement(By.id("j_idt6:asignatura")).click();
    driver.findElement(By.id("j_idt6:asignatura")).sendKeys("564846687");
    driver.findElement(By.id("j_idt6:grupoGruposAsignatura")).click();
    driver.findElement(By.id("j_idt6:grupoGruposAsignatura")).click();
    {
      WebElement element = driver.findElement(By.id("j_idt6:grupoGruposAsignatura"));
      Actions builder = new Actions(driver);
      builder.doubleClick(element).perform();
    }
    driver.findElement(By.id("j_idt6:grupoGruposAsignatura")).sendKeys("1231546");
    driver.findElement(By.id("j_idt6:oferta")).click();
    driver.findElement(By.id("j_idt6:oferta")).click();
    {
      WebElement element = driver.findElement(By.id("j_idt6:oferta"));
      Actions builder = new Actions(driver);
      builder.doubleClick(element).perform();
    }
    driver.findElement(By.id("j_idt6:oferta")).sendKeys("1");
    driver.findElement(By.name("j_idt6:j_idt22")).click();
    driver.findElement(By.cssSelector("li")).click();
    assertThat(driver.findElement(By.cssSelector("li")).getText(), is("Grupo-asignatura creado correctamente"));
    driver.findElement(By.cssSelector("input:nth-child(4)")).click();
    driver.findElement(By.cssSelector("input:nth-child(14)")).click();
    driver.findElement(By.id("j_idt6:cursoAcademico")).click();
    driver.findElement(By.id("j_idt6:cursoAcademico")).click();
    {
      WebElement element = driver.findElement(By.id("j_idt6:cursoAcademico"));
      Actions builder = new Actions(driver);
      builder.doubleClick(element).perform();
    }
    driver.findElement(By.id("j_idt6:cursoAcademico")).sendKeys("2022");
    driver.findElement(By.id("j_idt6:titulacion")).click();
    driver.findElement(By.id("j_idt6:titulacion")).click();
    {
      WebElement element = driver.findElement(By.id("j_idt6:titulacion"));
      Actions builder = new Actions(driver);
      builder.doubleClick(element).perform();
    }
    driver.findElement(By.id("j_idt6:titulacion")).sendKeys("1041");
    driver.findElement(By.id("j_idt6:asignatura")).click();
    driver.findElement(By.id("j_idt6:asignatura")).click();
    {
      WebElement element = driver.findElement(By.id("j_idt6:asignatura"));
      Actions builder = new Actions(driver);
      builder.doubleClick(element).perform();
    }
    driver.findElement(By.id("j_idt6:asignatura")).sendKeys("564846687");
    driver.findElement(By.id("j_idt6:grupoGruposAsignatura")).click();
    driver.findElement(By.id("j_idt6:grupoGruposAsignatura")).click();
    {
      WebElement element = driver.findElement(By.id("j_idt6:grupoGruposAsignatura"));
      Actions builder = new Actions(driver);
      builder.doubleClick(element).perform();
    }
    driver.findElement(By.id("j_idt6:grupoGruposAsignatura")).sendKeys("1231546");
    driver.findElement(By.name("j_idt6:j_idt21")).click();
    driver.findElement(By.cssSelector("ul")).click();
    assertThat(driver.findElement(By.cssSelector("li")).getText(), is("Grupo-Asignatura leido correctamente"));
  }

  @Test
  public void updateGruposAsignaturaIT() {
    driver.get("http://localhost:8080/Secretaria-WAR/faces/gestionarEntidades.xhtml");
    driver.manage().window().setSize(new Dimension(1651, 911));
    driver.findElement(By.cssSelector("input:nth-child(13)")).click();
    driver.findElement(By.id("j_idt6:cursoAcademico")).click();
    driver.findElement(By.id("j_idt6:cursoAcademico")).sendKeys("2022");
    driver.findElement(By.id("j_idt6:titulacion")).click();
    driver.findElement(By.id("j_idt6:titulacion")).click();
    {
      WebElement element = driver.findElement(By.id("j_idt6:titulacion"));
      Actions builder = new Actions(driver);
      builder.doubleClick(element).perform();
    }
    driver.findElement(By.id("j_idt6:titulacion")).sendKeys("1041");
    driver.findElement(By.id("j_idt6:asignatura")).click();
    driver.findElement(By.id("j_idt6:asignatura")).click();
    {
      WebElement element = driver.findElement(By.id("j_idt6:asignatura"));
      Actions builder = new Actions(driver);
      builder.doubleClick(element).perform();
    }
    driver.findElement(By.id("j_idt6:asignatura")).sendKeys("564846687");
    driver.findElement(By.id("j_idt6:grupoGruposAsignatura")).click();
    driver.findElement(By.id("j_idt6:grupoGruposAsignatura")).click();
    {
      WebElement element = driver.findElement(By.id("j_idt6:grupoGruposAsignatura"));
      Actions builder = new Actions(driver);
      builder.doubleClick(element).perform();
    }
    driver.findElement(By.id("j_idt6:grupoGruposAsignatura")).sendKeys("1231546");
    driver.findElement(By.id("j_idt6:oferta")).click();
    driver.findElement(By.id("j_idt6:oferta")).click();
    {
      WebElement element = driver.findElement(By.id("j_idt6:oferta"));
      Actions builder = new Actions(driver);
      builder.doubleClick(element).perform();
    }
    driver.findElement(By.id("j_idt6:oferta")).sendKeys("9");
    driver.findElement(By.name("j_idt6:j_idt23")).click();
    driver.findElement(By.cssSelector("li")).click();
    assertThat(driver.findElement(By.cssSelector("li")).getText(), is("Grupo-asignatura modificado correctamente"));
    driver.findElement(By.cssSelector("input:nth-child(4)")).click();
    driver.findElement(By.cssSelector("input:nth-child(14)")).click();
    driver.findElement(By.id("j_idt6:cursoAcademico")).click();
    driver.findElement(By.id("j_idt6:cursoAcademico")).click();
    {
      WebElement element = driver.findElement(By.id("j_idt6:cursoAcademico"));
      Actions builder = new Actions(driver);
      builder.doubleClick(element).perform();
    }
    driver.findElement(By.id("j_idt6:cursoAcademico")).sendKeys("2022");
    driver.findElement(By.id("j_idt6:titulacion")).click();
    driver.findElement(By.id("j_idt6:titulacion")).click();
    {
      WebElement element = driver.findElement(By.id("j_idt6:titulacion"));
      Actions builder = new Actions(driver);
      builder.doubleClick(element).perform();
    }
    driver.findElement(By.id("j_idt6:titulacion")).sendKeys("1041");
    driver.findElement(By.id("j_idt6:asignatura")).click();
    driver.findElement(By.id("j_idt6:asignatura")).click();
    {
      WebElement element = driver.findElement(By.id("j_idt6:asignatura"));
      Actions builder = new Actions(driver);
      builder.doubleClick(element).perform();
    }
    driver.findElement(By.id("j_idt6:asignatura")).sendKeys("564846687");
    driver.findElement(By.id("j_idt6:grupoGruposAsignatura")).click();
    driver.findElement(By.id("j_idt6:grupoGruposAsignatura")).click();
    {
      WebElement element = driver.findElement(By.id("j_idt6:grupoGruposAsignatura"));
      Actions builder = new Actions(driver);
      builder.doubleClick(element).perform();
    }
    driver.findElement(By.id("j_idt6:grupoGruposAsignatura")).sendKeys("1231546");
    driver.findElement(By.name("j_idt6:j_idt21")).click();
    driver.findElement(By.cssSelector("ul")).click();
    assertThat(driver.findElement(By.cssSelector("li")).getText(), is("Grupo-Asignatura leido correctamente"));
  }


  @Test
  public void deleteGruposAsignaturaIT() {
    driver.get("http://localhost:8080/Secretaria-WAR/faces/gestionarEntidades.xhtml");
    driver.manage().window().setSize(new Dimension(1651, 911));
    driver.findElement(By.cssSelector("input:nth-child(14)")).click();
    driver.findElement(By.id("j_idt6:cursoAcademico")).click();
    driver.findElement(By.id("j_idt6:cursoAcademico")).click();
    {
      WebElement element = driver.findElement(By.id("j_idt6:cursoAcademico"));
      Actions builder = new Actions(driver);
      builder.doubleClick(element).perform();
    }
    driver.findElement(By.id("j_idt6:cursoAcademico")).sendKeys("2022");
    driver.findElement(By.id("j_idt6:titulacion")).click();
    driver.findElement(By.id("j_idt6:titulacion")).click();
    {
      WebElement element = driver.findElement(By.id("j_idt6:titulacion"));
      Actions builder = new Actions(driver);
      builder.doubleClick(element).perform();
    }
    driver.findElement(By.id("j_idt6:titulacion")).sendKeys("1041");
    driver.findElement(By.id("j_idt6:asignatura")).click();
    driver.findElement(By.id("j_idt6:asignatura")).click();
    {
      WebElement element = driver.findElement(By.id("j_idt6:asignatura"));
      Actions builder = new Actions(driver);
      builder.doubleClick(element).perform();
    }
    driver.findElement(By.id("j_idt6:asignatura")).sendKeys("564846687");
    driver.findElement(By.id("j_idt6:grupoGruposAsignatura")).click();
    driver.findElement(By.id("j_idt6:grupoGruposAsignatura")).sendKeys("1231546");
    driver.findElement(By.name("j_idt6:j_idt20")).click();
    driver.findElement(By.cssSelector("li")).click();
    assertThat(driver.findElement(By.cssSelector("li")).getText(), is("Grupo-Asignatura eliminado correctamente"));
    driver.findElement(By.name("j_idt6:j_idt21")).click();
    driver.findElement(By.cssSelector("body")).click();
    assertThat(driver.findElement(By.cssSelector("li")).getText(), is("No se ha podido leer el grupo-asignatura"));
  }

}
