package com.ctrip.DAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import com.ctrip.Model.DateByWeek;
import com.ctrip.Model.TestData;
import com.ctrip.Utility.ConnectionDB;

public class TestDataDAO {
	
	private HttpClientContext context = HttpClientContext.create();
	
	/*
	 * 查询bug信息汇总
	 */
	public List<TestData> getBugInfoByTestUsers(TestData testData){
		List<TestData> bugInfoList=new ArrayList<TestData>();
		String result="";
		try{
			String sec=getSecById(1);
			String jqlTestBugInfo="reporter in('"+testData.getTestUsers()+"') AND issuetype=bug "
					+ "AND createdDate >='"+testData.getBeginDate()+"' AND createdDate<='"+testData.getEndDate()+"'";
			
			String jqlCloAndResBugInfo="reporter in ('"+testData.getTestUsers()+"')  AND issuetype=bug "
					+ "AND createdDate >='"+testData.getBeginDate()+"' AND createdDate<='"+testData.getEndDate()+"' "
				    + "and status in (closed,Resolved)";
			
			String jqlWontFixBugInfo="reporter in ('"+testData.getTestUsers()+"')  AND issuetype=bug "
					+ "AND createdDate >='"+testData.getBeginDate()+"' AND createdDate<='"+testData.getEndDate()+"'  "
					+ "and status in (closed,Resolved) and resolution was \"Won\'t Fix\"";
			
			String jqlProBugInfo="project=PLABUG AND createdDate >='"+testData.getBeginDate()+"' AND createdDate<='"+testData.getEndDate()+"' "
					+ "AND (assignee in('"+testData.getTestUsers()+"') or watcher in('"+testData.getTestUsers()+"'))";
			
			
			String jqlAvailAndPriority1BugInfo="reporter in ('"+testData.getTestUsers()+"')  AND issuetype=bug "
					+ "AND createdDate >='"+testData.getBeginDate()+"' AND createdDate<='"+testData.getEndDate()+"'  "
					+ "and status in (closed,Resolved) and resolution was not \"Won\'t Fix\" AND priority =1";
			String jqlAvailAndPriority2BugInfo="reporter in ('"+testData.getTestUsers()+"')  AND issuetype=bug "
					+ "AND createdDate >='"+testData.getBeginDate()+"' AND createdDate<='"+testData.getEndDate()+"'  "
					+ "and status in (closed,Resolved) and resolution was not \"Won\'t Fix\" AND priority =2";
			String jqlAvailAndPriority3BugInfo="reporter in ('"+testData.getTestUsers()+"')  AND issuetype=bug "
					+ "AND createdDate >='"+testData.getBeginDate()+"' AND createdDate<='"+testData.getEndDate()+"'  "
					+ "and status in (closed,Resolved) and resolution was not \"Won\'t Fix\" AND priority =3";
			String jqlAvailAndPriority4BugInfo="reporter in ('"+testData.getTestUsers()+"')  AND issuetype=bug "
					+ "AND createdDate >='"+testData.getBeginDate()+"' AND createdDate<='"+testData.getEndDate()+"'  "
					+ "and status in (closed,Resolved) and resolution was not \"Won\'t Fix\" AND priority =4";
			String jqlAvailAndPriority5BugInfo="reporter in ('"+testData.getTestUsers()+"')  AND issuetype=bug "
					+ "AND createdDate >='"+testData.getBeginDate()+"' AND createdDate<='"+testData.getEndDate()+"'  "
					+ "and status in (closed,Resolved) and resolution was not \"Won\'t Fix\" AND priority =5";
			String jqlProAndPriority1BugInfo="project=PLABUG AND createdDate >='"+testData.getBeginDate()+"' AND "
					+ "createdDate<='"+testData.getEndDate()+"' "
					+ "AND (assignee in('"+testData.getTestUsers()+"') or watcher in('"+testData.getTestUsers()+"')) "
					+ "AND priority =1";
			String jqlProAndPriority2BugInfo="project=PLABUG AND createdDate >='"+testData.getBeginDate()+"' AND "
					+ "createdDate<='"+testData.getEndDate()+"' "
					+ "AND (assignee in('"+testData.getTestUsers()+"') or watcher in('"+testData.getTestUsers()+"')) "
					+ "AND priority =2";
			String jqlProAndPriority3BugInfo="project=PLABUG AND createdDate >='"+testData.getBeginDate()+"' AND "
					+ "createdDate<='"+testData.getEndDate()+"' "
					+ "AND (assignee in('"+testData.getTestUsers()+"') or watcher in('"+testData.getTestUsers()+"')) "
					+ "AND priority =3";
			String jqlProAndPriority4BugInfo="project=PLABUG AND createdDate >='"+testData.getBeginDate()+"' AND "
					+ "createdDate<='"+testData.getEndDate()+"' "
					+ "AND (assignee in('"+testData.getTestUsers()+"') or watcher in('"+testData.getTestUsers()+"')) "
					+ "AND priority =4";
			String jqlProAndPriority5BugInfo="project=PLABUG AND createdDate >='"+testData.getBeginDate()+"' AND "
					+ "createdDate<='"+testData.getEndDate()+"' "
					+ "AND (assignee in('"+testData.getTestUsers()+"') or watcher in('"+testData.getTestUsers()+"')) "
					+ "AND priority =5";
			
			
			String url="http://cp4.mgmt.ctripcorp.com/rest/api/2/search";
			JSONObject jsonParam1=new JSONObject();
			jsonParam1.put("jql", jqlTestBugInfo);
			jsonParam1.put("maxResults", 500);
			result = postUrl(url,jsonParam1,sec);
		    JSONObject jsonObject1 = new JSONObject(result);
	        int totalTestBugs = jsonObject1.getInt("total");//测试提交的bug数--线下bug数
	        int prdAndDevNum=getStringNums(result,"http://cp4.mgmt.ctripcorp.com/rest/api/2/customFieldOption/10013")
	        		+getStringNums(result,"http://cp4.mgmt.ctripcorp.com/rest/api/2/customFieldOption/10004");//--产品/架构建议数
	        System.out.println(prdAndDevNum);
	        
	        JSONObject jsonParam2=new JSONObject();
			jsonParam2.put("jql", jqlCloAndResBugInfo);
			jsonParam2.put("maxResults", 500);
	        result=postUrl(url, jsonParam2, sec);
	        JSONObject jsonObject2 = new JSONObject(result);
	        int totalCloAndResBugs=jsonObject2.getInt("total");//已解决和关闭的bug数--已修复bug数
	        System.out.println(totalCloAndResBugs);
	        
	        JSONObject jsonParam3=new JSONObject();
			jsonParam3.put("jql", jqlWontFixBugInfo);
			jsonParam3.put("maxResults", 500);
	        result=postUrl(url, jsonParam3, sec);
	        JSONObject jsonObject3 = new JSONObject(result);
	        int totalWontFixBugs=jsonObject3.getInt("total");//无需修复的bug数
	        int totalAvailBugs=totalTestBugs-totalWontFixBugs;//--线下有效bug数
	        System.out.println(totalAvailBugs);
	        
	        JSONObject jsonParam4=new JSONObject();
			jsonParam4.put("jql", jqlProBugInfo);
			jsonParam4.put("maxResults", 500);
	        result=postUrl(url, jsonParam4, sec);
	        JSONObject jsonObject4 = new JSONObject(result);
	        int totalProBugs=jsonObject4.getInt("total");//生产故障bug数--线上bug数
	        System.out.println(totalProBugs);
	        
	        int totalAvailAndPriority1Bugs=getBugNum(jqlAvailAndPriority1BugInfo,url,sec);
	        System.out.println(totalAvailAndPriority1Bugs);
	        int totalAvailAndPriority2Bugs=getBugNum(jqlAvailAndPriority2BugInfo,url,sec);
	        System.out.println(totalAvailAndPriority2Bugs);
	        int totalAvailAndPriority3Bugs=getBugNum(jqlAvailAndPriority3BugInfo,url,sec);
	        System.out.println(totalAvailAndPriority3Bugs); 
	        int totalAvailAndPriority4Bugs=getBugNum(jqlAvailAndPriority4BugInfo,url,sec);
	        System.out.println(totalAvailAndPriority4Bugs);
	        int totalAvailAndPriority5Bugs=getBugNum(jqlAvailAndPriority5BugInfo,url,sec);
	        System.out.println(totalAvailAndPriority5Bugs);
	        int testBugScore=totalAvailAndPriority1Bugs*5+totalAvailAndPriority2Bugs*4+totalAvailAndPriority3Bugs*3
	        		+totalAvailAndPriority4Bugs*2+totalAvailAndPriority5Bugs*1;//线下bug分值
	        System.out.println(testBugScore);
	        
	        int toatlProAndPriority1Bugs=getBugNum(jqlProAndPriority1BugInfo,url,sec);
	        int toatlProAndPriority2Bugs=getBugNum(jqlProAndPriority2BugInfo,url,sec);
	        int toatlProAndPriority3Bugs=getBugNum(jqlProAndPriority3BugInfo,url,sec);
	        int toatlProAndPriority4Bugs=getBugNum(jqlProAndPriority4BugInfo,url,sec);
	        int toatlProAndPriority5Bugs=getBugNum(jqlProAndPriority5BugInfo,url,sec);
	        int proBugScore=toatlProAndPriority1Bugs*5+toatlProAndPriority2Bugs*4+toatlProAndPriority3Bugs*3
	        		+toatlProAndPriority4Bugs*2+toatlProAndPriority5Bugs*1;
	        System.out.println(proBugScore);
	        String lostPercent = null;//故障漏测率故障遗失率
	        NumberFormat percentFormat =NumberFormat.getPercentInstance();
	        if(testBugScore!=0){
	        	lostPercent=percentFormat.format((double)proBugScore/(double)testBugScore);
	        }else if(testBugScore==0){
	        	lostPercent="100%";
	        }
	           
	        TestData tData=new TestData();
	        tData.setTestUsers(testData.getTestUsers());
	        tData.setTestBugNum(totalTestBugs);
	        tData.setTestBugScore(testBugScore);
	        tData.setAvailBugNum(totalAvailBugs);
	        tData.setCloAndResBugNum(totalCloAndResBugs);
	        tData.setProBugNum(totalProBugs);
	        tData.setProBugScore(proBugScore);
	        tData.setLostPercent(lostPercent);
	        tData.setPrdAndDevNum(prdAndDevNum);
	        bugInfoList.add(tData);    
			
		}catch(Exception e){
			e.printStackTrace();
		}
		 return bugInfoList;
	}
	
	/*
	 * 查询故障漏测率
	 */
	public List<TestData> getLostPercentByTestUsers(TestData testData){
		List<TestData> listLostPercent =new ArrayList<TestData>();
		try{
			String sec=getSecById(1);
			String url="http://cp4.mgmt.ctripcorp.com/rest/api/2/search";
			String jqlAvailAndPriority1BugInfo="reporter in ('"+testData.getTestUsers()+"')  AND issuetype=bug "
					+ "AND createdDate >='"+testData.getBeginDate()+"' AND createdDate<='"+testData.getEndDate()+"'  "
					+ "and status in (closed,Resolved) and resolution was not \"Won\'t Fix\" AND priority =1";
			String jqlAvailAndPriority2BugInfo="reporter in ('"+testData.getTestUsers()+"')  AND issuetype=bug "
					+ "AND createdDate >='"+testData.getBeginDate()+"' AND createdDate<='"+testData.getEndDate()+"'  "
					+ "and status in (closed,Resolved) and resolution was not \"Won\'t Fix\" AND priority =2";
			String jqlAvailAndPriority3BugInfo="reporter in ('"+testData.getTestUsers()+"')  AND issuetype=bug "
					+ "AND createdDate >='"+testData.getBeginDate()+"' AND createdDate<='"+testData.getEndDate()+"'  "
					+ "and status in (closed,Resolved) and resolution was not \"Won\'t Fix\" AND priority =3";
			String jqlAvailAndPriority4BugInfo="reporter in ('"+testData.getTestUsers()+"')  AND issuetype=bug "
					+ "AND createdDate >='"+testData.getBeginDate()+"' AND createdDate<='"+testData.getEndDate()+"'  "
					+ "and status in (closed,Resolved) and resolution was not \"Won\'t Fix\" AND priority =4";
			String jqlAvailAndPriority5BugInfo="reporter in ('"+testData.getTestUsers()+"')  AND issuetype=bug "
					+ "AND createdDate >='"+testData.getBeginDate()+"' AND createdDate<='"+testData.getEndDate()+"'  "
					+ "and status in (closed,Resolved) and resolution was not \"Won\'t Fix\" AND priority =5";
			String jqlProAndPriority1BugInfo="project=PLABUG AND createdDate >='"+testData.getBeginDate()+"' AND "
					+ "createdDate<='"+testData.getEndDate()+"' "
					+ "AND (assignee in('"+testData.getTestUsers()+"') or watcher in('"+testData.getTestUsers()+"')) "
					+ "AND priority =1";
			String jqlProAndPriority2BugInfo="project=PLABUG AND createdDate >='"+testData.getBeginDate()+"' AND "
					+ "createdDate<='"+testData.getEndDate()+"' "
					+ "AND (assignee in('"+testData.getTestUsers()+"') or watcher in('"+testData.getTestUsers()+"')) "
					+ "AND priority =2";
			String jqlProAndPriority3BugInfo="project=PLABUG AND createdDate >='"+testData.getBeginDate()+"' AND "
					+ "createdDate<='"+testData.getEndDate()+"' "
					+ "AND (assignee in('"+testData.getTestUsers()+"') or watcher in('"+testData.getTestUsers()+"')) "
					+ "AND priority =3";
			String jqlProAndPriority4BugInfo="project=PLABUG AND createdDate >='"+testData.getBeginDate()+"' AND "
					+ "createdDate<='"+testData.getEndDate()+"' "
					+ "AND (assignee in('"+testData.getTestUsers()+"') or watcher in('"+testData.getTestUsers()+"')) "
					+ "AND priority =4";
			String jqlProAndPriority5BugInfo="project=PLABUG AND createdDate >='"+testData.getBeginDate()+"' AND "
					+ "createdDate<='"+testData.getEndDate()+"' "
					+ "AND (assignee in('"+testData.getTestUsers()+"') or watcher in('"+testData.getTestUsers()+"')) "
					+ "AND priority =5";
			
			int totalAvailAndPriority1Bugs=getBugNum(jqlAvailAndPriority1BugInfo,url,sec);
	        int totalAvailAndPriority2Bugs=getBugNum(jqlAvailAndPriority2BugInfo,url,sec);
	        int totalAvailAndPriority3Bugs=getBugNum(jqlAvailAndPriority3BugInfo,url,sec);
	        int totalAvailAndPriority4Bugs=getBugNum(jqlAvailAndPriority4BugInfo,url,sec);
	        int totalAvailAndPriority5Bugs=getBugNum(jqlAvailAndPriority5BugInfo,url,sec);
	        int testBugScore=totalAvailAndPriority1Bugs*5+totalAvailAndPriority2Bugs*4+totalAvailAndPriority3Bugs*3
	        		+totalAvailAndPriority4Bugs*2+totalAvailAndPriority5Bugs*1;//线下bug分值
	        
	        int toatlProAndPriority1Bugs=getBugNum(jqlProAndPriority1BugInfo,url,sec);
	        int toatlProAndPriority2Bugs=getBugNum(jqlProAndPriority2BugInfo,url,sec);
	        int toatlProAndPriority3Bugs=getBugNum(jqlProAndPriority3BugInfo,url,sec);
	        int toatlProAndPriority4Bugs=getBugNum(jqlProAndPriority4BugInfo,url,sec);
	        int toatlProAndPriority5Bugs=getBugNum(jqlProAndPriority5BugInfo,url,sec);
	        int proBugScore=toatlProAndPriority1Bugs*5+toatlProAndPriority2Bugs*4+toatlProAndPriority3Bugs*3
	        		+toatlProAndPriority4Bugs*2+toatlProAndPriority5Bugs*1;//线上故障分值
	        
	        String lostPercent = null;//故障漏测率故障遗失率
	        NumberFormat percentFormat =NumberFormat.getPercentInstance();
	        if(testBugScore!=0){
	        	lostPercent=percentFormat.format((double)proBugScore/(double)testBugScore);
	        }else if(testBugScore==0){
	        	lostPercent="100%";
	        }
	        TestData testData2=new TestData();
	        testData2.setTestUsers(testData.getTestUsers());
	        testData2.setLostPercent(lostPercent);
	        testData2.setBeginDate(testData.getBeginDate());
	        testData2.setEndDate(testData.getEndDate());
	        
	        listLostPercent.add(testData2);
        }catch(Exception e){
        	e.printStackTrace();
        }
		return listLostPercent;
	}
	
	/*
	 * 查询回退信息
	 */
 	public List<TestData> getBackInfoByTestUsers(TestData testData){
		List<TestData> backInfoList=new ArrayList<TestData>();
		try{
			 //发布回退信息
	        String dept=testData.getDepartment().trim().substring(0, 4);
	        String trackerUrl="http://tracker.tars.release.ctripcorp.com/api/v1/reports";
	        String[] testUserArray=testData.getTestUsers().split(",");
	        int totalBaoleiBack=0;
	        int totalProBack=0;
	        //int totalComTestOwnerNum=0;
	        for(int i=0;i<testUserArray.length;i++){
	        	String email = getEmailByUseralias(testUserArray[i]);
		        String rBParam_TARS_FORT_REVOKED="date_from="+testData.getBeginDate()+"&date_to="+testData.getEndDate()+""
		        		+ "&dept="+dept+"&page_size=100&mail="+email+"&event_type=TARS_FORT_REVOKED&format=json";
		        String rBParam_TARS_REVOKED="date_from="+testData.getBeginDate()+"&date_to="+testData.getEndDate()+""
		        		+ "&dept="+dept+"&page_size=100&mail="+email+"&event_type=TARS_REVOKED&format=json";
		        String rBParam_TARS_ROLLBACK="date_from="+testData.getBeginDate()+"&date_to="+testData.getEndDate()+""
		        		+ "&dept="+dept+"&page_size=100&mail="+email+"&event_type=TARS_ROLLBACK&format=json";
		        String result_TARS_FORT_REVOKED=getUrl(trackerUrl,rBParam_TARS_FORT_REVOKED);
		        int TARS_FORT_REVOKED_num=getStringNums(result_TARS_FORT_REVOKED,"TARS_FORT_REVOKED");
		        String result_TARS_REVOKED=getUrl(trackerUrl,rBParam_TARS_REVOKED);
		        int TARS_REVOKED_num=getStringNums(result_TARS_REVOKED,"TARS_REVOKED");
		        String result_TARS_ROLLBACK=getUrl(trackerUrl,rBParam_TARS_ROLLBACK);
		        int TARS_ROLLBACK_num=getStringNums(result_TARS_ROLLBACK,"TARS_ROLLBACK");
		        totalBaoleiBack+=TARS_FORT_REVOKED_num;
		        totalProBack+=(TARS_REVOKED_num+TARS_ROLLBACK_num);
		        //totalComTestOwnerNum+=getComTestOwnerNum(testUserArray[i], testData.getBeginDate(), testData.getEndDate());
	        }
	        TestData tData=new TestData();
	        tData.setBaoleiBackNum(totalBaoleiBack);
	        tData.setProBackNum(totalProBack);
	        //tData.setComTestOwnerNum(totalComTestOwnerNum);
	        backInfoList.add(tData);
		}catch(Exception e){
			e.printStackTrace();
		}
		return backInfoList;
	}
	
	/*
	 * 获取不同条件的bug数量
	 */
	public int getBugNum(String jql,String url,String sec){
        int bugNum=-100;
		JSONObject jsonParam=new JSONObject();
		jsonParam.put("jql", jql);
		jsonParam.put("maxResults", 500);
        String result;
		try {
			result = postUrl(url, jsonParam, sec);
			JSONObject jsonObject = new JSONObject(result);
			bugNum=jsonObject.getInt("total");
		} catch (Exception e) {
			e.printStackTrace();
		}     
        return bugNum;
	}

	/*
	 * 获取字符串个数
	 * 注意检查的字符串要求头尾字符不一样
	 */
	public int getStringNums(String ostr,String fstr){
		int num=0;
		if(ostr.indexOf(fstr) != -1)  
	    { 
	        String[] str1 = ostr.split(fstr);  
	        num=str1.length-1;  
	    }  
	    else   
	    {  
	    	num=0;  
	    }
		return num;
	}
	/*
	 * basic验证,post
	 */
	public String postUrl(String url,JSONObject jsonRequest,String sec) throws Exception{
		String result="";      
        CloseableHttpClient httpclient = null; 
        CloseableHttpResponse response = null; 
        try {  
        	String auth="fenggao:" + sec;
    	    byte[] encodedAuth = Base64.encodeBase64(auth.getBytes("utf-8"));
    	    String authHeader = "Basic " + new String(encodedAuth);
            httpclient = HttpClients.createDefault();        
            HttpPost method = new HttpPost(url);  	          
  
            StringEntity entity = new StringEntity(jsonRequest.toString(),"utf-8");
	        entity.setContentEncoding("UTF-8");    
	        entity.setContentType("application/json");    
	        method.setEntity(entity);
	        method.setHeader(HttpHeaders.AUTHORIZATION, authHeader);
	        //设置超时时间
	        RequestConfig requestConfig = RequestConfig.custom()
	        		.setConnectTimeout(10000).setConnectionRequestTimeout(20000).setSocketTimeout(30000).build(); 
	        method.setConfig(requestConfig);
	        
            response = httpclient.execute(method,context);    	        
            HttpEntity responseentity = response.getEntity();    
            if (null!=responseentity) {    
            	result=EntityUtils.toString(responseentity, "UTF-8");    
            }    
        }catch (Exception e) {  
           e.printStackTrace();
        }finally{  
        	httpclient.close();
        	response.close();
        }   
        return result;
	}
	
	/*
	 * get
	 */
	public String getUrl(String url,String param) throws IOException{
		String result="";
		CloseableHttpClient httpclient = null; 
        CloseableHttpResponse response = null;
        try{
        	httpclient = HttpClients.createDefault();
        	String uriString=url+"?"+param;
        	HttpGet httpGet=new HttpGet(uriString);
        	response=httpclient.execute(httpGet);
        	HttpEntity responseentity = response.getEntity();    
            if (null!=responseentity) {    
            	result=EntityUtils.toString(responseentity, "UTF-8");    
            }    
        }catch(Exception e){
        	e.printStackTrace();
        }finally{  
        	httpclient.close();
        	response.close();
        }   
        return result;		
	}
	
	/*
	 * 获取验证码
	 */
	public String getSecById(int id){
		String sec="";
		Connection conn = (new ConnectionDB()).connectionDB();
		try{
			Statement stat = conn.createStatement();
			String sql = "select sec from ProcessPlatform..Sec where id = " + id + "";
			
			ResultSet rs=stat.executeQuery(sql);
			while(rs.next()){
				sec = rs.getString("sec");
		    }
			conn.close();
	    }catch(Exception e){
	    	e.printStackTrace();
	    }
        return sec;
	}

	/*
	 * 根据域账号查email
	 */
	public String getEmailByUseralias(String userAlias){
		String email="";
		Connection conn = (new ConnectionDB()).connectionDB();
		try{
			Statement stat =conn.createStatement();
			String sql="select Email from Processplatform..PP_User where UserAlias='"+userAlias+"'";
			ResultSet rs = stat.executeQuery(sql);
			while(rs.next()){
				email=rs.getString("Email");
			}
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return email;
	}
	
	/*
	 * 获取一段时间做联调owner的次数
	 */
	public int getComTestOwnerNum(String userAlias,String beginDate,String endDate){
		int num=0;
		int userId=PP_UserDAO.getIdByuserAlias(userAlias);
		Connection conn = (new ConnectionDB()).connectionDB();
		try{
			Statement stat=conn.createStatement();
			String sql ="select count(id) from Processplatform..task where CombinedAdjustingOwner="+userId+""
					+ " and CombinedAdjustingTime>='"+beginDate+"' and CombinedAdjustingTime<='"+endDate+"'";
			ResultSet rs=stat.executeQuery(sql);
			while(rs.next()){
				num=rs.getInt(1);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return num;
	}
	
	/*
	 * 通过groupid查询测试用户
	 */
	public String getTestUsersByGroupId(int groupId){
		String testUsers="";
		Connection conn = (new ConnectionDB()).connectionDB();
		try{
			Statement stat=conn.createStatement();
			String sql ="select UserAlias from processplatform..PP_User where GroupID="+groupId+""
					+ " AND UserTile =1 ";
			ResultSet rs=stat.executeQuery(sql);
			while(rs.next()){
				String testUser=rs.getString("UserAlias");
				testUsers=testUsers+","+testUser;
			}
			testUsers=testUsers.replaceFirst(",", "");
		}catch(Exception e){
			e.printStackTrace();
		}
		return testUsers;	
	}
	
	/*
	 * 根据groupid查询groupname
	 */
	public String getGroupNameByGroupId(int groupId){
		String groupName="";
		Connection conn=(new ConnectionDB()).connectionDB();
		try{
			Statement stat=conn.createStatement();
			String sql="select GroupName from processplatform..pp_group where id="+groupId+"";
			ResultSet rs=stat.executeQuery(sql);
			while(rs.next()){
				groupName=rs.getString("GroupName");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return groupName;
	}
	
	/*
	 * 根据groupid查询测试用户数
	 */
	public int getTestUserNumByGroupId(int groupId){
		int num=0;
		Connection conn=(new ConnectionDB()).connectionDB();
		try{
			Statement stat=conn.createStatement();
			String sql="select count(UserAlias) from processplatform..PP_User where GroupID="+groupId+""
					+ " AND (UserTile =1 or UserTile=5) ";
			ResultSet rs=stat.executeQuery(sql);
			while(rs.next()){
				num=rs.getInt(1);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return num;
	}
	
	/*
	 * 根据groupid查询leader
	 */
	public String getGroupLeaderByGroupId(int groupId){
		String leader=PP_GroupDAO.getleaderbyid(groupId);
		return leader;
	}
	
	public DateByWeek getWeeksByCurrentDate(String currentDate){
		DateByWeek dByWeek=new DateByWeek();
		//List<DateByWeek> listWeeksDate= new ArrayList<DateByWeek>();
		String sunday1;
		String sunday2;
		String sunday3;
		String sunday4="";
		String sunday5;
		SimpleDateFormat sdfDate = new SimpleDateFormat( "yyyy-MM-dd" );
		SimpleDateFormat sdfWeekDay=new SimpleDateFormat("EEEE");
		GregorianCalendar gc=new GregorianCalendar(); 
		try {
			Date nowDate = sdfDate.parse(currentDate);//string转日期格式
			String weekDay= sdfWeekDay.format(nowDate);//日期转星期几
			gc.setTime(nowDate);
			if("星期日".equals(weekDay)){
				sunday4=sdfDate.format(nowDate);
			}else if("星期一".equals(weekDay)){
				gc.add(5,-1);
				sunday4=sdfDate.format(gc.getTime());			
			}else if("星期二".equals(weekDay)){
				gc.add(5,-2);
				sunday4=sdfDate.format(gc.getTime());	
			}else if("星期三".equals(weekDay)){
				gc.add(5,-3);
				sunday4=sdfDate.format(gc.getTime());	
			}else if("星期四".equals(weekDay)){
				gc.add(5,-4);
				sunday4=sdfDate.format(gc.getTime());	
			}else if("星期五".equals(weekDay)){
				gc.add(5,-5);
				sunday4=sdfDate.format(gc.getTime());	
			}else if("星期六".equals(weekDay)){
				gc.add(5,-6);
				sunday4=sdfDate.format(gc.getTime());	
			}
			gc.add(3,1);
			sunday5=sdfDate.format(gc.getTime());
			gc.add(3,-2);
			sunday3=sdfDate.format(gc.getTime());
			gc.add(3,-1);
			sunday2=sdfDate.format(gc.getTime());
			gc.add(3,-1);
			sunday1=sdfDate.format(gc.getTime());
			
			//DateByWeek dByWeek=new DateByWeek();
			dByWeek.setBeginDate1(sunday1);
			dByWeek.setBeginDate2(sunday2);
			dByWeek.setBeginDate3(sunday3);
			dByWeek.setBeginDate4(sunday4);
			dByWeek.setEndDate1(sunday2);
			dByWeek.setEndDate2(sunday3);
			dByWeek.setEndDate3(sunday4);
			dByWeek.setEndDate4(sunday5);
			//listWeeksDate.add(dByWeek);
				
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dByWeek;
	}
}
