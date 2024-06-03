package org.chaterls;

import java.util.List;

import org.apache.xmlbeans.impl.xb.xsdschema.Attribute.Use;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UserPersonalFunctionalities {

	WebDriver driver;
	
	JavascriptExecutor js;
	
	String currentPassword;
	
	String newPassword;

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

		Thread.sleep(5000);

	}

	@Test(priority = 1, enabled = true)
	private void prework() throws InterruptedException {
		// 1.place the cursor of sign logo
		WebElement signLogo = driver
				.findElement(By.xpath("//div[@class='toggle-tab outside-close mobile proceed-to-checkout']"));

		Actions a = new Actions(driver);
		a.moveToElement(signLogo).build().perform();

		Thread.sleep(2000);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", signLogo);

		Thread.sleep(4000);

	}

	@Test(priority = 2, enabled = true)
	private void login() throws InterruptedException {

		// enter the user name
		WebElement userName = driver.findElement(By.xpath("(//input[@name='username'])[2]"));
		userName.sendKeys("balaji.p@sysfore.com");

		// enter the password
		WebElement password = driver.findElement(By.xpath("(//input[@name='password'])[4]"));
		password.sendKeys("Balaji@1234");

		// click the submit
		WebElement submit = driver.findElement(By.xpath("//span[text()='Sign In']"));
		submit.click();

		Thread.sleep(4000);
		
		WebElement allowCookies = driver.findElement(By.xpath("//span[text()='Allow Cookies']"));
        allowCookies.click();
		
		WebElement signLogo = driver
				.findElement(By.xpath("//div[@class='toggle-tab outside-close mobile ']"));

		Actions a = new Actions(driver);
		a.moveToElement(signLogo).build().perform();

		Thread.sleep(2000);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", signLogo);

		Thread.sleep(4000);
		
		WebElement myAccount = driver.findElement(By.xpath("(//a[text()='My Account'])[1]"));
		myAccount.click();

	}
	
	@Test(priority = 3, enabled = false)
	private void myAccount() throws InterruptedException {
      
		Thread.sleep(3000);
		
		//password changing
		
		WebElement changePassword = driver.findElement(By.xpath("//a[@class='action change-password']"));
		changePassword.click();
		
		currentPassword = "Balaji@1234";
	    newPassword="Balaji@123";
		
		Thread.sleep(3000);
		
		WebElement curPassword = driver.findElement(By.xpath("//input[@id='current-password']"));
		curPassword.sendKeys(currentPassword);
		
		Thread.sleep(3000);
		
		WebElement newPass = driver.findElement(By.xpath("//input[@id='password']"));
		newPass.sendKeys(newPassword);
		
		Thread.sleep(3000);
		
		WebElement confirmNewPassword = driver.findElement(By.xpath("//input[@id='password-confirmation']"));
		confirmNewPassword.sendKeys(newPassword);
		
		Thread.sleep(3000);
		
		WebElement saveBtn = driver.findElement(By.xpath("//span[text()='Save']"));
		saveBtn.click();
		
		Thread.sleep(6000);
		
		WebElement newPasswordConfirmMsg = driver.findElement(By.xpath("//div[text()='You saved the account information.']"));
		
		if (newPasswordConfirmMsg.isDisplayed()) {
			
			System.out.println(newPasswordConfirmMsg.getText());
			Assert.assertTrue(true);
			Reporter.log(newPasswordConfirmMsg.getText());
			
		} else {

			Assert.assertTrue(false);
			Reporter.log("password updated is unsuccessful");
			
		}
		
		Thread.sleep(6000);
		
		WebElement userName = driver.findElement(By.xpath("(//input[@name='login[username]'])[1]"));
		userName.sendKeys("balaji.p@sysfore.com");

		// enter the password
		WebElement password = driver.findElement(By.xpath("(//input[@name='login[password]'])[1]"));
		password.sendKeys(newPassword);

		// click the submit
		WebElement submit = driver.findElement(By.xpath("(//span[text()='Sign In'])[1]"));
		submit.click();

		
	}
	
	@Test(priority=4, enabled =false)
	private void myOrders() throws InterruptedException {
     
		WebElement myOrder = driver.findElement(By.xpath("(//a[text()='My Orders'])[1]"));
		myOrder.click();
		
		Thread.sleep(3000);
		
		
		
		List<WebElement> orderList = driver.findElements(By.xpath("//span[text()='View Order']"));
		
		String UserExpect = "View Order";
		String userLike = "Reorder";
		
		int rowNumber=3;
		
		if (UserExpect.equals(" ")) {
			
			orderList.get(rowNumber).click();
			
			//print that order No
			
			WebElement orderNo = driver.findElement(By.xpath("//span[@class='base']"));
			System.out.println("The product order number is "+orderNo.getText());
			
			Thread.sleep(3000);
			
			WebElement backToMyOrders = driver.findElement(By.xpath("//span[text()='Back to My Orders']"));
			backToMyOrders.click();
			
			
		}else if (userLike.equals("Reorder")) {
			
			List<WebElement> reorderList = driver.findElements(By.xpath("//span[text()='Reorder']"));
			reorderList.get(rowNumber).click();
			
			Thread.sleep(2000);
			
			WebElement proceedToCheckout = driver.findElement(By.xpath("//span[text()='Proceed to Checkout']"));
			proceedToCheckout.click();
			
			Thread.sleep(3000);
			
			WebElement scrDown = driver.findElement(By.xpath("//span[text()='New Address']"));
			js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].scrollIntoView(true)",scrDown);
			
			
			Thread.sleep(3000);
			
			WebElement nextButton = driver.findElement(By.xpath("//span[text()='Next']"));
			nextButton.click();
			
			Thread.sleep(8000);
			
			WebElement cashOnDelivery = driver.findElement(By.xpath("//input[@id='cashondelivery']"));
			cashOnDelivery.click();
			
			Thread.sleep(3000);
			
			
			WebElement placeOrder = driver.findElement(By.xpath("(//span[text()='Place Order'])[2]"));
			placeOrder.click();
			
			Thread.sleep(7000);
			
			
			WebElement signLogo = driver
					.findElement(By.xpath("//div[@class='toggle-tab outside-close mobile ']"));

			Actions a = new Actions(driver);
			a.moveToElement(signLogo).build().perform();

			Thread.sleep(2000);

			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", signLogo);

			Thread.sleep(4000);

			WebElement myAccount = driver.findElement(By.xpath("(//a[text()='My Account'])[1]"));
			myAccount.click();
			
			Thread.sleep(7000);
			
		}
		
		else {
			
			System.out.println("user was ordered "+orderList.size()+"product");
			
		}
		
	}
	
	@Test(priority=5,enabled=false)
	private void myWishList() throws InterruptedException {
     
		WebElement myWishList = driver.findElement(By.xpath("//a[text()='My Wish List']"));
		myWishList.click();
		
		Thread.sleep(3000);
		
		try {
			
			WebElement emptyMsg = driver.findElement(By.xpath("//div[@class='message info empty']"));
			
			if (emptyMsg.isDisplayed()) {
				System.out.println(emptyMsg.getText());
			}
			
		} catch (Exception e) {
			
			List<WebElement> wishListProductsCount = driver.findElements(By.xpath("//img[@class='lazyload product-image-photo loaded']"));
			System.out.println("user have a "+wishListProductsCount.size()+"products in our wishlist");
		}
		
		Thread.sleep(3000);
		
		WebElement back = driver.findElement(By.xpath("//span[text()='Back']"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", back);
		
	}
	
	
	@Test(priority=6,enabled=false)
	private void addressBook() throws InterruptedException {
		
		WebElement addressBook = driver.findElement(By.xpath("//a[text()='Address Book']"));
		addressBook.click();
		
		Thread.sleep(4000);

		
		String userAddTheAddress="yes";
		
	//user have like to add the new address if block will execute, otherwise else block execute
		
		
		if (userAddTheAddress.equals("yes")) {
			
			WebElement addNewAddress = driver.findElement(By.xpath("//span[text()='Add New Address']"));
			addNewAddress.click();
			
			Thread.sleep(2000);
			
			
			WebElement namePrefix = driver.findElement(By.xpath("//Select[@id='prefix']"));
			Select s1 = new Select(namePrefix);
			s1.selectByIndex(0);
			
			Thread.sleep(2000);
			
			WebElement phoneNumber = driver.findElement(By.xpath("//input[@id='telephone']"));
			phoneNumber.sendKeys("987654321");
			
			Thread.sleep(2000);
			
			WebElement street1 = driver.findElement(By.xpath("(//input[@name='street[]'])[1]"));
			street1.sendKeys("ABC Block");
			
			Thread.sleep(2000);
			
			WebElement street2 = driver.findElement(By.xpath("(//input[@name='street[]'])[2]"));
			street2.sendKeys("ABC Flats");
			
			Thread.sleep(2000);
			
			WebElement street3 = driver.findElement(By.xpath("(//input[@name='street[]'])[3]"));
			street3.sendKeys("ABC street");
			
			Thread.sleep(2000);
			
			WebElement city = driver.findElement(By.xpath("//input[@name='city']"));
			city.sendKeys("Banglore");
			
			Thread.sleep(2000);
			
			WebElement state = driver.findElement(By.xpath("//input[@name='region']"));
			state.sendKeys("Karnataka");
			
			Thread.sleep(2000);
			
			WebElement postalCode = driver.findElement(By.xpath("//input[@name='postcode']"));
			postalCode.sendKeys("abcd1234");
			
			Thread.sleep(2000);
			
			WebElement country = driver.findElement(By.xpath("//Select[@name='country_id']"));
			Select s2 = new Select(country);
			s2.selectByIndex(0);
			
			Thread.sleep(2000);
			
			String addressType="Billing";
			
			//address type user select billing if block will execute ,otherwise select shipping else block will execute
			
			if (addressType.equals("Billing")) {
				
				WebElement billingCheckBox = driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
				billingCheckBox.click();
				
				
			} else {
				
				WebElement shippingCheckBox = driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
				shippingCheckBox.click();
				
			}
			
			WebElement saveAddress = driver.findElement(By.xpath("//span[text()='Save Address']"));
			saveAddress.click();
			
		} else {

			WebElement goBack = driver.findElement(By.xpath("//span[text()='Back']"));
			goBack.click();
		}
		
	}
	
	
	@Test(priority=7,enabled=false)
    private void accountInformation() throws InterruptedException {
    
		WebElement accInfo = driver.findElement(By.xpath("//a[text()='Account Information']"));
		accInfo.click();
		
		Thread.sleep(2000);
		
		
		//user like to change the username and password if block will execute, otherwise els block will execute
		
		String userLike = "yes";
		
		
		if (userLike.equals("yes")) {
			
			String email_Change="yes";
			
			String pass_Change="yes";
			
			
			if (email_Change.equals("No")) {
				
				WebElement emailCheckbox = driver.findElement(By.xpath("//input[@name='change_email']"));
				emailCheckbox.click();
				
				Thread.sleep(2000);
				
				WebElement enterPassword = driver.findElement(By.xpath("//input[@name='current_password']"));
				enterPassword.sendKeys(newPassword);
				
				Thread.sleep(2000);
				
				WebElement save = driver.findElement(By.xpath("//span[text()='Save']"));
				save.click();
				
			} 
			
			if (pass_Change.equals("yes")) {
				
				WebElement passwordCheckbox = driver.findElement(By.xpath("//input[@name='change_password']"));
				passwordCheckbox.click();
				
				Thread.sleep(2000);
				
				WebElement curPassword = driver.findElement(By.xpath("//input[@id='current-password']"));
				curPassword.sendKeys(newPassword);
				
				Thread.sleep(3000);
				
				WebElement newPass = driver.findElement(By.xpath("//input[@id='password']"));
				newPass.sendKeys(currentPassword);
				
				Thread.sleep(3000);
				
				WebElement confirmNewPassword = driver.findElement(By.xpath("//input[@id='password-confirmation']"));
				confirmNewPassword.sendKeys(currentPassword);
				
				Thread.sleep(3000);
				
				WebElement save = driver.findElement(By.xpath("//span[text()='Save']"));
				save.click();
				
				Thread.sleep(3000);
				
				WebElement userName = driver.findElement(By.xpath("(//input[@name='login[username]'])[1]"));
				userName.sendKeys("balaji.p@sysfore.com");

				// enter the password
				WebElement password = driver.findElement(By.xpath("(//input[@name='login[password]'])[1]"));
				password.sendKeys(currentPassword);

				// click the submit
				WebElement submit = driver.findElement(By.xpath("(//span[text()='Sign In'])[1]"));
				submit.click();

			}
			
			
			
		} else {
			
			WebElement goBack = driver.findElement(By.xpath("//span[text()='Go back']"));
			goBack.click();
			Thread.sleep(3000);
			
		}
		
		
	}
	
	
	@Test(priority=8,enabled=true)
	private void newsLetterSubscription() throws InterruptedException {
    
		WebElement newsLetterSubscribe = driver.findElement(By.xpath("//a[text()='Newsletter Subscriptions']"));
		newsLetterSubscribe.click();
		
		Thread.sleep(2000);
		
		WebElement subscribeCheckbox = driver.findElement(By.xpath("//input[@id='subscription']"));
		
		//news letter is already subscribed if block will execute, not subsribed else block will execute
		
		if (subscribeCheckbox.isSelected()) {
			
			System.out.println("News Letter Already Subscribed");
			
			WebElement goBack = driver.findElement(By.xpath("//span[text()='Back']"));
			goBack.click();
			
		} else {

			subscribeCheckbox.click();
			
			Thread.sleep(2000);
			
			WebElement saveBtn = driver.findElement(By.xpath("(//button[@type='submit'])[2]"));
			saveBtn.click();
			
			Thread.sleep(2000);
			
			WebElement succMsg = driver.findElement(By.xpath("//div[text()='We have saved your subscription.']"));
			System.out.println(succMsg.getText());
		}
		
		
	}
	
	@Test(priority=9,enabled=false)
	private void storeCredit() throws InterruptedException {
    
		WebElement storeCredit = driver.findElement(By.xpath("//a[text()='Store Credit']"));
		storeCredit.click();
		
		Thread.sleep(3000);
		
		String currentTitle = driver.getTitle();
		
		if (currentTitle.equals("Store Credit")) {
			
			System.out.println("user entered in to the store credit page");
			Assert.assertTrue(true);
			
		}else {
		
			System.out.println("user not entered in to the store credit page");
			Assert.assertTrue(false);
			
		}
		
	}
	
	
	@AfterClass
	private void end() {
     
		//driver.quit();
		
	}
	
	
}
	

