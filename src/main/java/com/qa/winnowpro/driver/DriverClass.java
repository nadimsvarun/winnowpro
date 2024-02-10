package com.qa.winnowpro.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverClass {
	
	public WebDriver driver;
	
	
	public WebDriver initializeDriver(String browser) {
		
		System.out.println("browser name is"+browser);
		
		if(browser.trim().equalsIgnoreCase("chrome")) {
			
			driver = new ChromeDriver();
		}
		else if(browser.trim().equalsIgnoreCase("edge")) {
			
			driver = new EdgeDriver();
		}
       else if(browser.trim().equalsIgnoreCase("firefox")) {
			
			driver = new FirefoxDriver();
		}
	else {
		
		System.out.println("please pass the right browser");
	}
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://ftest.winnowpro.com/");
		return driver;
	}
	

}
