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
    <script></script>
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
</head>
<body id="skin-blur-violate">
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
        <ul class="list-unstyled side-menu">
            <li>
                <a class="sa-side-home" href="index.jsp">
                    <span class="menu-item">首页</span>
                </a>
            </li>

            <li class="dropdown active">
                <a class="sa-side-widget" href="">
                    <span class="menu-item">功能测试</span>
                </a>
                <ul class="list-unstyled menu-item">
                    <li><a href="">项目 & 变更</a></li>
                    <li class="dropdown active"><a href="release.jsp">每日发布计划</a></li>
                </ul>
            </li>

            <li class="dropdown">
                <a class="sa-side-form" href="">
                    <span class="menu-item">质量数据</span>
                </a>
                <ul class="list-unstyled menu-item">
                    <li><a href="">测试数据汇总</a></li>
                    <li><a href="">每日发布计划</a></li>
                    <li><a href="">测试问题分析</a></li>
                    <li><a href="">计划外发布申请列表</a></li>
                </ul>
            </li>
            <li>
                <a class="sa-side-table" href="permission.jsp">
                    <span class="menu-item">权限管理</span>
                </a>
            </li>
        </ul>
    </aside>

    <!-- Content -->
    <section id="content" class="container">
        <h4 class="page-title">发布计划</h4>
        <!-- 新增发布计划 -->
        <div class="block-area" id="NewRelease">
            <div class="accordion tile">
                <div class="panel-group block" id="accordion">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h3 class="panel-title">
                                <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion" href="#NewReleaseOne">
                                    新增发布计划
                                </a>
                            </h3>
                        </div>
                        <div id="NewReleaseOne" class="panel-collapse collapse in" style="padding: 10px;">
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
                                <div class="col-md-8 m-b-15">
                                    <button class="btn btn-xs">提交</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!-- Search -->
        <div class="block-area" id="input-masking">
            <div class="row">
                <div class="col-md-3 m-b-0">
                    <select class="form-control input-sm m-b-10">
                        <option>基础业务研发部</option>
                        <option>基础业务研发部</option>
                        <option>基础业务研发部</option>
                    </select>
                </div>

                <div class="col-md-3 m-b-0">
                    <select class="form-control input-sm m-b-10">
                        <option>我携订单</option>
                        <option>登录注册</option>
                        <option>首页头尾</option>
                        <option>常旅收藏</option>
                        <option>Offline</option>
                    </select>
                </div>

                <div class="col-md-3 m-b-10">
                    <div class="input-icon datetime-pick date-only">
                        <input data-format="yyyy/MM/dd" type="text" class="form-control input-sm"/>
                        <span class="add-on">
                            <i class="sa-plus"></i>
                        </span>
                    </div>
                </div>

                <div class="col-md-3 m-b-10">
                    <div class="input-icon datetime-pick date-only">
                        <input data-format="yyyy/MM/dd" type="text" class="form-control input-sm"/>
                        <span class="add-on">
                            <i class="sa-plus"></i>
                        </span>
                    </div>
                </div>

                <div class="col-md-3 m-b-10">
                    <button class="btn btn-sm btn-alt m-r-5" style="height: 30px;float: left">Search</button>
                </div>
            </div>
        </div>

        <!-- List -->
        <div class="block-area">
            <div class="accordion tile">
                <div class="panel-group block" id="accordion">
                    <div class="panel panel-default">
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
                                <div class="col-md-8 m-b-15">
                                    <button class="btn btn-xs">修改</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="accordion tile">
                <div class="panel-group block" id="accordion">
                    <div class="panel panel-default">
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
                                <div class="col-md-8 m-b-15">
                                    <button class="btn btn-xs">修改</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="accordion tile">
                <div class="panel-group block" id="accordion">
                    <div class="panel panel-default">
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
                                <div class="col-md-8 m-b-15">
                                    <button class="btn btn-xs">修改</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <%--分页标签--%>
        <%--<div class="btn-toolbar">
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
        </div>--%>

        </div>
    </section>
    <br/><br/>
</section>

<!-- Javascript Libraries -->
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>

<script src="js/select.min.js"></script> <!-- Custom Select -->

<script src="js/scroll.min.js"></script> <!-- Custom Scrollbar -->

<script src="js/calendar.min.js"></script> <!-- Calendar -->

<script src="js/functions.js"></script><!-- All JS functions -->

<script src="js/icheck.js"></script> <!-- Custom Checkbox + Radio -->

<script src="js/datetimepicker.min.js"></script> <!-- Date & Time Picker -->

<script src="js/autosize.min.js"></script> <!-- Textare autosize -->

<%--加载基础HTML--%>
<script src="js/BaseJavaScript.js"></script>

</body>
</html>
