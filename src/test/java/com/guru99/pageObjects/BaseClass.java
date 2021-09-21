package com.guru99.pageObjects;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.guru99.utilities.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	ReadConfig readConfig = new ReadConfig();

	public static WebDriver driver;
	public static Logger logger;
	public String BaseURL = readConfig.getApplicationURL();
	public String UserName = readConfig.getUsername();
	public String Password = readConfig.getPassword();

	@Parameters("browser")
	@BeforeClass
	public void setUp(String br) {

		logger = Logger.getLogger("Guru99Bank");
		PropertyConfigurator.configure("log4j.properties");

		if (br.equals("chrome")) {

		//	System.setProperty("webdriver.chrome.driver", readConfig.getChromePath());
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (br.equals("firefox")) {
	//		System.setProperty("webdriver.gecko.driver", readConfig.getFirefoxpath());
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get(BaseURL);
		logger.info("URL is opened");

	}

	@AfterClass
	public void tearDown() {

		driver.quit();

	}

	public void captureScreen(WebDriver driver, String tname) throws IOException {

		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png"));
		System.out.println("Screenshot taken");

	}

}
