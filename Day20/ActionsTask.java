package Day20_assignment;

//Assignment 1 – Action Class
//Objective: Practice mouse and keyboard interactions.
//Scenario:
//Open the DemoQA site → https://demoqa.com/buttons
//Perform:
//Double Click on “Double Click Me” button.
//Right Click on “Right Click Me” button.
//Single Click on the third “Click Me” button.
//Print the text messages that appear after each click action.
//Extra Challenge:
//Visit https://demoqa.com/dragabble and drag the element from its position to another point.


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsTask {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/buttons");
		Thread.sleep(5000);
		
		WebElement doubleclick = driver.findElement(By.id("doubleClickBtn"));
		Actions act = new Actions(driver);
		act.doubleClick(doubleclick).perform();
		
		Thread.sleep(3000);
		WebElement rightclick = driver.findElement(By.id("rightClickBtn"));
		act.contextClick(rightclick).perform();
		
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/droppable");
		Actions act2 = new Actions(driver);
		WebElement source = driver.findElement(By.id("draggable"));
		WebElement target = driver.findElement(By.id("droppable"));
		act2.dragAndDrop(source, target).perform();
		
	}

}

