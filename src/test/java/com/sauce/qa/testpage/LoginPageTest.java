package com.sauce.qa.testpage;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sauce.qa.base.Base;
import com.sauce.qa.pageobject.LoginPage;
import com.sauce.qa.utility.ImageGenrater;

public class LoginPageTest extends Base {

	LoginPage loginpage;

	public LoginPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginpage = new LoginPage();
	}

	@Test
	public void validateLoginPageWithValidDataTest() {

		String expected = "Products";
		Assert.assertEquals(loginpage.validateLoginPageWithValidData("standard_user", "secret_sauce"), expected);

	}

	@Test
	public void validateLoginPageWithInValidDataTest() {

		String expected = "Epic sadface: Username and password do not match any user in this service";
		Assert.assertEquals(loginpage.validateLoginPageWithInValidData("shweta", "123"), expected);

	}

	@Test
	public void validateLoginPageTitleTest() {
		String expected = "Swag Labs";
		Assert.assertEquals(loginpage.validateLoginPageTitle("shweta", "123"), expected);

	}

	@AfterMethod
	public void tearDown(ITestResult result) {
		if (ITestResult.FAILURE == result.getStatus()) {
			ImageGenrater.imageClicker(driver, result.getName());
		}
		driver.quit();
	}
}
