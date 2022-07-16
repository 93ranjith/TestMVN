package com.test;

import java.awt.AWTException;
import java.awt.Robot;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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
public void lanuchUrl() {
			
		launchBrowser();
		maxWindow();
		toPassUrl("https://www.facebook.com/");
	
		driver.findElement(By.id("email")).sendKeys("kumaresan@123");
		driver.findElement(By.id("pass")).sendKeys("4526653236");
		driver.findElement(By.name("login")).click();
		closeWindow();

		}
@AfterClass
public void exequting_Testcase_done() throws AWTException {
	System.out.println("testcase exequting Done==>");
 Robot rk =new Robot();
 
 rk.equals(driver);

 
 
}
}
