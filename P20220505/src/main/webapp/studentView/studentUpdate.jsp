<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>수정할 학생의 학번 검색</h2>
	<form action="${pageContext.servletContext.contextPath }/studentNoSearch.do" method="post">
		<ul>
			<li>학번: <input type="number" name="num"></li>
		</ul>
		<input type="hidden" name="cmd" value="update">
		<input type="submit" value="검색하기">
	</form>
	
	<c:choose>
		<c:when test="${!empty result }"><h3>${result }</h3></c:when>
		<c:otherwise>
			<h4>회원정보 수정</h4>
			<form action="${pageContext.servletContext.contextPath }/studentUpdate.do" method="post">
				<ul>
					<li>학번: <input type="number" name="num" readonly value="${student.studNo }"></li>
					<li>이름: <input type="text" name="name" value="${student.studName }"></li>
					<li>학과: <input type="text" name="dept" value="${student.department }"></li>
					<li>담당교수: <input type="text" name="prof" value="${student.professor }"></li>
				</ul>
				<input type="submit" value="수정하기">
			</form>
		</c:otherwise>
	</c:choose>
</body>
</html>