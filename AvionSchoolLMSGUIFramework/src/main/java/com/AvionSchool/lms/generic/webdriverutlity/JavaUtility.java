package com.AvionSchool.lms.generic.webdriverutlity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	public int getRandomNumber() {
		Random ra=new Random();
		int randomvalue = ra.nextInt(5000);
		return randomvalue;
	}
	public String getSystemData() {
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		String todaydate = sdf.format(date);
		return todaydate;
	}
	
	public String getRequiredDateyyyyMMdd(int days) {
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		sdf.format(date);
		Calendar cal=sdf.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH,days);
		String reqdate = sdf.format(cal.getTime());
		return reqdate;
	}
	public String containsChecks(String value1,String value2) {
		String res;
		if(value1.contains(value2)) {
			res="SUCCESSFULLY";
		}
		else {
			res="FALIED";
		}
		return res;
	}
	public String equalsChecks(String value1,String value2) {
		String res;
		if(value1.equals(value2)) {
			res="SUCCESSFULLY";
		}
		else {
			res="FAILED";
		}
		return res;
	}
	

}
