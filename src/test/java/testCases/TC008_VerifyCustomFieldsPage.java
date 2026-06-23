package testCases;

import org.testng.annotations.Test;

import pageObjects.ConfigurationPage;
import pageObjects.CustomFieldsPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.OptionalFields;
import pageObjects.PIMPage;
import testBase.BaseClass;

public class TC008_VerifyCustomFieldsPage extends BaseClass {
	public LoginPage l;
	public PIMPage pim;
	public HomePage h;
	public ConfigurationPage configurationPage;
	public OptionalFields optionalFields;
	
	
	@Test(priority=0)
	public void verify_AddCustomFields() throws InterruptedException
	{
		logger.info("Login to OrangeHRM");
		l =new LoginPage(driver);
		l.set_Username(p.getProperty("username"));
		l.set_Password(p.getProperty("password"));
		l.click_Login();
		logger.info("Navigate to home page");
		h = new HomePage(driver);
		h.click_PIM();
		
		logger.info("Select Custom  from configuration dropdown");
		configurationPage = new ConfigurationPage(driver);
		configurationPage.Select_CustomFields();
		logger.info("Landed on Custom Fields page");

		
		CustomFieldsPage customFieldsPage = new CustomFieldsPage(driver);
		logger.info("Navigate to custom fields Add info page");
		customFieldsPage.Click_Add();
		logger.info("Send Field Name");
		customFieldsPage.send_FieldName("Address");
		logger.info("Select Screen Option");
		Thread.sleep(5000);
		customFieldsPage.select_ScreenOption(customFieldsPage.option2);
		Thread.sleep(5000);
		logger.info("Select Type Option");
		Thread.sleep(5000);
		customFieldsPage.select_Typeoption(customFieldsPage.TypeOption2);
		logger.info("Select Cancel");
		
		Thread.sleep(5000);
//		logger.info("Again Navigate to custom fields Add info page");
//		customFieldsPage.Click_Add();
//		logger.info("Send Field Name");
//		customFieldsPage.send_FieldName("Address");
//		logger.info("Select Screen Option");
//		customFieldsPage.select_ScreenOption(customFieldsPage.option2);
//		logger.info("Select Type Option");
//		customFieldsPage.select_Typeoption(customFieldsPage.TypeOption2);
//		logger.info("Select Save");
//		customFieldsPage.click_Cancel();
//		Thread.sleep(5000);
		
		
	//	customFieldsPage.click_Save();
//		logger.info("");
//		logger.info("");
//		logger.info("");
//		logger.info("");logger.info("");
		
		Thread.sleep(5000);
		
	}
	
//	@Test(priority=20)
//	public void testLogout()
//	{
//		h.click_Logout();
//	}
}
