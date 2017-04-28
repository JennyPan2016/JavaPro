<%--
  User: mianhuichen
  Date: 2017/4/14
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.ctrip.sec.sso.principal.AttributePrincipal" %>
<%@ page import="com.ctrip.sec.sso.util.AssertionHolder" %>
<%@ page import="java.util.Map" %>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0"/>
    <meta name="format-detection" content="telephone=no">
    <meta charset="UTF-8">



    <title>流程平台</title>
   	
    <!-- CSS -->
    
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/animate.min.css" rel="stylesheet">
    <link href="css/form.css" rel="stylesheet">
    <link href="css/calendar.css" rel="stylesheet">
    <link href="css/media-player.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
    <link href="css/icons.css" rel="stylesheet">
    <link href="css/generics.css" rel="stylesheet">
    <link href="css/basestyle.css" rel="stylesheet">
    
</head>
<body id="skin-blur-ocean">
<s:action name="getAllDepartment" namespace="/"></s:action>
<header id="header" class="media">
    <a href="" id="menu-toggle"></a>

    <div class="media-body">
        <div class="media" id="top-menu">
            <div id="time" class="pull-right">
                <span id="hours"></span>
                :
                <span id="min"></span>
                :
                <span id="sec"></span>
            </div>
        </div>
    </div>
</header>

<div class="clearfix"></div>

<section id="main" class="p-relative" role="main">

    <!-- Sidebar -->
    <aside id="sidebar">

        <!-- Sidbar Widgets -->
        <div class="side-widgets overflow">
            <!-- Profile Menu -->
            <div class="text-center s-widget m-b-25 dropdown" id="profile-menu">
                <a href="" data-toggle="dropdown">
                    <img class="profile-pic animated" src="img/profile-pic.jpg" alt="">
                </a>
                <ul class="dropdown-menu profile-menu">
                    <li><a href="">Sign Out</a> <i class="icon left">&#61903;</i><i class="icon right">&#61815;</i></li>
                </ul>
                <h4 class="m-0">
                    <%
                        AttributePrincipal principal = (AttributePrincipal) AssertionHolder.getAssertion().getPrincipal();
                        // 获取其他的登陆信息如下：
                        Map map = principal.getAttributes();
                        String name = (String) map.get("name");
                        out.println(name);
                    %>
                </h4>
            </div>

            <!-- Calendar -->
            <div class="s-widget m-b-25">
                <div id="sidebar-calendar"></div>
            </div>

            <!-- Feeds -->
            <!-- <div class="s-widget m-b-25">
                <h2 class="tile-title">
                   News Feeds
                </h2>

                <div class="s-widget-body">
                    <div id="news-feed"></div>
                </div>
            </div> -->

            <!-- Projects -->
            <div class="s-widget m-b-25">
                <h2 class="tile-title">
                    Projects on going
                </h2>

                <div class="s-widget-body">
                    <div class="side-border">
                        <small>Offline二月份班车</small>
                        <div class="progress progress-small">
                            <a href="#" data-toggle="tooltip" title="" class="progress-bar tooltips progress-bar-danger"
                               style="width: 60%;" data-original-title="60%">
                                <span class="sr-only">60% Complete</span>
                            </a>
                        </div>
                    </div>
                    <div class="side-border">
                        <small>UserDB解耦</small>
                        <div class="progress progress-small">
                            <a href="#" data-toggle="tooltip" title="" class="tooltips progress-bar progress-bar-info"
                               style="width: 43%;" data-original-title="43%">
                                <span class="sr-only">43% Complete</span>
                            </a>
                        </div>
                    </div>
                    <div class="side-border">
                        <small>收藏改造</small>
                        <div class="progress progress-small">
                            <a href="#" data-toggle="tooltip" title=""
                               class="tooltips progress-bar progress-bar-warning" style="width: 81%;"
                               data-original-title="81%">
                                <span class="sr-only">81% Complete</span>
                            </a>
                        </div>
                    </div>
                    <div class="side-border">
                        <small>V7.2我携服务</small>
                        <div class="progress progress-small">
                            <a href="#" data-toggle="tooltip" title=""
                               class="tooltips progress-bar progress-bar-success" style="width: 10%;"
                               data-original-title="10%">
                                <span class="sr-only">10% Complete</span>
                            </a>
                        </div>
                    </div>
                    <div class="side-border">
                        <small>V7.2无线发布</small>
                        <div class="progress progress-small">
                            <a href="#" data-toggle="tooltip" title=""
                               class="tooltips progress-bar progress-bar-success" style="width: 95%;"
                               data-original-title="95%">
                                <span class="sr-only">95% Complete</span>
                            </a>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!-- Side Menu -->
        <ul class="list-unstyled side-menu"></ul>

    </aside>

    <!-- Content -->
    <section id="content" class="container">
        <h4 class="page-title">质量数据》发布回退列表</h4>
        <div class="block-area" id="modal">
        
         <!-- Create Btn -->
            <div class="m-b-20">
                <button class="btn btn-lg m-r-5" data-toggle="modal" href="#NewRollBackModal">Create</button>
            </div>

            <!-- 新增模块 -->
            <div class="modal fade" id="NewRollBackModal" tabindex="-1" role="dialog" aria-hidden="true">
                <div class="modal-dialog modal-sm" style="width: 50%">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                            <h4 class="modal-title">新增发布回退</h4>
                        </div>
                        <div class="modal-body" id="CreateRollBackModal">
                            <div class="cl">
		                        <label class="fl tar">部门
		                        	<span style="color:red">*</span>
		                        </label>
	                            <div class="col-md-2"  style="width: 30%">
	                                <select class="form-control m-b-10" id="NewDept">
	                                	<option selected="true" disabled="true">请选择部门</option>
	                                    <c:forEach var="bQuery" items="${BaseQuery}">
											<option value="${bQuery.departmentName}">${bQuery.departmentName}</option>
										</c:forEach>
	                                </select>
	                            </div>
                            </div>
                            <div class="cl">
	                            <label class="fl tar">产品
	                            	<span style="color:red">*</span>
	                            </label>
	                            <div class="col-md-2" style="width: 30%">
	                                <select class="form-control m-b-10" id="NewCenter">
	                                    <option>用户中心</option>
	                                </select>
	                            </div>
                            </div>
                            <div class="cl">   
	                            <label class="fl tar">分组名称
	                            	<span style="color:red">*</span>
	                            </label>
	                            <div class="col-md-2" style="width: 30%">
	                                <select class="form-control m-b-10" id="NewGroup">
	                                    <option>我携订单</option>
	                                    <option>登录注册</option>
	                                    <option>首页头尾</option>
	                                    <option>常旅收藏</option>
	                                    <option>Offline</option>
	                                </select>
	                            </div>
                            </div>
                            <div class="cl">   
	                            <label class="fl tar">产线名称
	                            	<span style="color:red">*</span>
	                            </label>
	                            <div class="col-md-2" style="width: 30%">
	                                <select class="form-control m-b-10" id="NewProduct">
	                                    <option>我携订单</option>
	                                    <option>登录注册</option>
	                                    <option>首页头尾</option>
	                                    <option>常旅收藏</option>
	                                    <option>Offline</option>
	                                </select>
	                            </div>
                            </div>
                            <div class="cl">
	                            <label class="fl tar">开发人员：</label>
	                            <div class="col-lg-2" style="width: 30%">
	                                <input type="text" class="form-control m-b-10" id="Developer" placeholder="请输入开发人员">
	                            </div>
                            </div>
                            <div class="cl">
	                            <label class="fl tar">测试人员：</label>
	                            <div class="col-lg-2" style="width: 30%">
	                                <input type="text" class="form-control m-b-10" id="Tester" placeholder="请输入测试人员">
	                            </div>
                            </div>
                            <div class="cl">
	                            <label class="fl tar">回退类型：</label>
	                            <div class="col-md-2" style="width: 30%">
	                                <select class="form-control m-b-10" id="RollbackType">
	                                    <option>堡垒终止</option>
	                                    <option>Rolling终止</option>
	                                    <option>回滚</option>
	                                </select>
	                            </div>
                            </div>
                            <div class="cl">
	                            <label class="fl tar">Ropid：</label>
	                            <div class="col-lg-2" style="width: 70%">
	                                <input type="text" class="form-control m-b-10" id="RopId" placeholder="请输入Rop版本">
	                            </div>
                            </div>
                            <div class="cl">
	                            <label class="fl tar">发布版本：</label>
	                            <div class="col-lg-2" style="width: 70%">
	                                <input type="text" class="form-control m-b-10" id="ReleaseVersion" placeholder="请输入发布名称">
	                            </div>
                            </div>
                            <div class="cl">
	                            <label class="fl tar">开始执行时间：</label>
	                            <div class="col-lg-2" style="width: 70%">
	                                <input type="text" class="form-control m-b-10" id="StartTime" placeholder="请输入开始时间">
	                            </div>
                            </div>
                            <div class="cl">
	                            <label class="fl tar">结束时间：</label>
	                            <div class="col-lg-2" style="width: 70%">
	                                <input type="text" class="form-control m-b-10" id="EndTime" placeholder="请输入结束时间">
	                            </div>
                            </div>
                            <div class="cl">
	                            <label class="fl tar">回退原因分类：</label>
	                            <div class="col-md-2" style="width: 50%">
	                                <select class="form-control m-b-10" id="RollBack">
	                                    <option>环境问题</option>
	                                    <option>依赖问题</option>
	                                </select>
	                            </div>
                            </div>
                            <div class="cl">
	                            <label class="fl tar">分组原因分类：</label>
	                            <div class="col-md-2" style="width: 50%">
	                                <select class="form-control m-b-10" id="GroupReason">
	                                    <option>环境问题</option>
	                                    <option>依赖问题</option>
	                                </select>
	                            </div>
                            </div>
                            <div class="cl">
	                            <label class="fl tar">回退原因：</label>
	                            <div class="col-lg-2" style="width: 70%">
	                                <textarea rows="6" class="form-control m-b-10" id="RollBackReason" placeholder="请输入回退原因"></textarea>
	                            </div>
                            </div>
                            <div class="cl">
	                            <label class="fl tar">备注：</label>
	                            <div class="col-lg-2" style="width: 70%">
	                                <textarea rows="6" class="form-control m-b-10" id="Description" placeholder="请输入备注"></textarea>
	                            </div>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-sm">Save</button>
                            <button type="button" class="btn btn-sm" data-dismiss="modal">Close</button>
                        </div>
                    </div>
                </div>
            </div>
            
        <%--查询模块 --%>
        <div class="table-responsive" style="overflow: inherit">
			<div class="col-md-2 m-b-15" style="width: 70px;float: left;margin-top:5px">
	    		<label>查询日期</label>
			</div>
			<div class="col-md-2 m-b-15" style="width: 160px;float: left">
	    		<div class="input-icon datetime-pick date-only">
                        <input id="inputStartDate" name="inputStartDate" data-format="yyyy-MM-dd" type="text" class="form-control input-sm"/>
                        <span class="add-on">
                            <i class="sa-plus"></i>
                        </span>
                    </div>	    		
			</div>
			<div class="col-md-2 m-b-15" style="width: 5px;float: left;margin-top: 5px;">-</div>				
			<div class="col-md-2 m-b-15" style="width: 160px;float: left">	    		
	   			<div class="input-icon datetime-pick date-only">
                        <input id="inputEndDate" name="inputEndDate" data-format="yyyy-MM-dd" type="text" class="form-control input-sm"/>
                        <span class="add-on">
                            <i class="sa-plus"></i>
                        </span>
                </div>
			</div>
			<div class="col-md-2 m-b-15" style="width: 160px;height: 25px;float: left">
                    <select class="form-control input-sm m-b-10" name="GetDepartment" id="GetDepartment">
                        <option selected="true" disabled="true">请选择部门</option>
						<option value="基础业务研发部">基础业务研发部</option>
                    </select>
            </div>
            <div class="col-md-2 m-b-15" style="width: 160px;height: 25px;float: left">
                    <select class="form-control input-sm m-b-10" name="GetCenter" id="GetCenter">
                        <option selected="true" disabled="true">请选择产品</option>
						<option value="用户中心">用户中心</option>
                    </select>
            </div>            
            <div class="col-md-2 m-b-15" style="width: 160px;height: 25px;float: left">
                    <select class="form-control input-sm m-b-10" name="GetGroup" id="GetGroup">
                        <option selected="true" disabled="true">请选择分组</option>
						<option value="登录注册">登录注册</option>
						<option value="我携订单">我携订单</option>
						<option value="offline">offline</option>
						<option value="常旅收藏">常旅收藏</option>
                    </select>
            </div>
            <div class="col-md-2 m-b-15" style="width: 160px;height: 25px;float: left">
                    <select class="form-control input-sm m-b-10" name="GetProduct" id="GetProduct">
                        <option selected="true" disabled="true">请选择产线</option>
						<option value="登录注册">登录注册</option>
						<option value="我携订单">我携订单</option>
						<option value="offline">offline</option>
						<option value="常旅收藏">常旅收藏</option>
                    </select>
            </div>
            <div class="col-md-2 m-b-15" style="width: 160px;float: left">
                    <button class="btn btn-sm btn-alt m-r-5" style="height: 30px;float: left" onclick="GetRollBackInfo()">Search</button>
            </div> 
            
            <%--下载回退列表 --%>
            <div class="col-md-2 m-b-15" style="width: 160px;float: right">
            	<a href="" class="m-r-5 ico-download" style="float: right">下载全部列表
                </a>                  
            </div>
            
            <%--动态查询 --%> 
	        <table class="tile table table-bordered table-striped">
	                    <thead>
	                    <tr>
	                        <th>回退类型</th>
	                        <th>rop版本</th>
	                        <th>发布名称</th>
	                        <th>产品</th>
	                        <th>产线</th>
	                        <th>开始执行时间</th>
	                        <th>结束时间</th>
	                        <th>回退原因</th>
	                        <th>开发人员</th>
	                        <th>测试人员</th>
	                        <th>回退原因分类</th>
	                        <th>分组原因</th>
	                        <th>备注</th>
	                        <th class="OperationTitle">Operation</th>
	                    </tr>
	                    </thead>
	                    <tbody id="tbody-result"></tbody>
	                </table>
        	</div>	
     		
     		<%--修改模块 --%>
     		<div class="modal fade" id="ModifyRollBackInfo" tabindex="-1" role="dialog" aria-hidden="true">
                <div class="modal-dialog modal-sm" style="width: 50%">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                            <h4 class="modal-title">修改发布回退</h4>
                        </div>
                        <div class="modal-body" id="ModifyPermissionModal" style="height: 850px;">
                            <div class="cl">
		                        <label class="fl tar">部门
		                        	<span style="color:red">*</span>
		                        </label>
	                            <div class="col-md-2" style="width: 30%">
	                                <select class="form-control m-b-10" id="ModifyDept">
	                                    <option>基础业务研发部</option>
	                                </select>
	                            </div>
	                        </div>
	                        <div class="cl">
		                        <label class="fl tar">产品
		                        	<span style="color:red">*</span>
		                        </label>
	                            <div class="col-md-2" style="width: 30%">
	                                <select class="form-control m-b-10" id="ModifyCenter">
	                                    <option>用户中心</option>
	                                </select>
	                            </div>
                            </div>
                            <div class="cl">   
	                            <label class="fl tar">分组名称
	                            	<span style="color:red">*</span>
	                            </label>
	                            <div class="col-md-2" style="width: 30%">
	                                <select class="form-control m-b-10" id="ModifyGroup">
	                                    <option>我携订单</option>
	                                    <option>登录注册</option>
	                                    <option>首页头尾</option>
	                                    <option>常旅收藏</option>
	                                    <option>Offline</option>
	                                </select>
	                            </div>
                            </div>
                            <div class="cl">   
	                            <label class="fl tar">产线名称
	                            	<span style="color:red">*</span>
	                            </label>
	                            <div class="col-md-2" style="width: 30%">
	                                <select class="form-control m-b-10" id="ModifyProduct">
	                                    <option>我携订单</option>
	                                    <option>登录注册</option>
	                                    <option>首页头尾</option>
	                                    <option>常旅收藏</option>
	                                    <option>Offline</option>
	                                </select>
	                            </div>
                            </div>
                            <div class="cl">
	                            <label class="fl tar">开发人员：</label>
	                            <div class="col-md-2" style="width: 30%">
	                                <select class="form-control m-b-10" id="ModifyDeveloper">
	                                    <option>Developer</option>
	                                </select>
	                            </div>
                            </div>
                            <div class="cl">
	                            <label class="fl tar">测试人员：</label>
	                            <div class="col-md-2" style="width: 30%">
	                                <select class="form-control m-b-10" id="ModifyTester">
	                                    <option>Tester</option>
	                                </select>
	                            </div>
                            </div>
                            <div class="cl">
	                            <label class="fl tar">回退类型：</label>
	                            <div class="col-md-2" style="width: 30%">
	                                <select class="form-control m-b-10" id="ModifyRollbackType">
	                                    <option>堡垒终止</option>
	                                    <option>Rolling终止</option>
	                                    <option>回滚</option>
	                                </select>
	                            </div>
                            </div>
                            <div class="cl">
	                            <label class="fl tar">Ropid：</label>                           
	                            <div class="col-lg-2" style="width: 70%">
	                                <input type="text" class="form-control m-b-10" id="ModifyRopId" placeholder="请输入Rop版本">
	                            </div>
                            </div>
                            <div class="cl">
	                            <label class="fl tar">发布名称：</label>                           
	                            <div class="col-lg-2" style="width: 70%">
	                                <input type="text" class="form-control m-b-10" id="ModifyReleaseVersion" placeholder="请输入发布名称">
	                            </div>
                            </div>
                            <div class="cl">
	                            <label class="fl tar">开始执行时间：</label>
	                            <div class="col-lg-2" style="width: 70%">
	                                <input type="text" class="form-control m-b-10" id="ModifyStartTime" placeholder="请输入开始执行时间">
	                            </div>
                            </div>
                            <div class="cl">
	                            <label class="fl tar">结束时间：</label>
	                            <div class="col-lg-2" style="width: 70%">
	                                <input type="text" class="form-control m-b-10" id="ModifyEndTime" placeholder="请输入结束时间">
	                            </div> 
                            </div>  
                            <div class="cl">
	                            <label class="fl tar">回退原因分类：</label>                         
	                            <div class="col-md-2" style="width: 50%">
	                                <select class="form-control m-b-10" id="ModifyRollBack">
	                                    <option>环境问题</option>
	                                    <option>依赖问题</option>
	                                    <option>需求问题</option>
	                                </select>
	                            </div> 
                            </div> 
                            <div class="cl">
	                            <label class="fl tar">分组原因分类：</label>                         
	                            <div class="col-md-2" style="width: 50%">
	                                <select class="form-control m-b-10" id="ModifyGroupReason">
	                                    <option>分组原因分类</option>
	                                </select>
	                            </div>
                            </div>
                            <div class="cl">
	                            <label class="fl tar">回退原因：</label>
	                            <div class="col-lg-2" style="width: 70%">
	                                <textarea rows="6" class="form-control m-b-10" id="ModifyRollBackReason" placeholder="请输入回退原因"></textarea>
	                            </div>
                            </div>
                            <div class="cl">
	                            <label class="fl tar">备注：</label>
	                            <div class="col-lg-2" style="width: 70%">
	                                <textarea rows="6" class="form-control m-b-10" id="ModifyDescription" placeholder="请输入备注"></textarea>
	                            </div>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-sm">Save</button>
                            <button type="button" class="btn btn-sm" data-dismiss="modal">Close</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
     		
            <%--分页标签--%>
            <div class="btn-toolbar">
                <ul class="pagination" id="pagination1"></ul>
            </div>
        </div>
    </section>
    <br/><br/>
</section>

<!-- Javascript Libraries -->
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>

	<%--加载基础HTML--%>
	<script src="platform_js/BaseJavaScript.js"></script>
	<script src="platform_js/RollBack.js"></script>	
	<script src="js/select.min.js"></script> <!-- Custom Select -->
	<script src="js/scroll.min.js"></script> <!-- Custom Scrollbar -->
	<script src="js/calendar.min.js"></script> <!-- Calendar -->
	<script src="js/functions.js"></script><!-- All JS functions -->
	<script src="js/icheck.js"></script> <!-- Custom Checkbox + Radio -->
	<script src="js/datetimepicker.min.js"></script> <!-- Date & Time Picker -->
</body>
</html>
