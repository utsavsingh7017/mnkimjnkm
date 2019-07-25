package com.qa.keywords;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



public class TrainingObstacleCourse {
	WebDriver driver;
	
	 
	public TrainingObstacleCourse(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		
	}
	
	public void onBasicUrlClick() throws IOException
	{
		Properties obj = new Properties();
		FileInputStream objfile = new FileInputStream(System.getProperty("user.dir")+"\\environment.properties");
		obj.load(objfile);
		driver.findElement(By.linkText(obj.getProperty("BasicCourse"))).click();
		// basicCourse.click();
		
	}

	public String getTrainingObstacleCourseTitle()
	{
		return driver.getTitle();
	}

}
