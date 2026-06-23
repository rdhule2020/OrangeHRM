package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminPage extends BasePage {

	AdminPage(WebDriver driver) {
		super(driver);
	}

	// WebElements
	//Buttons
	
	@FindBy(xpath = "//button[@type='button'][@class='oxd-button oxd-button--medium oxd-button--secondary']")
	WebElement btn_Add;
	@FindBy(xpath = "//button[@type='button'][@class='oxd-button oxd-button--medium oxd-button--ghost'])")
	WebElement btn_reset;
	@FindBy(xpath = "//button[@type='submit'][@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space'])")
	WebElement btn_search;
	
	//First section -System Users
	
	
	//Add Page
}
