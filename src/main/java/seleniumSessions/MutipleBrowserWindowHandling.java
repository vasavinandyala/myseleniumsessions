package seleniumSessions;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MutipleBrowserWindowHandling {

	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {

		driver = new ChromeDriver();
		driver.get("https://orangehrm.com/en/contact-sales");
		
		String parentWindowId = driver.getWindowHandle();
		
		driver.findElement(By.xpath("//*[@id=\"CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll\"]")).click();
		Thread.sleep(4000);
		
		Actions act = new Actions(driver);
		act.sendKeys(Keys.COMMAND).sendKeys(Keys.END).perform();
		
		WebElement fbEle = driver.findElement(By.xpath("//img[@alt='facebook']"));
		WebElement linkedEle = driver.findElement(By.xpath("//img[@alt='linkedin']"));
		WebElement ytEle = driver.findElement(By.xpath("//img[@alt='youtube']"));
		
		fbEle.click();
		linkedEle.click();
		ytEle.click();
		
		Set<String> windowHandles = driver.getWindowHandles();
		Iterator<String> it = windowHandles.iterator();
		
		while (it.hasNext()) {
			String windowId = (String) it.next();
			driver.switchTo().window(windowId);
			System.out.println(driver.getCurrentUrl() + " : " + driver.getTitle());
			if(!windowId.equals(parentWindowId)) {
				driver.close();
			}
			Thread.sleep(1000);
		}
		driver.switchTo().window(parentWindowId);
		System.out.println("Current window Url is : " + driver.getCurrentUrl());
		driver.quit();
	
	}

}
