package com.ctrip.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

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
			
			int productId = (new ProductDAO()).getIdByProduct(project.getProductName());
			int groupId = (new PP_GroupDAO()).getIdByGroup(project.getGroupName());
			int centerId = (new CenterDAO()).getIdByCenter(project.getCenterName());
			
			if(productId!=0 && groupId!=0 && centerId!=0){
				project.setProductId(productId);
				project.setGroupId(groupId);
				project.setCenterId(centerId);
			}
			
			PP_UserDAO userDao = new PP_UserDAO();
			int BAOwnerID = userDao.getIdByUserName(project.getBAOwner());
			int ADOwnerID = userDao.getIdByUserName(project.getADOwner());
			int STOwnerID = userDao.getIdByUserName(project.getSTOwner());
			int createUID = userDao.getIdByUserName(project.getCreateUser());
			int updateUID = userDao.getIdByUserName(project.getUpdateUser());
			if(BAOwnerID!=0 && ADOwnerID!=0 && STOwnerID!=0 && createUID!=0 && updateUID!=0){
				project.setBAOwnerId(BAOwnerID);
				project.setADOwnerId(ADOwnerID);
				project.setSTOwnerId(STOwnerID);
				project.setCreateUserID(createUID);
				project.setUpdateUserID(updateUID);
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
	
	/*
	 * author:full
	 */
	public int getIdByProject(String group, String project){
		int projectId = 0;
		Connection conn = (new ConnectionDB()).connectionDB();
		try{
			Statement stat = conn.createStatement();
			String sql = "select a.id from Project a left join PP_Group b on a.GroupID = b.id "
					+ "where b.groupName = '" + group + "' and a.projectName = '" + project + "';";
			
			ResultSet rs=stat.executeQuery(sql);
			while(rs.next()){
				projectId = rs.getInt("id");
			}
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return projectId;
	}
}
