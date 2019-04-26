$(document).ready(function(){
	console.log("document.ready");
	//1.加载页面信息
	doGetObjects({});
	//2.绑定事件
	$('#queryFormId').on('click','.btn-search',function(){
		doQueryObjects();
	})
})
function doQueryObjects(){
	//1.获取页面信息
	var projectName=$('#queryFormId .searchPrjId').val();
	var valid=$('#queryFormId .searchValidId').val();
	
	var params={"projectName":projectName,
						"valid":valid};
	doGetObjects(params);
	
}

function doGetObjects(params){
	
	pageCurrent=$('pageId').data('pageCurrent');
	if(!pageCurrent) pageCurrent=1;
	
	params.pageCurrent=pageCurrent;
	
	var url="team/doFindPageObjects.do";
	$.post(url,params,function(result){
		console.log(result);
		if(result.state==1){
			setTeamRows(result.data.list);
			setPage(result.data.pageObject);
		}else{
			alert(result.message);
		}
	})
}

function setTeamRows(list){
	$('#tbodyId').empty();
	
	for(var i=0;i<list.length;i++){
		var tr=$("<tr></tr>");
		var valid=list[i].valid?"启用" : "禁用";
		var tds=
			"<td>"+"<input type='checkbox' id='checkItem'"+"</td>"+
			"<td>"+list[i].name+"</td>"+
			"<td>"+list[i].projectName+"</td>"+
			"<td>"+valid +"</td>"+
			"<td>"+"修改"+"</td>";
		tr.append(tds);
		$('#tbodyId').append(tr);
	}
}

function setPage(page){
	$('pageId .pageCount').html('总页数'+page.pageCount);
	$('pageId .pageCurrent').html('当前页'+page.pageCurrent)
}
