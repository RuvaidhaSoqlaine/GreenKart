package GreenKart;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		
		System.setProperty("webdriver.chrome.driver", "C:\\\\drivers\\\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys("Cucumber");
		Thread.sleep(3000);
		
		for(int i=1;i<3;i++) {
			driver.findElement(By.xpath("//a[@class=\"increment\"]")).click();
			
		}
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//button[text()='ADD TO CART']")).click();
	
		
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		
		
		WebElement itemName=driver.findElement(By.xpath("//h4[@class='product-name']"));
		
		System.out.println(itemName.getText());
		
		WebElement selectedItem=driver.findElement(By.xpath("//p[@class='product-name']"));
		System.out.println(selectedItem.getText());

		Assert.assertEquals(itemName.getText(), selectedItem.getText() );
			
		String quantity= driver.findElement(By.xpath("//p[@class=\"quantity\"]")).getText();
		System.out.println(quantity);
		
		
		char itemno = quantity.charAt(0);
		int q=Integer.parseInt(String.valueOf(itemno));
		
		String price=driver.findElement(By.xpath("//p[@class=\"product-price\"]")).getText();
		int p=Integer.parseInt(price);
	
		
		int actualprice = q*p;
		System.out.println("Expected price: "+actualprice);
		
		String cprice = driver.findElement(By.xpath("//p[@class=\"amount\"]")).getText();
		int cartprice=Integer.parseInt(cprice);
		System.out.println("Actual Price :" +cartprice);
		Assert.assertEquals(actualprice,cartprice);

	
	}

}


