package pages;

import supportlibraries.*;


/**
 * MasterPage Abstract class
 * @author Cognizant
 */
abstract class MasterPage extends ReusableLibrary
{		
	/**
	 * Constructor to initialize the functional library
	 * @param scriptHelper The {@link ScriptHelper} object passed from the {@link DriverScript}
	 */
	protected MasterPage(ScriptHelper scriptHelper)
	{
		super(scriptHelper);
	}
		
}