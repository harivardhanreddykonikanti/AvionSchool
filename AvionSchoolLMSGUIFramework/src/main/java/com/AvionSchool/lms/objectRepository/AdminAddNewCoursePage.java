package com.AvionSchool.lms.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminAddNewCoursePage {
	public WebDriver driver;
	@FindBy(xpath = "//input[@id='course_title']")
	private WebElement  coursetf;
	@FindBy(xpath = "//textarea[@id='short_description']")
	private WebElement shortdesctf;

	@FindBy(xpath = "//span[@id='select2-sub_category_id-container']")
	private WebElement categdropdown;

	@FindBy(xpath = "//div[@id='finish']/following-sibling::ul/li[2]")
	private WebElement nexticon;
	@FindBy(xpath = "//span[text()='Pricing']")
	private WebElement pricinglink;
	@FindBy (xpath = "//input[@id='is_free_course']")
	private WebElement isfreecoursecheckbox; 
	@FindBy (xpath = "//span[text()='Finish']")
	private WebElement finishlink;
	@FindBy (xpath = "//button[text()='Submit']")
	private WebElement submitbtn;
	public AdminAddNewCoursePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	public WebElement getCoursetf() {
		return coursetf;
	}
	public WebElement getShortdesctf() {
		return shortdesctf;
	}
	public WebElement getCategdropdown() {
		return categdropdown;
	}
	public WebElement getNexticon() {
		return nexticon;
	}
	public WebElement getPricinglink() {
		return pricinglink;
	}
	public WebElement getIsfreecoursecheckbox() {
		return isfreecoursecheckbox;
	}
	public WebElement getFinishlink() {
		return finishlink;
	}
	public WebElement getSubmitbtn() {
		return submitbtn;
	}
	


}
