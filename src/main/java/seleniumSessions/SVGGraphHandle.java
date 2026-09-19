package seleniumSessions;

import java.util.List;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SVGGraphHandle {
		
		public static void main(String[] args) throws InterruptedException {
			
			WebDriver driver = new ChromeDriver();
			driver.get("https://petdiseasealerts.org/forecast-map#/");
			
			Thread.sleep(2000);
			
			driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@id,'map-instance')]")));
			
			String svgpath =  "//*[local-name() = 'svg' and @id='map-svg']//*[name()='g' and @id='regions']//*[name()='path']";
			
			List<WebElement> states = driver.findElements(By.xpath(svgpath));
			System.out.println(states.size());//51
			
			Actions act = new Actions(driver);
			
			for(WebElement e : states) {
				act.moveToElement(e).pause(500).perform();
				String stateName = e.getAttribute("name");
				System.out.println(stateName);
				if(stateName.contains("Maryland")) {
					e.click();
					break;
				}
			}
			//css selector works but not the xpath need to use local-name()
			
			String selectedCountyPath = "//*[local-name() = 'svg' and @id='map-svg']//*[name()='g' and @id='regions']//*[name()='g' and @id='maryland']//*[name()='g' and @class='subregion']//*[name()='path']";
			
			List<WebElement> county = driver.findElements(By.xpath(selectedCountyPath));
			System.out.println(county.size());
			
			String countyName=null;
			
			for(WebElement e : county) {
				act.moveToElement(e).pause(500).perform();
				countyName = e.getAttribute("name");
				System.out.println(countyName);
				if(countyName.contains("Baltimore")) {
					e.click();
					break;
				}
			}
			
			@Nullable
			String forecast = driver.findElement(By.xpath("//*[div[@id='capc-map-app']]//div[@class='map-content']//div[@class=\"stats-content--wheel\"]//div[@class='infection-rate']")).getText();
			System.out.println("\n" + "------------------" + "\n\n" + "IN " + countyName.toUpperCase() + " THE  " + forecast);
			////*[@id="capc-map-app"]/div[4]/div[1]/div/div/div/div/div[1]/div[2]
			
			
			
			
			

	}

}
