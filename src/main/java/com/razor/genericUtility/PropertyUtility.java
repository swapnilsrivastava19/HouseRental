package com.razor.genericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.razor.EnumUtility.PropertyKeyData;
/**
 * This class contains reusable methods to handle property File
 * @author Vishwanath-Naik
 *
 */
public class PropertyUtility
{
	private Properties prop;
	/**
	 * This constructor will initialize property file
	 * @param filePath
	 * @throws IOException
	 */
	public PropertyUtility(String filePath)
	{
		FileInputStream fisProperty = null;
		try {
			fisProperty = new FileInputStream(filePath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		prop = new Properties();
		try {
			prop.load(fisProperty);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			fisProperty.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * This constructor is used to create object for class
	 */
	public PropertyUtility() {}
	/**
	 * This method is used to initialize Property file
	 * @deprecated new PropertyUtility(String filePath)
	 * @param filePath
	 * @throws Throwable
	 */
	@Deprecated
	public void initializePropertyFile(String filePath) throws Throwable
	{
		FileInputStream fisProperty=new FileInputStream(filePath);
		prop = new Properties();
		prop.load(fisProperty);
		fisProperty.close();
	}
	/**
	 * This method is used to fetch data from property file based on key
	 * @param url
	 * @return
	 */
	public String getPropertyData(PropertyKeyData key)
	{
		String keyString = key.name().toLowerCase();
		String value = prop.getProperty(keyString,keyString);
		return value;
	}
}
