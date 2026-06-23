package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver)
	{
		super(driver);
	}
	
	//WebElements
    @FindBy(xpath="//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[6]")private WebElement btn_MyInfo;
    @FindBy(xpath="//li[6]")private WebElement btn_MyInfo_6;
    @FindBy(xpath="//span[text()='PIM']") WebElement btn_PIM;
    @FindBy(xpath="//span[@class='oxd-userdropdown-tab']")WebElement drp_options;
    @FindBy(xpath="//a[text()='Logout']")WebElement logout;
	
	
	//Methods
    public void click_PIM()
	{
    	wait.until(ExpectedConditions.elementToBeClickable(btn_PIM));
    	btn_PIM.click();
		
	}
	public void click_MyInfo()
	{
		wait.until(ExpectedConditions.elementToBeClickable(btn_MyInfo_6));
		btn_MyInfo_6.click();
		
	}
	
	public void click_Logout()
	{
		wait.until(ExpectedConditions.elementToBeClickable(drp_options));
		drp_options.click();
		wait.until(ExpectedConditions.elementToBeClickable(logout));
		logout.click();
	}
}

