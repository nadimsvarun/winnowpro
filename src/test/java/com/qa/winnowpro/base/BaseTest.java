package com.qa.winnowpro.base;


import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.qa.winnowpro.driver.DriverClass;
import com.qa.winnowpro.listeners.ExtentManager;
import com.qa.winnowpro.pages.ContactUsPage;
import com.qa.winnowpro.pages.LandingPage;
import com.qa.winnowpro.pages.SignUpPage;
import com.qa.winnowpro.pages.SolutionsPage;

public class BaseTest {

	
	DriverClass dc;
	WebDriver driver;
	protected LandingPage lp;
	protected SolutionsPage sp;
	protected ContactUsPage cp;
	protected SignUpPage signup;
	Properties prop;
	

	@Parameters({"browser"})
	@BeforeTest
	public void setup(String browser) {
		
		dc = new DriverClass();
		prop = dc.initprop();
		if(browser!=null) {
			
			prop.setProperty("browser", browser);
		}
		driver = dc.initializeDriver(prop);
		lp=new LandingPage(driver);
	}
	
	@AfterTest
	public void teardown() {
		
		driver.quit();
	}
}
