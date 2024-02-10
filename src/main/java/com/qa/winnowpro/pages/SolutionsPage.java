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


public class SolutionsPage {
	
	private WebDriver driver;
	

 private By letstalk = By.cssSelector("div.main-section>div:nth-child(1)>div>div:nth-child(1)>a");
 private By painpoints = By.cssSelector("div.main-section>div:nth-child(5)>div>div:nth-child(6)>div>a>h3");
 private By clickhomepage = By.cssSelector("div.new-header>div>div:nth-child(1)>a");
 private By painpointsheader = By.cssSelector("div.main-section>div:nth-child(5)>div>h3:nth-child(4)");	
 
 
 public SolutionsPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
		this.driver = driver;
		
	}
	
	
	public boolean checkletstalkbtn() {
		
		return driver.findElement(letstalk).isEnabled();
	}
	
	
	public List<String> checkpainpointstext() {
		
		List<WebElement> list = driver.findElements(painpoints);
		System.out.println("size="+list.size());
		
		List<String> s = new ArrayList<String>();
		for(WebElement i : list) {
			s.add(i.getAttribute("innerText"));
		}
		
		return s;
		
	}
	
	
	public void gotohomepage() {
		
		driver.findElement(clickhomepage).click();
	}
	
	public void movetopainpointsheader() {
		
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(painpointsheader)).perform();
	}
	

}
