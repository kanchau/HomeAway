package com.kanch.TestCases;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.kanch.ObjectRepo.LoginPage;
import com.kanch.ObjectRepo.YourDetailsPage;

import org.testng.Assert;
/*
 * Verify updating your account details is saved and retrieved after logging out and 
 * back in using the My Account link. 
 * */
public class AccountDetails {

	@Test(priority=1)
	public void Login(){
		LoginPage loginPage = PageFactory.initElements(TestSuite.driver, LoginPage.class);
		loginPage.clickMyAccount();
		loginPage.enterLogin().sendKeys("sundar");
		loginPage.enterPassword().sendKeys("L8IOnz2ypvx8");
		loginPage.clickLogin();
		String uname = loginPage.getUsername();
		Assert.assertEquals(uname, "Howdy, sundar");
	}
	
	@Test(priority=2)
	public void yourDetails(){
		YourDetailsPage yourDetailsPage = PageFactory.initElements(TestSuite.driver, YourDetailsPage.class);
		TestSuite.driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		yourDetailsPage.enterYourDetails().click();
		yourDetailsPage.setOrGetFirstName().clear();
		yourDetailsPage.setOrGetFirstName().sendKeys("sundar");
		yourDetailsPage.setOrGetlastName().clear();
		yourDetailsPage.setOrGetlastName().sendKeys("dasar");
		yourDetailsPage.setOrGetAddress().clear();
		yourDetailsPage.setOrGetAddress().sendKeys("140 Lakeline Drive");
		yourDetailsPage.setOrGetCity().clear();
		yourDetailsPage.setOrGetCity().sendKeys("Austin");
		yourDetailsPage.selectCountry();
		yourDetailsPage.setOrGetPostalCode().clear();
		yourDetailsPage.setOrGetPostalCode().sendKeys("77665");
		yourDetailsPage.setOrGetPhone().clear();
		yourDetailsPage.setOrGetPhone().sendKeys("555-555-3333");
		yourDetailsPage.clickBillingCheck();
		yourDetailsPage.clickSaveProfile();
		yourDetailsPage.logout();
		TestSuite.driver.navigate().to("http://store.demoqa.com");
	}
	
	@Test(priority=3)
	public void verifyDetails(){
		Login();
		YourDetailsPage yourDetailsPage = PageFactory.initElements(TestSuite.driver, YourDetailsPage.class);
		yourDetailsPage.enterYourDetails().click();
		Assert.assertEquals(yourDetailsPage.setOrGetFirstName().getAttribute("value"),"sundar");
		Assert.assertEquals(yourDetailsPage.setOrGetlastName().getAttribute("value"),"dasar");
		Assert.assertEquals(yourDetailsPage.setOrGetAddress().getAttribute("value"),"140 Lakeline Drive");
		Assert.assertEquals(yourDetailsPage.setOrGetCity().getAttribute("value"),"Austin");
		Assert.assertEquals(yourDetailsPage.getCountry().getAttribute("value"),"US");
		Assert.assertEquals(yourDetailsPage.setOrGetPostalCode().getAttribute("value"),"77665");
		Assert.assertEquals(yourDetailsPage.setOrGetPhone().getAttribute("value"),"555-555-3333");
	}

}
