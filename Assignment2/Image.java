package week2.Day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import com.seleniumProject.UtilFiles;

public class Image {
	
	public static void main(String[] args) {
		UtilFiles util = new UtilFiles();
		WebDriver driver = util.setUpDriver("chrome");
		util.maximize(driver);

		// 1. Launch URL
		driver.get("http://leafground.com/pages/Image.html");
		
		//click to go to  home page
		driver.findElement(By.xpath("//img[contains(@src,'home.png')]")).click();
		driver.navigate().back();
		
		//broken image
		if(driver.findElement(By.xpath("//img[contains(@src,'abcd')]")).getAttribute("naturalWidth").equals("0"))
		{
			System.out.println("Image is broken");
		}
		
		//click on image using mouse:
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//img[contains(@src,'keyboard')]"))).click().build().perform();
	}

}
