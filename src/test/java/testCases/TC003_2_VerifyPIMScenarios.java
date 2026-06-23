package testCases;

import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.PIMPage;
import testBase.BaseClass;

public class TC003_2_VerifyPIMScenarios extends BaseClass{
	
	
	@Test(priority=1)
	public void verify_AddEmployeeSubModule() throws InterruptedException
	{
		logger.info("Started executing TC003_verify_AddEmployeeSubModule");
		try {
		logger.info("Login to OrangeHRM");
		LoginPage l =new LoginPage(driver);
		l.set_Username(p.getProperty("username"));
		l.set_Password(p.getProperty("password"));
		l.click_Login();
		logger.info("Navigate to Home page");
		HomePage h = new HomePage(driver);
		h.click_PIM();
		logger.info("Navigate to PIM page");
		PIMPage pim = new PIMPage(driver);
		logger.info("Navigate to Add Employee page");
		pim.click_AddEmployee();
		
		logger.info("Fill new Employee details");
		pim.send_FirstName(p1.getProperty("fname"));
		pim.send_MiddleName(p1.getProperty("mname"));
		pim.send_LastName(p1.getProperty("lname"));
		//pim.send_EmpId(p1.getProperty("empId"));
		logger.info("Enable toggle switch");
		
		pim.Click_ToggleSwitch();
		logger.info("Fill credentials");
		pim.send_Username(p1.getProperty("username"));
		pim.send_Password(p1.getProperty("password"));
		pim.send_ConfirmPassword(p1.getProperty("cpassword"));
		logger.info("Submit Form");
		pim.click_Submit();
		
		
		
		
		
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		logger.info("TC003_verify_AddEmployeeSubModule Verified successfully");
	}
	
	
}
