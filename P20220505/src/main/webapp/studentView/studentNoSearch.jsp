<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>학생학번 검색</h2>
	<form action="${pageContext.servletContext.contextPath }/studentNoSearch.do" method="post">
		<ul>
			<li>학번: <input type="number" name="num"></li>
		</ul>
		<input type="hidden" name="cmd" value="search">
		<input type="submit" value="검색하기">
	</form>
</body>
</html>