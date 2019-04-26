<%@page pageEncoding="utf-8" contentType="text/html;charset=utf-8"%>
<html>
<head></head>
<body style="font-size:30px;">
<%
	Object obj=session.getAttribute("user");
if(obj==null){
	//没有登陆,重定向到登陆页面
	response.sendRedirect("login.jsp");
	return;
}else{
	//已经登陆过
}
%>
这是首页	
</body>
</html>