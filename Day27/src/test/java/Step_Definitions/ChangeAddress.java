package Step_Definitions;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.*;

public class ChangeAddress {
	WebDriver driver;
	WebDriverWait wait;
	@Given("home page should be open in default browser for address")
	public void home_page_should_be_open_in_default_browser_for_address() {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.ebay.com/");
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	@When("click on profile and click account and click address and click shipping addresses and click edit address and enter fields and save")
	public void click_on_profile_and_click_account_and_click_address_and_click_shipping_addresses_and_click_edit_address_and_enter_fields_and_save() {
		PageClass pg = new PageClass(driver);
		pg.login("devendrachowdhary805@gmail.com", "Devendra@0018", "success");
		pg.changeaddress();
	}

	@Then("address should be updated")
	public void address_should_be_updated() throws InterruptedException {
	    Thread.sleep(2000);
	    driver.close();
	}

}
