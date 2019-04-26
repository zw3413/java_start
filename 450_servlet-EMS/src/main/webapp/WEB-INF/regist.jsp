<%@page pageEncoding="utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>regist</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css" href="css/style.css" />
		<script type="text/javascript" src="${request.getRequestContextPath()}/jquery-1.11.1.js"></script>
		<script>
		$('.datepicker').datepicker({
			format:'yyyy/mm/dd',
			autoclose:true
		});
		</script>
	</head>
	<body>
		<div id="wrap">
			<div id="top_content">
				<%@ include file="/WEB-INF/ref/header.jsp" %>
				<div id="content">
					<p id="whereami">
					</p>
					<h1><%=msg!=null?msg:"注册" %></h1>
					<form action="regist.s" method="post">
						<table cellpadding="0" cellspacing="0" border="0"
							class="form_table">
							<tr>
								<td valign="middle" align="right">
									用户名:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="username" />
								</td>
								<td></td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									真实姓名:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="name" />
								</td>
								<td></td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									密码:
								</td>
								<td valign="middle" align="left">
									<input type="password" class="inputgri" name="pwd" />
								</td>
								<td></td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									性别:
								</td>
								<td valign="middle" align="left">
									男
									<input type="radio" class="inputgri" name="sex" value="m" checked="checked"/>
									女
									<input type="radio" class="inputgri" name="sex" value="f"/>
								</td>
								<td></td>
							</tr>
							
							<tr>
								<td valign="middle" align="right">
									验证码:
									
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="number" />
								</td>
								<td>
								<%@include file="ref/checkcode.jsp" %>
									</td>
							</tr>
						</table>
						<p>
							<input type="submit" class="button" value="Submit &raquo;" />
						</p>
						日期：<input type="text" name="日期"  class="datepicker"/>
					</form>
				</div>
			</div>
			<%@include file="/WEB-INF/ref/footer.jsp" %>
		</div>
	</body>
</html>
