package pom;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ApplicationHeaderPage {

	
	@FindBy (xpath="//div[text()='Time-Track']")
    private WebElement timeTrack;
	
	@FindBy (xpath="//div[text()='Tasks']")
    private WebElement tasks;
	
	
	
	@FindBy (xpath="//div[text()='Reports']")
	private WebElement report;
	
	@FindBy (xpath="//div[text()='Users']")
	private WebElement users;
	
	@FindBy (xpath="//div[text()='Work Schedule']")
	private WebElement workShcedule;
	
	//@FindBy (xpath="//a[@id='logoutLink']")
	//private WebElement logOut;
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	public ApplicationHeaderPage(WebDriver driver)
	{
		this.driver =driver;
		wait = new WebDriverWait(driver ,Duration.ofSeconds(0));
		PageFactory.initElements(driver ,this);
	}

	public void clickOnTimeTrack()
	{
		wait.until(ExpectedConditions.visibilityOf(timeTrack));
		
		timeTrack.click();
	}
	public void clickOnTask()
	{
		wait.until(ExpectedConditions.visibilityOf(tasks));
		
		tasks.click();
	}
	public void clickOnReport()
	{
		wait.until(ExpectedConditions.visibilityOf(report));
		report.click();
	}
	public void clickOnUsers()
	{
		wait.until(ExpectedConditions.visibilityOf(users));
		users.click();
	}
	public void clickOnWorkSchedule()
	{
		wait.until(ExpectedConditions.visibilityOf(workShcedule));
		workShcedule.click();
	}
	public void clickOnLogout()
	{
		//wait.until(ExpectedConditions.visibilityOf(logOut));
		WebElement logOut =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='logoutLink']")));
		logOut.click();
	}
}
