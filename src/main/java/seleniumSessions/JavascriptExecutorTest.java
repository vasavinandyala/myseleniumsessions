package seleniumSessions;

import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavascriptExecutorTest {
	
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		
		driver = new ChromeDriver();
		driver.get("https://classic.crmpro.com");
		
		//interface to interface casting
		
//		JavascriptExecutor js = (JavascriptExecutor)driver;
//		String title = js.executeScript("return document.title").toString();
//		System.out.println(title);
//		
//		driver.quit();
		
		JavascriptUtil jsUtil = new JavascriptUtil(driver);
//		String title = jsUtil.getTitleByJS();
//		System.out.println("title is : " + title);
//		
//		//On console history.go(0); refreshes the page in javascript
//		//history.go(-1) -> navigates page back
//		//history.go(1) -> navigates page forward 
//		
//		System.out.println(jsUtil.getURLByJS());
//		
//		jsUtil.refreshBrowserByJS();
//		
//		jsUtil.generateAlert("This is login Page");
//		//document.documentElement.innerText -- all the text displayed fromt the page
//		
//		String pageText = jsUtil.getPageInnerText();
//		System.out.println(pageText);
//		
//		if(pageText.contains("Calls & voice")) {
//			System.out.println("PASS");
//		}
//		
//		jsUtil.scrollPageDown();
//		Thread.sleep(2000);
//		jsUtil.scrollPageUp();
		
//		WebElement element = driver.findElement(By.xpath("//h3[text()='Companies & Contacts']"));
//		jsUtil.scrollIntoView(element);
//		

		WebElement forgotPwdLink = driver.findElement(By.linkText("Forgot Password?"));
		jsUtil.clickElementByJS(forgotPwdLink);
		
		
	}

}
