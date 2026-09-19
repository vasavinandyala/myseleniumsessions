package seleniumSessions;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
//import org.openqa.selenium.support.ui.WebDriverWait;

public class FluentWaitConcept {
	
	static WebDriver driver;

	public static void main(String[] args) {
		// Wait(Interface) : until()
		//FluentWait(class) : until{} + other methods
		//WebDriverWait(class) : no methods + can inherit from FluentWait
		
		driver = new ChromeDriver();
		driver.get("https://classic.crmpro.com/");
		
		By locator = By.name("username");
		//wait is with fluentwait features
//		Wait<WebDriver> wait = new FluentWait<WebDriver> (driver)
//							.withTimeout(Duration.ofSeconds(10))
//							.pollingEvery(Duration.ofSeconds(2))
//							.ignoring(NoSuchElementException.class)
//							//.ignoring(StaleElementReferenceException.class) - > can add as no of exceptions you want
//							.withMessage("*******ELEMENT NOT PRESENT ON THE PAGE******");
//		
//		WebElement usernmaeEle = (WebElement) wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
//		usernmaeEle.sendKeys("Vasavi Nandyala");
		
		waitForElementVisiblewithFluentWait(locator, 10, 2).sendKeys("Automation");
//		
		
//		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
//		wait.pollingEvery(Duration.ofSeconds(2))
//			.ignoring(NoSuchElementException.class)
//			.ignoring(StaleElementReferenceException.class)
//			.withMessage("*******ELEMENT NOT PRESENT ON THE PAGE******");
//		
//		
//		
//		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
//		element.sendKeys("UIAutomation");
	}
	
	public static WebElement waitForElementVisiblewithFluentWait(By locator,int timeOut,int pollingTime) {
		
		Wait<WebDriver> wait = new FluentWait<WebDriver> (driver)
				.withTimeout(Duration.ofSeconds(timeOut))
				.pollingEvery(Duration.ofSeconds(pollingTime))
				.ignoring(NoSuchElementException.class)
				.ignoring(StaleElementReferenceException.class) //- > can add as no of exceptions you want
				.withMessage("*******ELEMENT NOT PRESENT ON THE PAGE******");
		
		return  (WebElement)wait.until(ExpectedConditions.visibilityOfElementLocated(locator));


	}

}
