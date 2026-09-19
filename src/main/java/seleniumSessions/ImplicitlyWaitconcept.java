package seleniumSessions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ImplicitlyWaitconcept {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));//4.x feature
		//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);//3.x feature - 
		//not applicable anymore

		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		
		//Implicitly wait - method - never use for defining framework
		/*
		 * 1. global wait - once its applied, it will be there throughout the session
		 * it ll be applicable for all the web elements
		 * and its applicable only for web elements
		 * not applicable for non web elements : title,url,alerts,windows
		 */
		driver.findElement(By.id("input-email")).sendKeys("test@gmail.com");
		driver.findElement(By.id("input-password")).sendKeys("test@123");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		
		//overriding the implicitly wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		//need to keep on changint the mplicitly wait. if it should not impact then also 
		//should override with '0 called nullifiable wait
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
		


	}

}
