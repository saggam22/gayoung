package com.edu.lambda;

interface Runnalbe4 {
	public int run(); //매개변수 없고
}

public class RunExample4 {
	public static void main(String[] args) {
		Runnalbe4 runnable = () -> {
			return (int) (Math.random()*10);  //반환값이 있을 경우
		};
		int result = runnable.run();
		System.out.println(result);
		
		//함수적 프로그램 작성
		runnable = () -> {
			return (int) (Math.random()*100); //변수에 다른 '기능'을 담을 수 있음
		};
		result = runnable.run();
		System.out.println(result);
	}
}
