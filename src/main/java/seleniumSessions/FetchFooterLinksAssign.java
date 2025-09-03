package seleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FetchFooterLinksAssign {
	
	static WebDriver driver;

	public static void main(String[] args) {

		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		
		//By xPath = By.xpath("//footer//div[@class='col-sm-3']//a");//-->this link is also correct
		By xPath = By.xpath("//footer//a");

		
	/*	List<WebElement> footerLinks = driver.findElements(xPath);
		System.out.println(footerLinks.size());
		for(WebElement e : footerLinks) {
			String text = e.getText();
			System.out.println(text);
		}*/
		
		ElementUtil eleUtil = new ElementUtil(driver);
		int countOfLinks = eleUtil.getElementsCount(xPath);
		System.out.println(countOfLinks);
		
		List<String> actListext = eleUtil.getElementsTextList(xPath);
		for(String e : actListext) {
			System.out.println(e);
		}
		
	/*	List<WebElement> footerLinks = driver.findElements(xPath);

		//to click the link
		for(WebElement e: footerLinks) {
			String text =e.getText();
			if(text.contains("Contact Us")) {
				e.click();
				break;
			}
		}*/

		//clickElement(xPath,"Contact Us");
		
		By rightLinkNavigator = By.className("list-group-item");
		clickElement(rightLinkNavigator,"Forgotten Password");

	}
	
	public static void clickElement(By locator, String eleText) {
		
		List<WebElement> eleList = driver.findElements(locator);
		System.out.println("total no of elements : " + eleList.size());
		
		for(WebElement e: eleList) {
			String text =e.getText();
			if(text.contains(eleText)) {
				e.click();
				break;
			}
		}

	}

}
