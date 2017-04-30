/**
 * Created by junjie.wang on 2017/4/18.
 */

$(document).ready(function () {
    $("#NewReleaseData").val(getNowDate());//当天时间
    $("#StartDate").val(getWeekStartDate());//本周开始时间
    $("#EndDate").val(getWeekEndDate());//本周结束时间
    //等待全部加载完毕后显示
    $("#skin-blur-violate").css('display', 'block');

});

