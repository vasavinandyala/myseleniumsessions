package seleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectDropDownWithDeselect {
	
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		driver = new ChromeDriver();
		driver.get("https://html.com/attributes/select-multiple/");
		
		Select select = new Select(driver.findElement(By.xpath("//select[@multiple]")));//css - select[multiple]    
		
		boolean isMultiple = select.isMultiple();
		System.out.println(isMultiple);
		
		if(isMultiple) {
			select.selectByVisibleText("American flamingo");
			select.selectByVisibleText("Andean flamingo");
			select.selectByVisibleText("James's flamingo");

		}
		Thread.sleep(2000);
		select.deselectByVisibleText("James's flamingo");
		Thread.sleep(2000);
		select.deselectAll();
		
	}

}
