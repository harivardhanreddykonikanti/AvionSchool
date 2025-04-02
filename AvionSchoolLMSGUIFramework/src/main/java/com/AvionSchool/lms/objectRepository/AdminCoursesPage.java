package com.AvionSchool.lms.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminCoursesPage {
	public WebDriver driver;
	@FindBy(xpath = "//h4[@class='page-title']/a")
	private WebElement addnewcoursebtn;
	@FindBy(xpath = "//table[@id='course-datatable']/tbody/tr/td[1]")
	private WebElement plusicon ;

	@FindBy(xpath = "//span[text()='Actions']/../span/../span[2]/div/button")
	private WebElement actionbtn;

	@FindBy(xpath = "(//span[text()='Actions']/../span/../span[2]/div/button)[2]/following-sibling::ul/li[4]")
	private WebElement markasactivebtn;

	@FindBy(xpath = "//input[@type='search']")
	private WebElement searchtf;
	@FindBy(xpath = "//h4[@class='page-title']")
	private WebElement coursetitlename;
	public AdminCoursesPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	public WebElement getAddnewcoursebtn() {
		return addnewcoursebtn;
	}
	public WebElement getPlusicon() {
		return plusicon;
	}
	public WebElement getActionbtn() {
		return actionbtn;
	}
	public WebElement getMarkasactivebtn() {
		return markasactivebtn;
	}
	public WebElement getSearchtf() {
		return searchtf;
	}
	public WebElement getCoursetitlename() {
		return coursetitlename;
	}
	
	


}
