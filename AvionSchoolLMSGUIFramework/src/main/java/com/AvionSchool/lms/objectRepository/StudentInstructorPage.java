package com.AvionSchool.lms.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StudentInstructorPage {
	public WebDriver driver;
	@FindBy(xpath = "//a[contains(text(),'Add')]")
	private WebElement addnewcoursebtn;
	@FindBy(xpath = "//a[contains(text(),'Time and work')]/../../../../tr/td[1]")
	private WebElement plusicon;
	@FindBy (xpath = "//span[@class='dtr-data']")
	private WebElement kebabmenu;
	@FindBy (xpath = "//span[@class='dtr-data']/div/ul/li[1]")
	private WebElement kebabmenuviewinfrontend;
	@FindBy (xpath = "//span[@class='dtr-data']/div/ul/li[5]")
	private WebElement kebabmenudeletecourse;
	public StudentInstructorPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	public WebElement getAddnewcoursebtn() {
		return addnewcoursebtn;
	}
	public WebElement getPlusicon() {
		return plusicon;
	}
	public WebElement getKebabmenu() {
		return kebabmenu;
	}
	public WebElement getKebabmenuviewinfrontend() {
		return kebabmenuviewinfrontend;
	}
	public WebElement getKebabmenudeletecourse() {
		return kebabmenudeletecourse;
	}
	
	
	
	

}
