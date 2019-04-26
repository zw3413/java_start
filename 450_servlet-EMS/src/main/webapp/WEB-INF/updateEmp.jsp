<%@page pageEncoding="utf-8"%>
<%@page import="entity.Employee" %>
<html>
	<head>
		<title>新时代员工信息管理系统</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css"
			href="css/style.css" />
	</head>

	<body>
		<div id="wrap">
			<div id="top_content">
					<%@include file="/WEB-INF/ref/header.jsp" %>
				<div id="content">
					<p id="whereami">
					</p>
					<h1><%=msg!=null?msg:"更新员工信息" %></h1>
					<form action="update.do" method="post">
						<table cellpadding="0" cellspacing="0" border="0"
							class="form_table">
							<tr>
								<td valign="middle" align="right">
									id:
								</td>
								<td valign="middle" align="left">
								<%Employee e=(Employee)request.getAttribute("employee");%>
									<%=e.getId()%><input type="hidden" name="id" value="<%=e.getId()%>">
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									姓名:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="name" value="<%=e.getEname() %>"/>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									薪水:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="salary" value="<%=e.getSalary()%>"/>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									age:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="age" value="<%=e.getAge()%>"/>
								</td>
							</tr>
						</table>
						<p>
							<input type="submit" class="button" value="保存修改" />
						</p>
					</form>
				</div>
			</div>
		<%@include file="/WEB-INF/ref/footer.jsp" %>
		</div>
	</body>
</html>
