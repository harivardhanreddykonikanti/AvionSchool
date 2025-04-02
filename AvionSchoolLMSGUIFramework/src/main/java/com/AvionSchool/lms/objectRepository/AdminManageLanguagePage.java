package com.AvionSchool.lms.objectRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminManageLanguagePage {
	public WebDriver driver;
	@FindBy(xpath = "//li[@class='nav-item'][3]")
	private WebElement addnewlanguagelink;
	@FindBy(xpath = "//input[@id='language']")
	private WebElement addlanguagetf;
	@FindBy(xpath = "//input[@id='language']/parent::div/following-sibling::button")
	private WebElement savtbtn;
	@FindBy(xpath = "//li[@class='nav-item'][1]")
	private WebElement languagelistlink;
	@FindBy(xpath = "//div[@id='list']//tbody/tr/td[1]")
	private List<WebElement> alllanguagenames;
	public AdminManageLanguagePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);		
	}



}
