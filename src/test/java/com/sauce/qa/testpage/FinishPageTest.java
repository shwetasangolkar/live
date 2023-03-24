package com.sauce.qa.testpage;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sauce.qa.base.Base;
import com.sauce.qa.pageobject.CheckOutPage;
import com.sauce.qa.pageobject.FinishPage;
import com.sauce.qa.pageobject.LoginPage;
import com.sauce.qa.pageobject.ProductPage;
import com.sauce.qa.utility.ImageGenrater;

public class FinishPageTest extends Base

{
	FinishPage finishpage;
	CheckOutPage checkoutpage;
	ProductPage productpage;
	LoginPage loginpage;
	

	public FinishPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginpage = new LoginPage();
		loginpage.validateLoginPageWithValidData("standard_user", "secret_sauce");
		productpage = new ProductPage();
		productpage.validateAddToCart();
		checkoutpage = new CheckOutPage();
		checkoutpage.validateCheckOutPage("shweta", "sangolkar", "1234567");
		finishpage = new FinishPage();
	}

	@Test
	public void validateClickOnFinishPage() {
		String expected = "Checkout: Complete!";
		Assert.assertEquals(finishpage.validateClickOnFinishPage(), expected);

	}

	@AfterMethod
	public void tearDown(ITestResult result) {
		if (ITestResult.FAILURE == result.getStatus()) {
			ImageGenrater.imageClicker(driver, result.getName());
		}
		driver.quit();
	}

}