package com.ctrip.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import com.ctrip.Model.DeliverList;
import com.ctrip.Model.Project;
import com.ctrip.Utility.ConnectionDB;

public class ProjectDAO {
	/*
	 * Author: full
	 * 保存项目
	 */
	public String saveProject(Project project){
		Boolean autoCommit = true;
		Connection conn = (new ConnectionDB()).connectionDB();
		String result = "";
		
		try{
			autoCommit = conn.getAutoCommit();//获得当前状态
			conn.setAutoCommit(false);//关闭自动提交功能
			Statement stat = conn.createStatement();
			
			int productId = ProductDAO.getIdByProduct(project.getProductName());
			int groupId = PP_GroupDAO.getIdByGroup(project.getGroupName());
			int centerId = CenterDAO.getIdByCenter(project.getCenterName());
			
			if(productId!=0 && groupId!=0 && centerId!=0){
				project.setProductId(productId);
				project.setGroupId(groupId);
				project.setCenterId(centerId);
			}else{
				throw new Exception("saveProject: 数据格式异常");
			}
			
			PP_UserDAO userDao = new PP_UserDAO();
			int BAOwnerID = PP_UserDAO.getIdByUserName(project.getBAOwner());
			int ADOwnerID = PP_UserDAO.getIdByUserName(project.getADOwner());
			int STOwnerID = PP_UserDAO.getIdByUserName(project.getSTOwner());
			int createUID = PP_UserDAO.getIdByUserName(project.getCreateUser());
			int updateUID = PP_UserDAO.getIdByUserName(project.getUpdateUser());
			if(BAOwnerID!=0 && ADOwnerID!=0 && STOwnerID!=0 && createUID!=0 && updateUID!=0){
				project.setBAOwnerId(BAOwnerID);
				project.setADOwnerId(ADOwnerID);
				project.setSTOwnerId(STOwnerID);
				project.setCreateUserID(createUID);
				project.setUpdateUserID(updateUID);
			}else{
				throw new Exception("数据格式异常");
			}
			
			String developsId = userDao.getIdListByUser(project.getDevelops());
			String testersId = userDao.getIdListByUser(project.getTesters());
			project.setDevelopsId(developsId);
			project.setTestersId(testersId);
			
			String insertProject = "INSERT INTO ProcessPlatform..Project ([ProjectName],[Description],[ProductID],[GroupID],[CenterID],[Status],[ProjectType],"
					+ "[BAOwnerID],[ADOwnerID],[STOwnerID],[Developers],[Testers],[ScheSmokingTime],[ScheDeliverTime],[RealDeliverTime],[TestCompleteTime],"
					+ "[NeedCombinedAdjusting],[CombinedAdjustingTime],[NeedPerformanceTest],[ProjectRisk],[RiskSolution],[CreateUserID],[UpdateUserID],"
					+ "[CreateTime],[UpdateTime]) values ('" + project.getProjectName() + "','" + project.getDescription() + "','" + project.getProductId()
					+ "','" + project.getGroupId() + "','" + project.getCenterId() + "','" + project.getStatus() + "','" + project.getProjectType()
					+ "','" + project.getBAOwnerId() + "','" + project.getADOwnerId() + "','" + project.getSTOwnerId() + "','" + project.getDevelopsId()
					+ "','" + project.getTestersId() + "','" + project.getScheSmokingTime() + "','" + project.getScheDeliverTime() + "','" + project.getRealDeliverTime()
					+ "','" + project.getTestCompleteTime() + "','" + project.getNeedCombinedAdjusting() + "','" + project.getCombinedAdjustingTime() 
					+ "','" + project.getNeedPerformanceTest() + "','" + project.getProjectRisk() + "','" + project.getRiskSolution() + "','" + project.getCreateUserID()
					+ "','" + project.getUpdateUserID() + "', getDate(), getDate())";
			
			stat.executeUpdate(insertProject);			
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
	


	public Map<String, Object> getInfoByProject(String group, String project){
		Map<String, Object> map = new HashMap<String, Object>();
		Connection conn = (new ConnectionDB()).connectionDB();
		try{
			Statement stat = conn.createStatement();
			String sql = "select a.id, a.projectType, a.centerId,a.groupId from Project a left join PP_Group b on a.GroupID = b.id "
					+ "where b.groupName = '" + group + "' and a.projectName = '" + project + "';";
			
			ResultSet rs=stat.executeQuery(sql);
			while(rs.next()){
				map.put("id", rs.getInt("id"));
				map.put("projectType", rs.getInt("projectType"));
			}
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return map;
	}
	
}
