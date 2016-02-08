package com.kanch.TestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

/*
 * This file helps in opening and closing browser
 * */
public class TestSuite {
	public static WebDriver driver;
	
	@BeforeSuite
	public void SetUp(){
		driver = new FirefoxDriver();
		driver.get("http://store.demoqa.com");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	@AfterSuite
	public void LogOff(){
		driver.close();
	}

}
