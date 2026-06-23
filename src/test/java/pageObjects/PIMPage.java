package pageObjects;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PIMPage extends BasePage{
	
	
	public Random randomnumber;
	
	public String randomNumber()
	{
		String randomNumber = RandomStringUtils.randomNumeric(10);
		return randomNumber;
	}
	

	//------------------------------------------------------------------------------------------------ 

	
	 public PIMPage(WebDriver driver)
	{
		super(driver);
	}
	 
	 @FindBy(xpath="//span[text()='Configuration ']")WebElement lnk_Configuration;
//------------------------------------------------------------------------------------------------ 

	 @FindBy(xpath="//a[text()='Employee List']")WebElement lnk_employeeList;
//------------------------------------------------------------------------------------------------ 

		// Section -Add Employee:
		// WebElements
		
		@FindBy(xpath = "//a[text()='Add Employee']")
		WebElement lnk_addEmployee;
		
		@FindBy(xpath = "//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message']")
		List<WebElement> error_msgs;
		@FindBy(xpath = "//input[@name='firstName']")
		WebElement txt_FirstName;
		@FindBy(xpath = "//input[@name='middleName']")
		WebElement txt_MiddleName;
		@FindBy(xpath = "//input[@name='lastName']")
		WebElement txt_LastName;
		@FindBy(xpath="//*[text()='Employee Id']/following::*//input[@class='oxd-input oxd-input--active']")WebElement txt_EmployeeId;
		@FindBy(xpath = "//span[@class='oxd-switch-input oxd-switch-input--active --label-right']")
		WebElement ToggleSwitch;
		@FindBy(xpath = "//*[text()='Username']//following::*[2]")
		WebElement txt_username;
		@FindBy(xpath = "//*[@class='oxd-radio-input oxd-radio-input--active --label-right oxd-radio-input']")
		WebElement radio_Enabled;
		// @FindBy(xpath="")WebElement radio_desabled;

		@FindBy(xpath = "//*[text()='Username']//following::*[28]//input[@type='password']")
		WebElement txt_password;
		@FindBy(xpath = "//*[text()='Confirm Password']//following::*[2]")
		WebElement txt_Confirmpassword;
		@FindBy(xpath = "//*[text()=' Cancel ']")
		WebElement btn_Cancel;
		@FindBy(xpath = "//button[@type='submit']")
		WebElement btn_submit;

		// Methods

		public List<String> get_error_Msgs() {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
					"//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message']")));
			return error_msgs.stream().map(WebElement::getText).map(String::trim).collect(Collectors.toList());
		}

		public void click_AddEmployee() {
			wait.until(ExpectedConditions.elementToBeClickable(lnk_addEmployee));
			lnk_addEmployee.click();
		}

		public void send_FirstName(String value) {
			wait.until(ExpectedConditions.elementToBeClickable(txt_FirstName));
			txt_FirstName.sendKeys(value);
			
		}

		public void send_MiddleName(String value) {
			wait.until(ExpectedConditions.elementToBeClickable(txt_MiddleName));
			txt_MiddleName.sendKeys(value);
			
		}

		public void send_LastName(String value) {
			wait.until(ExpectedConditions.elementToBeClickable(txt_LastName));
			txt_LastName.sendKeys(value);
			
		}
		public void send_EmpId(String value)
		{
			clear(txt_EmployeeId);
			wait.until(ExpectedConditions.elementToBeClickable(txt_EmployeeId));
			txt_EmployeeId.sendKeys(value);
		}
		public void Click_ToggleSwitch() {
			wait.until(ExpectedConditions.elementToBeClickable(ToggleSwitch));
			ToggleSwitch.click();
		}
		
		
		public void send_Username(String value) {
			txt_username.sendKeys(value+"$"+randomnumber);
		}

	 	public void send_Password(String value) {
			wait.until(ExpectedConditions.elementToBeClickable(txt_password));
			txt_password.sendKeys(value);
		}

		public void send_ConfirmPassword(String value) {
			wait.until(ExpectedConditions.elementToBeClickable(txt_Confirmpassword));
			txt_Confirmpassword.sendKeys(value);
		}

		public void click_Cancel() {
			btn_Cancel.click();
		}

		public void click_Submit() {
			btn_submit.click();
		}
//------------------------------------------------------------------------------------------------ 
	 @FindBy(xpath="//a[text()='Reports']")WebElement lnk_reports;
	 
	 public void click_Reports() {
		 lnk_reports.click();
		}
	 //@FindBy(xpath="")WebElement ;
	 //@FindBy(xpath="")WebElement ;
	 
	 
	 
	//------------------------------------------------------------------------------------------------ 
	 
	 
	
	 
}
