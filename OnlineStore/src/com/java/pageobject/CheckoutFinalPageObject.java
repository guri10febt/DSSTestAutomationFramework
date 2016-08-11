package com.java.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutFinalPageObject {
	WebDriver driver;
	public CheckoutFinalPageObject(WebDriver driver) {
		this.driver=driver;
	}

	public boolean calculateamount(){
		
		boolean flag=false;
		WebElement tableOnCheckoutFinal = driver.findElement(By.tagName("tbody"));
		List<WebElement> rowsOnTable = tableOnCheckoutFinal.findElements(By.tagName("tr"));
		for(WebElement eachRow :rowsOnTable){
			List<WebElement> allColsInRow = eachRow.findElements(By.tagName("td"));
			
			String perProductValue = (allColsInRow.get(1).getText()).substring(1, allColsInRow.get(1).getText().length());
			String quantity = (allColsInRow.get(2).getText());
			String TotalAmount =(allColsInRow.get(3).getText()).substring(1, allColsInRow.get(3).getText().length());

float perProductValue1 = Float.valueOf(perProductValue);
float quantity1 = Float.valueOf(quantity);
float TotalAmount1 =  Float.valueOf(TotalAmount);


if((perProductValue1*quantity1)==TotalAmount1){
	flag=true;
}
			}
		return flag;
	}

}

