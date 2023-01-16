package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {
	
	public ContactsPage() throws IOException {
		PageFactory.initElements(driver, this);
	}
	@FindBy (xpath = "//td[contains(text(),'Contacts')]")
	WebElement verifingContact;
	
	@FindBy (id = "first_name")
	WebElement firstName;
	
	@FindBy (id = "surname")
	WebElement lastNAme;
	
	@FindBy (name = "nickname")
	WebElement nickName;
	
	@FindBy (name = "client_lookup")
	WebElement company;
	
	@FindBy (name = "country")
	WebElement country;
	
	@FindBy (xpath = "//input[@class='button' and @type='submit']")  // there are too many "type with submit"
	WebElement saveBtn;
	
	public boolean verifingContactspage() {
		return verifingContact.isDisplayed();
	}
	
	public void selectContactsByName(String name){
		driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td[@class='datalistrow']"
				+ "//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']")).click();
	}
	
	public void creatNewContact(String title , String fName, String lName, String nName, String comName, String countryName) {
		
		Select select = new Select(driver.findElement(By.name("title")));
		select.selectByVisibleText(title);
		firstName.sendKeys(fName);
		lastNAme.sendKeys(lName);
		nickName.sendKeys(nName);
		company.sendKeys(comName);
		country.sendKeys(countryName);
		saveBtn.click();
	}
	
	

}
