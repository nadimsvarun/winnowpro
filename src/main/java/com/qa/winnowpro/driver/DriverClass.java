package com.qa.winnowpro.driver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverClass {
	
	public static WebDriver driver;
	public  Properties prop;
	
	public WebDriver initializeDriver(Properties prop2) {
		
		OptionsManager opt = new OptionsManager(prop2);
		
		//System.out.println("browser name is"+prop2);
		String browser = prop2.getProperty("browser").trim().toLowerCase();
		
		if(browser.equals("chrome")) {
			
			driver = new ChromeDriver(opt.getChromeOptions());
		}
		else if(browser.equals("edge")) {
			
			driver = new EdgeDriver(opt.getEdgeOptions());
		}
       else if(browser.equals("firefox")) {
			
			driver = new FirefoxDriver(opt.getFirefoxOptions());
		}
	else {
		
		System.out.println("please pass the right browser");
	}
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		System.out.println(prop2.getProperty("url"));
		driver.get(prop2.getProperty("url"));
		return driver;
	}
	
	public static WebDriver getdriver() {
		
		return driver;
	}
	
	public Properties initprop() {
		
		prop = new Properties();
		FileInputStream fil;
		try {
			fil = new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/Config/config.properties");
			//fil = new FileInputStream(".\\src\\test\\resources\\Config\\config.properties");
		
			prop.load(fil);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop;
	    
	

	}
}
