package com.qa.keywords;




import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



public class GridGate {
	WebDriver driver;
	
	public GridGate(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		
	}
	public void onGreenBoxClick() throws IOException
	{
		
		 Properties obj = new Properties();
		 FileInputStream objfile = new FileInputStream(System.getProperty("user.dir")+"\\environment.properties");
		 obj.load(objfile);
		 driver.findElement(By.cssSelector(obj.getProperty("GreenBox"))).click();
		 //greenBox.click();
		 
	}
	
	public String getGridGateTitle()
	{
		return driver.getTitle();
	}

}
