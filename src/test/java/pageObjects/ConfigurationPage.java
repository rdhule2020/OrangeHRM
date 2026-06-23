package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ConfigurationPage extends BasePage{

	public ConfigurationPage(WebDriver driver) {
		super(driver);

	}
	
	
	//Section : Configuraton

	@FindBy(xpath="//span[@class='oxd-topbar-body-nav-tab-item']")WebElement drp_configuration;
	@FindBy(xpath="//li//a[@role='menuitem']")List<WebElement> Options;
	@FindBy(xpath="//*[text()='Optional Fields']")WebElement Optional_Fields;
	@FindBy(xpath="//*[text()='Custom Fields']")WebElement Custom_Fields;
	@FindBy(xpath="//*[text()='Data Import']")WebElement DataImport;
	@FindBy(xpath="//*[text()='Reporting Methods']")WebElement Reporting_Module;
	@FindBy(xpath="//*[text()='Termination Reasons']")WebElement Termination_Reasons;
	
	public void Select_OptionalFields()
	{
		drp_configuration.click();
		wait.until(ExpectedConditions.elementToBeClickable(Optional_Fields));
		Actions action = new Actions(driver);
		action.moveToElement(Optional_Fields).click().perform();
	}
	
	public void Select_CustomFields()
	{
		drp_configuration.click();
		wait.until(ExpectedConditions.elementToBeClickable(Custom_Fields));
		Actions action = new Actions(driver);
		action.moveToElement(Custom_Fields).click().perform();
	}
	
	public void Select_DataImport()
	{
		drp_configuration.click();
		wait.until(ExpectedConditions.elementToBeClickable(DataImport));
		Actions action = new Actions(driver);
		action.moveToElement(DataImport).click().perform();
	}
	
	public void Select_ReportingModule()
	{
		drp_configuration.click();
		wait.until(ExpectedConditions.elementToBeClickable(Reporting_Module));
		Actions action = new Actions(driver);
		action.moveToElement(Reporting_Module).click().perform();
	}
	
	public void Select_Termination_Reasons()
	{
		drp_configuration.click();
		wait.until(ExpectedConditions.elementToBeClickable(Termination_Reasons));
		Actions action = new Actions(driver);
		action.moveToElement(Termination_Reasons).click().perform();
	}
	
	
}
