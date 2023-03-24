package com.sauce.qa.pageobject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class LogingFacebook {
	
	Logger logger =LogManager.getLogger(LogingFacebook.class);
	
	@Test
	public void testcase1()
	{
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("incognito");
		WebDriver driver = new ChromeDriver(options);
		logger.info("Browser Open");
		driver.get("https://www.facebook.com");
		logger.info("Url Open");
	}

}
