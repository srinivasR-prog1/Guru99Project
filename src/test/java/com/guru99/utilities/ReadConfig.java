package com.guru99.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	Properties prop;
	
	public ReadConfig()
	{
		
		
		
		
		File src = new File("./Configuration\\config.properties");
		
		
		try{
			
			
			
			FileInputStream fis = new FileInputStream(src);
			
			prop= new Properties();
			
			prop.load(fis);
			
			
		}catch(Exception e){
			
			
			System.out.println("Exception is "+e.getMessage());
			
			
			
			
		}
		
		
		
	}
	
	public String getApplicationURL()
	
	{
		
	String url=	prop.getProperty("BaseURL");
	return url;
		
		
		
	}
public String getUsername()
	
	{
		
	String urName=	prop.getProperty("UserName");
	return urName;
		
		
		
	}
public String getPassword()

{
	
String password=	prop.getProperty("Password");
return password;
	
	
	
}
public String getChromePath()

{
	
String chroPath=	prop.getProperty("chromepath");
return chroPath;
	
	
	
}
public String getFirefoxpath()

{
	
String firePath=	prop.getProperty("firefoxpath");
return firePath;
	
	
	
}
	
	
	

}
