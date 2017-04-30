<%--
  Created by IntelliJ IDEA.
  User: junjie.wang
  Date: 2017/4/26
  Time: 20:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.ctrip.sec.sso.principal.AttributePrincipal" %>
<%@ page import="com.ctrip.sec.sso.util.AssertionHolder" %>
<%@ page import="java.util.Map" %>
<html>
<head>
    <script></script>
    <title>冒烟报告</title>

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
        <h4 class="page-title">冒烟报告</h4>

        <%--载入项目信息--%>
        <div class="block-area">
            <h4>v8.9无线App <span class="label label-success">Project ID</span></h4>
            <h5>导入历史冒烟用例</h5>
            <div class="row">
                <div class="col-md-8">
                    <select class="form-control">
                        <option>我携订单</option>
                    </select>
                </div>
                <div class="col-md-8">
                    <select class="form-control">
                        <option>项目名称</option>
                    </select>
                </div>
                <div class="col-md-6">
                    <button class="btn btn-xs btn-alt m-r-5">导入</button>
                </div>
            </div>
        </div>

        <!-- 录入冒烟信息 -->
        <div class="block-area">
            <h5>录入冒烟用例</h5>
            <div class="row">
                <div class="col-lg-3 m-b-10">
                    <input type="text" class="form-control" placeholder="项目经理">
                </div>
                <div class="col-lg-3 m-b-10">
                    <input type="text" class="form-control" placeholder="开发经理">
                </div>
                <div class="col-lg-3 m-b-10">
                    <input type="text" class="form-control" placeholder="测试">
                </div>
                <div class="col-lg-3 m-b-10">
                    <input type="text" class="form-control" placeholder="测试环境">
                </div>
                <div class="col-lg-3 m-b-10">
                    <input type="text" class="form-control" placeholder="测试轮次">
                </div>
                <div class="col-lg-3 m-b-10">
                    <select class="form-control">
                        <option>是否按时提测</option>
                        <option>是</option>
                        <option>否</option>
                    </select>
                </div>
                <div class="col-lg-3 m-b-10">
                    <select class="form-control">
                        <option>选择冒烟测试结果</option>
                        <option>测试通过</option>
                        <option>测试不通过</option>
                    </select>
                </div>
                <div class="col-lg-3 m-b-10">
                    <input type="text" class="form-control" placeholder="项目风险">
                </div>

            </div>
            <div class="row">
                <div class="col-md-8">
                    <div class="input-icon datetime-pick date-only m-b-10">
                        <input data-format="yyyy-MM-dd" type="text" class="form-control input-sm" placeholder="项目发布日期"/>
                        <span class="add-on">
                            <i class="sa-plus"></i>
                        </span>
                    </div>
                </div>
                <div class="col-md-8">
                    <div class="input-icon datetime-pick date-only m-b-10">
                        <input data-format="yyyy-MM-dd" type="text" class="form-control input-sm" placeholder="计划提测时间"/>
                        <span class="add-on">
                            <i class="sa-plus"></i>
                        </span>
                    </div>
                </div>
                <div class="col-md-8">
                    <div class="input-icon datetime-pick date-only m-b-10">
                        <input data-format="yyyy-MM-dd" type="text" class="form-control input-sm" placeholder="实际提测时间"/>
                        <span class="add-on">
                            <i class="sa-plus"></i>
                        </span>
                    </div>
                </div>
                <div class="col-md-8">
                    <button class="btn btn-xs btn-alt m-r-5">保存</button>
                </div>
            </div>
        </div>

        <!-- 添加冒烟功能点 -->
        <div class="block-area">
            <h5>添加功能点</h5>
            <div class="row">
                <div class="col-lg-3 m-b-10">
                    <input type="text" class="form-control" placeholder="功能点">
                </div>
                <div class="col-lg-1 m-b-10">
                    <select class="form-control">
                        <option>通过</option>
                        <option>不通过</option>
                    </select>
                </div>
                <div class="col-lg-3 m-b-10">
                    <input type="text" class="form-control" placeholder="备注">
                </div>
                <div class="col-md-3">
                    <button class="btn btn-xs btn-alt m-r-5">添加</button>
                </div>
            </div>
        </div>

        <div class="block-area" id="tableStriped">
            <div class="table-responsive" style="overflow: inherit">
                <table class="table table-bordered table-hover tile">
                    <thead>
                    <tr>
                        <th class="smokingtablestyle" colSpan="12">冒烟报告名称</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr class="smokingtablestyle">
                        <td>项目经理</td>
                        <td>徐杰</td>
                        <td>开发主管</td>
                        <td>陈清渠</td>
                        <td>测试人员</td>
                        <td>王俊杰</td>
                        <td>计划提测时间</td>
                        <td>2017-2-7</td>
                        <td>实际提测时间</td>
                        <td>2017-2-7</td>
                        <td>项目上线时间</td>
                        <td>2017-2-7</td>
                    </tr>
                    <tr class="smokingtablestyle">
                        <td>测试环境</td>
                        <td>FAT</td>
                        <td>测试轮次</td>
                        <td>第一次</td>
                        <td>是否按时提测</td>
                        <td>是</td>
                        <td>冒烟测试结果</td>
                        <td>测试通过</td>
                        <td>项目风险</td>
                        <td colspan="3">项目没有风险</td>
                    </tr>
                    <tr class="smokingtablestyle">
                        <th colspan="7">冒烟点</th>
                        <th>测试结果</th>
                        <th colspan="3">备注</th>
                        <th>操作</th>
                    </tr>
                    <tr class="smokingtablestyle">
                        <td colspan="7">全部订单聚合页订单列表显示正常</td>
                        <td>通过</td>
                        <td colspan="3">这个功能很好</td>
                        <td class="OperationStyle">
                            <div class="col-md-12">
                                <a class="dropdown-toggle underline" data-toggle="modal" href="###">删除</a>
                            </div>
                        </td>
                    </tr>
                    <tr class="smokingtablestyle">
                        <td colspan="7">全部订单聚合页订单列表显示正常</td>
                        <td>通过</td>
                        <td colspan="3"></td>
                        <td class="OperationStyle">
                            <div class="col-md-12">
                                <a class="dropdown-toggle underline" data-toggle="modal" href="###">删除</a>
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
<script src="js/jquery-ui.min.js"></script> <!-- jQuery UI -->
<script src="js/jquery.easing.1.3.js"></script> <!-- jQuery Easing - Requirred for Lightbox -->



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