package week2.Day2;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.seleniumProject.UtilFiles;

public class EditFields {
	
	public static void main(String[] args) {
		
		UtilFiles util = new UtilFiles();
		WebDriver driver = util.setUpDriver("chrome");
		util.maximize(driver);
		
		// 1. Launch URL 
	  	driver.get("http://leafground.com/pages/Edit.html");
	  	
	  	//Enter email address:
	  	driver.findElement(By.id("email")).sendKeys("testleaf.assignment@gmail.com");
	  	
	  	//append value:
	  	String existing =driver.findElement(By.xpath("//input[@value='Append ']")).getText();
	  	driver.findElement(By.xpath("//input[@value='Append ']")).sendKeys(existing + "some value"+ Keys.TAB);
	  	
	  	//get default text
	  	System.out.println(driver.findElement(By.name("username")).getText());
	  	
	  	//clear text
	  	driver.findElement(By.xpath("//label[text()='Clear the text']/following-sibling::input")).clear();
	  	
	  	//check inactive
	  	if(driver.findElement(By.xpath("(//div[@class='row'])[5]//input")).isEnabled()) {
	  		System.out.println("Element is enabled");
	  	} else {
	  		System.out.println("Element is disabled");
	  	}
	}

}
