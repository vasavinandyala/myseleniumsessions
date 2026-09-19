package seleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ElementIsDisplayed {
	
	static WebDriver driver;

	public static void main(String[] args) {
		
		driver = new ChromeDriver();
		
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		//boolean flag = driver.findElement(By.id("input-email")).isDisplayed();
		//System.out.println(flag);

		By email = By.id("input-email");
		By password = By.name("password1");
		boolean flag = isElementDisplayed(password);
		System.out.println(flag);
		
		flag = isElementDisplayed(email);
		System.out.println(flag);

		System.out.println(driver.getTitle());

		
	}
	
	public static boolean isElementDisplayed(By locator) {
		try{
			return getElement(locator).isDisplayed();
		}
		catch(NoSuchElementException e) {
			System.out.println("Element is not found " + locator);
			//e.printStackTrace();
			return false;
		}
	}
	
	public static  WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

}
