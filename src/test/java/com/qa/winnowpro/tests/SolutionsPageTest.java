package com.qa.winnowpro.tests;


import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.winnowpro.base.BaseTest;

public class SolutionsPageTest extends BaseTest{
	
	@BeforeClass
	public void solutionpagesetup() {
		
		sp = lp.clickonsolution();
	}
	
	
	
	@Test
    public void checksolutionbtn() {
		
		boolean btn = sp.checkletstalkbtn();
		Assert.assertTrue(btn);
	}
	
	@Test
	public void checkpainpoints() throws InterruptedException {
		
		sp.movetopainpointsheader();
		Thread.sleep(3000);
		List<String> pp = sp.checkpainpointstext();
		Assert.assertTrue((pp.get(0)).contains("LEAD QUALITY"));
		
	}
	
	@Test
	public void clickonhomepagelogo() {
		
		sp.gotohomepage();
	}

}
