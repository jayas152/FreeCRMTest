	package com.crm.qa.pages;
	
	import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;
	
	import com.crm.qa.base.TestBase;
	
	public class HomePage extends TestBase{
	
		public HomePage() throws IOException {
			PageFactory.initElements(driver, this);
		}
	
	 @FindBy(xpath = "//td[contains(text(),'User: Jayas Desai')]")
	 WebElement userNameLable;
	
	 @FindBy(xpath = "//a[contains(text(),'Contacts')]")// = "//a[contains(text(),'Contacts')]")
	 WebElement contactslink;
	 
	 @FindBy(xpath = "//a[contains(text(),'Deals')]")
	 WebElement dealslink;
	 
	 @FindBy(xpath = "//a[contains(text(),'Tasks')]")
	 WebElement taskslink;
	 
	 @FindBy(xpath = "//a[contains(text(),'New Contact')]")
	 WebElement newContactList;
	 
	 public String verifingTitle() {
		 return driver.getTitle();
	 }
	 
	 public boolean verifingUserName() {
		return userNameLable.isDisplayed();
	 }
	 public  ContactsPage clickOnContacts() throws IOException {
		 contactslink.click();
		 return new ContactsPage();
	 }
	 
	public  DealsPage clickondeals() throws IOException {
		 dealslink.click();
		 return new DealsPage();
	 }
	public  TaskPage clickonTasks() throws IOException {
		 taskslink.click();
		 return new TaskPage();
	 }
	
	public void clickOnNewContact() {
		Actions action = new Actions(driver);
		action.moveToElement(contactslink).build().perform();
		newContactList.click();	
	}
}
