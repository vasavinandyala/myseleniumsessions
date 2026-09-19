package seleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class NewWindowConcept {

	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {

		driver = new ChromeDriver();
		driver.get("https://orangehrm.com/en/contact-sales");

		String parentWindowId = driver.getWindowHandle();
		System.out.println("Parent window id is : " + parentWindowId);
		
		Thread.sleep(1000);
		
		driver.switchTo().newWindow(WindowType.TAB);//new tab
		//driver.switchTo().newWindow(WindowType.WINDOW);//for new window

		driver.get("https://google.com");
		System.out.println("Tab Id : " + driver.getWindowHandle());
		driver.close();
		
		driver.switchTo().window(parentWindowId);
		System.out.println("Current Window url : " + driver.getCurrentUrl());
		driver.quit();

	}

}
