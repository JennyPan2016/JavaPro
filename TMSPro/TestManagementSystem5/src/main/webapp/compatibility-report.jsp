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
    <title>兼容性报告</title>

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
        <h4 class="page-title">兼容性报告</h4>

        <%--载入项目信息--%>
        <div class="block-area">
            <h4>v8.9无线App <span class="label label-success">Project ID</span></h4>
        </div>

        <!-- 录入冒烟信息 -->

        <!-- 浏览器兼容性功能点 -->
        <div class="block-area">
            <h5>浏览器兼容性</h5>
            <div class="row">
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
                        <th class="smokingtablestyle" colSpan="15">浏览器兼容性</th>
                    </tr>
                    <tr>
                        <th class="smokingtablestyle" colSpan="9">Android</th>
                        <th class="smokingtablestyle" colSpan="6">IOS</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr class="smokingtablestyle">
                        <td>功能点</td>
                        <td>UC</td>
                        <td>Chrome</td>
                        <td>QQBrowser</td>
                        <td>BaiduApp</td>
                        <td>BaiduBrowser</td>
                        <td>Browser</td>
                        <td>Xiaomi</td>
                        <td>Wechat</td>
                        <td>Safari</td>
                        <td>UC</td>
                        <td>QQBrowser</td>
                        <td>Wechat</td>
                        <td>备注</td>
                        <td>操作</td>
                    </tr>
                    <tr class="smokingtablestyle">
                        <td style="padding: 0px;">
                            <input type="text" class="form-control" style="height: 36px;border: 0px;" placeholder="输入功能点">
                        </td>
                        <td>
                            <label class="checkbox-inline"><input type="checkbox">OK</label>
                        </td>
                        <td>
                            <label class="checkbox-inline"><input type="checkbox">OK</label>
                        </td>
                        <td>
                            <label class="checkbox-inline"><input type="checkbox">OK</label>
                        </td>
                        <td>
                            <label class="checkbox-inline"><input type="checkbox">OK</label>
                        </td>
                        <td>
                            <label class="checkbox-inline"><input type="checkbox">OK</label>
                        </td>
                        <td>
                            <label class="checkbox-inline"><input type="checkbox">OK</label>
                        </td>
                        <td>
                            <label class="checkbox-inline"><input type="checkbox">OK</label>
                        </td>
                        <td>
                            <label class="checkbox-inline"><input type="checkbox">OK</label>
                        </td>
                        <td>
                            <label class="checkbox-inline"><input type="checkbox">OK</label>
                        </td>
                        <td>
                            <label class="checkbox-inline"><input type="checkbox">OK</label>
                        </td>
                        <td>
                            <label class="checkbox-inline"><input type="checkbox">OK</label>
                        </td>
                        <td>
                            <label class="checkbox-inline"><input type="checkbox">OK</label>
                        </td>
                        <td style="padding: 0px;">
                            <input type="text" class="form-control" style="height: 36px;border: 0px;" placeholder="输入备注">
                        </td>
                        <td>
                            <div class="col-md-12">
                                <a class="dropdown-toggle underline" href="###">保存</a>
                            </div>
                        </td>
                    </tr>
                    <tr class="smokingtablestyle">
                        <td style="padding: 0px;">
                            <input type="text" class="form-control" style="height: 36px;border: 0px;" placeholder="输入功能点">
                        </td>
                        <td>
                            <label class="checkbox-inline"><input type="checkbox">OK</label>
                        </td>
                        <td>
                            <label class="checkbox-inline"><input type="checkbox">OK</label>
                        </td>
                        <td>
                            <label class="checkbox-inline"><input type="checkbox">OK</label>
                        </td>
                        <td>
                            <label class="checkbox-inline"><input type="checkbox">OK</label>
                        </td>
                        <td>
                            <label class="checkbox-inline"><input type="checkbox">OK</label>
                        </td>
                        <td>
                            <label class="checkbox-inline"><input type="checkbox">OK</label>
                        </td>
                        <td>
                            <label class="checkbox-inline"><input type="checkbox">OK</label>
                        </td>
                        <td>
                            <label class="checkbox-inline"><input type="checkbox">OK</label>
                        </td>
                        <td>
                            <label class="checkbox-inline"><input type="checkbox">OK</label>
                        </td>
                        <td>
                            <label class="checkbox-inline"><input type="checkbox">OK</label>
                        </td>
                        <td>
                            <label class="checkbox-inline"><input type="checkbox">OK</label>
                        </td>
                        <td>
                            <label class="checkbox-inline"><input type="checkbox">OK</label>
                        </td>
                        <td style="padding: 0px;">
                            <input type="text" class="form-control" style="height: 36px;border: 0px;" placeholder="输入备注">
                        </td>
                        <td>
                            <div class="col-md-12">
                                <a class="dropdown-toggle underline" href="###">保存</a>
                            </div>
                        </td>
                    </tr>
                    <tr class="smokingtablestyle">
                        <td style="padding: 0px;">
                            <input type="text" class="form-control" style="height: 36px;border: 0px;" placeholder="输入功能点">
                        </td>
                        <td>
                            <label class="checkbox-inline"><input type="checkbox">OK</label>
                        </td>
                        <td>
                            <label class="checkbox-inline"><input type="checkbox">OK</label>
                        </td>
                        <td>
                            <label class="checkbox-inline"><input type="checkbox">OK</label>
                        </td>
                        <td>
                            <label class="checkbox-inline"><input type="checkbox">OK</label>
                        </td>
                        <td>
                            <label class="checkbox-inline"><input type="checkbox">OK</label>
                        </td>
                        <td>
                            <label class="checkbox-inline"><input type="checkbox">OK</label>
                        </td>
                        <td>
                            <label class="checkbox-inline"><input type="checkbox">OK</label>
                        </td>
                        <td>
                            <label class="checkbox-inline"><input type="checkbox">OK</label>
                        </td>
                        <td>
                            <label class="checkbox-inline"><input type="checkbox">OK</label>
                        </td>
                        <td>
                            <label class="checkbox-inline"><input type="checkbox">OK</label>
                        </td>
                        <td>
                            <label class="checkbox-inline"><input type="checkbox">OK</label>
                        </td>
                        <td>
                            <label class="checkbox-inline"><input type="checkbox">OK</label>
                        </td>
                        <td style="padding: 0px;">
                            <input type="text" class="form-control" style="height: 36px;border: 0px;" placeholder="输入备注">
                        </td>
                        <td>
                            <div class="col-md-12">
                                <a class="dropdown-toggle underline" href="###">保存</a>
                            </div>
                        </td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>

        <!--服务兼容性报告-->
        <div class="block-area">
            <h5>浏览器兼容性</h5>
            <div class="row">
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
                        <th class="smokingtablestyle" colSpan="15">浏览器兼容性</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr class="smokingtablestyle">
                        <td>功能点</td>
                        <td>V7.1</td>
                        <td>V7.2</td>
                        <td>V7.3</td>
                        <td>V7.4</td>
                        <td>V7.5</td>
                        <td>V7.6</td>
                        <td>V7.7</td>
                        <td>V7.8</td>
                        <td>V7.9</td>
                        <td>V7.10</td>
                        <td>V7.11</td>
                        <td>V7.12</td>
                        <td>备注</td>
                        <td>操作</td>
                    </tr>
                    <tr class="smokingtablestyle">
                        <td style="padding: 0px;">
                            <input type="text" class="form-control" style="height: 36px;border: 0px;" placeholder="输入功能点">
                        </td>
                        <td>
                            <label class="checkbox-inline"><input type="checkbox">OK</label>
                        </td>
                        <td>
                            <label class="checkbox-inline"><input type="checkbox">OK</label>
                        </td>
                        <td>
                            <label class="checkbox-inline"><input type="checkbox">OK</label>
                        </td>
                        <td>
                            <label class="checkbox-inline"><input type="checkbox">OK</label>
                        </td>
                        <td>
                            <label class="checkbox-inline"><input type="checkbox">OK</label>
                        </td>
                        <td>
                            <label class="checkbox-inline"><input type="checkbox">OK</label>
                        </td>
                        <td>
                            <label class="checkbox-inline"><input type="checkbox">OK</label>
                        </td>
                        <td>
                            <label class="checkbox-inline"><input type="checkbox">OK</label>
                        </td>
                        <td>
                            <label class="checkbox-inline"><input type="checkbox">OK</label>
                        </td>
                        <td>
                            <label class="checkbox-inline"><input type="checkbox">OK</label>
                        </td>
                        <td>
                            <label class="checkbox-inline"><input type="checkbox">OK</label>
                        </td>
                        <td>
                            <label class="checkbox-inline"><input type="checkbox">OK</label>
                        </td>
                        <td style="padding: 0px;">
                            <input type="text" class="form-control" style="height: 36px;border: 0px;" placeholder="输入备注">
                        </td>
                        <td>
                            <div class="col-md-12">
                                <a class="dropdown-toggle underline" href="###">保存</a>
                            </div>
                        </td>
                    </tr>
                    <tr class="smokingtablestyle">
                        <td style="padding: 0px;">
                            <input type="text" class="form-control" style="height: 36px;border: 0px;" placeholder="输入功能点">
                        </td>
                        <td>
                            <label class="checkbox-inline"><input type="checkbox">OK</label>
                        </td>
                        <td>
                            <label class="checkbox-inline"><input type="checkbox">OK</label>
                        </td>
                        <td>
                            <label class="checkbox-inline"><input type="checkbox">OK</label>
                        </td>
                        <td>
                            <label class="checkbox-inline"><input type="checkbox">OK</label>
                        </td>
                        <td>
                            <label class="checkbox-inline"><input type="checkbox">OK</label>
                        </td>
                        <td>
                            <label class="checkbox-inline"><input type="checkbox">OK</label>
                        </td>
                        <td>
                            <label class="checkbox-inline"><input type="checkbox">OK</label>
                        </td>
                        <td>
                            <label class="checkbox-inline"><input type="checkbox">OK</label>
                        </td>
                        <td>
                            <label class="checkbox-inline"><input type="checkbox">OK</label>
                        </td>
                        <td>
                            <label class="checkbox-inline"><input type="checkbox">OK</label>
                        </td>
                        <td>
                            <label class="checkbox-inline"><input type="checkbox">OK</label>
                        </td>
                        <td>
                            <label class="checkbox-inline"><input type="checkbox">OK</label>
                        </td>
                        <td style="padding: 0px;">
                            <input type="text" class="form-control" style="height: 36px;border: 0px;" placeholder="输入备注">
                        </td>
                        <td>
                            <div class="col-md-12">
                                <a class="dropdown-toggle underline" href="###">保存</a>
                            </div>
                        </td>
                    </tr>
                    <tr class="smokingtablestyle">
                        <td style="padding: 0px;">
                            <input type="text" class="form-control" style="height: 36px;border: 0px;" placeholder="输入功能点">
                        </td>
                        <td>
                            <label class="checkbox-inline"><input type="checkbox">OK</label>
                        </td>
                        <td>
                            <label class="checkbox-inline"><input type="checkbox">OK</label>
                        </td>
                        <td>
                            <label class="checkbox-inline"><input type="checkbox">OK</label>
                        </td>
                        <td>
                            <label class="checkbox-inline"><input type="checkbox">OK</label>
                        </td>
                        <td>
                            <label class="checkbox-inline"><input type="checkbox">OK</label>
                        </td>
                        <td>
                            <label class="checkbox-inline"><input type="checkbox">OK</label>
                        </td>
                        <td>
                            <label class="checkbox-inline"><input type="checkbox">OK</label>
                        </td>
                        <td>
                            <label class="checkbox-inline"><input type="checkbox">OK</label>
                        </td>
                        <td>
                            <label class="checkbox-inline"><input type="checkbox">OK</label>
                        </td>
                        <td>
                            <label class="checkbox-inline"><input type="checkbox">OK</label>
                        </td>
                        <td>
                            <label class="checkbox-inline"><input type="checkbox">OK</label>
                        </td>
                        <td>
                            <label class="checkbox-inline"><input type="checkbox">OK</label>
                        </td>
                        <td style="padding: 0px;">
                            <input type="text" class="form-control" style="height: 36px;border: 0px;" placeholder="输入备注">
                        </td>
                        <td>
                            <div class="col-md-12">
                                <a class="dropdown-toggle underline" href="###">保存</a>
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