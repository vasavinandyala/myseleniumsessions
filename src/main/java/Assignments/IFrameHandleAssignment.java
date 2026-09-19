package Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class IFrameHandleAssignment {

	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {

		driver = new ChromeDriver();
		driver.get("https://www.formsite.com/templates/registration-form-templates/vehicle-registration-form/");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//img[@title='Vehicle-Registration-Forms-and-Examples']")).click();
		Thread.sleep(1000);
		
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@id,'frame-one')]")));
		driver.findElement(By.cssSelector("#RESULT_TextField-1")).sendKeys("Nissan Altima 2015");
		driver.findElement(By.cssSelector("#RESULT_TextField-3")).sendKeys("Parker");
		driver.findElement(By.cssSelector("#RESULT_TextField-4")).sendKeys("10/31/2025");
		driver.findElement(By.cssSelector("#RESULT_TextArea-5")).sendKeys("First Car Registration");
		driver.findElement(By.xpath("//*[contains(@id,'RESULT_FileUpload')]")).sendKeys("/Users/sudheerreddyt/Desktop/IMG_7559.jpeg");
		driver.findElement(By.cssSelector("#RESULT_TextField-8")).sendKeys("Vas");
		driver.findElement(By.cssSelector("#RESULT_TextField-9")).sendKeys("Nandy");
		driver.findElement(By.cssSelector("#RESULT_TextField-10")).sendKeys("8956 Red bud ln");
		driver.findElement(By.cssSelector("#RESULT_TextField-12")).sendKeys("Parker");
		
		Select selectState = new Select(driver.findElement(By.id("RESULT_RadioButton-13")));
		selectState.selectByContainsVisibleText("Colorado");

		driver.findElement(By.cssSelector("#RESULT_TextField-14")).sendKeys("80134");
		driver.findElement(By.cssSelector("#RESULT_TextField-15")).sendKeys("7207883655");
		driver.findElement(By.cssSelector("#RESULT_TextField-16")).sendKeys("harini5a3@gmail.com");
		driver.findElement(By.cssSelector("#FSsubmit")).click();
		
		String message = driver.findElement(By.cssSelector("h3.success-text")).getText();
		System.out.println("--------- "+message +" ----------");
		
		driver.switchTo().defaultContent();
		String header = driver.findElement(By.cssSelector("h3.details__form-preview-title")).getText();
		System.out.println("--------- "+ header +" ----------");

		driver.quit();
		
	}

}
