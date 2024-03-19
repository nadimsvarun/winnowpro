package com.qa.winnowpro.driver;

import java.util.Properties;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class OptionsManager {
	
	private Properties Prop;
	private ChromeOptions co;
	private FirefoxOptions fo;
	private EdgeOptions eo;
	
	
	public OptionsManager(Properties prop) {
		
		this.Prop = prop;
		
	}
	
	
	public ChromeOptions getChromeOptions() {
		
		co = new ChromeOptions();
		
		if(Boolean.parseBoolean(Prop.getProperty("headless").trim())){
			
			co.addArguments("--headless=new");
		}
		
		if(Boolean.parseBoolean(Prop.getProperty("incognito").trim())) {
			
			co.addArguments("--incognito");
		}
		
		return co;
		
	}
	
	
     public FirefoxOptions getFirefoxOptions() {
		
		fo = new FirefoxOptions();
		
		if(Boolean.parseBoolean(Prop.getProperty("headless").trim())){
			
			fo.addArguments("--headless");
		}
		
		if(Boolean.parseBoolean(Prop.getProperty("incognito").trim())) {
			
			fo.addArguments("--incognito");
		}
		
		return fo;
		
		
	}
     
     
     public EdgeOptions getEdgeOptions() {
 		
 		eo = new EdgeOptions();
 		
 		if(Boolean.parseBoolean(Prop.getProperty("headless").trim())){
 			
 			eo.addArguments("--headless");
 		}
 		
 		if(Boolean.parseBoolean(Prop.getProperty("incognito").trim())) {
 			
 			eo.addArguments("--incognito");
 		}
 		
 		return eo;
 		
 		
 	}

}
