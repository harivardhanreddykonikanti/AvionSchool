package com.AvionSchool.lms.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WelcomePage {
	public WebDriver driver;
	public WelcomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath = "//a[contains(text(),'Log In')]")
	private WebElement loginbtn;
	@FindBy(xpath = "//a[contains(text(),'Sign')]")
	private WebElement signupbtn;
	public WebElement getLogin() {
		return loginbtn;
	}
	public WebElement getSignup() {
		return signupbtn;
	}
	

}
