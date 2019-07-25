package com.qa.keywords;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class GenerateToken {

	WebDriver driver;
	 String token="";
 
	public GenerateToken(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		
	}
	
	public String generateToken() throws IOException
	{
		 
		 Properties obj = new Properties();
		 FileInputStream objfile = new FileInputStream(System.getProperty("user.dir")+"\\environment.properties");
		 obj.load(objfile);
		 driver.findElement(By.linkText(obj.getProperty("GenerateToken"))).click();
		 //generateToken.click();  
   	     token=driver.findElement(By.id(obj.getProperty("Token"))).getText();
   	     token=token.substring(7);
   	     System.out.println(token);
   	     return token;
	}
}
