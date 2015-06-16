package pages;

import org.openqa.selenium.By;

import supportlibraries.*;

import com.cognizant.framework.Status;


/**
 * BookFlightPage class
 * @author Cognizant
 */
public class MyBag extends MasterPage
{
	/**
	 * Constructor to initialize the page
	 * @param scriptHelper The {@link ScriptHelper} object passed from the {@link DriverScript}
	 */
	ConvenientFunction cf ;
	By myBagPage = By.xpath("//span[.='Shopping Bag Summary']");
	By cartItem = By.className("tbl_shopping_bag");
	By checkout = By.xpath("//a[.='Checkout']");
	public MyBag(ScriptHelper scriptHelper)
	{
		super(scriptHelper);
		cf = new ConvenientFunction(driver,report);
	}	
	
	/**
	 * To verify item is displayed in cart page
	 * 
	 * @return
	 */
	public MyBag verifyBagPageContain()
	{
		
		//cf.getText(driver, myBagPage, "Shopping Bag Summary");
		if(cf.verifyElementDisplayed(driver, cartItem) == true)
			report.updateTestLog("Verify cart item", "Item is displayed in cart page", Status.PASS);
		else
			report.updateTestLog("Verify cart item", "Item is displayed in cart page", Status.FAIL);
		
		return new MyBag(scriptHelper);
	}
	
	/**
	 * To verify item is displayed in cart page
	 * 
	 * @return
	 */
	public GuestUserSignIn clickOnCheckout()
	{
		
		cf.clickButton(driver, checkout, "Checkout");	
		
		return new GuestUserSignIn(scriptHelper);
	}
	
}