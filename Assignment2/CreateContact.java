package week2.Day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.seleniumProject.UtilFiles;

public class CreateContact {
	
	void loginToLeafTaps(WebDriver driver) {
		//2. Enter UserName and Password Using Id Locator
	  	driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
	  
	 // 3. Click on Login Button using Class Locator
		driver.findElement(By.className("decorativeSubmit")).click();
	  
	 // 4. Click on CRM/SFA Link
		driver.findElement(By.partialLinkText("CRM/SFA")).click();
		
		//return driver;
	}
	
	public void createContact(WebDriver driver) {
		 // 5. Click on contacts Button
		 driver.findElement(By.linkText("Contacts")).click();
	 // 6. Click on Create Contact
		 driver.findElement(By.xpath("//a[text()='Create Contact']")).click();
	   
	//  7. Enter FirstName Field Using id Locator
		 driver.findElement(By.id("firstNameField")).sendKeys("Arpitha");
	  
	//  8. Enter LastName Field Using id Locator
		 driver.findElement(By.id("lastNameField")).sendKeys("Menon");
		 
	//  9. Enter FirstName(Local) Field Using id Locator
		 driver.findElement(By.id("createContactForm_firstNameLocal")).sendKeys("Arpitha");
		 
	 // 10. Enter LastName(Local) Field Using id Locator
		 driver.findElement(By.id("createContactForm_lastNameLocal")).sendKeys("Menon");
		 
	 // 11. Enter Department Field Using any Locator of Your Choice
		 driver.findElement(By.name("departmentName")).sendKeys("Engineering");
		 
	 // 12. Enter Description Field Using any Locator of your choice 
		 driver.findElement(By.name("description")).sendKeys("This is a test field. Will check");
		 
	 // 13. Enter your email in the E-mail address Field using the locator of your choice
		 driver.findElement(By.id("createContactForm_primaryEmail")).sendKeys("ArpiMenon21@gmail.com");
		 
	  //14. Select State/Province as NewYork Using Visible Text
		 Select USstate = new Select(driver.findElement(By.name("generalStateProvinceGeoId")));
		 USstate.selectByVisibleText("Ohio");
		 
	  // 15. Click on Create Contact
		 driver.findElement(By.name("submitButton")).click();
		
	}
	
	public void updateContact(WebDriver driver) {
	//  16. Click on edit button 
				 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
				 driver.findElement(By.linkText("Edit")).click();
			  
			  // 17. Clear the Description Field using .clear
				 driver.findElement(By.name("description")).clear();
				 
			  // 18. Fill ImportantNote Field with Any text
				 driver.findElement(By.xpath("//textarea[@name='importantNote']")).sendKeys("This is important");
				 
			  //  19. Click on update button using Xpath locator
				 driver.findElement(By.xpath("//textarea[@name='importantNote']//following::input[@class='smallSubmit'][1]")).click();
				 
			 // 20. Get the Title of Resulting Page.
				 System.out.println(driver.getTitle());
	        
	}

	public static void main(String[] args) {
		  
		UtilFiles util = new UtilFiles();
		WebDriver driver = util.setUpDriver("chrome");
		CreateContact cc = new CreateContact();
		
		 // 1. Launch URL "http://leaftaps.com/opentaps/control/login"
		  	driver.get("http://leaftaps.com/opentaps/control/login");
		  	
		  cc.loginToLeafTaps(driver);
		  cc.createContact(driver);
		  cc.updateContact(driver);
		
	}

}
