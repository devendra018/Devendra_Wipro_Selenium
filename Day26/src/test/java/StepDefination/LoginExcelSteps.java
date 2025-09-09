package StepDefination;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.*;

import io.cucumber.java.en.Given;

public class LoginExcelSteps {

	WebDriver driver;

	@Given("user logs in using rows")
	public void user_logs_in_using_rows() {
		String filePath = "src/test/resources/testdata/LoginData.xlsx";
		String sheetName = "Sheet1";

		List<List<String>> sheetData = ExcelReader.getSheetData(filePath, sheetName);
		for (int i = 1; i < sheetData.size(); i++) {
			String username = sheetData.get(i).get(0);
			String password = sheetData.get(i).get(1);

			System.out.println("Username: " + username + " | Password: " + password);

			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get("http://zero.webappsecurity.com/login.html");

			driver.findElement(By.id("user_login")).sendKeys(username);
			driver.findElement(By.id("user_password")).sendKeys(password);
			driver.findElement(By.name("submit")).click();
			
			if(i < sheetData.size() - 1) {
				String result = driver.findElement(By.cssSelector("[class=\"alert alert-error\"]")).getText();
				if(result.isEmpty()) {
					System.out.println("Login successful");
				} else {
					System.out.println("Error : " + result);
				}
			}
			driver.close();
		}
	}
}