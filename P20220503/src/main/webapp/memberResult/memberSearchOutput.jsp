<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>검색결과</h3>
	<c:choose>
	<c:when test="${!empty result }"><h4>${result }</h4></c:when>
	<c:when test="${!empty member }">
		<table border="1">
			<thead><tr><th>아이디</th><th>이름</th><th>비밀번호</th><th>이메일</th></tr></thead>
			<tbody>
					<tr><td>${member.id }</td><td>${member.name }</td><td>${member.passwd }</td><td>${member.email }</td></tr>
			</tbody>
		</table>
	</c:when>
	</c:choose>
	<jsp:include page="home.jsp"></jsp:include>
</body>
</html>