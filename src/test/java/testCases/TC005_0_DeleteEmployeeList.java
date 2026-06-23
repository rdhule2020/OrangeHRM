package testCases;

import org.testng.annotations.Test;

import pageObjects.EmployeeList;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC005_0_DeleteEmployeeList extends BaseClass{

	@Test
	public void deleteEmployeeList() throws InterruptedException
	{
		logger.info("login as Admin");
		LoginPage l =new LoginPage(driver);
		logger.info("Enter username and password");
		l.set_Username(p.getProperty("username"));
		l.set_Password(p.getProperty("password"));
		logger.info("Click login");
		l.click_Login();
		
		HomePage h = new HomePage(driver);
		logger.info("Click on PIM from menu");
		h.click_PIM();
		
		EmployeeList em = new EmployeeList(driver);
		logger.info("Select Checkbox and delete all employees from employee list");
		em.deleteEmployeeList();
	
		Thread.sleep(5000);
		logger.info("Employees deleted");
		
	
	}
	
}
