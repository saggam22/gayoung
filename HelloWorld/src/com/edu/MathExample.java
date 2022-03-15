package com.edu;

import java.util.Scanner;

public class MathExample {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int num1, num2;
		
		System.out.println("첫 번째 수를 입력하세요");
		num1 = scn.nextInt();
		
		System.out.println("두 번째 수를 입력하세요");
		num2 = scn.nextInt();
		
		System.out.println("두 수의 합 : " + (num1+num2));
		System.out.println("두 수의 차 : " + (num1-num2));
		System.out.println("두 수의 곱 : " + num1*num2);
		System.out.println("두 수의 몫 : " + num1/num2);
		System.out.println("두 수의 나머지 : " + num1%num2);
		
		var num3 = 10; //값에 따라 자동으로 변수를 선언해줌, 그러나 어떤 오류를 일으킬지 모르니 사용은 지양
		
		scn.close();
	}
}
