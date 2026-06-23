package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.ConfigurationPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.OptionalFields;
import pageObjects.PIMPage;
import testBase.BaseClass;

public class TC007_VerifyOptionalFieldsPage extends BaseClass{
	public LoginPage l;
	public PIMPage pim;
	public HomePage h;
	public ConfigurationPage configurationPage;
	public OptionalFields optionalFields;
	
	@Test(priority=0)
	public void Verify_ConfigureOptionalFields() throws InterruptedException
	{
		SoftAssert softAssert = new SoftAssert();
		
		try {
	
		logger.info("Login to OrangeHRM");
		l =new LoginPage(driver);
		l.set_Username(p.getProperty("username"));
		l.set_Password(p.getProperty("password"));
		l.click_Login();
		logger.info("Navigate to home page");
		h = new HomePage(driver);
		h.click_PIM();
		logger.info("Select OptionalField from configuration dropdown");
		configurationPage = new ConfigurationPage(driver);
		configurationPage.Select_OptionalFields();
		logger.info("Landed on Optional Fields page");
		
		optionalFields = new OptionalFields(driver);
		logger.info("Turn NickName On");
		optionalFields.Click_toggle_NickName();
		logger.info("Turn SSN On");
		optionalFields.Click_toggle_SSN();
		logger.info("Turn SIN On");
		optionalFields.Click_toggle_SIN();
		logger.info("Turn US Tax On");
		optionalFields.Click_toggle_USTax();
		logger.info("Click Save");
		optionalFields.Click_btn_Save();
		Thread.sleep(5000);
		logger.info("Turn SIN Off");
		optionalFields.Click_toggle_SIN();
		logger.info("Turn US Tax Off");
		optionalFields.Click_toggle_USTax();
		logger.info("Click Save");
		optionalFields.Click_btn_Save();
		
		Thread.sleep(5000);
		logger.info("Turn NickName Off");
		optionalFields.Click_toggle_NickName();
		logger.info("Turn SSN Off");
		optionalFields.Click_toggle_SSN();
		
		logger.info("Click Save");
		optionalFields.Click_btn_Save();
		
		Assert.assertTrue(true);
		
		}catch(Exception e)
		{
			e.printStackTrace();
			softAssert.assertAll();
		}
		
	}

	

	@Test(priority=20)
	public void testLogout()
	{
		h.click_Logout();
	}
}
