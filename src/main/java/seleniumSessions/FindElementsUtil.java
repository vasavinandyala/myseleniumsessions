package seleniumSessions;

//import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElementsUtil {
	
	static WebDriver driver;

	public static void main(String[] args) {

		driver = new ChromeDriver();
		//driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		driver.get("https://amazon.com");
		
		ElementUtil eleUtil = new ElementUtil(driver);

		By links = By.tagName("a");
		By images = By.tagName("img");
		
		int totalLinks = eleUtil.getElementsCount(links);
		int totalImages = eleUtil.getElementsCount(images);
		
		System.out.println("total no of images: " + totalImages);
		System.out.println("total no of links: " +totalLinks);
		
		List<String> actualTextLinks = eleUtil.getElementsTextList(links);
		for(String e : actualTextLinks) {
			System.out.println(e);
		}
		
		if(actualTextLinks.contains("Login")) {
			System.out.println("Login is available on the screen");
		}
		
		if(actualTextLinks.contains("Register")) {
			System.out.println("Register is available pn the screen");
		}
		
		List<String> expList = Arrays.asList("Login","Register","Forgotten Password","Order History");
		
		if(actualTextLinks.containsAll(expList)) {
			System.out.println("All expected links are available");
		}
		
	}
	
	/*public static List<String> getElementsTextList(By locator) {
		
		List<WebElement>  eList = getElements(locator);
		List<String> eTextList = new ArrayList<String>();
		
		for(WebElement e : eList) {
			String text = e.getText();
			if(text.length()!=0) {
				eTextList.add(text);
			}
		}
		return eTextList;
		
	}
	
	public static int getElementsCount(By locator){
		return getElements(locator).size();
	}

	
	public static List<WebElement> getElements(By locator){
		return driver.findElements(locator);
	}
*/
}
