package seleniumSessions;

//import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ElementIsPresent {

	static WebDriver driver;

	public static void main(String[] args) {

		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
	
		By emailId = By.id("input-email");
		By forgotPwd = By.linkText("Forgotten Password");
		
	/*	List<WebElement> eleList = driver.findElements(emailId);//size 1
		
		if(eleList.size()==1) {
			System.out.println("Element is present");
		}
		else {
			System.out.println("Element is not present");
		}*/
		
		ElementUtil eleUtil = new ElementUtil(driver);
		
		if(eleUtil.isElementExist(emailId)) {
			System.out.println("PASS");
		}
		else {
			System.out.println("FAIL");
		}
		
		if(eleUtil.isElementExist(forgotPwd,2)) {
			System.out.println("PASS");
		}
		else {
			System.out.println("FAIL");
		}
			
	}
	
	/*public static Boolean isElementExist(By locator) {
		if(driver.findElements(locator).size() == 1) {
			System.out.println("the element : " + locator + " Is present one time");
			return true;
		}
		else {
			System.out.println("the element : " + locator + "Is not present");

			return false;
		}
	}
	
	public static Boolean isElementExist(By locator, int expEleCount) {
		if(driver.findElements(locator).size() == expEleCount) {
			System.out.println("the element : " + locator + " Is present " + expEleCount + " times" );
			return true;
		}
		else {
			System.out.println("the element : " + locator + "Is not present" + expEleCount + " times");

			return false;
		}
	}
*/
}
