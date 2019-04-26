<%@page pageEncoding="utf-8" contentType="text/html;charset=utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head></head>
<body style="font-size:30px;">
	<%
		bean.User user=new bean.User();
		user.setName("楚乔");
		user.setGender("x");
		request.setAttribute("user", user);
	%>
	性别:
	<c:choose>
		<c:when test="${user.gender=='f'}">女</c:when>
		<c:when test="${user.gender=='m' }">男</c:when>
		<c:otherwise>保密</c:otherwise>
	</c:choose>
	
	
</body>
</html>