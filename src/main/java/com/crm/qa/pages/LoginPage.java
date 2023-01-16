package com.crm.qa.pages;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.base.TestBase;
import com.crm.qa.utli.TestUtil;

public class LoginPage extends TestBase {

	
	//Page Factory
	@FindBy(name = "username")
	public WebElement username;
	
	@FindBy(name = "password")
	public WebElement password;
	
	@FindBy(xpath = "//input[@type='submit']")
	public WebElement loginBtn;
	
	@FindBy(xpath = "//a[text()='Sign Up']")
	public WebElement singUp;
	
	@FindBy(xpath = "//a[@class='navbar-brand']//img[@class='img-responsive']")
	public WebElement crmproImg;
	
	public LoginPage() throws IOException {
		//Initializing the page Objects.
		PageFactory.initElements(driver, this);
		
	}
	
	public String verifingTitle() { //String because it is title.
		return driver.getTitle();
	}
	
	public boolean crmLOGO() { // boolean, because picture is there or not
		return crmproImg.isDisplayed();
	}
	
	public HomePage login(String a , String b) throws InterruptedException, IOException {
		WebDriverWait wait = new WebDriverWait(driver, TestUtil.ecplictiWait);
		
		username.sendKeys(a);
		password.sendKeys(b);
		
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("preloader"))); //Extra wait time
			
		loginBtn.click();
		
		return new HomePage(); // What it is returning while clicking on login button, we have to put that as return method.
	}


}
