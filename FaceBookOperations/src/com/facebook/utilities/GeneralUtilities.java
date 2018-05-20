package com.facebook.utilities;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

public class GeneralUtilities {
	public static WebDriver openWebPage(WebDriver driver, String URL){
		driver.get(URL);
		System.out.println("Opened the WebPage " + URL);
		return driver;
	}
	
	
	public static String getValueOf(String fileName, String Key) throws IOException{
		System.out.println("<*** Inside getValueOf ****>");
		System.out.println("File Name :" + fileName + ", Key : " + Key);
		FileReader file = new FileReader("./src/Configuration/" + fileName);
		Properties prop = new Properties();
		prop.load(file);
		String keyValue = prop.getProperty(Key);
		System.out.println(keyValue);
		
		return keyValue;
	}

}


