package seleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class ActionsDragAndDrop {
	
	static WebDriver driver;
	static Actions act ;

	public static void main(String[] args) {

		driver = new ChromeDriver();
		driver.get("https://jqueryui.com/resources/demos/droppable/default.html");
		
		WebElement sourceEle = driver.findElement((By.xpath("//div[@id='draggable']/p[text()='Drag me to my target']")));
		WebElement targetEle = driver.findElement((By.id("droppable")));
		act = new Actions(driver);
//		Action action = act
//							.clickAndHold(sourceEle)
//									.moveToElement(targetEle)
//												.release()
//													.build();
//		action.perform();
//		
		//return type of build : Action -- creating all the composite actions
		//return type of perform is void -- performs all the composite actions on the page
		
		actionDragAndDrop(sourceEle, targetEle);
		
		
	}
	
	public static void actionDragAndDrop(WebElement sourceEle,WebElement targetEle) {
		act.dragAndDrop(sourceEle, targetEle).perform();

	}

}
