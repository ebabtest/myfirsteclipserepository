package pack11;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.server.handler.ImplicitlyWait;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class login {
	WebDriver driver;
  @Test
  @Parameters({ "sOrgname","sUsername", "sPassword" })
  public void f(String sOrgname,String sUsername,String sPassword) throws InterruptedException {
	 driver.findElement(By.id("txtOrgCode")).sendKeys(sOrgname);
	 driver.findElement(By.id("txtUName")).sendKeys(sUsername);
	 driver.findElement(By.id("txtUpass")).sendKeys(sPassword);
	 driver.findElement(By.xpath("//button[@id='Submit']")).click();
	  Thread.sleep(2000);
  }
  @BeforeMethod
  public void beforeMethod() {
	 System.setProperty("webdriver.chrome.driver","G://chromedriver.exe");
	 driver=new ChromeDriver();
	/* System.setProperty("webdriver.gecko.driver","G://geckodriver.exe");
	 driver=new FirefoxDriver();*/
	 driver.get("http://stage.trioblumenlab.com/");
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	 }

  @AfterMethod
  public void afterMethod() {
	  driver.close();
  }
  
}
