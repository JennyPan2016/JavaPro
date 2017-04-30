<%--
  User: mianhuichen
  Date: 2017/4/17
  Time: 17:30
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.ctrip.sec.sso.principal.AttributePrincipal" %>
<%@ page import="com.ctrip.sec.sso.util.AssertionHolder" %>
<%@ page import="java.util.Map" %>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0"/>
    <meta name="format-detection" content="telephone=no">
    <meta charset="UTF-8">

    <meta name="description" content="Violate Responsive Admin Template">
    <meta name="keywords" content="Super Admin, Admin, Template, Bootstrap">

    <title>流程平台</title>

    <!-- CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/animate.min.css" rel="stylesheet">
    <link href="css/font-awesome.min.css" rel="stylesheet">
    <link href="css/form.css" rel="stylesheet">
    <link href="css/calendar.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
    <link href="css/icons.css" rel="stylesheet">
    <link href="css/generics.css" rel="stylesheet">
</head>
<body id="skin-blur-ocean">

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
        <h4 class="page-title">质量数据》计划外发布申请列表</h4>
        <div class="block-area" id="modal">
        <div class="table-responsive" style="overflow: inherit">
			<div class="col-md-2 m-b-15" style="width: 70px;float: left;margin-top:5px">
	    		<label>查询日期</label>
			</div>
			<div class="col-md-2 m-b-15" style="width: 160px;float: left">
	    		<input class="form-control input-sm m-b-10" type="text" id="inputStartDate" placeholder="yyyy-mm-dd">
	    		
			</div>
			<div class="col-md-2 m-b-15" style="width: 5px;float: left;margin-top: 5px;">-</div>				
			<div class="col-md-2 m-b-15" style="width: 160px;float: left">	    		
	   			<input class="form-control input-sm m-b-10" type="text" id="inputEndDate" placeholder="yyyy-mm-dd">
			</div>
			<div class="col-md-2 m-b-15" style="width: 160px;height: 25px;float: left">
                    <select class="form-control input-sm m-b-10">
                        <option>基础业务研发部</option>
                        <option>基础业务研发部</option>
                    </select>
            </div> 
            <div class="col-md-2 m-b-15" style="width: 160px;height: 25px;float: left">
                    <select class="form-control input-sm m-b-10">
                        <option>用户中心</option>
                    </select>
            </div>          
            <div class="col-md-2 m-b-15" style="width: 160px;height: 25px;float: left">
                    <select class="form-control input-sm m-b-10">
                        <option>我携订单</option>
                        <option>登录注册</option>
                        <option>首页头尾</option>
                        <option>常旅收藏</option>
                    </select>
            </div>  
            <div class="col-md-2 m-b-15" style="width: 160px;height: 25px;float: left">
                    <select class="form-control input-sm m-b-10">
                        <option>产品1</option>
                        <option>产品2</option>
                        <option>产品3</option>
                    </select>
            </div> 
            <div class="col-md-2 m-b-15" style="width: 160px;height: 25px;float: left">
                    <select class="form-control input-sm m-b-10">
                        <option>类型1</option>
                        <option>类型2</option>
                        <option>类型3</option>
                    </select>
            </div>
            <div class="col-md-2 m-b-15" style="width: 160px;float: left">
	    		<input class="form-control input-sm m-b-10" type="text" placeholder="发布单号">
	    		
			</div>
            <div class="col-md-2 m-b-15" style="width: 160px;float: left">
                    <button class="btn btn-sm btn-alt m-r-5" style="height: 30px;float: left">Search</button>
            </div>  
	        <table class="tile table table-bordered table-striped">
	                    <thead>
	                    <tr>
	                        <th>发布产品</th>
	                        <th>appid</th>
	                        <th>发布类型</th>
	                        <th>申请人</th>
	                        <th>申请时间</th>
	                        <th>开发责任人</th>
	                        <th>测试负责人</th>
	                        <th>紧急发布原因</th>
	                        <th>发布风险</th>
	                        <th>发布版本</th>
	                    </tr>
	                    </thead>
	                    <tbody>
	                    <tr>
	                        <td>发布产品1</td>
	                        <td>appid1</td>
	                        <td>255</td>
	                        <td>应用发布</td>
	                        <td>我携订单</td>
	                        <td>2017-01-01 18:00</td>
	                        <td>2017-01-01 19:00</td>
	                        <td>回退切换原因</td>
	                        <td>developer</td>
	                        <td>tester</td>
	                    </tr>
	                    <tr>
	                        <td>发布产品2</td>
	                        <td>appid2</td>
	                        <td>255</td>
	                        <td>应用发布</td>
	                        <td>我携订单</td>
	                        <td>2017-01-01 18:00</td>
	                        <td>2017-01-01 19:00</td>
	                        <td>回退切换原因</td>
	                        <td>developer</td>
	                        <td>tester</td>
	                    </tr>
	                    <tr>
	                        <td>发布产品3</td>
	                        <td>appid3</td>
	                        <td>255</td>
	                        <td>应用发布</td>
	                        <td>我携订单</td>
	                        <td>2017-01-01 18:00</td>
	                        <td>2017-01-01 19:00</td>
	                        <td>回退切换原因</td>
	                        <td>developer</td>
	                        <td>tester</td>
	                    </tr>
						<tr>
	                        <td>发布产品4</td>
	                        <td>appid4</td>
	                        <td>255</td>
	                        <td>应用发布</td>
	                        <td>我携订单</td>
	                        <td>2017-01-01 18:00</td>
	                        <td>2017-01-01 19:00</td>
	                        <td>回退切换原因</td>
	                        <td>developer</td>
	                        <td>tester</td>
	                    </tr>
	                    </tbody>
	                </table>
        	</div>	
     
            <%--分页标签--%>
            <div class="btn-toolbar">
                <div class="btn-group">
                    <button type="button" class="btn btn-sm btn-alt">1</button>
                    <button type="button" class="btn btn-sm btn-alt">2</button>
                    <button type="button" class="btn btn-sm btn-alt">3</button>
                </div>
                <div class="btn-group">
                    <button type="button" class="btn btn-sm btn-alt">4</button>
                    <button type="button" class="btn btn-sm btn-alt">5</button>
                    <button type="button" class="btn btn-sm btn-alt">6</button>
                </div>
                <div class="btn-group">
                    <button type="button" class="btn btn-sm btn-alt">7</button>
                    <button type="button" class="btn btn-sm btn-alt">8</button>
                    <button type="button" class="btn btn-sm btn-alt">9</button>
                </div>
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

<script src="js/select.min.js"></script> <!-- Custom Select -->

<script src="js/scroll.min.js"></script> <!-- Custom Scrollbar -->

<script src="js/calendar.min.js"></script> <!-- Calendar -->

<script src="js/functions.js"></script><!-- All JS functions -->

<script src="js/icheck.js"></script> <!-- Custom Checkbox + Radio -->



</body>
</html>
