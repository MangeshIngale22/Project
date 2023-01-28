package neoStoxTestClasses;


import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import neoStoxPOMClasses.Utility;



public class Listener extends Base implements ITestListener 
{
	
	public void onTestSuccess(ITestResult result) 
	{
        Reporter.log("TC "+result.getName()+" is passed", true);
        

	}
	
	public void onTestFailure(ITestResult result) 
	{
		Reporter.log("TC "+result.getName()+" is Failed", true);
		
		try 
		{
			Utility.takeScreenShot(driver,result.getName());
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

}
