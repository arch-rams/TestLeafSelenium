package week2.Day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.seleniumProject.UtilFiles;

public class Acme_TestPath {

/*
 * Assignment:3
===================
1. Load url "https://acme-test.uipath.com/login"
2. Enter email as "kumar.testleaf@gmail.com"
3. Enter Password as "leaf@12"
4. Click login button
5. Get the title of the page and print
6. Click on Log Out
7. Close the browser (use -driver.close())
======================
*/
	
	public static void main(String[] args) {
		UtilFiles util = new UtilFiles();
		WebDriver driver = util.setUpDriver("chrome");
		
		//1. Load url "https://acme-test.uipath.com/login"
		driver.get("https://acme-test.uipath.com/login");
		
		//2,3 . Enter email & password
		driver.findElement(By.id("email")).sendKeys("kumar.testleaf@gmail.com");
		driver.findElement(By.id("password")).sendKeys("leaf@12");
		
		//4. Click login button
		driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();
		
		//5. Get the title of the page and print
		System.out.println(driver.getTitle());
		
		//Click on Log Out
		driver.findElement(By.linkText("Log Out")).click();
		
		//Close the browser 
		//driver.close();
		
	}
}
