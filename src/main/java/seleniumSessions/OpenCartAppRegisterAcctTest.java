package seleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OpenCartAppRegisterAcctTest {

	public static void main(String[] args) {
		
		BrowserUtil brUtil = new BrowserUtil();
		WebDriver driver = brUtil.initDriver("chrome");
		ElementUtil eleUtil = new ElementUtil(driver);
		
		//brUtil.launchUrl("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		
		brUtil.launchUrl("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		
		By registerLink = By.linkText("Register");
		eleUtil.doClick(registerLink);
		
		
		String title = brUtil.getPageTitle();
		VerificationUtil.verify(title, "Register Account");
		
		By fName = By.id("input-firstname");
		By lName = By.id("input-lastname");
		By email = By.id("input-email");
		By telPhone = By.id("input-telephone");
		By pwd = By.id("input-password");
		By pwdConfirm = By.id("input-confirm");
		
		
		eleUtil.doSendKeys(fName, "Vasavi");
		eleUtil.doSendKeys(lName, "Reddy");
		eleUtil.doSendKeys(email, "vasavir@gmail.com");//Vasavi@gmail.com,vasavir@gmail.com
		eleUtil.doSendKeys(telPhone, "7207893655");
		eleUtil.doSendKeys(pwd, "Sudheer@456");//Vasavi@123,Sudheer@456
		eleUtil.doSendKeys(pwdConfirm, "Sudheer@456");
		
		By login = By.xpath("//*[@id=\"content\"]/form/div/div/input[2]");
		By rules = By.xpath("//*[@id=\"content\"]/form/div/div/input[1]");
		eleUtil.doClick(rules);
		eleUtil.doClick(login);
		
		title = brUtil.getPageTitle();
		VerificationUtil.verifyContains(title, "Created");
		
		By continueButton = By.xpath("//*[@id=\"content\"]/div/div/a");
		eleUtil.doClick(continueButton);
		
		brUtil.quitBrowser();

	}

}
