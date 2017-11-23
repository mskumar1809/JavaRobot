package com.crossover.robotframework.JavaRobot;
import org.openqa.selenium.support.ui.Select;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
 
public class SampleKeywords {
	
	@Test
	public void verifySearch() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","/Users/sampathkumar/Documents/Webdriver/chromedriver");
		   WebDriver driver = new ChromeDriver();
		   driver.manage().window().maximize();
		   driver.get("https://app.crossover.com/x/marketplace/available-jobs?title=chief");
		   Thread.sleep(10000);
		   
		   JavascriptExecutor js = (JavascriptExecutor) driver;

		// Scroll inside web element vertically (e.g. 100 pixel)
		   js.executeScript("arguments[0].scrollTop = arguments[1];",driver.findElement(By.xpath(".//*[@id='available-jobs']/div[3]/div[2]/div")), 11000);
	
		  Thread.sleep(5000);
		  
		  List<WebElement> table = driver.findElements(By.xpath("//div[@class='cell title ng-binding']"));
		  
		   java.util.Iterator<WebElement> i = table.iterator();
		   
		   while(i.hasNext()) {
			 
		       WebElement row = i.next();
		       
		       if (row.getText() != null && row.getText().toString().length() > 0) {
		    	   String rowText = row.getText().toString();
		    	   System.out.println(row.getText().toString());
		    	   Assert.assertTrue(rowText.toLowerCase().contains("chief"));
		       }
		         
		}
		   
	}
	
}


