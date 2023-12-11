package com.amazon.qa.pages;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.qa.base.TestBase;

public class HomePage extends TestBase {
	//div[@id='nav-xshop']//a
 
	@FindBy(xpath="//span[@id='nav-link-accountList-nav-line-1']")
	WebElement Signin;
	
	@FindBy(xpath="//input[@id='ap_email']")
	WebElement email ;
	
	@FindBy(xpath="//input[@id='ap_password']")
	WebElement password;

	@FindBy(xpath="//input[@id='continue']")
	WebElement continuebtn ;
  
	@FindBy(xpath="//input[@id='signInSubmit']")
	WebElement fsubmitbtn ;
	
	@FindBy(xpath="//span[@id='nav-link-accountList-nav-line-1']")
	WebElement my_name;
	
	@FindBy(xpath="//div[@id='nav-xshop']//a")
	 List<WebElement> HeaderLinks;
	
	@FindBy(xpath="//a[contains(text(),'Warehouse Deals')]")
	WebElement WareHouseEle;
	
	@FindBy(xpath="//h4[contains(text(),'Laptops & Tablets')]")
	WebElement Lap_and_Tab_icon;
	
	@FindBy(xpath="//input[@id='twotabsearchtextbox']")
	WebElement SearchBox;
	
	@FindBy(xpath="//input[@id='nav-search-submit-button']")
	WebElement SearchBtn;
	
	

	//AWS Page
	@FindBy(xpath="//a[text()='Amazon Web Services']")
	WebElement AWSLink;
	
	//coupons page
	@FindBy(xpath="//a[contains(text(),'Coupons')]")
	WebElement couponspagelink;
	
	
	
	//Initilisation of the web elements
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	
	//Action Method
	public String verifyHomePageTitle(){
		return driver.getTitle();
	}
	
	
	public void sign_in(String un, String pwd) {
		Signin.click();
		email.sendKeys(un);
		continuebtn.click();
		password.sendKeys(pwd);
		fsubmitbtn.click();
	}	
	
	public String NameAfterLogin() {
		return my_name.getText();
		
	}
	
	
	public int NumberHeaderLinks() {
		return HeaderLinks.size();
	}
	
	
	public AwsPage clicking_On_AWS() {
		AWSLink.click();
		return new AwsPage();
	}
	
	
	public CouponsPage Nav_To_couponsPage(){
		couponspagelink.click();
		return new CouponsPage();
	}
	
	public String LT_in_Warehouse(){
		WareHouseEle.click();
		return Lap_and_Tab_icon.getText();
	}
	
	public void CartFNTY(String Pro ) {
		SearchBox.sendKeys(Pro);
		SearchBtn.click();
		
		
		
		
		
		
		
	}
	
	
	
	
}
