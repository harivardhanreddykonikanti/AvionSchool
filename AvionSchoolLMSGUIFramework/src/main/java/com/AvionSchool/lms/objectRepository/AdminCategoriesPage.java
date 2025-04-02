package com.AvionSchool.lms.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminCategoriesPage {
	public WebDriver driver;
	@FindBy(xpath = "(//a[contains(text(),'New')])[2]")
	private WebElement addnewcatebtn;
	public AdminCategoriesPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	public WebElement getAddnewcatebtn() {
		return addnewcatebtn;
	}
	
	

}
