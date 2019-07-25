package com.qa.keywords;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;


public class CookieHandling {

	WebDriver driver;
	public CookieHandling(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}
	
	public void getCookie()
	{
		
	     driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	public String getCookiePageTitle()
	{
		return driver.getTitle();
	}
	
}
