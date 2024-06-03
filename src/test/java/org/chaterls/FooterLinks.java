package org.chaterls;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FooterLinks {

    WebDriver driver;
    
    JavascriptExecutor js;
	
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
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
	}
	
	
	@AfterClass
	private void end() {
     
		driver.quit();
		
	}
	
	
	@Test(priority=1)
	private void outStory() throws InterruptedException {
    
		WebElement ourStory = driver.findElement(By.xpath("//a[text()='Our Story']"));
		ourStory.click();
		
		Thread.sleep(2000);
		
		
		String title = driver.getTitle();

		if (title.equals("Our Story")) {

			System.out.println("user clicked the Our Story link, its redirecting to Our Story page");
			Assert.assertTrue(true);
			Reporter.log("user clicked the Our Story link, its redirecting to Our Story page");

		} else {

			System.out.println("user clicked the Our Story link, its not redirecting to Our Story  page");
			Assert.assertTrue(false);
			Reporter.log("user clicked the Our Story link, its not redirecting to Our Story US page");

		}
		
	}
	
	
	@Test(priority=2)
	private void careers() throws InterruptedException {
    
		WebElement careers = driver.findElement(By.xpath("//a[text()='Careers']"));
		careers.click();
		
		Thread.sleep(2000);
		
		Set<String> windows = driver.getWindowHandles();
		
		List<String> li = new ArrayList<String>(windows);
		
		driver.switchTo().window(li.get(1));
		
		String title = driver.getTitle();
		

		if (title.equals("Human Capital - Easa Saleh Al Gurg Group")) {

			System.out.println("user clicked the Careers link, its redirecting to Careers page");
			Assert.assertTrue(true);
			Reporter.log("user clicked the Careers link, its redirecting to Careers page");

		} else {

			System.out.println("user clicked the Careers link, its not redirecting to Careers  page");
			Assert.assertTrue(false);
			Reporter.log("user clicked the Careers link, its not redirecting to Careers page");

		}
		
		driver.switchTo().window(li.get(0));
		
		Thread.sleep(2000);
		
	}
	
	
	@Test(priority=3)
	private void blog() throws InterruptedException {
     
		WebElement blog = driver.findElement(By.xpath("//a[text()='Blog']"));
		blog.click();
		
		Thread.sleep(2000);
		
		String title = driver.getTitle();
		

		if (title.equals("Blog")) {

			System.out.println("user clicked the Blog link, its redirecting to Blog page");
			Assert.assertTrue(true);
			Reporter.log("user clicked the Blog link, its redirecting to Blog page");

		} else {

			System.out.println("user clicked the Blog link, its not redirecting to Blog  page");
			Assert.assertTrue(false);
			Reporter.log("user clicked the Blog link, its not redirecting to Blog page");

		}
	
		Thread.sleep(2000);
		
	}
	
	@Test(priority=4)
	private void aboutEsag() throws InterruptedException {
    
		WebElement blog = driver.findElement(By.xpath("//a[text()='About ESAG']"));
		blog.click();
		
		Thread.sleep(2000);
		
		String title = driver.getTitle();
		

		if (title.equals("About ESAG")) {

			System.out.println("user clicked the About ESAG link, its redirecting to About ESAG page");
			Assert.assertTrue(true);
			Reporter.log("user clicked the About ESAG link, its redirecting to About ESAG page");

		} else {

			System.out.println("user clicked the About ESAG link, its not redirecting to About ESAG  page");
			Assert.assertTrue(false);
			Reporter.log("user clicked the About ESAG link, its not redirecting to About ESAG page");

		}
	
		Thread.sleep(2000);
	
		
	}
	
	
	@Test(priority=5)
	private void living() throws InterruptedException {
     
		WebElement living = driver.findElement(By.xpath("//a[text()='Living']"));
	    js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", living);
		//living.click();
		
		Thread.sleep(2000);
		
		String title = driver.getTitle();
		

		if (title.equals("Living Room")) {

			System.out.println("user clicked the Living link, its redirecting to Living page");
			Assert.assertTrue(true);
			Reporter.log("user clicked the Living link, its redirecting to Living page");

		} else {

			System.out.println("user clicked the Living link, its not redirecting to Living  page");
			Assert.assertTrue(false);
			Reporter.log("user clicked the Living link, its not redirecting to Living page");

		}
	
		Thread.sleep(4000);
		
	}
	
	
	@Test(priority=6,dependsOnMethods = {"bedRoom"})
	private void dining() throws InterruptedException {
     
		WebElement dining = driver.findElement(By.xpath("(//a[text()='Dining'])[2]"));
		js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", dining);
	//	dining.click();
		
		Thread.sleep(2000);
		
		String title = driver.getTitle();
		

		if (title.equals("DINING")) {

			System.out.println("user clicked the Dining link, its redirecting to Dining page");
			Assert.assertTrue(true);
			Reporter.log("user clicked the Dining link, its redirecting to Dining page");

		} else {

			System.out.println("user clicked the Dining link, its not redirecting to Dining  page");
			Assert.assertTrue(false);
			Reporter.log("user clicked the Dining link, its not redirecting to Dining page");

		}
	
		Thread.sleep(2000);
	
		
	}
	
	
	@Test(priority=7)
	private void bedRoom() throws InterruptedException {
      
		WebElement bedRoom = driver.findElement(By.xpath("//a[text()='Bedroom']"));
		bedRoom.click();
		
		Thread.sleep(2000);
		
		String title = driver.getTitle();
		

		if (title.equals("BEDROOM")) {

			System.out.println("user clicked the Bedroom link, its redirecting to Bedroom page");
			Assert.assertTrue(true);
			Reporter.log("user clicked the Bedroom link, its redirecting to Bedroom page");

		} else {

			System.out.println("user clicked the Bedroom link, its not redirecting to Bedroom  page");
			Assert.assertTrue(false);
			Reporter.log("user clicked the Bedroom link, its not redirecting to Bedroom page");

		}
	
		Thread.sleep(2000);
		
	}
	
	
	@Test(priority=8)
	private void accessories() throws InterruptedException {
     
		WebElement accessories = driver.findElement(By.xpath("//a[text()='Accessories']"));
		js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", accessories);
	//	accessories.click();
		
		Thread.sleep(2000);
		
		String title = driver.getTitle();
		

		if (title.equals("ACCESSORIES")) {

			System.out.println("user clicked the Accessories link, its redirecting to Accessories page");
			Assert.assertTrue(true);
			Reporter.log("user clicked the Accessories link, its redirecting to Accessories page");

		} else {

			System.out.println("user clicked the Accessories link, its not redirecting to Accessories  page");
			Assert.assertTrue(false);
			Reporter.log("user clicked the Accessories link, its not redirecting to Accessories page");

		}
	
		Thread.sleep(2000);
	
		
	}
	
	
	@Test(priority=9)
	private void lighting() throws InterruptedException {
     
		WebElement lighting = driver.findElement(By.xpath("//a[text()='Lighting']"));
		js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", lighting);
	//	lighting.click();
		
		Thread.sleep(2000);
		
		String title = driver.getTitle();
		

		if (title.equals("LIGHTING")) {

			System.out.println("user clicked the Lighting link, its redirecting to Lighting page");
			Assert.assertTrue(true);
			Reporter.log("user clicked the Lighting link, its redirecting to Lighting page");

		} else {

			System.out.println("user clicked the Lighting link, its not redirecting to Lighting  page");
			Assert.assertTrue(false);
			Reporter.log("user clicked the Lighting link, its not redirecting to Lighting page");

		}
	
		Thread.sleep(2000);	
		
	}
	
	
	@Test(priority=10)
	private void contactUs() throws InterruptedException {
   
		WebElement contactUs = driver.findElement(By.xpath("//a[text()='Contact Us']"));
		contactUs.click();
		
		Thread.sleep(2000);
		
		String title = driver.getTitle();
		

		if (title.equals("Contact Us")) {

			System.out.println("user clicked the Contact Us link, its redirecting to Contact Us page");
			Assert.assertTrue(true);
			Reporter.log("user clicked the Contact Us link, its redirecting to Contact Us page");

		} else {

			System.out.println("user clicked the Contact Us link, its not redirecting to Contact Us  page");
			Assert.assertTrue(false);
			Reporter.log("user clicked the Contact Us link, its not redirecting to Contact Us page");

		}
	
		Thread.sleep(2000);	
			
		
		
	}
	
	
	@Test(priority=11)
	private void faqs() throws InterruptedException {
   
		WebElement faqs = driver.findElement(By.xpath("//a[text()='FAQs']"));
		faqs.click();
		
		Thread.sleep(2000);
		
		String url = driver.getCurrentUrl();
		

		if (url.equals("https://dev.chattelsandmore.com/faq/")) {

			System.out.println("user clicked the FAQs link, its redirecting to FAQs page");
			Assert.assertTrue(true);
			Reporter.log("user clicked the FAQs link, its redirecting to FAQs page");

		} else {

			System.out.println("user clicked the FAQs link, its not redirecting to FAQs  page");
			Assert.assertTrue(false);
			Reporter.log("user clicked the FAQs link, its not redirecting to FAQs page");

		}
	
		Thread.sleep(2000);	
		
		
	}
	
	
	@Test(priority=12)
	private void uae() throws InterruptedException {
    
		WebElement uae = driver.findElement(By.xpath("//a[text()='UAE Consumer Rights']"));
		uae.click();
		
		Thread.sleep(2000);
		
		String title = driver.getTitle();
		

		if (title.equals("Customer Right")) {

			System.out.println("user clicked the UAE Consumer Rights link, its redirecting to UAE Consumer Rights page");
			Assert.assertTrue(true);
			Reporter.log("user clicked the UAE Consumer Rights link, its redirecting to UAE Consumer Rights page");

		} else {

			System.out.println("user clicked the UAE Consumer Rights link, its not redirecting to UAE Consumer Rights  page");
			Assert.assertTrue(false);
			Reporter.log("user clicked the UAE Consumer Rights link, its not redirecting to UAE Consumer Rights page");

		}
	
		Thread.sleep(2000);	

	}
	
	
	@Test(priority=13)
	private void privacyPolicy() throws InterruptedException {
    
		WebElement privacyPolicy = driver.findElement(By.xpath("//a[text()='Privacy Policy']"));
		privacyPolicy.click();
		
		Thread.sleep(2000);
		
		String title = driver.getTitle();
		

		if (title.equals("Privacy and Cookie Policy")) {

			System.out.println("user clicked the Privacy Policy link, its redirecting to Privacy Policy page");
			Assert.assertTrue(true);
			Reporter.log("user clicked the Privacy Policy link, its redirecting to Privacy Policy page");

		} else {

			System.out.println("user clicked the Privacy Policy link, its not redirecting to Privacy Policy  page");
			Assert.assertTrue(false);
			Reporter.log("user clicked the Privacy Policy link, its not redirecting to Privacy Policy page");

		}
	
		Thread.sleep(2000);	
		
		
	}
	
	
	@Test(priority=14)
	private void storeLocations() throws InterruptedException {
    
		WebElement storeLocations = driver.findElement(By.xpath("//a[text()='Store Locations']"));
		storeLocations.click();
		
		Thread.sleep(2000);
		
		String title = driver.getTitle();
		

		if (title.equals("Find a Store")) {

			System.out.println("user clicked the Store Locations link, its redirecting to Store Locations page");
			Assert.assertTrue(true);
			Reporter.log("user clicked the Store Locations link, its redirecting to Store Locations page");

		} else {

			System.out.println("user clicked the Store Locations link, its not redirecting to Store Locations  page");
			Assert.assertTrue(false);
			Reporter.log("user clicked the Store Locations link, its not redirecting to Store Locations page");

		}
	
		Thread.sleep(2000);	
			
		
	}
	
	
	@Test(priority=15)
	private void shippingAndDelivery() throws InterruptedException {
    
		WebElement shippingAndDelivery = driver.findElement(By.xpath("//a[text()='Shipping and Delivery']"));
		shippingAndDelivery.click();
		
		Thread.sleep(2000);
		
		String title = driver.getTitle();
		

		if (title.equals("Delivery Terms")) {

			System.out.println("user clicked the Shipping and Delivery link, its redirecting to Shipping and Delivery page");
			Assert.assertTrue(true);
			Reporter.log("user clicked the Shipping and Delivery link, its redirecting to Shipping and Delivery page");

		} else {

			System.out.println("user clicked the Shipping and Delivery link, its not redirecting to Shipping and Delivery  page");
			Assert.assertTrue(false);
			Reporter.log("user clicked the Shipping and Delivery link, its not redirecting to Shipping and Delivery page");

		}
	
		Thread.sleep(2000);	
		
	}
	
	
	@Test(priority=16)
	private void exchangeAndReturns() throws InterruptedException {
    
		WebElement exchangeAndReturns = driver.findElement(By.xpath("//a[text()=' Exchanges & Returns']"));
		exchangeAndReturns.click();
		
		Thread.sleep(2000);
		
		String title = driver.getTitle();
		

		if (title.equals("Exchanges and Returns")) {

			System.out.println("user clicked the  Exchanges & Returns link, its redirecting to  Exchanges & Returns page");
			Assert.assertTrue(true);
			Reporter.log("user clicked the  Exchanges & Returns link, its redirecting to  Exchanges & Returns page");

		} else {

			System.out.println("user clicked the  Exchanges & Returns link, its not redirecting to  Exchanges & Returns  page");
			Assert.assertTrue(false);
			Reporter.log("user clicked the  Exchanges & Returns link, its not redirecting to  Exchanges & Returns page");

		}
	
		Thread.sleep(2000);		
		
		
	}
	
	
	@Test(priority=17)
	private void easyPayment() throws InterruptedException {
      
		WebElement easyPayment = driver.findElement(By.xpath("//a[text()='Easy Payment']"));
		easyPayment.click();
		
		Thread.sleep(2000);
		
		String title = driver.getTitle();
		

		if (title.equals("Easy Payment")) {

			System.out.println("user clicked the  Easy Payment link, its redirecting to Easy Payment page");
			Assert.assertTrue(true);
			Reporter.log("user clicked the Easy Payment link, its redirecting to Easy Payment page");

		} else {

			System.out.println("user clicked the Easy Payment link, its not redirecting to  Easy Payment page");
			Assert.assertTrue(false);
			Reporter.log("user clicked the Easy Payment link, its not redirecting to Easy Payment page");

		}
	
		Thread.sleep(2000);		
		
	}
	
	
	@Test(priority=18)
	private void register() throws InterruptedException {
    
		WebElement easyPayment = driver.findElement(By.xpath("//a[text()='Register']"));
		easyPayment.click();
		
		Thread.sleep(2000);
		
		String title = driver.getTitle();
		

		if (title.equals("Create New Customer Account")) {

			System.out.println("user clicked the  Register link, its redirecting to Register page");
			Assert.assertTrue(true);
			Reporter.log("user clicked the Register link, its redirecting to Register page");

		} else {

			System.out.println("user clicked the Register link, its not redirecting to  Register page");
			Assert.assertTrue(false);
			Reporter.log("user clicked the Register link, its not redirecting to Register page");

		}
	
		
		//Login
		
		WebElement login = driver.findElement(By.xpath("(//a[text()='Log In'])[2]"));
		login.click();
		
		Thread.sleep(1000);
		
		WebElement userName = driver.findElement(By.xpath("//input[@name='login[username]']"));
		userName.sendKeys("balaji.p@sysfore.com");
		
		
		WebElement password = driver.findElement(By.xpath("//input[@name='login[password]']"));
		password.sendKeys("Balaji@1234");
		
		Thread.sleep(2000);		
		
		WebElement submit = driver.findElement(By.xpath("(//span[text()='Sign In'])[1]"));
		submit.click();
		
		Thread.sleep(4000);
	}	
		
		
	@Test(priority=19)
	private void myOrder() throws InterruptedException {
    
		WebElement myOrder = driver.findElement(By.xpath("//a[text()='My Orders']"));
		js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();",myOrder );
	//	myOrder.click();
		
	
		Thread.sleep(2000);
		
		String title = driver.getTitle();
		
		
		if (title.equals("My Orders")) {

			System.out.println("user clicked the  myOrder link, its redirecting to myOrder page");
			Assert.assertTrue(true);
			Reporter.log("user clicked the myOrder link, its redirecting to myOrder page");

		} else {

			System.out.println("user clicked the myOrder link, its not redirecting to  myOrder page");
			Assert.assertTrue(false);
			Reporter.log("user clicked the myOrder link, its not redirecting to myOrder page");

		}

		
	}

	
	@Test(priority=20)
	private void myWishlist() throws InterruptedException {
     
		
		WebElement wishList = driver.findElement(By.xpath("//a[text()='My Wishlist']"));
		js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();",wishList );
	//	wishList.click();
		
		Thread.sleep(2000);
		
		String title = driver.getTitle();
		

		if (title.equals("My Wish List")) {

			System.out.println("user clicked the  My Wishlist link, its redirecting to My Wishlist page");
			Assert.assertTrue(true);
			Reporter.log("user clicked the My Wishlist link, its redirecting to My Wishlist page");

		} else {

			System.out.println("user clicked the My Wishlist link, its not redirecting to  My Wishlist page");
			Assert.assertTrue(false);
			Reporter.log("user clicked the My Wishlist link, its not redirecting to My Wishlist page");

		}
	
		Thread.sleep(4000);
		
	}
	
	
	@Test(priority=21)
	private void myAccount() throws InterruptedException {
     
		WebElement myAccount = driver.findElement(By.xpath("//a[text()='My Account']"));
		js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();",myAccount);
	//	myAccount.click();
		
		Thread.sleep(2000);
		
		String title = driver.getTitle();
		

		if (title.equals("My Account")) {

			System.out.println("user clicked the  My Account link, its redirecting to My Account page");
			Assert.assertTrue(true);
			Reporter.log("user clicked the My Account link, its redirecting to My Account page");

		} else {

			System.out.println("user clicked the My Account link, its not redirecting to My Account page");
			Assert.assertTrue(false);
			Reporter.log("user clicked the My Account link, its not redirecting to My Account page");

		}
	
		Thread.sleep(5000);
	}
	
	
	@Test(priority=22)
	private void stayUptoDate() throws InterruptedException {
    
		
		WebElement newsLetter = driver.findElement(By.xpath("//input[@id='newsletter']"));
		newsLetter.sendKeys("Test123@mailinator.com");
		
		Thread.sleep(2000);
		
		WebElement newsLetterSubmit = driver.findElement(By.xpath("(//button[@type='submit'])[3]"));
		newsLetterSubmit.click();
		
		try {
			
			WebElement newsletterPopup = driver.findElement(By.xpath("(//div[@class='modal-inner-wrap'])[4]"));
			
			if (newsletterPopup.isDisplayed()) {
				
				System.out.println("user entered existing email address in to news letter subscription its throwsing throwing in the err msg");
				Assert.assertTrue(false);
				Reporter.log("user entered existing email address in to news letter subscription its throwing in the err msg");
				
			}
			
		} catch (Exception e) {
			
			System.out.println("user entered new email address in to news letter subscription, it not throwing in the err msg");
			Assert.assertTrue(true);
			Reporter.log("user entered new email address in to news letter subscription, it not throwing in the err msg");
			
		}
		

		Thread.sleep(10000);
		
	}
		
	
	@Test(priority=23)
	private void esagAlgurgLogo() throws InterruptedException {
      
		WebElement esagLogo = driver.findElement(By.xpath("(//img[@class='lazyload sub-image loaded'])[6]"));
		js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", esagLogo);
		
		Thread.sleep(2000);
		
		Set<String> windows = driver.getWindowHandles();
		
		List<String> li = new ArrayList<String>(windows);
		
		driver.switchTo().window(li.get(1));
		
		String title = driver.getTitle();
		
		System.out.println(title);

		if (title.equals("Human Capital - Easa Saleh Al Gurg Group")) {

			System.out.println("user clicked the Careers link, its redirecting to Careers page");
			Assert.assertTrue(true);
			Reporter.log("user clicked the Careers link, its redirecting to Careers page");

		} else {

			System.out.println("user clicked the Careers link, its not redirecting to Careers  page");
			Assert.assertTrue(false);
			Reporter.log("user clicked the Careers link, its not redirecting to Careers page");

		}
		
		driver.switchTo().window(li.get(0));
		
		Thread.sleep(2000);
		
		
	}
	
	@Test(priority=24)
	private void facebook() throws InterruptedException {
   
		WebElement facebook = driver.findElement(By.xpath("(//span[@class='fa fa-facebook'])[3]"));
		js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();",facebook);
		
		
		Thread.sleep(2000);
		
		Set<String> windows = driver.getWindowHandles();
		
		List<String> li = new ArrayList<String>(windows);
		
		driver.switchTo().window(li.get(1));
		
		String title = driver.getTitle();
		
		System.out.println(title);
		
		System.out.println(title);

		if (title.equals("Human Capital - Easa Saleh Al Gurg Group")) {

			System.out.println("user clicked the Careers link, its redirecting to Careers page");
			Assert.assertTrue(true);
			Reporter.log("user clicked the Careers link, its redirecting to Careers page");

		} else {

			System.out.println("user clicked the Careers link, its not redirecting to Careers  page");
			Assert.assertTrue(false);
			Reporter.log("user clicked the Careers link, its not redirecting to Careers page");

		}
		
		driver.switchTo().window(li.get(0));
		
		Thread.sleep(2000);
			
	}
	
	
	@Test(priority=25)
	private void instagram() throws InterruptedException {
    
		WebElement instagram = driver.findElement(By.xpath("//span[@class='fa fa-instagram']"));
		js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();",instagram);
		
		
		Thread.sleep(2000);
		
		Set<String> windows = driver.getWindowHandles();
		
		List<String> li = new ArrayList<String>(windows);
		
		driver.switchTo().window(li.get(1));
		
		String title = driver.getTitle();
		
		System.out.println(title);
		
		System.out.println(title);

		if (title.equals("Human Capital - Easa Saleh Al Gurg Group")) {

			System.out.println("user clicked the Careers link, its redirecting to Careers page");
			Assert.assertTrue(true);
			Reporter.log("user clicked the Careers link, its redirecting to Careers page");

		} else {

			System.out.println("user clicked the Careers link, its not redirecting to Careers  page");
			Assert.assertTrue(false);
			Reporter.log("user clicked the Careers link, its not redirecting to Careers page");

		}
		
		driver.switchTo().window(li.get(0));
		
		Thread.sleep(2000);	
		
		
	}
	
	
	@Test(priority=26)
	private void termsOfUse() throws InterruptedException {
       
		WebElement termsOfUse = driver.findElement(By.xpath("//a[text()='Terms of Use']"));
		js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();",termsOfUse);
	//	myAccount.click();
		
		Thread.sleep(2000);
		
		String title = driver.getTitle();
		

		if (title.equals("Terms of Use")) {

			System.out.println("user clicked the Terms of Use link, its redirecting to Terms of Use page");
			Assert.assertTrue(true);
			Reporter.log("user clicked the Terms of Use link, its redirecting to Terms of Use page");

		} else {

			System.out.println("user clicked the Terms of Use link, its not redirecting to Terms of Use page");
			Assert.assertTrue(false);
			Reporter.log("user clicked the Terms of Use link, its not redirecting to Terms of Use page");

		}
	
		Thread.sleep(4000);

	}
	
	
	@Test(priority=27)
	private void privacyNoticy() throws InterruptedException {

		WebElement privacyNotice = driver.findElement(By.xpath("//a[text()='Privacy Notice']"));
		js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();",privacyNotice);
	//	myAccount.click();
		
		Thread.sleep(2000);
		
		String title = driver.getTitle();
		

		if (title.equals("Privacy and Cookie Policy")) {

			System.out.println("user clicked the Privacy Notice link, its redirecting to Privacy Notice page");
			Assert.assertTrue(true);
			Reporter.log("user clicked the Privacy Notice link, its redirecting to Privacy Notice page");

		} else {

			System.out.println("user clicked the Privacy Notice link, its not redirecting to Privacy Notice page");
			Assert.assertTrue(false);
			Reporter.log("user clicked the Privacy Notice link, its not redirecting to Privacy Notice page");

		}
	
		Thread.sleep(4000);	
		
	}
}
