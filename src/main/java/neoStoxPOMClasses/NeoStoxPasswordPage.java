package neoStoxPOMClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class NeoStoxPasswordPage 
{	
	
	//1. Data member should be declared globally with access level private using @findBy Annotation
    
	@FindBy(id ="txt_accesspin")private WebElement passwordField;
	
	@FindBy(id ="lnk_submitaccesspin")private WebElement submitButton;
	
	//2. Initialize within a constructor with access level public using pagefactory 
	
	public NeoStoxPasswordPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//3. Utilize within a method with access level public
	
	public void enterPasswordfield(String pwd) throws InterruptedException
	{
		passwordField.sendKeys(pwd);
		Reporter.log("Entering Password", true);
		Thread.sleep(1000);
	}

	public void clickingOnSubmitButton() throws InterruptedException 
	{
		submitButton.click();
		Reporter.log("Clicking On Submit Button", true);
		Thread.sleep(1000);
	}
}
