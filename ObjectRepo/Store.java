package com.kanch.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class Store {

	WebDriver driver;
	
	public Store(WebDriver driver){
		this.driver = driver;
	}
	
	@FindBy(xpath="//*[@id='menu-item-33']/a")
	WebElement productCategory;
	
	@FindBy(xpath="//*[@id='menu-item-37']/a")
	WebElement iPhones;
	
	@FindBy(linkText="Apple iPhone 4S 16GB SIM-Free – Black")
	WebElement iPhone4s;
	
	@FindBy(xpath="//*[@value='Add To Cart']")
	WebElement addToCart;
	
	@FindBy(linkText="Go to Checkout")
	WebElement checkOut;
	
	@FindBy(xpath="//*[@id='checkout_page_container']/div[1]/table/tbody/tr[2]/td[3]/form/input[1]")
	WebElement countIncrement;
	
	@FindBy(xpath="//*[@id='checkout_page_container']/div[1]/table/tbody/tr[2]/td[3]/form/input[4]")
	WebElement update;
	
	@FindBy(xpath="//*[@id='checkout_page_container']/div[1]/a/span")
	WebElement checkOutCont;
	
	@FindBy(id="current_country")
	WebElement country;
	
	@FindBy(xpath="//*[@id='change_country']/input[4]")
	WebElement calculate;
	
	@FindBy(xpath="//*[@id='wpsc_shopping_cart_container']/form/div[4]/div/div/span/input")
	WebElement purchase;
	
	@FindBy(xpath="//*[@id='checkout_page_container']/div[1]/table/tbody/tr[2]/td[5]/span/span")
	WebElement totalPrice;
	
	public void clickProductCategory(){
		Actions actions = new Actions(driver);
		actions.moveToElement(productCategory).build().perform();
	   
	}
	
	public void clickIPhones(){
		iPhones.click();
	}
	
	public void clickIphone4s(){
		iPhone4s.click();
	}
	
	public void clickAddToCart(){
		addToCart.click();
	}
	
	public void clickCheckOut(){
		checkOut.click();
	}
	
	public WebElement enterCount(){
		return countIncrement;
	}
	
	public void clickUpdate(){
		update.click();
	}
	
	public void clickCheckOutCont(){
		checkOutCont.click();
	}
	
	public void selectCountry(){
		new Select(country).selectByVisibleText("USA");
	}
	
	public void clickCalculate(){
		calculate.click();
	}
	
	public void clickPurchase(){
		purchase.click();
	}
	
	public WebElement getTotalPrice(){
		return totalPrice;
	}
}

