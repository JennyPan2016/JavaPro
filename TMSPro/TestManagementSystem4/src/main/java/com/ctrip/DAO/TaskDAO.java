package com.ctrip.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
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
			
			int projectId = (Integer) (new ProjectDAO()).getInfoByProject(task.getGroupName(), task.getProjectName()).get("id");
			
			int developerId = PP_UserDAO.getIdByUserName(task.getDeveloper());
			int testerId = PP_UserDAO.getIdByUserName(task.getTester());
			int comAdjustingOwnerId = PP_UserDAO.getIdByUserName(task.getComAdjustingOwner());
			int createUID = PP_UserDAO.getIdByUserName(task.getCreateUser());
			int updateUID = PP_UserDAO.getIdByUserName(task.getUpdateUser());
			
			if(projectId!=0 && developerId!=0 && testerId!=0 && comAdjustingOwnerId!=0
					&& createUID!=0 && updateUID!=0){
				task.setProjectId(projectId);
				task.setDeveloperId(developerId);
				task.setTesterId(testerId);
				task.setCombinedAdjustingOwner(comAdjustingOwnerId);
				task.setCreateUserID(createUID);
				task.setUpdateUserID(updateUID);
			}else{
				throw new Exception("saveTask: 数据格式异常");
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
	
	/*
	 * author:full
	 */
	public String updateTask(Task task){
		Boolean autoCommit = true;
		Connection conn = (new ConnectionDB()).connectionDB();
		String result = "";
		
		try{
			autoCommit = conn.getAutoCommit();//获得当前状态
			conn.setAutoCommit(false);//关闭自动提交功能
			Statement stat = conn.createStatement();
			
			int projectId = (Integer) (new ProjectDAO()).getInfoByProject(task.getGroupName(), task.getProjectName()).get("id");
			
			int developerId = PP_UserDAO.getIdByUserName(task.getDeveloper());
			int testerId = PP_UserDAO.getIdByUserName(task.getTester());
			int comAdjustingOwnerId = PP_UserDAO.getIdByUserName(task.getComAdjustingOwner());
			int updateUID = PP_UserDAO.getIdByUserName(task.getUpdateUser());
			
			if(projectId!=0 && developerId!=0 && testerId!=0 && comAdjustingOwnerId!=0 && updateUID!=0){
				task.setProjectId(projectId);
				task.setDeveloperId(developerId);
				task.setTesterId(testerId);
				task.setCombinedAdjustingOwner(comAdjustingOwnerId);
				task.setUpdateUserID(updateUID);
			}else{
				throw new Exception("updateTask: 数据格式异常");
			}
			
			
			String updateTask = "update [Task] set [TaskName] = '" + task.getTaskName() + "', [Decription] = '" + task.getDescription() + "', [Status] = '" + task.getStatus() 
					+ "', [ProjectID] = '" + task.getProjectId() + "', [DeveloperID] = '" + task.getDeveloperId() + "', "
					+ "[TesterID] = '" + task.getTesterId() + "', [CombinedAdjustingOwner] = '" + task.getCombinedAdjustingOwner()
					+ "', [CombinedAdjustingTime] = '" + task.getCombinedAdjustingTime() + "', [UpdateUserID] = '" + task.getUpdateUserID()
					+ "', [UpdateTime] = getDate() where id = '" + task.getId() + "'";
			
			stat.executeUpdate(updateTask);
			conn.commit();

			conn.setAutoCommit(autoCommit);//恢复场景
			System.out.println("更新成功");
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
	
	/*
	 * author:full
	 */
	public int getIdByTask(String group, String project, String taskName){
		int taskId = 0;
		Connection conn = (new ConnectionDB()).connectionDB();
		try{
			Statement stat = conn.createStatement();
			String sql = "select c.id, c.taskName from Project a left join PP_Group b on a.GroupID = b.id "
					+ "left join Task c on a.id = c.ProjectID where b.groupName = '" + group
					+ "' and a.projectName = '" + project + "' and c.taskName = '" + taskName + "';";
			
			ResultSet rs=stat.executeQuery(sql);
			while(rs.next()){
				taskId = rs.getInt("id");
			}
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return taskId;
	}
	
}
