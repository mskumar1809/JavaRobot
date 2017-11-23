package com.crossover.robotframework.JavaRobot;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import com.crossover.robotframework.JavaRobot.CrossoverLandingPage;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.PageFactory;
import org.robotframework.javalib.annotation.ArgumentNames;
import org.robotframework.javalib.annotation.RobotKeyword;
import org.robotframework.javalib.annotation.RobotKeywords;
import org.testng.Assert;
import org.testng.annotations.Test;


@RobotKeywords

public class KeywordImplementations {
	
	static WebDriver driver;
	CrossoverLandingPage objcrossoverlandingpage = new CrossoverLandingPage(driver);
	
	
	@RobotKeyword("Launch Crossover Website")
    @ArgumentNames({"URL", "Browser"})
	public void LaunchCrossoverWebsite(String url, String Browser) {
		driver = new ChromeDriver();
		driver.get(url);	
		Assert.assertTrue(driver.getCurrentUrl().contains(url));		
	}
	
	@RobotKeyword("Maximize Browser")
	public void MaximizeBrowser() {
		driver.manage().window().maximize();				
	}
	
	@RobotKeyword("Navigate to For Candidates")
	
	public void NavigateToForCandidates() {
		//objcrossoverlandingpage = new CrossoverLandingPage(driver);
		objcrossoverlandingpage.navigateToForCandidates();
	 
	}
	
@RobotKeyword("Navigate to Available Jobs")
	
	public void NavigateToAvailableJobs() {
		objcrossoverlandingpage.navigateToAvailableJobs();
	 
	}

/*Focus on Job Title
Type Chief in Job Title
Click Search Jobs*/

@RobotKeyword("Focus on Job Title")

public void FocusOnJobTitle() {
	objcrossoverlandingpage.FocusOnJobTitle();
 
	}

@RobotKeyword("Enter search text In Job Title")
@ArgumentNames({"SEARCHTEXT"})

public void EnterSearchTextInJobTitle(String SEARCHTEXT) {
	
	objcrossoverlandingpage.EnterChiefInJobTitle(SEARCHTEXT);
	
	
	}

@RobotKeyword("Click Search Jobs")

public void ClickSearchJobs() {
	objcrossoverlandingpage.ClickSearchJobs();
 
	}

@RobotKeyword("Verify the results")

public void Verifytheresults() {
	objcrossoverlandingpage.Verifytheresults();
 
	}

@RobotKeyword("Reset the filter")

public void Resetthefilter() {
	objcrossoverlandingpage.ClickReset();
 
	}

@RobotKeyword("Select Java from Job Categories")

public void SelectJavafromJobCategories() {
	objcrossoverlandingpage.SelectJavafromJobCategories();
 
	}

@RobotKeyword("Navigate to Home Page")
public void NavigateToHomePage() {
	objcrossoverlandingpage.NavigateToHomePage();
 
	}

@RobotKeyword("Close the Browser")
public void CloseTheBrowser() {
	objcrossoverlandingpage.CloseTheBrowser();
 
	}

}
