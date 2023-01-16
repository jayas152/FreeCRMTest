package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm.qa.utli.TestUtil;
import com.crm.qa.utli.WebEventListener;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	public  static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;

	

	public TestBase() throws IOException {
//		FileInputStream fi = new FileInputStream("/Users/jayas/Desktop/Selenium_WorkSpace/FreeCRMTest/src/main/java/com/crm/qa/config/config.properties");
//		prop.load(fi);
		try {
			prop = new Properties();
			FileInputStream fi = new FileInputStream("/Users/jayas/Desktop/Selenium_WorkSpace/FreeCRMTest/src/main/java/com/crm/qa/config/config.properties");
			prop.load(fi);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void openBrowser() throws IOException {
		
		String browser = prop.getProperty("browser");
		if(browser.equals("FireFox")) {
			System.setProperty("webdriver.gecko.driver", "/Users/jayas/Desktop/SeleniumJars//geckodriver");
			driver = new FirefoxDriver();
			}
			else if(browser.equals("chrome")) {
				System.setProperty("webdriver.chrome.driver", "/Users/jayas/Desktop/SeleniumJars/chromedriver");
				driver = new ChromeDriver();
			}
		
		
		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.pageLoad, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);	

	//	WebDriverWait expliWait = new WebDriverWait(driver, Duration.ofSeconds(15));
	//	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		
		driver.get(prop.getProperty("url"));
		
	}
	
	
	
}
