package seleniumSessions;


import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebElementException {
	
	static WebDriver driver;

	public static void main(String[] args) {
		
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		
		//create webelement + perform action
		try {
			driver.findElement(By.id("input-emai")).sendKeys("Vasavi@gmail.com");
		}
		catch(NoSuchElementException e) {
			System.out.println("Element is not found");
			e.printStackTrace();
		}
		System.out.println("title : " + driver.getTitle());
		
		
	}

}
