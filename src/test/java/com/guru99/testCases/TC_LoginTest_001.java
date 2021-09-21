package com.guru99.testCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.guru99.pageObjects.BaseClass;
import com.guru99.pageObjects.LoginPage;
import com.guru99.utilities.Util;

public class TC_LoginTest_001 extends BaseClass {
	
	String ActualTitle="";
	
	
	@Test
	public void loginTest() throws IOException
	{
		
		LoginPage lp = new LoginPage(driver);
		lp.setUserId(UserName);
		lp.setPassword(Password);
		lp.loginSubmit();
		
		
		
		ActualTitle=driver.getTitle();
		
		if(ActualTitle.contains(Util.EXPECTED_TITLE))
		{
			
			
			
			Assert.assertTrue(true);
			driver.manage().timeouts().implicitlyWait(Util.WAIT_TIME, TimeUnit.SECONDS);
			lp.logOut();
			
			
		}
		else
		{
			captureScreen(driver, "loginTest");
			Assert.assertTrue(false);
		}
		
		
		
		
		
		
	}

}
