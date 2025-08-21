package Step_Definitions;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.cucumber.java.en.*;

public class Language {
	WebDriver driver;
	WebDriverWait wait;

	@Given("home page should be open in default browser for lang")
	public void home_page_should_be_open_in_default_browser_for_lang() {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.ebay.com/");
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	@When("hover on us country flag and click the country")
	public void hover_on_us_country_flag_and_click_the_country() {
		PageClass pg = new PageClass(driver);
		pg.language();
	}

	@Then("language should be shown")
	public void language_should_be_shown() throws InterruptedException {
		Thread.sleep(2000);
		driver.close();
	}
}
