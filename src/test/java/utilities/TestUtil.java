package utilities;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.apache.commons.io.FileUtils;

import base.TestBase;

public class TestUtil extends TestBase{

	public static String screenshotPath;
	public static String screenshotName;
	public static void captureScreenshot() throws IOException {
		
		File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String screenshotName = "error.jpg";
		FileUtils.copyFile(screenshotFile, new File(System.getProperty("user.dir")+"\\target\\surefire-reports\\html\\"+screenshotName));
	}
}
