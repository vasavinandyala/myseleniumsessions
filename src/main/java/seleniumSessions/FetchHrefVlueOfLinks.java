package seleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FetchHrefVlueOfLinks {
	
	static WebDriver driver;

	public static void main(String[] args) {
		
		driver = new ChromeDriver();
		driver.get("https://amazon.in");
		
		List<WebElement> linkslist = driver.findElements(By.tagName("a"));
		System.out.println(linkslist.size());
		
		for(WebElement e : linkslist) {
			
			String hrefVal = e.getDomAttribute("href");
			String text = e.getText();
			System.out.println(text + " ::: " + hrefVal);
		}

		

	}

}
