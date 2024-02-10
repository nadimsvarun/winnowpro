package com.qa.winnowpro.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactUsPage {
	
	WebDriver driver;
	
	
	private By bookmeet = By.cssSelector("a#calendlyContactUs");
	private By phoneno = By.cssSelector("form>input[name='PhoneNumber']");
	private By website = By.cssSelector("form>input[name='Website-URL']");
	
	public ContactUsPage(WebDriver driver) {
		
		this.driver = driver;
	}
	
	

}
