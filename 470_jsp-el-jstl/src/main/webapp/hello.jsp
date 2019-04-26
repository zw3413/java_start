<%@ page import="java.util.*" import="java.text.*" language="java"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body style="font-size: 30px">
	time:
	<%
	Date date = new Date();
SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

	out.println(sdf.format(date));
	%>

	<br /> time2:<%=new Date()%>
	<br />

	<%
		for (int i = 0; i < 5; i++) {
			out.println("Hello Kitty.<br/>");
		}
	%>
</body>
</html>