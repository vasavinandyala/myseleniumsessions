package seleniumSessions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PsuedoElementConcept {

	public static void main(String[] args) {
		// Pusedo elements used with pusedo classes
		//Pusedo classes are any class starts with ::before or ::after
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");

		String script = ("return window.getComputedStyle(document.querySelector(\"label[for='input-firstname']\"),'::before').getPropertyValue('content')");
		String script2 = ("return window.getComputedStyle(document.querySelector(\"#input-telephone\"),'::before').getPropertyValue('content')");

		JavascriptExecutor js = (JavascriptExecutor)driver;
		String content = js.executeScript(script).toString();
		System.out.println(content);
		
		if(content.contains("*")) {
			System.out.println("First Name is mandatory field");
		}
		
		String content2 = js.executeScript(script2).toString();
		System.out.println(content2);
		
		if(content.contains("*")) {
			System.out.println("Telephone is mandatory field");
		}
		
		
	}

}
