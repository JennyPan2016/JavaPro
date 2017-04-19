/**
 * Created by junjie.wang on 2017/4/12.
 */

/*加载HTML*/
$(document).ready(function () {
    //Title
    var LeftTitle = "<a class='logo pull-left' href='index.jsp' id='LeftTitel'>Process Platform</a>";
    //侧边栏

    var menu = "<li class='active'><a class='sa-side-home' href='index.jsp'><span class='menu-item'>首页</span></a></li>" +
        //region Menu Html Code
        //功能测试菜单
        "<li class='dropdown'>" +
        "<a class='sa-side-widget' href=''><span class='menu-item'>功能测试</span></a>" +
        "<ul class='list-unstyled menu-item'>" +
        "<li><a href='projects.html'>项目 & 变更</a></li>" +
        "<li><a href=''>每日发布计划</a></li>" +
        "<li><a href=''>预留一</a></li>" +
        "<li><a href=''>预留二</a></li>" +
        "</ul>" +
        "</li>" +
        //质量菜单
        "<li class='dropdown active'>" +
        "<a class='sa-side-form' href=''><span class='menu-item'>质量数据</span></a>" +
        "<ul class='list-unstyled menu-item'>" +
        "<li><a href=''>测试数据汇总</a></li>" +
        "<li><a href=''>发布回退列表</a></li>" +
        "<li><a href=''>测试问题分析</a></li>" +
        "<li><a href=''>计划外发布申请列表</a></li>" +
        "</ul>" +
        "</li>" +
        //自动化菜单
        /*"<li class='dropdown'>" +
        "<a class='sa-side-ui' href=''>" +
        "<span class='menu-item'>自动化测试</span>" +
        "</a>" +
        "<ul class='list-unstyled menu-item'>" +
        "<li><a href=''>UI自动化验收报告</a></li>" +
        "<li><a href=''>UI自动化每日运行报告</a></li>" +
        "<li><a href=''>API自动化运行报告</a></li>" +
        "</ul>" +
        "</li>" +
        //性能菜单
        "<li class='dropdown'>" +
        "<a class='sa-side-chart' href=''>" +
        "<span class='menu-item'>性能测试</span>" +
        "</a>" +
        "<ul class='list-unstyled menu-item'>" +
        "<li><a href=''>创建性能测试任务</a></li>" +
        "<li><a href=''>性能测试报告</a></li>" +
        "<li><a href=''>产线性能测试基线</a></li>" +
        "</ul>" +
        "</li>" +
        //持续集成菜单
        "<li class='dropdown'>" +
        "<a class='sa-side-page' href=''>" +
        "<span class='menu-item'>持续集成</span>" +
        "</a>"
        "<ul class='list-unstyled menu-item'>" +
        "<li><a href=''>创建持续集成</a></li>" +
        "<li><a href=''>持续集成结果趋势图</a></li>" +
        "</ul>" +
        "</li>" +*/
        //权限菜单
        "<li class='dropdown'>" +
        "<a class='sa-side-table' href='permission.jsp'>" +
        "<span class='menu-item'>权限管理</span>" +
        "</a>" +
        /*"<ul class='list-unstyled menu-item'>" +
        "<li><a href=''>添加查看用户</a></li>" +
        "<li><a href=''>角色配置</a></li>" +
        "</ul>" +*/
        "</li>";
    //endregion
    $('#menu-toggle').after(LeftTitle);
    /*$(".side-menu").append(menu);*/

})