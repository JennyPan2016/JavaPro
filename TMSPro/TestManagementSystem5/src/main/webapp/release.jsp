<%--
  Created by IntelliJ IDEA.
  User: junjie.wang
  Date: 2017/4/13
  Time: 9:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.ctrip.sec.sso.principal.AttributePrincipal" %>
<%@ page import="com.ctrip.sec.sso.util.AssertionHolder" %>
<%@ page import="java.util.Map" %>
<html>
<head>
    <title>每日发布计划</title>

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
    <link href="css/font-awesome.min.css" rel="stylesheet">
</head>

<body id="skin-blur-violate" style="display:none">
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
                <!--User Name-->
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

            <!-- Projects schedule -->
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
        <h4 class="page-title">发布计划</h4>
        <!-- 新增发布计划 -->
        <div class="block-area">
            <div class="alert alert-success" id="altSuccess"></div>
            <div class="alert alert-danger" id="altError"></div>
            <div class="accordion tile">
                <div class="panel-heading">
                    <h3 class="panel-title">
                        <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion" href="#NewRelease">
                            新增发布计划
                        </a>
                    </h3>
                </div>
                <div id="NewRelease" class="panel-collapse collapse in" style="padding: 10px;">
                    <div class="row">
                        <div class="col-md-8 m-b-1">
                            <div class="input-icon datetime-pick date-only" style="margin-bottom: 10px">
                                <input data-format="yyyy-MM-dd" type="text" class="form-control input-sm" id="NewReleaseData"/>
                                <span class="add-on">
                                    <i class="sa-plus"></i>
                                </span>
                            </div>
                        </div>
                        <div class="col-md-8 m-b-1">
                            <select class="form-control input-sm m-b-10" name="dept"></select>
                        </div>

                        <div class="col-md-8 m-b-1">
                            <select class="form-control input-sm m-b-10" name="center" id="newCenter"></select>
                        </div>

                        <div class="col-md-8 m-b-1">
                            <select class="form-control input-sm m-b-10" name="group"></select>
                        </div>
                        <div class="col-md-8 m-b-1">
                            <select class="form-control input-sm m-b-10">
                                <option>请选择产品</option>
                                <option>产品一</option>
                                <option>产品二</option>
                            </select>
                        </div>
                        <div class="col-md-8 m-b-1">
                            <select class="form-control input-sm m-b-10">
                                <option>请选择发布项目</option>
                                <option>项目一</option>
                                <option>项目二</option>
                            </select>
                        </div>
                        <div class="col-md-8 m-b-1">
                            <select class="form-control input-sm m-b-10">
                                <option>请选择任务</option>
                                <option>任务一</option>
                                <option>任务二</option>
                            </select>
                        </div>
                        <div class="col-md-8 m-b-1">
                            <input class="form-control input-sm m-b-10" type="text" placeholder="APPID">
                        </div>
                        <div class="col-md-8 m-b-1">
                            <select class="form-control input-sm m-b-10">
                                <option>发布类型</option>
                                <option>计划内</option>
                                <option>计划外</option>
                            </select>
                        </div>
                        <div class="col-md-8 m-b-15">
                            <select class="select" multiple>
                                <option disabled="disabled">请选择开发者</option>
                                <option>开发一</option>
                                <option>开发二</option>
                                <option>开发三</option>
                            </select>
                        </div>
                        <div class="col-md-8 m-b-15">
                            <select class="select" multiple>
                                <option disabled="disabled">请选择测试者</option>
                                <option>测试一</option>
                                <option>测试二</option>
                                <option>测试三</option>
                                <option>测试一</option>
                                <option>测试二</option>
                                <option>测试三</option>
                                <option>测试一</option>
                                <option>测试二</option>
                                <option>测试三</option>
                                <option>测试一</option>
                                <option>测试二</option>
                                <option>测试三</option>
                            </select>
                        </div>
                        <div class="col-md-8 m-b-1">
                            <select class="form-control input-sm m-b-10">
                                <option>选择发布状态</option>
                                <option>未发布</option>
                                <option>已发布</option>
                            </select>
                        </div>
                        <div class="col-md-12 m-b-15">
                            <textarea class="input-sm validate[required] form-control" rows=3 placeholder="发布地址 "></textarea>
                        </div>
                        <div class="col-md-12 m-b-15">
                            <textarea class="input-sm validate[required] form-control" rows=10 placeholder="变更点"></textarea>
                        </div>
                        <div class="col-md-12 m-b-15">
                            <textarea class="input-sm validate[required] form-control" rows=2 placeholder="备注 "></textarea>
                        </div>
                        <div class="col-md-8 m-b-15">
                            <button class="btn btn-xs">提交</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!-- Search -->
        <div class="block-area">
            <div class="row">
                <div class="col-md-3 m-b-0">
                    <select class="form-control input-sm m-b-10" name="dept" id="searchDept"></select>
                </div>
                <div class="col-md-3 m-b-0">
                    <select class="form-control input-sm m-b-10" name="center" id="searchCenter"></select>
                </div>
                <div class="col-md-3 m-b-0">
                    <select class="form-control input-sm m-b-10" name="group" id="searchGroup"></select>
                </div>
                <div class="col-md-3 m-b-10">
                    <div class="input-icon datetime-pick date-only">
                        <input id="StartDate" data-format="yyyy-MM-dd" type="text" class="form-control input-sm"/>
                        <span class="add-on">
                            <i class="sa-plus"></i>
                        </span>
                    </div>
                </div>
                <div class="col-md-3 m-b-10">
                    <div class="input-icon datetime-pick date-only">
                        <input id="EndDate" data-format="yyyy-MM-dd" type="text" class="form-control input-sm"/>
                        <span class="add-on">
                            <i class="sa-plus"></i>
                        </span>
                    </div>
                </div>
                <div class="col-md-1 m-b-0">
                    <select class="form-control input-sm m-b-10">
                        <option>未发布</option>
                        <option>已发布</option>
                    </select>
                </div>

                <div class="col-md-11 m-b-10">
                    <button class="btn btn-sm btn-alt m-r-5" style="height: 30px;float: left">Search</button>
                </div>
            </div>
        </div>

        <!-- List -->
        <div class="block-area">
            <h4><span class="label label-success">我携订单</span></h4>
            <div class="accordion tile">
                <div class="panel-heading">
                    <h3 class="panel-title">
                        <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion" href="#1">
                            2017.4.14-解耦
                        </a>
                    </h3>
                </div>
                <div id="1" class="panel-collapse collapse in" style="padding: 10px;">
                    <div class="row">
                        <div class="col-md-8 m-b-15" style="margin-bottom:0px !important;">
                            <div class="input-icon datetime-pick date-only">
                                <input data-format="yyyy/MM/dd" type="text" class="form-control input-sm" placeholder="日期..."/>
                                <span class="add-on">
                                            <i class="sa-plus"></i>
                                        </span>
                            </div>
                        </div>
                        <div class="col-md-8 m-b-15" style=";margin-bottom:0px !important;">
                            <select class="form-control input-sm m-b-10">
                                <option>基础业务研发部</option>
                            </select>
                        </div>

                        <div class="col-md-8 m-b-15" style="margin-bottom:0px !important;">
                            <select class="form-control input-sm m-b-10">
                                <option>用户中心</option>
                            </select>
                        </div>
                        <div class="col-md-8 m-b-15" style="margin-bottom:0px !important;">
                            <select class="form-control input-sm m-b-10">
                                <option>我携订单</option>
                                <option>登录注册</option>
                                <option>首页头尾</option>
                                <option>常旅收藏</option>
                                <option>Offline</option>
                            </select>
                        </div>

                        <div class="col-md-8 m-b-15">
                            <input class="form-control input-sm m-b-10" type="text" placeholder="开发">
                        </div>
                        <div class="col-md-8 m-b-15">
                            <input class="form-control input-sm m-b-10" type="text" placeholder="测试">
                        </div>
                        <div class="col-md-8 m-b-15">
                            <input class="form-control input-sm m-b-10" type="text" placeholder="所属项目">
                        </div>
                        <div class="col-md-8 m-b-15">
                            <input class="form-control input-sm m-b-10" type="text" placeholder="发布类型">
                        </div>
                        <div class="col-md-12 m-b-15">
                            <textarea class="input-sm validate[required] form-control" rows=3 placeholder="发布地址 "></textarea>
                        </div>
                        <div class="col-md-12 m-b-15">
                            <textarea class="input-sm validate[required] form-control" rows=10 placeholder="变更点"></textarea>
                        </div>
                        <div class="col-md-12 m-b-15">
                            <textarea class="input-sm validate[required] form-control" rows=2 placeholder="备注 "></textarea>
                        </div>
                        <div class="col-md-8 m-b-15">
                            <button class="btn btn-xs">修改</button>
                        </div>
                    </div>
                </div>
            </div>

            <h4><span class="label label-success">登陆注册</span></h4>
            <div class="accordion tile">
                <div class="panel-heading">
                    <h3 class="panel-title">
                        <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion" href="#2">
                            2017.4.14-解耦
                        </a>
                    </h3>
                </div>
                <div id="2" class="panel-collapse collapse in" style="padding: 10px;">
                    <div class="row">
                        <div class="col-md-8 m-b-15" style="margin-bottom:0px !important;">
                            <div class="input-icon datetime-pick date-only">
                                <input data-format="yyyy/MM/dd" type="text" class="form-control input-sm" placeholder="日期..."/>
                                <span class="add-on">
                                            <i class="sa-plus"></i>
                                        </span>
                            </div>
                        </div>
                        <div class="col-md-8 m-b-15" style=";margin-bottom:0px !important;">
                            <select class="form-control input-sm m-b-10">
                                <option>基础业务研发部</option>
                            </select>
                        </div>

                        <div class="col-md-8 m-b-15" style="margin-bottom:0px !important;">
                            <select class="form-control input-sm m-b-10">
                                <option>用户中心</option>
                            </select>
                        </div>

                        <div class="col-md-8 m-b-15" style="margin-bottom:0px !important;">
                            <select class="form-control input-sm m-b-10">
                                <option>我携订单</option>
                                <option>登录注册</option>
                                <option>首页头尾</option>
                                <option>常旅收藏</option>
                                <option>Offline</option>
                            </select>
                        </div>

                        <div class="col-md-8 m-b-15">
                            <input class="form-control input-sm m-b-10" type="text" placeholder="开发">
                        </div>
                        <div class="col-md-8 m-b-15">
                            <input class="form-control input-sm m-b-10" type="text" placeholder="测试">
                        </div>
                        <div class="col-md-8 m-b-15">
                            <input class="form-control input-sm m-b-10" type="text" placeholder="所属项目">
                        </div>
                        <div class="col-md-8 m-b-15">
                            <input class="form-control input-sm m-b-10" type="text" placeholder="发布类型">
                        </div>
                        <div class="col-md-12 m-b-15">
                            <textarea class="input-sm validate[required] form-control" rows=3 placeholder="发布地址 "></textarea>
                        </div>
                        <div class="col-md-12 m-b-15">
                            <textarea class="input-sm validate[required] form-control" rows=10 placeholder="变更点"></textarea>
                        </div>
                        <div class="col-md-12 m-b-15">
                            <textarea class="input-sm validate[required] form-control" rows=2 placeholder="备注 "></textarea>
                        </div>
                        <div class="col-md-8 m-b-15">
                            <button class="btn btn-xs">修改</button>
                        </div>
                    </div>
                </div>
            </div>

            <div class="accordion tile">
                <div class="panel-heading">
                    <h3 class="panel-title">
                        <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion" href="#3">
                            2017.4.14-解耦
                        </a>
                    </h3>
                </div>
                <div id="3" class="panel-collapse collapse in" style="padding: 10px;">
                    <div class="row">
                        <div class="col-md-8 m-b-15" style="margin-bottom:0px !important;">
                            <div class="input-icon datetime-pick date-only">
                                <input data-format="yyyy/MM/dd" type="text" class="form-control input-sm" placeholder="日期..."/>
                                <span class="add-on">
                                            <i class="sa-plus"></i>
                                        </span>
                            </div>
                        </div>
                        <div class="col-md-8 m-b-15" style=";margin-bottom:0px !important;">
                            <select class="form-control input-sm m-b-10">
                                <option>基础业务研发部</option>
                            </select>
                        </div>

                        <div class="col-md-8 m-b-15" style="margin-bottom:0px !important;">
                            <select class="form-control input-sm m-b-10">
                                <option>用户中心</option>
                            </select>
                        </div>
                        <div class="col-md-8 m-b-15" style="margin-bottom:0px !important;">
                            <select class="form-control input-sm m-b-10">
                                <option>我携订单</option>
                                <option>登录注册</option>
                                <option>首页头尾</option>
                                <option>常旅收藏</option>
                                <option>Offline</option>
                            </select>
                        </div>
                        <div class="col-md-8 m-b-15">
                            <input class="form-control input-sm m-b-10" type="text" placeholder="开发">
                        </div>
                        <div class="col-md-8 m-b-15">
                            <input class="form-control input-sm m-b-10" type="text" placeholder="测试">
                        </div>
                        <div class="col-md-8 m-b-15">
                            <input class="form-control input-sm m-b-10" type="text" placeholder="所属项目">
                        </div>
                        <div class="col-md-8 m-b-15">
                            <input class="form-control input-sm m-b-10" type="text" placeholder="发布类型">
                        </div>
                        <div class="col-md-12 m-b-15">
                            <textarea class="input-sm validate[required] form-control" rows=3 placeholder="发布地址 "></textarea>
                        </div>
                        <div class="col-md-12 m-b-15">
                            <textarea class="input-sm validate[required] form-control" rows=10 placeholder="变更点"></textarea>
                        </div>
                        <div class="col-md-12 m-b-15">
                            <textarea class="input-sm validate[required] form-control" rows=2 placeholder="备注 "></textarea>
                        </div>
                        <div class="col-md-8 m-b-15">
                            <button class="btn btn-xs">修改</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        </div>
    </section>
</section>

<!-- Javascript Libraries -->
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>

<%--加载基础HTML--%>
<script src="platform_js/BaseJavaScript.js"></script>
<script src="platform_js/release.js"></script>
<script src="js/select.min.js"></script> <!-- Custom Select -->
<script src="js/scroll.min.js"></script> <!-- Custom Scrollbar -->
<script src="js/calendar.min.js"></script> <!-- Calendar -->
<script src="js/functions.js"></script><!-- All JS functions -->
<script src="js/icheck.js"></script> <!-- Custom Checkbox + Radio -->
<script src="js/datetimepicker.min.js"></script> <!-- Date & Time Picker -->
<script src="js/autosize.min.js"></script> <!-- Textare autosize -->

</body>
</html>
