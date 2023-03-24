package com.sauce.qa.utility;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ImageGenrater {

	public static void imageClicker(WebDriver driver, String imagename) {
		try {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File src = ts.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src, new File("./Shweta/" + imagename + ".PNG"));
		} catch (Exception e) {
			System.out.println("Something Went Wrong------");

		}
	}
}
