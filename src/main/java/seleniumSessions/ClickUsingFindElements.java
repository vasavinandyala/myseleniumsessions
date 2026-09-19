package seleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ClickUsingFindElements {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");

		/*
		 * List<WebElement> footerList = driver.findElements(By.xpath("//footer//a"));
		 * System.out.println("total footer links : " + footerList); for(WebElement e :
		 * footerList) { String text = e.getText(); if(text.equals("Contact Us")) {
		 * e.click(); break; } }
		 */
		By footerList = By.xpath("//footer//a");
		clickElement(footerList,"Contact Us");

	}

	public static void clickElement(By locator,String eleText) {
		List<WebElement> eleList = driver.findElements(locator);
		System.out.println("total no of elements : " + eleList.size());
		for (WebElement e : eleList) {
			String text = e.getText();
			if (text.contains(eleText)) {
				e.click();
				break;
			}
		}

	}

}
