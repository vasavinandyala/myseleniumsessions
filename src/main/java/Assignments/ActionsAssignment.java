package Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsAssignment {

	static WebDriver driver;
	static Actions act;

	public static void main(String[] args) throws InterruptedException {

		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");

		By action1 = By.linkText("Desktops");
		By action2 = By.linkText("PC (0)");
		By action3 = By.linkText("Mac (1)");
		By action4 = By.linkText("MP3 Players");

		By action5 = By.linkText("test 23 (0)");

		By action6 = By.linkText("test 18 (0)");

//		act = new Actions(driver);
//		act.moveToElement(driver.findElement(action1)).perform();
//		Thread.sleep(1000);
//		driver.findElement(action2).click();

		actionHandling(action1, action2);
		actionHandling(action1, action3);
		
		actionHandling(action4, action5);
		actionHandling(action4, action6);

		
		
	}
	
	public static void actionHandling(By action1,By action2) throws InterruptedException {
		act = new Actions(driver);
		act.moveToElement(driver.findElement(action1)).perform();
		Thread.sleep(1000);
		driver.findElement(action2).click();

	}

}
