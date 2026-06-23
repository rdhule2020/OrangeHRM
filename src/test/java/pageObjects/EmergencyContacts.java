package pageObjects;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class EmergencyContacts extends BasePage{
	
	public EmergencyContacts(WebDriver driver)
	{
		super(driver);
	}

	//Assigned Emergency Contacts
	@FindBy(xpath="//input[@class='oxd-input oxd-input--active oxd-input--error']")List<WebElement> errors;
	
	@FindBy(xpath="//div/h6[text()='Assigned Emergency Contacts']//parent::*//button")WebElement add_contacts;
	@FindBy(xpath="//label[text()='Name']//following::*[2]")WebElement txt_btn;
	@FindBy(xpath="//label[text()='Name']//following::*[8]") WebElement txt_Relationship;
	@FindBy(xpath="//label[text()='Name']//following::*[16]")WebElement txt_homeTelephone ;
	@FindBy(xpath="//label[text()='Name']//following::*[22]")WebElement txt_mobile;
	@FindBy(xpath="//label[text()='Name']//following::*[28]")WebElement txt_work_telephone;
	@FindBy(xpath="//label[text()='Name']//following::*[31]")WebElement btn_cancel_A;
	@FindBy(xpath="//label[text()='Name']//following::*[32]")WebElement btn_save_A;
	
	public List<String> getErrorMessages()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='oxd-input oxd-input--active oxd-input--error']")));
		return	errors.stream().map(WebElement::getText).map(String::trim).collect(Collectors.toList());
		
	}
	
	public void click_add_contacts()
	{
		add_contacts.click();
	}
	public void set_Name(String value)
	{
		txt_btn.sendKeys(value);
	}
	
	public void set_Relationship(String value)
	{
		txt_Relationship.sendKeys(value);
	}
	public void set_HomeTelephone(String value)
	{
		txt_homeTelephone.sendKeys(value);
	}
	public void set_Mobile(String value)
	{
		txt_mobile.sendKeys(value);
	}
	public void set_WorkTelephone(String value)
	{
		txt_work_telephone.sendKeys(value);
	}

	public void click_cancel_A()
	{
		btn_cancel_A.click();
	}

	public void click_Save_A()
	{
		btn_save_A.click();
	}

//---------------------------------------------------------------------------------------------------------	
	
	//Attachments
	@FindBy(xpath = "//div/h6[text()='Assigned Emergency Contacts']//following::*//button")WebElement add_attachment ;
/*
	@FindBy(xpath="")WebElement ;
	@FindBy(xpath="")WebElement ;
	@FindBy(xpath="")WebElement ;
	@FindBy(xpath="")WebElement ;
	@FindBy(xpath="")WebElement ;
	@FindBy(xpath="")WebElement ;
	
*/	
	

	public void click_add_attachment()
	{
		add_attachment.click();
	}
	
}
