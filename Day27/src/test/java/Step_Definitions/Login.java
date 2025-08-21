package Step_Definitions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.cucumber.java.en.*;

public class Login {
	WebDriver driver;
	WebDriverWait wait;
	@Given("login page should be open in default browser")
	public void login_page_should_be_open_in_default_browser() {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.ebay.com/");
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	}

	@When("click on username button and enter (.*) and (.*) and click signin button and check (.*)$")
	public void click_on_username_button_and_enter_username_and_password_and_click_signin_button(String username1, String password1, String status) {
	    PageClass pg = new PageClass(driver);
	    pg.login(username1,password1, status);
	}

	@Then("login successfully and open home page")
	public void login_successfully_and_open_home_page() throws InterruptedException {
	   Thread.sleep(2000);
	   driver.close();
	}

}
