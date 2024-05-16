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

public class CancelOneItem {

	
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
	public void cancelThirdItem() {
		
		object.prod1();
		object.prod2();
		object.prod3();
		object.prod4();
		object.CartLogo();
		object.Compare();
		object.Cancelitem();
		object.checkout();
		object.Applybtn();		
		object.EnterCode();		
	} 
	
	@AfterMethod
  	public void validateItems() {		
		object.Valid();
	}
	
	@AfterTest
	public void tearDown() {
	driver.close();
	driver.quit();
	}
} 
                    