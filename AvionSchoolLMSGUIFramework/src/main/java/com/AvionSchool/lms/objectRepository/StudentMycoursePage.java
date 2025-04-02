package com.AvionSchool.lms.objectRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StudentMycoursePage {
	public WebDriver driver;
	@FindBy(xpath = "//div[@class='course-box']")
	private List<WebElement> allcourses;
	@FindBy (xpath = "//h5[contains(text(),'Photosynthesis')]")
	private WebElement photosynthesiscourse;
	@FindBy(xpath = "//p[@id='5']")
	private WebElement rating;
	@FindBy (xpath = "//label[@for='star4']")
	private WebElement rating4;
	@FindBy (xpath = "//div[@class='modal-footer']/button[text()='Next']")
	private WebElement ratingnextbtn;
	@FindBy (xpath="//textarea[@id='review_of_a_course']")
	private WebElement ratingtextarea;
	@FindBy (xpath = "//div[@class='modal-footer']/button[text()='Publish']")
	private WebElement publishratingbtn;
	@FindBy(xpath = "//div[@class='col-md-6']/a[contains(text(),'Course')]")
	private WebElement coursedetailsbtns;
	public StudentMycoursePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	public List<WebElement> getAllcourses() {
		return allcourses;
	}
	public WebElement getPhotosynthesiscourse() {
		return photosynthesiscourse;
	}
	public WebElement getRating() {
		return rating;
	}
	public WebElement getRating4() {
		return rating4;
	}
	public WebElement getRatingnextbtn() {
		return ratingnextbtn;
	}
	public WebElement getRatingtextarea() {
		return ratingtextarea;
	}
	public WebElement getPublishratingbtn() {
		return publishratingbtn;
	}
	public WebElement getCoursedetailsbtns() {
		return coursedetailsbtns;
	}
	

}
