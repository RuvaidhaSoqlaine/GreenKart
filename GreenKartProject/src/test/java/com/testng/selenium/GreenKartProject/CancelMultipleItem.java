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

public class CancelMultipleItem {

	
	WebDriver driver=new ChromeDriver();
	ElementObjects object= new ElementObjects(driver);
	
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
	
	@Test
	public void cancelMultipleItems() {
		object.product1();
		object.product2();
		object.product3();
		object.product4();
		object.product5();
		object.product6();
		object.product7();
		object.CartLogo();
		object.Compare();
		object.Cancelitem6();
		object.Cancelitem3();
		object.checkout();
		object.placeorder();
		object.selectlist();
		object.CheckBox();
		object.Proceed();		
	}
	
	@AfterMethod
	public void validateItems() {		
		object.validate();
	}
	
	@AfterTest
	public void tearDown() {
	driver.close();
	driver.quit();
	}
}
