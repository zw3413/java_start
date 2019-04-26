<%@page pageEncoding="utf-8" %>
<%@page import="java.util.Date" %>
<%@taglib uri="mytag" prefix="d" %>

<%//初始化session登陆状态
entity.User user=(entity.User)session.getAttribute("user");
String logstatus="login status";
if(user==null){
	//还没有登陆，
	logstatus="<a href='"+request.getContextPath()+"/toRegist.s'>注册</a>|<a href='" +request.getContextPath()+"/toLogin.s'>登陆</a>";
}else{
	//已经登陆
	logstatus="<span>欢迎，"+user.getUsername()+"|<a href=\"logout.do\">退出</a></span>";
}
%>

<%//获取其他页面或服务传递的信息。
	String msg=null;
	Object obj=request.getAttribute("msg");
	if(obj!=null){
		msg=(String)obj;
	}
%>

<script type="text/javascript" src="jquery-1.11.1.js"></script>
<script>
$(document).ready(function(){
	var time=<%=new Date().getTime()%>;
	var t=new Date();
	var id=setInterval(function(){
		time=time+1000;
		t.setTime(time);
		$('#time')[0].innerHTML=t.getHours()+":"+t.getMinutes()+":"+t.getSeconds();
	},1000);	
})
</script>
<div id="header">
				<div id="rightheader">
				
					<p><span id="logstatus"><%=logstatus%></span><br/><span><d:date pattern="yyyy-MM-dd"/></span>&nbsp<span id="time">time on server</span></p>
				</div>
				<div id="topheader">
					<h1 id="title">
						<a href="<%=request.getContextPath()%>/index.html">新时代员工信息管理系统</a>
					</h1>
				</div>
				<div id="navigation"></div>
			</div>