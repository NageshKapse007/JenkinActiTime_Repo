package test;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pojo.Base;
import pom.ApplicationHeaderPage;
import pom.LoginPage;
import properties.ReadConfigFile;

public class VerifyApplicationHeaderPage extends Base 
  {

	
	

	@Test(priority=1 ,groups = "Sanity")
	public void verifyClickOnTimeTrack()
	{
		testID="AP001";
		System.out.println("Verify click on time track");
		appPage.clickOnTimeTrack();
		String expectedUrl ="http://localhost/user/submit_tt.do";
		String actualUrl=driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl);
		logger.info("***-----Successfully verified Click On TimeTrack ------***");

	}
	@Test(priority=2,groups = "Regression")
	public void verifyClickOnTask()
	{
		testID="AP002";
		System.out.println("Verify click on task");
		appPage.clickOnTask();
		String expectedUrl ="http://localhost/tasks/otasklist.do";
		String actualUrl=driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl);
		logger.info("***-----Successfully verified Click On Task ------***");

	}
	@Test(priority=3,groups = "Sanity")
	public void verifyClickOnReport()
	{
		testID="AP003";
		System.out.println("Verify click on report");
		appPage.clickOnReport();
		String expectedUrl ="http://localhost/reports/reports.do";
		String actualUrl=driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl);
		logger.info("***-----Successfully verified Click On Report ------***");

		
	}
	@Test(priority=4,groups = "Regression")
	public void verifyClickOnUser()
	{
		testID="AP004";
		System.out.println("Verify click on report");
		appPage.clickOnUsers();
		String expectedUrl ="http://localhost/administration/userlist.do";
		String actualUrl=driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl);
		logger.info("***-----Successfully verified Click On User ------***");

		
	}
	@Test(priority=5)
	public void verifyClickOnWorkSchedule()
	{
		testID="AP005";
		System.out.println("Verify click on workSchedule");
		appPage.clickOnWorkSchedule();
		String expectedUrl ="http://localhost/administration/workingdays.do";
		String actualUrl=driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl);
		logger.info("***-----Successfully verified Click On WorkSchedule ------***");

		
	}
	
}
