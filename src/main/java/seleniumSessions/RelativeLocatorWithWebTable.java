package seleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import static  org.openqa.selenium.support.locators.RelativeLocator.with;

public class RelativeLocatorWithWebTable {
	
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		driver = new ChromeDriver();
		driver.get("https://selectorshub.com/xpath-practice-page/");
		Thread.sleep(3000);
		
		selectUserName("Joe.Root");
		
		WebElement usernameEle = driver.findElement(By.linkText("Joe.Root"));

		String abovePlayer = driver.findElement(RelativeLocator.with(By.tagName("a")).above(usernameEle)).getText();
		System.out.println(abovePlayer);
		
		String belowPlayer = driver.findElement(with(By.tagName("a")).below(usernameEle)).getText();
		System.out.println(belowPlayer);
		
		//if import static  org.openqa.selenium.support.locators.RelativeLocator.with;
		//if above is imported then RelativeLocator.with() can be written as with()
		String rightUserRole = driver.findElement(with(By.tagName("td")).toRightOf(usernameEle)).getText();
		System.out.println(rightUserRole);
		
		List<WebElement> belowLinks = driver.findElements(RelativeLocator.with(By.tagName("a")).below(usernameEle));
		System.out.println(belowLinks.size());
		for(WebElement e : belowLinks) {
			String text=e.getText();
			System.out.println(text);
		}
	}
	
	public static void selectUserName(String username) {
		
		WebElement usernameEle = driver.findElement(By.linkText(username));

		driver.findElement(RelativeLocator.with(By.name("chkSelectRow[]")).toLeftOf(usernameEle)).click();
	
	}

}
