package listeners;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import utilities.TestUtil;

public class CustomListeners implements ITestListener {

	public void onTestFailure(ITestResult arg0) {
		
		System.setProperty("org.uncommons.reportng.escape-output", "false");
		try {
			TestUtil.captureScreenshot();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Reporter.log("Login was successful");
		Reporter.log("<a target=\"_blank\"href="+TestUtil.screenshotName+">Screenshot</a>");
		Reporter.log("<br>");
		Reporter.log("<a target=\"_blank\"href="+TestUtil.screenshotName+"><img src="+TestUtil.screenshotName+" height=200 width=200></img></a>");
	}
}
