package Testng_package;


/* 
 2. Write a test to run the same test multiple times.
 */


import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Task2 {
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
	 @Test(invocationCount  = 2)
	  public void search() throws InterruptedException {
		  PageClass pg = new PageClass(driver);
		  pg.search_in();
		  pg.home();
		  Thread.sleep(2000);
		  
		  //by using for loop
		  for(int i = 0; i <2; i++) {
			  pg.search_in();
			  pg.home();
			  Thread.sleep(2000);
		  }
	  }
	  
}
