package seleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsConcept {
	
	static WebDriver driver;
	
	public static void main(String args[]) {
		
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");

		By imagelogo = By.className("img-responsive");
		
		ElementUtil eleUtil = new ElementUtil(driver);

		eleUtil.doClick(imagelogo);
		
	}
	

}
