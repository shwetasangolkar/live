package com.sauce.qa.testpage;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sauce.qa.base.Base;
import com.sauce.qa.pageobject.LoginPage;
import com.sauce.qa.pageobject.ProductPage;
import com.sauce.qa.utility.ImageGenrater;

public class ProductPageTest extends Base {

	ProductPage productpage;
	LoginPage loginpage;

	public ProductPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginpage = new LoginPage();
		loginpage.validateLoginPageWithValidData("standard_user", "secret_sauce");
		productpage = new ProductPage();
	}

	@Test
	public void validateaddToCartTest() {

		String expected = "Checkout: Your Information";
		Assert.assertEquals(productpage.validateAddToCart(), expected);
	}
	
	@AfterMethod
	public void tearDown(ITestResult result) {
		if (ITestResult.FAILURE == result.getStatus()) {
			ImageGenrater.imageClicker(driver, result.getName());
		}
		driver.quit();
	}

//	@Test
//	public void validatelogout() 
//	
//	{
//		productpage.validatelogout();
//		

}
