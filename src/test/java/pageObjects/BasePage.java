package pageObjects;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	WebDriver driver;
	protected WebDriverWait wait;
	BasePage(WebDriver driver)
	{
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver,this);
	}
//	// Generic method for clicking
	public void clickElement(WebElement element)
	{
		wait.until(ExpectedConditions.elementToBeClickable(element)).click();
	}
	
	public void clear(WebElement element) {
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.sendKeys(Keys.CONTROL + "a");
		element.sendKeys(Keys.DELETE);
	}
	
	//Generic Method for entering text	
	public void enterText(WebElement element, String text)
	{
		wait.until(ExpectedConditions.elementToBeClickable(element));
		clear(element);
		element.sendKeys(text);
	}
	
	//Generic method for getting text
	
	public String getText(WebElement element)
	{
	wait.until(ExpectedConditions.visibilityOf(element));
		return element.getText();
	}
	
	//Generic method for checking element is displayed
	public boolean isElementDisplayed(WebElement element)
	{
		try {
		wait.until((ExpectedConditions.visibilityOf(element)));
		return element.isDisplayed();
		}catch(Exception e)
		{
			return false;
		}
	}
	 
	//Handle dropdown by visible text
	public void selectDropdownByVisibleText(WebElement element, String text)
	{
		wait.until(ExpectedConditions.visibilityOf(element));
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}
	
	// Select dropdown By value
	public void selectDropdownByValue(WebElement element, String value)
	{
		wait.until(ExpectedConditions.visibilityOf(element));
		Select select = new Select(element);
		select.selectByValue(value);
	}
	
	//Select dropdown by index
	public void selectDropdownByIndex(WebElement element, int index)
	{
		wait.until(ExpectedConditions.visibilityOf(element));
		Select select = new Select(element);
		select.selectByIndex(index);
	}
	
	//CheckBox : check if not selected
	
	public void selectCheckbox(WebElement element)
	{
		wait.until(ExpectedConditions.elementToBeClickable(element));
		if(!element.isSelected())
		{
			element.click();
		}
		
	}
	
	public void unselectCheckbox(WebElement element)
	{
		wait.until(ExpectedConditions.elementToBeClickable(element));
		if(element.isSelected())
		{
			element.click();
		}
	}
	
	
	public void selectRadioButton(WebElement element)
	{
		wait.until(ExpectedConditions.elementToBeClickable(element));
		if(!element.isSelected()) 
		{
			element.click();
		}
		
	}
	
	
	 /**
     * Uploads a file using the Robot class by simulating keyboard input.
     *
     * @param filePath Full path to the file to upload.
     * @throws AWTException if the platform configuration does not allow low-level input control.
     * @throws InterruptedException if thread is interrupted during sleep.
     */
    public static void uploadFileWithRobot(String filePath) throws AWTException, InterruptedException {
        // Copy file path to clipboard
        StringSelection selection = new StringSelection(filePath);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);

        // Create Robot instance
        Robot robot = new Robot();
        robot.setAutoDelay(100);

        // Wait a little for dialog to appear
        Thread.sleep(2000);

        // Paste the file path (CTRL + V)
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);

        // Press Enter
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    
}

	
	//Excel Data Provider
}

