package com.dev;

import java.util.Scanner;

public class IfExample3 {
	public static void main(String[] args) {
		int ranVal = (int)(Math.random() *3)+1; //Math.random함수는 0~1사이에 임의의 값을 만들어줌
		
		Scanner scn = new Scanner(System.in);
		
		System.out.println("1~3까지의 숫자를 입력하세요");
		int input = scn.nextInt();
		
		if(input==ranVal) {
			System.out.println("정답입니다.");
		} else {
			System.out.println("틀렸습니다.");
		}
		
		System.out.println((input==ranVal) ? "정답" : "틀림"); //삼항연산자 출력내용 설정
		
		String result = (ranVal == input) ? "정답" : "틀림";  //삼항연산자 변수 설정
		System.out.println(result);

		scn.close();
	}
}
