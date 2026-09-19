package seleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsMoveToElement {
	
	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {

		driver = new ChromeDriver();
		driver.get("https://www.spicejet.com/");
		
//		Actions act = new Actions(driver);
//		Thread.sleep(2000);
//		
//		WebElement addons = driver.findElement(By.xpath("//div[text()='Add-ons']"));
//		//1.
//		act.moveToElement(addons).perform();
//		//2.
//		act.moveToElement(addons).build().perform();//1 and 2 are doing the same actions biuld and perform
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//div[@class='css-76zvg2 r-homxoj r-ubezar'] [ text()='Visa Services']")).click();
//		
		
		By ParentMenu = By.xpath("//div[text()='Add-ons']");
		By ChildMenu = By.xpath("//div[@class='css-76zvg2 r-homxoj r-ubezar'] [ text()='Visa Services']");
		menuSubMenuHandling(ParentMenu, ChildMenu);
		
		
		
	}
	
	public static void menuSubMenuHandling(By ParentMenu, By ChildMenu) throws InterruptedException {
		Actions act = new Actions(driver);
		act.moveToElement(getElement(ParentMenu)).perform();
		Thread.sleep(2000);
		getElement(ChildMenu).click();
		
	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

}
