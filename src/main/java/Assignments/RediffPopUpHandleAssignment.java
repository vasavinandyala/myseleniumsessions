package Assignments;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RediffPopUpHandleAssignment {

	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {

		driver = new ChromeDriver();
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi/config/ma");
		By emailId = By.cssSelector("#login1");
		By pwd = By.cssSelector("#password");
		By button = By.xpath("//*[@class='signin-btn']");
		//1. enter the username and login -- alert "Please enter your password"
		//2. enter only password and login -- alert " Please enter a valid user name"
		//3. enter none and press login -- alert " Please enter a valid user name"
		//4.enter everything correctly and login -- couldnt create an account
	//	driver.findElement(emailId).sendKeys("Vasavi.nandyala");
		driver.findElement(pwd).sendKeys("Sudheer@123");
		driver.findElement(button).click();
		
		Alert alert = driver.switchTo().alert();
		String text = alert.getText();
		System.out.println(text);
		alert.accept();
		driver.quit();
		
		
		
		
	}

}
