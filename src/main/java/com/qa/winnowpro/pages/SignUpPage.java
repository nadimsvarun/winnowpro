package com.qa.winnowpro.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.winnowpro.util.Elementutil;

public class SignUpPage {
	
	private WebDriver driver;
	
	
	private By Paratext = By.cssSelector("div>h2+p");
	private By fullname = By.cssSelector("form>div:nth-child(1)>mat-form-field>div>div:nth-child(1)>div>input");
	
	Elementutil eutil;
	public SignUpPage(WebDriver driver) {
		
		this.driver=driver;
		eutil = new Elementutil(driver);
		
	}
	
	public String checkparatext() {
		
		return eutil.getelementtext(Paratext, 5);
		
	}
	
	public void enterfirstandlastname(String fname, String lname) {
		
		List<WebElement> els = eutil.findelements(fullname);
		eutil.entertext(els.get(0), fname);
		eutil.entertext(els.get(1), lname);
	}

}
