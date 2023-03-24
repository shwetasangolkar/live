package com.sauce.qa.pageobject;



import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sauce.qa.action.ActionDriver;
import com.sauce.qa.base.Base;

public class FinishPage extends Base
{
	
	ActionDriver actionDriver=new ActionDriver();
	
	@FindBy(xpath="//div/span[text()='Checkout: Complete!']")
	WebElement checkoutcomplete;
	
	@FindBy(xpath="//button[@id='finish']")
	WebElement finish;
		
	public FinishPage()
	{
		
		PageFactory.initElements(driver,this);
	}
	
	public String validateClickOnFinishPage()
	{    
//		actionDriver.scrollByVisibilityOfElement(driver, finish);
		actionDriver.sleepThread(5000);
		actionDriver.jsClick(driver, finish);
		actionDriver.sleepThread(2000);
		String title=driver.findElement(By.xpath("//div/span[text()='Checkout: Complete!']")).getText().toString();
		return title;
	}
	

//	@Test
//	public void validatelogout() 
//	
//	{
//		productpage.validatelogout();
//		
			
	}
	
	
	


