package com.amazon.qa.testdata;

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

	@Test(priority = 2)
	public void SignIn() throws InterruptedException {
		hp.sign_in(prop.getProperty("username"), prop.getProperty("password"));
		String ACT = hp.NameAfterLogin();
		String EXP = "Hello, rishi";
		Assert.assertEquals(ACT, EXP);
	
	}

	@Test(priority = 3)
	public void ValidateNumberOfLinksInHeader() throws InterruptedException {

		Thread.sleep(3000);
		Integer ACT = hp.NumberHeaderLinks();
		Integer EXP = 28;//Integer.getInteger(prop.getProperty("headerlinks"));
		Assert.assertEquals(ACT, EXP);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
