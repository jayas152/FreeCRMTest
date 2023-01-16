package com.crm.qa.tests;

import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.TaskPage;
import com.crm.qa.utli.TestUtil;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class ContactsPageTest extends TestBase {
	
	
	LoginPage lp;
	HomePage hp;
	ContactsPage cp;
	TestUtil tu;
	TaskPage tp;
	DealsPage dp;
	
	String sheetName = "Contacts";
	
	public ContactsPageTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

 
  @BeforeMethod
  public void beforeMethod() throws IOException, InterruptedException {
	  
	  openBrowser();
	  lp = new LoginPage();
	  hp = new HomePage();
	  tu = new TestUtil();
	  cp = new ContactsPage();
	  hp = lp.login(prop.getProperty("username"), prop.getProperty("password"));
	  tu.switchToFrame();
	  hp.clickOnContacts();
	  
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }
  
  @DataProvider
  public Object[][] getCRMdata() {
	Object data[][] =  TestUtil.getTestData("Sheet1");
	return data;
  }
  
  @Test(priority = 1)
  public void verifingContactLable() {
	Assert.assertTrue(cp.verifingContactspage(), "Contacts not Available"); 
	  
  }
  
  @Test (priority = 2, dataProvider="getCRMdata")
  public void creatNewContact(String title , String fName, String lName, String nName, String comName, String countryName) {
	  hp.clickOnNewContact();
	  cp.creatNewContact(title,fName,lName,nName,comName,countryName);
  }
}
