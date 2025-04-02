package com.AvionSchool.lms.objectRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminStudentPage {
	public WebDriver driver;
	@FindBy (xpath = "//h4[@class='page-title']/a")
	private WebElement addstudentbtn;
	@FindBy (xpath = "//input[@type='search']")
	private WebElement searchfield;
	@FindBy (xpath = "//div[contains(@class,'dropright')]")
	private WebElement dropdown;
	@FindBy(xpath = "//td[@class='sorting_1']/../td/div/button")
	private WebElement dropkebabbuttton;
	@FindBy(xpath = "//a[contains(text(),'Continue')]")
	private WebElement continuedeletebtn;
	@FindBy(xpath = "(//table[@id='basic-datatable']//td[6])[1]/div/button")
	private WebElement moreactionsbtn;
	@FindBy(xpath = "//td[contains(text(),'No')]")
	private WebElement searchresultmsg;

	@FindBy (xpath = "//ul[@class='dropdown-menu']/li[1]")
	private WebElement editstudentdrop;
	@FindBy (xpath = "//a[contains(text(),'Delete')]")
	private WebElement deletestudentdrop;
	@FindBy(xpath = "//td[contains(text(),'No')]")
	private WebElement searchresulttext;
	@FindBy(xpath = "//table[@id='basic-datatable']/tbody//td[3]")
	private List<WebElement> allstudentnames;
	public AdminStudentPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	public WebElement getAddstudentbtn() {
		return addstudentbtn;
	}
	public WebElement getSearchfield() {
		return searchfield;
	}
	public WebElement getDropdown() {
		return dropdown;
	}
	public WebElement getEditstudentdrop() {
		return editstudentdrop;
	}
	public WebElement getDeletestudentdrop() {
		return deletestudentdrop;
	}
	public WebElement getDropkebabbuttton() {
		return dropkebabbuttton;
	}
	public WebElement getContinuedeletebtn() {
		return continuedeletebtn;
	}
	public WebElement getSearchresulttext() {
		return searchresulttext;
	}
	public List<WebElement> getAllstudentnames() {
		return allstudentnames;
	}
	public WebElement getMoreactionsbtn() {
		return moreactionsbtn;
	}
	public WebElement getSearchresultmsg() {
		return searchresultmsg;
	}
	
	
	
	
	

	

}
