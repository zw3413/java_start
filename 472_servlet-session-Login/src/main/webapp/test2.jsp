<%@page pageEncoding="utf-8" contentType="text/html;charset=utf-8"%>
<html>
<head>


<script type="text/javascript" src="jquery-1.11.1.js"></script>
<script type="text/javascript">
$(function(){
	$('img').eq(0).click(function(e){
		e.target.setAttribute("src","checkcode?"+Math.random());
		
	})
})


</script>

</head>
<body style="font-size:30px;">

	hello<br/>
	<img src="checkcode" border="1"/>

	
</body>
</html>