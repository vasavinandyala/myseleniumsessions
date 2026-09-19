package Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class TabSequenceAssignment {
	
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		
		driver = new ChromeDriver();
		driver.get("https://www.amazon.com/");
			
		WebElement search = driver.findElement(By.xpath("//input[@placeholder='Search Amazon']"));
		Thread.sleep(4000);
		Actions act = new Actions(driver);
		act.sendKeys(Keys.TAB)
				.pause(500)
				.sendKeys(Keys.TAB)
				.pause(500)
				.sendKeys(Keys.TAB)
				.pause(500)
				.sendKeys(Keys.TAB)
				.pause(500)
				.sendKeys(Keys.TAB)
				.pause(500)
				.sendKeys(search,"Macbook")
				.pause(200)
				.sendKeys(Keys.ENTER)
				.build().perform();
		
		driver.quit();
	}
		//can also write sendkeys("Macbook") instead of sendKeys(search,"Macbook")
}
