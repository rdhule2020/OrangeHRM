package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;//Log4j
import org.apache.logging.log4j.Logger;//Log4j
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.github.javafaker.Faker;

import pageObjects.HomePage;
import pageObjects.LoginPage;

public class BaseClass {
	
	public static final Faker faker = new Faker();
	
	public static WebDriver driver;
	public FileReader file;
	public Properties p;
	public FileReader file1;
	public Properties p1;
	public Logger logger;
	
//	@BeforeSuite
//	public void OpenConfiguration() throws IOException
//	{
//
//		FileReader file = new FileReader("./src/test/resources//config.Properties");
//		this.p = new Properties();
//		p.load(file);
//		
//		FileReader file1 = new FileReader("./src/test/resources//configPIM.Properties");
//		this.p1 = new Properties();
//		p1.load(file1);
//		
//	
//	}
//	
	@BeforeMethod (enabled=false)
	public void Login()
	{
		LoginPage login =new LoginPage(driver);
		login.set_Username(p.getProperty("username"));
		login.set_Password(p.getProperty("password"));
		login.click_Login();
	}
	
	@AfterMethod(enabled=false)
	public void LogOut()
	{
		HomePage h = new HomePage(driver);
		h.click_Logout();
	}
	
	@BeforeClass
	@Parameters ({"Browser"})
	public void setup(String br) throws IOException 
	{
		
	FileReader file = new FileReader("./src/test/resources//config.Properties");
	this.p = new Properties();
	p.load(file);
	
	FileReader file1 = new FileReader("./src/test/resources//configPIM.Properties");
	this.p1 = new Properties();
	p1.load(file1);
	
		
		
		logger = LogManager.getLogger(this.getClass());
		
		switch(br.toLowerCase())
		{
		case "chrome" : driver = new ChromeDriver(); break; 
		case "edge" : driver = new EdgeDriver(); break;
		case "firefox" : driver = new FirefoxDriver(); break;
		default : System.out.println("Invalid browser name ..."); return;
		}
		
		//driver = new EdgeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(p.getProperty("appURL"));
		driver.manage().window().maximize();
		logger.info("Browser launched successfully");
		
	}
	
	@AfterClass
	public void tesrDown()
	{
		driver.quit();
	}
	
//	@AfterSuite
//	public void CloseConfiguration() {
//		
//		if (p != null) {
//	        p.clear();  // Clear all properties
//	        p = null;   // Set the Properties object to null (optional)
//	    }
//		
//	    if (p1 != null) {
//	        p1.clear();  // Clear all properties
//	        p1 = null;   // Set the Properties object to null (optional)
//	    }
//	    System.out.println("Test suite execution completed. Configuration closed.");
//	}
//	
	
	
	
	
	public String randomString()
	{
		String generatedstring = RandomStringUtils.randomAlphabetic(8);
		return generatedstring;
	}
	
	public String randomNumber()
	{
		String randomNumber = RandomStringUtils.randomNumeric(10);
		return randomNumber;
	}
	
	public String randomAlphaNumeric()
	{
		String generatedstring = RandomStringUtils.randomAlphabetic(3);
		String randomNumber = RandomStringUtils.randomNumeric(3);
		
		return (generatedstring+"$"+randomNumber);
	}
	
	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
		File targetFile=new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
			
		return targetFilePath;

	}
}
