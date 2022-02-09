package week2.Day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.seleniumProject.UtilFiles;

public class FaceBookAssignment1 {
	/*
	 * Assignment:1
FaceBook:
================================
// Step 1: Download and set the path 
// Step 2: Launch the chromebrowser
// Step 3: Load the URL https://en-gb.facebook.com/
// Step 4: Maximise the window
// Step 5: Add implicit wait
// Step 6: Click on Create New Account button
// Step 7: Enter the first name
// Step 8: Enter the last name
// Step 9: Enter the mobile number
// Step 10: Enterthe password
// Step 11: Handle all the three drop downs
// Step 12: Select the radio button "Female" 
            ( A normal click will do for this step) 
            */
	
	public static void main(String[] args) {
		// Step 1: Download and set the path 
		UtilFiles util = new UtilFiles();
		WebDriver driver = util.setUpDriver("chrome");
		
		// Step 2: Launch the chromebrowser & Step 3: Load the URL https://en-gb.facebook.com/
		driver.get("https://en-gb.facebook.com/");
		
		// Step 4: Maximise the window
		util.maximize(driver);
		
		// Step 5: Add implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		
		// Step 6: Click on Create New Account button
		driver.findElement(By.linkText("Create New Account")).click();
		
		//Step 7-10: Enter FirstName, Last Name, Mobile Number, password
		driver.findElement(By.name("firstname")).sendKeys("Tracey");
		driver.findElement(By.name("lastname")).sendKeys("Whitney");
		driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("9165482003");
		driver.findElement(By.xpath("//input[@name='reg_email__']/../following::input[@type='password']")).sendKeys("WhiTrac2003");
		
		//Step 11: Handle all dropdowns
		WebElement daydropdwn = driver.findElement(By.name("birthday_day"));
		Select daydropDown = new Select(daydropdwn);
		daydropDown.selectByIndex(22);
		
		Select monthdropDown = new Select(driver.findElement(By.name("birthday_month")));
		monthdropDown.selectByValue("7");
		
		Select yeardropDown = new Select(driver.findElement(By.name("birthday_year")));
		yeardropDown.selectByVisibleText("1986");
		
		//Step 12: Select the radio button "Female" 
		driver.findElement(By.xpath("//label[text()='Female']")).click();
	}

}
