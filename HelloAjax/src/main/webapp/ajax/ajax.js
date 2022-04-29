/**
 * ajax.js
 */
 
 //비동기
let val = 10; 
setTimeout(function(){
	val += 5;
 	console.log('hello -> ' + val);

 	setTimeout(function(){
 		val += 3;
 		console.log('hello2 -> ' + val);
 	
 		setTimeout(function(){
 			val += 3;
 			console.log('hello3 -> ' + val);
 	 
 	 }, 1000);
 	 
 	}, 1000);
 
 }, 2000); //순서대로 처리하지 않고 응답시간으로 처리를 하니까 순서대로 코드를 실행하려면 함수 안에 또 함수를 중첩해서 넣어야한다
 
 
 let success = true;
 let promise = new Promise(function(resolve, reject) { //프로미스 객체는 매개값으로 함수를 받는데 성공하면 첫번째 정의된 함수 res, 실패하면 두번째 정의된 rej 실행 
 	if(success) {
 	resolve('success'); //성공했을때 실행하는 함수를 정의
 	} else {
 	reject('error'); //실패했을때 실행하는 함수를 정의
 	}
 });
 
 promise.then(function(result) { //성공하면 실행하는 첫번째 정의된 함수 = resolve
 					console.log(result);
 				})
 				.then(function(result) {
 					console.log(result);
 				})
 				.then(function(result) { //promise : 약속을 한다. 함수안에 중첩해서 넣지 않고 이 순서대로 함수를 처리하겠다는 약속
 					console.log(result);
 				})
 				.catch(function(result) { //실패했을때 실행하는 두번째 정의된 함수 = reject
 					console.log(err);
 				});
 