<%@page pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link type="shortcut-icon" src="hero0.png"/>
<title>new ems</title>
<script src="jquery-1.11.1.js"></script>
<link rel="stylesheet" type="text/css"href="css/style.css" />
</script>
<script>
	$(function() {
		$('#addemp_btn').click(function() {
			location.href = "addEmp.jsp";
		});
	})
</script>

</head>
<body>

<div id="wrap">
	<div id="top_content">
		<%@ include file="/WEB-INF/ref/header.jsp" %>
		<div style="height:355px">

		<div style="float:left;">
		<%java.util.Random r=new java.util.Random(); %>
		<img src="<%=request.getContextPath()+"/images/t7.jpg" %>" >
		</div>
		<div style="float:left; ">
	
		<input type="button" value="添加新员工信息"  onclick="location.href='<%=request.getContextPath()%>/toAdd.do'" /><br />
		<input type="button" value="显示所有员工信息" onclick="location.href='<%=request.getContextPath()%>/list.do'" /><br />
		<input type="button" value="个人信息"  onclick="location.href='<%=request.getContextPath()%>/toEmp.do'"/>
		
		</div>
		</div>
	</div>
	<%@include file="/WEB-INF/ref/footer.jsp" %>
</div>
</body>
</html>

