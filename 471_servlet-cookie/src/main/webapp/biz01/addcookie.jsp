<%@page pageEncoding="utf-8" contentType="text/html;charset=utf-8"%>

<%
Cookie c=new Cookie("username","Sally");
c.setPath("/471_servlet-cookie");
response.addCookie(c);
%>
<html>
<head></head>
<body style="font-size:30px;">
	
</body>
</html>