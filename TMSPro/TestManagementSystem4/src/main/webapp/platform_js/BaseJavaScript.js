/**
 * Created by junjie.wang on 2017/4/12.
 */

/*
 时间方法
 */
var now = new Date(); //当前日期
var nowDayOfWeek = now.getDay(); //今天本周的第几天
var nowDay = now.getDate(); //日
var nowMonth = now.getMonth(); //月
var nowYear = now.getFullYear(); //年

function formatDate(date) {
    var myYear = date.getFullYear();
    var myMonth = date.getMonth() + 1;
    var myWeekday = date.getDate();
    if (myMonth < 10) {
        myMonth = "0" + myMonth;
    }
    if (myWeekday < 10) {
        myWeekday = "0" + myWeekday;
    }
    return (myYear + "-" + myMonth + "-" + myWeekday);
}
/*获取当前日期*/
function getNowDate() {
    var nowDate = new Date(nowYear, nowMonth, nowDay);
    return formatDate(nowDate);
}
/*获取一周开始时间*/
function getWeekStartDate() {
    var weekStartDate = new Date(nowYear, nowMonth, nowDay - nowDayOfWeek);
    return formatDate(weekStartDate);
}
/*获取一周结束时间*/
function getWeekEndDate() {
    var weekEndDate = new Date(nowYear, nowMonth, nowDay + (6 - nowDayOfWeek));
    return formatDate(weekEndDate);
}
/*加载菜单*/
function loadMenu() {
    var menuCss = "active",
        getUrl = window.location.pathname,
        indexUrl = "/TestManagementSystem/index.jsp",
        projectUrl = "/TestManagementSystem/project.jsp",
        crUrl = "/TestManagementSystem/cr.jsp",
        releaseUrl = "/TestManagementSystem/release.jsp",
        dataCollectingUrl = "/TestManagementSystem/data-collecting.jsp",
        problemUrl = "/TestManagementSystem/problem-analysis.jsp",
        rollbackUrl = "/TestManagementSystem/Rollback.jsp",
        emergencyreleaseUrl = "/TestManagementSystem/Emergencyrelease.jsp",
        permissionUrl = "/TestManagementSystem/permission.jsp",
        LeftTitle = "<a class='logo pull-left' href='index.jsp' id='LeftTitel'>Process Platform</a>",//Title
        //菜单
        menu =
            //region Menu Html Code
            "<li id='IndexPage'>" +
            "<a class='sa-side-home' href='index.jsp'>" +
            "<span class='menu-item'>首页</span>" +
            "</a>" +
            "</li>" +
            //功能测试菜单
            "<li class='dropdown' id='functionMenu'>" +
            "<a class='sa-side-widget' href=''><span class='menu-item'>功能测试</span></a>" +
            "<ul class='list-unstyled menu-item'>" +
            "<li><a id='projectPage' href='project.jsp'>Project 项目</a></li>" +
            "<li><a id='crPage' href='cr.jsp'>CR 变更</a></li>" +
            "<li><a id='releasePage' href='release.jsp'>每日发布计划</a></li>" +
            "</ul>" +
            "</li>" +
            //质量菜单
            "<li class='dropdown' id='qualityMenu'>" +
            "<a class='sa-side-form' href=''><span class='menu-item'>质量数据</span></a>" +
            "<ul class='list-unstyled menu-item'>" +
            "<li><a id='dataPage' href='data-collecting.jsp'>测试数据汇总</a></li>" +
            "<li><a id='problemPage' href='problem-analysis.jsp'>测试问题分析</a></li>" +
            "<li><a id='rollbackPage' href='Rollback.jsp'>发布回退</a></li>" +
            "<li><a id='emergencyPage' href='Emergencyrelease.jsp'>紧急发布申请</a></li>" +
            "</ul>" +
            "</li>" +
            //权限菜单
            "<li id='permissionMenu'>" +
            "<a class='sa-side-table' href='permission.jsp'>" +
            "<span class='menu-item'>权限管理</span>" +
            "</a>" +
            "</li>";
    //endregion
    $('#menu-toggle').after(LeftTitle);
    $(".side-menu").append(menu);
    switch (getUrl) {
        case indexUrl:
            $("#IndexPage").addClass(menuCss);
            break;
        case projectUrl:
            $("#functionMenu").addClass(menuCss);
            $("#projectPage").addClass(menuCss);
            break;
        case crUrl:
            $("#functionMenu").addClass(menuCss);
            $("#crPage").addClass(menuCss);
            break;
        case releaseUrl:
            $("#functionMenu").addClass(menuCss);
            $("#releasePage").addClass(menuCss);
            break;
        case dataCollectingUrl:
            $("#qualityMenu").addClass(menuCss);
            $("#dataPage").addClass(menuCss);
            break;
        case problemUrl:
            $("#qualityMenu").addClass(menuCss);
            $("#problemPage").addClass(menuCss);
            break;
        case rollbackUrl:
            $("#qualityMenu").addClass(menuCss);
            $("#rollbackPage").addClass(menuCss);
            break;
        case emergencyreleaseUrl:
            $("#qualityMenu").addClass(menuCss);
            $("#emergencyPage").addClass(menuCss);
            break;
        case permissionUrl:
            $("#permissionMenu").addClass(menuCss);
            break;
        default:
            break;
    }
}

function getDepartment() {
    var deptList = [], deptName = $("select[name=dept]");
    $.ajax({
        type: "post", url: "getAllDepartment", data: {}, dataType: "json", timeout: 1000, async: true,
        success: function (data) {
            for (var i = 0; i <= data.length - 1; i++) {
                deptList.push("<option value='" + data[i].departmentId + "'" + ">" + data[i].departmentName + "</option>")
            }
            deptName.append(deptList);
            getCenterByDept();
        },
        error: function () {
            altError("加载部门异常！");
        }
    });
}

function getCenterByDept() {
    var centerList = [], deptId = $("#searchDept").val(), centerName = $("select[name=center]");
    $.ajax({
        type: "post", url: "getAllCenter",
        data: {
            departmentId: deptId
        },
        dataType: "json", timeout: 1000, async: true,
        success: function (data) {
            for (var i = 0; i <= data.length - 1; i++) {
                centerList.push("<option value='" + data[i].centerId + "'" + ">" + data[i].centerName + "</option>")
            }
            centerName.append(centerList);
            getGroupByCenter(deptId)
        },
        error: function () {
            altError("加载中心异常！");
        }
    })
}

function getGroupByCenter(deptId) {
    var groupList = [], centerId = $("#searchCenter").val(), gName = $("select[name=group]");
    $.ajax({
        type: "post", url: "getAllGroup",
        data: {
            departmentId: deptId,
            centerId: centerId,
        },
        dataType: "json", timeout: 1000, async: true,
        success: function (data) {
            console.log(data)
            for (var i = 0; i <= data.length - 1; i++) {
                groupList.push("<option value='" + data[i].groupId + "'" + ">" + data[i].groupName + "</option>")
            }
            gName.append(groupList);
        },
        error: function () {
            altError("加载小组异常！");
        }
    })
}
//成功提示
function altSuccess(content) {
    $("#altSuccess").show().delay(3000).hide(1000);
    $("#altSuccess").append(content);
}
//失败提示
function altError(content) {
    $("#altError").show().delay(3000).hide(1000);
    $("#altError").append(content);
}
$(document).ready(function () {
    loadMenu();
    getDepartment();
});
