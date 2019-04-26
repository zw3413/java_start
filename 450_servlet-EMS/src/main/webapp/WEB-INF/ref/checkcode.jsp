<%@page pageEncoding="utf-8" contentType="text/html;charset=utf-8"%>


<img id="num" src="checkcode"/>
<a onclick="$('#num').attr('src','checkcode?'+Math.random())" href="">换一张</a>