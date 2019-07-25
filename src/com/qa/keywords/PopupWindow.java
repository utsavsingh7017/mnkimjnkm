package com.qa.keywords;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class PopupWindow {
	WebDriver driver;
	
	public PopupWindow(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		
	}
	
	public void setUserName() throws IOException
	{
		 String parentWinHandle = driver.getWindowHandle();
		 Properties obj = new Properties();
		 FileInputStream objfile = new FileInputStream(System.getProperty("user.dir")+"\\environment.properties");
		 obj.load(objfile);
		 driver.findElement(By.linkText(obj.getProperty("LaunchPopupWindow"))).click();
		 //launchPopupWindow.click();
   	     driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
   	     Set<String> winHandles = driver.getWindowHandles();

   	     Iterator<String> i1=winHandles.iterator();
   	     while(i1.hasNext()){
   		   String ChildWindow=i1.next();
            if(!parentWinHandle.equalsIgnoreCase(ChildWindow))
            {
              driver.switchTo().window(ChildWindow);
             // System.out.println(driver.getTitle());  
              driver.findElement(By.id(obj.getProperty("Name"))).sendKeys("xyz");
              driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
              driver.findElement(By.id(obj.getProperty("Submit"))).click();
       	      //submitBtn.click();
       	      driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            }
          }
    	 driver.switchTo().window(parentWinHandle);
	}
	
}
