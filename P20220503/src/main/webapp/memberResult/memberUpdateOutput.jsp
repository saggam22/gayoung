<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3><%=(String)request.getAttribute("id")%> 님 수정이 완료되었습니다.</h3>
	<%@include file="home.jsp"%>
</body>
</html>