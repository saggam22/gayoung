<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form name="frm" action="StudentGetServlet" method="get"> <!-- get방식은 주소창에 파라메타값을 표시하고 post는 주소값에 표시하지 않음 -->
		<input type="hidden" name="cmd" value="search">
		ID : <input type="number" name="user_id"><br>
		Name : <input type="text" name="user_name"><br>
		Eng : <input type="number" name="eng_score"><br>
		Kor : <input type="number" name="kor_score"><br>
		<input type="submit" value="조회">
		<input id="addBtn" type="button" value="입력">
		<input id="modBtn" type="button" value="수정">
		<input id="delBtn" type="button" value="삭제">
		<hr>
		<a href="studentList.jsp">학생목록</a>
	</form>
	
	<script>
		let addbtn = document.querySelector('#addBtn');
		addbtn.addEventListener('click', function() {
			let frm = document.forms.frm;
			frm.action = "StudentGetServlet";
			frm.method = "post";
			frm.cmd.value = "add";
			frm.submit(); //form의 submit을 누른거와 같음
		});
		
		let modbtn = document.querySelector('#modBtn');
		modbtn.addEventListener('click', function() {
			let frm = document.forms.frm;
			frm.method = "post";
			frm.cmd.value = "mod";
			frm.submit(); //form의 submit을 누른거와 같음
		});
		
		let delbtn = document.querySelector('#delBtn');
		delbtn.addEventListener('click', function() {
			let frm = document.forms.frm;
			frm.method = "post";
			frm.cmd.value = "del";
			frm.submit(); //form의 submit을 누른거와 같음
		});
	</script>
</body>
</html>