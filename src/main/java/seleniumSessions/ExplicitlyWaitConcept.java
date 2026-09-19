package seleniumSessions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitlyWaitConcept {
	
	static WebDriver driver;

	public static void main(String[] args) {
		
		//Wait(interface) - until();
		//FluentWait(class)[until(){} + individual methods];  
		//--- implements Wait(interface) - Until();
		//WebDriverWait(child class) extends FluentWait(class)
			//no methods in WebDriverWait(), can access all methods from FluentWait
		
		
		/* Exp Wait:
		 * Can be applied for a specific element on the basis of some condition
		 * no need to apply as a global wait
		 * it can be applied for non webelements also :windows,title,url,alerts etc.
		 */
		
		 driver = new ChromeDriver();

		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		By emailId = By.id("input-email");
		By password = By.id("input-password");
		By loginBtn = By.xpath("//input[@value='Login']");
		
//		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
//		WebElement emailEle = wait.until(ExpectedConditions.presenceOfElementLocated(emailId));
//		emailEle.sendKeys("naveen@open.com");
//		driver.findElement(password).sendKeys("test@123");
//		driver.findElement(loginBtn).click();

		//waitForElementPresence(emailId, 10).sendKeys("naveen@gmail.com");
		waitForElementVisible(emailId, 10).sendKeys("naveen@opencart.com");
		getElement(password).sendKeys("test@123");
		getElement(loginBtn).click();


	}
	
	public static WebElement waitForElementPresence(By locator,int timeout) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeout));
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));

		
	}
	
	public static WebElement waitForElementVisible(By locator,int timeout) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeout));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

		
	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

}
