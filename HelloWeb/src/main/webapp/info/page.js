//page.js
console.log(member1); //전역번수에 선언했던 값을 main.html에 .js 파일이 같이 들어있으므로 사용가능

let field = 'fullName';
console.log(member1.fullName);
console.log(member2['fullName']);
console.log(member3[field]); //가장 기억해둘것!

//배열요소를 반복적으로 for...of
for (let member of members) {
  // console.log(`이름은 ${member.fullName}`); 도 가능하지만 아래와 같이 사용하기
  console.log(`이름은 ${member['fullName']}이고 나이는 ${member['age']}이고 ${member['score']}입니다.`);
}

//오브젝트의 속성(필드)을 반복적으로 for...in
for (let field in member1) {
  console.log(`${field} => ${member1[field]}`);
}

//각 배열요소의 각 필드를 출력
for (let member of members) {
  for (let field in member) {
    console.log(`${field} => ${member[field]}`);
  }
  console.log(`----------------------------------`);
}

//각 배열요소의 선택적 필드를 출력
let fields = ['fullName', 'score'];
for (let member of members) {
  for (let prop of fields) {
    console.log(`${prop} => ${member[prop]}`);
  }
  console.log(`==================================`);
}

//각 배열요소의 필드 순서 변경 및 테이블로 출력
document.write('<table border=1>');
let fields1 = ['fullName', 'score', 'age'];
for (let member of members) {
  document.write('<tr>');
  for (let prop of fields1) {
    console.log(`${prop} => ${member[prop]}`);
    document.write(`<td>${member[prop]}</td>`)
  }
  document.write('<td><button>클릭</button></td>');
  document.write('</tr>');
  console.log(`*********************************`);
}
document.write('</table>')