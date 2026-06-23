package testCases;

import org.testng.annotations.Test;

import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC000_LoginUsingGenericMethod extends BaseClass{
	
	@Test
	public void Verify_Login()
	{
		LoginPage login = new LoginPage(driver);
		login.login(p.getProperty("username"), p.getProperty("password"));
	}

}
