package Step_Definitions;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.*;

public class ChangeName {
	WebDriver driver;
	WebDriverWait wait;
	@Given("home page should be open in default browser for name change")
	public void home_page_should_be_open_in_default_browser_for_name_change() {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.ebay.com/");
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	@When("click on profile and click account and click personal info and click edit username and enter username and save")
	public void click_on_profile_and_click_account_and_click_personal_info_and_click_edit_username_and_enter_username_and_save() {
		PageClass pg = new PageClass(driver);
		pg.login("devendrachowdhary805@gmail.com", "Devendra@0018", "success");
		pg.changename();
	}

	@Then("username should be updated")
	public void username_should_be_updated() throws InterruptedException {
	    Thread.sleep(2000);
	    driver.close();
	}
}
