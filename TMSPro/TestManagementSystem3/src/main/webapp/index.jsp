<%--
  Created by IntelliJ IDEA.
  User: junjie.wang
  Date: 2017/3/31
  Time: 13:44
  To change this template use File | Settings | File Templates.
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
            <div class="pull-left tm-icon">
                <a data-drawer="messages" class="drawer-toggle" href="">
                    <i class="sa-top-message"></i>
                    <i class="n-count animated">5</i>
                    <span>Messages</span>
                </a>
            </div>

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
        <ul class="list-unstyled side-menu">
            <li class="active">
                <a class="sa-side-home" href="index.jsp">
                    <span class="menu-item">首页</span>
                </a>
            </li>

            <li class="dropdown">
                <a class="sa-side-widget" href="">
                    <span class="menu-item">功能测试</span>
                </a>
                <ul class="list-unstyled menu-item">
                    <li><a href="">项目 & 变更</a></li>
                    <li><a href="release.jsp">每日发布计划</a></li>
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

        <!-- Messages Drawer -->
        <div id="messages" class="tile drawer animated">
            <div class="listview narrow">
                <div class="media">
                    <a href="">Send a New Message</a>
                    <span class="drawer-close">&times;</span>

                </div>
                <div class="overflow" style="height: 254px">
                    <div class="media">
                        <div class="pull-left">
                            <img width="40" src="img/profile-pics/1.jpg" alt="">
                        </div>
                        <div class="media-body">
                            <small class="text-muted">1分钟之前</small>
                            <br>
                            <a class="t-overflow" href="">junjie.wang 更新了V7.2无线项目状态</a>
                        </div>
                    </div>
                    <div class="media">
                        <div class="pull-left">
                            <img width="40" src="img/profile-pics/2.jpg" alt="">
                        </div>
                        <div class="media-body">
                            <small class="text-muted">1分钟前</small>
                            <br>
                            <a class="t-overflow" href="">junjie.wang 更新了V7.2无线项目状态</a>
                        </div>
                    </div>
                    <div class="media">
                        <div class="pull-left">
                            <img width="40" src="img/profile-pics/3.jpg" alt="">
                        </div>
                        <div class="media-body">
                            <small class="text-muted">1小时前</small>
                            <br>
                            <a class="t-overflow" href="">full 更新了UserDB解耦项目进度。</a>
                        </div>
                    </div>
                    <div class="media">
                        <div class="pull-left">
                            <img width="40" src="img/profile-pics/4.jpg" alt="">
                        </div>
                        <div class="media-body">
                            <small class="text-muted">3小时前</small>
                            <br>
                            <a class="t-overflow" href="">junjie.wang 新增了我携服务项目</a>
                        </div>
                    </div>
                    <div class="media">
                        <div class="pull-left">
                            <img width="40" src="img/profile-pics/1.jpg" alt="">
                        </div>
                        <div class="media-body">
                            <small class="text-muted">1天前</small>
                            <br>
                            <a class="t-overflow" href="">junjie.wang 睡着了</a>
                        </div>
                    </div>
                </div>
                <div class="media text-center whiter l-100">
                    <a href="">
                        <small>VIEW ALL</small>
                    </a>
                </div>
            </div>
        </div>


        <hr class="whiter"/>
        <h4 class="page-title">首页</h4>
        <!-- Quick Stats -->
        <div class="block-area">
            <div class="row">
                <div class="col-md-3 col-xs-6">
                    <div class="tile quick-stats">
                        <div id="stats-line-2" class="pull-left"></div>
                        <div class="data">
                            <h2 data-value="98">0</h2>
                            <small>我携订单</small>
                        </div>
                    </div>
                </div>

                <div class="col-md-3 col-xs-6">
                    <div class="tile quick-stats media">
                        <div id="stats-line-3" class="pull-left"></div>
                        <div class="media-body">
                            <h2 data-value="1452">0</h2>
                            <small>常旅收藏</small>
                        </div>
                    </div>
                </div>

                <div class="col-md-3 col-xs-6">
                    <div class="tile quick-stats media">

                        <div id="stats-line-4" class="pull-left"></div>

                        <div class="media-body">
                            <h2 data-value="4896">0</h2>
                            <small>登录注册</small>
                        </div>
                    </div>
                </div>

                <div class="col-md-3 col-xs-6">
                    <div class="tile quick-stats media">
                        <div id="stats-line" class="pull-left"></div>
                        <div class="media-body">
                            <h2 data-value="29356">0</h2>
                            <small>Offline</small>
                        </div>
                    </div>
                </div>

            </div>

        </div>

        <hr class="whiter"/>

        <!-- Main Widgets -->

        <div class="block-area">
            <div class="row">
                <div class="col-md-8">
                    <!-- Main Chart -->
                    <div class="tile">
                        <h2 class="tile-title">统计</h2>
                        <div class="tile-config dropdown">
                            <a data-toggle="dropdown" href="" class="tile-menu"></a>
                            <ul class="dropdown-menu pull-right text-right">
                                <li><a class="tile-info-toggle" href="">Chart Information</a></li>
                                <li><a href="">Refresh</a></li>
                                <li><a href="">Settings</a></li>
                            </ul>
                        </div>
                        <div class="p-10">
                            <div id="line-chart" class="main-chart" style="height: 250px"></div>

                            <div class="chart-info">
                                <ul class="list-unstyled">
                                    <li class="m-b-10">
                                        Total Sales 1200
                                        <span class="pull-right text-muted t-s-0">
                                                    <i class="fa fa-chevron-up"></i>
                                                    +12%
                                                </span>
                                    </li>
                                    <li>
                                        <small>
                                            Local 640
                                            <span class="pull-right text-muted t-s-0"><i
                                                    class="fa m-l-15 fa-chevron-down"></i> -8%</span>
                                        </small>
                                        <div class="progress progress-small">
                                            <div class="progress-bar progress-bar-warning" role="progressbar"
                                                 aria-valuenow="40" aria-valuemin="0" aria-valuemax="100"
                                                 style="width: 40%"></div>
                                        </div>
                                    </li>
                                    <li>
                                        <small>
                                            Foreign 560
                                            <span class="pull-right text-muted t-s-0">
                                                        <i class="fa m-l-15 fa-chevron-up"></i>
                                                        -3%
                                                    </span>
                                        </small>
                                        <div class="progress progress-small">
                                            <div class="progress-bar progress-bar-info" role="progressbar"
                                                 aria-valuenow="40" aria-valuemin="0" aria-valuemax="100"
                                                 style="width: 60%"></div>
                                        </div>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </div>

                    <!-- Pies -->
                    <div class="tile text-center">
                        <div class="tile-dark p-10">
                            <div class="pie-chart-tiny" data-percent="86">
                                <span class="percent"></span>
                                <span class="pie-title">Demo<i class="m-l-5 fa fa-retweet"></i></span>
                            </div>
                            <div class="pie-chart-tiny" data-percent="23">
                                <span class="percent"></span>
                                <span class="pie-title">Demo<i class="m-l-5 fa fa-retweet"></i></span>
                            </div>
                            <div class="pie-chart-tiny" data-percent="57">
                                <span class="percent"></span>
                                <span class="pie-title">Demo<i class="m-l-5 fa fa-retweet"></i></span>
                            </div>
                            <div class="pie-chart-tiny" data-percent="34">
                                <span class="percent"></span>
                                <span class="pie-title">Demo<i class="m-l-5 fa fa-retweet"></i></span>
                            </div>
                            <div class="pie-chart-tiny" data-percent="81">
                                <span class="percent"></span>
                                <span class="pie-title">Demo<i class="m-l-5 fa fa-retweet"></i></span>
                            </div>
                        </div>
                    </div>

                    <!--  Recent Postings -->
                    <div class="row">
                        <div class="col-md-6">
                            <div class="tile">
                                <h2 class="tile-title">Recent Postings</h2>
                                <div class="tile-config dropdown">
                                    <a data-toggle="dropdown" href="" class="tile-menu"></a>
                                    <ul class="dropdown-menu animated pull-right text-right">
                                        <li><a href="">Refresh</a></li>
                                        <li><a href="">Settings</a></li>
                                    </ul>
                                </div>

                                <div class="listview narrow">
                                    <div class="media p-l-5">
                                        <div class="pull-left">
                                            <img width="40" src="img/profile-pics/1.jpg" alt="">
                                        </div>
                                        <div class="media-body">
                                            <small class="text-muted">1分钟之前</small>
                                            <br>
                                            <a class="t-overflow" href="">junjie.wang 更新了V7.2无线项目状态</a>
                                        </div>
                                    </div>
                                    <div class="media p-l-5">
                                        <div class="pull-left">
                                            <img width="40" src="img/profile-pics/2.jpg" alt="">
                                        </div>
                                        <div class="media-body">
                                            <small class="text-muted">1分钟前</small>
                                            <br>
                                            <a class="t-overflow" href="">junjie.wang 更新了V7.2无线项目状态</a>
                                        </div>
                                    </div>
                                    <div class="media p-l-5">
                                        <div class="pull-left">
                                            <img width="40" src="img/profile-pics/3.jpg" alt="">
                                        </div>
                                        <div class="media-body">
                                            <small class="text-muted">1小时前</small>
                                            <br>
                                            <a class="t-overflow" href="">full 更新了UserDB解耦项目进度。</a>
                                        </div>
                                    </div>
                                    <div class="media p-l-5">
                                        <div class="pull-left">
                                            <img width="40" src="img/profile-pics/4.jpg" alt="">
                                        </div>
                                        <div class="media-body">
                                            <small class="text-muted">3小时前</small>
                                            <br>
                                            <a class="t-overflow" href="">junjie.wang 新增了我携服务项目</a>
                                        </div>
                                    </div>
                                    <div class="media p-l-5">
                                        <div class="pull-left">
                                            <img width="40" src="img/profile-pics/5.jpg" alt="">
                                        </div>
                                        <div class="media-body">
                                            <div class="media-body">
                                                <small class="text-muted">1天前</small>
                                                <br>
                                                <a class="t-overflow" href="">junjie.wang 睡着了</a>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="media p-5 text-center l-100">
                                        <a href="">
                                            <small>VIEW ALL</small>
                                        </a>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <!-- Tasks to do -->
                        <div class="col-md-6">
                            <div class="tile">
                                <h2 class="tile-title">Tasks to do</h2>
                                <div class="tile-config dropdown">
                                    <a data-toggle="dropdown" href="" class="tile-menu"></a>
                                    <ul class="dropdown-menu pull-right text-right">
                                        <li id="todo-add"><a href="">Add New</a></li>
                                        <li id="todo-refresh"><a href="">Refresh</a></li>
                                        <li id="todo-clear"><a href="">Clear All</a></li>
                                    </ul>
                                </div>

                                <div class="listview todo-list sortable">
                                    <div class="media">
                                        <div class="checkbox m-0">
                                            <label class="t-overflow">
                                                <input type="checkbox">
                                                自由行购物车改用调用接口方式
                                            </label>
                                        </div>
                                    </div>
                                    <div class="media">
                                        <div class="checkbox m-0">
                                            <label class="t-overflow">
                                                <input type="checkbox">
                                                增加根据接入渠道管理配置功能，实现可指定某个渠道某个BU关闭提醒
                                            </label>
                                        </div>

                                    </div>
                                    <div class="media">
                                        <div class="checkbox m-0">
                                            <label class="t-overflow">
                                                <input type="checkbox">
                                                机场三字码对应机场名称接口 提供SDK
                                            </label>
                                        </div>

                                    </div>
                                    <div class="media">
                                        <div class="checkbox m-0">
                                            <label class="t-overflow">
                                                <input type="checkbox">
                                                用车-国内接送机订单VendorID=9997，不提醒
                                            </label>
                                        </div>

                                    </div>
                                </div>

                                <h2 class="tile-title">Completed Tasks</h2>

                                <div class="listview todo-list sortable">
                                    <div class="media">
                                        <div class="checkbox m-0">
                                            <label class="t-overflow">
                                                <input type="checkbox" checked="checked">
                                                检查国际订单提示时间
                                            </label>
                                        </div>

                                    </div>
                                    <div class="media">
                                        <div class="checkbox m-0">
                                            <label class="t-overflow">
                                                <input type="checkbox" checked="checked">
                                                船票增加到达日期，到达时间字段
                                            </label>
                                        </div>

                                    </div>
                                    <div class="media">
                                        <div class="checkbox m-0">
                                            <label class="t-overflow">
                                                <input type="checkbox" checked="checked">
                                                时区更新逻辑调整（加有效期 以soa为主）
                                            </label>
                                        </div>

                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="clearfix"></div>
                </div>

                <div class="col-md-4">
                    <!-- USA Map -->
                    <!-- <div class="tile">
                        <h2 class="tile-title">Live Visits</h2>
                        <div class="tile-config dropdown">
                            <a data-toggle="dropdown" href="" class="tile-menu"></a>
                            <ul class="dropdown-menu pull-right text-right">
                                <li><a href="">Refresh</a></li>
                                <li><a href="">Settings</a></li>
                            </ul>
                        </div>

                        <div id="usa-map"></div>
                    </div> -->

                    <!-- Dynamic Chart -->
                    <div class="tile">
                        <h2 class="tile-title">Server Process</h2>
                        <div class="tile-config dropdown">
                            <a data-toggle="dropdown" href="" class="tile-menu"></a>
                            <ul class="dropdown-menu pull-right text-right">
                                <li><a href="">Refresh</a></li>
                                <li><a href="">Settings</a></li>
                            </ul>
                        </div>

                        <div class="p-t-10 p-r-5 p-b-5">
                            <div id="dynamic-chart" style="height: 200px"></div>
                        </div>

                    </div>

                    <!-- Activity -->
                    <div class="tile">
                        <h2 class="tile-title">Projects & CR</h2>
                        <div class="tile-config dropdown">
                            <a data-toggle="dropdown" href="" class="tile-menu"></a>
                            <ul class="dropdown-menu pull-right text-right">
                                <li><a href="">Refresh</a></li>
                                <li><a href="">Settings</a></li>
                            </ul>
                        </div>

                        <div class="listview narrow">

                            <div class="media">
                                <div class="pull-right">
                                    <div class="counts">36</div>
                                </div>
                                <div class="media-body">
                                    <h6>我携订单</h6>
                                </div>
                            </div>

                            <div class="media">
                                <div class="pull-right">
                                    <div class="counts">20</div>
                                </div>
                                <div class="media-body">
                                    <h6>登陆注册</h6>
                                </div>
                            </div>

                            <div class="media">
                                <div class="pull-right">
                                    <div class="counts">56</div>
                                </div>
                                <div class="media-body">
                                    <h6>首页头尾</h6>
                                </div>
                            </div>

                            <div class="media">
                                <div class="pull-right">
                                    <div class="counts">78</div>
                                </div>
                                <div class="media-body">
                                    <h6>常旅收藏</h6>
                                </div>
                            </div>
                            <div class="media">
                                <div class="pull-right">
                                    <div class="counts">68</div>
                                </div>
                                <div class="media-body">
                                    <h6>Offline</h6>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="clearfix"></div>
            </div>
        </div>

        <!-- Chat -->
        <div class="chat">

            <!-- Chat List -->
            <div class="pull-left chat-list">
                <div class="listview narrow">
                    <div class="media">
                        <img class="pull-left" src="img/profile-pics/1.jpg" width="30" alt="">
                        <div class="media-body p-t-5">
                            Alex Bendit
                        </div>
                    </div>
                    <div class="media">
                        <img class="pull-left" src="img/profile-pics/2.jpg" width="30" alt="">
                        <div class="media-body">
                            <span class="t-overflow p-t-5">David Volla Watkinson</span>
                        </div>
                    </div>
                    <div class="media">
                        <img class="pull-left" src="img/profile-pics/3.jpg" width="30" alt="">
                        <div class="media-body">
                            <span class="t-overflow p-t-5">Mitchell Christein</span>
                        </div>
                    </div>
                    <div class="media">
                        <img class="pull-left" src="img/profile-pics/4.jpg" width="30" alt="">
                        <div class="media-body">
                            <span class="t-overflow p-t-5">Wayne Parnell</span>
                        </div>
                    </div>
                    <div class="media">
                        <img class="pull-left" src="img/profile-pics/5.jpg" width="30" alt="">
                        <div class="media-body">
                            <span class="t-overflow p-t-5">Melina April</span>
                        </div>
                    </div>
                    <div class="media">
                        <img class="pull-left" src="img/profile-pics/6.jpg" width="30" alt="">
                        <div class="media-body">
                            <span class="t-overflow p-t-5">Ford Harnson</span>
                        </div>
                    </div>

                </div>
            </div>

            <!-- Chat Area -->
            <div class="media-body">
                <div class="chat-header">
                    <a class="btn btn-sm" href="">
                        <i class="fa fa-circle-o status m-r-5"></i> Chat with Friends
                    </a>
                </div>

                <div class="chat-body">
                    <div class="media">
                        <img class="pull-right" src="img/profile-pics/1.jpg" width="30" alt=""/>
                        <div class="media-body pull-right">
                            Hiiii<br/>
                            How you doing bro?
                            <small>Me - 10 Mins ago</small>
                        </div>
                    </div>

                    <div class="media pull-left">
                        <img class="pull-left" src="img/profile-pics/2.jpg" width="30" alt=""/>
                        <div class="media-body">
                            I'm doing well buddy. <br/>How do you do?
                            <small>David - 9 Mins ago</small>
                        </div>
                    </div>

                    <div class="media pull-right">
                        <img class="pull-right" src="img/profile-pics/2.jpg" width="30" alt=""/>
                        <div class="media-body">
                            I'm Fine bro <br/>Thank you for asking
                            <small>Me - 8 Mins ago</small>
                        </div>
                    </div>

                    <div class="media pull-right">
                        <img class="pull-right" src="img/profile-pics/2.jpg" width="30" alt=""/>
                        <div class="media-body">
                            Any idea for a hangout?
                            <small>Me - 8 Mins ago</small>
                        </div>
                    </div>

                </div>

                <div class="chat-footer media">
                    <i class="chat-list-toggle pull-left fa fa-bars"></i>
                    <i class="pull-right fa fa-picture-o"></i>
                    <div class="media-body">
                        <textarea class="form-control" placeholder="Type something..."></textarea>
                    </div>
                </div>

            </div>
        </div>
    </section>

    <!-- Older IE Message -->
    <!--[if lt IE 9]>
    <div class="ie-block">
        <h1 class="Ops">Ooops!</h1>
        <p>You are using an outdated version of Internet Explorer, upgrade to any of the following web browser in order
            to access the maximum functionality of this website. </p>
        <ul class="browsers">
            <li>
                <a href="https://www.google.com/intl/en/chrome/browser/">
                    <img src="img/browsers/chrome.png" alt="">
                    <div>Google Chrome</div>
                </a>
            </li>
            <li>
                <a href="http://www.mozilla.org/en-US/firefox/new/">
                    <img src="img/browsers/firefox.png" alt="">
                    <div>Mozilla Firefox</div>
                </a>
            </li>
            <li>
                <a href="http://www.opera.com/computer/windows">
                    <img src="img/browsers/opera.png" alt="">
                    <div>Opera</div>
                </a>
            </li>
            <li>
                <a href="http://safari.en.softonic.com/">
                    <img src="img/browsers/safari.png" alt="">
                    <div>Safari</div>
                </a>
            </li>
            <li>
                <a href="http://windows.microsoft.com/en-us/internet-explorer/downloads/ie-10/worldwide-languages">
                    <img src="img/browsers/ie.png" alt="">
                    <div>Internet Explorer(New)</div>
                </a>
            </li>
        </ul>
        <p>Upgrade your browser for a Safer and Faster web experience. <br/>Thank you for your patience...</p>
    </div>
    <![endif]-->
</section>

<!-- Javascript Libraries -->
<!-- jQuery -->
<script src="js/jquery.min.js"></script> <!-- jQuery Library -->
<script src="js/jquery-ui.min.js"></script> <!-- jQuery UI -->
<script src="js/jquery.easing.1.3.js"></script> <!-- jQuery Easing - Requirred for Lightbox + Pie Charts-->

<!-- Bootstrap -->
<script src="js/bootstrap.min.js"></script>

<!-- Charts -->
<script src="js/charts/jquery.flot.js"></script> <!-- Flot Main -->
<script src="js/charts/jquery.flot.time.js"></script> <!-- Flot sub -->
<script src="js/charts/jquery.flot.animator.min.js"></script> <!-- Flot sub -->
<script src="js/charts/jquery.flot.resize.min.js"></script> <!-- Flot sub - for repaint when resizing the screen -->

<script src="js/sparkline.min.js"></script> <!-- Sparkline - Tiny charts -->
<script src="js/easypiechart.js"></script> <!-- EasyPieChart - Animated Pie Charts -->
<script src="js/charts.js"></script> <!-- All the above chart related functions -->

<!-- Map -->
<script src="js/maps/jvectormap.min.js"></script> <!-- jVectorMap main library -->
<script src="js/maps/usa.js"></script> <!-- USA Map for jVectorMap -->

<!--  Form Related -->
<script src="js/icheck.js"></script> <!-- Custom Checkbox + Radio -->

<!-- UX -->
<script src="js/scroll.min.js"></script> <!-- Custom Scrollbar -->

<!-- Other -->
<script src="js/calendar.min.js"></script> <!-- Calendar -->
<script src="js/feeds.min.js"></script> <!-- News Feeds -->


<!-- All JS functions -->
<script src="js/functions.js"></script>
<%--加载基础HTML--%>
<script src="js/BaseJavaScript.js"></script>

</body>
</html>
