package com.java.pageobject;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutInfoPageObject {
	private WebDriver driver;
	public CheckoutInfoPageObject(WebDriver driver) {
		this.driver=driver;
	}
// Calculate Shipping
	public CheckoutFinalPageObject enterAddressInfo() throws AWTException, InterruptedException{
		WebElement Country = driver.findElement(By.id("current_country")); 
		List<WebElement> CountryList = Country.findElements(By.tagName("option"));
		for(WebElement element: CountryList ){
			if(element.getText().equalsIgnoreCase("india")){
				element.click();
			}
		}
		
		driver.findElement(By.name("collected_data[15]")).sendKeys("maharashtra");
		driver.findElement(By.name("wpsc_submit_zipcode")).click();
		
		
		//Your billing details
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", (driver.findElement(By.id("wpsc_checkout_form_9"))));
		Thread.sleep(500); 
		driver.findElement(By.id("wpsc_checkout_form_9")).sendKeys("avinashkumarpujari@gmail.com");
		driver.findElement(By.id("wpsc_checkout_form_2")).sendKeys("avinashkumar");
		driver.findElement(By.id("wpsc_checkout_form_3")).sendKeys("pujari");
		driver.findElement(By.id("wpsc_checkout_form_4")).sendKeys("Kalewadi");
		driver.findElement(By.id("wpsc_checkout_form_5")).sendKeys("Pune");
		driver.findElement(By.id("wpsc_checkout_form_6")).sendKeys("maharashtra");
		driver.findElement(By.id("wpsc_checkout_form_8")).sendKeys("411017");
		
		WebElement billingCountry = driver.findElement(By.id("wpsc_checkout_form_7")); 
		List<WebElement> billingCountryList = billingCountry.findElements(By.tagName("option"));
		for(WebElement element: billingCountryList ){
			if(element.getText().equalsIgnoreCase("india")){
				element.click();
			}
		}
		driver.findElement(By.id("wpsc_checkout_form_18")).sendKeys("8888888888");
		
		//Your shipping details
		driver.findElement(By.id("wpsc_checkout_form_11")).sendKeys("avinashkumar");
		driver.findElement(By.id("wpsc_checkout_form_12")).sendKeys("pujari");
		driver.findElement(By.id("wpsc_checkout_form_13")).sendKeys("Kalewadi");
		driver.findElement(By.id("wpsc_checkout_form_14")).sendKeys("Pune");
		driver.findElement(By.id("wpsc_checkout_form_15")).sendKeys("maharashtra");
		driver.findElement(By.id("wpsc_checkout_form_17")).sendKeys("411017");
	
		/*WebElement shippingSountry = driver.findElement(By.id("wpsc_checkout_form_16")); 
		List<WebElement> shippingCountryList = shippingSountry.findElements(By.tagName("option"));
		for(WebElement element: shippingCountryList ){
			if(element.getText().equalsIgnoreCase("india")){
				element.click();
			}
		}*/
		
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", (driver.findElement(By.xpath("//*[@id='wpsc_shopping_cart_container']/form/div[4]/div/div/span/input"))));
		Thread.sleep(12000);
		driver.findElement(By.xpath("//*[@id='wpsc_shopping_cart_container']/form/div[4]/div/div/span/input")).click();
		
		return new CheckoutFinalPageObject(driver);
		
	}
}
