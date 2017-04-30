<%--
  Created by IntelliJ IDEA.
  User: junjie.wang
  Date: 2017/4/26
  Time: 10:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.ctrip.sec.sso.principal.AttributePrincipal" %>
<%@ page import="com.ctrip.sec.sso.util.AssertionHolder" %>
<%@ page import="java.util.Map" %>
<html>
<head>
    <script></script>
    <title>性能测试报告</title>

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
    <link href="css/lightbox.css" rel="stylesheet">
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
        <h4 class="page-title">性能测试报告</h4>
        <%--载入项目信息--%>
        <div class="block-area">
            <h4>v8.9无线App <span class="label label-success">Project ID</span></h4>
            <div class="row">
                <div class="col-md-8 m-b-10">
                    <p class="label-name">Report Name</p>
                    <input type="text" class="form-control">
                </div>
                <div class="col-md-3 m-b-10">
                    <p class="label-name">Test Type</p>
                    <input type="text" class="form-control">
                </div>
                <div class="col-md-3 m-b-10">
                    <p class="label-name">Test Scenario</p>
                    <input type="text" class="form-control">
                </div>
                <div class="col-md-3 m-b-10">
                    <p class="label-name">System Configuration</p>
                    <input type="text" class="form-control">
                </div>
                <div class="col-md-3 m-b-10">
                    <p class="label-name">Performance Target</p>
                    <input type="text" class="form-control">
                </div>
                <div class="col-md-3 m-b-10">
                    <p class="label-name">Business Name</p>
                    <input type="text" class="form-control">
                </div>
                <div class="col-lg-3 m-b-10">
                    <p class="label-name">AppService CPU</p>
                    <input type="text" class="form-control">
                </div>
                <div class="col-lg-3 m-b-10">
                    <p class="label-name">AppService Memery</p>
                    <input type="text" class="form-control">
                </div>
                <div class="col-lg-3 m-b-10">
                    <p class="label-name">DBService CPU</p>
                    <input type="text" class="form-control">
                </div>
                <div class="col-lg-3 m-b-10">
                    <p class="label-name">DBService Memery</p>
                    <input type="text" class="form-control">
                </div>
            </div>

            <div class="row">
                <div class="col-md-7 m-b-10">
                    <p class="label-name">Run Time</p>
                    <input type="text" class="form-control" value="min">
                </div>
                <div class="col-md-7 m-b-10">
                    <p class="label-name">TPS</p>
                    <input type="text" class="form-control">
                </div>
                <div class="col-md-7 m-b-10">
                    <p class="label-name">Passed</p>
                    <input type="text" class="form-control">
                </div>
                <div class="col-md-7 m-b-10">
                    <p class="label-name">Failed</p>
                    <input type="text" class="form-control">
                </div>
                <div class="col-md-7 m-b-10">
                    <p class="label-name">Pass Rate</p>
                    <input type="text" class="form-control" value="%">
                </div>
                <div class="col-md-7 m-b-10">
                    <p class="label-name">Avg</p>
                    <input type="text" class="form-control">
                </div>
                <div class="col-md-7 m-b-10">
                    <p class="label-name">90% Line</p>
                    <input type="text" class="form-control">
                </div>
                <div class="col-md-7 m-b-10">
                    <p class="label-name">Deviation</p>
                    <input type="text" class="form-control">
                </div>
                <div class="col-md-7 m-b-10">
                    <p class="label-name">Min</p>
                    <input type="text" class="form-control">
                </div>
                <div class="col-md-7 m-b-10">
                    <p class="label-name">Max</p>
                    <input type="text" class="form-control">
                </div>
                <div class="col-md-6 m-b-10">
                    <p class="label-name">URL</p>
                    <input type="text" class="form-control">
                </div>
                <div class="col-md-6 m-b-10">
                    <p class="label-name">Risk</p>
                    <input type="text" class="form-control">
                </div>
                <div class="col-md-3 m-b-10">
                    <p class="label-name">CPU Picture</p>
                    <div class="fileupload fileupload-new" data-provides="fileupload">
                        <div class="fileupload-new thumbnail small form-control"></div>
                        <div class="fileupload-preview form-control fileupload-exists thumbnail small"></div>
                        <span class="btn btn-file btn-alt btn-sm">
                            <span class="fileupload-new">Select image</span>
                            <span class="fileupload-exists">Change</span>
                            <input type="file" />
                        </span>
                        <a href="#" class="btn-sm btn fileupload-exists" data-dismiss="fileupload">Remove</a>
                    </div>
                </div>
                <div class="col-md-3 m-b-10">
                    <p class="label-name">Memory Picture</p>
                    <div class="fileupload fileupload-new" data-provides="fileupload">
                        <div class="fileupload-new thumbnail small form-control"></div>
                        <div class="fileupload-preview form-control fileupload-exists thumbnail small"></div>
                        <span class="btn btn-file btn-alt btn-sm">
                            <span class="fileupload-new">Select image</span>
                            <span class="fileupload-exists">Change</span>
                            <input type="file" />
                        </span>
                        <a href="#" class="btn-sm btn fileupload-exists" data-dismiss="fileupload">Remove</a>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-md-6 m-b-10">
                    <button class="btn btn-xs btn-alt m-r-5">Save</button>
                </div>
            </div>
        </div>

        <div class="block-area" id="tableStriped">
            <div class="table-responsive" style="overflow: inherit">
                <table class="table table-bordered table-hover tile">
                    <thead>
                    <tr class="smokingtablestyle">
                        <th>Report Name</th>
                        <th>Business Name</th>
                        <th>Thread Count</th>
                        <th>Response Min</th>
                        <th>Response Max</th>
                        <th>Response Avg</th>
                        <th>99% Line</th>
                        <th>Pass</th>
                        <th>Fail</th>
                        <th>Pass Rate</th>
                        <th>URL</th>
                    </tr>
                    </thead>
                    <tbody>
                        <tr class="smokingtablestyle">
                            <td>v8.9OI</td>
                            <td>GetBasicOrderInfosWithBinding</td>
                            <td>7</td>
                            <td>8.0</td>
                            <td>348.0</td>
                            <td>33.0</td>
                            <td>60.0</td>
                            <td>3445455</td>
                            <td>0</td>
                            <td>100%</td>
                            <td>
                                <a class="dropdown-toggle underline" href="###" onclick="window.open('http://10.3.2.167:8080/PerformanceTestPlatform/details.jsp');">
                                    查看详情</a>
                            </td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>

        <div class="block-area">
            <div class="row">
                <div class="col-md-1 m-b-10">
                    <p>CPU</p>
                    <a href="img/cputest.png" data-rel="gallery"  class="pirobox_gall img-popup" title="CPU">
                        <img src="img/cputest.png" alt="" width="150">
                    </a>
                </div>
                <div class="col-md-1 m-b-10">
                    <p>MEMORY</p>
                    <a href="img/memtest.png" data-rel="gallery"  class="pirobox_gall img-popup" title="Memory">
                        <img src="img/memtest.png" alt="" width="150">
                    </a>
                </div>
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

<script src="js/pirobox.min.js"></script> <!-- Lightbox -->
</body>
</html>