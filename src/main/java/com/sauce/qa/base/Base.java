package com.sauce.qa.base;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.sauce.qa.utility.DataUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	public static WebDriver driver;
	public static Properties prop;
	public static String properties_path="C:\\Users\\rohit\\eclipse-workspace\\SauceDemo\\src\\main\\java\\config.properties";
	public static BufferedReader reader;
	public Base()
	{
		
		
		try
		{
			reader=new BufferedReader(new FileReader(properties_path));
			prop=new Properties();
			prop.load(reader);
		}
		catch(FileNotFoundException f)
		{
			f.printStackTrace();
		}
		catch(IOException i)
		{
			i.printStackTrace();
		}}
		public void initialization()
		{
			
			String browserName=prop.getProperty("browser");
			if(browserName.equalsIgnoreCase("chrome"))
			{
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--remote-allow-origins=*");
				//System.setProperty("webdriver.chrome.driver","C:\Users\rohit\eclipse-workspace\EkviraHRMS\chromedriver.exe");
				WebDriverManager.chromedriver().setup(); 
				driver=new ChromeDriver(options);
			
			}
			else if(browserName.equalsIgnoreCase("firefox"))
			{
				System.setProperty("webdriver.gecko.driver", "");
				driver = new FirefoxDriver();
				
			}
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(DataUtility.pageLoadTime));
			driver.get(prop.getProperty("url"));
		}	
	}
	



	