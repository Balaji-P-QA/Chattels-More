package org.chaterls;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ProductPurchase {

	WebDriver driver;

	JavascriptExecutor js;

	String usingStoreCredit;

	String paymentMethod;

	Actions a;

	int Favourite = 7;

	@BeforeClass
	private void start() throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://dev.chattelsandmore.com/get-inspired");

		driver.manage().window().maximize();

		Thread.sleep(30000);

		WebElement agree = driver.findElement(By.xpath("//span[text()='Allow Cookies']"));
		agree.click();

		Thread.sleep(5000);

	}

	@Test(priority = 1, enabled = true)
	private void login1() throws InterruptedException {

		WebElement signLogo = driver
				.findElement(By.xpath("//div[@class='toggle-tab outside-close mobile proceed-to-checkout']"));

		Actions a = new Actions(driver);
		a.moveToElement(signLogo);

		Thread.sleep(2000);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", signLogo);

		Thread.sleep(4000);

	}

	@Test(priority = 2, enabled = true)
	private void credentials() throws InterruptedException {

		// enter the user name
		WebElement userName = driver.findElement(By.xpath("(//input[@name='username'])[2]"));
		userName.sendKeys("balaji.p@sysfore.com");

		Thread.sleep(2000);

		// enter the password
		WebElement password = driver.findElement(By.xpath("(//input[@name='password'])[4]"));
		password.sendKeys("Balaji@1234");

		Thread.sleep(2000);

		// click the submit
		WebElement submit = driver.findElement(By.xpath("//span[text()='Sign In']"));
		submit.click();

		Thread.sleep(7000);

	}

	@Test(priority = 3, enabled = true)
	private void productSelecting() throws InterruptedException, AWTException {

		String Generalsearch = "yes";
		String particularCategory = "";
		String Productpagewise = "";
		PurchasePoj p = new PurchasePoj(driver);
		int i = 0;

		if (Generalsearch.equals("yes")) {

			WebElement searchIcon = driver.findElement(By.xpath("//a[@class='display-search']"));
			js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].click();", searchIcon);
			

			Thread.sleep(1000);

			WebElement searchTextbox = driver.findElement(By.cssSelector("input#search"));
			searchTextbox.sendKeys("Bench Wing Grey");

			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_ENTER);

			Thread.sleep(3000);

			List<WebElement> addToCartTooltip = driver.findElements(By.xpath("//button[@title='Add to Cart']"));
			a = new Actions(driver);
			a.moveToElement(addToCartTooltip.get(Favourite)).build().perform();
			Thread.sleep(1000);
			addToCartTooltip.get(Favourite).click();

		} else if (particularCategory.equals("yes")) {

			WebElement accessories = driver.findElement(By.xpath("(//a[@class='level-top'])[15]"));
			a = new Actions(driver);
			a.moveToElement(accessories).build().perform();

			Thread.sleep(3000);

			WebElement decorativeAccessories = driver
					.findElement(By.xpath("(//span[text()='Decorative accessories'])[2]"));
			decorativeAccessories.click();

			Thread.sleep(3000);

			List<WebElement> addToCartTooltip = driver
					.findElements(By.xpath("//button[@class='action tocart primary button btn-cart pull-left-none']"));
			a.moveToElement(addToCartTooltip.get(Favourite)).build().perform();
			addToCartTooltip.get(Favourite).click();

			Thread.sleep(4000);

		} else if (Productpagewise.equals("yes")) {

			WebElement accessories = driver.findElement(By.xpath("(//a[@class='level-top'])[15]"));
			a = new Actions(driver);
			a.moveToElement(accessories).build().perform();

			Thread.sleep(3000);

			WebElement decorativeAccessories = driver
					.findElement(By.xpath("(//span[text()='Decorative accessories'])[2]"));
			decorativeAccessories.click();

			String ExpectProduct = "Man With Beard Turban With Basket Resin";

			p = new PurchasePoj(driver);

			for (int k = 0; k < p.ProductsName.size(); k++) {

				String actualProduct = p.ProductsName.get(k).getText();

				if (actualProduct.equals(ExpectProduct)) {

					List<WebElement> addToCartTooltip = driver.findElements(By.xpath("//button[@title='Add to Cart']"));
					a.moveToElement(addToCartTooltip.get(k)).build().perform();
					Thread.sleep(1000);
					js = (JavascriptExecutor) driver;
					js.executeScript("arguments[0].click();", addToCartTooltip.get(k));
					i = k;
					break;
				}

				if (k == p.ProductsName.size() - 1) {

					try {

						WebElement nextBtn = driver.findElement(By.xpath("(//span[text()='Next'])[2]"));
						nextBtn.click();
						i = k;
						k = -1;

						Thread.sleep(3000);

					} catch (Exception e) {

						System.out.println("User searching Product is not Available");
						i = -1;
						break;
					}

				}

			}

		}
		if (i != -1) {
			
			Thread.sleep(3000);
			
			WebElement cartIcon = driver.findElement(By.xpath("//div[@class='minicart-wrapper']"));
			cartIcon.click();

			Thread.sleep(2000);

			WebElement proceedToCheckout = driver.findElement(By.xpath("//button[text()='Proceed to Checkout']"));
			proceedToCheckout.click();
		}
	}

	@Test(priority = 4, enabled = false)
	private void checkoutWorks() throws InterruptedException {

		WebElement scrDown = driver.findElement(By.xpath("//span[text()='New Address']"));
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", scrDown);

		Thread.sleep(3000);

		WebElement nextButton = driver.findElement(By.xpath("//span[text()='Next']"));
		nextButton.click();

		Thread.sleep(8000);

		paymentMethod = "credit Card";

		if (paymentMethod.equals("credit Card")) {

			WebElement cardPayment = driver.findElement(By.xpath("//input[@id='ccavenuepay']"));
			cardPayment.click();

		} else if (paymentMethod.equals("cash On Delivery")) {

			WebElement cashOnDelivery = driver.findElement(By.xpath("//input[@id='cashondelivery']"));
			cashOnDelivery.click();

		} else {

			WebElement postpay = driver.findElement(By.xpath("//input[@id='postpay']"));
			postpay.click();
		}

		String discountCode = "yes";

		if (discountCode.equals("yes")) {

			WebElement enterDiscountCode = driver.findElement(By.xpath("//input[@placeholder='Enter discount code']"));
			enterDiscountCode.sendKeys("Test@123");

			Thread.sleep(4000);

			WebElement submitDiscountCode = driver.findElement(By.xpath("//span[text()='Apply Discount']"));
			submitDiscountCode.click();

			Thread.sleep(2000);

			WebElement discountValidMsg = driver.findElement(By.xpath("//div[@class='message message-error error']"));

			if (discountValidMsg.isDisplayed()) {

				System.out.println("user entered the invalid discount code");

			}

		}

		String storeCredit = "yes";

		if (storeCredit.equals("yes")) {

			WebElement clickableStoreCredit = driver.findElement(By.xpath("(//span[text()='Use Store Credit'])[1]"));
			clickableStoreCredit.click();

			Thread.sleep(2000);

			WebElement enterDiscountAmount = driver.findElement(By.xpath("//input[@id='credit-amount']"));
			enterDiscountAmount.sendKeys("10");

			Thread.sleep(2000);

			WebElement submitStoreCredit = driver.findElement(By.xpath("//button[@id='apply-credit']"));
			submitStoreCredit.click();

			Thread.sleep(2000);

			WebElement storecreditValidMsg = driver
					.findElement(By.xpath("(//div[@data-ui-id='checkout-cart-validationmessages-message-error'])[2]"));

			if (storecreditValidMsg.isDisplayed()) {

				System.out.println("user don't have store credit balance code");

			}

		}

	}

	@Test(priority = 5, enabled = false)
	private void paymentTypes() throws InterruptedException {

		if (paymentMethod.equals("credit Card")) {

			WebElement placeOrder = driver.findElement(By.xpath("(//span[text()='Place Order'])[4]"));
			placeOrder.click();

			Thread.sleep(10000);

			WebElement scrDown = driver.findElement(By.xpath("//div[@class='span12 content-bg']"));
			js.executeScript("arguments[0].scrollIntoView(true)", scrDown);

			WebElement creditcardNumber = driver.findElement(By.xpath("//input[@id='creditCardNumber']"));
			creditcardNumber.sendKeys("5123450000000008");

			Thread.sleep(2000);

			WebElement Month = driver.findElement(By.xpath("//select[@id='expiryMonthCreditCard']"));
			Select s1 = new Select(Month);
			s1.selectByIndex(1);

			Thread.sleep(2000);

			WebElement year = driver.findElement(By.xpath("//select[@id='expiryYearCreditCard']"));
			Select s2 = new Select(year);
			s2.selectByVisibleText("2039");

			Thread.sleep(2000);

			WebElement ccvNumber = driver.findElement(By.xpath("//input[@id='CVVNumberCreditCard']"));
			ccvNumber.sendKeys("100");

			Thread.sleep(2000);

			WebElement submit = driver.findElement(By.xpath("(//span[text()='Make Payment'])[1]"));
			submit.click();

			Thread.sleep(9000);

			WebElement AcsSubmit = driver.findElement(By.xpath("//input[@type='submit']"));
			AcsSubmit.click();

		} else if (paymentMethod.equals("cash On Delivery")) {

			WebElement placeOrder = driver.findElement(By.xpath("(//span[text()='Place Order'])[2]"));
			placeOrder.click();

		} else {

			WebElement continuePostpay = driver.findElement(By.xpath("//span[text()='Continue to Postpay']"));
			continuePostpay.click();

			/*
			 * List<WebElement> phoneNumberForPostpay =
			 * driver.findElements(By.xpath("//div[@tabindex='0']"));
			 * 
			 * for (int i = 0; i <phoneNumberForPostpay.size(); i++) {
			 * 
			 * 
			 * 
			 * // ((WebElement) phoneNumberForPostpay).sendKeys("987654321");
			 * 
			 * for (int j =0; j >9; j--) {
			 * 
			 * int j1=j;
			 * 
			 * String s=Integer.toString(j1);
			 * 
			 * ((WebElement) phoneNumberForPostpay.get(j1)).sendKeys(s); } }
			 * 
			 * 
			 */

			Thread.sleep(3000);

			WebElement sendCode = driver.findElement(By.xpath("//button[text()='Send Code']"));
			sendCode.click();

		}

	}

	@AfterClass
	private void end() {

		 //driver.quit();

	}

}
