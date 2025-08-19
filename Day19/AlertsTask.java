package Day20_assignment;

//Assignment 3 – Alerts
//Objective: Handle different types of alerts.
//Scenario:
//Open the DemoQA site → https://demoqa.com/alerts
//Perform:
//Click the button to see an alert, accept it.
//Click the “On button click, confirm box will appear” button, dismiss the alert.
//Click the “Prompt Box” button, enter your name, and accept it.
//Capture and print the alert messages before accepting/dismissing.
//Extra Challenge:
//Wait dynamically for the alert that appears after 5 seconds, then accept it.

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertsTask {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/alerts");
		Thread.sleep(5000);
		
		WebElement alertbutton = driver.findElement(By.id("alertButton"));
		alertbutton.click();
		Thread.sleep(2000);
		Alert alert = driver.switchTo().alert();
		alert.accept();
		
		WebElement timealert = driver.findElement(By.id("timerAlertButton"));
		timealert.click();
		Thread.sleep(7000);
		Alert alert12 = driver.switchTo().alert();
		alert12.accept();
		
		Thread.sleep(3000);
		WebElement confirmalert = driver.findElement(By.id("confirmButton"));
		confirmalert.click();
		Thread.sleep(2000);
		Alert alert1 = driver.switchTo().alert();
		alert1.dismiss();
		
		Thread.sleep(3000);
		WebElement promptalert = driver.findElement(By.id("promtButton"));
		promptalert.click();
		Thread.sleep(2000);
		Alert alert11 = driver.switchTo().alert();
		alert11.sendKeys("Virat");
		alert11.accept();

	}
}
