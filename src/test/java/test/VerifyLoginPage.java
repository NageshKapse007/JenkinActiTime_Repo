package test;

import java.io.File;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;
import pojo.Base;
import pom.LoginPage;
import properties.ReadConfigFile;

public class VerifyLoginPage  {


	WebDriver driver;
	LoginPage loginpage;
	ReadConfigFile configFile;
	public org.apache.logging.log4j.Logger logger ;
//	XLUtilityExcel utility ;
//	ApplicationHeaderPage appPage ;
	static ExtentTest test;
	static ExtentHtmlReporter reporter;
	@BeforeClass(groups ={"Regression","Sanity","Master"})
	public void lounchBrowser() throws IOException, InterruptedException
	{
		logger=LogManager.getLogger(this .getClass());	
		System.out.println("Luanch Browser");
		
		WebDriverManager.chromedriver().setup();
		// reporter = new ExtentHtmlReporter("test-output"+File.separator+"ExtentReport"+File.separator+"Extent.html");
		//	ExtentReports extend = new ExtentReports();
		//	extend.attachReporter(reporter);
		driver= new ChromeDriver();
		configFile = new ReadConfigFile();
	//	utility = new XLUtilityExcel();
		driver.get(configFile.getUrl()); 
		
		driver.manage().window().maximize();
		Thread.sleep(3000);
		logger.info("***-----Chrome browser and url launched ------***");
	}
	@BeforeMethod(groups ={"Regression","Sanity","Master"})
	public void createObject() throws IOException
	{
		System.out.println("Creat POM Object");
	    loginpage = new LoginPage(driver);
		logger.info("***-----Created Pom Object ------***");
	}
	
	@Test(priority = 1 ,groups="Sanity")
	public void verifyUrl()
	{
		System.out.println("Verify URL");
		String expectedUrl ="http://localhost/login.do";
		String actualUrl=driver.getCurrentUrl();
		
		if(actualUrl.equals(expectedUrl))
		{
			System.out.println("Both Url are same ");
		}
		else
		{
			System.out.println("Fail");
		}
		logger.info("***-----Successfully verified URL ------***");
	}
	
	@Test(priority = 2 ,groups="Regression")
	public void verifyTitle()
	{
		System.out.println("Verify Title");
		String expectedTitle ="actiTIME -  Login";
		String actualTitle =driver.getTitle();
		if(actualTitle.equals(expectedTitle))
		{
			System.out.println("Pass");
		}
		else
		{
			System.out.println("Fail");
		}
		logger.info("***-----Successfully verified Title ------***");
	}
	@Test(priority = 3 ,groups="Regression")
	public void verifyLoginPageTestCases() throws InterruptedException
	
	{
		
		System.out.println("Verify Login Page Test Cases");
	
			Thread.sleep(1000);
		WebElement lg =loginpage.sendUserName();
		lg.sendKeys(configFile.getUserName());
		
			Thread.sleep(1000);
		WebElement ps =loginpage.sendPassword();
		ps.sendKeys(configFile.getPassword());
		
		
		try
		{
			Thread.sleep(2000);
			loginpage.clickOnCheckBox();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		try
		{
			Thread.sleep(2000);
		  boolean result =loginpage.checkText();
		  if(result == true)
			{
				System.out.println("Keep me log In text is displayed");
			}
			else
			{
				System.out.println("Keep me log in text is not displayed");
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		try
		{
			Thread.sleep(2000);
		  loginpage.clickOnLogin();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		logger.info("***-----Successfully verified LoginPage test case with valid passwaord and username ------***");

	}

	
	@AfterMethod(groups ={"Regression","Sanity","Master"})
	public void clearObject()
	{
		//appPage.clickOnLogout();
		System.out.println("-----Null POM Object------------");
		loginpage =null;
		logger.info("***---- Null Pom Object ------***");

		
	}
	@AfterClass(groups ={"Regression","Sanity","Master"})
	public void closeBrowser()
	{
		System.out.println("Close Browser and Clear Unwanted objectes");
		driver.close();
		driver =null;
		System.gc();
		logger.info("***-----Successfully Executed testScript for login page ------***");

   }
		
		
}
