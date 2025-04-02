package com.AvionSchool.lms.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminWebsiteSettingsPage {
	public WebDriver driver;
	@FindBy(xpath = "//div[@class='content-page']/div/div[2]/div/div/div/form/div[1]/input")
	private WebElement bannertitle;
	@FindBy(xpath = "//div[@class='content-page']/div/div[2]/div/div/div/form/div[1]/input")
	private WebElement bannersubtitle;
	@FindBy(xpath = "//div[@class='content-page']/div/div[2]/div/div/div/form/div[6]/div/button")
	private WebElement updatesettingsbtn;
	public AdminWebsiteSettingsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	public WebElement getBannertitle() {
		return bannertitle;
	}
	public WebElement getBannersubtitle() {
		return bannersubtitle;
	}
	public WebElement getUpdatesettingsbtn() {
		return updatesettingsbtn;
	}
	


}
