package org.chaterls;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Login {

	
	WebDriver driver;

	@BeforeClass
	private void start() throws InterruptedException {

		// browser configuration

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		// url launch

		driver.get("https://dev.chattelsandmore.com/get-inspired");

		// widow maximize

		driver.manage().window().maximize();

		// apply implicitlywait

		driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(5));

	}
	
	

	@Test(priority=1,enabled=true)
	private void prework() throws InterruptedException {
		// 1.place the cursor of sign logo
		WebElement signLogo = driver.findElement(By.xpath("//div[@class='toggle-tab outside-close mobile proceed-to-checkout']"));
		
		Actions a = new Actions(driver);
		a.moveToElement(signLogo).build().perform();
		
		Thread.sleep(2000);
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
       js.executeScript("arguments[0].click();", signLogo);
		
        Thread.sleep(4000);

	}
	
	
	

	@Test(priority=2,enabled =true)
	private void credentials() throws InterruptedException {

		// enter the user name
		WebElement userName = driver.findElement(By.xpath("(//input[@name='username'])[2]"));
		userName.sendKeys("balaji.p@sysfore.com");

		// enter the password
		WebElement password = driver.findElement(By.xpath("(//input[@name='password'])[4]"));
		password.sendKeys("Balaji@123");

		// click the submit
		WebElement submit = driver.findElement(By.xpath("//span[text()='Sign In']"));
		submit.click();

		Thread.sleep(4000);

		try {

			WebElement errMsg = driver.findElement(By.xpath("//div[text()='Invalid login or password.']"));

			// error msg is showing the if block will execute, otherwise errmsg is not
			// showing else block is will execute

			if (errMsg.isDisplayed()) {

				// if error msg is showing print the error msg
				System.out.println(errMsg.getText());

			}

		} catch (Exception e) {

			// error msg is not showing this statement will execute
			System.out.println("user entered the proper username and password");

		}

	}
	
	

	@Test(priority=3,enabled =false)
	private void withoutRule() {

		
		//enter the user name
		WebElement userName = driver.findElement(By.xpath("(//input[@name='username'])[2]"));
		userName.sendKeys("balaji.psysfore.com");

		//enter the password
		WebElement password = driver.findElement(By.xpath("(//input[@name='password'])[4]"));
		password.sendKeys("Balaji@123");
		
        //can get the username field value
		String emailId = userName.getAttribute("value");

		//click the submit button
		WebElement submit = driver.findElement(By.xpath("//span[text()='Sign In']"));
		submit.click();

		//user name is without @ and .com if block will execute
		if (!emailId.contains("@") | !emailId.contains(".com")) {

			WebElement errmsg = driver.findElement(By.xpath("//div[@id='customer-email-error']"));

			//error msg is showing if block will execute, 
			if (errmsg.isDisplayed()) {

				System.out.println("error msg showing properly");
				System.out.println(errmsg.getText());

				//error msg is not showing else block will execute.
			} else {

				System.out.println("error msg is not showing");
			}

			
			// username with @ and .com else block will execute
		} else {

			System.out.println("user entered the emaild is with @ and .com");

		}

	}
	
	@Test(priority=4,enabled=false)
	private void withoutEmpty() throws InterruptedException {
    
		        //enter the user name
				WebElement userName = driver.findElement(By.xpath("(//input[@name='username'])[2]"));
				userName.sendKeys("balaji.p@sysfore.com");

				//enter the password
				WebElement password = driver.findElement(By.xpath("(//input[@name='password'])[4]"));
				password.sendKeys("Balaji@123");
				
		        //can get the username field value
				String emailId = userName.getAttribute("value");
				
				String keyword = password.getAttribute("value");

				//click the submit button
				WebElement submit = driver.findElement(By.xpath("//span[text()='Sign In']"));
				submit.click();
				
		       if (emailId.isEmpty()) {
			
			   System.out.println("username  field is empty");
			
			   WebElement emailErrMsg = driver.findElement(By.xpath("//div[@id='customer-email-error']"));
		
				
			   if (emailErrMsg.isDisplayed()) {
				
				System.out.println("please enter your user name");
				System.out.println(emailErrMsg.getText());
				
		     	} 
			   
			   
		       }
		       
			  Thread.sleep(2000);
			   
			   
			   if (keyword.isEmpty()) {
					
				   System.out.println("password field is empty");		
				
				   WebElement passErrMsg = driver.findElement(By.xpath("//div[@id='pass-error']"));
				
				
				   if (passErrMsg.isDisplayed()) {
					
					System.out.println("please enter your password");
					System.out.println(passErrMsg.getText());
					
			     	} 
			   
			   }
			   
				
		       
	
	}

	
	
	@AfterClass
	private void end() {

		driver.quit();

	}
	
	
}
