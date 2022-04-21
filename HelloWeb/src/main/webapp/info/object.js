//object.js

//마치 자바의 클래스와 같음 
let member1 = {
  fullName: 'Hong',
  age: 20,
  score: 80
};
let member2 = {
  fullName: 'Hwang',
  age: 22,
  score: 88
};

let member3 = {
  fullName: 'Park',
  age: 25,
  score: 92
};

member1.fullName = '홍';
console.log(member1.fullName);
console.log(member1.age + member2.age);

//{key: value}, {key: value}
const members = [member1, member2, member3];
//홍의 나이는 20이고 점수는 80입니다의 형식으로 출력하기
for (let i = 0; i < members.length; i++) {
  console.log(members[i].fullName + '의 나이는 ' + members[i].age + '이고 점수는 ' + members[i].score + '입니다.');
}

document.write('<h3>Hong</h3>'); //()안 내용을 documemt영역에 쓰겠다 js의 라이브러리

document.write('<ul>');
for (let i = 0; i < members.length; i++) {
  document.write('<li>' + members[i].fullName + ',' + members[i].age + ',' + members[i].score + '</li>');
  //문자열을 나타내는 기호 '' "" 그리고 `(백틱)이 추가됨
  document.write(`<li>${members[i].fullName}, ${members[i].age}, ${members[i].score}</li>`);
}
document.write('</ul>')

//줄바꿈도 지원
let welcome = `안녕하세요.
반갑습니다,`;
console.log(welcome);