package seleniumSessions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitForFrame {

	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {

		driver = new ChromeDriver();
		driver.get("https://www.formsite.com/templates/registration-form-templates/vehicle-registration-form/");
		driver.manage().deleteAllCookies();
		By image = By.cssSelector("img[title='Vehicle-Registration-Forms-and-Examples']");
		ElementUtil eleutil = new ElementUtil(driver);
		eleutil.waitForElementVisible(image,5).click();
		
//		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
//		wait
//			.until(ExpectedConditions
//					.frameToBeAvailableAndSwitchToIt(driver
//							.findElement(By.xpath("//iframe[contains(@id,'frame-one')]"))));
		
		
		By frameLocator = By.xpath("//iframe[contains(@id,'frame-one')]");
		
		//Use this for waitForFrame;
//		WebElement frameElement = driver.findElement(By.xpath("//iframe[contains(@id,'frame-one')]"));
//		boolean isFrameAvailable = waitForFrame(frameElement, 10);
		boolean isFrameAvailable = waitForFrameUsingLocator(frameLocator, 10); 
		//--> if not available throws the exception
		if(isFrameAvailable) {
		driver.findElement(By.id("RESULT_TextField-1")).sendKeys("Vasavi Nandyala");
		}

	}
	
	public static boolean waitForFrame(WebElement frameElement,int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		try {
		wait
			.until(ExpectedConditions
					.frameToBeAvailableAndSwitchToIt(frameElement));
		return true;
		
		}
		catch(TimeoutException e) {
			System.out.println("Frame is not present on the page");
			return false;
		}

}
	
	public static boolean waitForFrameUsingLocator(By frameLocator,int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		try {
		wait
			.until(ExpectedConditions
					.frameToBeAvailableAndSwitchToIt(frameLocator));
		return true;
		
		}
		catch(TimeoutException e) {
			System.out.println("Frame is not present on the page");
			return false;
		}

	}
	
	public static boolean waitForFrameUsingIndex(int frameIndex,int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		try {
			wait
				.until(ExpectedConditions
					.frameToBeAvailableAndSwitchToIt(frameIndex));
			return true;
		}
		catch(TimeoutException e) {
			System.out.println("Frame is not present on the page");
			return false;
		}

	}
	
	public static boolean waitForFrameUsingName(String frameNameOrID,int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		try {
			wait
				.until(ExpectedConditions
					.frameToBeAvailableAndSwitchToIt(frameNameOrID));
			return true;
		}
		catch(TimeoutException e) {
			System.out.println("Frame is not present on the page");
			return false;
		}

	}
}
