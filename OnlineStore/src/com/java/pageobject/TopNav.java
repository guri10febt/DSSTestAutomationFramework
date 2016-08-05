package com.java.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public abstract class TopNav {
	private WebDriver driver;
	private PageListing pageL;
	
	public TopNav(WebDriver driver){
		this.driver=driver;
	} 
	
	public PageListing selectProduct(String ProductName){
		
		
		WebElement ProductCatagory=driver.findElement(By.xpath("//*[@id='menu-item-33']/a"));
		Actions hoverProductCatagory = new Actions(driver);
		hoverProductCatagory.moveToElement(ProductCatagory).perform();
				
		WebElement Catogary = driver.findElement(By.className("sub-menu")); 
		List<WebElement> CatogaryList= Catogary.findElements(By.tagName("li"));
		
		for(WebElement Element: CatogaryList){
						
			if(Element.getText().equalsIgnoreCase(ProductName))
			{
				
				Element.click();
				break;
			}
		}
				
		switch(ProductName.toLowerCase()){
				case "accessories": 
					pageL = new AccessorieslistingPageObject(driver);
					System.out.println("Accessories inside");
					break;
					
				case "ipads":
					
					break;
					
				case "iphones":
					
					break;
					
				case "ipods":
					
					break;
					
				case "macbooks":
					
					break;
					
				default : 
					System.out.println("Invalid input");	
					
				}
				
				
			
		
		System.out.println("Before returning");
		return pageL;
		
	}
	
	

}
