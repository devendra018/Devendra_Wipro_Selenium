package Step_Definitions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.*;

public class AddToCart {
	WebDriver driver;
	WebDriverWait wait;

	@Given("home page should be open in default browser for cart")
	public void home_page_should_be_open_in_default_browser_for_cart() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.ebay.com/");
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	@When("click on search button and search product and then add to cart")
	public void click_on_search_button_and_search_product_and_then_add_to_cart() throws InterruptedException {
		PageClass pg = new PageClass(driver);
		pg.itemtocart();
	}

	@Then("product should add to cart")
	public void product_should_add_to_cart() throws InterruptedException {
		Thread.sleep(2000);
		driver.close();
	}

}
