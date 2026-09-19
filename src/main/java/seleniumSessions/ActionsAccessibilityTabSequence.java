package seleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsAccessibilityTabSequence {

	static WebDriver driver;

	public static void main(String[] args){

		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		WebElement fname = driver.findElement(By.id("input-firstname"));
		Actions act = new Actions(driver);
		act.sendKeys(fname,"Vasavi")
			.pause(500)
				.sendKeys(Keys.TAB)
					.sendKeys("Nandyala")
						.pause(500)
							.sendKeys(Keys.TAB)
							.sendKeys("vasavi@gmail.com")
							.pause(500)
							.sendKeys(Keys.TAB)
							.sendKeys("7207893655")
								.pause(500)
									.sendKeys(Keys.TAB)
										.sendKeys("Vasavi@234")
											.pause(500)
												.sendKeys(Keys.TAB)
													.sendKeys("Vasavi@234")
														.pause(500)																.sendKeys(Keys.TAB)																			.pause(500)
															.sendKeys(Keys.TAB)
															.pause(500)
															.sendKeys(Keys.TAB)
															.pause(500)
															.sendKeys(Keys.SPACE)	//checkbox selection can't use click for checkbox
															.pause(500)
															.sendKeys(Keys.TAB)
															.sendKeys(Keys.ENTER);	//enter or space can work for selection																.build().perform();
		
		
		
		driver.quit();
																			
																			
		
		
	}

}
