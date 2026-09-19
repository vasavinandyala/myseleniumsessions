package seleniumSessions;

//import java.util.List;

//import org.openqa.selenium.By;
//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathConcept {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		
		//xpath:
		//-not an attribute
		//-its the adrress of the element in html DOM
		//1. absolute xpath : never use , performance issues
		
		//2. relative/custom xpath:
		
		//1> with single attribute:
		//htmltag[@attr='value']  eg: input[@id='input-email']
		//input[@id]
		//img[@title='naveenopencart']
		
		//2> with multiple attributes:
		//htmltag[@aatr1='value' and @aatr2='value']
		//eg : input[@type and @placeholder]     img[@title='naveenopencart' and @class='img-responsive']
		
		
		//3. with text(): button, link, para, header, label
		//html[text()='value']
		//h2[text()='New Customer']
		//a[text()='Register']
		
		//4> text() and attribute
		//htmltag[text()='value' and @aatr='value']
		//label[text()='E-Mail' and @for='input-email']
		//a[@class='list-group-item' and text()='Register']
		
		//5> contains() with attribute:
		//htmltag[contains(@attr,'value')]
		//input[contains(@placeholder,'E-Mail')]
		
		
		//6> contains() with one attribute and another attribute with contains:
		//htmltag[contains(@attr,'value') and @aatr2='value]
		//input[contains(@placeholder,'E-Mail') and @name='email' and @type ='text' and contains(@id,'email')]
		
		//one text field 
		//<input> id ='firstname_123' />
		//<input> id ='firstname_233' />
		//<input> id ='firstname_345' />
		//<input> id ='firstname_965' />
		
		//By.id("firstname_965"); -- wrong way to use id, coz id is dynamic
		//input[contains[@id,'firstname_')
		
		//7> contains() with text()
		//htmltag[contains(text(),'value')]
		//p[contains(text(),'shop faster')]
		//a[contains(text(),'Forgotten')]
		//h2[contains(text(),'Returning')]
		
		//8> contains() with text() and contains with attribute:
		//html[contains(text(),'value') and contains(@attr,'value')]
		//a[contains(text(),'Forgotten') and contains(@class,'list-group-item')]
		
		
		//9> starts-with():
		//htmltag[starts-with(text(),'value')]
		//a[starts-with(text(),'Recurring')]
		
		//htmltag[starts-with(@attr,'value')]
		//input[starts-with(@placeholder,'E-Mail')]
		//input[starts-with(@placeholder,'E-Mail') and contains(@id,'email')]
		
		//ends with is not available in selenium
		
		//parent to child combination
		//-----------------------------
		//a.direct child '/'
		//b. direct and indirect child '//'
		
		//footer//h5  : gives all the h5 details
		//div[@class='list-group']/a - only child details
		//div[@class='list-group']//a - all the children including grandchildren details
		
		//div[@class='form-group']/input[@id='input-email']
		
		//xpath:axes:
		//--------------
		//div[@class='form-group']/child::input[@id='input-email']
		//div[@class='form-group']/input[@id='input-email']
		//div[@class='form-group']/child::a
		//footer//child::a
		
		//child to parent: yes -- backward traverse
		//input[@id='input-email']/..      ---- traverse to the direct parent
		//input[@id='input-email']/../..   ---- traverse to the direct grandparent
		
		//child to ancestor:
		//------------------
		//input[@id='input-email']/parent::div[@class='form-group']
		//input[@id='input-email']/ancestor::div
		//input[@id='input-email']/ancestor::form
		
		
		//sibling to sibling:
		//-------------------
		//label[@for=input-email']/following-sibling::input
		//input[@id='inut-email']/preceding-sibling::label

		
		//option[@value='Afghanistan']/following-sibling::option
		//option[@value='Afghanistan']/preceding-sibling::option
		
		
		//indexing:: to get the exact position like forgottn password first or second.
		//-----------
		
		//(//a[text()='Forgotten Password'])[2]
		//driver.findElement(By.xpath("(//a[text()='Forgotten Password'])[2]")).click();
		
		// (//form//input[@id])[3]   -- give us the 3rd input id
		// (//form//input[@id])[position()=3]
		// (//form//input[@id])[last()] --- give me the last input id
		// (//form//input[@id])[last()-1] --- give me the last -1 input id, similarly last -2...
		
		//((//div[@class='navFooterVerticalRow navAccessibility']/div[contains(@class,'navFooterLinkCol')])[last()]//a)[last()]
		
		
		
		//--- to find the last text in the footer.
		//or (//div[text()='Let Us Help You']/following-sibling::ul//a)[last()]
		//div[text()='Let Us Help You']//following-sibling::ul//a[text()='Your Orders']-- interview question
		//OR
		//(//div[text()='Let Us Help You']/following-sibling::ul//a)[2]
		//not in xpath:
		//-------------
		//Select all <input> elements that do not have a type attribute  --
		// //input[not(@type)]
		//Select all <div> elements that do not contain the class active
		// //div[not(contains(@class, 'active'))]
		// Select all <a> tags that do not have an href value
		// //a[not(@href)]
		// Select all elements except <span>
		// //*[not(self::span)]

		//not() only works with boolean expressions inside the brackets [ ].		
		//It’s often combined with @attribute, contains(), or logical operators like and / or.


	
		
		
		//		By.xpath("//a[contains(text(),'Forgotten')]");
		//		driver.findElement(By.xpath("//a[contains(text(),'Forgotten')]")).click();
		
//		List<WebElement> inactiveDivs = driver.findElements(
//			    By.xpath("//div[not(contains(@class, 'active'))]")
//			);
//		
		
		//comma/union are not suggested have limited support

	}

}
