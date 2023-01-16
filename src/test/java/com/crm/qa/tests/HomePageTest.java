package com.crm.qa.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.TaskPage;
import com.crm.qa.utli.TestUtil;

public class HomePageTest extends TestBase{
	
	LoginPage lp;
	HomePage hp;
	ContactsPage cp;
	TestUtil tu;
	TaskPage tp;
	DealsPage dp;
	
	public HomePageTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	@BeforeMethod
	public void getiingtoHomepage() throws IOException, InterruptedException {
		openBrowser();
		tu = new TestUtil();
		lp = new LoginPage();
		hp = lp.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}
	
	@Test(priority = 1)
	public void homePageTitle() {
		String title = hp.verifingTitle();
		
		Assert.assertEquals(title, "CRMPRO");
	}
	@Test(priority = 2)
	public void verifingUsername() {
		tu.switchToFrame();
		boolean uname = hp.verifingUserName();
		Assert.assertTrue(uname);
	}
	
	@Test(priority = 3)
	public void clickOnContacts() throws IOException {
		tu.switchToFrame();
		 cp = hp.clickOnContacts();
	}
	
	@Test(priority = 4)
	public void clickOnTaskss() throws IOException {
		tu.switchToFrame();
		 tp = hp.clickonTasks();
	}
	
	@Test(priority = 5)
	public void clickOnDeals() throws IOException {
		tu.switchToFrame();
		 dp = hp.clickondeals();
	}
	
	
}
