package com.valentine.qa.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.valentine.qa.base.TestBase;
import com.valentine.qa.pages.Add2CartPage;
import com.valentine.qa.pages.HomePage;
import com.valentine.qa.utils.TestUtils;

public class Add2CartPageTest extends TestBase{
	Add2CartPage add2CartPage;
	HomePage homePage;
	String shetName = "AddComment";
	
	public Add2CartPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		browserSetup();
		homePage = new HomePage();
		homePage.validateAdd2Cart();
		add2CartPage = new Add2CartPage();
	}
	
	@DataProvider
	public Object[][] getData() {
		return TestUtils.getTestData(shetName);
	}
	
	//same number of parameters have to be passed to match the number of columns inside the excel sheet
	@Test(dataProvider = "getData")
	public void validatesubmitBtnTest(String name, String email, String website, String rating, String comment) {
		add2CartPage.validateSubmitCommentBtn(name, email, website, rating, comment);
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
