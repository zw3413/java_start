<%@page pageEncoding="utf-8" contentType="text/html;charset=utf-8"%>
<html>
<head></head>
<body style="font-size:30px;">
	1+1=${1+1 }
	"a"+"b"=${"1"+"2" }
	<br/>
	${1<2 }
	<%
		request.setAttribute("str1","abc");
	%>
	${str1=="abc"} <br/>
	${sessionScope.str1=="abc" }<br/>
	${1<2&&2>3 }
	<br/>
	<%
		request.setAttribute("str1","");
		java.util.List list1=new java.util.ArrayList();
		request.setAttribute("list1", list1);
	%>
	空的字符串：${empty str2 }
	空的集合：${empty list1 }
	null值:${empty null }
	找不到对应的值: ${empty a }
</body>
</html>