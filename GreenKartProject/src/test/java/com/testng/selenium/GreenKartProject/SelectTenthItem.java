package com.testng.selenium.GreenKartProject;

import java.io.File;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.BaseClass;
import PageObject.ElementObjects;
public class SelectTenthItem {
	 
	WebDriver driver=new ChromeDriver();;

	ElementObjects item= new ElementObjects(driver);	
	
	
	@BeforeTest
	public void initDriver() {
	String path = System.getProperty("user.dir") + File.separator + "Driver" + File.separator
	+ "chromedriver.exe";
	System.setProperty("webdriver.chrome.driver", path);
	driver.get("https://rahulshettyacademy.com/seleniumPractise/");
	
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	}
	
	@BeforeMethod
	public void openBrowser () {
		
		System.out.println("Validation of Selecting Tenth item");
	}
	
	@Test(description="This method validate the item in the cart functionality")
	public void addCartItem () {		
		item.clickaddcart();
		item.cart();
		
	}
	
	@AfterMethod
	public void validateItems() {
		item.SelectsItem();
		item.ValidatePriceTenthitem();
	}
	
	@AfterTest
	public void tearDown() {
	driver.close();
	driver.quit();
	}
	
	
	
}
