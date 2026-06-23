package testCases;

import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.PersonalDetailsPage;
import testBase.BaseClass;

public class TC002_VerifyPersonalDetails extends BaseClass {
//Incomplete
	@Test//logger.info("");
	public void verify_UpdatePersonalDetails() throws InterruptedException
	{
		LoginPage l =new LoginPage(driver);
		l.set_Username(p.getProperty("username"));
		l.set_Password(p.getProperty("password"));
		l.click_Login();
		
		HomePage h = new HomePage(driver);
	
		h.click_MyInfo();
	
		
		PersonalDetailsPage pd = new PersonalDetailsPage(driver);
		Thread.sleep(5000);
	
		
		pd.enterPersonalDetails(p.getProperty("fname"), p.getProperty("mname"), p.getProperty("lname"),
				p.getProperty("empID"), p.getProperty("otherId"), p.getProperty("DLiscNo"));
			
		pd.set_ExpiryDate("2025-02-09");
		logger.info("");
		
		Thread.sleep(5000);
	}
}
