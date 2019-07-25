package com.qa.keywords;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;



public class DragAround {
	WebDriver driver;

	public DragAround(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		
	}
	
	public void dragAndDrop() throws IOException
	{
	   	 Actions action=new Actions(driver);
	   	 Properties obj = new Properties();
		 FileInputStream objfile = new FileInputStream(System.getProperty("user.dir")+"\\environment.properties");
		 obj.load(objfile);
	   	 action.dragAndDrop(driver.findElement(By.id(obj.getProperty("DragBox"))),
	   			 driver.findElement(By.id(obj.getProperty("DropBox"))))
	   	 .build().perform();
	   	// Thread.sleep(1000);
	   	driver.findElement(By.linkText(obj.getProperty("Proceed"))).click(); 
	}
	
	public String getDragAroundTitle()
	{
		return driver.getTitle();
	}
	
}
