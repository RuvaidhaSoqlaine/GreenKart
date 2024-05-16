package GreenKart;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		
		System.setProperty("webdriver.chrome.driver", "C:\\\\drivers\\\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		driver.manage().window().maximize();
		
		
		
		List<WebElement> products= driver.findElements(By.cssSelector("h4.product-name"));
		for(int i=0;i<products.size();i++) {
			String name=products.get(i).getText();
			
			if(i==9) {
				driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click();
				
				break;
			}
		}
		Thread.sleep(2000);
		
		
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();

		WebElement itemName=driver.findElement(By.xpath("(//h4[@class='product-name'])[10]"));
		WebElement selectedItem=driver.findElement(By.xpath("//p[@class='product-name']"));
		
		Assert.assertEquals(itemName.getText(), selectedItem.getText() );
		
		System.out.println(driver.findElement(By.xpath("//p[@class='product-name']")).getText());   //selected item
		
		
		String iprice=driver.findElement(By.xpath("//p[@class=\"product-price\"]")).getText();
		int itemprice=Integer.parseInt(iprice);
		System.out.println("Price in item: " +iprice);
		
		
		String cprice = driver.findElement(By.xpath("//p[@class=\"amount\"]")).getText();
		int cartprice=Integer.parseInt(cprice);
		System.out.println("Price in cart: " +cprice);
		
		Assert.assertEquals(itemprice,cartprice);

		Thread.sleep(2000);

	
	}

}
