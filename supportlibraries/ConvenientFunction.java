package supportlibraries;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cognizant.framework.CraftDataTable;
import com.cognizant.framework.Report;
import com.cognizant.framework.Status;


/**
 * Wrapper class for common utility functions
 * @author Cognizant
 */
public class ConvenientFunction
{
	Report report;
	WebDriver driver;
	
	/**
	 * Constructor to initialize all the objects wrapped by the {@link ConvenientFunction} class
	 * @param dataTable The {@link CraftDataTable} object
	 * @param report The {@link SeleniumReport} object
	 * @param driver The {@link WebDriver} object
	 * 
	 */
	
	public ConvenientFunction( WebDriver driver,Report report)
	{
		this.driver = driver;
		this.report = report;
		
	}	
	
	/**
	 * To verify element is displayed
	 * @param driver
	 * @param element
	 * @return
	 */
	public boolean verifyElementDisplayed(WebDriver driver,By element){
		
		// To wait till element loaded
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		boolean isDisplayed = false;
		try{
			isDisplayed = driver.findElement(element).isDisplayed();
			
		}
		catch(StaleElementReferenceException e){
			e.printStackTrace();
			// driver.navigate().refresh();
			isDisplayed = driver.findElement(element).isDisplayed();
		}
		return isDisplayed;
	}
	
	/**
	 * To get text from application
	 * @param driver
	 * @param element
	 * @return
	 */
	public String getText(WebDriver driver,By element){
		
		// To wait till element loaded
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		boolean isDisplayed = false;
		String text = null;
		try{
			isDisplayed = driver.findElement(element).isDisplayed();
			if(isDisplayed== true){
				text = driver.findElement(element).getText().trim();
			}
			else{
				text = null;
			}
			
		}
		catch(StaleElementReferenceException e){
			e.printStackTrace();
			isDisplayed = driver.findElement(element).isDisplayed();
			driver.navigate().refresh();
			isDisplayed = driver.findElement(element).isDisplayed();
			if(isDisplayed== true){
				text = driver.findElement(element).getText().trim();
			}
			else{
				text = null;
			}
		}
		return text;
	}
	
	/**
	 * To get text from application
	 * @param driver
	 * @param element
	 * @return
	 */
	public String getText(WebDriver driver,By element,String expected){
		
		// To wait till element loaded
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		boolean isDisplayed = false;
		String text = null;
		try{
			isDisplayed = driver.findElement(element).isDisplayed();
			text = driver.findElement(element).getText().trim();
			if(isDisplayed== true && text.contains(expected)){
				report.updateTestLog("Verify Text", "<b>"+ expected+" </b> is displayed application as expected", Status.PASS);
			}
			else{
				report.updateTestLog("Verify Text", "<b>"+ expected+" </b> is not displayed application", Status.FAIL);
			}
			
		}
		catch(StaleElementReferenceException e){
			e.printStackTrace();
			driver.navigate().refresh();
			isDisplayed = driver.findElement(element).isDisplayed();
			text = driver.findElement(element).getText().trim();
			if(isDisplayed== true && text.contains(expected)){
				report.updateTestLog("Verify Text", "<b>"+ expected+" </b> is displayed application as expected", Status.PASS);
			}
			else{
				report.updateTestLog("Verify Text", "<b>"+ expected+" </b> is not displayed application", Status.FAIL);
			}
		}
		return text;
	}
	
	/**
	 * To get text from application
	 * @param driver
	 * @param element
	 * @return
	 */
	public void clickButton(WebDriver driver,By element,String buttonName){
		
		// To wait till element loaded
		boolean isDisplayed = false;
		try{
			//scrollToView(driver,element);
			isDisplayed = driver.findElement(element).isDisplayed();
			
			if(isDisplayed== true){
				driver.findElement(element).click();
				report.updateTestLog("Click on "+buttonName, "<b>"+ buttonName+" </b> is clicked in application as expected", Status.PASS);
			}
			else{
				report.updateTestLog("Click on "+buttonName, "<b>"+ buttonName+" </b> is not displayed in application", Status.FAIL);
			}
			
		}
		catch(StaleElementReferenceException e){
			e.printStackTrace();
			driver.navigate().refresh();
			isDisplayed = driver.findElement(element).isDisplayed();
			if(isDisplayed== true){
				driver.findElement(element).click();
				report.updateTestLog("Click on "+buttonName, "<b>"+ buttonName+" </b> is clicked in application as expected", Status.PASS);
			}
			else{
				report.updateTestLog("Click on "+buttonName, "<b>"+ buttonName+" </b> is not displayed in application", Status.FAIL);
			}
		}
	}
	/**
	 * 
	 * To get text value from application
	 * 
	 * 
	 * 
	 * 
	 * 
	 * @since Oct 25, 2012
	 * 
	 * @author mxr8044
	 */

	public void scrollToView(WebDriver driver, By locator) {

		try

		{
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", driver.findElement(locator));
		}

		catch (Exception e)

		{
			System.out.println("Unable to scroll to view");

		}

	}
}