package seleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectDropDownValueSelection {
	
	static WebDriver driver;
	
	public static void main(String[] args) {

		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/en/contact-sales");	
		//1. select tag dropdown
		//2.select value from the dropdown w/o using select class methods
		
		By country = By.id("Form_getForm_Country");
		//By employee = By.id("Form_getForm_NoOfEmployees");
		
		WebElement countryEle = driver.findElement(country);
		
		Select select = new Select(countryEle);
		List<WebElement> countryOptionsList = select.getOptions();
		
		for(WebElement e : countryOptionsList) {
			String text = e.getText();
			if(text.contains("India")) {
				e.click();
				break;
			}
		}
		
		
	}

}
