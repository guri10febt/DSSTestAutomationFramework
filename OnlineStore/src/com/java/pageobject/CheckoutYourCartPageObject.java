package com.java.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutYourCartPageObject {
	private WebDriver driver;

	public CheckoutYourCartPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public CheckoutInfoPageObject CheckoutYourCartPageContinue() {
		driver.findElement(By.xpath("//*[@id='checkout_page_container']/div[1]/a/span")).click();
		return new CheckoutInfoPageObject(driver);
	}
// update product
	public void updateQuantity(String ProductName, String Count) throws InterruptedException {

		WebElement ElementTable = driver.findElement(By.tagName("tbody"));
		List<WebElement> products = ElementTable.findElements(By.tagName("tr"));

		for (WebElement row : products) {
			List<WebElement> product = row.findElements(By.tagName("td"));
			if (product.size() != 0) {
				if (product.get(1).getText().equalsIgnoreCase(ProductName)) {
					Thread.sleep(3000);
					product.get(2).findElement(By.name("quantity")).clear();
					product.get(2).findElement(By.name("quantity")).sendKeys(Count);
					Thread.sleep(3000);
					product.get(2).findElement(By.name("submit")).click();
					break;
				}
			}
		}
	}

	// remove product
	public void removeProduct(String ProductName) throws InterruptedException {

		WebElement ElementTable = driver.findElement(By.tagName("tbody"));
		List<WebElement> products = ElementTable.findElements(By.tagName("tr"));

		for (WebElement row : products) {
			List<WebElement> product = row.findElements(By.tagName("td"));
			if (product.size() != 0) {
				if (product.get(1).getText().equalsIgnoreCase(ProductName)) {
					Thread.sleep(3000);
					product.get(5).findElement(By.name("submit")).click();
				}
			}
		}
	}
	
	
	public boolean calculateYourCart(String Product, String PerProductValue, String quantity ) throws InterruptedException{
		String perProductCost = null; 
		String TotalProductcost = null;
		boolean flag=false;
		WebElement ElementTable = driver.findElement(By.tagName("tbody"));
		List<WebElement> products = ElementTable.findElements(By.tagName("tr"));

		for (WebElement row : products) {
			List<WebElement> product = row.findElements(By.tagName("td"));
			if (product.size() != 0) {
				if (product.get(1).getText().equalsIgnoreCase(Product)) {
					Thread.sleep(3000);
					perProductCost=	product.get(3).findElement(By.className("pricedisplay")).getText();
					TotalProductcost=	product.get(4).getText();
					System.out.println("inside YourChart-------->"+perProductCost+"         "+TotalProductcost );
				}
			}
		}
		perProductCost=perProductCost.substring(1, perProductCost.length());
		TotalProductcost=TotalProductcost.substring(1, TotalProductcost.length());

		
			System.out.println("Expected Per Product value"+PerProductValue);
			float ExpectedQuantity = Float.parseFloat(quantity);
			float Expectedperproduct=Float.parseFloat(PerProductValue);
			float Expectedtotalamount = ExpectedQuantity*Expectedperproduct;
			float ActualQuantity = Float.parseFloat(perProductCost);
			float Actualtotalamount =Float.parseFloat(TotalProductcost);

			System.out.println("--------------------------------------------------------");			
			
			System.out.println(ExpectedQuantity);
			System.out.println(Expectedperproduct);
			System.out.println(Expectedtotalamount);
			System.out.println(ActualQuantity);
			System.out.println(Actualtotalamount);
			
			System.out.println("--------------------------------------------------------");
			
			
		
		return flag;
	}

}
