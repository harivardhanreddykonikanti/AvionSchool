package com.AvionSchool.lms.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class AdminHomepage {
	public WebDriver driver;
	@FindBy (xpath = "//span[text()='Dashboard']")
	private WebElement dashboadlink;
	@FindBy(xpath = "//h4[@class='page-title']")
	private WebElement dashboardtitle;
	@FindBy(xpath = "//div[contains(@class,'jq-icon-success')]/h2")
	private WebElement popupnotification;
	@FindBy(xpath = "//span[contains(text(),'Categories')]")
	private WebElement categoriesmainlink;
	@FindBy (xpath ="//span[contains(text(),'Categories')]/../../ul/li[1]")
	private WebElement categoiressublink;
	@FindBy (xpath = "//span[contains(text(),'Categories')]/../../ul/li[2]")
	private WebElement addnewcategrolink;
	@FindBy (xpath = "//span[contains(text(),'Categories')]/../../following-sibling::li[1]")
	private WebElement courseslink;
	@FindBy (xpath = "//span[contains(text(),'Categories')]/../../following-sibling::li[2]")
	private WebElement studentslink;
	@FindBy (xpath = "//span[contains(text(),'Categories')]/../../following-sibling::li[3]")
	private WebElement enrollmentmainlink;
	@FindBy (xpath = "//span[contains(text(),'Categories')]/../../following-sibling::li[3]/ul/li[1]")
	private WebElement enrollhistory;
	@FindBy (xpath = "//span[contains(text(),'Categories')]/../../following-sibling::li[3]/ul/li[2]")
	private WebElement enrollstudent;
	@FindBy (xpath = "//span[contains(text(),'Categories')]/../../following-sibling::li[4]")
	private WebElement reportmainlink;
	@FindBy (xpath = "//span[contains(text(),'Categories')]/../../following-sibling::li[4]/ul/li[1]")
	private WebElement adminrevenue;
	@FindBy (xpath = "//span[contains(text(),'Categories')]/../../following-sibling::li[4]/ul/li[2]")
	private WebElement instructorrevenue;
	@FindBy (xpath = "//span[contains(text(),'Categories')]/../../following-sibling::li[5]")
	private WebElement messagelink;
	@FindBy (xpath = "//span[contains(text(),'Categories')]/../../following-sibling::li[6]")
	private WebElement settingslink;
	@FindBy (xpath = "//span[contains(text(),'Categories')]/../../following-sibling::li[6]/ul/li[1]")
	private WebElement systemsettings;
	@FindBy (xpath = "//span[contains(text(),'Categories')]/../../following-sibling::li[6]/ul/li[2]")
	private WebElement websitesettings;
	@FindBy (xpath = "//span[contains(text(),'Categories')]/../../following-sibling::li[6]/ul/li[3]")
	private WebElement paymentsettings;
	@FindBy (xpath = "//span[contains(text(),'Categories')]/../../following-sibling::li[6]/ul/li[4]")
	private WebElement instructorsettings;
	@FindBy (xpath = "//span[contains(text(),'Categories')]/../../following-sibling::li[6]/ul/li[5]")
	private WebElement languagesettings;
	@FindBy (xpath = "//a[@id='topbar-userdrop']")
	private WebElement adminprofileimg;
	@FindBy (xpath = "//a[@id='topbar-userdrop']")
	private WebElement adminprofiledropmyacc;
	@FindBy (xpath = "//a[@id='topbar-userdrop']/following-sibling::div/a[2]")
	private WebElement adminprofiledropsettings;
	@FindBy (xpath = "//a[@id='topbar-userdrop']/following-sibling::div/a[3]")
	private WebElement adminprofiledroplogout;
	@FindBy (xpath = "//a[@id='topbar-userdrop']/ancestor::ul/preceding-sibling::a")
	private WebElement tekpyramidlogoheader;
	@FindBy (xpath = "//div[@class='app-search']/a")
	private WebElement visitwebsiteheader;
	public AdminHomepage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	public void AdminLogout() throws InterruptedException {
	Thread.sleep(8000);
	adminprofiledropmyacc.click();
	adminprofiledroplogout.click();		
	}
	public WebElement getDashboadlink() {
		return dashboadlink;
	}
	
	public WebElement getPopupnotification() {
		return popupnotification;
	}
	public WebElement getCategoriesmainlink() {
		return categoriesmainlink;
	}
	public WebElement getCategoiressublink() {
		return categoiressublink;
	}
	public WebElement getAddnewcategrolink() {
		return addnewcategrolink;
	}
	public WebElement getCourseslink() {
		return courseslink;
	}
	public WebElement getStudentslink() {
		return studentslink;
	}
	public WebElement getEnrollmentmainlink() {
		return enrollmentmainlink;
	}
	public WebElement getEnrollhistory() {
		return enrollhistory;
	}
	public WebElement getEnrollstudent() {
		return enrollstudent;
	}
	public WebElement getReportmainlink() {
		return reportmainlink;
	}
	public WebElement getAdminrevenue() {
		return adminrevenue;
	}
	public WebElement getInstructorrevenue() {
		return instructorrevenue;
	}
	public WebElement getMessagelink() {
		return messagelink;
	}
	public WebElement getSettingslink() {
		return settingslink;
	}
	public WebElement getSystemsettings() {
		return systemsettings;
	}
	public WebElement getWebsitesettings() {
		return websitesettings;
	}
	public WebElement getPaymentsettings() {
		return paymentsettings;
	}
	public WebElement getInstructorsettings() {
		return instructorsettings;
	}
	public WebElement getLanguagesettings() {
		return languagesettings;
	}
	public WebElement getAdminprofileimg() {
		return adminprofileimg;
	}
	public WebElement getAdminprofiledropmyacc() {
		return adminprofiledropmyacc;
	}
	public WebElement getAdminprofiledropsettings() {
		return adminprofiledropsettings;
	}
	public WebElement getAdminprofiledroplogout() {
		return adminprofiledroplogout;
	}
	public WebElement getTekpyramidlogoheader() {
		return tekpyramidlogoheader;
	}
	public WebElement getVisitwebsiteheader() {
		return visitwebsiteheader;
	}
	public WebElement getDashboardtitle() {
		return dashboardtitle;
	}
	
	
	
	
	
	
	
	

}
