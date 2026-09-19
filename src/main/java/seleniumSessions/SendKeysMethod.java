package seleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SendKeysMethod {

	static WebDriver driver;
	
	public static void main(String[] args) {
		
		driver = new ChromeDriver();
		
		/*driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		
		String emailId = "vasavi@gmail.com";
		StringBuilder emailBuilder = new StringBuilder("tom@gmail.com");
		StringBuffer emailBuffer = new StringBuffer("vasavir@gmail.com");

		//driver.findElement(By.id("input-email")).sendKeys(emailId);
		//driver.findElement(By.id("input-email")).sendKeys(emailBuilder);
		//driver.findElement(By.id("input-email")).sendKeys(emailBuffer);
		driver.findElement(By.id("input-email")).sendKeys(emailId,emailBuilder,emailBuffer);
		*/
		
		
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		
	/*	String firstname = "Vasavi";
		String middlename = "Reddy";
		String lastname = "Nandyala";
		
		
		driver.findElement(By.id("input-firstname")).sendKeys(firstname,middlename,lastname);
	*/
		
		//keysToSend cannot be null
		//driver.findElement(By.id("input-firstname")).sendKeys(null);
		
		ElementUtil eleUtil = new ElementUtil(driver);
		
		By firstName = By.id("input-firstname");
		eleUtil.doSendKeys(firstName, "Sudheer");

		//sendkeys:
		//singke values are allowed
		//multiple values are also allowed
		//String,stringbuffer,stringbuilder are allowed
		//null - not allowed
		//cannot put a trycatch block for multiple charsequence if one of the value is null we cannot handle that.
		
	}

}
