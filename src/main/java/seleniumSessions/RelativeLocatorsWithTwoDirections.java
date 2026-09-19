package seleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.locators.RelativeLocator;
import static  org.openqa.selenium.support.locators.RelativeLocator.with;


public class RelativeLocatorsWithTwoDirections {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		Thread.sleep(3000);
		
		WebElement header = driver.findElement(By.xpath("//h2[text()='New Customer']"));
		WebElement button = driver.findElement(By.linkText("Continue"));
		
		String para = driver
						.findElement(with(By.tagName("p"))
								.below(header)
									.above(button))
										.getText();
		System.out.println(para);
		
		
	}

}
