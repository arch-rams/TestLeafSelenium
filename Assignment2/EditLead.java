package week2.Day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.seleniumProject.UtilFiles;

public class EditLead {
	/*http://leaftaps.com/opentaps/control/main
	
	* 1	Launch the browser
	* 2	Enter the username
	* 3	Enter the password
	* 4	Click Login
	* 5	Click crm/sfa link
	* 6	Click Leads link
	* 7	Click Find leads
	* 8	Enter first name
	* 9	Click Find leads button
	* 10 Click on first resulting lead
	* 11 Verify title of the page
	* 12 Click Edit
	* 13 Change the company name
	* 14 Click Update
	* 15 Confirm the changed name appears
	* 16 Close the browser (Do not log out)
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
		dl.findLead(driver,"Name");
		
		EditLead edLead = new EditLead();
		String updateValue = "TestLeaf in Test";
		edLead.updateField(driver,"Company", updateValue);

	}

	private void updateField(WebDriver driver, String field, String updateVal) {
		// Click Edit
		driver.findElement(By.xpath("//tr//a[@class='linktext'][1]")).click();
		driver.findElement(By.linkText("Edit")).click();
		
		if(field == "Company") {
			driver.findElement(By.id("updateLeadForm_companyName")).clear();
			driver.findElement(By.id("updateLeadForm_companyName")).sendKeys(updateVal);
		}
		
		driver.findElement(By.xpath("//input[@value='Update']")).click();
		
		//Assert same Value:
		Assert.assertEquals(driver.findElement(By.id("viewLead_companyName_sp")).getText().contains(updateVal), true);
		System.out.println("Update Assertion Completed");
				
		
	}
}
