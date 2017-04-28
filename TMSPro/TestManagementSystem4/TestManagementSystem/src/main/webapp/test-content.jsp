<%--
  Created by IntelliJ IDEA.
  User: junjie.wang
  Date: 2017/4/25
  Time: 19:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.ctrip.sec.sso.principal.AttributePrincipal" %>
<%@ page import="com.ctrip.sec.sso.util.AssertionHolder" %>
<%@ page import="java.util.Map" %>
<html>
<head>
    <script></script>
    <title>提测内容</title>

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
        <ul class="list-unstyled side-menu"></ul>
    </aside>

    <!-- Content -->
    <section id="content" class="container">
        <h4 class="page-title">提测内容</h4>
        <!-- Modal -->
        <div class="block-area" id="modal">
            <h4>v8.9无线App <span class="label label-success">我携订单</span></h4>
            <!-- New User Modal -->
            <div class="modal fade" id="NewUserModal" tabindex="-1" role="dialog" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                            <h4 class="modal-title">新增用户权限</h4>
                        </div>
                        <div class="modal-body" id="CreatePermissionModal">
                            <div class="row">
                                <div class="col-md-2">
                                    <textarea class="input-sm validate[required] form-control m-b-10" rows="2" placeholder="需求描述"></textarea>
                                </div>
                                <div class="col-lg-2">
                                    <input type="text" class="form-control m-b-10" placeholder="需求范围">
                                </div>
                                <div class="col-md-2">
                                    <select class="form-control m-b-10">
                                        <option>开发</option>
                                    </select>
                                </div>
                                <div class="col-md-2">
                                    <select class="form-control m-b-10">
                                        <option>测试</option>
                                    </select>
                                </div>
                                <div class="col-md-2">
                                    <textarea class="input-sm validate[required] form-control m-b-10" rows="2" placeholder="备注"></textarea>
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

            <!-- Modify User Modal -->
            <div class="modal fade" id="ModifyUserModal" tabindex="-1" role="dialog" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                            <h4 class="modal-title">修改用户权限</h4>
                        </div>
                        <div class="modal-body">
                            <div class="row">
                                <div class="col-md-2">
                                    <textarea class="input-sm validate[required] form-control m-b-10" rows="2" placeholder="需求描述"></textarea>
                                </div>
                                <div class="col-lg-2">
                                    <input type="text" class="form-control m-b-10" placeholder="需求范围">
                                </div>
                                <div class="col-md-2">
                                    <select class="form-control m-b-10">
                                        <option>开发</option>
                                    </select>
                                </div>
                                <div class="col-md-2">
                                    <select class="form-control m-b-10">
                                        <option>测试</option>
                                    </select>
                                </div>
                                <div class="col-md-2">
                                    <textarea class="input-sm validate[required] form-control m-b-10" rows="2" placeholder="备注"></textarea>
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

        <!-- Table Striped -->
        <div class="block-area" id="tableStriped">
            <!-- Create Btn -->
            <div class="m-b-20">
                <button class="btn btn-lg btn-alt m-r-5" data-toggle="modal" href="#NewUserModal">New</button>
            </div>
            <div class="table-responsive" style="overflow: inherit">
                <table class="tile table table-bordered table-striped">
                    <thead>
                    <tr>
                        <th>序号</th>
                        <th>需求描述</th>
                        <th>需求范围</th>
                        <th>开发</th>
                        <th>测试</th>
                        <th>备注</th>
                        <th class="OperationTitle">开发状态</th>
                        <th class="OperationTitle">测试状态</th>
                        <th class="OperationTitle">操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>1</td>
                        <td>机+X/用车 使用Ordertype=Channel+SubChannel</td>
                        <td>Online</td>
                        <td>翁兴华</td>
                        <td>王俊杰</td>
                        <td>online需求，7.3服务不影响</td>
                        <td class="OperationStyle">
                            <label class="checkbox-inline">
                                <input type="checkbox">
                                开发完成
                            </label>
                        </td>
                        <td class="OperationStyle">
                            <label class="checkbox-inline">
                                <input type="checkbox">
                                测试完成
                            </label>
                        </td>
                        <td class="OperationStyle">
                            <div class="dropdown pull-left" style="width: 50%;">
                                <a class="dropdown-toggle underline" data-toggle="modal" href="#ModifyUserModal">修改</a>
                            </div>
                            <div class="dropdown pull-left" style="width: 50%;">
                                <a href="#" class="dropdown-toggle underline" data-toggle="dropdown">删除</a>
                                <ul class="dropdown-menu">
                                    <li role="presentation"><a role="menuitem" tabindex="-1" href="#">是</a></li>
                                    <li role="presentation" class="divider"></li>
                                    <li role="presentation"><a role="menuitem" tabindex="-1" href="#">否</a></li>
                                </ul>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td>2</td>
                        <td>机+X/用车 使用Ordertype=Channel+SubChannel</td>
                        <td>Online</td>
                        <td>翁兴华</td>
                        <td>王俊杰</td>
                        <td>online需求，7.3服务不影响</td>
                        <td class="OperationStyle">
                            <label class="checkbox-inline">
                                <input type="checkbox">
                                开发完成
                            </label>
                        </td>
                        <td class="OperationStyle">
                            <label class="checkbox-inline">
                                <input type="checkbox">
                                测试完成
                            </label>
                        </td>
                        <td class="OperationStyle">
                            <div class="dropdown pull-left" style="width: 50%;">
                                <a class="dropdown-toggle underline" data-toggle="modal" href="#ModifyUserModal">修改</a>
                            </div>
                            <div class="dropdown pull-left" style="width: 50%;">
                                <a href="#" class="dropdown-toggle underline" data-toggle="dropdown">删除</a>
                                <ul class="dropdown-menu">
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

<script src="js/scroll.min.js"></script> <!-- Custom Scrollbar -->

<script src="js/calendar.min.js"></script> <!-- Calendar -->

<script src="js/functions.js"></script><!-- All JS functions -->

<script src="js/icheck.js"></script> <!-- Custom Checkbox + Radio -->
</body>
</html>
