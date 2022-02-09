package week2.Day2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.seleniumProject.UtilFiles;

public class Checkbox {
	public static void main(String[] args) {
		UtilFiles util = new UtilFiles();
		WebDriver driver = util.setUpDriver("chrome");
		util.maximize(driver);

		// 1. Launch URL
		driver.get("http://leafground.com/pages/checkbox.html");

		// lang known
		Map<String, WebElement> langMap = new HashMap<>();
		List<WebElement> langLink = new ArrayList<>();
		List<WebElement> langName = new ArrayList<>();

		// assigning Checkbox and their names to list elements
		langLink = driver.findElements(By.xpath("//div[@class='example'][1]//input"));
		langName = driver.findElements(By.xpath("//div[@class='example'][1]//input/parent::div"));

		// assigning values in map
		for (int i = 0; i < langName.size(); i++) {
			langMap.put(langName.get(i).getText(), langLink.get(i));
		}

		String[] arr = { "Java", "SQL", "C++" };
		for (String val : arr) {
			if (langMap.containsKey(val)) {
				langMap.get(val).click();
			}
		}

		// element is selected:
		if (driver.findElement(By.xpath("//div[@class='example'][2]//input")).isSelected()) {
			System.out.println("Selenium is selected");
		}

		// Deselect selected:
		List<WebElement> elts = driver.findElements(By.xpath("//div[@class='example'][3]//input"));
		for (WebElement elt : elts) {
			if (elt.isSelected()) {
				elt.click();
			}
		}

		// all opt
		List<WebElement> allOpt = driver.findElements(By.xpath("//div[@class='example'][4]//input"));
		for (WebElement elt : allOpt) {
			elt.click();

		}

	}
}
