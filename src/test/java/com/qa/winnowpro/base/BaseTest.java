package com.qa.winnowpro.base;


import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.winnowpro.driver.DriverClass;
import com.qa.winnowpro.pages.ContactUsPage;
import com.qa.winnowpro.pages.LandingPage;
import com.qa.winnowpro.pages.SolutionsPage;

public class BaseTest {

	
	DriverClass dc;
	WebDriver driver;
	protected LandingPage lp;
	protected SolutionsPage sp;
	protected ContactUsPage cp;
	Properties prop;

	
	@BeforeTest
	public void setup() {
		
		dc = new DriverClass();
		prop = dc.initprop();
		driver = dc.initializeDriver(prop);
		lp=new LandingPage(driver);
	}
	
	@AfterTest
	public void teardown() {
		
		driver.quit();
	}
}
