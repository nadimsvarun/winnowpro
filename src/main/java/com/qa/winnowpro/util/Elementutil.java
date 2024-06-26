package com.qa.winnowpro.util;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Elementutil {
	
	WebDriver driver;
	public Elementutil(WebDriver driver) {
		
		
		this.driver=driver;
		
		
		
		
	}
	
	
	
	////fetch element////
	
	
	public WebElement findelement(By locator) {
		
		return driver.findElement(locator);
	}
	
	
	public List<WebElement> findelements(By locator) {
		
		return driver.findElements(locator);
		
	}
	
	
	public WebElement findelement(By locator, int timeout) {
		
		return waitforvisibilityofelement(locator, timeout);
	}
	
	
	public List<WebElement> findelements(By locator, int timeout) {
		
		return waitforvisibilityofallelements(locator, timeout);
	}
	
	public boolean elementenabled(By locator) {
		
		return findelement(locator).isEnabled();
		
	}
	
	//select tag
	
	public void clickonselectandchoose(By locator, String ele) {
		
		Select sel = new Select(findelement(locator));
		
		sel.selectByVisibleText(ele);
		
		
	}
	 //select check box/ radio btn  by text
	
	public void selectbytext(By element ,String attr, String text) {
		
		  List<WebElement> ele = findelements(element);
		  for(WebElement el :ele) {
			
			String txt = el.getAttribute(attr);
			System.out.println(txt);
			if(txt.equalsIgnoreCase(text)){
				
				
				 el.click();
						
				
			}
		}
	}
	
	//element visible
	
	public boolean iselementvisible(By element) {
		
		 return driver.findElement(element).isDisplayed();
	}
	
	
	////enter text
	
	
	public void entertext(By locator, String value) {
		
		WebElement element = findelement(locator);
		element.clear();
		element.sendKeys(value);
		
	}
	
     public void entertext(WebElement ele, String value) {
		
		ele.clear();
		ele.sendKeys(value);
		
	}
	
	
	///Get Text
	
	public String getelementtext(By locator, int timeout) {
		
		return  waitforvisibilityofelement(locator, timeout).getText();
	}
	
	
	public List<String> getelementstext(By locator, int timeout) {
		
		List<WebElement> list = waitforvisibilityofallelements(locator, timeout);
		List<String> text = new ArrayList<String>();
		for(WebElement x : list) {
			
			text.add(x.getText());
		}
		
		return text;
		
	}
	
   public List<String> getelementsinnertext(By locator, int timeout){
	
	   
	   List<WebElement> list = waitforvisibilityofallelements(locator, timeout);
		List<String> text = new ArrayList<String>();
		for(WebElement x : list) {
			
			text.add(x.getAttribute("innnerText"));
		}
	   
	   
	   
	   return text;
	   
	   
   }
	
	//Actions
	
	public void doActionssendkeys(WebDriver driver, By locator, String value) {
		
		Actions act = new Actions(driver);
		act.sendKeys(findelement(locator),value).build().perform();
	}
	
	public void doActionsclick(WebDriver driver,By locator) {
		
		Actions act = new Actions(driver);
		act.click(findelement(locator)).build().perform();
		
		
	}
	
	public void navigatetoelement(By form, WebDriver driver) {
		Actions act = new Actions(driver);
		act.moveToElement(findelement(form)).build().perform();
		
	}
	
	
	

	
	///click
	
	  public void clickonelement(By ele) {
		  
		  
		  findelement(ele).click();
		  
		  
		  
	  }
	
	
	/////wait/////
	
	
	public List<WebElement> waitforvisibilityofallelements(By locator, int timeout) {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
	     return  wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
		
		
	}
	
	public WebElement waitforvisibilityofelement(By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
         return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		
	}

    
	//javascript
	
	 public void movetoelementjs(By by, WebDriver driver) {
		 
		 JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(false);", findelement(by));		 
		 
	 }
	 

	

}
