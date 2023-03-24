package com.sauce.qa.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sauce.qa.action.ActionDriver;
import com.sauce.qa.base.Base;

public class CheckOutPage extends Base {
	
	ActionDriver actionDriver=new ActionDriver();
		
	@FindBy(xpath="//input[@id='first-name']")
	WebElement FirstName  ;
	
	@FindBy(xpath="//input[@id='last-name']")
	WebElement LastName ;
	
	@FindBy(xpath="//input[@id='postal-code']")
	WebElement ZipCode ;
	
	@FindBy(xpath="//input[@id='continue']")
	WebElement continuebtn;
			
	@FindBy(xpath="//div/span[text()='Checkout: Overview']")
	WebElement CheckoutOverview ;
	
	
	
	public CheckOutPage()
	{
		PageFactory.initElements(driver,this);
		
	}
	
	public String validateCheckOutPage(String firstname,String lastname,String zipcode)
	
	{
		
		actionDriver.type(FirstName ,firstname);
		actionDriver.sleepThread(2000);
		actionDriver.type(LastName,lastname);
		actionDriver.sleepThread(2000);
		actionDriver.type(ZipCode,zipcode);
		actionDriver.click(driver, continuebtn);
		actionDriver.sleepThread(2000);
		
		
		String title=driver.findElement(By.xpath("//div/span[text()='Checkout: Overview']")).getText().toString();
		return title;
	}
	
		
		
	}


