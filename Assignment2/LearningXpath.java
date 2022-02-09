package week2.Day2;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearningXpath {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		// System.setProperty("webdriver.chrome.driver","D:\\Archana\\AutoResourceFiles\\chromeDriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		
		//Login
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("Demosalesmanager");
		driver.findElement(By.xpath("//input[@name='PASSWORD']")).sendKeys("crmsfa");
		driver.findElement(By.xpath("//input[contains(@class,'decorative')]")).click();
		
		//click on link:
		driver.findElement(By.xpath("//a[contains(text(),'CRM')]")).click();
		
		//click on create Test Lead
		driver.findElement(By.xpath("//a[text()='Create Lead']")).click();
		
		//Enter Details and create
		driver.findElement(By.xpath("(//input[@class='inputBox'])[1]")).sendKeys("TestLeaf");
		driver.findElement(By.xpath("//tr/td/input[@name='firstName']")).sendKeys("Archana");
		driver.findElement(By.xpath("(//input[@name='lastName'])[3]")).sendKeys("R");
		//driver.findElement(By.xpath("//input[@value='Create Lead']")).click();
		
		
		
	}

}
