package com.qa.winnowpro.tests;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.winnowpro.base.BaseTest;

public class LandingPageTest extends BaseTest{
	
	@Test
	public void getpagetitletest() {
		
		String title = lp.getpagetitle();
		Assert.assertEquals(title ,"WinnowPro | Digitally Essential for B2C Businesses");
		
		
	}
	
	@Test
	public void loginpageurltest() {
		
		String acturl = lp.getloginpageurl();
		Assert.assertTrue(acturl.contains("https://fprod.winnowpro.com/"));
		
	}
	
	@Test
	public void checkindustries() {
		
	 List<WebElement> industries = lp.checkindustries();
	 Assert.assertTrue(industries.size()==3);
	}
	
	
	@Test
	public void fillletstalkform() {
		
		lp.scrolltoelement();
		
		lp.enterdatainform("james", "test", "james@yop.com");
	}
	
	

}
