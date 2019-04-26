<%@page pageEncoding="utf-8" contentType="text/html;charset=utf-8"%>
<%@page import="bean.*,java.util.*"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<style>
.row1{
	background-color:#fff8dc;
}
.row2{
	background-color:#f0f0f0;
}


</style>

</head>
<body style="font-size:30px;">
	<%
		List<User> users=new ArrayList<User>();
		for(int i=0;i<8;i++){
			User user=new User();
			user.setName("楚乔"+i);
			user.setAge(22+i);
			user.setGender("x");
			users.add(user);
		}
		request.setAttribute("users", users);
	%>
	
	<table width="60%" border="1" cellspacing="0" cellpadding="0">
	<tr>
	<td>姓名</td>
	<td>年龄</td>
	<td>性别</td>
	<td>index</td>
	<td>count</td>
	</tr>
	<c:forEach  items="${users}" var="u" varStatus="s">
	<tr class="row${s.index%2+1 }">
	<td>${u.name }</td>
	<td>${u.age }</td>
	<td>
		<c:choose>
			<c:when test="${u.gender=='f' }">女</c:when>
			<c:when test="${u.gender=='m' }">男</c:when>
			<c:otherwise>保密</c:otherwise>
		</c:choose>
	</td>
	<td>${s.index }</td>
	<td>${s.count }</td>
	</tr>
	</c:forEach>
	
	
	</table>
	
	
</body>
</html>