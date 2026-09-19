package seleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NestedIframe {

	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {

		driver = new ChromeDriver();
		driver.get("https://selectorshub.com/iframe-scenario");
		Thread.sleep(2000);
	
		driver.switchTo().frame("pact1");//frame 1
		driver.findElement(By.id("inp_val")).sendKeys("Vasavi");
		
		driver.switchTo().frame("pact2");//frame 2
		driver.findElement(By.id("jex")).sendKeys("Shrimath");
		
		driver.switchTo().frame("pact3");//frame 3
		driver.findElement(By.id("glaf")).sendKeys("Shrihaun Anav");
		
		/*//switch from f3-f2
		driver.switchTo().parentFrame();
		driver.findElement(By.id("jex")).clear();//inorder to clear the enetered content
		driver.findElement(By.id("jex")).sendKeys(" Atharv");
		//switch from f2-f1
		driver.switchTo().parentFrame();
		driver.findElement(By.id("inp_val")).sendKeys(" Reddy");
		//switch from f1 to main page
		driver.switchTo().defaultContent();
		String title = driver.findElement(By.tagName("h6")).getText();
		System.out.println("title of the frame is : " + "\n" + title);*/
		
		//f3-f1 or to grandparent : not allowed
		//driver.switchTo().frame("pact1");
		//driver.findElement(By.id("inp_val")).sendKeys("Nandyala");
		
		//f3-f2 without using parentFrame: not allowed
		//driver.switchTo().frame("pact2");
		//driver.findElement(By.id("jex")).sendKeys(" Thagguparthi");
		
		//f3-f2/f1 using defaultcontent
		driver.switchTo().defaultContent(); //-- goes to main page
		//driver.findElement(By.id("jex")).sendKeys(" Thagguparthi");//doesnt work
		//driver.findElement(By.id("inp_val")).sendKeys(" Thagguparthi");//doesnt work

		String title = driver.findElement(By.tagName("h6")).getText();
		System.out.println(title);
		driver.quit();
		
		/*
		 * main-f1 -switchto.frame1
		 * f1-f2 -switchto.frame2
		 * f2-f3 -switchto.frame3
		 * f3-f2-switchto.parentframe
		 * f3-f2-switchto.parentframe
		 * f2-f1-switchto.parentframe
		 * f1-main-switchto.defaultcontent
		 * any frame to main - switchto.defaultcontent
		 */
		
		
		


		
	
	}

}
