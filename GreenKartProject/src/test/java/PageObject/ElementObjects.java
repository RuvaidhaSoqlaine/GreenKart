package PageObject;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Function;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

public class ElementObjects {
	
	WebDriver driver;
	public ElementObjects(WebDriver driver) {
		this.driver=driver;
		
	}

	//SelectTenthItem
	By addcart=By.xpath("(//button[text()='ADD TO CART'])[10]");
	By cart=By.className("cart-icon");
	By itemsel=By.xpath("(//h4[@class='product-name'])[10]");
	By selecteditem=By.cssSelector("p[class='product-name']");
	By iprice=By.cssSelector("p[class='product-price']");
	By cprice=By.className("amount");
	
	
	
	public void clickaddcart() {
		driver.findElement(addcart).click();
	}
	
	public void cart() {
		driver.findElement(cart).click();
	}
	
    public void SelectsItem() {
		
		String Item1= driver.findElement(itemsel).getText();
		
		String Item2= driver.findElement(selecteditem).getText();
		
		Assert.assertEquals(Item1,Item2);
		
		System.out.println("The item to be select: "+Item1);
		
		System.out.println("The selected item is: "+Item2);


	}

   public void  ValidatePriceTenthitem() {
	
    String price1= driver.findElement(iprice).getText();
	
	String price2= driver.findElement(cprice).getText();
	
	Assert.assertEquals(price1,price2);
	
	System.out.println("The price of an item to be select: "+price1);
	
	System.out.println("The price of the selected item is: "+price2);
	
}
	
	//SelectMultipleItems
	By search=By.className("search-keyword");
	By plus=By.className("increment");
	By cartbtn=By.xpath("//button[text()='ADD TO CART']");
	By Item=By.xpath("//h4[@class='product-name']");
	By Cartitem=By.className("product-name");
	By quantity=By.className("quantity");
	By price=By.xpath("//p[@class='product-price']");
	
	

public void clicksearch() {
	driver.findElement(search).sendKeys("Cucumber");
}

public void clickplus() {
	
	driver.findElement(plus).click();


}

public void Cartbutton() {
	driver.findElement(cartbtn).click();
}

public void CartLogo() {
	driver.findElement(cart).click();
	
}



public void ValidateItem() {
	
	Assert.assertEquals(driver.findElement(Item).getText(),driver.findElement(Cartitem).getText());
	
	System.out.println("The item to be select: "+driver.findElement(Item).getText());
	
	System.out.println("The selected item is: "+driver.findElement(Cartitem).getText());

	

}


public void ValidatePriceMultipleItem() {
	String Quantity=driver.findElement(quantity).getText();
	System.out.println(Quantity);
	
	char itemnum = Quantity.charAt(0);

	int quan=Integer.parseInt(String.valueOf(itemnum));
	
	String Price=driver.findElement(price).getText();
	int pri=Integer.parseInt(Price);
	
	int actualitemprice = quan*pri;
	System.out.println("Expected price: "+actualitemprice);
	
	
	String Cprice = driver.findElement(cprice).getText();
	int cartitemprice=Integer.parseInt(Cprice);
	System.out.println("Cart Price :" +cartitemprice);
	Assert.assertEquals(actualitemprice,cartitemprice);
}
		

	//CancelOneItem
	By product1=By.xpath("(//button[text()='ADD TO CART'])[1]");
	By product2=By.xpath("(//button[text()='ADD TO CART'])[2]");
	By product3=By.xpath("(//button[text()='ADD TO CART'])[3]");
	By product4=By.xpath("(//button[text()='ADD TO CART'])[4]");
	By cItems=By.cssSelector("p.product-name");
	By cancel=By.xpath("(//a[@class='product-remove'])[3]");
	By CheckOut=By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]");
	By Apply=By.className("promoBtn");
	By EnterPromo=By.className("promoCode");
	By popup=By.cssSelector("span.promoInfo");

	
	public void prod1() {
		driver.findElement(product1).click();
	}
	
	public void prod2() {
		driver.findElement(product2).click();
	}
	
	public void prod3() {
		driver.findElement(product3).click();
	}
	
	public void prod4() {
		driver.findElement(product4).click();
	}
		
	public void Compare() {		
		String[] itemNeeded={"Brocolli - 1 Kg","Cucumber - 1 Kg", "Carrot - 1 Kg", "Beans - 1 Kg"};
		List itemNeededList=Arrays.asList(itemNeeded);
		System.out.println("The Items to be select: "+itemNeededList);
		String[] ItemNum= new String[4] ;
		int x=0;
		for(int i=0;i<ItemNum.length;i++) {
			String cartItems=driver.findElements(cItems).get(i).getText();			
			ItemNum[x] = cartItems;
			x++;
		}
		List actuallist=Arrays.asList(ItemNum);
        System.out.println(actuallist);
	Assert.assertEquals(itemNeededList,actuallist);	
	}	
	public  void Cancelitem() {
		driver.findElement(cancel).click();
	}
	
	public void checkout() {
		driver.findElement(CheckOut).click();
	}
	
	public void Applybtn() {
		driver.findElement(Apply).click();
		System.out.println(driver.findElement(popup).getText());


	}
	
	public void EnterCode() {		
		driver.findElement(EnterPromo).sendKeys("rahulshettyacademy");

	}
	
	public void Valid() {

		driver.findElement(Apply).click();
		
	Wait<WebDriver> wait= new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(50)).pollingEvery(Duration.ofSeconds(5)).ignoring(NoSuchElementException.class);
		
		final WebElement popupafter = driver.findElement(By.cssSelector("span[style=\"color: green;\"]")); 
		WebElement foo = wait.until(new Function<WebDriver , WebElement>() {
			public WebElement apply(WebDriver driver) {
				if(popupafter.isDisplayed()) {
					return popupafter;
				}
				else
				return null;
			}
		});

        String code="rahulshettyacademy";
		if(code=="rahulshettyacademy") {
			System.out.println("The given promo code is valid");
		}
		else if(code!="rahulshettyacademy") {
			System.out.println("The given promo code is invalid");
		}		
		
	
		System.out.println(driver.findElement(popup).getText());

	}
	
	
	//CancelMultipleItem
	
	By product5=By.xpath("(//button[text()='ADD TO CART'])[5]");
	By product6=By.xpath("(//button[text()='ADD TO CART'])[6]");
	By product7=By.xpath("(//button[text()='ADD TO CART'])[7]");
	By item6=By.xpath("(//p[@class='product-name'])[6]");
	By cancel3=By.xpath("(//a[@class='product-remove'])[3]");
	By cancel6=By.xpath("(//a[@class='product-remove'])[6]");
	By order=By.xpath("//button[text()='Place Order']");
	By select=By.xpath("//div/select");
	By check=By.xpath("//input[@type='checkbox']");
	By proceed=By.xpath("//button[text()='Proceed']");
	By Message=By.xpath("//div[@class='wrapperTwo']");

	public void product1() {
		driver.findElement(product1).click();
	}
	
	public void product2() {
		driver.findElement(product2).click();
	}
	
	public void product3() {
		driver.findElement(product3).click();
	}
	
	public void product4() {
		driver.findElement(product4).click();
	}
	

	public void product5() {
		driver.findElement(product5).click();
	}
	

	public void product6() {
		driver.findElement(product6).click();
	}
	

	public void product7() {
		driver.findElement(product7).click();
	}
	
	
	public void CompareItems() {
		
		String[] itemNeeded={"Brocolli - 1 Kg","Cucumber - 1 Kg","Carrot - 1 Kg","Beans - 1 Kg", "Capsicum"};		
		List itemNeededList=Arrays.asList(itemNeeded);
		System.out.println("The Items to be select: "+itemNeededList);		
		System.out.println("The sixth element is: "+driver.findElement(item6).getText());		
		String[] ElementSize= new String[5] ;		
		int x=0;
		for(int i=0;i<ElementSize.length;i++) {			
			String cartItems=driver.findElements(cItems).get(i).getText();			
			ElementSize[x] = cartItems;
			x++;			
		}
		List actuallist=Arrays.asList(ElementSize);		
        System.out.println(actuallist);		
	Assert.assertEquals(itemNeededList,actuallist);
	}	
	public  void Cancelitem3() {
		driver.findElement(cancel3).click();
	}
	
	public  void Cancelitem6() {
		driver.findElement(cancel6).click();
	}
	
	public void placeorder() {
		driver.findElement(order).click();
	}
	
	public void selectlist() {
		//select.click();
		Select dd=new Select(driver.findElement(select));
		dd.selectByValue("India");
	}
	
	public void CheckBox() {
		driver.findElement(check).click();
	}
	
	public void Proceed() {
		driver.findElement(proceed).click();
	}
	
	public void validate() {
				
//		String mes=driver.findElement(Message).getText();
//		
//		String message="Thank you, your order has been placed successfully"
//				+ "You'll be redirected to Home page shortly!!";
//		Assert.assertEquals(mes,message);
//				
//		System.out.println("The popup message is: "+mes);
		
		System.out.println("The popup message is: "+driver.findElement(Message).getText());
	}
	
	
	//FlightBooking
	
	By flight=By.xpath("//a[text()='Flight Booking']");
	By autosug=By.xpath("//input[@id='autosuggest']");
	By SelIndia=By.xpath("//a[text()='India']");
	By flighttitle=By.xpath("(//span[text()='Flights'])[1]");
	By round=By.xpath("(//input[@value='RoundTrip'])[1]");
	By depart=By.id("ctl00_mainContent_ddl_originStation1_CTXTaction");
	By city=By.xpath("//a[@value='BLR']");
	By arrive=By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']");
	By date=By.cssSelector(".ui-state-default.ui-state-highlight");
	By returndate=By.id("ctl00_mainContent_view_date2");
	By ardate=By.xpath("(//a[@class='ui-state-default'])[6]");
	By pass=By.id("divpaxinfo");
	By adult=By.id("hrefIncAdt");
	By child=By.id("hrefIncChd");
	By infant=By.id("hrefIncInf");
	By done=By.id("btnclosepaxoption");
	By currency=By.id("ctl00_mainContent_DropDownListCurrency");
	By checkbox=By.xpath("//input[@id='ctl00_mainContent_chk_friendsandfamily']");
	By searchflight=By.name("ctl00$mainContent$btn_FindFlights");

	
	public void flightlink() {
		driver.findElement(flight).click();		
	}
	
	public void autosuggest() {
		driver.findElement(autosug).sendKeys("India");		
	}
	
	public void IndiaSelect(){
		driver.findElement(SelIndia).click();
	}
	
	public void FlightTle() {
		driver.findElement(flighttitle).click();
	}
	
	public void Round() {
		driver.findElement(round).click();
	}
	
	public void departure() {
		driver.findElement(depart).click();
	}
	
	public void CitySel() {
		driver.findElement(city).click();
	}
	
	public void Arrival() {
		driver.findElement(arrive).click();
	}
	
	public void ddate() {
		driver.findElement(date).click();
	}
	
	public void rdate() {
		driver.findElement(returndate).click();
	}
	
	public void arrdate() {
		driver.findElement(ardate).click();
	}
	
	public void passenger() {
		driver.findElement(pass).click();		
	}
	
	public void Adult() {
		
		for(int i=1;i<2;i++) {
			driver.findElement(adult).click();
		}
	}
	
	public void Child() {
		driver.findElement(child).click();		
	}
	
	public void Infant() {
		driver.findElement(infant).click();		
	}
	
	public void Done() {
		driver.findElement(done).click();		
	}
	
	public void Currency() {		
		Select dropdown= new Select(driver.findElement(currency));
		dropdown.selectByValue("INR");		
	}
	
	public void Checkboxff() {		
		Assert.assertFalse(driver.findElement(checkbox).isSelected());
		driver.findElement(checkbox).click();		
		Assert.assertTrue(driver.findElement(checkbox).isSelected());
		System.out.println(driver.findElement(checkbox).isSelected()); //print true		
	}
	
	public void Searchbtn() {
		driver.findElement(searchflight).click();		
	}
	
	public void validatepopup() {		
		String pop=driver.switchTo().alert().getText();		
		String popup="Family and Friends discount is applicable for a minimum of 4 passenger (excluding infant) on a single booking. Terms and conditions apply.";
		Assert.assertEquals(pop,popup);				
		System.out.println("The popup message is: "+pop);
	}
}
