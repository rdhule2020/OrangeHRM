package testCases;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.ContactDetails;
import pageObjects.EmergencyContacts;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyInfo;
import pageObjects.PIMPage;
import pageObjects.PersonalDetailsPage;
import testBase.BaseClass;

public class TC006_VerifyEmergenctDetailsPage extends BaseClass {
	public HomePage h;
	public LoginPage l;
	public PIMPage pim;
	public PersonalDetailsPage pd;
	public ContactDetails cd;
	public MyInfo my;

	public EmergencyContacts ed;
	public SoftAssert sa= new SoftAssert();
	
	@Test(priority=1)
	public void testCheckErrorMessagesOnEmergencyContactDetailsPage()
	{
		
		sa = new SoftAssert();
		
		
		logger.info("Login to OrangeHRM");
		l =new LoginPage(driver);
		l.set_Username(p.getProperty("username"));
		l.set_Password(p.getProperty("password"));
		l.click_Login();
		logger.info("Navigate to home page");
		h = new HomePage(driver);
		h.click_MyInfo();
		logger.info("Navigate to MayInfo Page");
		
		my =new MyInfo(driver);
		
		logger.info("Click on EmergencyDetails ");
		my.click_EmergencyDetails();
		logger.info("Click on Add EmergencyDetails button ");
		ed = new EmergencyContacts(driver);
		ed.click_add_contacts();
		logger.info("Click on Save ");
		ed.click_Save_A();
		logger.info("Extract expected errors list");
		List<String> ExpectedErrors = Arrays.asList("Required","Required","At least one phone number is required");
		System.out.println(ExpectedErrors);
		logger.info("Extract actual errors list");
		List<String> ActualErrors = ed.getErrorMessages();
		ActualErrors.forEach(System.out::println);
		System.out.println(ActualErrors);
		logger.info("sort both lists");
		Collections.sort(ExpectedErrors);
		Collections.sort(ActualErrors);
		
		logger.info("Comapre Expected & Actual Errors");
		sa.assertEquals(ExpectedErrors, ActualErrors,"Errors messages not matched");
	
		
	}
	
	
	
	
	
	@Test(priority=2)
	public void testAssignedEmergencyContacts()
	{
		
		
		logger.info("Click on EmergencyDetails ");
		my.click_EmergencyDetails();
		logger.info("Click on Add EmergencyDetails button ");
		ed = new EmergencyContacts(driver);
		ed.click_add_contacts();
		
		logger.info("Enter Name ");
		ed.set_Name(faker.name().firstName());
		logger.info("Enter Relationship ");
		ed.set_Relationship(faker.relationships().parent());
		logger.info("Enter HomeTelephone ");
		ed.set_HomeTelephone(faker.phoneNumber().phoneNumber());
		logger.info("Enter Mobile ");
		ed.set_HomeTelephone(faker.phoneNumber().cellPhone());
		logger.info("Enter WorkTelephone ");
		ed.set_HomeTelephone(faker.phoneNumber().phoneNumber());
		logger.info("Click on Save ");
		
	}
	
	@Test(priority=20)
	public void testLogout()
	{
		h.click_Logout();
	}
}
