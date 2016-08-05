package com.java.pageobject;

import org.openqa.selenium.WebDriver;

public class HomepagePageObject extends TopNav{
	private WebDriver driver;
	
	public HomepagePageObject(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}

	
	
}
