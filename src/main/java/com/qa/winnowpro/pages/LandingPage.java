package com.qa.winnowpro.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.winnowpro.constant.Constant;
import com.qa.winnowpro.util.Elementutil;

public class LandingPage {
	
	private WebDriver driver;
	
	
	//As per pom  
	//private by locators should be used
	

	
	private By industries = By.cssSelector("div.main-section>div:nth-child(1)>div>div>div>div>a>h3");
	
	private By btnautosolution = By.cssSelector("div.main-section>div:nth-child(4)>div>a");
	
	private By formname = By.cssSelector("div>input[name='First-Name']");
	
	private By formlname = By.cssSelector("div>input[name='Last-Name']");
	
	private By formemail = By.cssSelector("input[name='BusinessEmail']");
	
	private By formspend = By.cssSelector("select#Monthly-Advertising-Spend");
	
	private By solutionlink = By.cssSelector("div>nav>div:nth-child(1)>div>div>a");
	
	private By contactuslink = By.linkText("CONTACT US");
	
	private By form = By.cssSelector("form[name='wf-form-Home-Page-Contact-Form']");
	
	private By signup = By.cssSelector("a#register-button");
	// page constructor should be used
	//hello
	
	Elementutil eutil;
	public LandingPage(WebDriver driver) {
		
		this.driver=driver;
		eutil = new Elementutil(driver);
		
	}
	
	//page actions/methods should be written
	
	public String getpagetitle() {
		
		String title = driver.getTitle();
		System.out.println("title is="+title);
		return title;
	}
	
	public String getloginpageurl() {
		
		String url = driver.getCurrentUrl();
		System.out.println("login page url is"+url);
		return url;
	}
	
	public List<WebElement> checkindustries() {
		
		 return eutil.findelements(industries);
		
	}
	
	public void enterdatainform(String name,String lastname,String email) {
		
		   eutil.entertext(eutil.findelement(formname, Constant.MID_TIMEOUT),name);
		   eutil.entertext(formlname, lastname);
		   eutil.entertext(formemail, email);
		
		
	}
	
	public SolutionsPage clickonsolution() {
		
	
		eutil.clickonelement(solutionlink);
		
		return new SolutionsPage(driver);
	}
	
	public void scrolltoelement() {
		
		eutil.navigatetoelement(form, driver);
		
		
	}
	
	public ContactUsPage clickoncontactus() {
		
		
		eutil.clickonelement(contactuslink);
		
		return new ContactUsPage(driver);
	}
	
	public SignUpPage clickonsignup() {
		
		eutil.clickonelement(signup);
		return new SignUpPage(driver);
		
	}
	
	

}
