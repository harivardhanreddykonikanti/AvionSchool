package com.AvionSchool.lms.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StudentProfilepage {
	public WebDriver driver;
	@FindBy (xpath = "//div[@class='user-dashboard-menu']/preceding-sibling::div/div/div")
	private WebElement nameofuser;
	@FindBy (xpath = "//div[@class='user-dashboard-menu']/ul/li[1]")
	private WebElement profile;
	@FindBy (xpath = "//div[@class='user-dashboard-menu']/ul/li[2]")
	private WebElement account;
	@FindBy (xpath = "//input[@id='FristName']")
	private WebElement profileeditfname;
	@FindBy (xpath = "//input[@id='FristName']/../following-sibling::div[1]")
	private WebElement profileeditlname;
	@FindBy (xpath = "//input[@id='FristName']/../../../following-sibling::div/button")
	private WebElement savebtn;
	@FindBy (xpath = "//div[@class='content-box']/div[2]/div[1]/input")
	private WebElement accountcurrentpasstf;
	@FindBy (xpath = "//div[@class='content-box']/div[2]/div[2]/input")
	private WebElement accountnewpasstf;
	@FindBy (xpath = "//div[@class='content-box']/div[2]/div[3]/input")
	private WebElement accountnewpassretypetf;
	@FindBy (xpath = "//button[text()='Save']")
	private WebElement savebtnofaccoutn;
	public StudentProfilepage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	public WebElement getNameofuser() {
		return nameofuser;
	}
	public WebElement getProfile() {
		return profile;
	}
	public WebElement getAccount() {
		return account;
	}
	public WebElement getProfileeditfname() {
		return profileeditfname;
	}
	public WebElement getProfileeditlname() {
		return profileeditlname;
	}
	public WebElement getSavebtn() {
		return savebtn;
	}
	public WebElement getAccountcurrentpasstf() {
		return accountcurrentpasstf;
	}
	public WebElement getAccountnewpasstf() {
		return accountnewpasstf;
	}
	public WebElement getAccountnewpassretypetf() {
		return accountnewpassretypetf;
	}
	public WebElement getSavebtnofaccoutn() {
		return savebtnofaccoutn;
	}
	


}
