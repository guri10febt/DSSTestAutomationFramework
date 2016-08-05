package com.java.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccessorieslistingPageObject extends PageListing {
	WebDriver driver;

	public AccessorieslistingPageObject(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}

	
}
