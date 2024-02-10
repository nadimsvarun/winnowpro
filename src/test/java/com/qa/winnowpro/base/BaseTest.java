package com.qa.winnowpro.base;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.winnowpro.driver.DriverClass;
import com.qa.winnowpro.pages.LandingPage;
import com.qa.winnowpro.pages.SolutionsPage;

public class BaseTest {

	
	DriverClass dc;
	WebDriver driver;
	protected LandingPage lp;
	protected SolutionsPage sp;
	

	
	@BeforeTest
	public void setup() {
		
		dc = new DriverClass();
		driver = dc.initializeDriver("chrome");
		lp=new LandingPage(driver);
	}
	
	@AfterTest
	public void teardown() {
		
		driver.quit();
	}
}
