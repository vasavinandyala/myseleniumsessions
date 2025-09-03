package seleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SessionIDConcept {

	public static void main(String[] args) {
		
	//1. Open browser: chrome
		
		WebDriver driver = new FirefoxDriver();//sid=123
		
		//2. enter the url
		
		driver.get("https://www.google.com");//sid=123
		
		//3. get the page title
		
		String title = driver.getTitle();//sid=123
		System.out.println("page title : "+ title);
		
		//4. validation, checkpoint: act vs exp result
		
		String url = driver.getCurrentUrl();//sid=123
		System.out.println("Page url : " + url);
		
		//driver.quit();//sid=123
		//browser is closed , sid=null
		//NosuchsessionException when using chrome driver afer quitting the bowser.
		
		
		driver.close();//sid=123
		//bowser closed but, to continue driver sid is invalid
		//So NoSuchSessionException - Invalid session id
		
		driver = new ChromeDriver();//sid=456
		driver.get("https://www.google.com");//sid=456
		
		System.out.println(driver.getTitle());//sid=456
		
		driver.quit();
	}

}
