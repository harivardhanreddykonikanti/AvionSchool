package com.AvionSchool.lms.objectRepository;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;

public class StudentHomepage {
	public WebDriver driver;
	public StudentHomepage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy (xpath = "//div[@class='main-nav-wrap']/preceding-sibling::a")
	private WebElement tekpyramidlogo;
	@FindBy(xpath = "//span[text()='Courses']")
	private WebElement courseslink;
	@FindBy(xpath = "((//span[@class='icon']/../../../../..)[2]/li)[10]")
	private WebElement allcourseslink;
	@FindBy(xpath = "//a[text()='Instructor']")
	private WebElement instructorlink;
	@FindBy(xpath = "(//a[contains(text(),'Courses')])[1]")
	private WebElement mycourseslink;
	@FindBy(xpath = "(//div[@class='icon'])[3]")
	private WebElement wishlisticon;
	@FindBy(xpath = "(//div[@class='icon'])[4]")
	private WebElement carticon;
	@FindBy(xpath = "(//div[@class='icon'])[5]")
	private WebElement profileicon;
	@FindBy(xpath = "(//h2[contains(text(),'Top')])[1]")
	private WebElement topcoursesection;
	@FindBy(xpath = "(//h2[contains(text(),'Top')])[1]")
	private List<WebElement> allcourses;
	@FindBy (xpath = "//div[@class='user-name']")
	private WebElement profileusname;
	@FindBy(xpath = "//li[@class='user-dropdown-menu-item']//a[contains(text(),'Courses')]")
	private WebElement profilecourses;
	@FindBy(xpath = "//li[@class='user-dropdown-menu-item']//a[contains(text(),'Wishlist')]")
	private WebElement profilewishlist;
	@FindBy (xpath = "//li[@class='user-dropdown-menu-item']//a[contains(text(),'Messages')]")
	private WebElement profilemessages;
	@FindBy(xpath = "//li[@class='user-dropdown-menu-item']//a[contains(text(),'Purchase')]")
	private WebElement profilehistory;
	@FindBy(xpath = "//li[@class='user-dropdown-menu-item']//a[contains(text(),'User')]")
	private WebElement profileuser;
	@FindBy(xpath = "//li[@class='user-dropdown-menu-item']//a[contains(text(),'User')]/../following-sibling::li")
	private WebElement profilelogout;
	@FindBy (xpath = "//div[@class='course-box']/div[2]/../../../../../../..//h2[text()='Top Courses']/../div/div/div/div/div[1]/../a/div/div[2]//h5[text()='Ballet']/../../../../preceding-sibling::div[2]")
	private WebElement topcoursepaidcourse;
	@FindBy (xpath ="//button[@id='4' ]/following-sibling::button")
	private WebElement hovermenuoftopcoursewishlisticon;
	@FindBy (xpath = "//button[@id='4' ]/following-sibling::button/preceding-sibling::button")
	private WebElement hovermenuoftopcourseaddtocart;
	@FindBy (xpath = "//span[text()='Courses']/../../../../following-sibling::form/div/input")
	private WebElement headersearchtf;
	@FindBy (xpath = "//span[text()='Courses']/../../../../following-sibling::form/div/div/button")
	private WebElement headerseachbtn;
	@FindBy (xpath = "//button[@id='4']")
	private WebElement wishlisttocartbtn;
	
	public WebElement getTekpyramidlogo() {
		return tekpyramidlogo;
	}
	public WebElement getWishlisttocartbtn() {
		return wishlisttocartbtn;
	}
	public WebElement getCourseslink() {
		return courseslink;
	}
	public WebElement getAllcourseslink() {
		return allcourseslink;
	}
	public WebElement getInstructorlink() {
		return instructorlink;
	}
	public WebElement getMycourseslink() {
		return mycourseslink;
	}
	public WebElement getWishlisticon() {
		return wishlisticon;
	}
	public WebElement getCarticon() {
		return carticon;
	}
	public WebElement getProfileicon() {
		return profileicon;
	}
	public WebElement getTopcoursesection() {
		return topcoursesection;
	}
	public List<WebElement> getAllcourses() {
		return allcourses;
	}
	public WebElement getProfileusname() {
		return profileusname;
	}
	public WebElement getProfilecourses() {
		return profilecourses;
	}
	public WebElement getProfilewishlist() {
		return profilewishlist;
	}
	public WebElement getProfilemessages() {
		return profilemessages;
	}
	public WebElement getProfilehistory() {
		return profilehistory;
	}
	public WebElement getProfileuser() {
		return profileuser;
	}
	public WebElement getProfilelogout() {
		return profilelogout;
	}
	public WebElement getTopcoursepaidcourse() {
		return topcoursepaidcourse;
	}
	public WebElement getHovermenuoftopcoursewishlisticon() {
		return hovermenuoftopcoursewishlisticon;
	}
	public WebElement getHovermenuoftopcourseaddtocart() {
		return hovermenuoftopcourseaddtocart;
	}
	public WebElement getHeadersearchtf() {
		return headersearchtf;
	}
	public WebElement getHeaderseachbtn() {
		return headerseachbtn;
	}
	public void logout() {
		Actions action=new Actions(driver);
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(15));
		wait.until(ExpectedConditions.elementToBeClickable(profileicon));
		action.moveToElement(profileicon).perform();
		profilelogout.click();
	}
	
	
	

}
