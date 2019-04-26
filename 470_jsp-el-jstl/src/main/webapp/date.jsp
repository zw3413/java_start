<%@page import="java.text.SimpleDateFormat,java.util.Date" %>
<%@page contentType="text/html;charset=utf-8" pageEncoding="utf-8" %>
<html>

<head>
<title>
</title>
<style>
*{
margin:0;
padding:0;
border:0;
}
</style>
<script type="text/javascript" src="jquery-1.11.1.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$('#ss').fadeOut(1000);
	setInterval(function(){
		location.reload();
	},1000)})


</script>
</head>
<body style="font-size:30px">
喜迎十九大，好好学java <br/>
<%SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:"); %>
<div style="float:left">time:<%= sdf.format(new Date())%><%sdf=new SimpleDateFormat("ss");%></div><div style="float:left"><strong id="ss" style="color:red;font-size:32px;"><%=sdf.format(new Date())%></strong></div>



</body>
</html>