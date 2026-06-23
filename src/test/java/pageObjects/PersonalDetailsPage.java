package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PersonalDetailsPage extends BasePage {

	public PersonalDetailsPage(WebDriver driver) {
		super(driver);
	}

	// find out xpath for all elements,
	@FindBy(xpath = "//input[@name='firstName']")
	WebElement firstName;
	@FindBy(xpath = "//input[@name='middleName']")
	WebElement middleName;
	@FindBy(xpath = "//input[@name='lastName']")
	WebElement lastName;
	// @FindBy(xpath="//label[text()='Employee Id']//following::*[2]")WebElement
	// empID;
	@FindBy(xpath = "//*[contains(text(),'Employee Id')]/following::*[1]/input")
	WebElement EmpID;
	@FindBy(xpath = "//*[contains(text(),'Other Id')]/following::*[1]//input")
	WebElement OtherID;

	@FindBy(xpath = "//label[@class='oxd-label']//following::*[15][1]")
	WebElement driverLiscNo;
	@FindBy(xpath = "//*[contains(text(),'License Expiry Date')]/following::*[1]//input")
	WebElement drp_liscExpdate;
	@FindBy(xpath = "//*[contains(text(),'Nationality')]/following::*[1]//div/div/div[2]")
	WebElement drp_nationality;
	@FindBy(xpath="//span[text()='Indian']")WebElement country;
	
	@FindBy(xpath = "//label[text()='Marital Status']//following::*[2]")
	WebElement drp_mStatus;
	@FindBy(xpath = "//label[text()='Date of Birth']//following::*//input[@placeholder='yyyy-dd-mm']")
	WebElement drp_DOB;

	@FindBy(xpath = "//*[text()='Male']")
	WebElement radio_gender;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement btn_save;

	public WebElement getFirstName() {

		wait.until(ExpectedConditions.visibilityOf(firstName));
		return firstName;
	}

	public void setFirstName(String value) {

		clear(firstName);
		firstName.sendKeys(value);

	}

	public WebElement getempID() {
		wait.until(ExpectedConditions.visibilityOf(EmpID));
		return EmpID;
	}

	public void set_empID(String value)// this.wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	{
		clear(EmpID);
		EmpID.sendKeys(value);
	}

	public void set_OtherID(String value) {
		wait.until(ExpectedConditions.visibilityOf(OtherID));
		OtherID.sendKeys(value);
	}

	public void set_ExpiryDate(String value) {
		wait.until(ExpectedConditions.visibilityOf(drp_liscExpdate));
		drp_liscExpdate.sendKeys(value);
		;
	}

	public void set_DriverLiscNO(String value) {
		wait.until(ExpectedConditions.visibilityOf(driverLiscNo));
		driverLiscNo.sendKeys(value);
	}

	public void select_Nationality() {
		drp_nationality.click(); // open dropdown
		wait.until(ExpectedConditions.elementToBeClickable(country));

		country.click();
		
//		List<WebElement> country_List = driver.findElements(By.xpath("//div[@role='listbox']//span"));
//		
//		for(WebElement country : country_List)
//		{
//			if(country.equals("Indian"))
//			{
//				country.click();
//			}
//		}
		
		
		
//		Actions action = new Actions(driver);
//		action.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
		;
	}

	public void Click_MarriageStatus() {
		drp_mStatus.click();
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
	}

	public void set_DOB(String value) {
		wait.until(ExpectedConditions.visibilityOf(drp_DOB));
		drp_DOB.sendKeys(value);
	}

	public void select_Gender() {
		wait.until(ExpectedConditions.visibilityOf(radio_gender));
		if (radio_gender.isSelected() == false) {
			radio_gender.click();
		}
	}

	public void click_Save() {
		wait.until(ExpectedConditions.visibilityOf(btn_save));
		btn_save.click();
	}
	// Generic Method
//	public  boolean isEnabled(WebElement element)
//	{
//		try {
//			return(element.isEnabled());			
//		}catch(Exception e)
//		{
//			System.out.println(e.getMessage());
//			return false;
//		}
//		
//	}

//	public void clear(WebElement element)
//	{
//		if(element.isEnabled())
//		{
//	
//		element.clear();
//		}
//	}

	public void enterPersonalDetails(String fname, String mname, String lname, String empID, String otherID,
			String DLiscNo) {
		// add all filelds and values in one method for a page and complete this method
		clear(firstName);
		clear(middleName);
		clear(lastName);
		clear(EmpID);
		clear(OtherID);
		clear(driverLiscNo);
		clear(drp_liscExpdate);

		enterText(firstName, fname);
		enterText(middleName, mname);
		enterText(lastName, lname);
		enterText(EmpID, empID);
		enterText(OtherID, otherID);
		enterText(driverLiscNo, DLiscNo);

		clickElement(btn_save);
	}

	// Custom fields

	@FindBy(xpath = "//label[text()='Blood Type']//following::*//div[@class='oxd-select-text-input']")
	WebElement drp_bloodgropup;
	@FindBy(xpath = "//label[text()='Test_Field']//following::*//input[@class='oxd-input oxd-input--active']")
	WebElement drp_testField;
	@FindBy(xpath = "//*[text()=' * Required']//following::*//button[@type='submit']")
	WebElement btn_CustomFieldsave;

	public void set_bloodGroup() {
		wait.until(ExpectedConditions.visibilityOf(drp_bloodgropup));
		drp_bloodgropup.click();
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).build().perform();
	}

	public void set_TestField() {
		wait.until(ExpectedConditions.visibilityOf(drp_testField));
		drp_testField.sendKeys("Hi");
	}

	public void click_CustomFieldsave() {
		wait.until(ExpectedConditions.visibilityOf(btn_CustomFieldsave));
		btn_CustomFieldsave.click();
	}

	
	
	//Contach details
	
	

}
