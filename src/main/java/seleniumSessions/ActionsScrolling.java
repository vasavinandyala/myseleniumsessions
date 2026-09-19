package seleniumSessions;

import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsScrolling {
	
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		
		driver =new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		//driver.get("https://Amazon.com");
		Actions act = new Actions(driver);
//		act.sendKeys(Keys.PAGE_DOWN).perform();//partial scrolling down
//		
//		Thread.sleep(1000);
//		
//		act.sendKeys(Keys.PAGE_UP).perform();//partially scrolls up
//		
		//go to footer of the page
		//mac: command+down/up arrow
		//windows: control +down/up arrow
		
//		act.sendKeys(Keys.COMMAND).sendKeys(Keys.END).perform();//scrolls to end of the page
//
//		Thread.sleep(1000);
//
//		act.sendKeys(Keys.COMMAND).sendKeys(Keys.HOME).perform();//scrolls back to top
//		
		act
			.scrollToElement(driver.findElement(By.linkText("OpenCart")))
					.click(driver.findElement(By.linkText("OpenCart")))
						.perform();
		
		
		
		
	}

}
