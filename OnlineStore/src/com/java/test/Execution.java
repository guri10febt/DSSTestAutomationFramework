package com.java.test;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.java.pageobject.AccessorieslistingPageObject;
import com.java.pageobject.CheckoutFinalPageObject;
import com.java.pageobject.CheckoutInfoPageObject;
import com.java.pageobject.CheckoutYourCartPageObject;
import com.java.pageobject.HomepagePageObject;

import junit.framework.Assert;

public class Execution {
	private WebDriver driver;
	private HomepagePageObject home;
	private AccessorieslistingPageObject Accessories;
	private CheckoutYourCartPageObject  CheckoutYourCart;
	private CheckoutInfoPageObject CheckoutInfo;
	private CheckoutFinalPageObject Checkoutfinal;
	@BeforeTest
	public void config(){
		System.setProperty("webdriver.chrome.driver","C:\\AllJarFiles\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://store.demoqa.com/");
		home = new HomepagePageObject(driver);
	}
	
	@Test
	public void testcase1() throws InterruptedException, AWTException{
		
		boolean flag;
		Accessories=(AccessorieslistingPageObject) home.selectProduct("accessories");
		System.out.println("Out of accessories");
		String ProductPrice=Accessories.AddToCart("Apple TV");
		System.out.println(ProductPrice);
		CheckoutYourCart=Accessories.ClickGoToCheckoutButton();
		CheckoutInfo=CheckoutYourCart.CheckoutYourCartPageContinue();
		Checkoutfinal=CheckoutInfo.enterAddressInfo();
		flag=Checkoutfinal.calculateamount();
		Assert.assertTrue(flag);
	}
	@AfterTest
	public void CleanUp(){
		//driver.quit();
	}
}
