package seleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class BrowserUtil {

	WebDriver driver;
	
	public WebDriver initDriver(String browserName) {
		System.out.println("browser name : " + browserName);
		
		switch (browserName.trim().toLowerCase()) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
		case "safari":
			driver = new SafariDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		default:
			System.out.println("Plz pass the right browser : " + browserName);
			throw new BrowserException("------INVALID browser--------");
		}
		
		return driver;
	}
	
	public void launchUrl(String Url) {
		
		System.out.println("Application url : " + Url);
		
		if(Url == null) {
			throw new BrowserException("------INVALID Url; url cannot be null-------");
		}
		
		if(Url.indexOf("http") != 0) {
			throw new BrowserException("------INVALID Url; http(s) is missing--------");
		}
		
		driver.get(Url);
	}
	
	public String getPageTitle() {
		return driver.getTitle();
	}
	
	public String getPageUrl() {
		return driver.getCurrentUrl();
	}
	
	public void closeBrowser() {
		driver.close();
	}
	
	public void quitBrowser() {
		driver.quit();
	}
	

}
