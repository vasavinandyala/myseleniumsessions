package seleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ElementIsDisabled {

	static WebDriver driver;

	public static void main(String[] args) {

		driver = new ChromeDriver();

		driver.get("https://seleniumpractise.blogspot.com/2016/09/how-to-work-with-disable-textbox-or.html");

		boolean flag1 = driver.findElement(By.id("pass")).isEnabled();
		System.out.println(flag1);

		boolean flag2 = driver.findElement(By.id("fname")).isEnabled();
		System.out.println(flag2);

		driver.findElement(By.id("pass")).sendKeys("test@123");

	}

}
