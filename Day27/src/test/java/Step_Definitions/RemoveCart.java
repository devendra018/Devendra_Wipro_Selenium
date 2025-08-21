package Step_Definitions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.cucumber.java.en.*;

public class RemoveCart {
	WebDriver driver;
	WebDriverWait wait;
	@Given("home page should be open in default browser for rm cart")
	public void home_page_should_be_open_in_default_browser_for_rm_cart() {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.ebay.com/");
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	@When("click on cart remove product from cart")
	public void click_on_cart_remove_product_from_cart() throws InterruptedException {
		PageClass pg = new PageClass(driver);
		pg.removeitem();
	}

	@Then("product should removed from cart")
	public void product_should_removed_from_cart() throws InterruptedException {
	   Thread.sleep(2000);
	   driver.close();
	}

}
