package Testng_package;

//---------------------------------
//Create testing class
//Project URL= https://www.ebay.com/
//Add pre-requisite
//Create 10 testcases for
//1.Login
//2.Multiple searches using array list or array
//3.Add to cart
//4.delete from cart
//5.Change login name
//6. change current address
//7.shop by categories
//8.select particular product right click on that product image and find out description of that product.
//9.shop by all categories and check whether this function is working fine or not
//10. change the language of your application using setting
//
//Create Post condition for every testcase

//-----------------------------


import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

public class TestNg_ebay {
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
	 WebElement signin = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Sign in")));
	 signin.click();
	 
	 WebElement username = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("userid")));
	 username.sendKeys("devendrachowdhary805@gmail.com");
	 username.sendKeys(Keys.ENTER);

	 WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pass")));
	 password.sendKeys("Devendra@018");
	 password.sendKeys(Keys.ENTER);
  }
  
  
  @Test(priority = 4)
  public void search() throws InterruptedException {
	  WebElement searchBox;
	  ArrayList<String> products = new ArrayList<>();
      products.add("Watch");
      products.add("Laptop");
      products.add("Phone");

      for (String product : products) {
          searchBox = driver.findElement(By.id("gh-ac"));
          searchBox.clear();
          searchBox.sendKeys(product);
          searchBox.sendKeys(Keys.ENTER);
      }
      Thread.sleep(1000);
      
  }

  
  @Test(priority = 5)
  public void cart() throws InterruptedException {
	  WebElement searchBox = driver.findElement(By.id("gh-ac"));
	  searchBox.sendKeys("Apple MacBook Pro 13 16GB RAM");
	  searchBox.sendKeys(Keys.ENTER);
	  WebElement product = driver.findElement(By.partialLinkText("Apple MacBook Pro 13 RETINA INTEL CORE 16GB RAM 1TB SSD"));
	  String url = product.getAttribute("href");
	  driver.get(url);
	  WebElement cartbtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Add to cart")));
	  cartbtn.sendKeys(Keys.ENTER);
	  WebElement seecart = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("See in cart")));
	  seecart.sendKeys(Keys.ENTER);
	  
	  driver.findElement(By.cssSelector("div[class=\"gh-header__logo-cats-wrap\"]")).click();
	  Thread.sleep(1000);
  }
  
  @Test(priority = 6)
  public void remove() throws InterruptedException {
	  driver.findElement(By.cssSelector("div[class=\"gh-cart\"]>div[class=\"gh-flyout is-right-aligned gh-flyout--icon-target\"]")).click();
	  WebElement rmcart = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[data-test-id=\"cart-remove-item\"]")));
	  rmcart.sendKeys(Keys.ENTER);
	  Thread.sleep(1000);
	  driver.findElement(By.cssSelector("div[class=\"gh-header__logo-cats-wrap\"]")).click();
	  Thread.sleep(1000);
  }
  
  @Test(priority = 2)
  public void changename() throws InterruptedException {
      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

      WebElement profile = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span[class=\"gh-my-ebay__link gh-rvi-menu\"]"))); 
      profile.click();

      WebElement acc = driver.findElement(By.linkText("Account"));
      acc.click();

      WebElement info = driver.findElement(By.cssSelector("a[id=\"account-settings-link-PI\"]"));
      info.click();

      WebElement edit = driver.findElement(By.cssSelector("button[id=\"individual_username_edit_button\"]"));
      edit.click();

      WebElement value = driver.findElement(By.cssSelector("input[name='username']"));
      value.clear();
      value.sendKeys("devendra-0018");
      value.sendKeys(Keys.ENTER);

      driver.findElement(By.cssSelector("div[class=\"gh-header__logo-cats-wrap\"]")).click();
	  Thread.sleep(1000);
  }

  @Test(priority = 3)
  public void changeaddress() throws InterruptedException {
      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

      WebElement profile = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span[class=\"gh-my-ebay__link gh-rvi-menu\"]"))); 
      profile.click();

      WebElement acc = driver.findElement(By.linkText("Account"));
      acc.click();

      WebElement info = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[id=\"account-settings-link-ADDR\"]")));
      info.click();

      WebElement address = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[aria-label=\"Edit Shipping address opens in new window or tab.\"]")));
      address.click();
      
      WebElement edit = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[id=\"edit-address-SHIPPING\"]")));
      edit.click();

      WebElement field = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[name=\"addressLine1-field\"]")));
      field.clear();
      field.sendKeys("Aswath Nagar");

      WebElement submit = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[id=\"save-address-btn\"]")));
      submit.click();

      driver.findElement(By.cssSelector("div[class=\"gh-header__logo-cats-wrap\"]")).click();
	  Thread.sleep(1000);
  }

  
 
  @Test(priority = 7)
  public void category() throws InterruptedException {
      driver.findElement(By.cssSelector("span[class=\"gh-categories__title\"]")).click();
      wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Electronics"))).click();
      Thread.sleep(1000);
  }
  
  @Test(priority = 8)
  public void selectproduct() throws InterruptedException{
	  WebElement searchBox = driver.findElement(By.id("gh-ac"));
	  searchBox.sendKeys("Apple MacBook Pro 13 16GB RAM");
	  searchBox.sendKeys(Keys.ENTER);
	  WebElement img = driver.findElement(By.cssSelector("img[alt=\" Apple MacBook Pro 13 RETINA INTEL CORE 16GB RAM 1TB SSD\"]"));
	  Actions actions = new Actions(driver);
	  actions.contextClick(img).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
	  Thread.sleep(1000);
  }
  
  @Test(priority = 9)
  public void allcategories() throws InterruptedException {
	  WebElement categories = driver.findElement(By.cssSelector("select[class=\"gh-search-categories\"]"));
	  categories.sendKeys(Keys.ENTER);
	  Select sel = new Select(categories);
	  sel.selectByIndex(4);
	  WebElement search = driver.findElement(By.cssSelector("button[id=\"gh-search-btn\"]"));
	  search.sendKeys(Keys.ENTER);
	  
	  WebElement cat = driver.findElement(By.cssSelector("select[class=\"gh-search-categories\"]"));
	  cat.click();
	  Select sel1= new Select(cat);
	  sel1.selectByIndex(6);
	  driver.findElement(By.cssSelector("button[id=\"gh-search-btn\"]")).click();
	  Thread.sleep(1000);
  }
  
  @Test(priority = 10)
  public void language() throws InterruptedException {
	  
	  WebElement profile = driver.findElement(By.cssSelector("button[aria-label=\"eBay Sites - United States - change site\"]"));
      Actions lang = new Actions(driver);
      lang.moveToElement(profile).perform();
      wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("China"))).click();
      Thread.sleep(4000);
  }
  
  
  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}
