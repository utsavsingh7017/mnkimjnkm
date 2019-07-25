package com.qa.keywords;



import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



public class FrameDungeon {
	WebDriver driver;
	String firstBoxColour="";
	String secondBoxColour="";
	
	public FrameDungeon(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		
	}
	public void onColourMatching() throws IOException
	{
		  
		 driver.switchTo().frame("main");
		 Properties obj = new Properties();
		 FileInputStream objfile = new FileInputStream(System.getProperty("user.dir")+"\\environment.properties");
		 obj.load(objfile);
   	     firstBoxColour=driver.findElement(By.id(obj.getProperty("BoxColour"))).getAttribute("class");
		 //firstBoxColour=boxColour.getAttribute("class");
    	 do
    	 { 
    	   driver.findElement(By.linkText(obj.getProperty("RepaintButton"))).click();
           driver.switchTo().frame("child");
           secondBoxColour=driver.findElement(By.id(obj.getProperty("BoxColour"))).getAttribute("class");
          // secondBoxColour=boxColour.getAttribute("class");
           driver.switchTo().parentFrame();
    	 }
    	 while(!firstBoxColour.equals(secondBoxColour));
    	 driver.findElement(By.linkText(obj.getProperty("Proceed"))).click();
	}
	
	public String getFrameDungeonTitle()
	{
		return driver.getTitle();
	}
	
}
