package seleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class StaticWebTable {

	static WebDriver driver;

	public static void main(String[] args)  {
		
		driver = new ChromeDriver();
		driver.get("https://w3schools.com/html/html_tables.asp");
		
		////*[@id="customers"]/tbody/tr[3]/td[2]
		//Thread.sleep(1000);
		
		String beforeXpath = "//table[@id='customers']/tbody/tr[";
		String afterXpath = "]/td[2]";
		
		int rowCount = driver.findElements(By.xpath("//table[@id='customers']//tr")).size();
		
		for(int row=2;row<=rowCount;row++) {
			String xpath = beforeXpath + row + afterXpath;
			String text = driver.findElement(By.xpath(xpath)).getText();
			System.out.println(text);
		}
		
		getTableData(1);
		getTableData(2);
		getTableData(3);

	}
	
	public static void getTableData(int columnNum) {
		
		String beforeXpath = "//table[@id='customers']/tbody/tr[";
		String afterXpath = "]/td["+columnNum+"]";
		
		int rowCount = driver.findElements(By.xpath("//table[@id='customers']//tr")).size();
		
		for(int row=2;row<=rowCount;row++) {
			String xpath = beforeXpath + row + afterXpath;
			String text = driver.findElement(By.xpath(xpath)).getText();
			System.out.println(text);
		}
	}

}
