package com.dev;

public class WhileExample2 {
	public static void main(String[] args) {
		// 1~10까지의 수 중에서 짝만 출력.
		//while문으로 작성.
		
		int num = 0;
		while (num <= 10) {
			num += 2;
			System.out.println(num);
		}
		
		int i = 1; //초기화
		while (i <= 10) { //조건식
			if (i%2 == 0) {
				System.out.println("i의 값 " + i);
			}
			i++; //증감식
		}
	}
}