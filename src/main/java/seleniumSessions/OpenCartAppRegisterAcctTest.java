package seleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OpenCartAppRegisterAcctTest {

	public static void main(String[] args) {
		
		BrowserUtil brUtil = new BrowserUtil();
		WebDriver driver = brUtil.initDriver("chrome");
		
		brUtil.launchUrl("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		
		String title = brUtil.getPageTitle();
		VerificationUtil.verify(title, "Register Account");
		
		By fName = By.id("input-firstname");
		By lName = By.id("input-lastname");
		By email = By.id("input-email");
		By telPhone = By.id("input-telephone");
		By pwd = By.id("input-password");
		By pwdConfirm = By.id("input-confirm");
		
		ElementUtil eleUtil = new ElementUtil(driver);
		
		eleUtil.doSendKeys(fName, "Vasavi");
		eleUtil.doSendKeys(lName, "Nandyala");
		eleUtil.doSendKeys(email, "Vasavi@gmail.com");
		eleUtil.doSendKeys(telPhone, "7207893655");
		eleUtil.doSendKeys(pwd, "Vasavi@123");
		eleUtil.doSendKeys(pwdConfirm, "Vasavi@123");
		
		brUtil.quitBrowser();

	}

}
