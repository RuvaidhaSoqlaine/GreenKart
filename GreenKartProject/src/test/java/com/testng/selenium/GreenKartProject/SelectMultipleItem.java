package com.testng.selenium.GreenKartProject;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import PageObject.ElementObjects;

public class SelectMultipleItem {

	WebDriver driver=new ChromeDriver();
	ElementObjects increment= new ElementObjects(driver);
	
	@BeforeTest
	public void initDriver() {
	String path = System.getProperty("user.dir") + File.separator + "Driver" + File.separator
	+ "chromedriver.exe";
	System.setProperty("webdriver.chrome.driver", path);
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	}
	
	@BeforeMethod
	public void openBrowser () {
	driver.get("https://rahulshettyacademy.com/seleniumPractise/");
	}
	
	@Test(description="This method validate the multiple items in the cart functionality")
	public void addMultipleItems () {
		increment.clicksearch();		
		 for(int i=1;i<3;i++) {
		    	increment.clickplus();
		    }
		increment.Cartbutton();
		increment.CartLogo();		
	}
	
	@AfterMethod
	public void validateItems() {
		increment.ValidateItem();
		increment.ValidatePriceMultipleItem();
	}
	
	@AfterTest
	public void tearDown() {
	driver.close();
	driver.quit();
	}
}
