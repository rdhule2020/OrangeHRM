package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;



public class EmployeeReportsPage extends BasePage{

	public EmployeeReportsPage(WebDriver driver) {
		super(driver);
	}
	
	//Search Section : This section need to check 
	//@FindBy(xpath="//div[@class='oxd-autocomplete-text-input oxd-autocomplete-text-input--active']") WebElement txt_reportName;
	@FindBy(xpath="//input[@placeholder='Type for hints...']")WebElement drp_reportName;
	@FindBy(xpath="//button[text()=' Reset ']")WebElement btn_reset;
	@FindBy(xpath="//button[text()=' Search ']")WebElement btn_search;
	@FindBy(xpath = "//div[@class='oxd-table']//div[@class='oxd-table-card']//div[@class='oxd-table-cell-actions']//i[@class='oxd-table-cell-actions']")
	WebElement pencil_edit;
	@FindBy(xpath="//h6[@class='oxd-text oxd-text--h6 orangehrm-main-title']")WebElement reportTitle;
	
	
	public void search_Report()
	{
		wait.until(ExpectedConditions.visibilityOf(drp_reportName));
		drp_reportName.click();
		
		drp_reportName.sendKeys("Test");
		
		Actions action = new Actions(driver);
		
		action.sendKeys(Keys.ARROW_DOWN);
	
		action.sendKeys(Keys.SPACE).sendKeys(Keys.BACK_SPACE).sendKeys(Keys.ENTER);
	}
	
	
	public void click_reset()
	{
		wait.until(ExpectedConditions.visibilityOf(btn_reset));
		btn_reset.click();
	}
	
	public void click_Search()
	{
		wait.until(ExpectedConditions.visibilityOf(btn_search));
		btn_search.click();
	}
	
	public void EditReport()
	{
		wait.until(ExpectedConditions.visibilityOf(pencil_edit));
		pencil_edit.click();
	}
	
	public String getReportTitle()
	{
		wait.until(ExpectedConditions.visibilityOf(reportTitle));
		return reportTitle.getText();
	}
	
	
	
	
	
	//Records Found
	@FindBy(xpath="//div[@role='table']//div[@class='oxd-table-body']//div[@role='row']//button[@type='button'][3]")WebElement ViewReport1; 
	
	@FindBy(xpath = "//div[@role='table']//div[@class='oxd-table-body']//div[@role='row']//div[text()='TestReport1']")WebElement testReport1;
	@FindBy(xpath="//button[@class='oxd-button oxd-button--medium oxd-button--ghost orangehrm-button-margin']")WebElement popup_cancel;
	@FindBy(xpath="//button[@class='oxd-button oxd-button--medium oxd-button--label-danger orangehrm-button-margin']")WebElement popup_Delete;
	@FindBy(xpath = "//div[@role='table']//div[@class='oxd-table-body']//div[@role='row']//div[text()='TestReport1']//following::*[3]//i[@class='oxd-icon bi-trash']")
	WebElement delete_TestReport1;
	//Report
	@FindBy(xpath="//h6[@class='oxd-text oxd-text--h6 orangehrm-main-title']")WebElement Pagetitle;

	public boolean isExist()
	{
	 return	testReport1.isDisplayed();
	}
	
	public void delete_report()
	{
		delete_TestReport1.click();
	}
	
	public void Click_NoCancel()
	{
		popup_cancel.click();
	}
	public void click_YesDelete()
	{
		popup_Delete.click();
	}
	public void clickViewReport()
	{
		ViewReport1.click();
	}
	
	public String Gettitle()
	{
		return Pagetitle.getText();
	}


}
