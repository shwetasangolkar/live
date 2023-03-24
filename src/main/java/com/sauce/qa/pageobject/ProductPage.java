package com.sauce.qa.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.sauce.qa.action.ActionDriver;
import com.sauce.qa.base.Base;

public class ProductPage extends Base {

	
	ActionDriver actionDriver=new ActionDriver();
	
	@FindBy(xpath="//button[@id='add-to-cart-sauce-labs-backpack']")
	WebElement addToCart  ;
	
	@FindBy(xpath="//a[@class='shopping_cart_link']")
	WebElement cartLink;
	
	@FindBy(xpath="//button[@id='checkout']")
	WebElement Checkout ;
	
	@FindBy(xpath="//span[contains(text(),'Checkout: Your Information')]")
	WebElement title;
	
	public ProductPage()
	{
		PageFactory.initElements(driver,this);
		
	}
	
	public String validateAddToCart() 
	{
		actionDriver.click(driver,addToCart);
		actionDriver.sleepThread(2000);
		actionDriver.click(driver, cartLink);
		actionDriver.sleepThread(2000);
		actionDriver.click(driver, Checkout);		
		String title=driver.findElement(By.xpath("//span[contains(text(),'Checkout: Your Information')]")).getText().toString();
		return title;
		
	}}

	


	

