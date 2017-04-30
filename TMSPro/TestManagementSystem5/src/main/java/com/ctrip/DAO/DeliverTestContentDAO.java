package com.ctrip.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.json.JSONArray;
import org.json.JSONObject;

import com.ctrip.Model.DeliverTestContent;
import com.ctrip.Utility.ConnectionDB;

public class DeliverTestContentDAO {
	/*
	 * author:full
	 */
	public String saveDeliverTestContent(DeliverTestContent deliverContent){
		Boolean autoCommit = true;
		Connection conn = (new ConnectionDB()).connectionDB();
		String result = "";
		
		try{
			autoCommit = conn.getAutoCommit();//获得当前状态
			conn.setAutoCommit(false);//关闭自动提交功能
			Statement stat = conn.createStatement();
			
			int projectId = (Integer) (new ProjectDAO()).getInfoByProject(deliverContent.getGroupName(), deliverContent.getProjectName()).get("id");
			
			int createUID = PP_UserDAO.getIdByUserName(deliverContent.getCreateUser());
			int updateUID = PP_UserDAO.getIdByUserName(deliverContent.getUpdateUser());
			
			if(projectId!=0 && createUID!=0 && updateUID!=0){
				deliverContent.setProjectId(projectId);
				deliverContent.setCreateUserID(createUID);
				deliverContent.setUpdateUserID(updateUID);
			}else{
				throw new Exception("saveDeliverTestContent: 数据格式异常");
			}
			
			String insertContent = "insert into DeliverTestContent (ProjectID, Decription, ServiceName, "
					+ "ChangePoint, ChangeContent, ChangeDescription, EmailList, CreateUserID, "
					+ "UpdateUserID, CreateTime, UpdateTime) values ('" + deliverContent.getProjectId()
					+ "','" + deliverContent.getDescription() + "','" + deliverContent.getServiceName()
					+ "','" + deliverContent.getChangePoint() + "','" + deliverContent.getChangeContent()
					+ "','" + deliverContent.getChangeDescription() + "','" + deliverContent.getEmailList()
					+ "','" + deliverContent.getCreateUserID() + "','" + deliverContent.getUpdateUserID() 
					+ "', getDate(), getDate())";
			
			stat.executeUpdate(insertContent);
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
	public String updateDeliverTestContent(DeliverTestContent deliverContent){
		Boolean autoCommit = true;
		Connection conn = (new ConnectionDB()).connectionDB();
		String result = "";
		
		try{
			autoCommit = conn.getAutoCommit();//获得当前状态
			conn.setAutoCommit(false);//关闭自动提交功能
			Statement stat = conn.createStatement();
			
			int projectId = (Integer) (new ProjectDAO()).getInfoByProject(deliverContent.getGroupName(), deliverContent.getProjectName()).get("id");
			int updateUID = PP_UserDAO.getIdByUserName(deliverContent.getUpdateUser());
			
			if(projectId!=0 && updateUID!=0){
				deliverContent.setProjectId(projectId);
				deliverContent.setUpdateUserID(updateUID);
			}else{
				throw new Exception("updateDeliverTestContent: 数据格式异常");
			}
			
			String updateContent = "update DeliverTestContent set ProjectID = '" + deliverContent.getProjectId() + "', Decription = '" + deliverContent.getDescription()
					+ "', ServiceName = '" + deliverContent.getServiceName() + "', ChangePoint = '" + deliverContent.getChangePoint() + "', "
					+ "ChangeContent = '" + deliverContent.getChangeContent() + "', ChangeDescription = '" + deliverContent.getChangeDescription()
					+ "', EmailList = '" + deliverContent.getEmailList() + "', UpdateUserID = '" + deliverContent.getUpdateUserID()
					+ "', UpdateTime = getDate() where id = '" + deliverContent.getId() + "'";
			
			stat.executeUpdate(updateContent);
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
	public JSONArray queryDeliverTestContent(DeliverTestContent deliverContent){
		JSONArray json = new JSONArray();
		Connection conn = (new ConnectionDB()).connectionDB();
		
		try{
			Statement stat = conn.createStatement();
			
			String querySql = "select a.id, b.projectName, a.decription, a.serviceName, a.changePoint, a.changeContent, a.changeDescription,"
					+ " a.emailList from DeliverTestContent a left join Project b on a.projectId = b.id "
					+ "left join PP_Group c on b.GroupID = c.id where c.groupName = '" + deliverContent.getGroupName()
					+ "' and b.projectName = '" + deliverContent.getProjectName() + "';";
			
			ResultSet rs=stat.executeQuery(querySql);
			while(rs.next())
			{				
				JSONObject jo = new JSONObject();
				jo.put("id", rs.getString("id"));
				jo.put("projectName", rs.getString("projectName"));
				jo.put("description", rs.getString("decription"));
				jo.put("serviceName", rs.getString("serviceName"));
				jo.put("changePoint", rs.getString("changePoint"));
				jo.put("changeContent", rs.getString("changeContent"));
				jo.put("changeDescription", rs.getString("changeDescription"));
				jo.put("emailList", rs.getString("emailList"));
				json.put(jo);
			}
			conn.close();

		}catch(Exception e){
			System.out.println("无提测内容");
		}
		return json;
	}

}
