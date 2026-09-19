package seleniumSessions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ShadowDomConcept {
	
	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		
		driver = new ChromeDriver();
		driver.get("https://selectorshub.com/iframe-in-shadow-dom");
		Thread.sleep(2000);
		
		//Structure of the page
		//Browser -> page -> shadow dom -> shadow dom -> Element
		
		//driver.findElement(By.id("pizza")).sendKeys("Cheese");
		//-> cannot access the element due to shadow root -- NoSuchElementException
		//coy the JS Path and paste in console its gives the html element
		
		String script = "return document.querySelector(\"#userName\").shadowRoot.querySelector(\"#app2\").shadowRoot.querySelector(\"#pizza\")";
		//return html element
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		//DOM Html Element --> WebElement
		// conbvert html element to webelement
		
		WebElement pizzaName = (WebElement)js.executeScript(script);
		pizzaName.sendKeys("Cheese");
		
		
		

	}

}
