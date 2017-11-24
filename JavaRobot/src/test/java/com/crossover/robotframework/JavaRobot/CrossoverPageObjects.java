package com.crossover.robotframework.JavaRobot;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.Iterator;

public class CrossoverPageObjects {

	WebDriver driver;
	
	/***
	 * 
	 * Page Objects declarations
	 *  
	 */
	private static final By FORCANDIDATES = By
			.xpath("//*[@id='desktopNav']/nav/div/ul/li[4]/a/span[contains(text(),'For Candidates')]");

	private static final By AVAILABLEJOBS = By.xpath("//*[@class='title-desc-wrapper over-image has-main-image']/div[2]/div[2]/p[2]/a");

	private static final By JOBTITLE = By.xpath("//*[@id='available-jobs']/div[2]/form/div/div[1]/div/input");

	private static final By SEARCHJOBS = By.xpath("//*[@id='available-jobs']/div[2]/form/div/div[3]/button");

	private static final By RESET = By.xpath("//button[@ng-click='filterReset()']");

	private static final By JOBCATEGORIES = By.xpath("//span[contains(.,'All Job Categories')]");

	private static final By JAVA = By.xpath("//span[contains(.,'Java')]");

	private static final By ICON = By.xpath("html/body/div[2]/div[1]/div/header/nav/div/h1/a/div");

	private static final By LOGIN = By.xpath("html/body/div[2]/div[1]/div/header/nav/div/div[3]/ul/li[1]/a");
	

	public CrossoverPageObjects(WebDriver driver) {
		this.driver = driver;
	}

	/***
	 * 
	 * Method and test for Navigation to For Candidates
	 *  
	 */
	
	@Test
	public void navigateToForCandidates() {
		click(FORCANDIDATES);
		Assert.assertTrue(driver.getCurrentUrl().contains("candidates"));
	}
	
	/***
	 * 
	 * Method and test for Navigation to Available Jobs
	 *  
	 */

	@Test
	public void navigateToAvailableJobs() {
		click(AVAILABLEJOBS);
		Assert.assertTrue(driver.getCurrentUrl().contains("available-jobs"));
	}

	/***
	 * 
	 * Method and test for Focusing on Job Title
	 *  
	 */
	
	@Test
	public void focusOnJobTitle() {
		click(JOBTITLE);
		Assert.assertTrue(driver.findElement(JOBTITLE).isEnabled());
	}
	
	/***
	 * 
	 * Method and test for clicking Search Button
	 *  
	 */

	@Test
	public void enterChiefInJobTitle(String searchText) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		sendKeys(JOBTITLE, searchText);
		String text = driver.findElement(JOBTITLE).getAttribute("value");
		Assert.assertTrue(text.equals(searchText));
	}
	
	/***
	 * 
	 * Method and test for clicking Search Button
	 *  
	 */
	
	@Test
	public void clickSearchJobs() {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		click(SEARCHJOBS);
		Assert.assertTrue(driver.findElement(RESET).isDisplayed());
	}

	/***
	 * 
	 * Method and test for Verifying the returned results with the Search Criteria
	 *  
	 */
	
	@Test
	public void verifyResults(String searchText) throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].scrollTop = arguments[1];",
				driver.findElement(By.xpath(".//*[@id='available-jobs']/div[3]/div[2]/div")), 11000);
		
		Thread.sleep(5000);
		List<WebElement> table = driver.findElements(By.xpath("//div[@class='cell title ng-binding']"));
		Iterator<WebElement> i = table.iterator();

		while (i.hasNext()) {

			WebElement row = i.next();

			if (row.getText() != null && row.getText().toString().length() > 0) {
				String rowText = row.getText().toString();
				System.out.println(row.getText().toString());
				Assert.assertTrue(rowText.toLowerCase().contains(searchText));
			}
		}
	}

	/***
	 * 
	 * Method and test for Clicking Reset Button
	 *  
	 */
	
	@Test
	public void clickReset() {
		click(RESET);
		Assert.assertTrue(driver.findElements(RESET).size() == 0);
	}

	/***
	 * 
	 * Method and test for Selection of Java from All Job Categories Drop Down
	 *  
	 */
	
	@Test
	public void selectJavaFromJobCategories() {
		click(JOBCATEGORIES);
		click(JAVA);
		isVisible(RESET, true);
	}

	/***
	 * As there is no Element of "Companies" in the stated Webpage, Navigation to Home page is performed
	 * 
	 * Method and test for Navigation to the Home page
	 * 
	 * 
	 */
	
	@Test
	public void navigateToHomePage() {
		click(ICON);
		isVisible(LOGIN, true);
	}

	/***
	 * Method to close the browser
	 */
	
	public void closeTheBrowser() {
		driver.quit();
	}
	
	/***
	 * Method to check the visibility of the element and then perform click operation
	 * 
	 * @param path
	 */
	
	private void click(By path) {
		if (isVisible(path, true)) {
			driver.findElement(path).click();
		}
	}
	
	/***
	 * Method to check the visibility of the element and then perform send keys operation
	 * 
	 * @param path
	 * @param text
	 */
	
	private void sendKeys(By path, String text) {
		if (isVisible(path, true)) {
			driver.findElement(path).sendKeys(text);
		}
	}
	
	/***
	 * Check if element by path is visible
	 * 
	 * @param path
	 * @param throwException
	 *            if true, will perform assert operation on visibility
	 * @return visibility
	 */
	
	private boolean isVisible(By path, boolean throwException) {
		boolean isVisible = driver.findElements(path).size() > 0;
		if (throwException) {
			Assert.assertTrue(isVisible);
		}
		return isVisible;
	}

}
