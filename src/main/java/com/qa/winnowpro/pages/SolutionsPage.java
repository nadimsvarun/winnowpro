package com.qa.winnowpro.pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.winnowpro.constant.Constant;
import com.qa.winnowpro.util.Elementutil;


public class SolutionsPage {
	
	private WebDriver driver;
	Elementutil eutil;

 private By letstalk = By.cssSelector("div.main-section>div:nth-child(1)>div>div:nth-child(1)>a");
 private By painpoints = By.xpath("//h3[contains(text(),'select your pain points')]/following-sibling::div[2]//div/a/h3");
 private By clickhomepage = By.cssSelector("div.new-header>div>div:nth-child(1)>a");
 private By painpointsheader = By.xpath("//h3[contains(text(),'select your pain points')]");
 
 public SolutionsPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
		this.driver = driver;
		eutil = new Elementutil(driver);
		
	}
	
	
	public boolean checkletstalkbtn() {
		
		
		 return eutil.elementenabled(letstalk);
		
		
		
	}
	
	
	public List<String> checkpainpointstext() {
		
		List<WebElement> list = eutil.findelements(painpoints);
		List<String> text = new ArrayList<String>();
		for(WebElement x : list) {
			
			System.out.println(x.getAttribute("innerHTML"));
			text.add(x.getAttribute("innerHTML"));
		}
	   
	   
	   System.out.println(text.size());
	   return text;
		
		//return eutil.getelementsinnertext(painpoints, Constant.MAX_TIMEOUT);
		
		
		
	}
	
	
	public void gotohomepage() {
		
		eutil.clickonelement(clickhomepage);
		
		
	}
	
	public void movetopainpointsheader() {
		
		//eutil.navigatetoelement(painpointsheader, driver);
		eutil.movetoelementjs(painpointsheader, driver);
		
	}
	

}
