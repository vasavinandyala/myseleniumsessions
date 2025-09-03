package seleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OpenCartAppLoginTest {

	public static void main(String[] args) {

		BrowserUtil brUtil = new BrowserUtil();
		WebDriver driver = brUtil.initDriver("chrome");
		
		brUtil.launchUrl("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		
		String title = brUtil.getPageTitle();
		VerificationUtil.verify(title, "Account Login");
		
		By email = By.id("input-email");
		By pwd = By.id("input-password");
		
		ElementUtil eleUtil = new ElementUtil(driver);
		
		eleUtil.doSendKeys(email, "tom@gmail.com");
		eleUtil.doSendKeys(pwd, "Tom@123");
		
		brUtil.quitBrowser();
		
		
	}

}
