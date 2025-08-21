package Step_Definitions;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.cucumber.java.en.*;

public class Category {
	WebDriver driver;
	WebDriverWait wait;
	@Given("home page should be open in default browser for cat")
	public void home_page_should_be_open_in_default_browser_for_cat() {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.ebay.com/");
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	@When("click on category and select sub category and click enter")
	public void click_on_category_and_select_sub_category_and_click_enter() {
		PageClass pg = new PageClass(driver);
		  pg.category();
	}

	@Then("selected category should be shown")
	public void selected_category_should_be_shown() throws InterruptedException {
	    Thread.sleep(2000);
	    driver.close();
	}
}
