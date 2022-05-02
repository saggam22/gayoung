<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ajax.jsp</title>
</head>
<body>
	<script>
		//Asynchronous Javascript And XML
		let url = 'StudentGetServlet'; //기본방식은 get이고 파라메터값이 없음
		fetch(url) //XMLHttp와 promise객체를 내부적으로 구현하고 있는 함수
				.then(result => {
					console.log(result);
					return result.json(); //{"id":23, "name":"hong"}(json타입으로 받음) result.text();로 받을 수도 있음(문자형식으로 받음)
				})
				.then(result => {
					console.log(result);
				})
				.catch(error => {
					console.log(error);
				})
	</script>
</body>
</html>