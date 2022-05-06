<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>studentView/studentDelete.jsp</title>
</head>
<body>
	<h2>삭제할 학생의 학번 검색</h2>
	<form action="${pageContext.servletContext.contextPath }/studentNoSearch.do" method="post">
		<ul>
			<li>학번: <input type="number" name="num"></li>
		</ul>
		<input type="hidden" name="cmd" value="delete">
		<input type="submit" value="검색하기">
	</form>
	
	<c:choose>
		<c:when test="${!empty result }"><h3>${result }</h3></c:when>
		<c:otherwise>
			<h3>삭제할 학생 정보 확인</h3>
			<form action="${pageContext.servletContext.contextPath }/studentDelete.do" method="post">
				<input type="hidden" readonly name="num" value="${student.studNo }">
				이름 :	<input type="text" readonly name="name" value="${student.studName }"><br>
				<input type="submit" value="삭제하기">
			</form>
		</c:otherwise>
	</c:choose>
</body>
</html>