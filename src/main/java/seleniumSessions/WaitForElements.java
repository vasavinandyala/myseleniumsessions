package seleniumSessions;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitForElements {

static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {

		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		By footer = By.cssSelector("footer a");
		//List<WebElement> elements = driver.findElements(footer);
		
//		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
//		List<WebElement> footerList = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(footer));
//		System.out.println(footerList.size());
		
//		List<WebElement> footerList = waitForElementsPresence(footer, 10);
//		System.out.println(footerList.size());
		
		List<WebElement> footerList = waitForElementsVisible(footer, 10);
		System.out.println(footerList.size());
		
		
	
	}
	
	public static List<WebElement> waitForElementsPresence(By locator,int timeOut) {
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
		
	}
	
	public static List<WebElement> waitForElementsVisible(By locator,int timeOut) {
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
		
	}

}
