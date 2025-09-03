package seleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetAttributeConcept {
	
	static WebDriver driver;

	public static void main(String[] args) {

		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		
		String hRefValue = driver.findElement(By.linkText("Forgotten Password")).getDomAttribute("href");
		System.out.println(hRefValue);
		
		String classValue = driver.findElement(By.linkText("Forgotten Password")).getDomAttribute("class");
		System.out.println(classValue);//null

		String classVal = driver.findElement(By.linkText("Forgotten Password")).getDomProperty("class");
		System.out.println(classVal);//null
		
		
		String outerHTML = driver.findElement(By.id("input-email")).getDomProperty("outerHTML");
		System.out.println(outerHTML);//null
		
		driver.findElement(By.id("input-email")).sendKeys("Vasavi@gmail.com");
		String val = driver.findElement(By.id("input-email")).getDomProperty("value");
		System.out.println(val);


		
		
	}

}
