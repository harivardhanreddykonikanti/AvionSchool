package com.AvionSchool.lms.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddnewCoursePageInstructor {
	public WebDriver driver;
	@FindBy (xpath = "//input[@id='course_title']")
	private WebElement coursetitletf ;
	@FindBy (xpath = "//input[@id='course_title']/parent::div/parent::div/following-sibling::div[1]/div/textarea")
	private WebElement shortdesc ;

	@FindBy (xpath = "//span[@id='select2-sub_category_id-container']")
	private WebElement categorydrop;

	@FindBy (xpath = "//li[@class='next list-inline-item']")
	private WebElement nexticon ;

	@FindBy (xpath = "//input[@id='is_free_course']/../input/../label")
	private WebElement checkfreecourse ;

	@FindBy (xpath = "//div[@id='basicwizard']/ul/li[4]")
	private WebElement pricingsection;

	@FindBy (xpath = "//div[@id='basicwizard']/ul/li[7]")
	private WebElement finishsection;

	@FindBy (xpath = "//button[text()='Submit']")
	private WebElement submitbtn;

	@FindBy (xpath = "//span[text()='Courses']")
	private WebElement courseslink ;
	@FindBy (xpath = "//a[contains(text(),'Visit Website')]")
	private WebElement visitwebsitelink;
	


}
