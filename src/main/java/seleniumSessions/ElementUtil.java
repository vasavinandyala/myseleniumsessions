package seleniumSessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementUtil {
	
	private WebDriver driver;
	
	public ElementUtil(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public void doSendKeys(By locator, String value) {
		getElement(locator).sendKeys(value);
	}
	
	public void doClick(By locator) {
		 getElement(locator).click();
	}
	
	public int getElementsCount(By locator){
		return getElements(locator).size();
	}

	
	public List<WebElement> getElements(By locator){
		return driver.findElements(locator);
	}

	public List<String> getElementsTextList(By locator) {
		
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
	
	public Boolean isElementExist(By locator) {
		if(getElementsCount(locator) == 1) {
			System.out.println("the element : " + locator + " Is present one time");
			return true;
		}
		else {
			System.out.println("the element : " + locator + "Is not present");

			return false;
		}
	}
	
	public Boolean isElementExist(By locator, int expEleCount) {
		if(getElementsCount(locator) == expEleCount) {
			System.out.println("the element : " + locator + " Is present " + expEleCount + " times" );
			return true;
		}
		else {
			System.out.println("the element : " + locator + "Is not present" + expEleCount + " times");

			return false;
		}
	}

}
