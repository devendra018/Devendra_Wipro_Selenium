package Testng_package;


/* 
 1. Create 2 test cases, disable one using enabled = false, and run only the active test.
 */


import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Task1 {
	WebDriver driver;
	WebDriverWait wait;
	Actions actions;
	@BeforeTest
	  public void beforeTest() throws InterruptedException {
		  	driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://www.ebay.com/");
			wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        actions = new Actions(driver);
	  }
	@Test()
	  public void login() throws InterruptedException {
		 driver.get("https://signin.ebay.com/ws/eBayISAPI.dll?SignIn&sgfl=gh&ru=https%3A%2F%2Fwww.ebay.com%2F");
		 PageClass pg = new PageClass(driver);
		 pg.login();
	  }
	  
  @Test(enabled = false)
  public void changename() throws InterruptedException {
	  PageClass pg = new PageClass(driver);
	  pg.changename();
	  Thread.sleep(1000);
  }

  @Test()
  public void changeaddress() throws InterruptedException {
	  PageClass pg = new PageClass(driver);
	  pg.changeaddress();
	  pg.home();
	  Thread.sleep(2000);
  }
}
