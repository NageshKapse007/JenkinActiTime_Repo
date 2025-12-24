package pom;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import properties.ReadConfigFile;


public class LoginPage {

	
	@FindBy (xpath=("//input[@id='username']"))
	private WebElement username;
	
	@FindBy(xpath=("//input[@name='pwd']"))
	private WebElement password;
	
	@FindBy(xpath="//input[@name='remember']")
	private WebElement checkBoxElement;
	
	@FindBy (xpath="//label[@id='keepLoggedInLabel']")
	private WebElement text;
	
	@FindBy(xpath="//div[text()='Login ']")
	private WebElement login;
	
	private WebDriver driver ;
	private WebDriverWait wait;
	private ReadConfigFile configFile ;
	
	public LoginPage(WebDriver driver) throws IOException 
	{
		this.driver = driver;
		configFile = new ReadConfigFile();
		PageFactory.initElements(driver, this);
		
		wait = new WebDriverWait(driver ,Duration.ofSeconds(20));
	}
	public  WebElement sendUserName()
	{
		wait.until(ExpectedConditions.visibilityOf(username));
		username.click();
		//username.sendKeys(user);
		return username;
	}
	public WebElement sendPassword()
	{
		wait.until(ExpectedConditions.visibilityOf(password));
		password.click();
		//password.sendKeys(configFile.getPassword());
		return password;
	}
	public void clickOnCheckBox()
	{
		wait.until(ExpectedConditions.visibilityOf(checkBoxElement));
		
		boolean result = checkBoxElement.isSelected();
		if(result == true)
		{
			System.out.println("Check Box Already Selected");
		}
		else 
		{
		checkBoxElement.click();
		}
	}
	public boolean checkText()
	{
		wait.until(ExpectedConditions.visibilityOf(text));
		
		boolean result = text.isDisplayed();
		
		
		return result;
	}
	
	public void clickOnLogin()
	{
		wait.until(ExpectedConditions.visibilityOf(login));
		login.click();
	}
}
