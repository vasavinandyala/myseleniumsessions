package seleniumSessions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptPopUpAlertHAndle {
	
	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {

		driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		
		//Alert alert = driver.switchTo().alert();//NoAlertPresentException : no such alert
		
		//3 pop ups: alert, prompt, confirm
		//alert API
		
		//1.Alert
		driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
		Thread.sleep(4000);
		
		Alert alert = driver.switchTo().alert();
		String text = alert.getText();
		System.out.println(text);
		
		//alert.accept();//click/accept the alert 
		alert.dismiss();//cancel the alert
		
		
		//2.Confirm.
		
//		driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
//		Thread.sleep(4000);
//		
//		Alert alert = driver.switchTo().alert();
//		String text = alert.getText();
//		System.out.println(text);
//		//alert.accept();
//		alert.dismiss();
		
		//3.Prompt
		
//		driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
//		Thread.sleep(1000);
//		
//		Alert alert = driver.switchTo().alert();
//		String text = alert.getText();
//		System.out.println(text);
//		alert.sendKeys("Vasavi Nandyala");
//		Thread.sleep(3000);
//		alert.accept(); //click ok
//		//alert.dismiss(); // click cancel
//
//		WebElement element = driver.findElement(By.cssSelector("#result"));
//		String value = element.getText();
//		System.out.println(value);//You entered: Vasavi Nandyala
//		//if cancelled : value = You entered: null

	}

}
