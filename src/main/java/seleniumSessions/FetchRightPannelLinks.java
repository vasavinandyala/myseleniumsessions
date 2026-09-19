package seleniumSessions;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FetchRightPannelLinks {
	static WebDriver driver;

	public static void main(String[] args) {

		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
	
		By rightPanelLinks = By.className("list-group-item");
		
		/*List<WebElement> rightPanelLinksList =  driver.findElements(rightPanelLinks);
		System.out.println(rightPanelLinksList.size());
		
		for(WebElement e : rightPanelLinksList) {
			String text = e.getText();
			System.out.println(text);
		}*/
		
		ElementUtil eleUtil = new ElementUtil(driver);

		int actLinksCount = eleUtil.getElementsCount(rightPanelLinks);
		System.out.println(actLinksCount);
		if(actLinksCount == 13) {
			System.out.println("PASS");
		}
		List<String> actListext = eleUtil.getElementsTextList(rightPanelLinks);
		
		if(actListext.containsAll(Arrays.asList("Login","Forgotten Password","Register"))) {
			System.out.println("All the important links are present at right panel");
		}
		
	}

}
