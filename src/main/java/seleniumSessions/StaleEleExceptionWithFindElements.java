package seleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class StaleEleExceptionWithFindElements {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://freshworks.com");
		
		Thread.sleep(5000);
		
		JavascriptUtil jsUtil = new JavascriptUtil(driver);
		jsUtil.scrollPageDown();
		
		Thread.sleep(5000);
		//dom v1
		List<WebElement> footerList = driver.findElements(By.xpath("//footer//a"));
		System.out.println(footerList.size());
		
		for(int i=2 ; i<=7 ;i++) {
			footerList.get(i).click();
			driver.navigate().back();
			//dom v2,v3....v7
			footerList = driver.findElements(By.xpath("//footer//a"));
		}
		//IndexOutOfBoundsException: what to do
		//driver.navigate().refresh();
	}

}
