package com.crossover.robotframework.JavaRobot;
import org.openqa.selenium.support.ui.Select;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
 
public class SampleKeywords {
	@Test
	public void verifySearch() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\bin\\chromedriver.exe");
		   WebDriver driver = new ChromeDriver();
		   driver.manage().window().maximize();
		   driver.get("https://app.crossover.com/x/marketplace/available-jobs");
		   Thread.sleep(10000);
		   //driver.findElement(By.xpath(".//*[@id='available-jobs']/div[3]/div[2]/div")).click();
		   
		  /* List Implementation
		   List<WebElement> table = driver.findElements(By.xpath("//div[@class='cell title ng-binding']"));
		   List<String> jobText = new ArrayList<String>();
		   java.util.Iterator<WebElement> i = table.iterator();
		   while(i.hasNext()) {
		       WebElement row = i.next();
		       jobText.add(row.getText().toString());
		     
		}
		   System.out.println(jobText); */
		// drop down implementation
		   driver.findElement(By.xpath("//span[contains(.,'All Job Categories')]")).click();
		   driver.findElement(By.xpath("//span[contains(.,'Java')]")).click();
	}
	
}


