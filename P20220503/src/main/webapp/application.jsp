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
		String name = (String) application.getAttribute("name"); //세션을 다르게 열어도 다 동일한 내용이 표시
		out.print("<h3>" + name + "</h3>");
	%>
</body>
</html>