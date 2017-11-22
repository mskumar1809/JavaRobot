package com.crossover.robotframework.JavaRobot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
 
import org.openqa.selenium.support.FindBy;
 
import org.openqa.selenium.support.How;
import org.testng.Assert;
import org.testng.annotations.Test;
 
public class CrossoverLandingPage {
 
	WebDriver driver;
	
	By ForCandidates = By.xpath("//*[@id='desktopNav']/nav/div/ul/li[4]/a/span[contains(text(),'For Candidates')]");
 
	By AvailableJobs = By.xpath("//*[@class='title-desc-wrapper over-image has-main-image']/div[2]/div[2]/p[2]/a");
	
	By JobTitle = By.xpath("//*[@id='available-jobs']/div[2]/form/div/div[1]/div/input");
  
	public CrossoverLandingPage(WebDriver driver)
 
	{
 
		this.driver = driver;
	}
	
	
	public void navigateToForCandidates () {
		driver.findElement(ForCandidates).click();
		Assert.assertTrue(driver.getCurrentUrl().contains("candidates"));
	}
	

	public void navigateToAvailableJobs() {
		driver.findElement(AvailableJobs).click();
		Assert.assertTrue(driver.getCurrentUrl().contains("available-jobs"));
		
	}
	
	public void FocusOnJobTitle() {
		driver.findElement(JobTitle).click();
		Assert.assertTrue(driver.findElement(JobTitle).isEnabled());
		
	}
	
	public void EnterChiefInJobTitle(String searchText) {
		driver.findElement(JobTitle).sendKeys(searchText);

	}
}


	  


