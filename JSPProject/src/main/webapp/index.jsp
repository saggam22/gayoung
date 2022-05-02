<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index.jsp</title>
</head>
<body>
	<h3>반갑습니다.</h3>
	<%
		String name ="홍길동";
		out.println("<h3>" + name + "</h3>"); //out 선언 안해도 쓸 수 있는 내장객체. 톰캣이 jsp서블릿 형태로 바꿔줄때 선언됨
		
		String id = request.getParameter("user_id");
		String name2 = request.getParameter("user_name");
		out.println("<h4>" +"아이디는 "+ id + "이고 이름은 " + name2 + "</h4>");
	%> <!-- %로 선언시 자바소스 입력가능 -->
	<a href="./student/student.do">Student Servlet</a>
</body>
</html>