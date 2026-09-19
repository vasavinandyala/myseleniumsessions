package seleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultipleElements {
	
	static WebDriver driver;

	public static void main(String[] args) {
		
		//fetch total no of links on the page
		//then print the text of each link on the console
		//links -- htmltag: <a>
		
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		//driver.get("https://amazon.in");
		
		List<WebElement> linkslist = driver.findElements(By.tagName("a"));
		int totallinks = linkslist.size();
		System.out.println("Total links : " + totallinks);
		
		//print the text of each link : iterate this list : using for loop:
		//index - for loop:
		
		for(int i=0 ; i<totallinks; i++) {
			
			String text = linkslist.get(i).getText();
			
			if(text.length() != 0) {
				
			System.out.println(text);
			
			}
		}
		
		System.out.println("--------------------------");

		//for-each loop:
		
		for(WebElement e: linkslist) {
			
			String text1 = e.getText();	
			
			if(text1.length()!=0) {
				System.out.println(text1);
			}
			
		}
		
		//total no of images:
		List<WebElement> imgList = driver.findElements(By.tagName("img"));
		int image = imgList.size();
		System.out.println(image);
		
		
	}

}
