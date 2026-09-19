package seleniumSessions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PollingTime {

	static WebDriver driver;

	public static void main(String[] args) {

		driver = new ChromeDriver();
		driver.get("https://classic.crmpro.com/");
		
		By locator = By.name("usernme");
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10),Duration.ofSeconds(2));

		WebElement usernmaeEle = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		usernmaeEle.sendKeys("Vasavi Nandyala");
		
		
	}

}
