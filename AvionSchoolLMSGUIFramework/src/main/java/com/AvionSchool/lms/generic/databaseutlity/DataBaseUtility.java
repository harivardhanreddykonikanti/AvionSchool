package com.AvionSchool.lms.generic.databaseutlity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class DataBaseUtility {
	Connection conn;
	public void getDbconnection(String url,String username,String password) throws SQLException {
		try {
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		conn = DriverManager.getConnection(url, username, password);
		}catch(Exception e) {}
	}
	public void closeDbConnection() {
		try {
		conn.close();
		}catch(Exception e){}
	}
	public ResultSet executeselectquery(String query) throws Throwable {
		ResultSet result=null;
		try {
		Statement stmt = conn.createStatement();
		 result = stmt.executeQuery(query);
		}catch(Exception e) {}
		 return result;		 
	}
	public int executeNonselectquery(String query) throws Throwable {
		int result=0;
		try {
		Statement stmt = conn.createStatement();
		result = stmt.executeUpdate(query);
		}catch(Exception e) {}
		return result;		
	}
	public void getDbconnection() throws SQLException {
		try {
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		conn=DriverManager.getConnection("jdbc:mysql://49.249.28.218:3333/ninza_hrm", "root","root");
		}catch(Exception e) {}		
	}
		
	}


