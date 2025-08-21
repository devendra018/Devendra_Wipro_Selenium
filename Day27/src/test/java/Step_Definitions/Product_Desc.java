package Step_Definitions;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.cucumber.java.en.*;

public class Product_Desc {
	WebDriver driver;
	WebDriverWait wait;
	@Given("home page should be open in default browser for producr desc")
	public void home_page_should_be_open_in_default_browser_for_producr_desc() {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.ebay.com/");
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	@When("click on search button and perform search and click on product and get the description")
	public void click_on_search_button_and_perform_search_and_click_on_product_and_get_the_description() {
		PageClass pg = new PageClass(driver);
		pg.desc();
	}

	@Then("product description should printed")
	public void product_description_should_printed() throws InterruptedException {
	    Thread.sleep(2000);
	    driver.close();
	}

}
