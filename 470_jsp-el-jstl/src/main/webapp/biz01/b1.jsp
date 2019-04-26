<%@page pageEncoding="utf-8" contentType="text/html;charset=utf-8"%>
<html>
<head></head>
<body style="font-size:30px;">
	b1...<br/>
	<a href="../b2.jsp">点这儿跳转到b2-通过相对路径"../b2.jsp"</a><br/>
	<a href="<%=request.getContextPath()%>/b2.jsp">点这儿跳转到b2-通过绝对路径"=request.getContextPath()/b2.jsp"</a>
</body>
</html>