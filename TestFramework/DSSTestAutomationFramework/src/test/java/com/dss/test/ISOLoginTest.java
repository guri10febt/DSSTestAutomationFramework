package com.dss.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.dss.test.pageobject.homepage.HomePage;

public class ISOLoginTest {
	
	private HomePage home;
	private WebDriver driver;
	
	@BeforeTest
	public void setup(){
		
		System.setProperty("webdriver.gecko.driver", "/Users/username/Downloads/geckodriver");
		WebDriver driver = new FirefoxDriver();
		driver = new FirefoxDriver();
		driver.get("nguxbeta:nguxtr!b@ngux.chicagotribune.stage.tribdev.com/");
		driver.manage().window().maximize();
		
		home =new HomePage(driver);
	}

	@Test
	public void ISOlogin(){
		home.isISOLoginSuccess("dsstribune11@gmail.com","tribune1");
		
	}
}
