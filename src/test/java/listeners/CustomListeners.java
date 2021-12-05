package listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class CustomListeners implements ITestListener {

	public void onTestFailure(ITestResult arg0) {
		
		System.setProperty("org.uncommons.reportng.escape-output", "false");
		Reporter.log("Capturing Screenshot");
		Reporter.log("Login was successful");
		Reporter.log("<a target=\"_blank\"href=\"C:\\Users\\Heyma\\Downloads\\43a273a650cf4e9ebf1219151ab4ccf8.jpg\">Screenshot</a>");
		Reporter.log("<br>");
		Reporter.log("<a target=\"_blank\"href=\"C:\\Users\\Heyma\\Downloads\\43a273a650cf4e9ebf1219151ab4ccf8.jpg\"><img src=\"C:\\Users\\Heyma\\Downloads\\43a273a650cf4e9ebf1219151ab4ccf8.jpg\" height=200 width=200></img></a>");
	}
}
