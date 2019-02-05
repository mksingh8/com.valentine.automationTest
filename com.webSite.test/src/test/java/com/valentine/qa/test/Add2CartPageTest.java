package com.valentine.qa.test;

import org.testng.annotations.BeforeMethod;
import com.valentine.qa.base.TestBase;
import com.valentine.qa.pages.HomePage;

public class Add2CartPageTest extends TestBase{
	
	public Add2CartPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		browserSetup();
		HomePage homePage = new HomePage();
		homePage.validateAdd2Cart();
	}

}
