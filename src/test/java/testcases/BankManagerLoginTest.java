package testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import base.TestBase;

public class BankManagerLoginTest extends TestBase {
	
	@Test
	public void loginAsBankManager() throws InterruptedException {
		
		System.setProperty("org.uncommons.reportng.escape-output", "false");
		log.debug("Inside BankManagerLoginTest");
		driver.findElement(By.cssSelector(OR.getProperty("btn_BankManagerLogin"))).click();
		Assert.assertTrue(isElementPresent(By.cssSelector(OR.getProperty("btn_AddCustomer"))), "Login was not successful");
		log.debug("Login was successful");
		Reporter.log("Login was successful");
		Reporter.log("<a target=\"_blank\"href=\"C:\\Users\\Heyma\\Downloads\\43a273a650cf4e9ebf1219151ab4ccf8.jpg\">Screenshot</a>");
		Reporter.log("<br>");
		Reporter.log("<a target=\"_blank\"href=\"C:\\Users\\Heyma\\Downloads\\43a273a650cf4e9ebf1219151ab4ccf8.jpg\"><img src=\"C:\\Users\\Heyma\\Downloads\\43a273a650cf4e9ebf1219151ab4ccf8.jpg\" height=200 width=200></img></a>");
	}
}
