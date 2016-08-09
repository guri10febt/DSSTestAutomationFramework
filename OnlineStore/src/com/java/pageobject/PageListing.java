package com.java.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class PageListing extends TopNav{

	WebDriver driver;
	public PageListing(WebDriver driver) {
		super(driver);
		this.driver=driver;
		
	}
	public void AddToCart(String args){
		    int count=0;
			WebElement List = driver.findElement(By.xpath("//*[@id='default_products_page_container']"));
			List<WebElement> productslist = List.findElements(By.className("prodtitle"));
			for(WebElement element:productslist){
				
				if(element.getText().equalsIgnoreCase(args)){
				List <WebElement> li = driver.findElements(By.name("Buy"));
				li.get(count).click();;
					
				}
				count++;	
			}
			
		}

	public CheckoutYourCartPageObject ClickGoToCheckoutButton() throws InterruptedException{
		Thread.sleep(4000);
		driver.findElement(By.linkText("Go to Checkout")).click();
		return new CheckoutYourCartPageObject(driver);
		
	}
	
	public void ClickContinueShopping() throws InterruptedException{
		Thread.sleep(4000);
		driver.findElement(By.linkText("Continue Shopping")).click();
		
	}


}
