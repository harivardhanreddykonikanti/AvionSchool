package com.AvionSchool.lms.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminStudentAddPage {
	public WebDriver driver;
	@FindBy(xpath = "//input[@id='first_name']")
	private WebElement firstnametf ;
	@FindBy(xpath = "//input[@id='last_name']")
	private WebElement lastnametf;
	@FindBy(xpath = "(//a[contains(@class,'btn-info')])[2]")
	private WebElement nexticon;
	@FindBy(xpath = "//span[text()='Finish']")
	private WebElement finishlink;
	@FindBy(xpath = "//button[text()='Submit']")
	private WebElement submitbtn;
	public AdminStudentAddPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	public WebElement getFirstnametf() {
		return firstnametf;
	}
	public WebElement getLastnametf() {
		return lastnametf;
	}
	public WebElement getNexticon() {
		return nexticon;
	}
	public WebElement getFinishlink() {
		return finishlink;
	}
	public WebElement getSubmitbtn() {
		return submitbtn;
	}
	


}
