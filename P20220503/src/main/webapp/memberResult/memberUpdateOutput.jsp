<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberUpdateOutput.jsp</title>
</head>
<body>
	<c:if test="${!empty error }"><h4>${error }</h4></c:if>
	<h3>${name } 님 수정이 완료되었습니다.</h3>
	<jsp:include page="home.jsp"></jsp:include>
</body>
</html>