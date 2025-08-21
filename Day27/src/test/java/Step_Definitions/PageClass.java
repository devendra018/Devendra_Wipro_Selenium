package Step_Definitions;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
	By editUsernameBtn = By.cssSelector("button[id=\"individual_personal_info_address_edit_button\"]");
	By usernameField = By.cssSelector("input[name=\"firstName\"]");

	By addressSettingsLink = By.cssSelector("a[id=\"account-settings-link-ADDR\"]");
	By editShippingLink = By.cssSelector("a[aria-label=\"Edit Shipping address opens in new window or tab.\"]");
	By editAddressBtn = By.cssSelector("a[id=\"edit-address-SHIPPING\"]");
	By addressField = By.cssSelector("input[name=\"addressLine1-field\"]");
	By saveAddressBtn = By.cssSelector("button[id=\"save-address-btn\"]");
	
	By category = By.cssSelector("span[class=\"gh-categories__title\"]");
	By electronics = By.linkText("Electronics");
	By allcategories = By.cssSelector("select[class=\"gh-search-categories\"]");
	
	By US = By.cssSelector("button[aria-label=\"eBay Sites - United States - change site\"]");
	By france = By.linkText("France");

	
	public PageClass(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(20));
	}

	public void login(String username1, String password1, String status) {
		driver.get("https://signin.ebay.com/ws/eBayISAPI.dll?SignIn&sgfl=gh&ru=https%3A%2F%2Fwww.ebay.com%2F");
		wait.until(ExpectedConditions.visibilityOfElementLocated(email)).sendKeys(username1);
		driver.findElement(cont).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(password)).sendKeys(password1);
		driver.findElement(submit).click();
		
		System.out.println("Test Status : "+ status);
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
	
	public void itemtocart() throws InterruptedException {
		search();
		product();
		addToCart();
		Thread.sleep(1000);
		home();
		Thread.sleep(2000);
	}

	public void removeitem() throws InterruptedException {
		itemtocart();
		driver.findElement(cartbtn).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[data-test-id=\"cart-remove-item\"]"))).click();
	}

	public void changename() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(profileMenu)).click();
		driver.findElement(accountLink).click();
		driver.findElement(personalInfoLink).click();
		driver.findElement(editUsernameBtn).click();

		WebElement value = wait.until(ExpectedConditions.visibilityOfElementLocated(usernameField));
//		System.out.println(value.getAttribute("value"));
//		value.clear();//clear() method is not working 
//		System.out.println(value.getAttribute("value"));
		System.out.println(value.getAttribute("value"));
		value.sendKeys(Keys.CONTROL + "a"); // selecting all text and clicking delete
	    value.sendKeys(Keys.BACK_SPACE);     
	    System.out.println(value.getAttribute("value"));
		value.sendKeys("Devendra");
		System.out.println(value.getAttribute("value"));
		System.out.println(value.getAttribute("value"));
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
		search();
		WebElement product = driver.findElement(By.partialLinkText("Apple MacBook Pro 13 RETINA INTEL CORE 16GB RAM 1TB SSD"));
		String url = product.getAttribute("href");
		driver.get(url);
		WebElement producttitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class=\"ux-textspans ux-textspans--BOLD\"]/parent::h1")));
		String description = producttitle.getText();
        System.out.println("Product description: " + description);
		
	}

	public void sub_category(int index) {
		WebElement categories = driver.findElement(allcategories);
	    categories.click();
	    Select sel = new Select(categories);
	    sel.selectByIndex(index);
	    driver.findElement(By.cssSelector("button[id=\"gh-search-btn\"]")).click();
	}
	public void allcategories() {
	    sub_category(4);
	    sub_category(6);
	}

	public void language() {
	    WebElement profile = driver.findElement(US);
	    Actions lang = new Actions(driver);
	    lang.moveToElement(profile).perform();
	    driver.findElement(france).click();
	}
}
