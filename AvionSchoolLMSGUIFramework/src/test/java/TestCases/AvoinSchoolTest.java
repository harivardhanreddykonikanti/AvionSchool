package TestCases;

import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.AvionSchool.lms.basetest.Baseclass;
import com.AvionSchool.lms.generic.webdriverutlity.UtilityClassObject;
import com.AvionSchool.lms.objectRepository.AdminCoursesPage;
import com.AvionSchool.lms.objectRepository.AdminCreatenewCategoryPage;
import com.AvionSchool.lms.objectRepository.AdminEnrollAStudentPage;
import com.AvionSchool.lms.objectRepository.AdminEnrollHistoryPage;
import com.AvionSchool.lms.objectRepository.AdminHomepage;
import com.AvionSchool.lms.objectRepository.AdminMessagePage;
import com.AvionSchool.lms.objectRepository.AdminStudentPage;
import com.AvionSchool.lms.objectRepository.AdminWriteNewMessagePage;
import com.AvionSchool.lms.objectRepository.LoginPage;
import com.AvionSchool.lms.objectRepository.Signup_Page;
import com.AvionSchool.lms.objectRepository.WelcomePage;
import com.aventstack.extentreports.Status;
@Listeners(com.AvionSchool.lms.listenerutlity.ListnerimplementatationClass.class)
public class AvoinSchoolTest extends Baseclass {
	@Test(groups = "systemtest")
	public void AdminMessaging() throws InterruptedException, EncryptedDocumentException, IOException {
		//creating object for required classes
		AdminHomepage ahp=new AdminHomepage(driver);
		AdminMessagePage amp=new AdminMessagePage(driver);
		AdminWriteNewMessagePage anmp=new AdminWriteNewMessagePage(driver);
		//getting tet script data from the excel sheet
		String s_name = eu.getDataFromExcel("Admin_messaging", 1, 2);
		String message = eu.getDataFromExcel("Admin_messaging", 1, 3);
		String pop_message = eu.getDataFromExcel("Admin_messaging", 1, 4);
		//adding random number to the message
		int num=ju.getRandomNumber();
		String random_msg=message+num;
		//actual execution starts
		ahp.getMessagelink().click();		
		amp.getNewmessagebtn().click();	
		UtilityClassObject.getTest().log(Status.INFO,"clicked on message link");
		anmp.getSelectuserdrop().click();
		//finding name of the particular student in message select user dropdown
		for(WebElement name:anmp.getAllnamessuggestion()) {
			if(name.getText().contains(s_name)) {
				name.click();
				break;
			}
		}
		UtilityClassObject.getTest().log(Status.INFO,"selected particular user");
		anmp.getMessagetextarea().sendKeys(random_msg);
		UtilityClassObject.getTest().log(Status.INFO,"message entered into the text field");
		anmp.getSentmessagebtn().click();
		Thread.sleep(2000);
		String conformmessage =ahp.getPopupnotification().getText();
		Thread.sleep(2000);
		UtilityClassObject.getTest().log(Status.INFO,"clicked on the send button");		
		UtilityClassObject.getTest().log(Status.INFO,"message captured from the alert pop up");
		//reading pop message for conformation 
		Assert.assertEquals(conformmessage,pop_message);
		Actions act=new Actions(driver);
		boolean flag=false;
		//validating message form the message page again
		List<WebElement>allmessages=anmp.getChatmessages();
		for(WebElement fmessage:allmessages) {			
			act.scrollToElement(fmessage).click().perform();
			Thread.sleep(1000);			
			String message1 = fmessage.getText();
			System.out.println(message1);
			if(message1.equals(random_msg)) {
				flag=true;			
			}
		}
		//validating message using asserts
		Assert.assertEquals(flag,true);
		UtilityClassObject.getTest().log(Status.PASS,"message checked on the message history");
		
		}
	@Test(groups = "systemtest")
	public void Admin_Enroll_course() throws InterruptedException, EncryptedDocumentException, IOException {
		//creating objects for required classes
		AdminHomepage ahp=new AdminHomepage(driver);
		AdminEnrollAStudentPage aesp=new AdminEnrollAStudentPage(driver);
		AdminEnrollHistoryPage aehp=new AdminEnrollHistoryPage(driver);
		//reading test script data from the excel sheet
		String studentname = eu.getDataFromExcel("Admin_enroll_course", 1, 2);
		String cname = eu.getDataFromExcel("Admin_enroll_course", 1, 3);
		String popmessage = eu.getDataFromExcel("Admin_enroll_course", 1, 4);
		//actual execution starts				
		ahp.getEnrollmentmainlink().click();
		ahp.getEnrollstudent().click();
		UtilityClassObject.getTest().log(Status.INFO,"clicked on enroll a new student");
		aesp.getSelectuserdrop().click();
		Thread.sleep(2000);
		//finding user name in the users drop down 
		for(WebElement user:aesp.getAlluser()) {
			if(user.getText().contains(studentname)) {
				user.click();
				break;
			}
		}
		UtilityClassObject.getTest().log(Status.INFO,"selected particular user");
		//finding course name in the course drop down
		aesp.getSelectcoursedrop().click();
		for(WebElement course:aesp.getAllcourses()) {
			if(course.getText().contains(cname)) {
				course.click();
				break;
			}
		}
		UtilityClassObject.getTest().log(Status.INFO,"selected particular course");
		boolean flag=false;
		Thread.sleep(2000);
		aesp.getEnrolstudentbtn().click();
		UtilityClassObject.getTest().log(Status.INFO,"clicked on enroll button");
		//validating from  pop message text 
		String conformmessage =ahp.getPopupnotification().getText();
		UtilityClassObject.getTest().log(Status.INFO,"captured data from the popup message");
		Assert.assertEquals(conformmessage,popmessage);
		Thread.sleep(2000);
		//validating student and course from enrollment history page 
		List<WebElement> names = aehp.getNamesofstudents();
		for(WebElement name:names) {
			String text = name.getText();
			System.out.println(text);
			if(text.equals(studentname)) {
				List<WebElement>courses=driver.findElements(By.xpath("//b[text()='"+studentname+"']/../../td[3]/strong/a"));
				for(WebElement course:courses) {
					if(course.getText().equals("Ballet")) {
						flag=true;
						break;
						
					}
				}
			}
		}
		Assert.assertEquals(flag,true);	
		UtilityClassObject.getTest().log(Status.PASS,"validated student and course from enrollment page");
	}
	@Test(groups = "systemtest")
	public void deleting_student() throws InterruptedException, EncryptedDocumentException, IOException {
		//creating object for required web pages
		System.out.println("system test method 3");
		AdminHomepage ahp=new AdminHomepage(driver);
		AdminStudentPage asp=new AdminStudentPage(driver);
		WelcomePage wp=new WelcomePage(driver);
		Signup_Page sp=new Signup_Page(driver);
		LoginPage lp=new LoginPage(driver);
		//reading test scriptdata from the excel sheet
		String studentname = eu.getDataFromExcel("deleting_student", 1, 2);
		String popmessage = eu.getDataFromExcel("deleting_student", 1, 3);
		String f_name = eu.getDataFromExcel("deleting_student", 4, 0);
		String l_name = eu.getDataFromExcel("deleting_student", 4, 1);
		String email = eu.getDataFromExcel("deleting_student", 4, 2);
		String password = eu.getDataFromExcel("deleting_student", 4, 3);
		//actual execution begin
		//we have to logout first as admin
		ahp.AdminLogout();	
		UtilityClassObject.getTest().log(Status.INFO,"loged out as admin");
		//creating a new user
		Thread.sleep(6000);
		wp.getSignup().click();
		UtilityClassObject.getTest().log(Status.INFO,"clicked on signup link");
		Thread.sleep(2000);
		//adding radom number to the email and username
		int random =ju.getRandomNumber();
		String newemail = email+random+"@gmail.com";
		String studentnam = f_name+random;		
		sp.getFnametf().sendKeys(studentnam);
		sp.getLnametf().sendKeys(l_name);
		sp.getEmailtf().sendKeys(newemail);
		sp.getPasswordtf().sendKeys(password);
		sp.getSignupbtn().click();
		UtilityClassObject.getTest().log(Status.INFO,"enterd all details of new user and clicked on signup button");
		Thread.sleep(6000);
		//again login as a admin to the application	
		Thread.sleep(4000);
		wp.getLogin().click();
		lp.Adminlogin();
		UtilityClassObject.getTest().log(Status.INFO,"loged in as admin");
		//deleting of the student 
		ahp.getStudentslink().click();
		UtilityClassObject.getTest().log(Status.INFO,"clicked on students link");
		asp.getSearchfield().sendKeys(studentnam,Keys.ENTER);
		Thread.sleep(2000);
		asp.getDropkebabbuttton().click();
		Thread.sleep(1000);
		asp.getDeletestudentdrop().click();
		Thread.sleep(1000);
		UtilityClassObject.getTest().log(Status.INFO,"entered student deatils and clicked on delete button");
		asp.getContinuedeletebtn().click();
		UtilityClassObject.getTest().log(Status.INFO,"clicked on continue button");
		//reading pop notification message text
		String message = ahp.getPopupnotification().getText();
		UtilityClassObject.getTest().log(Status.INFO,"successfully captured message from the pop up");
		Assert.assertEquals(message,popmessage);
		Thread.sleep(1000);
		ahp.getStudentslink().click();
		UtilityClassObject.getTest().log(Status.INFO,"clicked on students link");
		asp.getSearchfield().sendKeys(studentnam,Keys.ENTER);
		Thread.sleep(2000);
		UtilityClassObject.getTest().log(Status.INFO,"entered student name into text field");
		String text1 = asp.getSearchresulttext().getText();
		boolean flag=false;
		//validating the user is present or not
		if(text1.contains("No")) {
			flag=true;			
		}
		UtilityClassObject.getTest().log(Status.PASS,"student is removed from the student page");
		Assert.assertEquals(flag,true);		
	}
	@Test(groups = "systemtest")
	public void createcategory() throws InterruptedException, EncryptedDocumentException, IOException {
		//creating object for the particular classes
		System.out.println("system test method 4");
		AdminHomepage ahp=new AdminHomepage(driver);
		AdminCreatenewCategoryPage acnp=new AdminCreatenewCategoryPage(driver);
		//reading data from the excel sheet
		String parent_category = eu.getDataFromExcel("createcategory", 1, 2);
		String none_category = eu.getDataFromExcel("createcategory", 1, 3);
		String child_category = eu.getDataFromExcel("createcategory", 1, 4);
		String popmessage = eu.getDataFromExcel("createcategory", 1, 5);	
		//adding random number to the child category
		int randomnumber = ju.getRandomNumber();
		String subcategory = child_category+randomnumber;
		//actual execution starts
		//creating parent category
		Thread.sleep(5000);
		ahp.getCategoriesmainlink().click();
		ahp.getAddnewcategrolink().click();
		UtilityClassObject.getTest().log(Status.INFO,"clicked on create new category link");
		acnp.getNametf().sendKeys(parent_category);
		acnp.getParentdrop().click();
		acnp.getSearchtf().sendKeys(none_category);
		List<WebElement> alloptions = acnp.getCourseoptionssearch();
		for(WebElement option:alloptions) {
			String name = option.getText();
			if(name.contains(none_category)) {
				option.click();
				break;
			}
		}
		Thread.sleep(2000);
		acnp.getSavebutton().click();
		Thread.sleep(3000);
		UtilityClassObject.getTest().log(Status.INFO,"clicked on save buttton");
		//creating sub category
		ahp.getAddnewcategrolink().click();
		UtilityClassObject.getTest().log(Status.INFO,"click on create new catogeory");
		acnp.getNametf().sendKeys(subcategory);
		acnp.getParentdrop().click();
		acnp.getSearchtf().sendKeys(parent_category);
		List<WebElement> alloptions2 = acnp.getCourseoptionssearch();
		for(WebElement option1:alloptions2) {
			String name1 = option1.getText();
			if(name1.contains(parent_category)) {
				option1.click();
				UtilityClassObject.getTest().log(Status.INFO,"selected parent category");
				break;
			}
		}
		Thread.sleep(2000);
		boolean flag=false;
		acnp.getSavebutton().click();
		UtilityClassObject.getTest().log(Status.INFO,"clicked on the save button");
		Thread.sleep(2000);
		//reading pop message
		String message = ahp.getPopupnotification().getText();
		UtilityClassObject.getTest().log(Status.INFO,"captured pop up notification message");
		Assert.assertEquals(message,popmessage);
		//validating category at the category page
		Thread.sleep(2000);
		ahp.getCategoiressublink().click();
		UtilityClassObject.getTest().log(Status.INFO,"clicked on categoires link");
		Thread.sleep(1000);
		List<WebElement> allnames = acnp.getAllcoursenames();
		for(WebElement name:allnames) {
			String text = name.getText();
			System.out.println(text);
			if(text.contains(subcategory)) {
				flag=true;
				break;
			}
		}
		System.out.println("the result is "+flag);	
		Assert.assertEquals(flag,true);		
		UtilityClassObject.getTest().log(Status.PASS,"category has been sucessfully created");
	}
	@Test(groups = "integrationtest")
	public void DeletingStudentusingemailid() throws InterruptedException, EncryptedDocumentException, IOException {
		//creating object for required web pages
				System.out.println("system test method 3");
				AdminHomepage ahp=new AdminHomepage(driver);
				AdminStudentPage asp=new AdminStudentPage(driver);
				WelcomePage wp=new WelcomePage(driver);
				Signup_Page sp=new Signup_Page(driver);
				LoginPage lp=new LoginPage(driver);
				//reading test scriptdata from the excel sheet
				String studentname = eu.getDataFromExcel("deleting_student", 1, 2);
				String popmessage = eu.getDataFromExcel("deleting_student", 1, 3);
				String f_name = eu.getDataFromExcel("deleting_student", 4, 0);
				String l_name = eu.getDataFromExcel("deleting_student", 4, 1);
				String email = eu.getDataFromExcel("deleting_student", 4, 2);
				String password = eu.getDataFromExcel("deleting_student", 4, 3);
				//actual execution begin
				//we have to logout first as admin
				ahp.AdminLogout();	
				UtilityClassObject.getTest().log(Status.INFO,"loged out as admin");
				//creating a new user
				Thread.sleep(6000);
				wp.getSignup().click();
				UtilityClassObject.getTest().log(Status.INFO,"clicked on signup link");
				Thread.sleep(2000);
				//adding radom number to the email and username
				int random =ju.getRandomNumber();
				String newemail = email+random+"@gmail.com";
				String studentnam = f_name+random;		
				sp.getFnametf().sendKeys(studentnam);
				sp.getLnametf().sendKeys(l_name);
				sp.getEmailtf().sendKeys(newemail);
				sp.getPasswordtf().sendKeys(password);
				sp.getSignupbtn().click();
				UtilityClassObject.getTest().log(Status.INFO,"enterd all details of new user and clicked on signup button");
				Thread.sleep(6000);
				//again login as a admin to the application	
				Thread.sleep(4000);
				wp.getLogin().click();
				lp.Adminlogin();
				UtilityClassObject.getTest().log(Status.INFO,"loged in as admin");
				//deleting of the student 
				ahp.getStudentslink().click();
				UtilityClassObject.getTest().log(Status.INFO,"clicked on students link");
				asp.getSearchfield().sendKeys(newemail,Keys.ENTER);
				Thread.sleep(2000);
				asp.getDropkebabbuttton().click();
				Thread.sleep(1000);
				asp.getDeletestudentdrop().click();
				Thread.sleep(1000);
				UtilityClassObject.getTest().log(Status.INFO,"entered students email and clicked on delete button");
				asp.getContinuedeletebtn().click();
				UtilityClassObject.getTest().log(Status.INFO,"clicked on continue button");
				//reading pop notification message text
				String message = ahp.getPopupnotification().getText();
				UtilityClassObject.getTest().log(Status.INFO,"successfully captured message from the pop up");
				Assert.assertEquals(message,popmessage);
				Thread.sleep(1000);
				ahp.getStudentslink().click();
				UtilityClassObject.getTest().log(Status.INFO,"clicked on students link");
				asp.getSearchfield().sendKeys(newemail,Keys.ENTER);
				Thread.sleep(2000);
				UtilityClassObject.getTest().log(Status.INFO,"entered student email into text field");
				String text1 = asp.getSearchresulttext().getText();
				boolean flag=false;
				//validating the user is present or not
				if(text1.contains("No")) {
					flag=true;			
				}
				UtilityClassObject.getTest().log(Status.PASS,"student is removed from the student page");
				Assert.assertEquals(flag,true);
				}
	@Test(groups ="integrationtest")
	public void deleteenrollment() throws InterruptedException, EncryptedDocumentException, IOException {
		//creating object for the specific classes
		System.out.println("this is integration test 2");
		AdminHomepage ahp=new AdminHomepage(driver);
		AdminEnrollHistoryPage aehp=new AdminEnrollHistoryPage(driver);
		AdminEnrollAStudentPage aesp=new AdminEnrollAStudentPage(driver);
		//reading test data from the excel sheet
		String s_name = eu.getDataFromExcel("deleting_enrollment", 1, 2);
		String popmessage = eu.getDataFromExcel("deleting_enrollment", 1, 3);
		String studentname = eu.getDataFromExcel("Admin_enroll_course", 1, 2);
		String cname = eu.getDataFromExcel("Admin_enroll_course", 1, 3);
		//actual execuation starts
		//enrolling student to a particular course	
		UtilityClassObject.getTest().log(Status.INFO,"clicked on enrollment link");
		ahp.getEnrollmentmainlink().click();
		ahp.getEnrollstudent().click();
		UtilityClassObject.getTest().log(Status.INFO,"clicked on getenrollment link");
		aesp.getSelectuserdrop().click();
		Thread.sleep(2000);
		for(WebElement user:aesp.getAlluser()) {
			if(user.getText().contains(studentname)) {
				user.click();
				UtilityClassObject.getTest().log(Status.INFO,"selected particular user");
				break;
			}
		}
		aesp.getSelectcoursedrop().click();
		for(WebElement course:aesp.getAllcourses()) {
			if(course.getText().contains(cname)) {
				course.click();
				UtilityClassObject.getTest().log(Status.INFO,"selected particular course");
				break;
				
			}
		}
		Thread.sleep(2000);
		aesp.getEnrolstudentbtn().click();
		UtilityClassObject.getTest().log(Status.INFO,"clicked on enrollment button");
		Thread.sleep(5000);
		//deleting enrollment
		ahp.getEnrollhistory().click();
		UtilityClassObject.getTest().log(Status.INFO,"clicked on enrollment history page");
		Thread.sleep(2000);
		List<WebElement> names = aehp.getNamesofstudents();
		for(WebElement name:names) {
			String text = name.getText();
			if(text.equals(studentname)) {
				driver.findElement(By.xpath("//b[text()='"+text+"']/../../td[5]/button")).click();
				aehp.getDeletecontinuebtn().click();
				break;
			}
		}
		//validating pop notification message text
		WebElement text = ahp.getPopupnotification();
		UtilityClassObject.getTest().log(Status.INFO,"captured text from the pop message");
		String message = text.getText();
		System.out.println(message);
		Assert.assertEquals(message,popmessage);
		UtilityClassObject.getTest().log(Status.PASS,"student enrollment is successfully removed from the enrollment page");
	}
	@Test(groups = "smoketest")
	public void dashboardverify() throws EncryptedDocumentException, IOException {
		System.out.println("executing smoke test 1");
		//crating object for the specific cases
		AdminHomepage ahp=new AdminHomepage(driver);
		//reading data from the excel sheet
		String expectedtext = eu.getDataFromExcel("smoke_test_cases", 1, 2);
		System.out.println("smoke test case 2nd method ");
		UtilityClassObject.getTest().log(Status.INFO,"loged in as admin");
		String name = ahp.getDashboardtitle().getText();
		UtilityClassObject.getTest().log(Status.INFO,"dashboard page is displayed");
		System.out.println(name);
		//verifying header name with asserts
		Assert.assertEquals(name,expectedtext);
		UtilityClassObject.getTest().log(Status.PASS,"dashboard text is successfully verified at the header of the page");
	}
	@Test(groups = "smoketest")
	public void coursepageverify() throws EncryptedDocumentException, IOException {

		System.out.println("executing smoke test 2");
		//creating object for the specific class
		AdminHomepage ahp=new AdminHomepage(driver);
		AdminCoursesPage acp=new AdminCoursesPage(driver);
		//getting test data from the excel sheet
		String expectedtext = eu.getDataFromExcel("smoke_test_cases", 4, 2);
		//actual execution starts here
		UtilityClassObject.getTest().log(Status.INFO,"dash board page is displayed");
		ahp.getCourseslink().click();		
		UtilityClassObject.getTest().log(Status.INFO,"course page got opened");
		String name = acp.getCoursetitlename().getText();
		System.out.println(name);
		//verifying header text by using asserts
		boolean flag=false;
		if(name.contains(expectedtext)) {
			flag=true;			
		}
		Assert.assertEquals(flag,true);
		UtilityClassObject.getTest().log(Status.PASS,"course text is successfully verified at the header");
	}

}
