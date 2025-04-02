package com.AvionSchool.lms.basetest;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.AvionSchool.lms.generic.databaseutlity.DataBaseUtility;
import com.AvionSchool.lms.generic.fileutlity.ExcelUtility;
import com.AvionSchool.lms.generic.fileutlity.FileUtility;
import com.AvionSchool.lms.generic.fileutlity.JsonUtility;
import com.AvionSchool.lms.generic.webdriverutlity.JavaUtility;
import com.AvionSchool.lms.generic.webdriverutlity.UtilityClassObject;
import com.AvionSchool.lms.generic.webdriverutlity.WebdriverUtlity;
import com.AvionSchool.lms.objectRepository.AdminHomepage;
import com.AvionSchool.lms.objectRepository.LoginPage;
import com.AvionSchool.lms.objectRepository.StudentHomepage;
import com.AvionSchool.lms.objectRepository.WelcomePage;
public class Baseclass {
public WebDriver driver=null;
public JavaUtility ju=new JavaUtility();
public WebdriverUtlity wu=new WebdriverUtlity();
public FileUtility fu=new FileUtility();
public JsonUtility js=new JsonUtility();
public DataBaseUtility db=new DataBaseUtility();
public ExcelUtility eu=new ExcelUtility();
@BeforeSuite(groups = {"smoketest","integrationtest","systemtest"})
public void configBeforeSuit() throws Throwable {
	System.out.println("connected to database and report config");
	db.getDbconnection();
}
@AfterSuite(groups = {"smoketest","integrationtest","systemtest"})
public void configAftersuit() {
	System.out.println("connection to the data base has been closed");
	db.closeDbConnection();
}
@BeforeMethod(groups = {"smoketest","integrationtest","systemtest"})
public void configbeforemethod() throws IOException, InterruptedException {
	FileUtility fu=new FileUtility();
	String url = System.getProperty("url",fu.getDataFromPropertyFile("url"));
	//String url = fu.getDataFromPropertyFile("url");
	driver.get(url);	
	Thread.sleep(6000);
	WelcomePage wp=new WelcomePage(driver);
	wp.getLogin().click();
	LoginPage lp=new LoginPage(driver);		
	lp.Adminlogin();
}
@AfterMethod(groups = {"smoketest","integrationtest","systemtest"})
public void configaftermethod() throws InterruptedException {
	AdminHomepage ah= new AdminHomepage(driver);
	Thread.sleep(4000);
	ah.AdminLogout();	
}
//@Parameters("browser")
@BeforeClass(groups = {"smoketest","integrationtest","systemtest"})
public void configbeforeclass() throws Throwable {
	String bro=System.getProperty("browser",fu.getDataFromPropertyFile("browser"));
	//String bro = browser;
	if(bro.equals("chrome")) {
		driver=new ChromeDriver();
	}
	else {
		driver=new EdgeDriver();
	}
	UtilityClassObject.setDriver(driver);	
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	System.out.println("Launch the browser");
}
@AfterClass(groups = {"smoketest","integrationtest","systemtest"})
public void configafterclass() throws InterruptedException {	
	Thread.sleep(3000);
	driver.quit();
}



	

}
