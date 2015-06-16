package com.cognizant.framework;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


/**
 * Singleton class that encapsulates the user settings specified in the properties file of the framework
 * @author Cognizant
 */
public class Settings
{
	private static Properties properties;
	/**
	 * Function to return the singleton instance of the {@link Properties} object
	 * @return Instance of the {@link Properties} object
	 */
	public static synchronized Properties getInstance()
	{
		if (properties == null) {
			loadFromPropertiesFile();
			overWriteFromSystem();
		}
		return properties;
	}
	
	private static void overWriteFromSystem() {
		Properties props = System.getProperties();
		for (String key : props.stringPropertyNames()) {
			// System.out.println(key + " = " + props .getProperty(key));
			if (key.startsWith("pom")) {
				String newKey = key.substring(4);
				System.out.println("Found key " + key);
				System.out.print("Overwriting " + newKey + " = " + properties.getProperty(newKey));
				properties.setProperty(newKey, props.getProperty(key));
				System.out.println(" with " + newKey + " = " + properties.getProperty(newKey));
			}
		}
	}
	
	private static void loadFromPropertiesFile()
	{
		FrameworkParameters frameworkParameters = FrameworkParameters.getInstance();
		
		if(frameworkParameters.getRelativePath() == null) {
			throw new FrameworkException("FrameworkParameters.relativePath is not set!");
		}
		
		properties = new Properties();
		
		try {
			properties.load(new FileInputStream(frameworkParameters.getRelativePath() +
									Util.getFileSeparator() + "Global Settings.properties"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new FrameworkException("FileNotFoundException while loading the Global Settings file");
		} catch (IOException e) {
			e.printStackTrace();
			throw new FrameworkException("IOException while loading the Global Settings file");
		}

	}
	
	@Override
	public Object clone() throws CloneNotSupportedException
	{
		throw new CloneNotSupportedException();
	}
}