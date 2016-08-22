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
	
	
	

	
	//Add single product cart
	public String AddToCart(String args){
		String ProductPrice = null;
		WebElement List = driver.findElement(By.xpath("//*[@id='default_products_page_container']/div"));
		List<WebElement> ProductList= List.findElements(By.xpath("//*[contains(@class, 'default_product_display product_view_')]"));
		for(WebElement productSelected: ProductList){
			if(productSelected.findElement(By.className("wpsc_product_title")).getText().equalsIgnoreCase(args)){
				ProductPrice=productSelected.findElement(By.cssSelector(".currentprice.pricedisplay")).getText();
			    System.out.println(ProductPrice);
			    productSelected.findElement(By.name("Buy")).click();
			}
			
		}
		return ProductPrice.substring(1, ProductPrice.length());
	}
	
	
	/*public void AddToCart(String args){
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
			
		}*/

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
