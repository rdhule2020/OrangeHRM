package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CustomFieldsPage extends BasePage {

	public CustomFieldsPage(WebDriver driver) {
		super(driver);

	}

	// Main Page
	@FindBy(xpath = "//*[text()=' Add ']")
	WebElement btn_Add;
//	@FindBy(xpath="")WebElement ele;
//	@FindBy(xpath="")WebElement ele;
//	@FindBy(xpath="")WebElement ele;

	// Methods

	public void Click_Add() {
		btn_Add.click();
	}

//----------------------------------------------------------------------------------------------------------

	// Add Custom Fields Page
	@FindBy(xpath = "//label[text()='Field Name']//following::*//input[@class='oxd-input oxd-input--active']")
	WebElement txt_FieldName;
	@FindBy(xpath = "//label[text()='Screen']//following::*[4]")
	WebElement drp_Screen;
	@FindBy(xpath = "//label[text()='Screen']//following::*//div[@role='listbox']//div[@role='option']")
	List<WebElement> screen_Options;
	
	
	@FindBy(xpath = "//*[text()='Type']/following::*[4]")
	WebElement drp_Type;
	@FindBy(xpath = "//label[text()='Type']//following::*//div[@role='listbox']//div[@role='option']")
	List<WebElement> Type_Options;
	@FindBy(xpath = "//button[text()=' Cancel ']")
	WebElement btn_Cancel;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement btn_Save;

	// Screen Options
	public String option1 = "-- Select --";
	public String option2 = "Personal Details";
	public String option3 = "Contact Details";
	public String option4 = "Emergency Contacts";
	public String option5 = "Dependents";
	public String option6 = "Immigration";
	public String option7 = "Job";
	public String option8 = "Salary";
	public String option9 = "Tax Exemptions";
	public String option10 = "Report-to";
	public String option11 = "Qualifications";
	public String option12 = "Memberships";

	// Type options
	public String TypeOption1 = "";
	public String TypeOption2 = "Text or Number";
	public String TypeOption3 = "Drop Down";
	// Method Area

	public void send_FieldName(String value) {
		txt_FieldName.sendKeys(value);
	}

	public void select_ScreenOption(String value) {
		drp_Screen.click();

		for (WebElement option : screen_Options) {
			if (option.getText().equalsIgnoreCase(value))
				option.click();
		}
	}

	public void select_Typeoption(String option) {
		drp_Type.click();
		wait.until(ExpectedConditions.visibilityOfAllElements(Type_Options));
		for (WebElement Type_option : Type_Options) {
			if (Type_option.getText().equalsIgnoreCase(option)) {
				  wait.until(ExpectedConditions.elementToBeClickable(Type_option)).click();
				Type_option.click();
			}
		}
	}

	public void click_Cancel() {
		btn_Cancel.click();
	}

	public void click_Save() {
		btn_Save.click();
	}
}
