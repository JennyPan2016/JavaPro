$(document).ready(function () {
    $("#inputStartDate").val(getWeekStartDate());//本周开始时间
    $("#inputEndDate").val(getWeekEndDate());//本周结束时间
})

//提交发布回退列表
function SaveRollBackInfo() {    

        $.ajax({
            type: "post",
            url: "addRollBackInfo",
            data: {
            	department:$("select[name=NewDept]").val(),
            	center:$("select[name=NewCenter]").val(),
            	groupName:$("select[name=NewGroup]").val(),
            	productName:$("select[name=NewProduct]").val(),
            	roleuser:"",
                ropid:$("input[name=RopId]").val(),
                "developer":"ccc",
                "tester":"ww",
                rollbackType:$("select[name=RollbackType]").val(),
                releaseVersion:$("input[name=ReleaseVersion]").val(),
                startTime:$("input[name=StartTime]").val(),
                endTime:$("input[name=EndTime]").val(),
                rollbackReason:$("textarea[name=RollBackReason]").val(),
                backCategory:$("select[name=RollBack]").val(),
                "backGroup":"211",
                description:$("textarea[name=Description]").val(),              
            },
            dataType: "json",
            timeout: 10000,
            async: false,
            success: function(data) {
                if (data) {
                    if (data[0].message == "success") {
                    	alert('sucess');
                    } else {
                        alert('fail');
                    }
                }
            },
        })
}


//查询发布回退列表
function GetRollBackInfo() {  
		var GetDepartment = $('#GetDepartment').val(); 
		var GetCenter = $('#GetCenter').val(); 
        var GetGroup = $('#GetGroup').val();  
        var GetProduct = $('#GetProduct').val();  
        var inputStartDate = $('#inputStartDate').val();  
        var inputEndDate = $('#inputEndDate').val();  
        var tbody=window.document.getElementById("tbody-result");  
  
        $.ajax({  
            type: "post",               
            url: "getRollBackInfos",  
            data: {  
            	department:GetDepartment,
            	centerName:GetCenter,
            	groupName: GetGroup,  
            	productName: GetProduct,  
            	beginDate: inputStartDate,  
            	endDate: inputEndDate,  
            },  
            timeout: 10000,
            dataType: "json", 
            async: false,
            success: function (data) {  
            	var str="";
            	for (var i=0;i<data.length-1;i++) { 
                    str += "<tr>" +  
                    "<td style='display:none'>" + data[i].id + "</td>" +  
                    "<td>" + data[i].RollbackType + "</td>" +  
                    "<td>" + data[i].ropid + "</td>" +  
                    "<td>" + data[i].ReleaseVersion + "</td>" +
                    "<td style='display:none'>" + data[i].department + "</td>" +
                    "<td style='display:none'>" + data[i].centerName + "</td>" +
                    "<td>" + data[i].GroupName + "</td>" +  
                    "<td>" + data[i].ProductName + "</td>" +  
                    "<td>" + data[i].StartTime + "</td>" +  
                    "<td>" + data[i].EndTime + "</td>" +  
                    "<td>" + data[i].RollbackReason + "</td>" +  
                    "<td>" + data[i].Developer + "</td>" +  
                    "<td>" + data[i].Tester + "</td>" +  
                    "<td>" + data[i].RollbackCategory + "</td>" +  
                    "<td>" + data[i].RollbackGroup + "</td>" +  
                    "<td>" + data[i].Description + "</td>" +  
                    "<td style='display:none'>" + data[i].CreateUser + "</td>" +
                    "<td style='display:none'>" + data[i].UpdateUser + "</td>" +
                    // "<td>" + '<a class="dropdown-toggle underline" data-toggle="modal" href="#ModifyRollBackInfo" onclick="LoadRollBackInfo()">修改</a>'+ "</td>" +
                    "<td>" + '<a class="dropdown-toggle underline action-modify" data-index="'+ i +'" data-toggle="modal" href="#ModifyRollBackInfo">修改</a>'+ "</td>" +
                    "</tr>";  
                }  
                tbody.innerHTML = str; 
                $(tbody).find('.action-modify').on('click', function(){
                	var index = parseInt($(this).attr('data-index'));
                	LoadRollBackInfo(data[index]);
                })
        },  
        error: function () {  
            alert("查询失败")  
        }  
    });   
}


//加载回退信息
function LoadRollBackInfo(data) {
	
	$("#ModifyDept").val(data.department);
	$("select[name='ModifyCenter']").val(data.centerName);
	$('#ModifyGroup').val(data.GroupName);
	$('#ModifyProduct').val(data.ProductName);
	$('#ModifyRollbackType').val(data.RollbackType);
	$('#ModifyRopId').val(data.ropid);
	$('#ModifyReleaseVersion').val(data.ReleaseVersion);
	$('#ModifyStartTime').val(data.StartTime);
	$('#ModifyEndTime').val(data.EndTime);
	$('#ModifyRollBackReason').val(data.RollbackReason);
	$('#ModifyDeveloper').val(data.Developer);
	$('#ModifyTester').val(data.Tester);
	$('#ModifyRollBack').val(data.RollbackCategory);
	$('#ModifyGroupReason').val(data.RollbackGroup);
	$('#ModifyDescription').val(data.Description);
	

}