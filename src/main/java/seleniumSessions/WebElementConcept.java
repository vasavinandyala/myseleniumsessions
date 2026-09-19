package seleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WebElementConcept {
	
	static WebDriver driver;
	
	public static void main(String[] args) {
		
		BrowserUtil brUtil = new BrowserUtil();
		
		driver = brUtil.initDriver("chrome");
		brUtil.launchUrl("https://naveenautomationlabs.com/opencart/index.php?route=account/login");

		//driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		
		//driver.findElement(By.id("input-email")).sendKeys("tom@gmail.com");
		//driver.findElement(By.id("input-password")).sendKeys("Tom@123");
		
		By email = By.id("input-email");
		By pwd = By.id("input-password");
		
		//......Using methods
		//getElement(email).sendKeys("tom@gmail.com");
		//getElement(pwd).sendKeys("Tom@123");
		
		//......Using ElementUtil
		//doSendKeys(email,"tom@gmail.com");
		//doSendKeys(pwd,"Tom@123");
		
		ElementUtil eleUtil = new ElementUtil(driver);
		eleUtil.doSendKeys(email, "tom@gmail.com");
		eleUtil.doSendKeys(pwd, "Tom@123");
		
		
		brUtil.quitBrowser();
		
	}

}
