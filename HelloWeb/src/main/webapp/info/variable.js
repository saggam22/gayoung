// variable.js

var myName = '이가영'; //string
var yourName; //변수를 두번 선언해도 오류가 나지 않음
myName = 100; //number
myName = true; //boolean
myName = null; //object

console.log(typeof yourName);

var yourName = '홍길동'; 
//undefined : console 이후에 변수가 선언되면 변수만 끌어올려서 변수의 유무만 확인, 값이 담겨있지 않다는 뜻

console.log(typeof yourName); //string으로 확인 됨

//전역변수(스크립트변수), 지역변수(함수안에서 변수)

function checkInfo() {
  var myName = 'LeeGaYoung'; //지역변수 함수안에서만 사용되었다가 함수가 끝나면 값이 사라진다
  console.log(myName);
}
checkInfo(); //함수호출되어서 LeeGaYoung 출력
console.log(myName); //함수 호출이 끝났으므로 값이 사라져 null 출력

//ES6 (ES2015) => let(변수를 동일하게 선언하면 오류를 일으킴), const(상수값 선언) 추가
//let 블럭레벨 변수 선언.
function info() {
  let myName = 'Hong';
  console.log(myName);
}
info();

//함수 밖에서 myName을 선언하면 중복변수명이므로 에러 발생

{
  let myName = 'Hong';
  console.log(myName);
}

{
  let myName = 'Hwang';
  console.log(myName);
} //블럭단위로 변수를 선언할때도 사용

const otherName = 'Hong';
//otherName = 'Hwang';

//var, let => 변수선언
//const => 상수선언