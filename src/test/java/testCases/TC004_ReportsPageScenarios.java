package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.EmployeeReportsPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.PIMPage;
import pageObjects.ReportsPage;
import testBase.BaseClass;

public class TC004_ReportsPageScenarios extends BaseClass {

	
	
	@Test(priority=1,enabled = true)
	public void verify_AddUserReports() throws InterruptedException
	{
		try
		{
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
			pim.click_Reports();
			logger.info("Navigate to Add Reports page");
			ReportsPage r = new ReportsPage(driver);
			logger.info("Click Add");
			r.click_Add();
			logger.info("Add report Name");
			r.set_ReportName(p1.getProperty("ReportName1"));

	
			logger.info("Select options from Include dropdown");
			r.Click_IncludeSelection();
			
			//1
			logger.info("Select options from field Group dropdown");
			r.select_FieldGroup_personnel();
			logger.info("Select options from field dropdown");
			r.select_field();
			r.click_btn_plus_field();
			r.select_field();
			r.click_btn_plus_field();
			r.select_field();
			r.click_btn_plus_field();
			
			//2
			logger.info("Select options from field Group dropdown");
			r.select_FieldGroup();
			logger.info("Select options from field dropdown");
			r.select_field();
			r.click_btn_plus_field();
			//3
			logger.info("Select options from field Group dropdown");
			r.select_FieldGroup();
			logger.info("Select options from field dropdown");
			r.select_field();
			logger.info("Click save button");
			r.click_Save();
			
			
		}catch(Exception e)
		{
			e.printStackTrace();
			Assert.fail();
		}
		
	
		
	}
	
	@Test(priority=2,enabled = true)
	public void DeleteReport() throws InterruptedException
	{
		logger.info("Navigate to PIM page");
		PIMPage pim = new PIMPage(driver);
		pim.click_Reports();
		logger.info("Navigate to EmployeeReportsPage");
		EmployeeReportsPage erp = new EmployeeReportsPage(driver);
	
		if(erp.isExist()==true)
		{	
			logger.info("Click delete Icon from table");
			erp.delete_report();
			logger.info("Click cancel Icon from PopUp");
			erp.Click_NoCancel();
			
			erp.delete_report();
			logger.info("Click delete Icon from table");
			erp.click_YesDelete();
			logger.info("Report deleted");
	
		}
		
		Thread.sleep(1000);
		
	}
	
	@Test(priority=3 ,enabled = true )
	public void CheckReport() throws InterruptedException
	{
		logger.info("Navigate to PIM page");
		PIMPage pim = new PIMPage(driver);
		pim.click_Reports();
		logger.info("Navigate to EmployeeReportsPage");
		EmployeeReportsPage erp = new EmployeeReportsPage(driver);
		logger.info("View Report");
		erp.clickViewReport();;
		logger.info("Get Report Title");
		String title= erp.Gettitle();
		if(erp.Gettitle()!=null)
		{
			logger.info("Report Edited");
		}

		Thread.sleep(1000);
		
	}
	
	@Test(priority=4,enabled = true)
	public void verify_AddReports() throws InterruptedException
	{
		try
		{
			logger.info("Navigate to Home page");
			HomePage h = new HomePage(driver);
			h.click_PIM();
			logger.info("Navigate to PIM page");
			PIMPage pim = new PIMPage(driver);
			pim.click_Reports();
			logger.info("Navigate to Add Reports page");
			ReportsPage r = new ReportsPage(driver);
			logger.info("Click Add");
			r.click_Add();
			logger.info("Add report Name");
			r.set_ReportName(p1.getProperty("ReportName"));

			logger.info("Select Criteria from dropdown");
			r.testSelectPayGrade();
			r.click_CriteriaPlus();
		
			r.delete_option_PayGrade();
			r.testSelectPayGrade();
			
			logger.info("Select Grade");
			r.click_CriteriaPlus();
			r.selectGrade();
			logger.info("Select options from Include dropdown");
			r.Click_IncludeSelection();
			logger.info("Select options from field Group dropdown");
			r.select_FieldGroup();
			logger.info("Select options from field dropdown");
			r.select_field();
			
			r.click_btn_plus_field();
			
			logger.info("Click save button");
			r.click_Save();
			
			
		}catch(Exception e)
		{
			e.printStackTrace();
			Assert.fail();
		}	
		finally {
		
		HomePage h = new HomePage(driver);
		h.click_Logout();
	}
	}
	
	@Test(priority=5, enabled = false) /// Pending
	public void searchAndView()
	{
		try
		{
		logger.info("Navigate to PIM page");
		PIMPage pim = new PIMPage(driver);
		pim.click_Reports();
		logger.info("Navigate to EmployeeReportsPage");
		EmployeeReportsPage erp = new EmployeeReportsPage(driver);
		logger.info("Send value in autosuggesstion dropdown");
		Thread.sleep(1000);
		erp.search_Report();
		
//		Thread.sleep(1000);
//		logger.info("Click on reset");
//		erp.click_reset();
//		logger.info("Again send value in autosuggesstion dropdown");
//		erp.search_Report();
		logger.info("Click on search");
		erp.click_Search();
		logger.info("Edit report");
		erp.EditReport();
		logger.info("Make some changes");
		ReportsPage r = new ReportsPage(driver);
		r.select_FieldGroup_personnel();
		r.select_field();
		r.click_btn_plus_field();
		logger.info("Save changes");
		r.click_Save();
		
	if(erp.getReportTitle().equals("Test1"));
	{
		Assert.assertTrue(true);
		logger.info("title verified");
	}
	
	}catch(Exception e)
	{
		e.printStackTrace();
		Assert.fail();
	}
	
		
		
	}
}
