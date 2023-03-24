package com.sauce.qa.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sauce.qa.action.ActionDriver;
import com.sauce.qa.base.Base;

public class AboutPage extends Base {
	
	ActionDriver actionDriver=new ActionDriver();

	@FindBy(xpath="//button[@id='react-burger-menu-btn']")
	WebElement drawer;
	
	@FindBy(xpath="//a[@id='about_sidebar_link']")
	WebElement about;
	
	@FindBy(xpath="//div//p[contains(text(),'The world relies on your code. Test on thousands of device, browser, and OS configurations – anywhere, any time.')]")
	WebElement title;
	
	public AboutPage() 
	{
		PageFactory.initElements(driver, this);
	}
	
	public String validateClickOnAboutPage()
	{   
		actionDriver.click(driver, drawer);
		actionDriver.sleepThread(2000);
		actionDriver.click(driver, about);
		actionDriver.sleepThread(2000);
	    String title=driver.findElement(By.xpath("//div//p[contains(text(),'The world relies on your code. Test on thousands of device, browser, and OS configurations – anywhere, any time.')]")).getText().toString();
		driver.navigate().back();
		actionDriver.sleepThread(2000);
	    driver.navigate().refresh();
		return title;
	}
	
		
	}
	
	
	
	


