package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver)
	{
		super(driver);
		//PageFactory.initElements(driver, this);
	}
	
	//WebElements :Credentials
	
	@FindBy(xpath= "//input[@name='username']") private WebElement txt_username;
	@FindBy(xpath= "//input[@name='password']") private WebElement txt_password;
	@FindBy(xpath= "//button[@type='submit']") private WebElement btn_login;
	@FindBy(xpath= "//p[@class='oxd-text oxd-text--p oxd-alert-content-text']")private WebElement error_msg;
	
	
	//Methods
	
	public void set_Username(String value)
	{
		txt_username.sendKeys(value);
	}
	
	public void refresh()
	{
		driver.navigate().refresh();
	}
	public void set_Password(String value)
	{
		txt_password.sendKeys(value);
	}
	
	public void click_Login()
	{
		btn_login.click();
	}
	
	public String get_error_msg()
	{
		try {
		return (error_msg.getText());
		}catch(Exception e)
		{
			return(e.getMessage());
		}
	}
	
	//LoginMethod
	public void login(String username, String password)
	{
		enterText(txt_username,username );
		enterText(txt_password,password);
		clickElement(btn_login);
	}
}
