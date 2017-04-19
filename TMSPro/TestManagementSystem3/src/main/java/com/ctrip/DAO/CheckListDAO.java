package com.ctrip.DAO;

import java.sql.Connection;
import java.sql.Statement;
import java.util.Map;

import com.ctrip.Model.CheckList;
import com.ctrip.Utility.ConnectionDB;

public class CheckListDAO {
	/*
	 * author:full
	 */
	public String saveCheckList(CheckList checkList){
		Boolean autoCommit = true;
		Connection conn = (new ConnectionDB()).connectionDB();
		String result = "";
		
		try{
			autoCommit = conn.getAutoCommit();//获得当前状态
			conn.setAutoCommit(false);//关闭自动提交功能
			Statement stat = conn.createStatement();
			
			ProjectDAO projectInfo = new ProjectDAO();
			Map<String, Object> map = projectInfo.getInfoByProject(checkList.getGroupName(), checkList.getProjectName());
			String projectType = (String.valueOf(map.get("projectType")));
			
			int taskID = 0, CRID = '0';
			if(projectType.equals("0")){
				taskID = (new TaskDAO()).getIdByTask(checkList.getGroupName(), checkList.getProjectName(), checkList.getTaskName());
				checkList.setTaskID(taskID);
			}else if(projectType.equals("1")){
				CRID = (Integer) map.get("id");
				checkList.setCRID(CRID);
			}
			
			if(taskID==0 && CRID==0){
				throw new Exception("saveCheckList: 数据格式错误！");
			}
			
			String insertChecklist = "insert into [CheckList] ([TaskID],[CRID],[DeliverTime],[DeliverVersion],"
					+ "[UATClog],[DBRedis],[BUDependence],[BugCheck],[BranchCheck],[DevStatus],[TestStatus],"
					+ "[Remark],[CreateTime],[UpdateTime]) values ('" + checkList.getTaskID() + "','" + checkList.getCRID()
					+ "','"+ checkList.getDeliverTime() + "','" + checkList.getDeliverVersion() + "','" + checkList.getUATClog()
					+ "','" + checkList.getDBRedis() + "','" + checkList.getBUDependence() + "','" + checkList.getBugCheck()
					+ "','" + checkList.getBranchCheck() + "','" + checkList.getDevStatus() + "','" + checkList.getTestStatus()
					+ "','" + checkList.getRemark() + "',getDate(),getDate())";
			
			stat.executeUpdate(insertChecklist);
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
	public String updateCheckList(CheckList checkList){
		Boolean autoCommit = true;
		Connection conn = (new ConnectionDB()).connectionDB();
		String result = "";
		
		try{
			autoCommit = conn.getAutoCommit();//获得当前状态
			conn.setAutoCommit(false);//关闭自动提交功能
			Statement stat = conn.createStatement();
			
			ProjectDAO projectInfo = new ProjectDAO();
			Map<String, Object> map = projectInfo.getInfoByProject(checkList.getGroupName(), checkList.getProjectName());
			String projectType = (String.valueOf(map.get("projectType")));
			
			int taskID = 0, CRID = '0';
			if(projectType.equals("0")){
				taskID = (new TaskDAO()).getIdByTask(checkList.getGroupName(), checkList.getProjectName(), checkList.getTaskName());
				checkList.setTaskID(taskID);
			}else if(projectType.equals("1")){
				CRID = (Integer) map.get("id");
				checkList.setCRID(CRID);
			}
			
			if(taskID==0 && CRID==0){
				throw new Exception("saveCheckList: 数据格式错误！");
			}
			
			String updateChecklist = "update CheckList set TaskID = '" + checkList.getTaskID() + "', "
					+ "CRID = '" + checkList.getCRID() + "', DeliverTime = '" + checkList.getDeliverTime()
					+ "', DeliverVersion = '" + checkList.getDeliverVersion() + "', UATClog = '" + checkList.getUATClog()
					+ "', DBRedis = '" + checkList.getDBRedis() + "', BUDependence = '" + checkList.getBUDependence()
					+ "', BugCheck = '" + checkList.getBugCheck() + "', BranchCheck = '" + checkList.getBranchCheck()
					+ "', DevStatus = '" + checkList.getDevStatus() + "', TestStatus = '" + checkList.getTestStatus()
					+ "', Remark = '" + checkList.getRemark() + "', UpdateTime = getDate() where id = '" + checkList.getId() + "'";
			
			stat.executeUpdate(updateChecklist);
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

}
