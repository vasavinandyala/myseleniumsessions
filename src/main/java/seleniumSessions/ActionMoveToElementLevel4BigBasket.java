package seleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionMoveToElementLevel4BigBasket {

	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {

		driver = new ChromeDriver();
		driver.get("https://www.bigbasket.com/");
		
		By menuLevel1 = By.xpath("(//span[text()='Shop by'])[2]");
		By menuLevel2 = By.linkText("Beverages");
		By menuLevel3 = By.linkText("Tea");
		By menuLevel4 = By.linkText("Green Tea");
		
		ElementUtil eleUtil = new ElementUtil(driver);
		eleUtil.menuSubHandlingLevel4(menuLevel1, menuLevel2, menuLevel3, menuLevel4, "click");
		
	//	menuSubHandlingLevel4(menuLevel1,menuLevel2,menuLevel3,menuLevel4);
		
	}
	
	public static void menuSubHandlingLevel4(By menuLevel1, By menuLevel2, By menuLevel3,By menuLevel4) throws InterruptedException {
		Actions act = new Actions(driver);
		Thread.sleep(1000);
		driver.findElement(menuLevel1).click();
		Thread.sleep(1000);
		act.moveToElement(driver.findElement(menuLevel2)).perform();
		Thread.sleep(1000);
		act.moveToElement(driver.findElement(menuLevel3)).perform();
		Thread.sleep(1000);
		driver.findElement(menuLevel4).click();;
	}

}
