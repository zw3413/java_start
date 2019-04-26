<%@page pageEncoding="utf-8" contentType="text/html;charset=utf-8"%>
<%@page session="false" %>
<html>
<head></head>
<body style="font-size:30px;">
	<%! 
		int i=100; 
		int sum(int a1,int a2){
			return a1+a2;
		}
	%>
	<%=i+100 %>
	<%=sum(1,1) %><br/>
	<%='a'+'b' %><br/>
<%request.setAttribute("count",new Integer(0));
	Integer count =(Integer)request.getAttribute("count");
%>
<%=count %>
<%int temp=0; %>
<h1>temp is <%=temp %></h1>
<%Object o=request.getAttribute("a"); 
	System.out.println(o);
%>
</body>
</html>