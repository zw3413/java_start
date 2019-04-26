$(function(){
	//1.模态框上注册click事件
	$("#modal-dialog").on('click','.ok',doSaveOrUpdate);
	//2.模态框隐藏时移除click事件
	$("#modal-dialog").on("hidden.bs.modal",function(){
		$('#modal-dialog').off("click",".ok");
		var id=$("#modal-dialog").data("id");
		if(id) $("#modal-dialog").removeData("id");
	})	
	//$("p").off( "click", "**" )
	//3.获取模态框上绑定的id值（可能有值也可能没有值）
	var id=$("#modal-dialog").data("id");
	console.log("#modal-dialog.id="+id);
	//假如id有值，一定是修改，然后根据id查记录，将记录信息初始化到表单中
	if(id) doFindObjectById(id);
});

//通过id查找项目对象
function doFindObjectById(id){
	console.log("doFindObjectById()")
	var url="project/doFindObjectById.do";
	var params={"id":id};
	$.getJSON(url,params,function(result){
		if(result.state==1){
			console.log(result.data);
			setEditFormData(result.data);
		}else{
			alert(result.message);
		}
	})
}
//将根据id从服务器请求的数据显示在模态框上面
function setEditFormData(data){
	$("#nameId").val(data.name);
	$("#codeId").val(data.code);
	$("#beginDateId").val(data.beginDate);
	$("#endDateId").val(data.endDate);
	$("#noteId").html(data.note);

//	if(data.valid){
//		$("#editFormId input[name$='valid'][value='1']").attr("checked",true);
//		$("#editFormId input[name$='valid'][value='0']").removeAttr("checked");
//	}else{
//		$("#editFormId input[name$='valid'][value='1']").removeAttr("checked");
//		$("#editFormId input[name$='valid'][value='0']").attr("checked",true);
//	}
	
//	$("#editFormId input[name='valid']").each(function(){
//		if($(this).val()==data.valid){
//			$(this).prop("checked",true);
//		}
//	})
	$("#editFormId input[name='valid'][value='"+data.valid+"']").prop("checked",true);
}

function doSaveOrUpdate(){
	debugger
	console.log("doSaveOrUpdate()")
	//0.对表单数据进行非空验证
	//valid方法为bootstrap方法，其验证：
	if(!$('#editFormId').valid()){
		return;
	}
	//1.获取表单数据
	var params=getEditFormData();
	console.log(params);
	//2.异步提交表单数据
	var id=$("#modal-dialog").data("id");
	var updateUrl="project/doUpdateObject.do";
	var insertUrl="project/doSaveObject.do";		
	var url=id?updateUrl:insertUrl;
	//修改时需要根据id进行修改，当key比较复杂时可采用params['key']=value形式赋值
	if(id) params['id']=id;
	$.post(url,params,function(result){
		debugger
		if(result.state==1){
			alert(result.message);
			
			doGetObjects();
			//$(".btn-default").trigger('click');	
			$('#modal-dialog').modal('hide');
		}else{
			alert(result.message);
		}
	})
}

function getEditFormData(){
	var params={"name":$("#nameId").val(),
			"code":$("#codeId").val(),
			"beginDate":$("#beginDateId").val(),
			"endDate":$("#endDateId").val(),
			"valid":$("#editFormId input[name='valid']:checked").val(),
			"note":$("#noteId").val(),
			};
	return params;
}