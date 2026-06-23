package testCases;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.PIMPage;
import testBase.BaseClass;

public class TC003_1_verify_ErrorMessages extends BaseClass {
	public SoftAssert sa;
	@Test(priority=1)
	public void verify_ErrorMessages()
	{
		logger.info("Started executing TC003_verify_ErrorMessages");
		try {
			 sa = new SoftAssert();
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
			logger.info("Enable toggle switch");
			pim.Click_ToggleSwitch();
			logger.info("Submit Form");
			pim.click_Submit();
			logger.info("Extract expected errors list");
			List<String> expectedErrors = Arrays.asList("Required","Required","Required","Required","Passwords do not match");
			System.out.println(expectedErrors);
			logger.info("Extract actual errors list");
			List<String> actualErrors = pim.get_error_Msgs();
			System.out.println(actualErrors);
			actualErrors.forEach(System.out::println);
			Collections.sort(expectedErrors);
			Collections.sort(actualErrors);
			logger.info("Comapre Expected & Actual Errors");
			sa.assertEquals(actualErrors,expectedErrors,"Errors does not match");
			h.click_Logout();
			
		}catch(Exception e)
		{
			e.printStackTrace();
			sa.assertAll();
			logger.info("TC003_verify_ErrorMessages failed");
		}
		
		logger.info("TC003_verify_ErrorMessages Verified successfully");
	}
}
