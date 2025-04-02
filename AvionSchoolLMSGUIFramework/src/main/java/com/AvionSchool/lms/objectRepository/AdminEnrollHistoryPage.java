package com.AvionSchool.lms.objectRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminEnrollHistoryPage {
	public WebDriver driver;
	@FindBy(xpath = "//tr[@class='gradeU']/td[2]/b")
	private List<WebElement> namesofstudents;
	@FindBy(xpath = "//button[contains(@class,'btn btn-outline-danger')]")
	private WebElement deletebtn;
	@FindBy(xpath = "//a[@id='update_link']")
	private WebElement deletecontinuebtn;
	@FindBy(xpath = "//a[@id='update_link']/preceding-sibling::button")
	private WebElement deletecancelbtn;
	public AdminEnrollHistoryPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	public List<WebElement> getNamesofstudents() {
		return namesofstudents;
	}
	public WebElement getDeletebtn() {
		return deletebtn;
	}
	public WebElement getDeletecontinuebtn() {
		return deletecontinuebtn;
	}
	public WebElement getDeletecancelbtn() {
		return deletecancelbtn;
	}
}
