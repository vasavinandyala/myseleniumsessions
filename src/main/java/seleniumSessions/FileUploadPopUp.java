package seleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUploadPopUp {

	static WebDriver driver;
	
	public static void main(String[] args) {
		
		driver = new ChromeDriver();
		driver.get("https://practice.expandtesting.com/upload");
		
		//tag 'type = file' -- should be there to automate
		
		//Mac:
		driver.findElement(By.id("fileInput")).sendKeys("/Users/sudheerreddyt/Library/Mobile Documents/com~apple~CloudDocs/Downloads/New Passport_First Page.PDF");
		
		//Windows:
		//driver.findElement(By.id("fileInput")).sendKeys("C:\\Users\\sudheerreddyt\\Library\\Mobile Documents\\com~apple~CloudDocs\\Downloads\\New Passport_First Page.PDF");

		driver.findElement(By.id("fileSubmit")).click();
		
		String message = driver.findElement(By.id("uploaded-files")).getText();
		System.out.println(message);
		
		//if type = file is not there?
		//ask your dev team to add type = file
		//otherwise we cannot automate
		//we can use some 3rd party libraries: not at all recommended
		//1.sikuli - takes all images
		//2.AutoIt -- 3rd party open source -- works only for windows OS
		//3.Robot class -- works only for windows OS
		
		
		
	}

}
