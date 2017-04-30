package com.ctrip.DAO;

import java.sql.Connection;
import java.sql.Statement;

import com.ctrip.Model.Log;
import com.ctrip.Utility.ConnectionDB;

public class LogDAO {
	
	/*
	 * author: went
	 */
	public static String addLog(Log log)
	{Boolean autoCommit = true;
	Connection conn = (new ConnectionDB()).connectionDB();
	String result = "";
	
	try{
		autoCommit = conn.getAutoCommit();//获得当前状态
		conn.setAutoCommit(false);//关闭自动提交功能
		Statement stat = conn.createStatement();

		String addlog = "insert into [ProcessPlatform].[dbo].[log](UserID,OperationType,OperationModel,"
				+ "OperationDetail,Remarks,CreateTime) values('"+log.getUserid()+"','"+log.getOperationType()+"','"+log.getOperationModel()
				+"','"+log.getOperationDetail()+"','"+log.getRemarks()+"',getdate())";
		stat.executeUpdate(addlog);
		conn.commit();
		conn.setAutoCommit(autoCommit);//恢复场景
	
		System.out.println("保存成功");
		result = "Success";
		
	}catch(Exception e){
		System.out.println(e);
		result = e.toString();
		try{
			conn.rollback();
		}catch(Exception ro){
			ro.printStackTrace();
		}
	}
	finally{
		try{
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	return result;
	}
	
}
