<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${!empty error }"><h4>${error }</h4></c:if>
	<h2>학생이름 검색</h2>
	<form action="${pageContext.servletContext.contextPath }/studentNameSearch.do" method="post">
		<ul>
			<li>이름: <input type="text" name="name"></li>
		</ul>
		<input type="submit" value="검색하기">
	</form>
</body>
</html>