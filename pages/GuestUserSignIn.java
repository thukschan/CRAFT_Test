package pages;

import org.openqa.selenium.By;

import supportlibraries.*;

import com.cognizant.framework.Status;


/**
 * BookFlightPage class
 * @author Cognizant
 */
public class GuestUserSignIn extends MasterPage
{
	/**
	 * Constructor to initialize the page
	 * @param scriptHelper The {@link ScriptHelper} object passed from the {@link DriverScript}
	 */
	By emailAddress = By.id("create_email");
	By password = By.id("create_password");
	By confirmPassword = By.id("create_password_confirm");
	By register = By.id("btn_create_account");
	public GuestUserSignIn(ScriptHelper scriptHelper)
	{
		super(scriptHelper);
		cf = new ConvenientFunction(driver,report);
	}
	
	public GuestUserSignIn registerUser()
	{
		String guestEmail = dataTable.getData("RegisterUser_Data", "Email");
		String guestPassword = dataTable.getData("RegisterUser_Data", "Password");
		
		
		driver.findElement(emailAddress).sendKeys(guestEmail);
		driver.findElement(password).sendKeys(guestPassword);
		driver.findElement(confirmPassword).sendKeys(guestPassword);
		driver.findElement(register).click();
		report.updateTestLog("Guest user sign in", "Guest user is signed in successfully", Status.PASS);
		
		return new GuestUserSignIn(scriptHelper);
	}
	
}