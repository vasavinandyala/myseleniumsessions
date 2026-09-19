package seleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsClickSendKeys {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		
		driver =new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
	
		Actions act = new Actions(driver);
		By email = By.id("input-email");
		By pwd = By.id("input-password");
		By loginBtn = By.xpath("//input[@value='Login']");
		
		act.sendKeys(driver.findElement(email), "vasavi@gmail.com").perform();
		act.sendKeys(driver.findElement(pwd), "Vasavi@234").perform();
		act.sendKeys(driver.findElement(loginBtn)).perform();
		
		//click = moveToElement + click on middle of the element
		//sendKeys = click + sendKeys
		//sendKeys = moveToElement + click on middle of the element + sendKeys
		
		
		
		
	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	public static void doActionsSendKeys(By locator,String Value) {
		Actions act = new Actions(driver);
		act.sendKeys(getElement(locator), Value).perform();
	}
	
	
}
