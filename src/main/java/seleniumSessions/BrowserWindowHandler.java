package seleniumSessions;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class BrowserWindowHandler {
	
	//if target=_blank then the link ll be opened in new window
	
	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {

		driver = new ChromeDriver();
		driver.get("https://orangehrm.com/en/contact-sales");
		driver.findElement(By.xpath("//*[@id=\"CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll\"]")).click();
		Thread.sleep(4000);
		Actions act = new Actions(driver);
		act.sendKeys(Keys.COMMAND).sendKeys(Keys.END).perform();
		driver.findElement(By.xpath("(//a[@href=\"https://orangehrm.com/resources/e-books\"])[2]")).click();
		
		//1. get window id's:
		Set<String> windowHandles = driver.getWindowHandles();
		
		Iterator<String> it = windowHandles.iterator();
		String parentWindowId = it.next();
		System.out.println(parentWindowId);
		
		String childWindowId = it.next();		
		System.out.println(childWindowId);
		
		//2. Switching work:
		
		driver.switchTo().window(childWindowId);
		System.out.println("Child window url : " + driver.getCurrentUrl());
		//close the child window
		driver.close();
		//driver is lost after closing the child window
		
		driver.switchTo().window(parentWindowId);
		System.out.println("Parent window url : " + driver.getCurrentUrl());
		act.sendKeys(Keys.COMMAND).sendKeys(Keys.HOME);
		driver.findElement(By.id("Form_getForm_FullName")).sendKeys("Vasavi Nandyala");
		Thread.sleep(4000);
		driver.quit();
		
		
	}

}
