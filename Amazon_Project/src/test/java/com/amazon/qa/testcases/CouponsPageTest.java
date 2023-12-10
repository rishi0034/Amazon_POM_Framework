package com.amazon.qa.testcases;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazon.qa.base.TestBase;
import com.amazon.qa.pages.CouponsPage;
import com.amazon.qa.pages.HomePage;
import com.amazon.qa.util.TestUtil;
public class CouponsPageTest extends TestBase {

	HomePage hp;
	CouponsPage cp;
	TestUtil ut;
	public CouponsPageTest() {
		super();
	}

	@BeforeMethod
	public void setup() throws Exception {
	//TestBase.initilization();
	initilization();
	hp = new HomePage();
	cp=hp.Nav_To_couponsPage();
	cp= new CouponsPage();
	//ut=new TestUtil("C:\\QA\\Testing\\NikulTest.xlsx");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test(priority=1)
	public void Validate_Page_Title() {
		String ACT=cp.couponetitle();
		String EXP="Amazon.ca: Coupons: Stores";
		Assert.assertEquals(ACT, EXP);
	}
	
	
	@Test(priority=2)
	public void Validate_Image() {
		
		//System.out.println(ut.getCellData("Data1", "Name", 3));
		boolean flag=cp.ImageDisplayMethod();
		Assert.assertTrue(flag);
	}
	
	
	
	//for Screenshort
	@Test(priority=6)
	public void Fail_Validate_Image() {
		
		//System.out.println(ut.getCellData("Data1", "Name", 3));
		boolean flag=cp.FailImageDisplayMethod();
		Assert.assertTrue(flag);
	}
	
	
	
	
	
	
	@Test(priority=3)
	public void Validate_Text1() {
		String ACT=cp.labeltextmethod();
		String EXP="Search coupons by Brand";
		Assert.assertEquals(ACT, EXP);
	}
	
	@Test(priority=4)
	public void Validate_HeaderSize() {
		int ACT=cp.headercount();
		int EXP=7;
		Assert.assertEquals(ACT, EXP);
	}
	
	@Test(priority=5)
	public void Validate_Text2() throws InterruptedException {
		
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		
		jse.executeScript("window.scrollBy(0,6700)");
		Thread.sleep(6500);
		String ACT=cp.couponsmore();
		String EXP="Most Popular";
		Thread.sleep(6500);
		Assert.assertEquals(ACT, EXP);
	
	}
	
	
	

}
