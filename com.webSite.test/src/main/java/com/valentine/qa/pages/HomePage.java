package com.valentine.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.valentine.qa.base.TestBase;

public class HomePage extends TestBase{
	
	//define Page Factory
	
	@FindBy(xpath="//img[@id='logo']")
	WebElement homePagelogo;
	
	@FindBy(xpath="//*[@id='top-menu']/li[1]/a")
	WebElement headerHomeBtn;
	@FindBy(xpath="//*[@id='top-menu']/li[2]/a")
	WebElement headerCodeBtn;
	@FindBy(xpath="//*[@id='top-menu']/li[3]/a")
	WebElement headerContactUsBtn;
	@FindBy(xpath="//*[@id='top-menu']/li[4]/a")
	WebElement headerPurchaseFormBtn;
	@FindBy(xpath="//*[@id='top-menu']/li[5]/a")
	WebElement headerStoreBtn;
	
	@FindBy(xpath="//*[@id='searchinput']")
	WebElement searchBox;
	@FindBy(xpath="//h1[@class='category-title']//text()")
	WebElement searchResult;
	
	@FindBy(xpath="//*[@id='secondary-menu']/li[1]/a")
	WebElement homeBtn;
	@FindBy(xpath="//*[@id='secondary-menu']/li[2]/a")
	WebElement codeBtn;
	@FindBy(xpath="//*[@id='secondary-menu']/li[3]/a")
	WebElement contactUsBtn;
	@FindBy(xpath="//*[@id='secondary-menu']/li[4]/a")
	WebElement purchaseFormBtn;
	@FindBy(xpath="//*[@id='secondary-menu']/li[5]/a")
	WebElement storeBtn;
	
	@FindBy(xpath="//a[contains(text(),'Dima Kovalenko')]")
	WebElement copyRight;
	//*[@id="copyright"]/a
	
	@FindBy(xpath="//div[@id='special-items']//img")
	List<WebElement> specialItemImageList;
	
	@FindBy(xpath="//*[@id='special-items']/div[1]/h4/a")
	WebElement spclOfr1stItem;
		
	//Initializing the Page Object
	public HomePage() {
		PageFactory.initElements(driver, this);
		
	}
	
	//Actions
	public String validateHomePageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateValentineLogo() {
		return homePagelogo.isDisplayed();
	}

	public boolean validateCopyRightOwner() {
		return copyRight.isDisplayed();
	}
	
	public CodePage validateHeaderCodeBtnClick() {
		headerCodeBtn.click();
		return new CodePage();
	}
	
	public ContactusPage validateHeaderContactUsBtnClick() {
		headerCodeBtn.click();
		return new ContactusPage();
	}
	
	public PurchaseformsPage validateHeaderPurchaseFormBtnClick() {
		headerCodeBtn.click();
		return new PurchaseformsPage();
	}
	
	public HomePage validateHeaderHomeBtnClick() {
		headerCodeBtn.click();
		return new HomePage();
	}
	
	public boolean validateSeachBox() {
		searchBox.sendKeys("closeness");
		searchBox.sendKeys(Keys.RETURN);
		return searchResult.isDisplayed();
	}
	
	public void validateSpecialitemList(String itemName) {
		
		for(WebElement spItem : specialItemImageList) {
			//spItem.click();
			spItem.getText();	
		}
	}
	
	//public Add2CartPage validateAdd2Cart(String itemName) {
	public Add2CartPage validateAdd2Cart() {
		//WebElement firstItem = driver.findElement(By.xpath("//div[@class='special-item']//h4//a[text()='"+itemName+"']"));
		//Closeness and Togetherness
		
		spclOfr1stItem.click();
		return new Add2CartPage();
		
	}
	
	
}
