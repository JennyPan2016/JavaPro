package com.ctrip.Utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ConnectionDB {
	public Connection connectionDB(){
		String driver = "";
		String url = "";
		String username = "";
		String password = "";
		
		try{
			Properties prop = new Properties();
			prop.load(this.getClass().getResourceAsStream("db.properties"));
			
			driver = prop.getProperty("driver");
		    url = prop.getProperty("url");;
			username = prop.getProperty("user");
			password = prop.getProperty("pwd");
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		Connection conn = null;
		
		try{
			Class.forName(driver);
			conn = DriverManager.getConnection(url, username, password);
		}catch(Exception e){
			e.printStackTrace();
		}
		return conn;
	}

}
