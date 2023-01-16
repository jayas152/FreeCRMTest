package com.crm.qa.tests;

import org.testng.annotations.Test;
import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import org.testng.annotations.BeforeMethod;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class LoginPageTest extends TestBase{
  
	LoginPage lp;
	HomePage hp;

  
  public LoginPageTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

@BeforeMethod
  public void setUp() throws IOException {
	openBrowser();
	lp = new LoginPage();
	
  }

  @AfterMethod
  public void closeBrowser() {
	  driver.quit();
  }
  
  @Test (priority = 1)
  public void verifingtitle() {
	  String expectedtitle = "Free CRM - CRM software for customer relationship management, sales, and support.";
	  String actualtitle = lp.verifingTitle();
	  Assert.assertEquals(actualtitle, expectedtitle);
  }
  
  @Test (priority = 2)
  public void verifingLogo() {
	  boolean logo = lp.crmLOGO();
	  Assert.assertTrue(logo, "Logo is verified");
	  
  }
  
  @Test (priority = 3)
  public void login() throws InterruptedException, IOException {
	 
	hp = lp.login(prop.getProperty("username"), prop.getProperty("password"));

  }
}
