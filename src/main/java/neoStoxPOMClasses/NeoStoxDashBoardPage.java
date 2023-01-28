package neoStoxPOMClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;



public class NeoStoxDashBoardPage 
{
	//1. Data member should be declared globally with access level private using @findBy Annotation
    
	@FindBy(xpath = "(//a[text()='OK'])[2]") private WebElement popUpOkButton;
	
	@FindBy(xpath="(//a[text()='Close'])[5]") private WebElement popUpCloseButton;
	
	@FindBy (id = "lbl_username")private WebElement userName;
	
	@FindBy (id = "lbl_curbalancetop")private WebElement balance;
	
	@FindBy (id = "lnk_logout")private WebElement logOutButton;
	

	//2. Initialize within a constructor with access level public using pagefactory 
	
	public NeoStoxDashBoardPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	//3. Utilize within a method with access level public
	
	public void handlePopUp(WebDriver driver) throws InterruptedException
	{
		Thread.sleep(1000);
		if(popUpOkButton.isDisplayed()==true)
		{
			popUpOkButton.click();
			Thread.sleep(1000);
			if(popUpCloseButton.isDisplayed()==true)
			{
			popUpCloseButton.click();
			Thread.sleep(1000);
			Reporter.log("Handling Pop Up ", true);
			}
		}
		else
		{
			Reporter.log("There no Pop Up ", true);
		}
	}
	public String getActualUserName()
	{
		String actualUserName = userName.getText();
		Reporter.log("Getting Actual User Name ", true);
		Reporter.log("Actual User Name--> "+actualUserName, true);
		return actualUserName;
		
	}
	public String getBalanceInfo()
	{
		String accBalance = balance.getText();
		Reporter.log("Getting Account Balance", true);
		Reporter.log("Account Balance -->>"+accBalance, true);
		return accBalance;
	}
	public void logOutFromNeoStox() throws InterruptedException
	{
		userName.click();
		Thread.sleep(1000);
		logOutButton.click();
		Thread.sleep(1000);
	}
	

}
