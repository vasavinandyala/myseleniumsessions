package seleniumSessions;

import java.time.Duration;
import org.openqa.selenium.TimeoutException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitForTitleAndURL {

	static WebDriver driver;

	public static void main(String[] args) {

		driver = new ChromeDriver();
		driver.get("https://classic.freecrm.com/index.html");
		
		String title = waitForTitleContains("Free CRM software for customer relationship management",5);
		System.out.println(title);
		
		String fullTitle = waitForTitleIs("Free CRM software for customer relationship management, sales, and support.",5);
		System.out.println(fullTitle);
		
		String forURLContains = waitForURLContains("https://classic.freecrm",5);
		System.out.println(forURLContains);
		
		String forURLIs = waitForURLIs("https://classic.freecrm.com/.html",5);
		System.out.println(forURLIs);

	}
		
	public static String waitForTitleContains(String fractionTitleValue,int timeOut) {
			
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeOut));
			
			try{
				wait.until(ExpectedConditions.titleContains(fractionTitleValue));
			}
			catch (TimeoutException e) {
				System.out.println("expected title value : " + fractionTitleValue.toUpperCase() + " is not present");
			}
			
			return driver.getTitle();
			
		}

	public static String waitForTitleIs(String expectedTitleValue,int timeOut) {
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeOut));
		
		try{
			wait.until(ExpectedConditions.titleContains(expectedTitleValue));
		}
		catch (TimeoutException e) {
			System.out.println("expected title value : " + expectedTitleValue.toUpperCase() + " is not present");
		}
		
		return driver.getTitle();
		
	}
	public static String waitForURLContains(String fractionURLValue,int timeOut) {
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeOut));
		
		try{
			wait.until(ExpectedConditions.urlContains(fractionURLValue));
		}
		catch (TimeoutException e) {
			System.out.println("expected URL value : " + fractionURLValue.toUpperCase() + " is not present");
		}
		
		return driver.getCurrentUrl();
		
	}
	public static String waitForURLIs(String expectedURLValue,int timeOut) {
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeOut));
		
		try{
			wait.until(ExpectedConditions.urlToBe(expectedURLValue));
		}
		catch (TimeoutException e) {
			System.out.println("expected URL value : " + expectedURLValue.toUpperCase() + " is not present");
		}
		
		return driver.getCurrentUrl();
		
	}


	
}
