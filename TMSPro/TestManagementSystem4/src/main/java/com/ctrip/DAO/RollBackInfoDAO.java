package com.ctrip.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ctrip.Model.RollBackInfo;
import com.ctrip.Utility.ConnectionDB;

public class RollBackInfoDAO {
	
	/*
	 * 新增
	 */
	public String addRollBackInfo(RollBackInfo backInfo){
		Boolean autoCommit = true;
		Connection conn=(new ConnectionDB()).connectionDB();
		String result = "";
		try
		{
			autoCommit=conn.getAutoCommit();
			conn.setAutoCommit(false);
			Statement state=conn.createStatement();
			
			String addSql="insert into ProcessPlatform..RollbackInfo(RollbackType,ropid,ReleaseVersion,groupId,"
					+ "StartTime,EndTime,RollbackReason,Developer,Tester,backCategoryId,backGroupId,Description,"
					+ "CreateUserID,UpdateUserID,CreateTime,UpdateTime,productId,departmentId,centerId) VALUES "
					+ "('"+backInfo.getRollbackType()+"','"+backInfo.getRopid()+"','"+backInfo.getReleaseVersion()+"',"
					+ ""+backInfo.getGroupId()+",'"+backInfo.getStartTime()+"','"+backInfo.getEndTime()+"',"
				    + "'"+backInfo.getRollbackReason()+"',"+backInfo.getDeveloperId()+","+backInfo.getTesterId()+","
				    + ""+backInfo.getBackCategoryId()+","+backInfo.getBackGroupId()+",'"+backInfo.getDescription()+"',"
				    + ""+backInfo.getCreateUserId()+","+backInfo.getUpdateUserId()+",getDate(),getDate(),"
				    + ""+backInfo.getProductId()+","+backInfo.getDepartmentId()+","+backInfo.getCenterId()+");";
			
			state.executeUpdate(addSql);
			conn.commit();
			
			conn.setAutoCommit(autoCommit);
			result="Success";
			
		}catch(Exception e){
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
	 * 更新
	 */
	public String updateRollBackInfo(RollBackInfo backInfo){
		Connection conn=(new ConnectionDB()).connectionDB();
		Boolean autoCommit=true;
		String result="";
		try{
			autoCommit=conn.getAutoCommit();
			conn.setAutoCommit(false);
			Statement state=conn.createStatement();
			
			String updateSql="update ProcessPlatform..dbo.RollbackInfo set RollbackType='"+backInfo.getRollbackType()+"',"
					+ "ropid='"+backInfo.getRopid()+"',ReleaseVersion='"+backInfo.getReleaseVersion()+"',"
					+ "groupId="+backInfo.getGroupId()+",StartTime='"+backInfo.getStartTime()+"',"
					+ "EndTime='"+backInfo.getEndTime()+"',RollbackReason='"+backInfo.getRollbackReason()+"',"
					+ "Developer="+backInfo.getDeveloperId()+",Tester="+backInfo.getTesterId()+","
					+ "backCategoryId="+backInfo.getBackCategoryId()+",backGroupId="+backInfo.getBackGroupId()+","
					+ "Description='"+backInfo.getDescription()+"',UpdateUserID="+backInfo.getUpdateUserId()+","
					+ "UpdateTime=getDate(),departmentId="+backInfo.getDepartmentId()+","
					+ "centerId="+backInfo.getCenterId()+",productId="+backInfo.getProductId()+" where id="+backInfo.getId()+"";
			int affectedLine=state.executeUpdate(updateSql);
			if(affectedLine==1){
				result="Success";
			}else{
				result="Error:更新失败！";
			}
			conn.commit();
			conn.setAutoCommit(autoCommit);
		}catch(Exception e){
			result = e.toString();
			try{
				conn.rollback();
			}catch(Exception ro){
				ro.printStackTrace();
			}
		}
		return result;
	}
	
	/*
	 * 查询
	 */
	public List<RollBackInfo> getRollBackInfos(RollBackInfo backInfo){
		Connection conn=(new ConnectionDB()).connectionDB();
		List<RollBackInfo> list=new ArrayList<RollBackInfo>();
		
		try{
			Statement state=conn.createStatement();
			String querySql="select r.*,c.RollbackCategory,g.RollbackGroup,gp.GroupName,p.productName "
					+ " from ProcessPlatform..RollbackInfo r join ProcessPlatform..RollbackCategory c "
					+ "on c.id=r.backCategoryId join ProcessPlatform..RollbackGroup g on g.id=r.backGroupId "
					+ "join ProcessPlatform..PP_Group gp on gp.id=r.groupId "
					+ "join ProcessPlatform..Product p on p.id=r.productId "
					+ " where r.CreateTime>='"+backInfo.getBeginDate()+"' and r.CreateTime<='"+backInfo.getEndDate()+"' "
					+ " and r.groupId="+backInfo.getGroupId()+" ";
			if(backInfo.getProductId()!=null && backInfo.getProductId()>0){
				querySql=querySql+" and r.productId="+backInfo.getProductId()+"";		
			}
			ResultSet rSet=state.executeQuery(querySql);
			while (rSet.next()) {
				RollBackInfo rbinfo = new RollBackInfo();
				rbinfo.setId(Integer.valueOf(rSet.getString("id")));
				rbinfo.setRollbackType(rSet.getString("RollbackType"));
				rbinfo.setRopid(rSet.getString("ropid"));
				rbinfo.setReleaseVersion(rSet.getString("ReleaseVersion"));
				rbinfo.setGroupId(Integer.valueOf(rSet.getString("groupId")));
				rbinfo.setGroupName(rSet.getString("GroupName"));
				rbinfo.setProductName(rSet.getString("productName"));
				rbinfo.setStartTime(rSet.getString("StartTime"));
				rbinfo.setEndTime(rSet.getString("EndTime"));
				rbinfo.setRollbackReason(rSet.getString("RollbackReason"));
				rbinfo.setDeveloperId(Integer.valueOf(rSet.getString("Developer")));
				rbinfo.setTesterId(Integer.valueOf(rSet.getString("Tester")));
				rbinfo.setBackCategoryId(Integer.valueOf(rSet.getString("backCategoryId")));
				rbinfo.setBackCategory(rSet.getString("RollbackCategory"));
				rbinfo.setBackGroupId(Integer.valueOf(rSet.getString("backGroupId")));
				rbinfo.setBackGroup(rSet.getString("RollbackGroup"));
				rbinfo.setDescription(rSet.getString("Description"));
				rbinfo.setCreateUserId(Integer.valueOf(rSet.getString("CreateUserID")));
				rbinfo.setUpdateUserId(Integer.valueOf(rSet.getString("UpdateUserID")));
				list.add(rbinfo);
			}	
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return list;
	}
	
	/*
	 * 根据回退原因类型查id
	 */
	public int getIdByBackCategory(String backCategory){
		int backCategoryId = 0;
		Connection conn = (new ConnectionDB()).connectionDB();
		try{
			Statement stat = conn.createStatement();
			String sql = "select id from ProcessPlatform..RollbackCategory where RollbackCategory = '" + backCategory + "'";
			
			ResultSet rs=stat.executeQuery(sql);
			while(rs.next()){
				backCategoryId = rs.getInt("id");
			}
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return backCategoryId;
	}
	
	/*
	 * 根据回退原因分组查id
	 */
	public int getIdByBackGroup(String backGroup){
		int backGroupId = 0;
		Connection conn = (new ConnectionDB()).connectionDB();
		try{
			Statement stat = conn.createStatement();
			String sql = "select id from ProcessPlatform..RollbackGroup where RollbackGroup = '" + backGroup + "'";
			
			ResultSet rs=stat.executeQuery(sql);
			while(rs.next()){
				backGroupId = rs.getInt("id");
			}
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return backGroupId;
	}
	
	/*
	 * 根据id查用户域账号
	 */
	public String getUserAliasById(int id){
		String userAlias="";
		Connection conn = (new ConnectionDB()).connectionDB();
		try{
			Statement stat = conn.createStatement();
			String sql = "select UserAlias from ProcessPlatform..PP_User where id = " + id + "";
			
			ResultSet rs=stat.executeQuery(sql);
			while(rs.next()){
				userAlias = rs.getString("UserAlias");
		    }
			conn.close();
	    }catch(Exception e){
	    	e.printStackTrace();
	    }
        return userAlias;
    }
	
	/*
	 * 级联查询回退原因分类
	 */
	public List<RollBackInfo> getRollbackCategory(){
		List<RollBackInfo> list=new ArrayList<RollBackInfo>();
		Connection conn = (new ConnectionDB()).connectionDB();
		try{
			Statement stat=conn.createStatement();
			String sql="select id,RollbackCategory from processplatform..RollbackCategory where"
					+ " id!=0";
			ResultSet rs=stat.executeQuery(sql);
			while(rs.next()){
				RollBackInfo rollBackInfo=new RollBackInfo();
				rollBackInfo.setBackCategoryId(rs.getInt("id"));
				rollBackInfo.setBackCategory(rs.getString("RollbackCategory"));
				list.add(rollBackInfo);
			}
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
	
	/*
	 * 级联通过回退原因分类id查询回退原因分组
	 */
	public List<RollBackInfo> getRollbackGroupByBackCategory(RollBackInfo rollBackInfo){
		List<RollBackInfo> list=new ArrayList<RollBackInfo>();
		Connection conn = (new ConnectionDB()).connectionDB();
		try{
			Statement stat=conn.createStatement();
			String sql="select id,RollbackGroup from processplatform..RollbackGroup where"
					+ " backCategoryId="+rollBackInfo.getBackCategoryId()+"";
			ResultSet rs=stat.executeQuery(sql);
			while(rs.next()){
				RollBackInfo rBackInfo=new RollBackInfo();
				rBackInfo.setBackGroupId(rs.getInt("id"));
				rBackInfo.setBackGroup(rs.getString("RollbackGroup"));
				list.add(rBackInfo);
			}
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
}
