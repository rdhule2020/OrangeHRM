package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MyInfo extends BasePage{

	public MyInfo(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//a[@class='orangehrm-tabs-item --active']")WebElement personalDetails; 
	//@FindBy(xpath="//div[@role='tablist']//child::*[2]")WebElement contactDetails;
	
	@FindBy(xpath="//a[normalize-space()='Contact Details']")WebElement cd;
	
	@FindBy(xpath="//a[normalize-space()='Emergency Contacts']")WebElement emergencyDetails;
	//Methods
	public void click_personalDetails()
	{
	
		personalDetails.click();
	}
	
	public void click_contactDetails()
	{	
		wait.until(ExpectedConditions.elementToBeClickable(cd));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", cd);
		cd.click();
	}
	
	public void click_EmergencyDetails()
	{
		wait.until(ExpectedConditions.elementToBeClickable(emergencyDetails));
		emergencyDetails.click();
	}
}
