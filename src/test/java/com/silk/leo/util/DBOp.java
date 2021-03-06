package com.silk.leo.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBOp {
	private Statement stat = null;
	private ResultSet rsq = null;
	private String tablename = null;
	
	public DBOp(String tablename){
		this.tablename=tablename;
	}
	
	public void connect(){
		try {
			Class.forName("org.sqlite.JDBC");
			Connection conn;
			try {
				conn = DriverManager.getConnection("jdbc:sqlite:"+System.getProperty("user.dir")+"\\Tools\\mylocator.sqlite");
				stat = conn.createStatement();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
	
	//获取Xpath
	public String getLocatorXpath(String locatorname){
		String xpath = null;
		try {
			rsq = stat.executeQuery("select * from "+tablename+""
					+ " where WebElementName = '"+locatorname+"';");
			while(rsq.next()){
				xpath = rsq.getString("Xpath");
			}
			rsq.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return xpath;
		
	}
	
	//获取Css
	public String getLocatorCss(String locatorname){
		String css = null;
		try {
			rsq = stat.executeQuery("select * from "+tablename+""
					+ " where WebElementName = '"+locatorname+"';");
			while(rsq.next()){
				css = rsq.getString("Css");
			}
			rsq.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return css;
		
	}
	
	//select xpath from LoginPage where WebElementName='username'
	public static void main(String[] args){
		DBOp test = new DBOp("LoginPage");
		test.connect();
		System.out.println(test.getLocatorXpath("username"));
	}

}

