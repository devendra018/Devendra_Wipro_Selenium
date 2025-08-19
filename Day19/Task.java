package Day20_assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task {
	public static void loginStep(WebDriver driver, String user1, String pass1, String testexecution)
			throws InterruptedException {

		driver.manage().window().maximize();

		System.out.println("Manual Test : " + testexecution);

		Thread.sleep(1000);
		WebElement user = driver.findElement(By.id("user-name"));
		user.sendKeys(user1);

		Thread.sleep(1000);
		WebElement pass = driver.findElement(By.id("password"));
		pass.sendKeys(pass1);

		Thread.sleep(1000);
		driver.findElement(By.id("login-button")).click();
		Thread.sleep(3000);

	}

	public static void addToCart(WebDriver driver, String firstName1, String lastName1, String postalCode1,
			String testexecution) throws InterruptedException {

		System.out.println("Manual Test : " + testexecution);

		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"item_1_title_link\"]/div")).click();
		driver.findElement(By.name("add-to-cart")).click();

		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a")).click();
		driver.findElement(By.id("checkout")).click();

		Thread.sleep(1000);
		WebElement firstName = driver.findElement(By.id("first-name"));
		firstName.sendKeys(firstName1);

		Thread.sleep(1000);
		WebElement lastName = driver.findElement(By.id("last-name"));
		lastName.sendKeys(lastName1);

		Thread.sleep(1000);
		WebElement postalCode = driver.findElement(By.id("postal-code"));
		postalCode.sendKeys(postalCode1);

		Thread.sleep(1000);
		driver.findElement(By.id("continue")).click();

		Thread.sleep(1000);
		driver.findElement(By.id("finish")).click();

		Thread.sleep(2000);

	}

	public static void logoutPage(WebDriver driver, String testexecution) throws InterruptedException {
		System.out.println("Manual Test : " + testexecution);

		driver.findElement(By.xpath("//*[@id=\"react-burger-menu-btn\"]")).click();

		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"logout_sidebar_link\"]")).click();

	}

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");

		loginStep(driver, "standard_user", "secret_sauce", "login");

		addToCart(driver, "virat", "kohli", "560037", "adding to cart");

		logoutPage(driver, "logout");

	}
}
