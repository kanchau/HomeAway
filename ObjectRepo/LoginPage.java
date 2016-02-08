package com.kanch.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

	
WebDriver driver;
	
	public LoginPage(WebDriver driver){
		this.driver = driver;
	}
	
	@FindBy(xpath="//*[@id='account']/a")
	WebElement account;
	
	@FindBy(id="log")
	WebElement login;
	
	@FindBy(id="pwd")
	WebElement password;
	
	@FindBy(xpath="//*[@id='login']")
	WebElement loginButton;
	
	@FindBy(xpath="//*[@id='wp-admin-bar-my-account']/a")
	WebElement username;
	
	
	public void clickMyAccount(){
		account.click();
	}
	
	public WebElement enterLogin(){
		return login;
	}
	
	public WebElement enterPassword(){
		return password;
	}
	
	public void clickLogin(){
		loginButton.click();
	}
	
	public String getUsername(){
		return username.getText();
	}

	
}
