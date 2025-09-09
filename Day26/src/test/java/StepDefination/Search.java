package StepDefination;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;

public class Search {
	WebDriver driver;
	@Given("home page should be open in default browser")
	public void home_page_should_be_open_in_default_browser() {
		driver = new ChromeDriver();
		driver.get("http://zero.webappsecurity.com/index.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@When("^enter (.*) and click enter$")
	public void enter_service_and_click_enter(String service1) {
		PageClass pg = new PageClass(driver);
		pg.search(service1);
	}

	@Then("results should be displayed")
	public void results_should_be_displayed() throws InterruptedException {
		Thread.sleep(2000);
	   driver.close();
	}
}
