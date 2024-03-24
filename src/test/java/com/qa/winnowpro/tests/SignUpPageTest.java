package com.qa.winnowpro.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.winnowpro.base.BaseTest;

public class SignUpPageTest extends BaseTest {
	
	
	@BeforeClass
	public void singuppagesetup() {
		
		signup = lp.clickonsignup();
	}
	
	
	@Test
	public void checkparatext() {
		
		String paratext = signup.checkparatext();
		System.out.println(paratext);
		
		Assert.assertEquals(paratext, "Become a WinnowPro client in 4 easy steps. Share some basic details to get started.");
	}
	
	
	@DataProvider
	public Object[][] userdata() {
		
		return new Object[][] {
			
			{"nadim","varun"}
			
		};
	}
	
	@Test(dataProvider="userdata")
	public void enterfirstandlastname(String fname, String lname) {
		
		signup.enterfirstandlastname(fname, lname);
	}
	
	

}
