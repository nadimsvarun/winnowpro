package com.qa.winnowpro.driver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DriverClass {
	
	public static WebDriver driver;
	public  Properties prop;
	public OptionsManager opt;
	
	public WebDriver initializeDriver(Properties prop2) {
		
		 opt = new OptionsManager(prop2);
		
		//System.out.println("browser name is"+prop2);
		String browser = prop2.getProperty("browser").trim().toLowerCase();
		
		//init_remotewebdriver(browser);
		if(browser.equals("chrome")) {
			
			if(Boolean.parseBoolean(prop.getProperty("remote"))){
					
				init_remotewebdriver(browser);
				
				
			}else {
			
			driver = new ChromeDriver(opt.getChromeOptions());
			
		}
		}
		else if(browser.equals("edge")) {
			
			if(Boolean.parseBoolean(prop.getProperty("remote"))){
				
				init_remotewebdriver(browser);
				
				
			}else {
			
			
			
			driver = new EdgeDriver(opt.getEdgeOptions());
		}
		}
       else if(browser.equals("firefox")) {
    	   
	       if(Boolean.parseBoolean(prop.getProperty("remote"))){
				
				init_remotewebdriver(browser);
				
				
			}else {
			
			
			
				driver = new FirefoxDriver(opt.getFirefoxOptions());
		}
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
	
	private void init_remotewebdriver(String browser) {
		// TODO Auto-generated method stub
		System.out.println("Running on Grid server");
		try {
		switch (browser) {
		case "chrome":
			
			
				driver = new RemoteWebDriver(new URL(prop.getProperty("huburl")),opt.getChromeOptions());
			     break;
			
		
		
        case "firefox":
			
			
				driver = new RemoteWebDriver(new URL(prop.getProperty("huburl")),opt.getFirefoxOptions());
			    break;
			
		
		
       case "edge":
			
				driver = new RemoteWebDriver(new URL(prop.getProperty("huburl")),opt.getEdgeOptions());
			    break;
		

		default:
			System.out.println("please provide correct browser");
			break;
			
		}
		}catch(MalformedURLException e) {
			
			e.printStackTrace();
		}
		
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
	
	
	public static String getScreenshot() {
		File srcFile = ((TakesScreenshot) getdriver()).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "/screenshot/" + System.currentTimeMillis() + ".png";
		File destination = new File(path);
		try {
			FileHandler.copy(srcFile, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;
		
		
	}
}
