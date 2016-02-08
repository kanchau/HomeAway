package com.kanch.TestCases;


import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.kanch.ObjectRepo.RemoveFromCartPage;
/*
 * Verify removing all items from your cart produces an empty cart message. 
 * */
public class RemoveFromCart {

	@Test
	public void removeItems(){
		RemoveFromCartPage cartPage = PageFactory.initElements(TestSuite.driver, RemoveFromCartPage.class);
		cartPage.clickCheckOut();
		cartPage.clickRemove();
		String text = cartPage.getCartText().getText();
		System.out.println("Value in text");
		Assert.assertEquals(text, "Oops, there is nothing in your cart.");
	}
}
