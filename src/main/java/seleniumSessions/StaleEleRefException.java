package seleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class StaleEleRefException {
	
	static WebDriver driver;

	public static void main(String[] args) {
		
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		By emailId = By.id("input-email");
		
		WebElement userName = driver.findElement(emailId);
		//driver.findElement(emailId).sendKeys("vas@gmail.com");
		userName.sendKeys("vas@gmail.com");
		
		driver.navigate().refresh();
		//driver.findElement(emailId).sendKeys("naveen@gmail.com");
		
		//If used with By locator after refresh still locator value is same
		//If used with webelement after refresh,
		//the value is stale and not available so exception occurs
		
		//inorder to avoid the exception recreate the element or initialize element
		userName = driver.findElement(emailId);
		
		userName.sendKeys("naveen@gmail.com");


	}

}
