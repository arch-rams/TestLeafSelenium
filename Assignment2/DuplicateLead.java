package week2.Day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.seleniumProject.UtilFiles;

public class DuplicateLead extends UtilFiles{

	/*http://leaftaps.com/opentaps/control/main
	 
	1	Launch the browser
	2	Enter the username
	3	Enter the password
	4	Click Login
	5	Click crm/sfa link
	6	Click Leads link
	7	Click Find leads
	8	Click on Email
	9	Enter Email
	10	Click find leads button
	11	Capture name of First Resulting lead
	12	Click First Resulting lead
	13	Click Duplicate Lead
	14	Verify the title as 'Duplicate Lead'
	15	Click Create Lead
	16	Confirm the duplicated lead name is same as captured name
	17	Close the browser (Do not log out)
	
	*/
	
	public static void main(String[] args) {
		WebDriver driver = setUpDriver("chrome");
		driver.manage().window().maximize();
		
		// 1. Launch URL "http://leaftaps.com/opentaps/control/login"
	  	driver.get("http://leaftaps.com/opentaps/control/login");
	  	
	  	CreateContact cc = new CreateContact();
	  	 cc.loginToLeafTaps(driver);
	  	 
	  	DeleteLead dl = new DeleteLead();
	  	 dl.findLead(driver, "Email");
	  	 
	  	 DuplicateLead dupLead = new DuplicateLead();
	  	 dupLead.createDuplicateLead(driver);
	  	 
	  	 
	  		  	 
	}

	private void createDuplicateLead(WebDriver driver) {
		//12	Click First Resulting lead
	  	driver.findElement(By.xpath("//tr//a[@class='linktext'][1]")).click();
	  	
	  	// Click Duplicate Lead
	  	driver.findElement(By.linkText("Duplicate Lead")).click();
	  	 String firstName = driver.findElement(By.id("createLeadForm_firstName")).getAttribute("value");
	  	String lastName = driver.findElement(By.id("createLeadForm_lastName")).getAttribute("value");
		System.out.println("The first Lead name is: " + firstName + " " +lastName);
		System.out.println("Duplicating...");
		//Verify the title as 'Duplicate Lead'
		Assert.assertEquals(driver.getTitle().contains("Duplicate Lead"), true);
		System.out.println("Assertion Complete");
		
		//create Duplicate Lead
		driver.findElement(By.xpath("//input[@value='Create Lead']")).click();
		Assert.assertEquals(driver.findElement(By.id("viewLead_firstName_sp")).getText(), firstName);
		Assert.assertEquals(driver.findElement(By.id("viewLead_lastName_sp")).getText(), lastName);
		System.out.println(" Duplicate Lead Assertion Complete");
		
		
	}
}
