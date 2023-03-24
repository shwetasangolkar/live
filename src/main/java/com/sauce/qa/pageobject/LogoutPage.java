package com.sauce.qa.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sauce.qa.action.ActionDriver;
import com.sauce.qa.base.Base;

public class LogoutPage extends Base {
	
	ActionDriver actionDriver=new ActionDriver();
	
	@FindBy(xpath="//button[@id='react-burger-menu-btn']")
	WebElement drawer;
	
	@FindBy(xpath="//a[@id='logout_sidebar_link']")
	WebElement logout;
	
	
	
	public LogoutPage()
	{
		
		PageFactory.initElements(driver,this);
	}
	
	public void validatelogoutPage()
	{	
		
		actionDriver.click(driver, drawer);
		actionDriver.sleepThread(2000);
		actionDriver.click(driver, logout);
		String title=driver.findElement(By.xpath("//h4[contains(text(),'Password for all users:')]")).getText().toString();
		
	}

}
