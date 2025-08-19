package Testng_package;



/* 
 5.Use Data Provider to supply multiple sets of usernames/passwords to a login test.
 */



import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Task5 {
	
	WebDriver driver;
	WebDriverWait wait;
	Actions actions;
	@BeforeTest
	  public void beforeTest() throws InterruptedException {
		  	driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://www.ebay.com/");
			wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        actions = new Actions(driver);
	  } 
 
  @DataProvider(name= "excelData")
	public Object[][] excelDataProvider() throws IOException {
		String excelPath = "C:\\Users\\k devendra\\eclipse-workspace\\TestNG_selenium\\src\\test\\resources\\TestData.xlsx";
		String sheetName = "loginData";
		
		FileInputStream fis = new FileInputStream(excelPath);
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheet(sheetName);
		
		int rows = sheet.getPhysicalNumberOfRows();
		int cols = sheet.getRow(0).getLastCellNum();
		
		Object[][] data = new Object[rows - 1][cols];
		
		
		for(int i = 1; i < rows; i++) {
			Row row = sheet.getRow(i);
			for(int j = 0; j < cols; j++) {
				Cell cell = row.getCell(j);
				data[i - 1][j] = (cell == null) ? "" : cell.toString();
			}
		}
		
		workbook.close();
		fis.close();
		
		return data;
	}
	@Test(dataProvider = "excelData")
	public void testLogin(String username1, String password1) {
		System.out.println("Username : "+ username1 + " | Password : " + password1);
		WebDriver driver = new ChromeDriver();
		driver.get("http://zero.webappsecurity.com/login.html");
		
		driver.findElement(By.id("user_login")).click();
		driver.findElement(By.id("user_login")).sendKeys(username1);
		
		driver.findElement(By.id("user_password")).click();
		driver.findElement(By.id("user_password")).sendKeys(password1);
		
		driver.findElement(By.name("submit")).click();
	}
  
	
}
