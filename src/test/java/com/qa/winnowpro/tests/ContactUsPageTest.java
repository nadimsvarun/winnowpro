package com.qa.winnowpro.tests;


import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.winnowpro.base.BaseTest;

public class ContactUsPageTest extends BaseTest {
	
	
	
	@BeforeClass
	public void contactuspagesetup() {
		
		cp = lp.clickoncontactus();
		
	}
	
	@DataProvider
	public Object[][] names() {
		
		return new Object[][] {
			
			{"varun","nadim"}
		};
		
	}
	
	@Test(dataProvider="names")
	public void enterfnameandlname(String fname, String lname) throws InterruptedException {
		
		List<WebElement> names = cp.enterfandlname();
		names.get(0).sendKeys(fname);
		names.get(1).sendKeys(lname);
		
	}
	
	@DataProvider
	public Object[][] cdetails(){
		
		return new Object[][] {
			
			
			{"varun@yopmail.com", "1111111111","url.com"}
		};
		
		
	}
	
	@Test(dataProvider="cdetails")
	public void enteremailnowebsite(String email, String phoneno , String url) {
		
		List<WebElement> details = cp.enteremailnourl();
		details.get(0).sendKeys(email);
		details.get(1).sendKeys(phoneno);
		details.get(2).sendKeys(url);
	}
	
	
	@Test
	public void selectspend() {
		
		cp.clickondropdownandselecttext();
		
	}
	
	@Test
	public void selectchannel() throws InterruptedException {
		
		cp.selectchannel();
		Thread.sleep(2000);
	}

}
