package seleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AuthenticationPopUpHandle {

	static WebDriver driver;
	
	public static void main(String[] args) {
		
		driver = new ChromeDriver();
		String username = "admin";
		String password = "admin";
		driver.get("https://" + username + ":" + password +"@" + "the-internet.herokuapp.com/basic_auth");
		//OR
		//driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
		//username and password is supplied to the url 
		//as https://username:password@url
		//if the username and password are correct then it will process to the next page successfully
		//if the anyof them are wrong the popup still stays in the alert or does nothing.
		//if password has '@' as character sending the password in the url ll never work.
		
		//if password has '@' selenium 4.x :HasAuthenticate

	}

}
