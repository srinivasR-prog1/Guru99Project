package com.guru99.testCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.guru99.pageObjects.BaseClass;
import com.guru99.pageObjects.LoginPage;
import com.guru99.utilities.Util;
import com.guru99.utilities.XLUtils;



public class TC_LoginDDT_002 extends BaseClass{
	
	@Test(dataProvider="LoginData")
	public void loginDDT(String user, String pwd)
	{
		
		LoginPage lp= new LoginPage(driver);
		lp.setUserId(user);
		logger.info("Username is Provided");
		lp.setPassword(pwd);
		logger.info("Password is Provided");
		lp.loginSubmit();
		
		driver.manage().timeouts().implicitlyWait(Util.WAIT_TIME, TimeUnit.SECONDS);
		
		if(isAlertPresent()==true)
		{
			
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			logger.info("Login Failed");
		}
		else
		{  
			Assert.assertTrue(true);
			logger.info("Login Passed");
			lp.logOut();
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			
			
			
		}
		
		
		
	}
	
	
	public boolean isAlertPresent()
	{
		
		try{
			
			driver.switchTo().alert();
			return true;
			
			
			
			
		}catch(NoAlertPresentException e)
		{
			
			System.out.println("Exception is :"+e.getMessage());
			
			return false;
			
			
		}
		
		
		
	}
	
	
	@DataProvider(name="LoginData")
	String[][] getData() throws IOException
	{
		String path=System.getProperty("user.dir")+"/src/test/java/com/guru99/testData/LoginData.xlsx";
		
		int rowCount=XLUtils.getRowCount(path, "loginData");
		int colCount=XLUtils.getCellCount(path, "loginData", 1);
		
		String logindata[][]= new String[rowCount][colCount];
		
		
		for(int i=1;i<=rowCount;i++)
		{
			
			for(int j=0;j<colCount;j++)
			{
				
				
			logindata[i-1][j]=	XLUtils.getCellData(path, "loginData", i, j);
				
				
				
			}
			
			
			
			
		}
		
		return logindata;
		
		
		
	}

}
