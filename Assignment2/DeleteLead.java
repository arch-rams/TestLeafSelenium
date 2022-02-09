package week2.Day2;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.seleniumProject.UtilFiles;

public class DeleteLead {

	/*
	 * http://leaftaps.com/opentaps/control/main
	 * 
	 * Delete Lead: 1 Launch the browser 2 Enter the username 3 Enter the password 4
	 * Click Login 5 Click crm/sfa link 6 Click Leads link 7 Click Find leads 8
	 * Click on Phone 9 Enter phone number 10 Click find leads button 11 Capture
	 * lead ID of First Resulting lead 12 Click First Resulting lead 13 Click Delete
	 * 14 Click Find leads 15 Enter captured lead ID 16 Click find leads button 17
	 * Verify message "No records to display" in the Lead List. This message
	 * confirms the successful deletion 18 Close the browser (Do not log out)
	 */

	public static void main(String[] args) {

		UtilFiles util = new UtilFiles();
		WebDriver driver = util.setUpDriver("chrome");
		util.maximize(driver);

		// 1. Launch URL "http://leaftaps.com/opentaps/control/login"
		driver.get("http://leaftaps.com/opentaps/control/login");

		CreateContact cc = new CreateContact();
		cc.loginToLeafTaps(driver);

		DeleteLead dl = new DeleteLead();
		dl.findLead(driver,"Phone");
		dl.deleteLead(driver);

		driver.quit();

	}

	void findLead(WebDriver driver, String findBy) {
		// Click Leads link
		driver.findElement(By.linkText("Leads")).click();

		// Click Find leads
		driver.findElement(By.xpath("//div[@class='frameSectionBody']//li[3]/a")).click();

		if (findBy == "Phone") {
			// Click on Phone
			driver.findElement(By.linkText("Phone")).click();
			// Enter Phone Number
			driver.findElement(By.name("phoneCountryCode")).sendKeys("1" + Keys.TAB + "321" + Keys.TAB + "3695512");
		
		} else if (findBy == "Email") {
			driver.findElement(By.linkText("Email")).click();
			driver.findElement(By.name("emailAddress")).sendKeys("test@selenium.com");
		} else if(findBy == "Name") {
			driver.findElement(By.xpath("(//input[@name='firstName'])[3]")).sendKeys("Test");
			driver.findElement(By.xpath("(//input[@name='lastName'])[3]")).sendKeys("Leaf");
		}
		// Find Lead
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void deleteLead(WebDriver driver) {

		// Click on Phone
		String firstID = driver.findElement(By.xpath("//tr//a[@class='linktext'][1]")).getText();
		System.out.println("The first Lead ID is: " + firstID);
		System.out.println("Deleting...");

		// Click Delete
		driver.findElement(By.xpath("//tr//a[@class='linktext'][1]")).click();
		driver.findElement(By.linkText("Delete")).click();

		// Verify message "No records to display" in the Lead List
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.name("id")).sendKeys(firstID);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='x-paging-info']")).getText(),
				"No records to display");
		System.out.println("Assertion completed");
	}
}
