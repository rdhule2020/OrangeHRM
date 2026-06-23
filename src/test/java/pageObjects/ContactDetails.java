package pageObjects;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ContactDetails extends BasePage{

	public ContactDetails(WebDriver driver) {
		super(driver);
		
	}

	@FindBy(xpath="//label[text()='Street 1']//following::input[1]")WebElement txt_street1;
	@FindBy(xpath="//label[text()='Street 1']//following::input[2]")WebElement txt_street2;
	@FindBy(xpath="//label[text()='Street 1']//following::input[3]")WebElement txt_city;
	@FindBy(xpath="//label[text()='Street 1']//following::input[4]")WebElement txt_State;
	@FindBy(xpath="//label[text()='Street 1']//following::input[5]")WebElement txt_postalCode;
	@FindBy(xpath="//div[@class='oxd-select-text oxd-select-text--active']")WebElement drp_Country;
	@FindBy(xpath="//label[text()='Street 1']//following::input[6]")WebElement txt_Home;
	@FindBy(xpath="//label[text()='Street 1']//following::input[7]")WebElement txt_Mobile;
	@FindBy(xpath="//label[text()='Street 1']//following::input[8]")WebElement txt_work;
	@FindBy(xpath="//label[text()='Street 1']//following::input[9]")WebElement workEmail;
	@FindBy(xpath="//label[text()='Street 1']//following::input[10]")WebElement otherEmail;
	@FindBy(xpath="//*[text()=' * Required']//following::*[1]")WebElement btn_save;
	public String country= "India";
	
	
	//Methods
	public void set_street1(String value)
	{
		wait.until(ExpectedConditions.elementToBeClickable(txt_street1));
		txt_street1.sendKeys(value);
	}
	public void set_street2(String value)
	{
		wait.until(ExpectedConditions.elementToBeClickable(txt_street2));
		txt_street2.sendKeys(value);
	}
	public void set_City(String value)
	{
		wait.until(ExpectedConditions.elementToBeClickable(txt_city));
		txt_city.sendKeys(value);
	}
	public void set_State(String value)
	{

		wait.until(ExpectedConditions.elementToBeClickable(txt_State));
		txt_State.sendKeys(value);
	}
	public void set_PostalCode(String value)
	{

		wait.until(ExpectedConditions.elementToBeClickable(txt_postalCode));
		txt_postalCode.sendKeys(value);
	}
	public void select_Country(String value)
	{
		//drp_Country.click();
		Actions action = new Actions(driver);
		action.sendKeys(drp_Country, value).build().perform();
	}
	public void set_Home(String value)
	{

		wait.until(ExpectedConditions.elementToBeClickable(txt_Home));
		txt_Home.sendKeys(value);
	}
	public void set_Mobile(String value)
	{

		wait.until(ExpectedConditions.elementToBeClickable(txt_Mobile));
		txt_Mobile.sendKeys(value);
	}
	public void set_work(String value)
	{

		wait.until(ExpectedConditions.elementToBeClickable(txt_work));
		txt_work.sendKeys(value);
	}
	public void set_workEmail(String value)
	{

		wait.until(ExpectedConditions.elementToBeClickable(workEmail));
		workEmail.sendKeys(value);
	}
	public void set_otherEmail(String value)
	{

		wait.until(ExpectedConditions.elementToBeClickable(otherEmail));
		otherEmail.sendKeys(value);
	}
	public void Click_Save()
	{

		wait.until(ExpectedConditions.elementToBeClickable(btn_save));
		btn_save.click();
	}
	
	
	
	
	
	
	
	
	
	//Attachment section
	@FindBy(xpath="//h6[text()='Attachments']/following::*[2]")WebElement btn_add;
	@FindBy(xpath="//div[text()='Browse']")WebElement btn_browse;
	@FindBy(xpath="//textarea[@placeholder='Type comment here']")WebElement txt_comment;
	@FindBy(xpath="//p[@class='oxd-text oxd-text--p orangehrm-form-hint']//following::*[32]")WebElement btn_cancel;
	@FindBy(xpath="//p[@class='oxd-text oxd-text--p orangehrm-form-hint']//following::*[33]")WebElement btn_save_Attachment;
	public String filepath = "C:\\Users\\RAHUL\\eclipse-workspace\\PractiseSet1\\OrangeHRM\\TestData\\Summary+Non+Primitive+Types+.pdf";
	
	public void click_Add()
	{
		wait.until(ExpectedConditions.elementToBeClickable(btn_add));
		btn_add.click();
	}
	
	public void click_Browse()
	{
		wait.until(ExpectedConditions.elementToBeClickable(btn_browse));
		btn_browse.click();
	}
	
	//upload
	public void uploadAttachment() throws AWTException, InterruptedException
	{
		uploadFileWithRobot(filepath);
	}
	
	
	
	
	public void enter_Comment(String value)
	{
		wait.until(ExpectedConditions.elementToBeClickable(txt_comment));
		txt_comment.sendKeys(value);
	}
	
	public void click_Cancel()
	{
		wait.until(ExpectedConditions.elementToBeClickable(btn_cancel));
		btn_cancel.click();
	}
	
	public void click_Save_Attachment()
	{
		wait.until(ExpectedConditions.elementToBeClickable(btn_save_Attachment));
		btn_save_Attachment.click();
	}
}
