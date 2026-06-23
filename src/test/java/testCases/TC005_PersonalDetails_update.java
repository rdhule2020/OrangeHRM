package testCases;

import java.awt.AWTException;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.ContactDetails;
import pageObjects.EmergencyContacts;
import pageObjects.EmployeeList;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyInfo;
import pageObjects.PIMPage;
import pageObjects.PersonalDetailsPage;
import testBase.BaseClass;

public class TC005_PersonalDetails_update extends BaseClass{

	public HomePage h;
	public LoginPage l;
	public PIMPage pim;
	public PersonalDetailsPage pd;
	public ContactDetails cd;
	public MyInfo my;
	public EmergencyContacts ed;
	public SoftAssert sa= new SoftAssert();
	@Test(priority =0)
	public void delete_Employees() throws InterruptedException
	{
		logger.info("Login to OrangeHRM");
		l =new LoginPage(driver);
		l.set_Username(p.getProperty("username"));
		l.set_Password(p.getProperty("password"));
		l.click_Login();
		logger.info("Navigate to Home page");
		h = new HomePage(driver);
		h.click_PIM();
		
		EmployeeList em = new EmployeeList(driver);
		logger.info("Select Checkbox");
		em.select_checkboxesAndClickDelete();
	
		logger.info("Users deleted");
	}
	
	
	@Test(priority =1)
	public void verify_AddEmployee_PersonnelDetails_Workflow() 
	{
		logger.info("Started executing TC005_verify_AddEmployee_PersonnelDetails_Workflow()");
		
		
		logger.info("Navigate to Home page");
		h = new HomePage(driver);
		h.click_PIM();
		logger.info("Navigate to PIM page");
		pim = new PIMPage(driver);
		logger.info("Navigate to Add Employee page");
		pim.click_AddEmployee();
		
		logger.info("Fill new Employee details");
		pim.send_FirstName(p1.getProperty("fname1"));
		pim.send_MiddleName(p1.getProperty("mname1"));
		pim.send_LastName(p1.getProperty("lname1"));
		//pim.send_EmpId(p1.getProperty("empId1"));
		logger.info("Enable toggle switch");
		
		pim.Click_ToggleSwitch();
		logger.info("Fill credentials");
		pim.send_Username(faker.name().username());
		//	pim.send_Username(p1.getProperty("username1"));
		pim.send_Password(p1.getProperty("password1"));
		pim.send_ConfirmPassword(p1.getProperty("cpassword1"));
		logger.info("Submit Form");
		pim.click_Submit();
		
		logger.info("Navigate to Personal Details page and Enter all information");
		pd = new PersonalDetailsPage(driver);
		pd.set_OtherID(p1.getProperty("otherId1"));
		pd.set_DriverLiscNO(p1.getProperty("DLiscNo1"));
		pd.set_ExpiryDate(p1.getProperty("ExpiryDate1"));;
		pd.select_Nationality();
		pd.Click_MarriageStatus();
		pd.set_DOB(p1.getProperty("DOB1"));
		pd.select_Gender();
		logger.info("Click Save ");
		pd.click_Save();
		
		logger.info("Enter Blood group details");
		pd.set_bloodGroup();
		pd.set_TestField();
		pd.click_CustomFieldsave();
		
		
	}

	@Test(priority = 2)
	public void testUpdateContactDetails() {
		
		
				logger.info("Navigate to Contact Details page");
				my = new MyInfo(driver);
				my.click_contactDetails();
			
				cd = new ContactDetails(driver);
				logger.info("Enter All informaton");
				cd.set_street1(p1.getProperty("Street1"));
				cd.set_street2(p1.getProperty("Street2"));
				cd.set_City(p1.getProperty("City"));
				cd.set_State(p1.getProperty("State"));
				cd.set_PostalCode(p1.getProperty("ZipCode"));
				cd.select_Country(p1.getProperty("country"));
				cd.set_Home(p1.getProperty("Home"));
				cd.set_Mobile(p1.getProperty("Mobile"));
				cd.set_work(p1.getProperty("work"));
				cd.set_workEmail(faker.internet().emailAddress());
				cd.set_otherEmail(faker.internet().emailAddress());
				logger.info("Submit form");
				cd.Click_Save();
				
			
				
				
	}
	
	@Test(priority=3)
	public void test_UploadAttachment() throws AWTException, InterruptedException
	{
		
		logger.info("Click on Add  ");
		cd.click_Add();
		logger.info("Click on Cancel  ");
		cd.click_Cancel();
		logger.info("Click on Add  ");
		cd.click_Add();
		logger.info("Click on Browse  ");
		cd.click_Browse();
		logger.info("Browse and Select file to Uplaod and upload ");
		cd.uploadFileWithRobot(cd.filepath);
		logger.info("Click on save attachment ");
		cd.click_Save_Attachment();
		
		
		
		
	}
	
	
	
	@Test(priority=20)
	public void testLogout()
	{
		h.click_Logout();
	}
}
