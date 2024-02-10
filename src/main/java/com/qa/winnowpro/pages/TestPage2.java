package com.qa.winnowpro.pages;

import org.openqa.selenium.By;

public class TestPage2 {
	
	By loc = By.id("order");
	By ploc = By.id("price");
	
	public void getorder() {
		
		System.out.println("get order");
	}
	
	public void getprice() {
		
		System.out.println("get price");
	}

}
