package com.testng.selenium.GreenKartProject;

import java.io.File;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObject.ElementObjects;

public class FlightBooking {

	
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
	public void FlighBook() {
		object.flightlink();
	
		Set<String> windows= driver.getWindowHandles();      
		Iterator<String> It= windows.iterator();
		String parentId=It.next();
		String childId=It.next();
		driver.switchTo().window(childId);

		object.autosuggest();
		object.IndiaSelect();
		object.FlightTle();
		object.Round();
		object.departure();
		object.CitySel();
		object.Arrival();
		object.ddate();
		object.rdate();
		object.arrdate();
		object.passenger();
		object.Adult();
		object.Child();
		object.Infant();
		object.Done();
		object.Currency();
		object.Checkboxff();
		object.Searchbtn();
	}

	@AfterMethod
	public void validateItems() {
		object.validatepopup();
		driver.switchTo().alert().accept();

	}
	
	@AfterTest
	public void tearDown() {
	driver.close();
	driver.quit();
	}
}
