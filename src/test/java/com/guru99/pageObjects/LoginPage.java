package com.guru99.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public WebDriver driver;
	
  public LoginPage(WebDriver driver)
  {
	  
	  this.driver=driver;
	  
	  PageFactory.initElements(driver, this);
	  
	  
  }
  
  @FindBy(name="uid")
  @CacheLookup
  WebElement txtUserId;
	
  @FindBy(name="password")
  @CacheLookup
  WebElement txtPassword;
  
  @FindBy(xpath="//a[text()='Log out']")  
  WebElement clickLogout;
	
  @FindBy(name="btnLogin")  
  WebElement btnSubmit;
  
  
  public void setUserId(String uname)
  {
	  
	  txtUserId.clear();
	  txtUserId.sendKeys(uname);
	  
	  
  }
  
  public void setPassword(String password)
  {
	  txtPassword.clear();
	  txtPassword.sendKeys(password);	  
	  
  }
  
  public void loginSubmit()
  {
	  btnSubmit.click();
	  
	  
  }
  
  public void logOut()
  {
	  clickLogout.click();
	  
	  
  }
  
	

}
