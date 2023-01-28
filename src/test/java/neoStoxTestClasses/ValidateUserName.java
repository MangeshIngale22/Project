package neoStoxTestClasses;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


import neoStoxPOMClasses.NeoStoxDashBoardPage;
import neoStoxPOMClasses.NeoStoxHomePage;
import neoStoxPOMClasses.NeoStoxPasswordPage;
import neoStoxPOMClasses.NeoStoxSignInPage;
import neoStoxPOMClasses.Utility;




@Listeners(neoStoxTestClasses.Listener.class)
public class ValidateUserName extends Base
{
	NeoStoxHomePage home;
	NeoStoxSignInPage signIn;
	NeoStoxPasswordPage password;
	NeoStoxDashBoardPage dash;
  @BeforeClass
  public void launchApp() throws IOException
  {
	  launchBrowser();
	  home = new NeoStoxHomePage(driver);
	  signIn = new NeoStoxSignInPage(driver);
	  password = new NeoStoxPasswordPage(driver);
	  dash = new NeoStoxDashBoardPage(driver);
  }
  @BeforeMethod
  public void logInToNeoStox() throws EncryptedDocumentException, IOException, InterruptedException 
  {
	  home.clickOnSignInButton();//
	  Utility.implicitlyWait(driver, 1000);
	  signIn.enterMobileNumberField(Utility.readDataFromExcelSheet(driver, 0, 0));
	  signIn.clickOnHomePageSignInButton();
	  Utility.implicitlyWait(driver, 1000);
	  password.enterPasswordfield(Utility.readDataFromExcelSheet(driver, 0, 1));
	  password.clickingOnSubmitButton();
	  Utility.implicitlyWait(driver, 1000);
	 
	  dash.handlePopUp(driver);
	  
  }
  @Test
  public void ValidateUserNameOfNeoStox() throws IOException 
  {
	  Assert.assertEquals(dash.getActualUserName(),Utility.readDataFromPropertyFile("UserName"), "Actual User Name and Expected User Name is Not Matching,TC is failed  ");
  }
  @Test
  public void ValidateAccountBalOfNeoStox() throws IOException 
  {
	  Assert.assertNotNull(dash.getBalanceInfo(),"Acual balance is not Matching with Expected Balance, Tc is Failed");
      Utility.takeScreenShot(driver,"ScreenShotName");
  }
  @AfterMethod
  public void logOutFromNeoStoxApp() throws InterruptedException
  {
	dash.logOutFromNeoStox();  
  }
  @AfterClass
  public void closeBrowser() throws EncryptedDocumentException, IOException
  {
	  driver.quit();
	  Reporter.log("Closing Browser",true);
  }
  
}
