package Testng_package;

import java.util.ArrayList;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageClass {
	
	WebDriver driver;
	WebDriverWait wait;

	By email = By.id("userid");
	By password = By.id("pass");
	By cont = By.id("signin-continue-btn");
	By search = By.id("gh-ac");
	By submit = By.id("sgnBt");
	By addtocart = By.linkText("Add to cart");
	By seecart = By.cssSelector("a[href=\"https://cart.ebay.com?_trksid=p4540640.m167481.l8876\"]");
	By home = By.cssSelector("div[class=\"gh-header__logo-cats-wrap\"]");
	By cartbtn = By.cssSelector("div[class=\"gh-cart\"]>div[class=\"gh-flyout is-right-aligned gh-flyout--icon-target\"]");

	By profileMenu = By.cssSelector("span[class=\"gh-my-ebay__link gh-rvi-menu\"]");
	By accountLink = By.linkText("Account");
	By personalInfoLink = By.cssSelector("a[id=\"account-settings-link-PI\"]");
	By editUsernameBtn = By.cssSelector("button[id=\"individual_username_edit_button\"]");
	By usernameField = By.cssSelector("input[name='username']");

	By addressSettingsLink = By.cssSelector("a[id=\"account-settings-link-ADDR\"]");
	By editShippingLink = By.cssSelector("a[aria-label=\"Edit Shipping address opens in new window or tab.\"]");
	By editAddressBtn = By.cssSelector("a[id=\"edit-address-SHIPPING\"]");
	By addressField = By.cssSelector("input[name=\"addressLine1-field\"]");
	By saveAddressBtn = By.cssSelector("button[id=\"save-address-btn\"]");
	
	By category = By.cssSelector("span[class=\"gh-categories__title\"]");
	By electronics = By.linkText("Electronics");
	By allcategories = By.cssSelector("select[class=\"gh-search-categories\"]");
	
	By US = By.cssSelector("button[aria-label=\"eBay Sites - United States - change site\"]");
	By china = By.linkText("China");

	public PageClass(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(15));
	}

	public void login() {
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(email)).sendKeys("devendrachowdhary805@gmail.com");
		driver.findElement(cont).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(password)).sendKeys("Devendra@0018");
		driver.findElement(submit).click();
		
//		driver.findElement(email).click();
//		driver.findElement(email).clear();
//		driver.findElement(email).sendKeys("devendrachowdhary805@gmail.com");
//		driver.findElement(cont).click();
//		driver.findElement(password).click();
//		driver.findElement(password).clear();
//		driver.findElement(password).sendKeys("Devendra@0018");
//		driver.findElement(submit).click();
	}

	public void search_in() {
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
	}

	public void search() {
		driver.findElement(search).clear();
		driver.findElement(search).sendKeys("Apple MacBook Pro 13 16GB RAM");
		driver.findElement(search).sendKeys(Keys.ENTER);
	}

	public void product() {
		WebElement product = driver.findElement(By.partialLinkText("Apple MacBook Pro 13 RETINA INTEL CORE 16GB RAM 1TB SSD"));
		String url = product.getAttribute("href");
		driver.get(url);
	}

	public void addToCart() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(addtocart)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(seecart)).click();
		
	}

	public void home() {
		driver.findElement(home).click();
	}

	public void removeitem() {
		driver.findElement(cartbtn).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[data-test-id=\"cart-remove-item\"]"))).click();
	}

	public void changename() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(profileMenu)).click();
		driver.findElement(accountLink).click();
		driver.findElement(personalInfoLink).click();
		driver.findElement(editUsernameBtn).click();

		WebElement value = driver.findElement(usernameField);
		value.clear();
		value.sendKeys("devendra018");
		value.sendKeys(Keys.ENTER);
	}

	public void changeaddress() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(profileMenu)).click();
		driver.findElement(accountLink).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(addressSettingsLink)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(editShippingLink)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(editAddressBtn)).click();

		WebElement field = wait.until(ExpectedConditions.visibilityOfElementLocated(addressField));
		field.clear();
		field.sendKeys("Aswath Nagar");

		wait.until(ExpectedConditions.elementToBeClickable(saveAddressBtn)).click();
	}
	
	public void category() {
	    driver.findElement(category).click();
	    driver.findElement(electronics).click();
	}
	
	public void desc() {
		driver.findElement(search).clear();
		driver.findElement(search).sendKeys("Apple MacBook Pro 13 16GB RAM");
		driver.findElement(search).sendKeys(Keys.ENTER);
		WebElement product = driver.findElement(By.partialLinkText("Apple MacBook Pro 13 RETINA INTEL CORE 16GB RAM 1TB SSD"));
		String url = product.getAttribute("href");
		driver.get(url);
	}

	public void allcategories() {
	    WebElement categories = driver.findElement(allcategories);
	    categories.click();
	    Select sel = new Select(categories);
	    sel.selectByIndex(4);
	    driver.findElement(By.cssSelector("button[id=\"gh-search-btn\"]")).click();

	    WebElement cat = driver.findElement(allcategories);
	    cat.click();
	    Select sel1 = new Select(cat);
	    sel1.selectByIndex(6);
	    driver.findElement(By.cssSelector("button[id=\"gh-search-btn\"]")).click();
	}

	public void language() {
	    WebElement profile = driver.findElement(US);
	    Actions lang = new Actions(driver);
	    lang.moveToElement(profile).perform();
	    driver.findElement(china).click();
	}

}
