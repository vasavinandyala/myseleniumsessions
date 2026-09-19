package seleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectDropDownHandling {
	
	static WebDriver driver;

	public static void main(String[] args) {

		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/en/contact-sales");
		
		//htmltag: <select/>
		//class : Select class in sleenium handle select tag dropdown 
		//select(parent) -- option(child)
		//if select html tag is not available then cannot use the select class
		
		By country = By.id("Form_getForm_Country");
		By employee = By.id("Form_getForm_NoOfEmployees");
		
	/*	WebElement countryEle = driver.findElement(country);		
		Select select_country = new Select(countryEle);
		select_country.selectByIndex(5);//select by index/position
		select_country.selectByContainsVisibleText("India");//select by the text of the option
		select_country.selectByValue("Australia");//check the value attribute
		
		WebElement employeeEle = driver.findElement(employee);		
		Select select_employee = new Select(employeeEle);
		//select_employee.selectByIndex(2);
		select_employee.selectByVisibleText("11 - 50");		*/
		
		doSelectByIndex(country, 7);
		doSelectByIndex(employee, 3);

	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}	
	
	public static void doSelectByIndex(By locator, int index) {
		Select select = new Select(getElement(locator));
		select.selectByIndex(index);
	}
	
	public static void doSelectByVisibleText(By locator, String eleText) {
		Select select = new Select(getElement(locator));
		select.selectByVisibleText(eleText);
	}
	
	public static void doSelectByContainsVisibleText(By locator, String eleText) {
		Select select = new Select(getElement(locator));
		select.selectByContainsVisibleText(eleText);
	}
	
	public static void doSelectByValue(By locator, String value) {
		Select select = new Select(getElement(locator));
		select.selectByValue(value);
	}
	
}
