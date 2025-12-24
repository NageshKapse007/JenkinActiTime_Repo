package properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadConfigFile {

	Properties properties ;
	String path ="D:\\JenkinsActi-time\\src\\main\\java\\properties\\Config.properties";
	

	public ReadConfigFile() throws IOException {
		properties = new Properties();

		try {
			FileInputStream fis = new FileInputStream(path);
			properties.load(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public String getUserName()
	{
		String user =properties.getProperty("userName");
		return user;
		
	}
	public String getPassword()
	{
		String pass = properties.getProperty("password");
		
		return pass;
	}
	public String getUrl()
	{
		String url = properties.getProperty("url");
		return url;
	}
	
}
