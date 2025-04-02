package com.AvionSchool.lms.objectRepository;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.AvionSchool.lms.generic.fileutlity.FileUtility;

public class LoginPage {
	public WebDriver driver;
	@FindBy(id = "login-email")
	private WebElement usernametf;
	@FindBy(xpath ="(//input[@name='password'])[1]")
	private WebElement passwordtf;
	@FindBy(xpath = "(//div[@class='content-update-box']/button)[1]")
	private WebElement loginbtn;
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	public WebElement getUsernametf() {
		return usernametf;
	}
	public WebElement getPasswordtf() {
		return passwordtf;
	}
	
	public WebElement getLoginbtn() {
		return loginbtn;
	}
	
	public void Studentlogin() {
		usernametf.sendKeys("haritesting21@gmail.com");
		passwordtf.sendKeys("ramu",Keys.ENTER);		
		//loginbtn.click();		
	}
	public void Adminlogin() {
		String username = System.getProperty("username","admin@example.com");
		String password = System.getProperty("password","admin");
		usernametf.sendKeys(username);
		passwordtf.sendKeys(password,Keys.ENTER);		
		//loginbtn.click();		
	}

}
