package com.amazon.qa.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazon.qa.base.TestBase;
import com.amazon.qa.pages.HomePage;

public class HomePageTest extends TestBase {
	HomePage hp;

	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void setup() throws Exception {
		initilization();
		hp = new HomePage();
	}

	@Test(priority = 1)
	public void LoginPageTitle() throws InterruptedException {

		String ActualTitle = hp.verifyHomePageTitle();
		String ExpectedTitle = "Amazon.ca: Low Prices – Fast Shipping – Millions of Items";
		Assert.assertEquals(ActualTitle, ExpectedTitle);

	}

	 @Test(priority=2)
	public void SignIn() throws InterruptedException {
		hp.sign_in(prop.getProperty("username"), prop.getProperty("password"));
		String ACT = hp.NameAfterLogin();
		String EXP = "Hello, rishi";
		Assert.assertEquals(ACT, EXP);

	}

	@Test(priority=3)
	public void ValidateNumberOfLinksInHeader() throws InterruptedException {
		Thread.sleep(3000);
		Integer ACT = hp.NumberHeaderLinks();
		String number = prop.getProperty("headerlinks");
		// System.out.println(number+2);
		// int EXP=Integer.parseInt(number);
		Integer num1 = Integer.valueOf(number);
		System.out.println(num1 + 2);
		// System.out.println(EXP.getClass());

		Assert.assertEquals(ACT, num1);

	}

	 @Test(priority=4)
	public void Awsaction() throws InterruptedException {

		hp.clicking_On_AWS();

		String ACT = driver.getTitle();
		String EXP = "What is Cloud Computing? - Cloud Computing Services, Benefits, and Types - AWS";
		Assert.assertEquals(ACT, EXP);

	}
	 
	 @Test(priority=5)
		public void Validating_Text_In_WarehousePage(){

			
			String ACT = hp.LT_in_Warehouse();
			String EXP = "Laptops & Tablets";
			Assert.assertEquals(ACT, EXP);

		}
	 
	 
	 
	 @Test(priority=6)
		public void Add_To_Cart_Ft() throws Exception{
		 hp.sign_in(prop.getProperty("username"), prop.getProperty("password"));
		 hp.CartFNTY("gold fish snacks");
		 driver.findElement(By.xpath("//img[@alt='Pepperidge Farm Goldfish Family Size Cheddar Crackers, 750 Grams']")).click();
		driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();
		driver.findElement(By.linkText("Go to cart")).click();
		driver.findElement(By.xpath("//span[@id='a-autoid-2-announce']")).click();
		 driver.findElement(By.id("quantity_6")).click();
			Thread.sleep(10000);
		String ACT =driver.findElement(By.xpath("((//div[@data-name='Subtotals'])/span)[4]")).getText().trim();
		String EXP = "$47.82";// there is a space in the item price 
		
	
		Assert.assertEquals(ACT, EXP);

	 }

	 
	 
	 
	 
	 

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
