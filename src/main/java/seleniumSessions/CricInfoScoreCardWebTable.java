package seleniumSessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CricInfoScoreCardWebTable {
	
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		
		driver = new ChromeDriver();
		driver.get("https://espncricinfo.com/series/major-league-cricket-2025-1481991/mi-new-york-vs-washington-freedom-29th-match-1482020/full-scorecard/");
		
		Thread.sleep(4000);
		String wktTakerName1 = getWicketTakerName("Tajinder Singh");
		System.out.println(wktTakerName1);
		
		wktTakerName1 = getWicketTakerName("Kunwarjeet Singh");
		System.out.println(wktTakerName1);
		
		List<String> tajScore = getScoreCardList("Tajinder Singh");
		System.out.println(tajScore);

		List<String> sharadScore = getScoreCardList("Sharad Lumba");
		System.out.println(sharadScore);
		
	}
	
	public static List<String> getScoreCardList(String username) {
		
		List<WebElement> scoreCardList = driver.findElements(By.xpath("span[text()='"+username+"']//ancestor::td/following-sibling::td[contains(@class,'ds-text-right')]"));
		List<String> scoreList = new ArrayList<String>();
		for(WebElement e : scoreCardList) {
			String text = e.getText();
			//if(text.length()!=0) {
			System.out.println(text);
			scoreList.add(text);
			//}
		}
		return scoreList;
	}
	public static String getWicketTakerName(String username) {
		String wktTakerName = driver.findElement(By.xpath("//span[text()='"+username+"']/ancestor::td/following-sibling::td/span/span")).getText();
		return wktTakerName;
	}
}
