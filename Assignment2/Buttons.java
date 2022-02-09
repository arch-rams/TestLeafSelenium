package week2.Day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.seleniumProject.UtilFiles;

public class Buttons {
	public static void main(String[] args) {
		UtilFiles util = new UtilFiles();
		WebDriver driver = util.setUpDriver("chrome");
		util.maximize(driver);
		
		// 1. Launch URL 
	  	driver.get("http://leafground.com/pages/Button.html");
	  	
	  	//click button
	  	driver.findElement(By.id("home")).click();
	  	driver.navigate().back();
	  	
	  	//get position (x, y)
	  System.out.println(driver.findElement(By.id("position")).getLocation());
	  
	  //button color
	  System.out.println(driver.findElement(By.id("color")).getCssValue("background-color"));
	  
	  //size
	  System.out.println(driver.findElement(By.id("size")).getSize());
	}

}
