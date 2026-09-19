package seleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectDropDownDefaultOption {

	static WebDriver driver;
	
	public static void main(String[] args) {

		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/en/contact-sales");
		
		By country = By.cssSelector("select#Form_getForm_Country > option");
		By employee = By.id("Form_getForm_NoOfEmployees");
		
//		WebElement countryEle = driver.findElement(employee);
//		Select select = new Select(countryEle);
//		
//		String defaultValue = select.getFirstSelectedOption().getText();
//		System.out.println(defaultValue);
//		
		if(getDropDownFirstSelectedValue(country).contains("Country")) {
			System.out.println("PASS");
		}
		
		if(getDropDownFirstSelectedValue(employee).contains("Number of Employees")) {
			System.out.println("PASS");
		}
		
	}
	
	public static String getDropDownFirstSelectedValue(By locator) {
		Select select = new Select(driver.findElement(locator));
		return select.getFirstSelectedOption().getText();

	}

}
