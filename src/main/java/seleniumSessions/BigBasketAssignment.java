package seleniumSessions;

// code is wrong yet
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.interactions.Actions;

public class BigBasketAssignment {

	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {

		driver = new ChromeDriver();
		
		//String text,text1,text2;
		driver.get("https://www.bigbasket.com/");
		
		By menuLevel1 = By.xpath("(//span[text()='Shop by'])[2]");
		By menuLevel2 = By.cssSelector("#headlessui-menu-items-\\:Rimkj6\\: > nav > ul.jsx-1259984711.w-56.px-2\\.5.bg-darkOnyx-800.text-silverSurfer-100.rounded-l-xs.max-h-120.overflow-y-auto.scroll-smooth > li > a");
		//By menuLevel4 = By.xpath("(//ul[@class='jsx-1259984711 w-56 px-2.5 bg-white text-darkOnyx-800 rounded-r-xs max-h-120 overflow-y-auto scroll-smooth'])[1]//a");
		
		driver.findElement(menuLevel1).click();
		List<WebElement> eleList1 = driver.findElements(menuLevel2);
		//List<WebElement> layerList2 = driver.findElements(By.xpath("(//ul[@class='jsx-1259984711 w-56 px-2.5 bg-silverSurfer-200 text-darkOnyx-800 max-h-120 overflow-y-auto scroll-smooth'])[2]//a")); 
		int listsize = eleList1.size();
		System.out.println(listsize);
	//	List<WebElement> layerList3 = driver.findElements(menuLevel4);

		
		/*for(WebElement e : eleList1) {
			
			text = e.getText();
			if(text.length() != 0) {
				System.out.println(text + "------------------------");
				}				
			for(WebElement e1 : layerList2) {
				
				text1 = e1.getText();
				if(text1.length() != 0) {
					System.out.println(text1);
					}				
				for(WebElement e2 : layerList3) {
					
					text2 = e2.getText();
					if(text2.length() != 0) {
					System.out.println(text2);
					}
				}
			}
			
			
			
		}*/


	}

}
