package pages;

import org.openqa.selenium.By;

import supportlibraries.*;

import com.cognizant.framework.Status;


/**
 * BookFlightPage class
 * @author Cognizant
 */
public class HomePage extends MasterPage
{
	/**
	 * Constructor to initialize the page
	 * @param scriptHelper The {@link ScriptHelper} object passed from the {@link DriverScript}
	 */
	ConvenientFunction cf;
	public HomePage(ScriptHelper scriptHelper)
	{
		super(scriptHelper);		
		cf = new ConvenientFunction(driver,report);
	}
	
	public MyBag launchJumpURL()
	{
		String cartJumpURL = dataTable.getData("General_Data", "Jump_URL").trim();
		driver.get(cartJumpURL);
		return new MyBag(scriptHelper);
	}
}