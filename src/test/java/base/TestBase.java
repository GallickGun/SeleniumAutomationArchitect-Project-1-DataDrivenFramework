package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.time.Duration;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import utilities.ExcelReader;


public class TestBase {
	
	
	/*
	 * Initialize WebDriver
	 * Initialize Properties
	 * Initialize ExtentReports
	 * Initialize Logs
	 * Initialize DB
	 * Initialize Excel
	 * Initialize Mail
	 * Initialize Jenkins
	 */

	
	public static WebDriver driver;
	public static Properties config = new Properties();
	public static Properties OR  = new Properties();
	public static FileInputStream fis;
	public static Logger log = Logger.getLogger("TestBase.java");
	public static ExcelReader excel = new ExcelReader(System.getProperty("user.dir")+"\\src\\test\\resources\\excel\\testData.xlsx");
	public static WebDriverWait wait;
	
	@BeforeSuite
	public void setUp() throws FileNotFoundException {
		
		if(driver==null) {
			
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\Config.properties");
			try {
				config.load(fis);
				log.debug("Config file loaded");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\ObjectRepositories.properties");
			try {
				OR.load(fis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(config.getProperty("browser").equals("firefox")) {
				
				System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\executables\\geckodriver.exe");
				driver = new FirefoxDriver();
				
			}else if(config.getProperty("browser").equals("chrome")) {
				
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\executables\\chromedriver.exe");
				driver = new ChromeDriver();
				log.debug("Chrome launched");
				
			}else if(config.getProperty("browser").equals("edge")) {
				
				System.setProperty("webdriver.edge.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\executables\\msedgedriver.exe");
				driver = new EdgeDriver();
			}
			
			driver.get(config.getProperty("testsiteurl"));
			log.debug("Navigated to: "+config.getProperty("testsiteurl"));
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		}
		
	}
	
	public boolean isElementPresent(By by) {
		
		try {
			
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			// TODO: handle exception
			return false;
		}
	}
	
	@AfterSuite
	public void tearDown() {
		
		driver.quit();
		log.debug("Test execution completed");
	}
}
