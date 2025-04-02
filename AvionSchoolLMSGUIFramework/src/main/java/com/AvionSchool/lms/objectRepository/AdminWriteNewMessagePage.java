package com.AvionSchool.lms.objectRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminWriteNewMessagePage {
	public WebDriver driver;
	@FindBy(xpath = "//span[@id='select2-receiver-container']")
	private WebElement selectuserdrop;
	@FindBy(xpath = "//span[@id='select2-receiver-container']/../../../../../../following-sibling::div[1]/div/div/textarea")
	private WebElement messagetextarea;
	@FindBy(xpath = "//span[@id='select2-receiver-container']/../../../../../../following-sibling::div[2]/div/div/button")
	private WebElement sentmessagebtn;
	@FindBy(xpath = "//input[@class='select2-search__field']")
	private WebElement messagesearchfield;
	@FindBy(xpath = "//strong[text()='Students']/../ul/li")
	private List<WebElement>allnamessuggestion;
	@FindBy(xpath = "//ul[contains(@class,'conversation-list')]/li/div[2]/div/p")
	private List<WebElement>chatmessages;
	public AdminWriteNewMessagePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	public WebElement getSelectuserdrop() {
		return selectuserdrop;
	}
	public WebElement getMessagetextarea() {
		return messagetextarea;
	}
	public WebElement getSentmessagebtn() {
		return sentmessagebtn;
	}
	public WebElement getMessagesearchfield() {
		return messagesearchfield;
	}
	public List<WebElement> getAllnamessuggestion() {
		return allnamessuggestion;
	}
	public List<WebElement> getChatmessages() {
		return chatmessages;
	}
	
	
	
	

}
