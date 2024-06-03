package org.chaterls;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginUsingForLoop {

	@Test
	private void login() throws IOException, InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		// url launch

		driver.get("https://dev.chattelsandmore.com/get-inspired");

		// widow maximize

		driver.manage().window().maximize();

		// apply implicitlywait

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// sign logo

		WebElement signLogo = driver
				.findElement(By.xpath("//div[@class='toggle-tab outside-close mobile proceed-to-checkout']"));

		Actions a = new Actions(driver);
		a.moveToElement(signLogo);

		Thread.sleep(2000);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", signLogo);
		

		File f = new File(
				"C:\\Users\\Balaji.p\\eclipse-workspace\\ChattelsAndMore\\DatasStorage\\Login credentials for proshop.xlsx");

		FileInputStream fin = new FileInputStream(f);
		
		Workbook b = new XSSFWorkbook(fin);
		
		Sheet s = b.getSheetAt(1);
		
		int  lasrRow = s.getLastRowNum();
		
		short  lastCell = s.getRow(1).getLastCellNum();
		
		for (int i = 1; i <=lasrRow; i++) {
			
			Row r = s.getRow(i);
			
			String c0 = r.getCell(0).getStringCellValue();
			String c1 = r.getCell(1).getStringCellValue();
			
			

			Thread.sleep(8000);

			// enter the user name
			WebElement userName = driver.findElement(By.xpath("(//input[@name='username'])[2]"));
			userName.sendKeys(c0);

			// enter the password
			WebElement password = driver.findElement(By.xpath("(//input[@name='password'])[4]"));
			password.sendKeys(c1);

			// click the submit
			WebElement submit = driver.findElement(By.xpath("//span[text()='Sign In']"));
			submit.click();

			
			
		}
		
		
	}

}
