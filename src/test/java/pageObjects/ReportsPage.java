package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class ReportsPage extends BasePage{
	public ReportsPage(WebDriver driver)
	{
		super(driver);
	}
	
	
	
	//WebElements
	@FindBy(xpath="//*[text()=' Add ']") WebElement btn_add;
	@FindBy(xpath="//input[@placeholder='Type here ...']")WebElement txt_reportName;
	@FindBy(xpath="//label[text()='Selection Criteria']//following::*[1]")WebElement drp_SelectionCriteria;
	@FindBy(xpath="//label[text()='Selection Criteria']//following::*[10]")WebElement btn_plus_Criteria;
//add hidden elements here 
	@FindBy(xpath="//i[@class='oxd-icon bi-trash-fill']/following::*[6]")WebElement icon_delete ;
	@FindBy(xpath="//div[@class='oxd-select-text oxd-select-text--active']//child::*[@operator='[object Object]']//following::*[1]")WebElement drp_PayGradeList;

	//	@FindBy(xpath="")WebElement ;
	@FindBy(xpath="//label[text()='Include']//following::*[1]")WebElement drp_include;
	@FindBy(xpath="//label[text()='Select Display Field Group']//following::*[1]")WebElement drp_fieldGroup;
	@FindBy(xpath="//label[text()='Select Display Field']//following::*[1]")WebElement drp_field;
	@FindBy(xpath="//label[text()='Select Display Field']//following::*[10]")WebElement btn_plus_field;
	//add hidden elements here  
//	@FindBy(xpath="")WebElement ;
	@FindBy(xpath="//button[text()=' Cancel ']")WebElement btn_cancel;
	@FindBy(xpath="//button[@type='submit']")WebElement btn_save;
	
	public void click_Add()
	{
		btn_add.click();
	}
	
	public void set_ReportName(String value)
	{
		txt_reportName.sendKeys(value);
	}
	
	// handle dropdown using loop statement
	// code area
	public void testSelectPayGrade() throws InterruptedException {
		drp_SelectionCriteria.click();
	// Select particular option using Action class
       Actions actions = new Actions(driver);
      Thread.sleep(1000);
       actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
	}
	public void click_CriteriaPlus(){
		btn_plus_Criteria.click();
	}
	public void delete_option_PayGrade()
	{
		icon_delete.click();
	}
	public void selectGrade()
	{
		drp_PayGradeList.click();
		Actions actions = new Actions(driver);
	       actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
	}
	
	
	// Include Dropdown
	
	public void Click_IncludeSelection()
	{
		drp_include.click();
		Actions actions = new Actions(driver);
	       actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
	}
	
	public void select_FieldGroup_personnel()
	{
		drp_fieldGroup.click();
		Actions actions = new Actions(driver);
	       actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
	}
	
	public void select_FieldGroup()
	{
		drp_fieldGroup.click();
		Actions actions = new Actions(driver);
	       actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
	}
	
	public void select_field()
	{
		drp_field.click();
		Actions actions = new Actions(driver);
	       actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
	}
	
	public void click_btn_plus_field()
	{
		btn_plus_field.click();
	}
	public void click_Save()
	{
		btn_save.click();
	}
	
	
	
	
}
