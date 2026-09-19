package seleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FrameHandle {

	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {

		driver = new ChromeDriver();
		driver.get("http://www.londonfreelance.org/courses/frames/index.html");
		Thread.sleep(2000);
		
		//can use any frame varribles : index, name Or Id ,WebElement
		//driver.switchTo().frame(2);//3rd frame but index =2
		//driver.switchTo().frame("main");
		driver.switchTo().frame(driver.findElement(By.xpath("//frame[@src='top.html']")));
		
		String header = driver.findElement(By.tagName("h2")).getText();
		System.out.println(header);
		driver.quit();
		
	}

}
