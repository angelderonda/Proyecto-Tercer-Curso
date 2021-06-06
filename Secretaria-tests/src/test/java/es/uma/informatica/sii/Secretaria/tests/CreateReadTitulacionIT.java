package es.uma.informatica.sii.Secretaria.tests;

// Generated by Selenium IDE
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
public class CreateReadTitulacionIT {
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
  public void createReadTItulacionIT() {
    driver.get("http://localhost:8080/Secretaria-WAR/faces/gestionarEntidades.xhtml");
    driver.manage().window().setSize(new Dimension(1851, 861));
    driver.findElement(By.cssSelector("input:nth-child(22)")).click();
    driver.findElement(By.id("j_idt6:codigo")).click();
    driver.findElement(By.id("j_idt6:codigo")).sendKeys("1045");
    driver.findElement(By.cssSelector("div:nth-child(3)")).click();
    driver.findElement(By.id("j_idt6:nombre")).sendKeys("Telemática");
    driver.findElement(By.id("j_idt6:creditos")).click();
    driver.findElement(By.id("j_idt6:creditos")).sendKeys("240");
    driver.findElement(By.name("j_idt6:j_idt17")).click();
    driver.findElement(By.cssSelector("li")).click();
    assertEquals(driver.findElement(By.cssSelector("li")).getText(), "Titulación creada correctamente");
    driver.findElement(By.cssSelector("input:nth-child(4)")).click();
    driver.findElement(By.cssSelector("input:nth-child(23)")).click();
    driver.findElement(By.id("j_idt6:codigo")).click();
    driver.findElement(By.id("j_idt6:codigo")).sendKeys("1045");
    driver.findElement(By.name("j_idt6:j_idt12")).click();
    driver.findElement(By.id("j_idt6")).click();
    assertEquals(driver.findElement(By.id("j_idt6")).getText(), "Titulacion\nCódigo*\n\n\n\nCódigo: 1045\nNombre: Telemática\nCréditos: 240");
    driver.findElement(By.cssSelector("input:nth-child(4)")).click();
  }
}
