<%--
  Created by IntelliJ IDEA.
  User: junjie.wang
  Date: 2017/4/12
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
    <title>权限管理</title>

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
        <h4 class="page-title">权限管理</h4>
        <!-- Modal -->
        <div class="block-area" id="modal">
            <!-- Create Btn -->
            <div class="m-b-20">
                <button class="btn btn-lg m-r-5" data-toggle="modal" href="#NewUserModal">Create</button>
            </div>

            <!-- New User Modal -->
            <div class="modal fade" id="NewUserModal" tabindex="-1" role="dialog" aria-hidden="true">
                <div class="modal-dialog modal-sm">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                            <h4 class="modal-title">新增用户权限</h4>
                        </div>
                        <div class="modal-body" id="CreatePermissionModal" style="height: 350px;">
                            <div class="col-md-2">
                                <select class="form-control m-b-10" id="NewDept">
                                    <option>基础业务研发部</option>
                                </select>
                            </div>
                            <div class="col-md-2">
                                <select class="form-control m-b-10" id="NewCenter">
                                    <option>用户中心</option>
                                </select>
                            </div>
                            <div class="col-md-2">
                                <select class="form-control m-b-10" id="NewGroup">
                                    <option>我携订单</option>
                                    <option>登录注册</option>
                                    <option>首页头尾</option>
                                    <option>常旅收藏</option>
                                    <option>Offline</option>
                                </select>
                            </div>
                            <div class="col-lg-2">
                                <input type="text" class="form-control m-b-10" id="NewName" placeholder="请输入用户名">
                            </div>
                            <div class="col-lg-2">
                                <input type="text" class="form-control m-b-10" id="NewEmail" placeholder="请输入邮箱">
                            </div>
                            <div class="col-md-2">
                                <select class="form-control m-b-10" id="NewPosition">
                                    <option>测试</option>
                                    <option>开发</option>
                                </select>
                            </div>
                            <div class="col-md-2">
                                <select class="form-control m-b-10" id="NewRole">
                                    <option>管理员</option>
                                    <option>普通用户</option>
                                </select>
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
                <div class="modal-dialog modal-sm">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                            <h4 class="modal-title">修改用户权限</h4>
                        </div>
                        <div class="modal-body" id="ModifyPermissionModal" style="height: 350px;">
                            <div class="col-lg-2">
                                <input type="text" class="form-control m-b-10" id="ModifyName" placeholder="修改ID">
                            </div>
                            <div class="col-md-2">
                                <select class="form-control m-b-10" id="ModifyDept">
                                    <option>基础业务研发部</option>
                                </select>
                            </div>
                            <div class="col-md-2">
                                <select class="form-control m-b-10" id="ModifyCenter">
                                    <option>用户中心</option>
                                </select>
                            </div>
                            <div class="col-md-2">
                                <select class="form-control m-b-10" id="ModifyGroup">
                                    <option>我携订单</option>
                                    <option>登录注册</option>
                                    <option>首页头尾</option>
                                    <option>常旅收藏</option>
                                    <option>Offline</option>
                                </select>
                            </div>
                            <div class="col-lg-2">
                                <input type="text" class="form-control m-b-10" id="ModifyName" placeholder="请输入用户名">
                            </div>
                            <div class="col-lg-2">
                                <input type="text" class="form-control m-b-10" id="ModifyEmail" placeholder="请输入邮箱">
                            </div>
                            <div class="col-md-2">
                                <select class="form-control m-b-10" id="ModifyPosition">
                                    <option>测试</option>
                                    <option>开发</option>
                                </select>
                            </div>
                            <div class="col-md-2">
                                <select class="form-control m-b-10" id="ModifyRole">
                                    <option>管理员</option>
                                    <option>普通用户</option>
                                </select>
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

        <div class="block-area">
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
                    <input class="form-control input-sm m-b-10" type="text" placeholder="UserName">
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
                        <th>Department</th>
                        <th>Center</th>
                        <th>Group</th>
                        <th>User Name</th>
                        <th>Email</th>
                        <th>Position</th>
                        <th>Role</th>
                        <th class="OperationTitle">Operation</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>基础业务研发部</td>
                        <td>用户中心</td>
                        <td>我携订单</td>
                        <td>went</td>
                        <td>went@ctrip.com</td>
                        <td>测试</td>
                        <td>管理员</td>
                        <td class="OperationStyle">
                            <div class="dropdown pull-left">
                                <a class="dropdown-toggle underline" data-toggle="modal" href="#ModifyUserModal">修改</a>
                            </div>
                            <div class="dropdown pull-right">
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
                        <td>基础业务研发部</td>
                        <td>用户中心</td>
                        <td>我携订单</td>
                        <td>junjie.wang</td>
                        <td>junjie.wang@ctrip.com</td>
                        <td>测试</td>
                        <td>管理员</td>
                        <td class="OperationStyle">
                            <div class="dropdown pull-left">
                                <a class="dropdown-toggle underline" data-toggle="modal" href="#ModifyUserModal">修改</a>
                            </div>
                            <div class="dropdown pull-right">
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

<script src="js/scroll.min.js"></script> <!-- Custom Scrollbar -->

<script src="js/calendar.min.js"></script> <!-- Calendar -->

<script src="js/functions.js"></script><!-- All JS functions -->


</body>
</html>
