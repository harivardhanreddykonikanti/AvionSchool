package com.AvionSchool.lms.generic.webdriverutlity;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebdriverUtlity {
	public void waitPageToLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}
	public void waitForElementPresent(WebDriver driver,WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	public void switchToBroswerTabOnUrl(WebDriver driver,String partialurl) {
		Set<String> allids = driver.getWindowHandles();
		for(String id:allids) {
			driver.switchTo().window(id);
			if(driver.getCurrentUrl().contains(partialurl)) {
				break;
			}
		}
	}
	public void switchToTabOnTitle(WebDriver driver,String partialtitle) {
		Set<String> allids = driver.getWindowHandles();
		for(String id:allids) {
			driver.switchTo().window(id);
			if(driver.getTitle().contains(partialtitle)) {
				break;
			}
		}
	}
	public void switchToFrame(WebDriver driver,String partialValue) {
		driver.switchTo().frame(partialValue);
	}
	public void switchToFrame(WebDriver driver,int index) {
		driver.switchTo().frame(index);
	}
	public void switchToFrame(WebDriver driver,WebElement element) {
		driver.switchTo().frame(element);
	}
	public void switchToAlertsAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	public void switchToAlertsDismiss(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	public void selectByIndex(WebElement element,int index) {
		Select objsel=new Select(element);
		objsel.selectByIndex(index);
	}
	public void selectbyValue(WebElement element,String value) {
		Select objsel=new Select(element);
		objsel.selectByValue(value);
	}
	public void selectByVisibleText(String value,WebElement element) {
		Select objsel=new Select(element);
		objsel.selectByVisibleText(value);
	}
	public void moveOnToTheElement(WebDriver driver,WebElement element) {
		Actions action=new Actions(driver);
		action.moveToElement(element).build().perform();
	}
	public void doubleclick(WebDriver driver,WebElement element) {
		Actions action=new Actions(driver);
		action.doubleClick(element).build().perform();
	}
	public void dragAndDrop(WebDriver driver,WebElement source,WebElement destination) {
		Actions action=new Actions(driver);
		action.dragAndDrop(source, destination).build().perform();
	}
	public void rightClick(WebDriver driver,WebElement element) {
		Actions action=new Actions(driver);
		action.contextClick(element).build().perform();
	}
	public void scrollToElement(WebDriver driver,WebElement element) {
		Actions action=new Actions(driver);
		action.scrollToElement(element).build().perform();
	}
	public void scrollByAmount(WebDriver driver,int x,int y) {
		Actions action=new Actions(driver);
		action.scrollByAmount(x, y).build().perform();
	}
	public void minimizeBrowser(WebDriver driver) {
		driver.manage().window().minimize();
	}
	public void maximizeBrowser(WebDriver driver) {
		driver.manage().window().maximize();
	}
	public void takescreenshotofpage(WebDriver driver) throws IOException {
		TakesScreenshot ts=(TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest=new File("./ScreenShotsOfCrm/img.png");
		FileHandler.copy(src, dest);
	}
	public void takescreenshotofwebelement(WebDriver driver,WebElement element) throws IOException {
		File src = element.getScreenshotAs(OutputType.FILE);
		File dest=new File("E:\\\\ComcastCRMGUIFramework\\\\ScreenShotsOfCrm");
		FileHandler.copy(src, dest);
	}
	public void javaScriptExecutor(WebDriver driver,String script) {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript(script);
	}
	

}
