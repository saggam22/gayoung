<%@page import="co.edu.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% 
		String id = (String) request.getAttribute("id"); //오브젝트 타입이므로 String으로 캐스팅
		String name = (String) request.getAttribute("name"); //class파일을 html처럼 보여주고 있는 것 reqeust는 내장객체
		Student student = (Student) request.getAttribute("result");
	%>
	<h3>id: <%=id %></h3>
	<h3>name: <%=name %></h3>
	<h3>no: <%=student.getStudentNo() %></h3>
	<h3>name: <%=student.getStudentName() %></h3>
</body>
</html>