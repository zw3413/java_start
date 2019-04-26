<%@page pageEncoding="utf-8" contentType="text/html;charset=utf-8"%>
<html>
<head></head>
<body style="font-size:30px;">
	b2...<br/>
	<a href="biz01/b1.jsp">点这儿跳转到b1-通过相对路径"biz01/b1.jsp"</a><br/>
	<a href="<%=request.getContextPath()%>/biz01/b1.jsp">点这儿跳转到b1-通过绝对路径"=request.getContextPath()/biz01/b1.jsp"</a><br/>
	
</body>
</html>