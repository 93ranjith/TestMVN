package com.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.google.common.annotations.VisibleForTesting;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestFacebook extends BaseClasses {
	
@Test
		private void lanuchUrl() {
			// TODO Auto-generated method stub

		
		launchBrowser();
		maxWindow();
		toPassUrl("https://www.facebook.com/");
	
		driver.findElement(By.id("email")).sendKeys("kumaresan@123");
		driver.findElement(By.id("pass")).sendKeys("4526653236");
		driver.findElement(By.name("login")).click();
		closeWindow();

		}

}
