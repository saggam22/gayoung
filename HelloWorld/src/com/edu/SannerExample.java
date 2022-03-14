package com.edu;

import java.util.Scanner;

public class SannerExample { //com.edu.ScannerExample이 fullname
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		System.out.println("첫번째 숫자를 입력하세요..");
		int val1 = scn.nextInt();
		System.out.println("두번째 숫자를 입력하세요..");
		int val2 = scn.nextInt();
		int sum = val1 + val2;
		
		System.out.println("두수의 합은 " + sum + "입니다.");
//		System.out.println("두수의 합은 " + 10+20 + "입니다."); 1020 출력 문자를 먼저 인식
//		System.out.println(10+20 + "두수의 합은 " + "입니다."); 30 출력 계산을 먼저 인식
//		System.out.println("두수의 합은 " + (10+20) + "입니다."); 30 출력 계산을 먼저 인식
		scn.close();
		
		if(sum % 2 == 0) {
			System.out.println("짝수입니다.");
		}
		if(sum % 2 == 1) {
			System.out.println("홀수입니다.");
		}
	}
}