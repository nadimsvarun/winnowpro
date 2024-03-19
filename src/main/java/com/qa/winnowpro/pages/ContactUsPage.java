package com.qa.winnowpro.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.winnowpro.constant.Constant;
import com.qa.winnowpro.util.Elementutil;

public class ContactUsPage {
	
	WebDriver driver;
	Elementutil eutil;
	
	
	private By bookmeet = By.cssSelector("a#calendlyContactUs");
	
	private By flnames = By.xpath("//form/div//div/input");
	
	private By emailnourl = By.xpath("//form/select/preceding-sibling::input");
	
	private By seldropdown = By.cssSelector("select#MonthlyAdvertisingSpend");
	
	private By selchannel = By.xpath("//form/div[2]//div//label/input");
	
	private By selmanager = By.xpath("//form/div[3]//div/div/label/input");
	
	
	public ContactUsPage(WebDriver driver) {
		
		this.driver = driver;
		eutil = new Elementutil(driver);
	}
	
	
	public List<WebElement> enterfandlname() {
		
		return eutil.findelements(flnames, Constant.MID_TIMEOUT);
		
	}
	
	public List<WebElement> enteremailnourl() {
		
		return eutil.findelements(emailnourl, Constant.MID_TIMEOUT);
	}
	
	
	public void clickondropdownandselecttext() {
		
		eutil.clickonselectandchoose(seldropdown, "$2,500 - $5,000");
	}
	
	
	public void selectchannel() {
		
		eutil.selectbytext(selchannel, "name", "Google");
	}
	
	
	public boolean isbookmeetenabled() {
		
		return eutil.elementenabled(bookmeet);
	}

}
