package com.crossover.robotframework.JavaRobot;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
 
import org.openqa.selenium.support.How;
import org.testng.Assert;
import org.testng.annotations.Test;
 
public class CrossoverLandingPage {
 
	WebDriver driver;
	
	By ForCandidates = By.xpath("//*[@id='desktopNav']/nav/div/ul/li[4]/a/span[contains(text(),'For Candidates')]");
 
	By AvailableJobs = By.xpath("//*[@class='title-desc-wrapper over-image has-main-image']/div[2]/div[2]/p[2]/a");
	
	By JobTitle = 	By.xpath("//*[@id='available-jobs']/div[2]/form/div/div[1]/div/input");
  
	By SearchJobs = By.xpath("//*[@id='available-jobs']/div[2]/form/div/div[3]/button");
	
	By Reset = By.xpath("//button[@ng-click='filterReset()']");
	
	By JobCategories = By.xpath("//span[contains(.,'All Job Categories')]"); 
	
	By Java = By.xpath("//span[contains(.,'Java')]"); 
	
	By Icon = By.xpath("html/body/div[2]/div[1]/div/header/nav/div/h1/a/div");
	
	public CrossoverLandingPage(WebDriver driver)
 
	{
		this.driver = driver;
		
	}
	
	@Test
	public void navigateToForCandidates () {
		WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='desktopNav']/nav/div/ul/li[4]/a/span[contains(text(),'For Candidates')]") ));
		driver.findElement(ForCandidates).click();
		Assert.assertTrue(driver.getCurrentUrl().contains("candidates"));
	}
	
	@Test
	public void navigateToAvailableJobs() {
		driver.findElement(AvailableJobs).click();
		Assert.assertTrue(driver.getCurrentUrl().contains("available-jobs"));
		
	}
	
	@Test
	public void FocusOnJobTitle() {
		driver.findElement(JobTitle).click();
		Assert.assertTrue(driver.findElement(JobTitle).isEnabled());
		
	}
	@Test
	public void EnterChiefInJobTitle(String SEARCHTEXT) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(JobTitle).sendKeys(SEARCHTEXT);
	}
	
	@Test
	public void ClickSearchJobs() {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(SearchJobs).click();

	}
	
	@Test
	public void Verifytheresults(String SEARCHTEXT) throws InterruptedException   {
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
		    	   //Assert.assertTrue(rowText.toLowerCase().contains(SEARCHTEXT));
		       }
		}
	}
	
	@Test
	public void ClickReset() {
		WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(Reset));
		driver.findElement(Reset).click();

	}
	
	@Test
	public void SelectJavafromJobCategories() {
		
		WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(JobCategories));
		driver.findElement(JobCategories).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(Java));
		driver.findElement(Java).click();

	}
	
	@Test
	public void NavigateToHomePage() {
		
		driver.findElement(Icon).click();
		
	}

	@Test
	public void CloseTheBrowser() {
		
		driver.quit();
		
	}
	
}


	  


