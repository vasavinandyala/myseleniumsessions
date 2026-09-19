package seleniumSessions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ShadowDomInChromeSettings {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		driver = new ChromeDriver();
		driver.get("chrome://settings/");
		
		Thread.sleep(2000);
		
		//Structure of the page
		//Browser -> page -> iframe-> shadow dom -> Element
		
		//driver.switchTo().frame("pact");
		
		String script = "return document.querySelector(\"body > settings-ui\").shadowRoot.querySelector(\"#toolbar\").shadowRoot.querySelector(\"#search\").shadowRoot.querySelector(\"#searchInput\")";
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement search = (WebElement)js.executeScript(script);
		//search.sendKeys("notifications");
		
		Actions act = new Actions(driver);
		act.sendKeys(search,"notifications").perform();
	}

}
