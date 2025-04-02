package com.AvionSchool.lms.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Signup_Page {
	public WebDriver driver;
	@FindBy(id = "first_name")
	private WebElement fnametf;
	@FindBy(id = "last_name")
	private WebElement lnametf;
	@FindBy(id = "registration-email")
	private WebElement emailtf;
	@FindBy(id = "registration-password")
	private WebElement passwordtf;
	@FindBy(xpath ="//button[text()='Sign Up']")
	private WebElement signupbtn;
	public WebElement getFnametf() {
		return fnametf;
	}
	public WebElement getLnametf() {
		return lnametf;
	}
	public WebElement getEmailtf() {
		return emailtf;
	}
	public WebElement getPasswordtf() {
		return passwordtf;
	}
	public WebElement getSignupbtn() {
		return signupbtn;
	}
	public Signup_Page(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	
	
	
	

}
