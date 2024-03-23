package com.qa.winnowpro.listeners;

import java.io.File;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.io.FileHandler;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.qa.winnowpro.driver.DriverClass;



public class ExtentManager {
	
	
	
	public static  ExtentSparkReporter sparkreporter;
	public static ExtentReports extentreport;
	public ExtentTest test;
	
	private static final String OUTPUT_FOLDER = System.getProperty("user.dir")+"/reports/";
	private static final String FILE_NAME = "TestExecutionReport.html";
	
	public static ExtentReports createinstance() {
		
		//"./reports/extent.html
		
		Path path = Paths.get(OUTPUT_FOLDER);
		// if directory exists?
		if (!Files.exists(path)) {
			try {
				Files.createDirectories(path);
			} catch (IOException e) {
				// fail to create directory
				e.printStackTrace();
			}
		}
		
		sparkreporter = new ExtentSparkReporter(OUTPUT_FOLDER + FILE_NAME);
		sparkreporter.config().setEncoding("uft-8");
		sparkreporter.config().setDocumentTitle("Automation Report");
		sparkreporter.config().setReportName("Test Results");
		sparkreporter.config().setTheme(Theme.STANDARD);
		
		extentreport = new ExtentReports();
		extentreport.attachReporter(sparkreporter);
		
		extentreport.setSystemInfo("Automation Tester", "varun");
		extentreport.setSystemInfo("Organisation", "Myorg");
		extentreport.setSystemInfo("Build Number", "Report-1");
		
		return extentreport;
		
	}
	
	public static String screenshotpath;
	
	
	public static String takescreenshot() {
		
	File scrFile = null ;
	
				try {
					scrFile = ((TakesScreenshot) DriverClass.getdriver()).getScreenshotAs(OutputType.FILE);
				} catch (Exception e) {
					// TODO Auto-generated catch block
				}

		Date d = new Date();
		screenshotpath = System.getProperty("user.dir")+"/screenshot/"+System.currentTimeMillis()+".png";
		File destination = new File(screenshotpath);

		try {
			FileHandler.copy(scrFile, destination);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return screenshotpath;
	}
	
	

}
