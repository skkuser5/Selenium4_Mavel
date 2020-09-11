package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadProperties {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		System.out.println(ReadProperties.readProperty("UserName"));
		

	}
	
	public static String readProperty(String key) throws IOException {

		File propertyFile = new File("C:\\Training\\Aug2020\\workspace\\Selenium4_Maven\\config.properties");
		FileInputStream fis = new FileInputStream(propertyFile);
		Properties prop = new Properties();
		prop.load(fis);
		
		String property = prop.getProperty(key);
		
	
		
		return property;
	}

}
