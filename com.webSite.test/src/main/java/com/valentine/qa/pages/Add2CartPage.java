package com.valentine.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.valentine.qa.base.TestBase;

public class Add2CartPage extends TestBase{
	
	@FindBy(xpath="//a[text()='Add To Cart']")
	WebElement addToCartBtn;
	
	@FindBy(xpath="//div[@id='et-slides-items']")
	WebElement magnifyImg;
	
	@FindBy(xpath="//*[@id='fancybox-img']")
	WebElement magnifiedImg;

	@FindBy(xpath="//a[@id='fancybox-close']")
	WebElement closemMgnifiedImg;
	
	@FindBy(xpath="//input[@id='author']")
	WebElement nameBox;
	
	@FindBy(xpath="//input[@id='email']")
	WebElement emailBox;
	
	@FindBy(xpath="//input[@id='url']")
	WebElement websiteBox;
	
	@FindBy(xpath="//textarea[@id='comment']")
	WebElement commentBox;
	
	//*[@id="comment"]

	@FindBy(xpath="//input[@id='submit']")
	WebElement sumitCommentBtn;
	
	
	@FindBy(xpath="//span[@class='star-rating-control']//a")
	List<WebElement> ratings;
	
	
	public Add2CartPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean validatemagnifyImage() {
		magnifyImg.click();
		return magnifiedImg.isDisplayed();
	}
	
	public boolean validatecloseMagnifiedImgFunctionality() {
		magnifyImg.click();
		magnifiedImg.click();
		return magnifyImg.isDisplayed();
	}
	
	public void validateSubmitCommentBtn(String name, String email, String website, String rating, String comment) {
	/*public void validateSubmitCommentBtn() {	

		nameBox.sendKeys("Ravi");
		emailBox.sendKeys("meranaam@ravi.com");
		websiteBox.sendKeys("www.ravi.com");
		driver.findElement(By.xpath("//a[@title='3.5']")).click();
		//driver.findElement(By.xpath("//a[@title='"+rating+"']")).click();
		commentBox.sendKeys("Hardcoded comments");
		sumitCommentBtn.click();
*/		
		nameBox.sendKeys(name);
		emailBox.sendKeys(email);
		websiteBox.sendKeys(website);
		driver.findElement(By.xpath("//a[@title='"+rating+"']")).click();
		commentBox.sendKeys(comment);
		sumitCommentBtn.click();
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
