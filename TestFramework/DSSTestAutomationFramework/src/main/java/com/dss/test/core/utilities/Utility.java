package com.dss.test.core.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Utility {

	public static void clickOnElement(WebElement element){
		element.click();
	}

	public static void enterData(String data, WebElement element){

		element.clear();
		element.sendKeys(data);
	} 



}
