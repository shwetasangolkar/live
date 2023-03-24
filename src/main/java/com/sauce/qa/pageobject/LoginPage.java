package com.sauce.qa.pageobject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sauce.qa.action.ActionDriver;
import com.sauce.qa.base.Base;

public class LoginPage extends Base {
	
	
	ActionDriver actionDriver=new ActionDriver();
	
	Logger logger =LogManager.getLogger(LoginPage.class);

	@FindBy(xpath="//input[@id='user-name']")
	WebElement userName;
	
	@FindBy(xpath="//input[@id='password']")
	WebElement password;
	
	@FindBy(xpath="//input[@id='login-button']")
	WebElement loginbtn;
	
    @FindBy(xpath="//div/span[@class='title']")
	WebElement productTitle;
    
    @FindBy(xpath="//div[contains(text(),'Swag Labs')]")
   	WebElement logintitle;
	
	public LoginPage()
	{
		PageFactory.initElements(driver,this);
	}
	
	public String validateLoginPageWithValidData(String username,String pass)
	{
		actionDriver.sleepThread(2000);
		actionDriver.type(userName,username);
		logger.info("Successfully Enter the user name");
		actionDriver.type(password,pass);
		logger.info("Successfully Enter the password");
		actionDriver.sleepThread(2000);
		actionDriver.click(driver,loginbtn);
		String title=driver.findElement(By.xpath("//div/span[@class='title']")).getText().toString();
		return title;
		
	}
	
	  public String validateLoginPageTitle(String username,String pass)
	  {
	
		  return driver.getTitle();
		  		  
	  }
	public String validateLoginPageWithInValidData(String username,String pass)
	{
		actionDriver.sleepThread(2000);
		actionDriver.type(userName,username);
		actionDriver.sleepThread(2000);
		actionDriver.type(password,pass);
		actionDriver.sleepThread(2000);
		actionDriver.click(driver,loginbtn);
		actionDriver.sleepThread(2000);
		String error=driver.findElement(By.xpath("//div[@class='error-message-container error']")).getText().toString();
		return error;		
	}
}
	












	

