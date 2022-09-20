package org.Youli.GenericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * this class consists reusable method to handle property file
 * 
 * @author SHALIVAN KHANDRE
 *
 */
public class FileUtility {
	/**
	 * this method is used for fetch the data from property files
	 * 
	 * @param propertyFilePath
	 * @param key
	 * @return
	 */
	public String getDataFromPropertyfile(String propertyFilePath, String key) {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(propertyFilePath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Properties properties = new Properties();
		try {
			properties.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
		String value = properties.getProperty(key).trim();
		return value;
	}
}
