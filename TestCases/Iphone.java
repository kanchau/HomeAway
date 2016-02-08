package com.kanch.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.kanch.ObjectRepo.Store;
import com.kanch.TestCases.TestSuite;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.PageFactory;

/*
 * Submit an order for an Apple iPhone4s 16GB SIM-Free – Black (known issue with State drop-down, 
 * selecting Country is adequate) and verify the Total Price: given is correct 
 * (assume shipping cost is correct based on your choice). 
 * You may assume prices shown on product pages are the correct price. 
 * */

public class Iphone {	
	@Test
	public void selectIphone(){
		Store store = PageFactory.initElements(TestSuite.driver, Store.class);
		store.clickProductCategory();
		store.clickIPhones();
		store.clickIphone4s();
		store.clickAddToCart();
		store.clickCheckOut();
		store.enterCount().clear();
		store.enterCount().sendKeys("3");
		store.clickUpdate();
		store.clickCheckOutCont();
		store.selectCountry();
		store.clickCalculate();
		store.clickPurchase();
		TestSuite.driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		String finalPrice = store.getTotalPrice().getText();
		Assert.assertEquals(finalPrice, "$810.00");
	}

}

