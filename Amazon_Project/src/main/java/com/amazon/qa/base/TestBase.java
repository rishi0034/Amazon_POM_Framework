package com.amazon.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.amazon.qa.util.TestUtil;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	
	public  TestBase() {
		
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("C:\\IT_SQUARE\\IT_QA\\Selenium_WorkSpace\\Amazon_Project\\src\\main\\java\\com\\amazon\\qa\\config\\config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			//e.printStackTrace();
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	public static void initilization() throws InterruptedException {
		String browserName=prop.getProperty("browser");
		if (browserName.equals("chrome")) {

			System.setProperty("webdriver.chrome.driver", "C:\\QA\\SeleniumJars\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
			driver = new ChromeDriver();
			// driver.get("https://classic.freecrm.com/index.html");

		} else if (browserName.equals("Firefox")) {

	   //  System.setProperty("webdriver.gecko.driver", "C:\\QA\\SeleniumJars\\geckodriver.exe");

		//	System.setProperty("webdriver.gecko.driver", "D:\\Selenuimjars_1\\geckodriver.exe");
			driver = new FirefoxDriver();

			
			
			
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			//driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
			// above is @deprecated method, due to some security reasons this method 
	     	//is no longer is appreciated to 
	     	//Thread.sleep(5000);
	        driver.manage().timeouts().implicitlyWait(/*Duration.ofSeconds(TestUtil.IMPLICIT_WAIT)*/
	        		Duration.ofSeconds(TestUtil.IMPLICT_WAIT));
	        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtil.PAGE_LOAD_TIMEOUT));
			driver.get(prop.getProperty("url"));
			Thread.sleep(4000);
			
			
			
			
			
			
		}
		
		

	      
      
		
		
		
		
	}
	
	
	
	
	
}