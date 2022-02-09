package week2.Day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.seleniumProject.UtilFiles;

public class DropDown {
	public static void main(String[] args) {
		UtilFiles util = new UtilFiles();
		WebDriver driver = util.setUpDriver("chrome");
		util.maximize(driver);

		// 1. Launch URL
		driver.get("http://leafground.com/pages/Dropdown.html");

		// Select using Index
		WebElement indexDrpdwn = driver.findElement(By.id("dropdown1"));
		Select indexSelect = new Select(indexDrpdwn);
		indexSelect.selectByIndex(1);

		// Select using Text
		WebElement textDrpdwn = driver.findElement(By.name("dropdown2"));
		Select textSelect = new Select(textDrpdwn);
		textSelect.selectByVisibleText("Appium");

		// Select using Value
		WebElement valDrpdwn = driver.findElement(By.name("dropdown3"));
		Select valSelect = new Select(valDrpdwn);
		valSelect.selectByValue("2");

		// No. Of Dropdown Options
		WebElement drpdwnOpt = driver.findElement(By.className("dropdown"));
		Select optSelect = new Select(drpdwnOpt);
		System.out.println("Number of options is: " +optSelect.getOptions().size());
		
		// Sendkeys to select
		WebElement sendKeysElt = driver.findElement(By.xpath("(//div[@class='example']/select)[5]"));
		sendKeysElt.sendKeys("LoadRunner");
		
		//multiselect
		WebElement multiple = driver.findElement(By.xpath("(//div[@class='example']/select)[6]"));
		Select slctMultiple = new Select(multiple);
		if(slctMultiple.isMultiple()) {
			slctMultiple.selectByIndex(4);
			slctMultiple.selectByIndex(3);
			slctMultiple.selectByIndex(2);
		}
		
	}
}
