package Testng_package;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

public class Ebay_POM {
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
  @Test(priority = 1)
  public void login() throws InterruptedException {
	 driver.get("https://signin.ebay.com/ws/eBayISAPI.dll?SignIn&sgfl=gh&ru=https%3A%2F%2Fwww.ebay.com%2F");
	 PageClass pg = new PageClass(driver);
	 pg.login();
  }
  
  
  @Test(priority = 4)
  public void search() throws InterruptedException {
	  PageClass pg = new PageClass(driver);
	  pg.search_in();
	  pg.home();
	  Thread.sleep(2000);
  }

  @Test(priority = 5)
  public void cart() throws InterruptedException {
	  PageClass pg = new PageClass(driver);
	  pg.search();
	  pg.product();
	  pg.addToCart();
	  Thread.sleep(1000);
	  pg.home();
	  Thread.sleep(2000);
  }
  
  @Test(priority = 6)
  public void remove() throws InterruptedException {
	  PageClass pg = new PageClass(driver);
	  pg.removeitem();
	  Thread.sleep(2000);
  }
  
  @Test(priority = 2)
  public void changename() throws InterruptedException {
	  PageClass pg = new PageClass(driver);
	  pg.changename();
	  Thread.sleep(1000);
  }

  @Test(priority = 3)
  public void changeaddress() throws InterruptedException {
	  PageClass pg = new PageClass(driver);
	  pg.changeaddress();
	  pg.home();
	  Thread.sleep(2000);
  }
 
  @Test(priority = 7)
  public void category() throws InterruptedException {
	  PageClass pg = new PageClass(driver);
	  pg.category();
	  pg.home();
	  Thread.sleep(2000);
  }
  
  @Test(priority = 8)
  public void selectproduct() throws InterruptedException{
	  PageClass pg = new PageClass(driver);
	  pg.desc();
	  pg.home();
	  Thread.sleep(2000);
  }
  
  @Test(priority = 9)
  public void allcategories() throws InterruptedException {
	  PageClass pg = new PageClass(driver);
	  pg.allcategories();
	  pg.home();
	  Thread.sleep(2000);
  }
  
  @Test(priority = 10)
  public void language() throws InterruptedException {
	  PageClass pg = new PageClass(driver);
	  pg.language();
  }
  
  
  @AfterTest
  public void afterTest() throws InterruptedException {
  }

}
