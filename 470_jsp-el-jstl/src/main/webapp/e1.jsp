<%@page pageEncoding="utf-8" contentType="text/html;charset=utf-8"%>
<%@page import="bean.*" %>
<html>
<head></head>
<body style="font-size:30px;">
	<%
		User user=new User(); 
		user.setName("小白");
		user.setAge(22);
		user.setInterest(new String[]{"snooker","football"});
		request.setAttribute("user",user);
		
		User user2=new User();
		user2.setName("李白");
		user2.setAge(32);
		session.setAttribute("user", user2);
	%>
	姓名：
	<%
		//User user1=(User)request.getAttribute("user1");
		//out.println(user1.getName());
	%>
	<br/>
	姓名: ${user.name}
	<br/>
	姓名：（指定查找范围） ${sessionScope.user.name} 
	<br/>
	姓名:  ${user['name']}
	<br/>
	<%
		request.setAttribute("str","age");
	%>
	${sessionScope.user[str]}
	<br/>
	兴趣:${user.interest[0] }
</body>
</html>