package com.AvionSchool.lms.objectRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StudentWishlistpage {
	public WebDriver driver;
	@FindBy(xpath = "//div[@class='course-box']/div[2]/a/h5")
	private WebElement allnamesofcourse ;
	@FindBy(xpath = "//div[@class='course-box']/div[1]/div[2]")
	private WebElement wishlisticon;
	public StudentWishlistpage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	

}
