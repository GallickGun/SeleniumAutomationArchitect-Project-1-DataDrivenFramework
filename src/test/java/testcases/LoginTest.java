package testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import base.TestBase;

public class LoginTest extends TestBase {
	
	@Test
	public void loginAsBankManager() throws InterruptedException {
		
		driver.findElement(By.cssSelector(OR.getProperty("btn_BankManagerLogin"))).click();
		Thread.sleep(3000);
	}
}
