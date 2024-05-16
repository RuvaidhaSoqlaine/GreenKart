package GreenKart;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test3 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		
		System.setProperty("webdriver.chrome.driver", "C:\\\\drivers\\\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		driver.manage().window().maximize();
		
		String[] itemNeeded={"Cucumber","Brocolli","Beetroot","Carrot"};		
		addItem(driver,itemNeeded);
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
	
		List<WebElement> cItems=driver.findElements(By.cssSelector("p.product-name"));
		for(int i=0;i<4;i++) {
			String cartItems=cItems.get(i).getText();
			System.out.println("The selected item in the cart: " +cartItems);

		}
		
		List itemNeededList=Arrays.asList(itemNeeded);
		System.out.println("The Items to be select: "+itemNeededList);
	
		
		
		driver.findElement(By.xpath("(//a[@class='product-remove'])[3]")).click();
		
		driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();

		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@class='promoBtn']")).click();
		Thread.sleep(3000);
		System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());


		String code="rahulshettyacademy";
		
		driver.findElement(By.cssSelector("input.promocode")).sendKeys(code);
		
		if(code=="rahulshettyacademy") {

			System.out.println("The given promo code is valid");
		}
		else if(code!="rahulshettyacademy") {
			System.out.println("The given promo code is invalid");
		}
		driver.findElement(By.xpath("//button[@class='promoBtn']")).click();
		Thread.sleep(5000);
		System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());

		
		
		
	}
	
	
	
public static void addItem(WebDriver driver,String[] itemNeeded) {
		
		
		List<WebElement> products= driver.findElements(By.cssSelector("h4.product-name"));
		for(int i=0;i<products.size();i++) {
			String[] name=products.get(i).getText().split("-");
			String formattedName= name[0].trim();
			
			List itemNeededList=Arrays.asList(itemNeeded);
			

			if(itemNeededList.contains(formattedName)) {
				int j=0;
				j++;
				driver.findElements(By.xpath("//div[@class=\'product-action\']/button")).get(i).click();
				
				if(j==itemNeeded.length) {
					break;
				}

			}
			
		}
		
		
	}
}

