package testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.TestBase;

public class BankManagerLoginTest extends TestBase {
	
	@Test
	public void loginAsBankManager() throws InterruptedException {
		
		log.debug("Inside BankManagerLoginTest");
		driver.findElement(By.cssSelector(OR.getProperty("btn_BankManagerLogin"))).click();
		Thread.sleep(2000);
		Assert.assertTrue(isElementPresent(By.cssSelector(OR.getProperty("btn_AddCustomer"))), "Login was not successful");
		log.debug("Login was successful");
	}
}
