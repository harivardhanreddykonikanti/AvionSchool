package com.AvionSchool.lms.objectRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminEnrollAStudentPage {
//	public WebDriver driver;
	@FindBy(xpath = "//span[@id='select2-user_id-container']")
	private WebElement selectuserdrop;
	@FindBy(xpath = "//span[@id='select2-course_id-container']")
	private WebElement selectcoursedrop;
	
//	@FindBy(xpath = "//span[@id='select2-course_id-container']/../../../../following-sibling::button")
	@FindBy(xpath = "//button[contains(text(),'Enrol Student')]")
	private WebElement enrolstudentbtn;
	
	@FindBy(xpath = "//h4[contains(text(),'Form')]/../form//button")
	private WebElement enrollstudentsearch;
	
	@FindBy(xpath = "//ul[@id='select2-user_id-results']/li")
	private List<WebElement> alluser;
	@FindBy(xpath = "//ul[@id='select2-course_id-results']/li")
	private List<WebElement> allcourses;
	public AdminEnrollAStudentPage(WebDriver driver) {
//		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	public WebElement getSelectuserdrop() {
		return selectuserdrop;
	}
	public WebElement getSelectcoursedrop() {
		return selectcoursedrop;
	}
	public WebElement getEnrolstudentbtn() {
		return enrolstudentbtn;
	}
	public WebElement getEnrollstudentsearch() {
		return enrollstudentsearch;
	}
	public void setEnrollstudentsearch(WebElement enrollstudentsearch) {
		this.enrollstudentsearch = enrollstudentsearch;
	}
	public List<WebElement> getAlluser() {
		return alluser;
	}
	public List<WebElement> getAllcourses() {
		return allcourses;
	}
	
	
	
	
	

}
