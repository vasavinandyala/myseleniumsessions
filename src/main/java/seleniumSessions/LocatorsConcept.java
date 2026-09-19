package seleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsConcept {

	static WebDriver driver;

	public static void main(String args[]) {
		
		BrowserUtil brUtil = new BrowserUtil();
		driver = brUtil.initDriver("chrome");
		brUtil.launchUrl("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		ElementUtil eleUtil = new ElementUtil(driver);
		
		//driver = new ChromeDriver();
		//driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");

		
		//1.id - unique attribute
		//2.name - Can be duplicate
		//3.className - can be duplicate
		//eg: driver.findElement(By.className("img-responsive")).click();
		
	/*	By imagelogo = By.className("img-responsive");*/

		//eleUtil.doClick(imagelogo);
		
		/*String title = brUtil.getPageTitle();
		System.out.println(title);*/
		
		//brUtil.quitBrowser();
		//4. xpath : not an attribute : address of the element in the DOM
		
		/*
		 * driver.findElement(By.xpath("//*[@id=\"input-email\"]")).sendKeys(
		 * "tom@gmail.com");
		 * driver.findElement(By.xpath("//*[@id=\"input-password\"]")).sendKeys(
		 * "tom@123"); driver.findElement(By.xpath(
		 * "//*[@id=\"content\"]/div/div[2]/div/form/input[1]")).click();
		 */
		
		//5. css selector value - not an attribute
		
//		driver.findElement(By.cssSelector("#input-email")).sendKeys("tom@gmail.com");
//		driver.findElement(By.cssSelector("#input-password")).sendKeys("tom@123");
//		driver.findElement(By.cssSelector("#content > div > div:nth-child(2) > div > form > input.btn.btn-primary")).click();

		//6. linkText : only for texts
		//html tag <a> -- every a tag ll have a text
		
		//driver.findElement(By.linkText("About Us")).click();
		//driver.findElement(By.linkText("Forgotten Password")).click();
		
		/*By forgotpwdlink = By.linkText("Forgotten Password");
		eleUtil.doClick(forgotpwdlink);*/
		
		//7. Partiallink text : only works for links
		
		//driver.findElement(By.partialLinkText("Forgotten")).click();

		//8.html tagName
		
		By pageHeader = By.tagName("h2");
		//String header = driver.findElement(By.tagName("h2")).getText();
		String header = eleUtil.doElementGetText(pageHeader);
		System.out.println(header);
		brUtil.quitBrowser();
		
		
		
		
		
		
	}

}
