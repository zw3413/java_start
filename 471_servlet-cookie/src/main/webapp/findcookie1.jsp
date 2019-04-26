<%
Cookie[] cookies=request.getCookies();
if(cookies!=null){
	for(Cookie c:cookies){
		out.println(c.getName()+"="+c.getValue()+"<br/>");
	}
}
%>