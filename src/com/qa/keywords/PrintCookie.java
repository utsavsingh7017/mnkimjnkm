package com.qa.keywords;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



public class PrintCookie {
	WebDriver driver;
	
	public PrintCookie(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		
	}
	
	public void printCookie() throws IOException
	{
		 System.out.println(driver.manage().getCookies());
		 Properties obj = new Properties();
		 FileInputStream objfile = new FileInputStream(System.getProperty("user.dir")+"\\environment.properties");
		 obj.load(objfile);
		 driver.findElement(By.linkText(obj.getProperty("Proceed"))).click();
  	     //proceed.click(); 
  	    	
	}
	
	public String getPrintCookiePageTitle()
	{
		return driver.getTitle();
	}
}
