package com.Utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtility {

	WebDriver driver;

	public ScreenshotUtility(WebDriver driver) {
		this.driver = driver;
	}

	public void Screenshot(String Scenarioname) {

		TakesScreenshot ts = (TakesScreenshot) driver;
		try {
			File sourcefile = ts.getScreenshotAs(OutputType.FILE);
			String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
			File targetfile = new File("Screenshots/" + Scenarioname + "_" + timestamp + ".png");
			sourcefile.renameTo(targetfile);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
