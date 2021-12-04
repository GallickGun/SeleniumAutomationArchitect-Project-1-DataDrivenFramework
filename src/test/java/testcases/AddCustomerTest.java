package testcases;

import java.time.Duration;
import java.util.Hashtable;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.TestBase;

public class AddCustomerTest extends TestBase {
	
	
	@Test(dataProvider="getData")
	public void AddCustomer(String firstName, String lastName, String postCode, String alertText) throws InterruptedException {
		
		log.debug("Inside AddCustomerTest");
		driver.findElement(By.cssSelector(OR.getProperty("btn_AddCustomer"))).click();
		driver.findElement(By.cssSelector(OR.getProperty("firstname"))).sendKeys(firstName);
		log.debug("First Name filled");
		driver.findElement(By.cssSelector(OR.getProperty("lastname"))).sendKeys(lastName);
		log.debug("Last Name filled");
		driver.findElement(By.cssSelector(OR.getProperty("postcode"))).sendKeys(postCode);
		log.debug("Post Code filled");
		driver.findElement(By.cssSelector(OR.getProperty("btn_Add"))).click();
		log.debug("New Customer added");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	
		Alert alert = driver.switchTo().alert(); // switch to alert

		String alertMessage= driver.switchTo().alert().getText();
		Assert.assertTrue(alert.getText().contains(alertText));
		alert.accept();
		log.debug("Alert accepted");
		
	}

	@DataProvider
	public Object [] [] getData(){
		
		
		String sheetName = "AddCustomerTest";
		int rows = excel.getRowCount(sheetName);
		int cols = excel.getColumnCount(sheetName);

		Object[][] data = new Object[rows-1][cols];
		


		for (int rowNum = 2; rowNum <= rows; rowNum++) { // 2
			
			for (int colNum = 0; colNum < cols; colNum++) {

				// data[0][0]
				data[rowNum -2] [colNum] = excel.getCellData(sheetName, colNum, rowNum);
			}

		}

		return data;

	}
		
}
