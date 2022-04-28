/**
 * post.js
 */

document.addEventListener('DOMContentLoaded', init);

function init() {
	let xhtp = new XMLHttpRequest();
	xhtp.open('get', '../studentList.json');
	xhtp.send();
	xhtp.onload = function() {
		let data = JSON.parse(xhtp.responseText); //json -> object
		console.log(data); //[{},{},{}]
		let tbodyList = document.getElementById('list');
		data.forEach(function(elem) {
			tbodyList.appendChild(makeTr(elem));
		});
	}//end of onload
	
	let modBtn = document.querySelector('input[type=button]'); //""을 해주지 않아도 된다. html자체가 읽는데 문제가 없음
	modBtn.addEventListener('click', function() {
		let sno = document.querySelector('input[name=sno]').value;
		let sname = document.querySelector('input[name=sname]').value;
		let eng = document.querySelector('input[name=eScore]').value;
		let kor = document.querySelector('input[name=kScore]').value;
		
		let xhtp = new XMLHttpRequest();
		xhtp.open('get', `modStudentServlet?a=${sno}&b=${sname}&c=${eng}&d=${kor}`);
			xhtp.send();
	xhtp.onload = function() {
		let result = JSON.parse(xhtp.responseText);
		if (result.retCode == 'OK') {
		//결과값으로 받은 값을 => 새로운 tr
			let obj = {
				studentNo: result.studentNo,
				studentName: result.studentName,
				engScore: result.engScore,
				korScore: result.korScore
			}
			let newTr = makeTr(obj);
			let oldTr = document.getElementById(result.studentNo);
			document.getElementById('list').replaceChild(newTr, oldTr); //새로운 tr로 교체
		} else {
			alert('변경 중 오류');
		}
	}
	})
}//end of init

//변경처리 함수
function modStudent(e) {
	//{\"retCode\":\"OK\", \"studentNo\":"+sNo+", \"studentName\":\""+sName+"\", \"engScore\":"+eng+", \"korScore\":"+kor+"}");	
}

//한건 추가하는 함수
function addStudent(e) {
	e.preventDefault(); //submit -> 차단
	console.log(e);
	
	//넘겨오는 파라메터 값 표시
	let sno = document.querySelector('input[name="sno"]').value;
	let sname = document.querySelector('input[name="sname"]').value;
	let eng = document.querySelector('input[name="eScore"]').value;
	let kor = document.querySelector('input[name="kScore"]').value;
	
	let xhtp = new XMLHttpRequest(); //비동기방식으로 서버의 파일요청
	xhtp.open('get', `addStudentServlet?sno=${sno}&sname=${sname}&eScore=${eng}&kScore=${kor}`); //addStudentServlet 을 get방식으로 실행하겠다
	xhtp.send(); //실행(호출)
	xhtp.onload = function() {
		console.log(xhtp.responseText); //xhtp.responseText 받아온 문자열(json형태의문자열) {"retCode":"Success"}
		let result = JSON.parse(xhtp.responseText); //오브젝트 타입으로 {retCode:"Success"}
		if (result.retCode == 'Success') {
			//리스트 새로운 값 추가
			successCallBack2(result); //result의 값 : {retCode:?, studNo:? ...}
		} else if (result.retCode == 'Fail') {
			//처리중 에러가 발생
			failCallBack();
		}

	}//end of function
}//end of addStudent(e)

function makeTr(student) {

	let tr = document.createElement('tr');
	tr.setAttribute('id', student.studentNo); //라인삭제를 id값으로 받아서 삭제하기 위해 구현
	for (let field in student) {
		let td = document.createElement('td');
		td.innerHTML = student[field];
		tr.appendChild(td);
	}
	
	//삭제버튼이 눌리면 삭제
	let delBtn = document.createElement('button');
	delBtn.innerHTML = '삭제';
	
	delBtn.addEventListener('click', function() {
		//삭제(id파악 => ajax호출) : this => 이벤트 대상 엘리먼트
		let id = this.parentElement.parentElement.firstChild.innerHTML;
		console.log(id);
		let xhtp = new XMLHttpRequest();
		xhtp.open('get', 'delStudentServlet?delId='+id);
		xhtp.send();
		xhtp.onload = function() {
			let result = JSON.parse(xhtp.responseText);
			console.log(result)
			if(result.retCode == 'OK') {
				alert(result.retVal + '번이 삭제되었습니다.');
				document.getElementById(result.retVal).remove();
			} else {
				console.log(result.retVal);
			}
		}
	});
	
	let td = document.createElement('td');
	td.appendChild(delBtn);
	tr.appendChild(td);
	 
	return tr;
}//end of makeTr(student)

//success시 json을 이용
function successCallBack2(retObj) {
	console.log(retObj)
	
	let obj = {
		studentNo: retObj.studentNo,
		studentName: retObj.studentName,
		eScore: retObj.engScore,
		kScore: retObj.korScore
	};
	
	document.getElementById('list').appendChild(makeTr(obj));

}//end of successCallBack2

function successCallBack() {
	//사용자 입력값을 id = 'list' (tbody) 하위 추가
	let sno = document.querySelector('input[name="sno"]').value;
	let sname = document.querySelector('input[name="sname"]').value;
	let eng = document.querySelector('input[name="eScore"]').value;
	let kor = document.querySelector('input[name="kScore"]').value;

	let student = {
		number: sno,
		name: sname,
		eScore: eng,
		kScore: kor
	};
	
	let low = makeTr(student)
	document.getElementById('list').appendChild(low);
}

function failCallBack() {
	alert('처리중 에러발생');
}