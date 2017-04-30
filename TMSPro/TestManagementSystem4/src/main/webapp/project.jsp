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
    <title>项目</title>

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
        <h4 class="page-title">项目</h4>
        <!-- Modal -->
        <div class="block-area" id="modal">
            <!-- Create Btn -->
            <div class="m-b-20">
                <button class="btn btn-lg m-r-5" data-toggle="modal" href="#modalWider">Create Project</button>
            </div>

            <!-- New User Modal -->
            <div class="modal fade" id="modalWider" tabindex="-1" role="dialog" aria-hidden="true">
                <div class="modal-dialog modal-lg">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                            <h4 class="modal-title">创建项目</h4>
                        </div>
                        <div class="modal-body">
                            <div class="row">
                                <div class="col-lg-6">
                                    <input type="text" class="form-control m-b-10" id="NewName1" placeholder="项目名称">
                                </div>
                                <div class="col-lg-6">
                                    <input type="text" class="form-control m-b-10" id="NewName2" placeholder="项目简述">
                                </div>
                                <div class="col-md-6">
                                    <select class="form-control m-b-10">
                                        <option>基础业务研发部</option>
                                    </select>
                                </div>
                                <div class="col-md-6">
                                    <select class="form-control m-b-10">
                                        <option>用户中心</option>
                                    </select>
                                </div>
                                <div class="col-md-6">
                                    <select class="form-control m-b-10">
                                        <option>我携订单</option>
                                        <option>登录注册</option>
                                        <option>首页头尾</option>
                                        <option>常旅收藏</option>
                                        <option>Offline</option>
                                    </select>
                                </div>
                                <div class="col-md-6">
                                    <select class="form-control m-b-10">
                                        <option>积分</option>
                                    </select>
                                </div>
                                <div class="col-md-6">
                                    <select class="form-control m-b-10">
                                        <option>请选择项目经理</option>
                                    </select>
                                </div>
                                <div class="col-md-6">
                                    <select class="form-control m-b-10">
                                        <option>请选择产品经理</option>
                                    </select>
                                </div>
                                <div class="col-md-6">
                                    <select class="form-control m-b-10">
                                        <option>请选择开发Owner</option>
                                    </select>
                                </div>
                                <div class="col-md-6">
                                    <select class="form-control m-b-10">
                                        <option>请选择测试Owner</option>
                                    </select>
                                </div>
                                <div class="col-md-6">
                                    <select class="select m-b-10" multiple>
                                        <option disabled="disabled">请选择开发者</option>
                                        <option>开发一</option>
                                        <option>开发二</option>
                                        <option>开发三</option>
                                    </select>
                                </div>
                                <div class="col-md-6">
                                    <select class="select m-b-10" multiple>
                                        <option disabled="disabled">请选择测试者</option>
                                        <option>测试一</option>
                                        <option>测试二</option>
                                        <option>测试三</option>
                                        <option>测试一</option>
                                        <option>测试二</option>
                                    </select>
                                </div>
                                <div class="col-md-6">
                                    <div class="input-icon datetime-pick date-only" style="margin-bottom: 10px">
                                        <input data-format="yyyy-MM-dd" type="text" class="form-control input-sm" placeholder="计划提测时间"/>
                                        <span class="add-on">
                                    <i class="sa-plus"></i>
                                </span>
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="input-icon datetime-pick date-only" style="margin-bottom: 10px">
                                        <input data-format="yyyy-MM-dd" type="text" class="form-control input-sm" placeholder="计划冒烟时间"/>
                                        <span class="add-on">
                                    <i class="sa-plus"></i>
                                </span>
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="input-icon datetime-pick date-only" style="margin-bottom: 10px">
                                        <input data-format="yyyy-MM-dd" type="text" class="form-control input-sm" placeholder="计划发布时间"/>
                                        <span class="add-on">
                                    <i class="sa-plus"></i>
                                </span>
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="input-icon datetime-pick date-only" style="margin-bottom: 10px">
                                        <input data-format="yyyy-MM-dd" type="text" class="form-control input-sm" placeholder="实际发布时间"/>
                                        <span class="add-on">
                                    <i class="sa-plus"></i>
                                </span>
                                    </div>
                                </div>

                                <div class="col-md-12">
                                    <div class="input-icon datetime-pick date-only" style="margin-bottom: 10px;">
                                        <input data-format="yyyy-MM-dd" type="text" class="form-control input-sm" placeholder="测试完成时间"/>
                                        <span class="add-on">
                                            <i class="sa-plus"></i>
                                        </span>
                                    </div>
                                </div>

                                <div class="col-md-6">
                                    <textarea class="input-sm validate[required] form-control m-b-10" rows=3 placeholder="预期风险 "></textarea>
                                </div>
                                <div class="col-md-6">
                                    <textarea class="input-sm validate[required] form-control m-b-10" rows=3 placeholder="风险解决方案 "></textarea>
                                </div>
                                <div class="col-md-12 m-b-10">
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

                                <div class="col-md-12 m-b-10">
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
                                <div class="col-md-12 m-b-10">
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
                                <div class="col-md-8">
                                    <div class="input-icon datetime-pick date-only" style="margin-bottom: 10px">
                                        <input data-format="yyyy-MM-dd" type="text" class="form-control input-sm" placeholder="联调测试时间"/>
                                        <span class="add-on">
                                        <i class="sa-plus"></i>
                                    </span>
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
        </div>

        <!-- Search -->
        <div class="block-area">
            <div class="row">
                <div class="col-md-3 m-b-0">
                    <select class="form-control input-sm m-b-10">
                        <option>基础业务研发部</option>
                    </select>
                </div>
                <div class="col-md-3 m-b-0">
                    <select class="form-control input-sm m-b-10">
                        <option>用户中心</option>
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

                <div class="col-md-3 m-b-0">
                    <select class="form-control input-sm m-b-10">
                        <option>请选择创建者（默认全部）</option>
                        <option>王俊杰</option>
                        <option>付乐乐</option>
                        <option>文婷</option>
                        <option>潘婧</option>
                    </select>
                </div>

                <div class="col-md-3 m-b-10">
                    <input class="form-control input-sm" type="text" placeholder="项目名称">
                </div>

                <div class="col-md-3 m-b-10">
                    <div class="input-icon datetime-pick date-only">
                        <input id="StartDate" data-format="yyyy-MM-dd" type="text" class="form-control input-sm" placeholder="计划提测时间"/>
                        <span class="add-on">
                            <i class="sa-plus"></i>
                        </span>
                    </div>
                </div>

                <div class="col-md-3 m-b-10">
                    <div class="input-icon datetime-pick date-only">
                        <input id="EndDate" data-format="yyyy-MM-dd" type="text" class="form-control input-sm" placeholder="计划发布时间"/>
                        <span class="add-on">
                            <i class="sa-plus"></i>
                        </span>
                    </div>
                </div>

                <div class="col-md-3 m-b-10">
                    <button class="btn btn-sm btn-alt m-r-5">Search</button>
                </div>
            </div>
        </div>

        <!-- Table Striped -->
        <div class="block-area" id="tableStriped">
            <div class="table-responsive" style="overflow: inherit">
                <table class="tile table table-bordered table-striped">
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>产线</th>
                        <th>项目名称</th>
                        <th>产品经理</th>
                        <th>开发Owner</th>
                        <th>测试Owner</th>
                        <th>开发人员</th>
                        <th>测试人员</th>
                        <th>冒烟时间</th>
                        <th>计划发布时间</th>
                        <th class="OperationTitle">操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>1</td>
                        <td>我携订单</td>
                        <td>V7.5我携服务</td>
                        <td>徐杰</td>
                        <td>陈清渠</td>
                        <td>王俊杰</td>
                        <td>陈清渠</td>
                        <td>王俊杰</td>
                        <td>2017-9-18</td>
                        <td>2018-3-15</td>
                        <td class="OperationStyle">
                            <div class="dropdown pull-left" style="width: 50%;">
                                <a class="dropdown-toggle underline" data-toggle="modal" href="###"
                                   onclick="window.open('http://localhost:8080/TestManagementSystem/modify-project.jsp');">修改</a>
                            </div>
                            <div class="dropdown pull-right" style="width: 50%;">
                                <a class="dropdown-toggle underline" data-toggle="modal" href="#ModifyUserModal">详情</a>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td>2</td>
                        <td>我携订单</td>
                        <td>V7.5我携服务</td>
                        <td>徐杰</td>
                        <td>陈清渠</td>
                        <td>王俊杰</td>
                        <td>陈清渠</td>
                        <td>王俊杰</td>
                        <td>2017-9-18</td>
                        <td>2018-3-15</td>
                        <td class="OperationStyle">
                            <div class="dropdown pull-left" style="width: 50%;">
                                <a class="dropdown-toggle underline" data-toggle="modal" href="###"
                                   onclick="window.open('http://localhost:8080/TestManagementSystem/modify-project.jsp');">修改</a>
                            </div>
                            <div class="dropdown pull-right" style="width: 50%;">
                                <a class="dropdown-toggle underline" data-toggle="modal" href="#ModifyUserModal">详情</a>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td>3</td>
                        <td>我携订单</td>
                        <td>V7.5我携服务</td>
                        <td>徐杰</td>
                        <td>陈清渠</td>
                        <td>王俊杰</td>
                        <td>陈清渠</td>
                        <td>王俊杰</td>
                        <td>2017-9-18</td>
                        <td>2018-3-15</td>
                        <td class="OperationStyle">
                            <div class="dropdown pull-left" style="width: 50%;">
                                <a class="dropdown-toggle underline" data-toggle="modal" href="###"
                                   onclick="window.open('http://localhost:8080/TestManagementSystem/modify-project.jsp');">修改</a>
                            </div>
                            <div class="dropdown pull-right" style="width: 50%;">
                                <a class="dropdown-toggle underline" data-toggle="modal" href="#ModifyUserModal">详情</a>
                            </div>
                        </td>
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

<script src="js/datetimepicker.min.js"></script> <!-- Date & Time Picker -->

<script src="js/autosize.min.js"></script> <!-- Textare autosize -->


</body>
</html>
