package pojo;

import java.io.File;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v142.page.model.Screenshot;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;
import pom.ApplicationHeaderPage;

import pom.LoginPage;

import properties.ReadConfigFile;
import utilities.ScreenShot;


public class Base {
	public static String testID ;
	public WebDriver driver;
	public LoginPage loginpage;
	public ReadConfigFile configFile;
	
	public ApplicationHeaderPage appPage ;
	public org.apache.logging.log4j.Logger logger ;
	//public static ExtentTest test;
	//public static ExtentHtmlReporter reporter;
	@BeforeClass(groups ={"Regression","Sanity","Master"})
	public void lounchBrowser() throws IOException, InterruptedException
	{
		logger=LogManager.getLogger(this .getClass());	

		System.out.println("Luanch Browser");
		
		//WebDriverManager.chromedriver().setup();
		
		   // driver= new ChromeDriver();
			logger.info("***-----Chrome browser and url launched ------***");
			 

	}
	@BeforeMethod(groups ={"Regression","Sanity","Master"})
	public void createObject() throws IOException, InterruptedException
	{
        System.out.println("Luanch Browser");
		
		WebDriverManager.chromedriver().setup();
		//reporter = new ExtentHtmlReporter("test-output"+File.separator+"ExtentReport"+File.separator+"Extent.html");
		//ExtentReports extend = new ExtentReports();
		//extend.attachReporter(reporter);
		driver= new ChromeDriver();
		configFile = new ReadConfigFile();
		driver.get(configFile.getUrl()); 
		
		driver.manage().window().maximize();
		Thread.sleep(3000);
	
		System.out.println("Creat POM Object");
	    loginpage = new LoginPage(driver);
	    appPage= new ApplicationHeaderPage(driver);
	  
	    System.out.println("Login to application");
		Thread.sleep(1000);
		WebElement lg =loginpage.sendUserName();
		lg.sendKeys(configFile.getUserName());
		
		Thread.sleep(1000);
		WebElement ps =loginpage.sendPassword();
		ps.sendKeys(configFile.getPassword());
		
		loginpage.clickOnCheckBox();
		
		loginpage.clickOnLogin();
		logger.info("***-----Created Pom Object ------***");

	}
	@AfterMethod(groups ={"Regression","Sanity","Master"})
	public void clearObject(ITestResult result) throws InterruptedException, IOException
	{
		
		System.out.println("-----Null POM Object------------");
		//loginpage =null;
		if(ITestResult.FAILURE==result.getStatus())
        {
		ScreenShot.getScreenShot(driver, testID);
        }	
		driver.close();
		logger.info("***---- Null Pom Object ------***");

		
	}
	@AfterClass(groups ={"Regression","Sanity","Master"})
	public void closeBrowser()
	{
		System.out.println("Close Browser and Clear Unwanted objectes");
		
		driver =null;
		System.gc();
		logger.info("***-----Successfully Executed testScript for create New TaskPage ------***");

   }
}
