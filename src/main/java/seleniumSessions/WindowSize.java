package seleniumSessions;

import org.openqa.selenium.Dimension ;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowSize {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		driver = new ChromeDriver();
		//Responsive Testing
		Dimension dim = new Dimension(430,932);
		//driver.manage().window().maximize(); to maximize
		//driver.manage().window().fullscreen(); to occupy the screen we are using.
		driver.manage().window().setSize(dim);
		
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		Thread.sleep(3000);
	}

}
