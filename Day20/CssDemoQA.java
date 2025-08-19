package Sele_package;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class CssDemoQA {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/automation-practice-form");
		Thread.sleep(5000);
		
		WebElement fname = driver.findElement(By.cssSelector("div>input[placeholder=\"First Name\"]"));
		fname.sendKeys("Virat");
		
		WebElement lname = driver.findElement(By.cssSelector("div>input[placeholder=\"Last Name\"]"));
		lname.sendKeys("Kohli");
		
		WebElement email = driver.findElement(By.cssSelector("div>input[placeholder=\"name@example.com\"]"));
		email.sendKeys("virat@gmail.com");
		
        driver.findElement(By.cssSelector("label[for='gender-radio-1']")).click();
		
		WebElement phone = driver.findElement(By.cssSelector("div>input[placeholder=\"Mobile Number\"]"));
		phone.sendKeys("1234567890");
		
		
		
//		driver.findElement(By.id("dateOfBirthInput")).click();
//		driver.findElement(By.cssSelector("#dateOfBirthInput")).click();
		driver.findElement(By.cssSelector("div>input[id=\"dateOfBirthInput\"]")).click();
		
		
		driver.findElement(By.cssSelector("select>option[value=\"2025\"]")).click();
		driver.findElement(By.cssSelector("select>option[value=\"3\"]")).click();
		driver.findElement(By.cssSelector("div[aria-label=\"Choose Tuesday, April 1st, 2025\"]")).click();
		
		String[] subjects = { "Maths", "Phy", "Eco", "Eng" };
        WebElement sub = driver.findElement(By.cssSelector("div>input[id=\"subjectsInput\"]"));
        for (String subject : subjects) {
            sub.sendKeys(subject);
            sub.sendKeys(Keys.ENTER);
            Thread.sleep(500);
        }
        
        JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,700)");
        
        driver.findElement(By.cssSelector("label[for='hobbies-checkbox-1']")).click();
        driver.findElement(By.cssSelector("label[for='hobbies-checkbox-3']")).click();
        
        WebElement pic = driver.findElement(By.cssSelector("div>input[id=\"uploadPicture\"]"));
        pic.sendKeys("C:\\Users\\k devendra\\Downloads\\Telegram Desktop\\VK [PAKISTAN].jpg");
		
		WebElement address = driver.findElement(By.cssSelector("div>textarea[placeholder=\"Current Address\"]"));
		address.sendKeys("Mumbai");
		
		WebElement state = driver.findElement(By.cssSelector("div>input[id=\"react-select-3-input\"]"));
        state.sendKeys("NCR");
        state.sendKeys(Keys.ENTER);

        WebElement city = driver.findElement(By.cssSelector("div>input[id=\"react-select-4-input\"]"));
        city.sendKeys("Delhi");
        city.sendKeys(Keys.ENTER);

        driver.findElement(By.cssSelector("div>button[id=\"submit\"]")).click();
		
	}

}
