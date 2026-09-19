package seleniumSessions;

//import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearch {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		driver = new ChromeDriver();
		ElementUtil eleUtil = new ElementUtil(driver);
		driver.get("https://google.com");
		driver.findElement(By.xpath("//div[@class='niO4u VDgVie SlP8xc'][1]")).click();		
		By searchlocator = By.name("q");
		By suggestionlocator = By.xpath("//ul[@Class='G43f7e']//div[@Class='wM6W7d']/span");
		
		eleUtil.doSearch(searchlocator,"selenium Automation",suggestionlocator,"framework");
		
	}
	
//	public static void doSearch(By searchlocator,String searchKey,By suggestionlocator,String suggestionValue) throws InterruptedException {
//		
//		driver.findElement(searchlocator).sendKeys(searchKey);
//		Thread.sleep(4000);
//		
//		List<WebElement> suggLinks = driver.findElements(suggestionlocator);
//	
//		System.out.println(suggLinks.size());
//	
//		for(WebElement e : suggLinks) {
//			String text = e.getText();
//			System.out.println(text);
//			if(text.contains(suggestionValue)) {
//				e.click();
//				break;
//			}
//		}
//	}
//	
	
}


