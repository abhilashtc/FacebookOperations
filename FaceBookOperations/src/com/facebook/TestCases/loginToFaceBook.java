package com.facebook.TestCases;

import java.io.IOException;

import org.apache.commons.text.diff.StringsComparator;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.facebook.utilities.GeneralUtilities;

public class loginToFaceBook {
	
  WebDriver driver;
  public String url;
  
  @BeforeSuite
  public void beforeTest() throws Exception {
	System.setProperty("webdriver.gecko.driver","D:/SeleniumDependencyDrivers/geckodriver.exe");
	driver = new FirefoxDriver();
	url = GeneralUtilities.getValueOf("environmentDetails.properties", "URL").trim();
	driver.get(url);
	System.out.println("Opened WebPage " + url );
  }
  

  @AfterTest
  public void afterTest() throws Exception{
	  System.out.println("Inside AfterTest");
//	  driver.quit();
  }


	
  @Test(priority = 1, enabled=true)
  @Parameters({"userName", "userPassword"})
  public void loginWithValidUserName(String userName, String userPassword) throws IOException {
	  System.out.println("Inside loginWithValidUserName..." + userName + " .. "+ userPassword);
	  
	  String userNameTBox = GeneralUtilities.getValueOf("loginPage.properties", "loginTextBox").trim();
	  String passwordTBox = GeneralUtilities.getValueOf("loginPage.properties", "loginPassword").trim();
	  String loginButton = GeneralUtilities.getValueOf("loginPage.properties", "loginButton").trim();
	  
	  
	  System.out.println("---" + userNameTBox);
	  System.out.println("---" + passwordTBox);
	  
	  driver.findElement(By.xpath(userNameTBox)).sendKeys(userName);
	  driver.findElement(By.xpath(passwordTBox)).sendKeys(userPassword);
	  driver.findElement(By.xpath(loginButton)).click();
	  
	  
	/*
//	  driver.findElement(By.id("//*[@id='email']")).sendKeys(userName);
//	  driver.findElement(By.id(passwordTBox)).sendKeys(userPassword);
	  System.out.println("Page Title is -> " + driver.getTitle());
	  driver.findElement(By.xpath("//input[@id='email']")).sendKeys(userName);
	  driver.findElement(By.xpath("//input[@id='pass']")).sendKeys(userName);
	  
	  */
  }

  
}