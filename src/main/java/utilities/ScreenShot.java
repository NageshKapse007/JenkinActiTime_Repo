package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenShot {
	public static void getScreenShot(WebDriver driver , String testID) throws InterruptedException, IOException
	{
		for(int i =0 ;i<2;i++)
		{
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-YYYY hh-mm-ss");
			
			Date date = new Date();
			System.out.println(date);
			
			String d = sdf.format(date);
			System.out.println(d);
			
			File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			
			File dest = new File("D:\\ActiTime\\ScreenShot\\"+" "+testID+""+d+".png");
			Thread.sleep(1000);
			
			 FileHandler.copy(source, dest);
		}
	}
}
