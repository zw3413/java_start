<%@page pageEncoding="utf-8" %>

<html>
	<head>
		<title>登陆</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css"href="css/style.css" />
	</head>
	<body>
		<div id="wrap">
			<div id="top_content">
					<%@include  file="/WEB-INF/ref/header.jsp" %>
				<div id="content">
					<p id="whereami">
					
					</p>
					<h1><%=msg!=null?msg:"登陆" %></h1>
					<span><%=request.getAttribute("msg")!=null?(String)request.getAttribute("msg"):
						(String)request.getAttribute("registResult")!=null?(String)request.getAttribute("registResult"):
							(String)request.getAttribute("loginResult")!=null?(String)request.getAttribute("loginResult"):""%></span>
					<form action="login.s" method="post">
						<table cellpadding="0" cellspacing="0" border="0"
							class="form_table">
							<tr>
								<td valign="middle" align="right">
									用户名:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="username" />
								</td>
								<td>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									密码:
								</td>
								<td valign="middle" align="left">
									<input type="password" class="inputgri" name="password" />
								</td>
								<td>
								</td>
							</tr>
							<tr>
								<td>验证码：
								</td>
								<td><input type="text" name="number"/>
								</td>
								<td>
									<%@include file="ref/checkcode.jsp" %>
								</td>
							</tr>
						</table>
						<p>
							<input type="submit" class="button" value="登陆 &raquo;" />
						</p>
					</form>
				</div>
			</div>
			<%@include file="/WEB-INF/ref/footer.jsp" %>
		</div>
	</body>
</html>
