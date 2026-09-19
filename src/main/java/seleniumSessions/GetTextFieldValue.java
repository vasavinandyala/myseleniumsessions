package seleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetTextFieldValue {
	
	static WebDriver driver;

	public static void main(String[] args) {
		
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
//		driver.findElement(By.id("input-email")).sendKeys("vasavi@gmail.com");
//		String text = driver.findElement(By.id("input-email")).getDomProperty("value");
//		System.out.println(text);
		
		By emailId = By.id("input-email");
		getElement(emailId).sendKeys("vasavi@gmail.com");
		String text = getDOMPropertyValue(emailId, "value");
		System.out.println(text);
		
		String placeHolderValue = getDOMAttributeValue(emailId, "placeholder");
		System.out.println(placeHolderValue);
		
		
	}
	public static String getDOMAttributeValue(By locator,String attrName) {
		return getElement(locator).getDomAttribute(attrName);
	}
	
	public static String getDOMPropertyValue(By locator,String attrName) {
		return getElement(locator).getDomProperty(attrName);
	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
}
