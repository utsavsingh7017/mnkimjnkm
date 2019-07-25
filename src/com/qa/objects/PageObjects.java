package com.qa.objects;

import org.openqa.selenium.By;

public class PageObjects {
	
	    public By proceed =By.linkText("Proceed");

	    public By baseUrl =By.cssSelector("a[href=\"/tatoc\"]");

	    public By basicUrl =By.cssSelector("a[href=\"/tatoc/basic\"]");

	    public By greenBox = By.cssSelector("div.greenbox");
	    
	    public By box =By.id("answer");
	    
	    public By repaintLink=By.linkText("Repaint Box 2");
	    
	    public By dragBox=By.id("dragbox");
	    
	    public By dropBox=By.id("dropbox");
	    
	    public By launchPopupWindow=By.linkText("Launch Popup Window");
	    
	    public By name=By.id("name");
	    
	    public By submitBtn=By.id("submit");
	    
	    public By generateToken=By.linkText("Generate Token");
	    
	    public By tokenBtn=By.id("token");
	    
	    
}
