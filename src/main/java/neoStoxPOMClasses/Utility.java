package neoStoxPOMClasses;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.testng.Reporter;

import net.bytebuddy.utility.RandomString;

public class Utility
{
	//1.Reading Data From ExcelSheet
	
	public  static String readDataFromExcelSheet(WebDriver driver, int row,int cell) throws EncryptedDocumentException, IOException
	{
		File myFile = new File("C:\\Eclipse\\New Microsoft Excel Worksheet.xlsx");
		Sheet mySheet = WorkbookFactory.create(myFile).getSheet("Sheet4");
		String value = mySheet.getRow(row).getCell(cell).getStringCellValue();
		return value;
	}
	
	//2.Take ScreenShot
	public static void takeScreenShot(WebDriver driver,String myFileName) throws IOException
	{
		  File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		  String s =RandomString.make(2);
		  File destination = new File("C:\\Eclipse\\Screenshot\\"+myFileName+s+".png");
		  FileHandler.copy(source, destination);
		  Reporter.log("Taking ScreenShot",true);
		  Reporter.log("Screenshot taken and save at "+ destination, true);
	}
	
	//3.Scrolling into View
	
	public static void scrollIntoView(WebDriver driver, WebElement element)
	{
	    JavascriptExecutor js = (JavascriptExecutor)driver;
	    js.executeScript("arguments[0].scrollIntoView(true)", element);
	    Reporter.log("Scrolling Into View"+element.getText(), true);
	}
	
	//4 Implicitly Wait
	
	public static void implicitlyWait(WebDriver driver,int time)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(time));
		Reporter.log("Waiting for "+time+"ms", true);
	}
	
	//5.Property File
	public static String readDataFromPropertyFile(String key) throws IOException
	{
		//1.Creating an object of Property File
		Properties prop = new Properties();
		
		//2.FileInputStream
		FileInputStream myFile = new FileInputStream("C:\\Mangesh WorkSpace\\JavaProject\\src\\myProperty.properties");
		
		//3.Load File
		prop.load(myFile);
		
		//4.Read Data From File
		
		String value = prop.getProperty(key);
		Reporter.log("Reading Data From Property File", true);
		Reporter.log("Data is "+value, true);
		return value;
	}
	
	public  static String readDataFromExcelSheet1(WebDriver driver, int row,int cell) throws EncryptedDocumentException, IOException
	{
		File myFile = new File("C:\\Eclipse\\New Microsoft Excel Worksheet.xlsx");
		Sheet mySheet = WorkbookFactory.create(myFile).getSheet("Sheet4");
		String value = mySheet.getRow(row).getCell(cell).getStringCellValue();
		return value;
	}
	
	
	 
	

	
	

}
