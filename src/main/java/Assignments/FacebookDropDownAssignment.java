package Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FacebookDropDownAssignment {
	
	static WebDriver driver;

	public static void main(String[] args) {
		
		driver = new ChromeDriver();
		driver.get("https://www.facebook.com/r.php?entry_point=login");
	
		
		//select[name='birthday_month'] > option   ----- selectbyvalue is not accepting the  option 
		//select[name='birthday_day'] > option	----- selectbyvalue is not accepting the  option
		//label[class='_58mt'] > input[value='-1']
		//select[aria-label='Select your pronoun'] > option:not([selected='1'])	----- selectbyvalue is not accepting the  options
		
		By bMonth = By.cssSelector("select[name='birthday_month']");
		By bDay = By.cssSelector("select[name='birthday_day']");
		By bYear = By.cssSelector("select[name='birthday_year']");
		
		By gender = By.cssSelector("label[class='_58mt'] > input[value='-1']");
		By genderPronoun = By.cssSelector("select[aria-label='Select your pronoun']");
		
//		WebElement month = driver.findElement(bMonth);
//		Select select_month = new Select(month);
//		select_month.selectByVisibleText("Nov");
//		
		/*WebElement day = driver.findElement(bDay);
		Select select_day = new Select(day);
		select_day.selectByVisibleText("16");
		
		WebElement year = driver.findElement(bYear);
		Select select_year = new Select(year);
		select_year.selectByVisibleText("1988");*/
		
		doSelectByVisibleText(bMonth, "Nov");
		doSelectByVisibleText(bDay, "16");
		doSelectByVisibleText(bYear, "1988");
		getElement(gender).click();
		//if value of gender value = -1 use the next step
		doSelectByValue(genderPronoun, "6");
		
		
		
		

	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static void doSelectByVisibleText(By locator, String value) {
		Select select = new Select(getElement(locator));
		select.selectByVisibleText(value);
	}
	public static void doSelectByValue(By locator, String value) {
		Select select = new Select(getElement(locator));
		select.selectByValue(value);
	}

}
