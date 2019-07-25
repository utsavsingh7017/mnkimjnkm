package com.qa.test;

import org.testng.annotations.Test;
import com.qa.keywords.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterTest;

public class TestMethods {
	  String token="";
	  WebDriver driver;
	  GridGate gridGate;
	  PopupWindow pWindow;
	  GenerateToken gToken;
	  DragAround dragAround;
	  PrintCookie printCookie;
	  FrameDungeon frameDungeon;
	  UtilityServer utilityServer;
	  CookieHandling cookieHandling;
	  TrainingObstacleCourse trainingObstacleCourse;
	  
	 @BeforeTest
	 public void setBaseURL() throws IOException
	  {
		 Properties obj = new Properties();
		 FileInputStream objfile = new FileInputStream(System.getProperty("user.dir")+"\\environment.properties");
		 obj.load(objfile);
		 System.setProperty(obj.getProperty("DriverName"),obj.getProperty("DriverPath"));
	     driver=new ChromeDriver();
	     driver.get(obj.getProperty("BaseUrl"));
	  }
	 
	 @Test
	 public void verifyBaseUrl() throws InterruptedException, IOException
	 {    
		  utilityServer=new UtilityServer(driver);
		  utilityServer.onBaseUrlClick();  
		  String expectedTitle = "Welcome - T.A.T.O.C";
		  String actualTitle = utilityServer.getUtilityServerTitle();
		  AssertJUnit.assertEquals(actualTitle, expectedTitle); 
	 }
	 
	@Test
	public void verifyBasicUrl() throws InterruptedException, IOException
	 {
		 trainingObstacleCourse=new TrainingObstacleCourse(driver);
		 trainingObstacleCourse.onBasicUrlClick();
		 String expectedTitle = "Grid Gate - Basic Course - T.A.T.O.C";
	     String actualTitle = trainingObstacleCourse.getTrainingObstacleCourseTitle();
	     AssertJUnit.assertEquals(actualTitle, expectedTitle); 
	 }
	 
	@Test
	public void verifyColourGreenBoxClick() throws InterruptedException, IOException
	 {
		 gridGate=new GridGate(driver);
		 gridGate.onGreenBoxClick();
		 String expectedTitle = "Frame Dungeon - Basic Course - T.A.T.O.C";
	     String actualTitle =gridGate.getGridGateTitle();
	     AssertJUnit.assertEquals(actualTitle, expectedTitle); 
	     driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		 
	 }
	 
	@Test
	public void verifyColourMatching() throws InterruptedException, IOException
	 {
		 frameDungeon=new FrameDungeon(driver); 
		 String expectedTitle = "Frame Dungeon - Basic Course - T.A.T.O.C";
		 String actualTitle = frameDungeon.getFrameDungeonTitle();
		 AssertJUnit.assertEquals(actualTitle, expectedTitle);
		 frameDungeon.onColourMatching();
	 }
	 
	 @Test
	 public void verifyDragAndDrop() throws InterruptedException, IOException
	 {
	   	 dragAround=new DragAround(driver);
	     String expectedTitle = "Drag - Basic Course - T.A.T.O.C";
		 String actualTitle = dragAround.getDragAroundTitle();
		 AssertJUnit.assertEquals(actualTitle, expectedTitle); 
	     dragAround.dragAndDrop();
	 }
	 
	@Test
	public void verifyPopupWindow() throws InterruptedException, IOException
	 {   
   		 pWindow=new PopupWindow(driver);
   	     pWindow.setUserName();
	 }
	 
	@Test
	public void verifyProceedLink() throws InterruptedException
	 {
		 driver.findElement(By.linkText("Proceed")).click();
		 cookieHandling=new CookieHandling(driver);
		 String expectedTitle = "Cookie Handling - Basic Course - T.A.T.O.C";
	     String actualTitle = cookieHandling.getCookiePageTitle();
	     AssertJUnit.assertEquals(actualTitle, expectedTitle);  
		 cookieHandling.getCookie();
	 }
	 
	@Test
	public void verifyTokenGeneration() throws InterruptedException, IOException
	 {
	    gToken=new GenerateToken(driver);
	    token=gToken.generateToken(); 	 							
	 }
	 
	@Test(priority=1)
	public void verifyCreateCookie() throws InterruptedException
	 {  
   	    Cookie cookie = new Cookie("Token",token);
   	    driver.manage().addCookie(cookie);
	 }
	
	 @Test(priority=2)
     public void verifyCookiePrinting() throws InterruptedException, IOException
	  { 
   	    printCookie=new PrintCookie(driver); 
   	    printCookie.printCookie();
   	    String expectedTitle = "End - T.A.T.O.C";
        String actualTitle = driver.getTitle();
        AssertJUnit.assertEquals(actualTitle, expectedTitle);
	  }
	 
	 @AfterTest
	 public void AfterTest() throws InterruptedException
	  { 
		 //Thread.sleep(1000);
		 driver.close();
		 driver.quit();
	  }
		

}
