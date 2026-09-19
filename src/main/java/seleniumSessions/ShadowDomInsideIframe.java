package seleniumSessions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ShadowDomInsideIframe {
	
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		driver = new ChromeDriver();
		driver.get("https://selectorshub.com/shadow-dom-in-iframe/");
		
		Thread.sleep(3000);
		
		//Structure of the page
		//Browser -> page -> iframe-> shadow dom -> Element
		
		driver.switchTo().frame("pact");
		
		String script = "return document.querySelector(\"#snacktime\").shadowRoot.querySelector(\"#tea\")";
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement teaName = (WebElement)js.executeScript(script);
		teaName.sendKeys("Masala Tea");
		
	}

}
