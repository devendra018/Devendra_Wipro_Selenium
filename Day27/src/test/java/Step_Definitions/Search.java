package Step_Definitions;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.cucumber.java.en.*;

public class Search {
	WebDriver driver;
	WebDriverWait wait;
	@Given("home page should be open in default browser")
	public void home_page_should_be_open_in_default_browser() {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.ebay.com/");
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	@When("click on search button and perform search")
	public void click_on_search_button_and_perform_search() {
	    PageClass pg = new PageClass(driver);
	    pg.search_in();
	}

	@Then("results should be shown")
	public void results_should_be_shown() throws InterruptedException {
		Thread.sleep(2000);
		driver.close();
	}

}
