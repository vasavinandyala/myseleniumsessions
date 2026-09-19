package seleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class IFrameHandle {


	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {

		driver = new ChromeDriver();
		driver.get("https://www.formsite.com/templates/registration-form-templates/vehicle-registration-form/");
		Thread.sleep(4000);
		//Manually accept the pop up
//		driver.findElement(By.xpath("//*[@id=\"8693eb98-a5ec-4d10-add6-e7e30fe635ad\"]/div[2]/button[1]")).click();
//		Thread.sleep(2000);
//		
		driver.findElement(By.cssSelector("img[title='Vehicle-Registration-Forms-and-Examples']")).click();
		Thread.sleep(2000);
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@id,'frame-one')]")));
		driver.findElement(By.id("RESULT_TextField-1")).sendKeys("Vasavi Nandyala");
		
		//come to main page
		driver.switchTo().defaultContent();
		String header = driver.findElement(By.cssSelector("h3.details__form-preview-title")).getText();
		System.out.println(header);
	
	}

}
