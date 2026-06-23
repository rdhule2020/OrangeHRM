package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class EmployeeList extends BasePage{

	public EmployeeList(WebDriver driver)
	{
		super(driver);
	}
	
	
	@FindBy(xpath="//div[@role='columnheader']//i[@class='oxd-icon bi-check oxd-checkbox-input-icon']")WebElement checkbox;
	@FindBy(xpath="//*[text()=' Delete Selected ']")WebElement  btn_Delete;
	@FindBy(xpath="//div[@role='document']//i")WebElement  btn_YesDelete;
	@FindBy(xpath="//div/span[@class='oxd-text oxd-text--span']")WebElement records;
	
//	@FindBy(xpath="")WebElement  ;
//	@FindBy(xpath="")WebElement  ;
//	@FindBy(xpath="")WebElement  ;
//	@FindBy(xpath="")WebElement  ;
	
	// Correct method
	public void deleteEmployeeList()
	{	
		wait.until(ExpectedConditions.visibilityOf(records));
		String text =records.getText();
		int employees =Integer.parseInt(text.substring(text.indexOf("(")+1, text.indexOf(")")));
	
		while(employees>2)
		{
		    if (checkbox.isEnabled() && !checkbox.isSelected()) {
		    	
	            checkbox.click();

	          wait.until(ExpectedConditions.elementToBeClickable(btn_Delete));
	            btn_Delete.click();

	           wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='document']//i"))); 
	            btn_YesDelete.click();
	            
	          text = records.getText();
	          employees = Integer.parseInt(text.substring(text.indexOf("(") + 1, text.indexOf(")")));
	          
	        } 
		    else {
	        	
	            System.out.println("Checkbox not clickable as number of records available is : " + employees);
	            break;
	        }
			
		}
	}
	
	//Use this method for known number of loops 
	public void select_checkboxesAndClickDelete() throws InterruptedException {

		for (int i = 0; i <= 1; i++) {
			if (checkbox.isEnabled()) {

				checkbox.click();
				if (btn_Delete.isEnabled()) {
					btn_Delete.click();
					if (btn_YesDelete.isDisplayed()) {
						btn_YesDelete.click();
					} else {
						break;
					}
				}
			} else {
				break;
			}
		}

	}
	
	
	////////////////////////
	/*
	 * 
	public void select_checkboxesAndClickDelete() {
    List<WebElement> checkboxes = driver.findElements(By.cssSelector("input[type='checkbox']")); // Replace with your actual locator

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    for (int i = 0; i < checkboxes.size(); i++) {
        WebElement checkbox = checkboxes.get(i);

        if (checkbox.isEnabled() && !checkbox.isSelected()) {
            checkbox.click();

            WebElement btn_Delete = wait.until(ExpectedConditions.elementToBeClickable(By.id("delete-button"))); // Replace with actual locator
            btn_Delete.click();

            WebElement btn_YesDelete = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("yes-delete-button"))); // Replace with actual locator
            btn_YesDelete.click();

            // Wait for deletion to complete (optional: wait for toast, disappearance of row, etc.)
            // Thread.sleep(1000); // Temporary wait — avoid using in real tests
        } else {
            System.out.println("Checkbox not clickable or already selected: " + i);
        }
    }
}

	 */
}
