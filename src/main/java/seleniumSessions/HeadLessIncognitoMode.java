package seleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class HeadLessIncognitoMode {

	static WebDriver driver;
	
	public static void main(String[] args) {
		
		//headless : no browser is launched 
		//runs in the background
		//advantage : 
		//1. execution speed is improved
		//2.really useful in ci/cd pipeline -- linux machine/docker(no ui)

		//HEADLESS
		//-------------------------------
		//1.Chrome
//		ChromeOptions co = new ChromeOptions();// only for chrome
//		co.addArguments("--headless");
//		
//		driver = new ChromeDriver(co);

		//2.Firefox
//		FirefoxOptions fo = new FirefoxOptions();
//		fo.addArguments("--headless");
//		
//		driver = new FirefoxDriver(fo);
		
		//3.Edge
//		EdgeOptions eo = new EdgeOptions();
//		eo.addArguments("--headless");
//		
//		driver = new EdgeDriver(eo);
		
		//Safari - does not work in headless mode 
		
		
		//INCOGNITO
		//------------------------
		
		
		//1.Chrome
//		ChromeOptions co = new ChromeOptions();// only for chrome
////		co.addArguments("--headless");
////		if uncomment this it ll run together in headless and incognito mode
//		co.addArguments("--incognito");
//		driver = new ChromeDriver(co);
		
		//2.Firefox
//		FirefoxOptions fo = new FirefoxOptions();
//		fo.addArguments("--incognito");
//		//fo.addArguments("--headless");//uncomment to run in both modes
//		driver = new FirefoxDriver(fo);
		
		//3.Edge
		EdgeOptions eo = new EdgeOptions();
		//eo.addArguments("--headless");//uncomment to run in both modes
		eo.addArguments("--inPrivate");

		driver = new EdgeDriver(eo);
		
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		driver.quit();
			
	}

}
