<%@page pageEncoding="utf-8" contentType="text/html;charset=utf-8"%>
<html>
<head></head>
<body style="font-size:30px;">
<!--  隐含对象： request response out session config application -->
	在线人数是 <%=application.getAttribute("count") %>
</body>
</html>