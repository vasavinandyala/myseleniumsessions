package seleniumSessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectDropDownOptions {

	static WebDriver driver;
	
	public static void main(String[] args) {

		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/en/contact-sales");
		
		By country = By.id("Form_getForm_Country");
		By employee = By.id("Form_getForm_NoOfEmployees");
		
//		WebElement countryEle = driver.findElement(country);	
//		Select select_country = new Select(countryEle);
//		
//		List<WebElement> optionsList = select_country.getOptions();
//		int totalOptions = optionsList.size();
//		//String title = driver.getTitle();
//		
//		System.out.println("total countries : "+totalOptions);
//		
//		if(totalOptions ==233 ) {
//			System.out.println("Test is passed");
//		}
//		
//		for(WebElement e : optionsList) {
//			String text = e.getText();
//			System.out.println(text);
//		}
//		
		
		List<String> employeeList = getDropDownValueList(employee);
		System.out.println(employeeList);

		System.out.println("----------------------------");
		
		List<String> countryList = getDropDownValueList(country);
		System.out.println(countryList);

	}
	
	public static int getDropDownOptionsCount(By locator) {
		Select select = new Select(getElement(locator));
		return select.getOptions().size();
	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}	
	
	public static List<String> getDropDownValueList(By locator) {
		Select select = new Select(getElement(locator));
		List<WebElement> optionsList = select.getOptions();
		System.out.println("total no of Options : "+ optionsList.size());
		
		List<String> optionsValueList = new ArrayList<String>();//pc=0, size=0,
		
		for(WebElement e : optionsList) {
			String text = e.getText();
			System.out.println(text);
			optionsValueList.add(text);
		}

		return optionsValueList;
	}

}
