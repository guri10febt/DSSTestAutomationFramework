package com.java.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutYourCartPageObject {
	private WebDriver driver;

	public CheckoutYourCartPageObject(WebDriver driver) {
		this.driver=driver;
	}

	public CheckoutInfoPageObject CheckoutYourCartPageContinue(){
		driver.findElement(By.xpath(".//*[@id='checkout_page_container']/div[1]/a/span")).click();
		return new CheckoutInfoPageObject(driver);
	}
}
