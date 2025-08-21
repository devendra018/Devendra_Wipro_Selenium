package Step_Definitions;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.*;

public class AllCategories {
	WebDriver driver;
	WebDriverWait wait;
	@Given("home page should be open in default browser for all cat")
	public void home_page_should_be_open_in_default_browser_for_all_cat() {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.ebay.com/");
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	@When("click on all category and select sub category and again click sub category")
	public void click_on_all_category_and_select_sub_category_and_again_click_sub_category() {
		PageClass pg = new PageClass(driver);
		pg.allcategories();
	}

	@Then("selected sub category should be shown")
	public void selected_sub_category_should_be_shown() throws InterruptedException {
	    Thread.sleep(2000);
	    driver.close();
	}
}
