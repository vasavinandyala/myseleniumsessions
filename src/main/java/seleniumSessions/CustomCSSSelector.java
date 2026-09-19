package seleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CustomCSSSelector {
	
	static WebDriver driver ;

	public static void main(String[] args) {
		
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		
		//CSS selector : Cascade style sheet
		//it is  a locator
		
		//1. id:    #id  eg: #input-email
		
		//2.class:  .class 
		//eg:  .img-responsive 
		//img.img-responsive 
		// input.form-control
		
		//3. id+class : #id.class .class#id 
		//eg: #input.form-control 
		//input.form-control#input-email
		
		//4.multiple classes: c1,c2,c3......cn
		//eg: c1.c2.c3.....cn
		//.form-control.input-lg
		//tagname.c1.c2.c3...cn
		//input.c1.c2
		
		//for other attributes:
		//----------------------
		
		//tagname[attr='value']
		//eg: input[name='email']-css 
		// xpath - //input[@name='email']
		//input[name='email']#input-email.form-control    (tagname[attr='value']#id.classname
		//tagname[attr='value'][attr2='value'][attr3='value'] --> for multiple attributes and values.
		//input[name='email'][placeholder='E-Mail Address'][id='input-email'].form-control
		//input[name='email'][placeholder='E-Mail Address']#input-email.form-control
		//input[id][class][placeholder]
		
		//text in css: no support for element text
		
		//contains:
		//tagname[attr *= 'value']
		//input[placeholder *= 'Address']
		//input[placeholder *= 'Address'][name='email'][id *= 'email']

		//startswith:
		//tagname[attr ^= 'value']
		//input[placeholder ^= 'E-Mail']
		
		//Endswith:
		//tagname[attr $= 'value']
		//input[placeholder $= 'Address']
		
		
		// parent to child:
		// parenttag childtag --> direct+indirect child elements
		// div.form-control input#input-email
		// footer li>a -- direct child a for li
		// footer li a -- all a's will be displayed
		// footer a -- all indirect and direct a's
		// parenttag > childtag --> only for direct parent and childtags
		// foorter>div ul a --> footer direct div indirect ul indirect a
		// select#form_getForm_Country > option
		
		//indexing in CSS:
		//-----------------
		
		// select#form_getForm_Country > option:nth-of-type(2)  --> to select 2nd index element
		// select#form_getForm_Country > option:nth-of-type(n)  --> nth element
		// select#form_getForm_Country > option:first-child  --> first child - country
		// select#form_getForm_Country > option:last-child  -->Last element
		// select#form_getForm_Country > option:nth-child(5) --> 5th child
		// select#form_getForm_Country > option:nth-last-child(2) --> from last 2nd element
		// select#form_getForm_Country > option:nth-last-child(n) --> all elements
		// select#form_getForm_Country > option:nth-child(odd) --> odd positioned elements(use FindElements)
		// select#form_getForm_Country > option:nth-child(even) --> even positioned elements	(use FindElements)	
		// select#form_getForm_Country > option:nth-of-type(4n)  --> multiple of 4th(4,8,12,16....) position element
		// select#form_getForm_Country > option:nth-of-type(4n-1)  --> every 3rd position element(can be ignored) dont use +1
		
		
		//odd/even in xpath:
		//10%2 == 0 --> (even)
		//9%2 == 1 --> (odd)
		//select[@id='Form_getForm_Country']/option[position() mod 2 = 0]  --> even position elements
		//select[@id='Form_getForm_Country']/option[position() mod 2 = 1]  --> odd position elements
	
		//child to parent to child to ancestor : no support available for backward traversing in css
		
		//sibling: only following sibling is supported
		//--------
		//label[for='input-email']+input#input-email ---> + immediate sibling(following)
	
		// select#form_getForm_Country > option[value='Afghanistan']+option  --> Albania(only one immediate sibling)
		// select#form_getForm_Country > option[value='Afghanistan']~option  --> All(following siblings)
		
		
		
		// comma in css:
		//img.img-responsive,input#input-email,input#input-password,input[value='Login']
	
	String impEleCSS = "img.img-responsive,input#input-email,input#input-password,input[value='Login']"; //--4 elements
	int impFieldsCount = driver.findElements(By.cssSelector(impEleCSS)).size();
	if(impFieldsCount == 4) {
		System.out.println("All the imp fields are present on the page");
	}
	else {
		System.out.println("All the imp fields are not present on the page");
	}
	
	//not in css:
	//-------------
	//input.form-control  --> 1 of 3 available
	//input.form-control:not([name='search'])  --> 1 of 2 avaialble excluded search
	
	
	}

}
