package com.AvionSchool.lms.objectRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminMessagePage {
	public WebDriver driver;
	@FindBy(xpath = "//div[@class='content']/div/following-sibling::div/div/div/div[1]/div")
	private WebElement newmessagebtn;
	@FindBy(xpath = "//div[@class='content']/div/following-sibling::div/div/div/div[1]/div/following-sibling::ul/li/a")
	private List<WebElement> allnames ;
	public AdminMessagePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	public WebElement getNewmessagebtn() {
		return newmessagebtn;
	}
	public List<WebElement> getAllnames() {
		return allnames;
	}
	
}
