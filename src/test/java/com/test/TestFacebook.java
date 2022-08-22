package com.test;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.google.common.annotations.VisibleForTesting;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestFacebook extends BaseClasses {
	@BeforeClass
	public void exquting_testcase() {
		System.out.println("today exequting start====>");

	}
	
@Test
public void lanuchUrl() throws IOException {
			
		launchBrowser();
		maxWindow();
		toPassUrl("https://www.facebook.com/");
	
		WebElement email = driver.findElement(By.id("email"));
		email.sendKeys("kumaresan@123");
	
		driver.findElement(By.id("pass")).sendKeys("4526653236");
		driver.findElement(By.name("login")).click();
		
		TakesScreenshot TS = (TakesScreenshot)driver;
		File src = TS.getScreenshotAs(OutputType.FILE);
		File disr =new File("C:\\Users\\kumar\\OneDrive\\Desktop\\testmvn\\TestMVN\\Screenshot\\facebook.png");
		FileUtils.copyFile(src, disr);
		closeWindow();

		}
@AfterClass
public void exequting_Testcase_done() throws AWTException {
	System.out.println("testcase exequting Done==>"); 
 
}
}
