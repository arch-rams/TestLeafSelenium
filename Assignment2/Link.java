package week2.Day2;

import org.openqa.selenium.WebDriver;

import com.seleniumProject.UtilFiles;

public class Link {
public static void main(String[] args) {
	UtilFiles util = new UtilFiles();
	WebDriver driver = util.setUpDriver("chrome");
	util.maximize(driver);
	
	// 1. Launch URL 
	driver.get("http://leafground.com/pages/Link.html");
}
}
