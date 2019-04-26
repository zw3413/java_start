<%@page pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>新时代员工管理系统</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/style.css" />

</head>
<body>
	<div id="wrap">
		<div id="top_content">
		<!-- include 指令 只有一个属性：file（指定被包含的文件），将另外文件jsp内容插入到此处 -->
			<%@include file="/WEB-INF/ref/header.jsp" %>
			
			<div id="content">
				<p id="whereami"></p>
				<h1><%=msg!=null?msg:"欢迎" %></h1>
				<table class="table">
					<tr class="table_header">
						<td>ID</td>
						<td>Name</td>
						<td>Salary</td>
						<td>Age</td>
						<td>Operation</td>
					</tr>
					
					<c:forEach items="${employees}" var="e" varStatus="s">
						<tr class="row${s.index%2+1 }">
						<td>${e.id}</td>
						<td>${e.ename}</td>
						<td>${e.salary }</td>
						<td>${e.age }</td>
						<td>
							<a href="del.do?id=${e.id}" onclick="return confirm('确定删除 ${e.ename}吗?')">删除</a>
							<a href="load.do?id=${e.id }">修改</a>					
						</td>
						</tr>
					</c:forEach>

				</table>
				<p>
					<input type="button" class="button" value="添加员工信息	"
						onclick="location='toAdd.do'" />
				</p>
			</div>
		</div>
<%@include file="/WEB-INF/ref/footer.jsp" %>
	</div>
</body>
</html>