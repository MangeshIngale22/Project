package neoStoxPOMClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class NeoStoxSignInPage 
{
	//1. Data member should be declared globally with access level private using @findBy Annotation
    
	@FindBy(id = "MainContent_signinsignup_txt_mobilenumber")private WebElement mobileNumberField;
	
	@FindBy(id = "lnk_signup1")private WebElement signInButtonOfHomePage;
	
	//2. Initialize within a constructor with access level public using pagefactory 
	
	public NeoStoxSignInPage (WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	
	//3. Utilize within a method with access level public
	
	public void enterMobileNumberField(String mobNum)
	{
		mobileNumberField.sendKeys(mobNum);
		Reporter.log("Entering mobile Number", true);
	}
	
	public void clickOnHomePageSignInButton()
	{
		signInButtonOfHomePage.click();
		Reporter.log("Clicking On SignIn Button of home page",true);
	}

}
