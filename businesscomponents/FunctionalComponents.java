package businesscomponents;

import com.cognizant.framework.Status;

import supportlibraries.ConvenientFunction;
import supportlibraries.ReusableLibrary;
import supportlibraries.ScriptHelper;
import pages.*;


/**
 * Functional Components class
 * @author Cognizant
 */
public class FunctionalComponents extends ReusableLibrary
{
	/**
	 * Constructor to initialize the component library
	 * @param scriptHelper The {@link ScriptHelper} object passed from the {@link DriverScript}
	 */
	ConvenientFunction cf = new ConvenientFunction(driver,report);
	public FunctionalComponents(ScriptHelper scriptHelper)
	{
		super(scriptHelper);
	}
	
	public void invokeApplication()
	{
		//driver.get(properties.getProperty("ApplicationUrl"));
		driver.get(dataTable.getData("General_Data", "URL"));
		report.updateTestLog("Invoke Application", "Invoke the application under test @ " +
								properties.getProperty("ApplicationUrl"), Status.DONE);
	}
	
	//===================================== Payment==========================================
	
	public void checkoutAsGuestUser()
	{
		HomePage homePage = new HomePage(scriptHelper);		
		homePage.launchJumpURL();
		MyBag mybagPage = new MyBag(scriptHelper);
		mybagPage.verifyBagPageContain();
		mybagPage.clickOnCheckout();
		GuestUserSignIn guestuserLogin = new GuestUserSignIn(scriptHelper);
		guestuserLogin.registerUser();
	}
	
	//===============================================================================================
	
			
}