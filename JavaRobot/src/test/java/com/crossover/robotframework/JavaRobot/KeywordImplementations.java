package com.crossover.robotframework.JavaRobot;
import com.crossover.robotframework.JavaRobot.CrossoverPageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.*;
import org.robotframework.javalib.annotation.ArgumentNames;
import org.robotframework.javalib.annotation.RobotKeyword;
import org.robotframework.javalib.annotation.RobotKeywords;
import org.testng.Assert;

@RobotKeywords
public class KeywordImplementations {

	static WebDriver driver;
	CrossoverPageObjects objcrossoverlandingpage = new CrossoverPageObjects(driver);

	@RobotKeyword("Launch Crossover Website")
	@ArgumentNames({ "URL", "Browser" })
	public void launchCrossoverWebsite(String url, String Browser) {
		driver = new ChromeDriver();
		driver.get(url);
		Assert.assertTrue(driver.getCurrentUrl().contains(url));
	}

	@RobotKeyword("Maximize Browser")
	public void maximizeBrowser() {
		driver.manage().window().maximize();
	}

	@RobotKeyword("Navigate to For Candidates")
	public void navigateToForCandidates() {
		// objcrossoverlandingpage = new CrossoverLandingPage(driver);
		objcrossoverlandingpage.navigateToForCandidates();
	}

	@RobotKeyword("Navigate to Available Jobs")
	public void navigateToAvailableJobs() {
		objcrossoverlandingpage.navigateToAvailableJobs();
	}

	@RobotKeyword("Focus on Job Title")
	public void focusOnJobTitle() {
		objcrossoverlandingpage.focusOnJobTitle();
	}

	@RobotKeyword("Enter search text In Job Title")
	@ArgumentNames({ "SEARCHTEXT" })
	public void enterSearchTextInJobTitle(String SEARCHTEXT) {
		objcrossoverlandingpage.enterChiefInJobTitle(SEARCHTEXT);
	}

	@RobotKeyword("Click Search Jobs")
	public void clickSearchJobs() {
		objcrossoverlandingpage.clickSearchJobs();
	}

	@RobotKeyword("Verify the results")
	@ArgumentNames({ "SEARCHTEXT" })
	public void verifyTheResults(String SEARCHTEXT) {
		try {
			objcrossoverlandingpage.verifyResults(SEARCHTEXT);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RobotKeyword("Reset the filter")
	public void resetTheFilter() {
		objcrossoverlandingpage.clickReset();
	}

	@RobotKeyword("Select Java from Job Categories")
	public void selectJavaFromJobCategories() {
		objcrossoverlandingpage.selectJavaFromJobCategories();
	}

	@RobotKeyword("Navigate to Home Page")
	public void navigateToHomePage() {
		objcrossoverlandingpage.navigateToHomePage();
	}
	
	@RobotKeyword("Close the Browser")
	public void closeTheBrowser() {
		objcrossoverlandingpage.closeTheBrowser();
	}

}
