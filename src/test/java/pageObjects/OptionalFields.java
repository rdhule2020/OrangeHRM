package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class OptionalFields extends BasePage {

	public OptionalFields(WebDriver driver) {
		super(driver);
		
	}

	@FindBy(xpath="//h6[text()='Show Deprecated Fields']//following::*[7]")WebElement toggle_NickName;
	@FindBy(xpath="//h6[text()='Country Specific Information']//following::*[7]")WebElement toggle_SSN;
	@FindBy(xpath="//h6[text()='Country Specific Information']//following::*[13]")WebElement toggle_SIN;
	@FindBy(xpath="//h6[text()='Country Specific Information']//following::*[19]")WebElement toggle_USTax;
	@FindBy(xpath="//h6[text()='Country Specific Information']//following::*[22]")WebElement btn_Save;
	
	
	public void Click_toggle_NickName()
	{
		wait.until(ExpectedConditions.elementToBeClickable(toggle_NickName));
		toggle_NickName.click();
	}
	
	public void Click_toggle_SSN()
	{
		wait.until(ExpectedConditions.elementToBeClickable(toggle_SSN));
		toggle_SSN.click();
	}
	public void Click_toggle_SIN()
	{
		wait.until(ExpectedConditions.elementToBeClickable(toggle_SIN));
		toggle_SIN.click();
	}
	public void Click_toggle_USTax()
	{
		wait.until(ExpectedConditions.elementToBeClickable(toggle_USTax));
		toggle_USTax.click();
	}
	public void Click_btn_Save()
	{
		wait.until(ExpectedConditions.elementToBeClickable(btn_Save));
		btn_Save.click();
	}
}
