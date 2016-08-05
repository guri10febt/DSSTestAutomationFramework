package com.java.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.java.pageobject.AccessorieslistingPageObject;
import com.java.pageobject.HomepagePageObject;

public class Execution {
	private WebDriver driver;
	private HomepagePageObject home;
	private AccessorieslistingPageObject Accessories;
	@BeforeTest
	public void config(){
		System.setProperty("webdriver.chrome.driver","C:\\AllJarFiles\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://store.demoqa.com/");
		home = new HomepagePageObject(driver);
	}
	
	@Test
	public void testcase1(){
		
		Accessories=(AccessorieslistingPageObject) home.selectProduct("accessories");
		System.out.println("Out of accessories");
		Accessories.AddToCart("Apple TV");
		
	}
	@AfterTest
	public void CleanUp(){
		//driver.quit();
	}
}
