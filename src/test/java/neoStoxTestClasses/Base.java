package neoStoxTestClasses;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;

import neoStoxPOMClasses.Utility;



public class Base
{
	protected static WebDriver  driver;
	
	public void launchBrowser() throws IOException
	{
        System.setProperty("webdriver.driver.chrome","C:\\Eclipse\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(Utility.readDataFromPropertyFile("Url"));
		Utility.implicitlyWait(driver, 1000);
		driver.manage().window().maximize();
		Reporter.log("Launching Browser",true);
		
		
		
	}
	
	//Commend 1

}
