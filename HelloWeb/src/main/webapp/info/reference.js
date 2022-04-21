//reference.js

const names = ['조수연', '황진주', '권가희', '이유빈'];

for (let i = 0; i < names.length; i++) {
  console.log((i + 1) + '번째 이름 : ' + names[i])
}

//enhanced for. 자바와 비교 for(String name : names) {}
for (let name of names) {
  console.log(name);
}

const numbers = [23, 44, 38, 12, 56];
for (let num of numbers) {
  if (num > 40) {
    console.log(num);
  }
}

const inputs = [];
for (let i = 0; i < numbers.length; i++) {
  var inputVal = prompt('값을 입력하세요...');
  console.log(typeof inputVal, inputVal);
  inputs[i] = parseInt(inputVal);
}

//합계, 평균을 구하자
let sum = 0,
  avg = 0; //초기값을 주지 않으면 undefiend상태이므로 항상 초기값을 줘야한다!!
// for(let i=0; i<inputs.length; i++) {
//   sum += inputs[i];
// }
for (let mem of inputs) {
  sum += mem;
}
console.log(sum);
avg = sum / inputs.length;
console.log(avg);