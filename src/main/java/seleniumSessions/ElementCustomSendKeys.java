package seleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ElementCustomSendKeys {

	static WebDriver driver;
	
	public static void main(String[] args) {
		
		driver = new ChromeDriver();
		
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
			
		ElementUtil eleUtil = new ElementUtil(driver);
		
		By firstName = By.id("input-firstname");
		eleUtil.doMultipleSendKeys(firstName, "Vasavi"," ","Reddy", " ","Nandyala",null);	
		
		//cannot put a trycatch block for multiple charsequence 
		//if one of the value is null we cannot handle that.
		
		
	}

}
