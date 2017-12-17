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
import org.openqa.selenium.support.ui.WebDriverWait;
import org.robotframework.javalib.annotation.ArgumentNames;
import org.robotframework.javalib.annotation.RobotKeyword;
import org.robotframework.javalib.annotation.RobotKeywords;
import org.testng.Assert;
import org.testng.annotations.Test;


@RobotKeywords

public class KeywordImplementations {
	
	static WebDriver driver;
	CrossoverLandingPage objcrossoverlandingpage;
	
	@RobotKeyword("Set Up")
	public void setUp(){
	 driver = new ChromeDriver();
	 objcrossoverlandingpage = new CrossoverLandingPage(driver);
	}
	
	
	@RobotKeyword("Launch Crossover Website is launched")
    @ArgumentNames({"URL", "Browser"})
	public void LaunchCrossoverWebsiteislaunched(String url, String Browser) {
		driver.get(url);	
		Assert.assertTrue(driver.getCurrentUrl().contains(url));		
	}
	
	@RobotKeyword("I Maximize Browser")
	public void IMaximizeBrowser() {
		driver.manage().window().maximize();				
	}
	
	@RobotKeyword("I Navigate to For Candidates")
	
	public void INavigateToForCandidates() {
		//objcrossoverlandingpage = new CrossoverLandingPage(driver);
		objcrossoverlandingpage.navigateToForCandidates();
	 
	}
	
@RobotKeyword("I Navigate to Available Jobs")
	
	public void INavigateToAvailableJobs() {
		objcrossoverlandingpage.navigateToAvailableJobs();
	 
	}



@RobotKeyword("I Focus on Job Title")

public void IFocusOnJobTitle() {
	objcrossoverlandingpage.FocusOnJobTitle();
 
	}

@RobotKeyword("I Enter search text In Job Title")
@ArgumentNames({"SEARCHTEXT"})

public void IEnterSearchTextInJobTitle(String SEARCHTEXT) {
	
	objcrossoverlandingpage.EnterChiefInJobTitle(SEARCHTEXT);
	
	
	}

@RobotKeyword("I Click Search Jobs")

public void IClickSearchJobs() {
	objcrossoverlandingpage.ClickSearchJobs();
 
	}

@RobotKeyword("I should see the results with searched text")
@ArgumentNames({"SEARCHTEXT"})

public void Ishouldseetheresultswithsearchedtext(String SEARCHTEXT) {
	try {
		objcrossoverlandingpage.Verifytheresults(SEARCHTEXT);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
 
	}

@RobotKeyword("I Reset the filter")

public void IResetthefilter() {
	objcrossoverlandingpage.ClickReset();
 
	}

@RobotKeyword("I Select Java from Job Categories")

public void ISelectJavafromJobCategories() {
	objcrossoverlandingpage.SelectJavafromJobCategories();
 
	}

@RobotKeyword("I Navigate to Home Page")
public void INavigateToHomePage() {
	objcrossoverlandingpage.NavigateToHomePage();
 
	}


@RobotKeyword("I should be home page")
public void Ishouldbehomepage() {
	objcrossoverlandingpage.assertHomePage();
 
	}

@RobotKeyword("Tear Down")
public void tearDown() {
	driver.quit();
}

@RobotKeyword("I am at Search results screen with Java selection")
public void IamatSearchresultsscreenwithJavaselection() {
	objcrossoverlandingpage.resultsScreeninvoke();
 
	}


}
