package com.AvionSchool.lms.objectRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminCreatenewCategoryPage {
	public WebDriver driver;
	@FindBy(xpath = "//input[@id='name']")
	private WebElement nametf;
	@FindBy(xpath ="//span[@id='select2-parent-container']")
	private WebElement parentdrop;
	@FindBy(xpath = "//button[text()='Submit']")
	private WebElement savebutton;
	@FindBy(xpath = "//input[@class='select2-search__field']")
	private WebElement searchtf;
	@FindBy(xpath = "//ul[@class='select2-results__options']/li")
	private List<WebElement> courseoptionssearch;
	@FindBy(xpath = "//div[@id='1']/..//div/ul/li")
	private List<WebElement> allcoursenames;
	public AdminCreatenewCategoryPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	public WebElement getNametf() {
		return nametf;
	}
	public WebElement getParentdrop() {
		return parentdrop;
	}
	public WebElement getSavebutton() {
		return savebutton;
	}
	public WebElement getSearchtf() {
		return searchtf;
	}
	public List<WebElement> getCourseoptionssearch() {
		return courseoptionssearch;
	}
	public List<WebElement> getAllcoursenames() {
		return allcoursenames;
	}
	
	
	
	

}
