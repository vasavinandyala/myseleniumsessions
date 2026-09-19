package seleniumSessions;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtil {

	private WebDriver driver;
	private Actions act;

	public ElementUtil(WebDriver driver) {
		this.driver = driver;
		act = new Actions(driver);
	}

	public WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	public String doElementGetText(By locator) {
		return getElement(locator).getText();
	}

	public void doSendKeys(By locator, String value) {
		if (value == null) {
			throw new ElementException("======Value cannot be null");
		}
		getElement(locator).sendKeys(value);
	}

	public void doMultipleSendKeys(By locator, CharSequence... value) {

		/*
		 * for(CharSequence e : value) { if(e==null) { throw new
		 * ElementException("======Value cannot be null"); } }
		 */

		getElement(locator).sendKeys(value);
	}

	public void doClick(By locator) {
		getElement(locator).click();
	}

	public int getElementsCount(By locator) {
		return getElements(locator).size();
	}

	public List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}

	public List<String> getElementsTextList(By locator) {

		List<WebElement> eList = getElements(locator);
		List<String> eTextList = new ArrayList<String>();

		for (WebElement e : eList) {
			String text = e.getText();
			if (text.length() != 0) {
				eTextList.add(text);
			}
		}
		return eTextList;

	}

	public Boolean isElementExist(By locator) {
		if (getElementsCount(locator) == 1) {
			System.out.println("the element : " + locator + " Is present one time");
			return true;
		} else {
			System.out.println("the element : " + locator + "Is not present");

			return false;
		}
	}

	public boolean isElementDisplayed(By locator) {
		try {
			return getElement(locator).isDisplayed();
		} catch (NoSuchElementException e) {
			System.out.println("Element is not Displayed" + locator);
			// e.printStackTrace();
			return false;
		}
	}

	public boolean isElementEnabled(By locator) {
		try {
			return getElement(locator).isDisplayed();
		} catch (NoSuchElementException e) {
			System.out.println("Element is not Enabled " + locator);
			return false;
		}
	}

	public Boolean isElementExist(By locator, int expEleCount) {
		if (getElementsCount(locator) == expEleCount) {
			System.out.println("the element : " + locator + " Is present " + expEleCount + " times");
			return true;
		} else {
			System.out.println("the element : " + locator + "Is not present" + expEleCount + " times");

			return false;
		}
	}

	public String getDOMAttributeValue(By locator, String attrName) {
		return getElement(locator).getDomAttribute(attrName);
	}

	public String getDOMPropertyValue(By locator, String attrName) {
		return getElement(locator).getDomProperty(attrName);
	}

	public void clickElement(By locator, String eleText) {
		List<WebElement> eleList = getElements(locator);
		System.out.println("total no of elements : " + eleList.size());
		for (WebElement e : eleList) {
			String text = e.getText();
			if (text.contains(eleText)) {
				e.click();
				break;
			}
		}
	}

	public void doSearch(By searchlocator, String searchKey, By suggestionlocator, String suggestionValue)
			throws InterruptedException {

		doSendKeys(suggestionlocator, searchKey);
		Thread.sleep(4000);

		clickElement(suggestionlocator, suggestionValue);

//		List<WebElement> suggLinks = getElements(suggestionlocator);
//		System.out.println(suggLinks.size());
//		for(WebElement e : suggLinks) {
//			String text = e.getText();
//			System.out.println(text);
//			if(text.contains(suggestionValue)) { e.click();break; }
//		}
	}
	
	public  void getTableData(int columnNum) {
		
		String beforeXpath = "//table[@id='customers']/tbody/tr[";
		String afterXpath = "]/td["+columnNum+"]";
		
		int rowCount = driver.findElements(By.xpath("//table[@id='customers']//tr")).size();
		
		for(int row=2;row<=rowCount;row++) {
			String xpath = beforeXpath + row + afterXpath;
			String text = driver.findElement(By.xpath(xpath)).getText();
			System.out.println(text);
		}
	}
	
	public List<String> getScoreCardList(String username) {
		
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
	public String getWicketTakerName(String username) {
		String wktTakerName = driver.findElement(By.xpath("//span[text()='"+username+"']/ancestor::td/following-sibling::td/span/span")).getText();
		return wktTakerName;
	}
	
	/*********************** Select drop down Utilities *********************/

	
	public void doSelectByIndex(By locator, int index) {
		Select select = new Select(getElement(locator));
		select.selectByIndex(index);
	}
	
	public void doSelectByVisibleText(By locator, String eleText) {
		Select select = new Select(getElement(locator));
		select.selectByVisibleText(eleText);
	}
	
	public void doSelectByContainsVisibleText(By locator, String eleText) {
		Select select = new Select(getElement(locator));
		select.selectByContainsVisibleText(eleText);
	}
	
	public void doSelectByValue(By locator, String value) {
		Select select = new Select(getElement(locator));
		select.selectByValue(value);
	}
	
	public int getDropDownOptionsCount(By locator) {
		Select select = new Select(getElement(locator));
		return select.getOptions().size();
	}
	
	public void selectDropDownValue(By locator,String value) {
		
		List<WebElement> optionsList = getElements(locator);

		System.out.println(optionsList.size());
		
		for(WebElement e : optionsList) {
			String text = e.getText();
			if(text.contains(value)) {
				e.click();
				break;
			}
		}
	}
	
	public String getDropDownFirstSelectedValue(By locator) {
		Select select = new Select(getElement(locator));
		return select.getFirstSelectedOption().getText();

	}
	
	//****************Actions class**********************
	
	public void  moveToElement(By locator) {
		act.moveToElement(getElement(locator)).perform();
	}
	
	public void menuSubMenuHandlingLevel2(By ParentMenu, By ChildMenu) throws InterruptedException {

		moveToElement(ParentMenu);
		Thread.sleep(2000);
		doClick(ChildMenu);
		
	}
	public void menuSubHandlingLevel3(By menuLevel1, By menuLevel2, By menuLevel3) throws InterruptedException {
		Thread.sleep(1000);
		doClick(menuLevel1);
		Thread.sleep(1000);
//		act.moveToElement(getElement(menuLevel2)).perform();
//		Thread.sleep(1000);
//		doClick(menuLevel3);
		menuSubMenuHandlingLevel2(menuLevel2, menuLevel3);
	}
	
	public void menuSubHandlingLevel4(By menuLevel1, By menuLevel2, By menuLevel3,By menuLevel4, String actionType) throws InterruptedException {
		
		if(actionType.equalsIgnoreCase("click")) {
			doClick(menuLevel1);
		}
		else if(actionType.equalsIgnoreCase("mouse over")) {
			moveToElement(menuLevel1);
		}
		
		Thread.sleep(1000);
		moveToElement(menuLevel2);
		Thread.sleep(1000);
		moveToElement(menuLevel3);
		Thread.sleep(1000);
		doClick(menuLevel4);
	}
	
	public void actionDragAndDrop(WebElement sourceEle,WebElement targetEle) {
		act.dragAndDrop(sourceEle, targetEle).perform();
	}
	
	public void doActionsSendKeys(By locator,String Value) {
		act.sendKeys(getElement(locator), Value).perform();
	}
	
	public void doSendKeysWithPause(By locator,String value,long pauseTime) {
		if(value == null) {
			throw new RuntimeException("======value cannot be NULL=======");
		}
		char val[] = value.toCharArray();
		for(char ch : val) {
			act.sendKeys(getElement(locator), String.valueOf(ch))
				.pause(pauseTime)
					.perform();
			
		}
	}
	public void doSendKeysWithPause(By locator,String value) {
		if(value == null) {
			throw new RuntimeException("======value cannot be NULL=======");
		}
		char val[] = value.toCharArray();
		for(char ch : val) {
			act.sendKeys(getElement(locator), String.valueOf(ch))
				.pause(200)
					.perform();
			
		}
	}
	
	//*******************WindowHandler and Iterator********************
	
	public void getWindowHandleiterator(String parentId) {
		Set<String> windowHandles = driver.getWindowHandles();
		Iterator<String> it = windowHandles.iterator();
		
		String windowId = it.next();
		String newId = null;
		if(windowId.equals(parentId)) {
			System.out.println(windowId);
			newId = it.next();
			 driver.switchTo().window(newId);
		}else {
			driver.switchTo().window(windowId);
		}
		
	}
	public void switchToChildThenParent(String parentWindowId) {
		getWindowHandleiterator(parentWindowId);
		driver.switchTo().window(parentWindowId);
		System.out.println("\n" + "Present url : " + driver.getCurrentUrl());
		System.out.println("=========================================");
	}
	
	/************************ Wait Utilities **************************/
	
	public  WebElement waitForElementPresence(By locator,int timeout) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeout));
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));

		
	}
	
	public  WebElement waitForElementVisible(By locator,int timeout) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeout));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

		
	}
	
	public Alert waitForAlert(int timeOut) {
		WebDriverWait  wait = new WebDriverWait(driver,Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.alertIsPresent());
	}
	
	public String getAlertText(int timeOut) {
		return waitForAlert(timeOut).getText();
	}
	
	public void acceptAlert(int timeOut) {
		waitForAlert(timeOut).accept();
	}
	
	public void dismissAlert(int timeOut) {
		waitForAlert(timeOut).dismiss();
	}
	
	public void sendKeysInAlert(int timeOut,String value) {
		waitForAlert(timeOut).sendKeys(value);
	}
	
	public String waitForTitleContains(String fractionTitleValue,int timeOut) {
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeOut));
		
		try{
			wait.until(ExpectedConditions.titleContains(fractionTitleValue));
		}
		catch (TimeoutException e) {
			System.out.println("expected title value : " + fractionTitleValue.toUpperCase() + " is not present");
		}
		
		return driver.getTitle();
		
	}

	public String waitForTitleIs(String expectedTitleValue,int timeOut) {
	
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeOut));
	
	try{
		wait.until(ExpectedConditions.titleContains(expectedTitleValue));
	}
	catch (TimeoutException e) {
		System.out.println("expected title value : " + expectedTitleValue.toUpperCase() + " is not present");
	}
	
	return driver.getTitle();
	
	}
	
	public String waitForURLContains(String fractionURLValue,int timeOut) {
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeOut));
		
		try{
			wait.until(ExpectedConditions.urlContains(fractionURLValue));
		}
		catch (TimeoutException e) {
			System.out.println("expected URL value : " + fractionURLValue.toUpperCase() + " is not present");
		}
		
		return driver.getCurrentUrl();
		
	}
	public String waitForURLIs(String expectedURLValue,int timeOut) {
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeOut));
		
		try{
			wait.until(ExpectedConditions.urlToBe(expectedURLValue));
		}
		catch (TimeoutException e) {
			System.out.println("expected URL value : " + expectedURLValue.toUpperCase() + " is not present");
		}
		
		return driver.getCurrentUrl();
		
	}
	public boolean waitForWindow(int expectedNoOfWindows,int timeOut) {
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeOut));
		
		try{
			return wait.until(ExpectedConditions.numberOfWindowsToBe(expectedNoOfWindows));
		}
		catch (TimeoutException e) {
			System.out.println("expected URL value : " + expectedNoOfWindows + " is not present");
			return false;
		}
			
	}
	
	
	public boolean waitForFrame(WebElement frameElement,int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		try {
		wait
			.until(ExpectedConditions
					.frameToBeAvailableAndSwitchToIt(frameElement));
		return true;
		
		}
		catch(TimeoutException e) {
			System.out.println("Frame is not present on the page");
			return false;
		}

}
	
	public boolean waitForFrameUsingLocator(By frameLocator,int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		try {
		wait
			.until(ExpectedConditions
					.frameToBeAvailableAndSwitchToIt(frameLocator));
		return true;
		
		}
		catch(TimeoutException e) {
			System.out.println("Frame is not present on the page");
			return false;
		}

	}
	
	public boolean waitForFrameUsingIndex(int frameIndex,int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		try {
			wait
				.until(ExpectedConditions
					.frameToBeAvailableAndSwitchToIt(frameIndex));
			return true;
		}
		catch(TimeoutException e) {
			System.out.println("Frame is not present on the page");
			return false;
		}

	}
	
	public boolean waitForFrameUsingName(String frameNameOrID,int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		try {
			wait
				.until(ExpectedConditions
					.frameToBeAvailableAndSwitchToIt(frameNameOrID));
			return true;
		}
		catch(TimeoutException e) {
			System.out.println("Frame is not present on the page");
			return false;
		}

	}
	
	public List<WebElement> waitForElementsPresence(By locator,int timeOut) {
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
		
	}
	
	public List<WebElement> waitForElementsVisible(By locator,int timeOut) {
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
		
	}
	public void clickElementWhenReady(By locator,int timeOut) {
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
		
	}
	
	//***************************FluentWait****************************//
	
	public WebElement waitForElementVisiblewithFluentWait(By locator,int timeOut,int pollingTime) {
		
		Wait<WebDriver> wait = new FluentWait<WebDriver> (driver)
				.withTimeout(Duration.ofSeconds(timeOut))
				.pollingEvery(Duration.ofSeconds(pollingTime))
				.ignoring(NoSuchElementException.class)
				.ignoring(StaleElementReferenceException.class) //- > can add as no of exceptions you want
				.withMessage("*******ELEMENT NOT PRESENT ON THE PAGE******");
		
		return  (WebElement)wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

	}
	public WebElement waitForElementPresencewithFluentWait(By locator,int timeOut,int pollingTime) {
		
		Wait<WebDriver> wait = new FluentWait<WebDriver> (driver)
				.withTimeout(Duration.ofSeconds(timeOut))
				.pollingEvery(Duration.ofSeconds(pollingTime))
				.ignoring(NoSuchElementException.class)
				.ignoring(StaleElementReferenceException.class)
				.withMessage("*******ELEMENT NOT PRESENT ON THE PAGE******");
		
		return  (WebElement) wait.until(ExpectedConditions.presenceOfElementLocated(locator));


	}
	


}
