<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>studentResult/noSearchOutput.jsp</title>
</head>
<body>
		<c:choose>
		<c:when test="${!empty result }"><h4>${result }</h4></c:when>
		<c:when test="${!empty student }">
			<table border="1">
				<thead><tr><th>학번</th><th>이름</th><th>학과</th><th>담당교수</th></tr></thead>
				<tbody>
						<tr><td>${student.studNo }</td><td>${student.studName }</td><td>${student.department }</td><td>${student.professor }</td></tr>
				</tbody>
			</table>
		</c:when>
	</c:choose>
	<jsp:include page="home.jsp"></jsp:include>
</body>
</html>