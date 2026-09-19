package seleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SelectDropDownWithoutSelectClass {
	
	static WebDriver driver;
	
	public static void main(String[] args) {

		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/en/contact-sales");	
			
		//1.select tag dropdown
		//2. dont use select class or its methods
		
	/*	List<WebElement> optionsList = driver.findElements(By.cssSelector("select#Form_getForm_Country > option"));

		System.out.println(optionsList.size());
		
		for(WebElement e : optionsList) {
			String text = e.getText();
			if(text.contains("Zaire")) {
				e.click();
				break;
			}
		}
		*/
		
		By countryOptions = By.cssSelector("select#Form_getForm_Country > option");
		By employee = By.id("Form_getForm_NoOfEmployees");
		
		
		selectDropDownValue(countryOptions, "Afghanistan");
		selectDropDownValue(employee, "11 - 50");
		
	}

	public static void selectDropDownValue(By locator,String value) {
		
		List<WebElement> optionsList = driver.findElements(locator);

		System.out.println(optionsList.size());
		
		for(WebElement e : optionsList) {
			String text = e.getText();
			if(text.contains(value)) {
				e.click();
				break;
			}
		}
	}
	
}
