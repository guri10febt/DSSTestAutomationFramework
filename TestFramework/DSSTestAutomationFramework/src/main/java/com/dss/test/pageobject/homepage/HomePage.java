package com.dss.test.pageobject.homepage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.dss.test.core.utilities.Utility;

public class HomePage {

	private WebDriver driver;

	public HomePage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, HomePageObject.class);
	}


	private HomePage clickOnLoginTopNav(){

		Utility.clickOnElement(HomePageObject.btn_LoginTopNav);
		return this;
	}

	private HomePage enterEmailId(){
		Utility.enterData("guri10febf@gmail.com", HomePageObject.textBox_EmailId);
		return this;
	}

	private HomePage enterPassword(){
		Utility.enterData("tribune1", HomePageObject.textBox_Password);
		return this;
	}

	private HomePage clicklogin(){
		Utility.clickOnElement(HomePageObject.btn_Login);
		return this;
	}
	private HomePage clickCancel(){
		Utility.clickOnElement(HomePageObject.btn_Cancel);
		return this;

	}

}
