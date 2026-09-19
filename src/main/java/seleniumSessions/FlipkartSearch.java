package seleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

////li[@class='_3D0G9a']//div[@class='YGcVZO _2VHNef']
public class FlipkartSearch {
	
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		driver = new ChromeDriver();
	/*	driver.get("https://flipkart.com/");
		
		By searchlocator = By.name("q");
		By searchLink = By.xpath("//div[@class='YGcVZO _2VHNef']");
		//System.out.println(searchLink.size());
		
		doSearch(searchlocator, "Macbook Pro", searchLink, "m3");*/
		
		driver.get("https://amazon.com/");
		
		//By identify = By.id("nav-search-keywords");
		

	}
	public static void doSearch(By searchlocator,String searchKey,By searchLink,String suggestionValue) throws InterruptedException {
		
		driver.findElement(searchlocator).sendKeys(searchKey);
		Thread.sleep(4000);
		
		List<WebElement> suggLinks = driver.findElements(searchLink);
	
		System.out.println(suggLinks.size());
	
		for(WebElement e : suggLinks) {
			String text = e.getText();
			System.out.println(text);
			if(text.contains(suggestionValue)) {
				e.click();
				break;
			}
		}
	}
	


}
