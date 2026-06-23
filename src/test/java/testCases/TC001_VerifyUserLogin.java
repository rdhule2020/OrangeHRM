package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC001_VerifyUserLogin extends BaseClass {

	@Test(priority = 0)
	public void LoginWithInvalidData() {
		 
		try 
		{
		logger.info("Started login test with Invalid Data");
		LoginPage l = new LoginPage(driver);
		logger.info("Sending Data");
		l.set_Username(p.getProperty("username"));
		l.set_Password(p.getProperty("pwd"));
		l.click_Login();
		logger.info("Clicked Login Button");
		
		if(l.get_error_msg().equalsIgnoreCase("Invalid credentials"))
		{
			Assert.assertTrue(true);
		}
		}
		catch(Exception e)
		{
			e.getMessage();
			Assert.fail();
		}
		 logger.info("Login test with Invalid Data Completed");
	}

	
	
	
	@Test(priority = 1)
	public void WrongUsernameLoginTest()
	
	{
		try {
			logger.info("Started login test with Wrong User Data");
			LoginPage l = new LoginPage(driver);
			logger.info("Sending User Data"); 
			l.set_Username(p.getProperty("user"));
			l.set_Password(p.getProperty("password"));
			logger.info("Clicked Login Button");
			l.click_Login();
			
			if(l.get_error_msg().equalsIgnoreCase("Invalid credentials"))
			{
				Assert.assertTrue(true);
			}
			}
			catch(Exception e)
			{
				e.getMessage();
				Assert.fail();
			}
			 logger.info("Login test with wrong User Data Completed");
	}
	
	@Test(priority = 2)
	public void WrongUsernameWrongPassLoginTest()
	
	{
		try {
			logger.info("Started login test with wrong User & Wrong Pass  ");
			LoginPage l = new LoginPage(driver);
			logger.info("Sending User Data"); 
			l.set_Username(p.getProperty("user"));
			l.set_Password(p.getProperty("pwd"));
			logger.info("Clicked Login Button");
			l.click_Login();
			if(l.get_error_msg().equalsIgnoreCase("Invalid credentials"))
			{
				Assert.assertTrue(true);
			}
			
			}
			catch(Exception e)
			{
				e.getMessage();
				Assert.fail();
			}
			 logger.info("Login test with wrong User & Wrong Pass  Completed");
	}
	
	@Test(priority = 4)
	public void LoginWithValidData() {
	
		try {
		logger.info("Started login test with Valid Data");
		LoginPage l = new LoginPage(driver);
		logger.info("Sending Data"); 
		l.set_Username(p.getProperty("username"));
		l.set_Password(p.getProperty("password"));
		logger.info("Clicked Login Button");
		l.click_Login();
		HomePage h = new HomePage(driver);
		h.click_Logout();
		if(l.get_error_msg().equalsIgnoreCase("Invalid credentials"))
		{
			Assert.assertTrue(false);;
		}
		}
		catch(Exception e)
		{
			e.getMessage();
			Assert.fail();
		}
		 logger.info("Login test with Valid Data Completed");
	}
	
	
	@Test(priority = 3)
	public void LoginWithInValidDataUsingFakerData() {
	
		try {
		logger.info("Started login test with Valid Data");
		LoginPage l = new LoginPage(driver);
		logger.info("Sending Data"); 
		l.set_Username(faker.name().username());
		l.set_Password(faker.internet().password());
		logger.info("Clicked Login Button");
		l.click_Login();
		if(l.get_error_msg().equalsIgnoreCase("Invalid credentials"))
		{
			Assert.assertTrue(true);;
		}
		}
		catch(Exception e)
		{
			e.getMessage();
			Assert.fail();
		}
		 logger.info("Login test with Valid Data Completed");
	}
}
