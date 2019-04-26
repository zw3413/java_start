<%@page pageEncoding="utf-8" contentType="text/html;charset=utf-8"%>
<%@page import="bean.*" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head></head>
<body style="font-size:30px;">
	<%
		User user=new User();
		user.setName("楚乔");
		user.setGender("x");
		request.setAttribute("user", user);
	%>
	
	姓名：${user.name }
	性别：
	<c:if test="${user.gender=='f'}">女</c:if><br/>
	性别:
	<c:if test="${user.gender=='f'}" var="rs" scope="page">女</c:if>
	<c:if test="${!rs }">男</c:if>
	
	
</body>
</html>