package com.valentine.qa.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.valentine.qa.base.TestBase;
import com.valentine.qa.pages.CodePage;
import com.valentine.qa.pages.HomePage;

public class HomePageTest extends TestBase{
	HomePage homePage;
	CodePage codePage;
	
	//Initialize the parent class so that the properties are initialized.
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		browserSetup();
		homePage = new HomePage();
	}
	
	@Test(priority=0)
	public void homePageTitleTest() {
		String homeTitle = homePage.validateHomePageTitle();
		Assert.assertEquals(homeTitle, "Valentine's Day Cards | Please your loved ones with a card this year!!");
	}
	
	@Test(priority=1)
	public void homePageLogoTest() {
		boolean logoDisaplyed = homePage.validateValentineLogo();
		Assert.assertTrue(logoDisaplyed);
	}
	
	@Test(priority=2)
	public void homePageHeaderCodeBtnClickTest() {
		codePage = homePage.validateHeaderCodeBtnClick();
		
	}
	
	@Test
	public void copyRightOwnerTest() {
		boolean isownerNameDisplayed = homePage.validateCopyRightOwner();
		Assert.assertTrue(isownerNameDisplayed);
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
