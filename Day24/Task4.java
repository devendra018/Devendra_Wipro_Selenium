package Testng_package;


/* 
4. Write dependent test cases:

login()

search Product() (depends on login)

logout() (depends on search)
 */


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Task4 {
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
	  
	
	 @Test(dependsOnMethods = {"login"})
	  public void product() {
		  PageClass pg = new PageClass(driver);
		  pg.search();
	  }
	  
	  
	  @Test(dependsOnMethods = {"login"})
	  public void logout() {
		  WebElement greeting = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.gh-identity__greeting")));
	      actions.moveToElement(greeting).perform();

	      WebElement signOut =  wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Sign out")));
	      signOut.click();
	  }
}
