package com.ctrip.DAO;

import java.sql.Connection;
import java.sql.Statement;

import com.ctrip.Model.Task;
import com.ctrip.Utility.ConnectionDB;

public class TaskDAO {
	/*
	 * author:full
	 */
	public String saveTask(Task task){
		Boolean autoCommit = true;
		Connection conn = (new ConnectionDB()).connectionDB();
		String result = "";
		
		try{
			autoCommit = conn.getAutoCommit();//获得当前状态
			conn.setAutoCommit(false);//关闭自动提交功能
			Statement stat = conn.createStatement();
			
			int projectId = (new ProjectDAO()).getIdByProject(task.getGroupName(), task.getProjectName());
			
			PP_UserDAO userDao = new PP_UserDAO();
			int developerId = userDao.getIdByUserName(task.getDeveloper());
			int testerId = userDao.getIdByUserName(task.getTester());
			int comAdjustingOwnerId = userDao.getIdByUserName(task.getComAdjustingOwner());
			int createUID = userDao.getIdByUserName(task.getCreateUser());
			int updateUID = userDao.getIdByUserName(task.getUpdateUser());
			
			if(projectId!=0 && developerId!=0 && testerId!=0 && comAdjustingOwnerId!=0
					&& createUID!=0 && updateUID!=0){
				task.setProjectId(projectId);
				task.setDeveloperId(developerId);
				task.setTesterId(testerId);
				task.setCombinedAdjustingOwner(comAdjustingOwnerId);
				task.setCreateUserID(createUID);
				task.setUpdateUserID(updateUID);
			}
			
			
			String insertTask = "insert into Task ([TaskName],[Decription],[Status],[ProjectID],[DeveloperID],[TesterID],"
					+ "[CombinedAdjustingOwner],[CombinedAdjustingTime],[CreateUserID],[UpdateUserID],[CreateTime],[UpdateTime]) "
					+ "values ('" + task.getTaskName() + "','" + task.getDescription() + "','" + task.getStatus() + "','" + task.getProjectId() 
					+ "','" + task.getDeveloperId() + "','" + task.getTesterId() + "','" + task.getCombinedAdjustingOwner() + "','" 
					+ task.getCombinedAdjustingTime() + "','" + task.getCreateUserID() + "','" + task.getUpdateUserID() + "',getDate(),getDate())";
			
			stat.executeUpdate(insertTask);
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
