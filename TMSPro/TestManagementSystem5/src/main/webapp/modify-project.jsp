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
    <title>编辑项目</title>

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
    <style>
        .select .form-control{
            height: 35px;
        }
    </style>
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
        <ul class="list-unstyled side-menu"></ul>
    </aside>

    <!-- Content -->
    <section id="content" class="container">
        <h4 class="page-title">编辑项目</h4>

        <!-- New Task Modal -->
        <div class="modal fade" id="modalWider" tabindex="-1" role="dialog" aria-hidden="true">
            <div class="modal-dialog modal-sm">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        <h4 class="modal-title">创建任务</h4>
                    </div>
                    <div class="modal-body">
                        <div class="row">
                            <div class="col-lg-12">
                                <input type="text" class="form-control m-b-10" id="TaskName" placeholder="任务名称">
                            </div>
                            <div class="col-lg-12">
                                <input type="text" class="form-control m-b-10" id="TaskDescription" placeholder="任务简述">
                            </div>
                            <div class="col-md-12">
                                <select class="form-control m-b-10">
                                    <option>基础业务研发部</option>
                                </select>
                            </div>
                            <div class="col-md-12">
                                <select class="form-control m-b-10">
                                    <option>用户中心</option>
                                </select>
                            </div>
                            <div class="col-md-12">
                                <select class="form-control m-b-10">
                                    <option>我携订单</option>
                                    <option>登录注册</option>
                                    <option>首页头尾</option>
                                    <option>常旅收藏</option>
                                    <option>Offline</option>
                                </select>
                            </div>

                            <div class="col-md-12">
                                <select class="form-control m-b-10">
                                    <option>开发</option>
                                </select>
                            </div>
                            <div class="col-md-12">
                                <select class="form-control m-b-10">
                                    <option>测试</option>
                                </select>
                            </div>

                            <div class="col-lg-12">
                                <input type="text" class="form-control m-b-10" placeholder="联调负责人">
                            </div>
                            <div class="col-md-12">
                                <div class="input-icon datetime-pick date-only " style="margin-bottom: 10px">
                                    <input data-format="yyyy-MM-dd" type="text" class="form-control input-sm" placeholder="联调时间"/>
                                    <span class="add-on">
                                    <i class="sa-plus"></i>
                                </span>
                                </div>
                            </div>

                            <div class="col-md-12">
                                <span class="label label-default" style="padding:2px 8px 6px;">任务状态</span>
                                <div class="btn-group" data-toggle="buttons">
                                    <label class="btn btn-gr-gray btn-sm">
                                        <input type="radio" name="options"  />未开始
                                    </label>
                                    <label class="btn btn-gr-gray btn-sm">
                                        <input type="radio" name="options"  />进行中
                                    </label>
                                    <label class="btn btn-gr-gray btn-sm">
                                        <input type="radio" name="options"/>已结束
                                    </label>
                                </div>
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

        <!-- Modify Task Modal -->
        <div class="modal fade" id="ModifyTask" tabindex="-1" role="dialog" aria-hidden="true">
            <div class="modal-dialog modal-sm">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        <h4 class="modal-title">修改任务</h4>
                    </div>
                    <div class="modal-body">
                        <div class="row">
                            <div class="col-lg-12">
                                <input type="text" class="form-control m-b-10" id="TaskID" placeholder="ID">
                            </div>
                            <div class="col-lg-12">
                                <input type="text" class="form-control m-b-10" id="ModifyTaskName" placeholder="任务名称">
                            </div>
                            <div class="col-lg-12">
                                <input type="text" class="form-control m-b-10" id="ModifyTaskDescription" placeholder="任务简述">
                            </div>
                            <div class="col-md-12">
                                <select class="form-control m-b-10">
                                    <option>基础业务研发部</option>
                                </select>
                            </div>
                            <div class="col-md-12">
                                <select class="form-control m-b-10">
                                    <option>用户中心</option>
                                </select>
                            </div>
                            <div class="col-md-12">
                                <select class="form-control m-b-10">
                                    <option>我携订单</option>
                                    <option>登录注册</option>
                                    <option>首页头尾</option>
                                    <option>常旅收藏</option>
                                    <option>Offline</option>
                                </select>
                            </div>
                            <div class="col-md-12">
                                <select class="form-control m-b-10">
                                    <option>开发</option>
                                </select>
                            </div>
                            <div class="col-md-12">
                                <select class="form-control m-b-10">
                                    <option>测试</option>
                                </select>
                            </div>
                            <div class="col-lg-12">
                                <input type="text" class="form-control m-b-10" placeholder="联调负责人">
                            </div>
                            <div class="col-md-12">
                                <div class="input-icon datetime-pick date-only " style="margin-bottom: 10px">
                                    <input data-format="yyyy-MM-dd" type="text" class="form-control input-sm" placeholder="联调时间"/>
                                    <span class="add-on">
                                    <i class="sa-plus"></i>
                                </span>
                                </div>
                            </div>

                            <div class="col-md-12">
                                <span class="label label-default" style="padding:2px 8px 6px;">任务状态</span>
                                <div class="btn-group" data-toggle="buttons">
                                    <label class="btn btn-gr-gray btn-sm">
                                        <input type="radio" name="options"  />未开始
                                    </label>
                                    <label class="btn btn-gr-gray btn-sm">
                                        <input type="radio" name="options"  />进行中
                                    </label>
                                    <label class="btn btn-gr-gray btn-sm">
                                        <input type="radio" name="options"/>已结束
                                    </label>
                                </div>
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

        <%--载入项目信息--%>
        <div class="block-area">
            <div class="row">
                <div class="col-lg-3">
                    <p class="label-name">Project Name</p>
                    <input type="text" class="form-control" id="NewName1" value="UserDB解耦" readonly="readonly">
                </div>
                <div class="col-lg-6">
                    <p class="label-name">Project Description</p>
                    <input type="text" class="form-control m-b-10" id="NewName2" value="UserDB解耦项目" readonly="readonly">
                </div>
                <div class="col-lg-3" style="display:block;">
                    <p class="label-name">Project Name</p>
                    <div class="input-icon datetime-pick date-only" style="margin-bottom: 10px">
                        <input data-format="yyyy-MM-dd" type="text" class="form-control input-sm" placeholder="联调测试时间"/>
                        <span class="add-on">
                            <i class="sa-plus"></i>
                        </span>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-8">
                    <p class="label-name">Department</p>
                    <select class="form-control">
                        <option>基础业务研发部</option>
                    </select>
                </div>
                <div class="col-md-8">
                    <p class="label-name">Center</p>
                    <select class="form-control">
                        <option>用户中心</option>
                    </select>
                </div>
                <div class="col-md-8">
                    <p class="label-name">Group</p>
                    <select class="form-control">
                        <option>我携订单</option>
                        <option>登录注册</option>
                        <option>首页头尾</option>
                        <option>常旅收藏</option>
                        <option>Offline</option>
                    </select>
                </div>
                <div class="col-md-8">
                    <p class="label-name">Product</p>
                    <select class="form-control">
                        <option>积分</option>
                    </select>
                </div>
                <div class="col-md-8">
                    <p class="label-name">Project Manager</p>
                    <select class="form-control">
                        <option>项目经理</option>
                    </select>
                </div>
                <div class="col-md-8">
                    <p class="label-name">Product Manager</p>
                    <select class="form-control">
                        <option>产品经理</option>
                    </select>
                </div>
                <div class="col-md-8">
                    <p class="label-name">Developer Owner</p>
                    <select class="form-control">
                        <option>开发Owner</option>
                    </select>
                </div>
                <div class="col-md-8">
                    <p class="label-name">Tester Owner</p>
                    <select class="form-control">
                        <option>测试Owner</option>
                    </select>
                </div>
                <div class="col-md-6">
                    <p class="label-name">Developer</p>
                    <select class="select" multiple>
                        <option selected="selected">开发一</option>
                        <option selected="selected">开发二</option>
                        <option selected="selected">开发三</option>
                    </select>
                </div>
                <div class="col-md-6">
                    <p class="label-name">Tester</p>
                    <select class="select" multiple>
                        <option selected="selected">测试一</option>
                        <option selected="selected">测试二</option>
                        <option selected="selected">测试三</option>
                        <option selected="selected">测试四</option>
                        <option selected="selected">测试五</option>
                    </select>
                </div>
                <div class="col-md-7">
                    <p class="label-name">Plan Testing Date</p>
                    <div class="input-icon datetime-pick date-only m-b-10">
                        <input data-format="yyyy-MM-dd" type="text" class="form-control input-sm" placeholder="计划提测时间"/>
                        <span class="add-on">
                            <i class="sa-plus"></i>
                        </span>
                    </div>
                </div>
                <div class="col-md-7">
                    <p class="label-name">Plan Smoking Date</p>
                    <div class="input-icon datetime-pick date-only m-b-10">
                        <input data-format="yyyy-MM-dd" type="text" class="form-control input-sm" placeholder="计划冒烟时间"/>
                        <span class="add-on">
                            <i class="sa-plus"></i>
                        </span>
                    </div>
                </div>
                <div class="col-md-7">
                    <p class="label-name">Plan Release Date</p>
                    <div class="input-icon datetime-pick date-only m-b-10">
                        <input data-format="yyyy-MM-dd" type="text" class="form-control input-sm" placeholder="计划发布时间"/>
                        <span class="add-on">
                            <i class="sa-plus"></i>
                        </span>
                    </div>
                </div>
                <div class="col-md-7">
                    <p class="label-name">Actual Release Date</p>
                    <div class="input-icon datetime-pick date-only m-b-10">
                        <input data-format="yyyy-MM-dd" type="text" class="form-control input-sm" placeholder="实际发布时间"/>
                        <span class="add-on">
                            <i class="sa-plus"></i>
                        </span>
                    </div>
                </div>
                <div class="col-md-7">
                    <p class="label-name">Test Done Date</p>
                    <div class="input-icon datetime-pick date-only m-b-10">
                        <input data-format="yyyy-MM-dd" type="text" class="form-control input-sm" placeholder="测试完成时间"/>
                        <span class="add-on">
                            <i class="sa-plus"></i>
                        </span>
                    </div>
                </div>
                <div class="col-md-6">
                    <p class="label-name">Risk</p>
                    <textarea class="input-sm validate[required] form-control m-b-10" rows=3 placeholder="预期风险 "></textarea>
                </div>
                <div class="col-md-6">
                    <p class="label-name">Risk Solution</p>
                    <textarea class="input-sm validate[required] form-control m-b-10" rows=3 placeholder="风险解决方案 "></textarea>
                </div>
            </div>
            <div class="row">
                <div class="col-md-7 m-b-10" style="min-width: 280px">
                    <span class="label label-default" style="padding:2px 8px 6px;">项目状态</span>
                    <div class="btn-group" data-toggle="buttons">
                        <label class="btn btn-gr-gray btn-sm">
                            <input type="radio" name="options" id="option1" />未开始
                        </label>
                        <label class="btn btn-gr-gray btn-sm">
                            <input type="radio" name="options" id="option2" />进行中
                        </label>
                        <label class="btn btn-gr-gray btn-sm">
                            <input type="radio" name="options" id="option3" />已结束
                        </label>
                    </div>
                </div>

                <div class="col-md-3 m-b-10" style="min-width: 210px">
                    <span class="label label-default" style="padding:2px 8px 6px;">性能测试</span>
                    <div class="btn-group" data-toggle="buttons">
                        <label class="btn btn-gr-gray btn-sm">
                            <input type="radio" name="options"/>需要
                        </label>
                        <label class="btn btn-gr-gray btn-sm">
                            <input type="radio" name="options"/>不需要
                        </label>
                    </div>
                </div>
                <div class="col-md-3 m-b-10" style="min-width: 210px">
                    <span class="label label-default" style="padding:2px 8px 6px;">联调测试</span>
                    <div class="btn-group" data-toggle="buttons">
                        <label class="btn btn-gr-gray btn-sm">
                            <input type="radio" name="options"/>需要
                        </label>
                        <label class="btn btn-gr-gray btn-sm">
                            <input type="radio" name="options"/>不需要
                        </label>
                    </div>
                </div>
                <div class="col-md-6 m-b-10" style="min-width: 210px">
                    <div class="fileupload fileupload-new" data-provides="fileupload">
                            <span class="btn btn-file btn-sm btn-alt">
                                <span class="fileupload-new">上传需求文档</span>
                                <span class="fileupload-exists">变更</span>
                                <input type="file" />
                            </span>
                        <span class="fileupload-preview"></span>
                        <a href="#" class="close close-pic fileupload-exists" data-dismiss="fileupload">
                            <i class="fa fa-times"></i>
                        </a>
                    </div>
                </div>
                <div class="col-md-7 m-b-10">
                    <button class="btn btn-xs btn-alt m-r-5">Save</button>
                </div>
            </div>
        </div>

        <%--报告跳转集合--%>
        <div class="block-area">
            <div class="btn-group btn-group-justified m-b-10">
                <a href="###" class="btn btn-sm btn-alt" onclick="window.open('http://localhost:8080/TestManagementSystem/test-content.jsp');">提测内容</a>
                <a href="###" class="btn btn-sm btn-alt" onclick="window.open('http://localhost:8080/TestManagementSystem/smoking-report.jsp');">冒烟报告</a>
                <a href="###" class="btn btn-sm btn-alt" onclick="window.open('http://localhost:8080/TestManagementSystem/automation-report.jsp');">自动化报告</a>
                <a href="###" class="btn btn-sm btn-alt" onclick="window.open('http://localhost:8080/TestManagementSystem/performance-report.jsp');">性能报告</a>
                <a href="###" class="btn btn-sm btn-alt" onclick="window.open('http://localhost:8080/TestManagementSystem/compatibility-report.jsp');">兼容性报告</a>
            </div>
        </div>

        <!-- Table Striped -->
        <div class="block-area" id="tableStriped">
            <div class="m-b-5">
                <button class="btn btn-xs btn-alt m-r-5" data-toggle="modal" href="#modalWider">Creat Task</button>
            </div>
            <div class="table-responsive" style="overflow: inherit">
                <table class="tile table table-bordered table-striped">
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>产线</th>
                        <th>任务名称</th>
                        <th>开发</th>
                        <th>测试</th>
                        <th>联调人员</th>
                        <th>联调时间</th>
                        <th>任务描述</th>
                        <th>任务状态</th>
                        <th class="OperationTitle">CheckList</th>
                        <th class="OperationTitle">操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>1</td>
                        <td>我携订单</td>
                        <td>V7.5我携服务 任务一</td>
                        <td>陈清渠</td>
                        <td>王俊杰</td>
                        <td>王俊杰</td>
                        <td>2017-09-19</td>
                        <td>任务描述我携服务订单测试</td>
                        <td>进行中</td>
                        <td class="OperationStyle">
                            <div class="dropdown">
                                <a class="dropdown-toggle underline">Check</a>
                            </div>
                        </td>
                        <td class="OperationStyle">
                            <div class="dropdown pull-left" style="width: 50%;">
                                <a class="dropdown-toggle underline" data-toggle="modal" href="#ModifyTask">修改</a>
                            </div>
                            <div class="dropdown pull-left" style="width: 50%;">
                                <a href="#" class="dropdown-toggle underline" data-toggle="dropdown">删除</a>
                                <ul class="dropdown-menu pull-left">
                                    <li role="presentation"><a role="menuitem" tabindex="-1" href="#">是</a></li>
                                    <li role="presentation" class="divider"></li>
                                    <li role="presentation"><a role="menuitem" tabindex="-1" href="#">否</a></li>
                                </ul>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td colSpan="10">
                            <div class="row">
                                <div class="col-md-3">
                                    <div class="input-icon datetime-pick date-only">
                                        <input data-format="yyyy-MM-dd" type="text" class="form-control input-sm" placeholder="发布时间"/>
                                        <span class="add-on">
                                            <i class="sa-plus"></i>
                                        </span>
                                    </div>
                                </div>
                                <div class="col-md-8">
                                    <input class="form-control input-sm" placeholder="发布版本"/>
                                </div>
                                <div class="col-md-5">
                                    <input class="form-control input-sm" placeholder="Remark"/>
                                </div>
                                <div class="col-md-3">
                                    <div class="checkbox m-b-5">
                                        <label class="checkbox-inline"><input type="checkbox">UAT-Clog</label>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-3">
                                    <div class="checkbox m-b-5">
                                        <label class="checkbox-inline"><input type="checkbox">DB/Reids</label>
                                    </div>
                                </div>
                                <div class="col-md-3">
                                    <div class="checkbox m-b-5">
                                        <label class="checkbox-inline"><input type="checkbox">BU依赖</label>
                                    </div>
                                </div>
                                <div class="col-md-3">
                                    <div class="checkbox m-b-5">
                                        <label class="checkbox-inline"><input type="checkbox">代码检查</label>
                                    </div>
                                </div>
                                <div class="col-md-3">
                                    <div class="checkbox m-b-5">
                                        <label class="checkbox-inline"><input type="checkbox">Bug Fix</label>
                                    </div>
                                </div>
                                <div class="col-md-3">
                                    <div class="checkbox m-b-5">
                                        <label class="checkbox-inline"><input type="checkbox">DEV</label>
                                    </div>
                                </div>
                                <div class="col-md-3">
                                    <div class="checkbox m-b-5">
                                        <label class="checkbox-inline"><input type="checkbox">junjie.wang</label>
                                    </div>
                                </div>

                            </div>
                        </td>
                        <td>
                            <div style="text-align: center;padding-top: 15%">
                                <button class="btn btn-xs btn-alt m-r-5" data-toggle="modal" href="#modalWider">保存</button>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td>2</td>
                        <td>我携订单</td>
                        <td>V7.5我携服务 任务一</td>
                        <td>陈清渠</td>
                        <td>王俊杰</td>
                        <td>王俊杰</td>
                        <td>2017-09-19</td>
                        <td>任务描述我携服务订单测试</td>
                        <td>进行中</td>
                        <td class="OperationStyle">
                            <div class="dropdown">
                                <a class="dropdown-toggle underline">Check</a>
                            </div>
                        </td>
                        <td class="OperationStyle">
                            <div class="dropdown pull-left" style="width: 50%;">
                                <a class="dropdown-toggle underline" data-toggle="modal" href="#ModifyTask">修改</a>
                            </div>
                            <div class="dropdown pull-right" style="width: 50%;">
                                <a href="#" class="dropdown-toggle underline" data-toggle="dropdown">删除</a>
                                <ul class="dropdown-menu pull-left">
                                    <li role="presentation"><a role="menuitem" tabindex="-1" href="#">是</a></li>
                                    <li role="presentation" class="divider"></li>
                                    <li role="presentation"><a role="menuitem" tabindex="-1" href="#">否</a></li>
                                </ul>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td>3</td>
                        <td>我携订单</td>
                        <td>V7.5我携服务 任务一</td>
                        <td>陈清渠</td>
                        <td>王俊杰</td>
                        <td>王俊杰</td>
                        <td>2017-09-19</td>
                        <td>任务描述我携服务订单测试</td>
                        <td>进行中</td>
                        <td class="OperationStyle">
                            <div class="dropdown">
                                <a class="dropdown-toggle underline">Check</a>
                            </div>
                        </td>
                        <td class="OperationStyle">
                            <div class="dropdown pull-left" style="width: 50%;">
                                <a class="dropdown-toggle underline" data-toggle="modal" href="#ModifyTask">修改</a>
                            </div>
                            <div class="dropdown pull-right" style="width: 50%;">
                                <a href="#" class="dropdown-toggle underline" data-toggle="dropdown">删除</a>
                                <ul class="dropdown-menu pull-left">
                                    <li role="presentation"><a role="menuitem" tabindex="-1" href="#">是</a></li>
                                    <li role="presentation" class="divider"></li>
                                    <li role="presentation"><a role="menuitem" tabindex="-1" href="#">否</a></li>
                                </ul>
                            </div>
                        </td>
                    </tr>
                    </tbody>
                </table>
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

<script src="js/datetimepicker.min.js"></script> <!-- Date & Time Picker -->

<script src="js/autosize.min.js"></script> <!-- Textare autosize -->

<script src="js/fileupload.min.js"></script> <!-- File Upload -->

</body>
</html>
