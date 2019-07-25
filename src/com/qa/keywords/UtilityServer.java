package com.qa.keywords;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



public class UtilityServer {

	WebDriver driver;
	  
	public UtilityServer(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}
	public void onBaseUrlClick() throws IOException
	{
		Properties obj = new Properties();
		FileInputStream objfile = new FileInputStream(System.getProperty("user.dir")+"\\environment.properties");
		obj.load(objfile);
		driver.findElement(By.linkText(obj.getProperty("UtilityServerLink"))).click();
		//utilityServerLink.click();
		
	}
	
	public String getUtilityServerTitle()
	  {
		return driver.getTitle();
	  }
	
}
