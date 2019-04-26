$(document).ready(function(){
	doGetObjects();
	$("#queryFormId").on("click",".btn-search",doQueryObjects)
	.on("click",".btn-valid,.btn-invalid",doValidById)
	.on("click",".btn-add,.btn-update",doShowEditDialog);
});
function doValidById(){
	console.log("doValidById");
	//TODO
	var valid;
	if($(this).hasClass('btn-valid'))
		valid=1;
	if($(this).hasClass('btn-invalid'))
		valid=0;
	var ids=getIds();
	var params={"ids":ids,"valid":valid};
	if(ids==""){
		alert("没有选择任何项目");
		return;
	}
	var url="project/doValidById.do";
	$.post(url,params,function(result){
		debugger
		if(result.state==1){
			doGetObjects();
		}else{
			alert(result.message);
		}
	})
	
}

function getIds(){
	var ids="";
	var id=$("input[name='checkItem']:checked").each(function(){
		var id=$(this).parent().parent().data("id");
		if(ids==""){
			ids+=id
		}else{
		ids+=","+id;
	}
	})
	console.log("ids"+ids);
	return ids;
}


function doShowEditDialog(){
	console.log("doShowEditDialog");
	var title;
	if($(this).hasClass("btn-add")){
		title="添加项目信息";
	}
	if($(this).hasClass("btn-update")){
		var id=$(this).parent().parent().data("id");
		$("#modal-dialog").data("id",id);
		title="修改项目信息 id="+id;
	}
	
	var url="project/editUI.do";
	$('#modal-dialog .modal-body').load(url,function(){
		$('#myModalLabel').html(title);
		$("#modal-dialog").modal('show');
	});
}

function doQueryObjects(){
	console.log("doQueryObjects()");
	//1.初始化当前页码信息
	$("pageId").data("pageCurrent",1);
	//2.执行查询操作
	//2.1获得表单数据
	//2.2提交表单数据执行查询
	doGetObjects();
}
/*获取表单数据*/
function getQueryFormData(){
	var params={
			"name":$("#searchNameId").val(),
			"valid":$("#searchValidId").val()
	}
	return params;
}
/*异步(ajax)加载服务端数据*/
function doGetObjects(){

	//1.定义访问项目信息的url
	var url="project/doFindPageObjects.do";
	//2.获取表单数据（查询时用）
	var params=getQueryFormData();
	//2.发起异步ajax请求
//	var data1;
//	$.ajax({"url":url,
//				"type":"get",
//				"success":function(data){
//					console.log(data);
//					data1=data;
//		}});
/*服务端：list<project>-->json串
 * 客户端：json串-->json对象：Array*/
	//3.动态设置分页页码数据
	var pageCurrent=$("#pageId").data("pageCurrent");
	if(!pageCurrent) pageCurrent=1;
	params.pageCurrent=pageCurrent;
	console.log("params.pageCurrent:"+params.pageCurrent);
	//4.发起异步ajax请求{name:"",valid:"",pageCurrent:1)
	$.getJSON(url,params,function(result){
		console.log(result);
		setTableBodyRows(result.list);
		setPagination(result.pageObject);
	})
}
function setPage(pageObject){
	/*
	 * 	<a class="first">首页</a>
		<a class="pre">上一页</a>&nbsp;
		<a class="next">下一页</a>
		<a class="last">尾页</a>
		<a class="pageCount">总页数(1)</a>
		<a class="pageCurrent">当前页(1)</a>
	 */
	$(".first").click(function(){
		doGetObjects(pageObject.startIndex)
	});
	$(".pre").click(function(){
		doGetObjects(pageObject.pageCurrent-1)
	});
	$(".next").click(function(){
		doGetObjects(pageObject.pageCurrent+1)
	});
	$(".last").click(function(){
		doGetObjects(pageObject.pageCount)
	});
	$(".pageCount").html("总页数("+pageObject.pageCount+")");
	$(".pageCurrent").html("当前页("+pageObject.pageCurrent+")");
}

/*将服务端返回的JSON对象数据显示在页面上*/
function setTableBodyRows(result){
	//1.获得具体dom对象（显示数据位置的那个dom）
	var tBody=$("#tbodyId");//jquery的函数
	tBody.empty();
	console.log(result.length);
	//2.
	for(var i=0;i<result.length;i++){
		
		//2.1构建tr对象
		var tr=$("<tr></tr>");
		tr.data("id",result[i].id);
		//2.2构建td对象
		var tds="<td><input type='checkbox' name='checkItem'/></td>"+
		"<td>"+result[i].code+"</td>"+
		"<td>"+result[i].name+"</td>"+
		"<td>"+result[i].beginDate+"</td>"+
		"<td>"+result[i].endDate+"</td>"+
		"<td>"+(result[i].valid?"启用":"禁用")+"</td>"+
		"<td><button type='button' class='btn btn-default btn-update'>修改</button></td>";
		//2.3将td对象添加到tr中 
		tr.append(tds);
		//2.4将tr对象添加到tbody中
		tBody.append(tr);
	}
}