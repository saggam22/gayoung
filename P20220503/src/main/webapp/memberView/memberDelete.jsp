<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberView/memberInsert.jsp</title>
</head>
<body>
	${error }
	<h3>회원정보삭제검색</h3>
	<form action="${pageContext.servletContext.contextPath }/memberSearch.do" method="get">
		삭제 아이디: <input type="text" name="id"><br>
		<input type="hidden" name="job" value="delete">
		<input type="submit" value="검색">
	</form>
	<c:choose>
		<c:when test="${!empty result }"><h3>${result }</h3></c:when>
		<c:otherwise>
			<h3>회원정보 확인하기</h3>
			<form action="${pageContext.servletContext.contextPath }/memberDelete.do" method="post">
				아이디: <input type="text" name="id" readonly value="${member.id }"><br>
				비밀번호: <input type="text" name="passwd" readonly value="${member.passwd }"><br>
				이름: <input type="text" name="name" readonly value="${member.name }"><br>
				이메일: <input type="email" name="email" readonly value="${member.email }"><br>
				<input type="submit" value="삭제">
			</form>
		</c:otherwise>
	</c:choose>
	<jsp:include page="../memberResult/home.jsp"></jsp:include>
</body>
</html>