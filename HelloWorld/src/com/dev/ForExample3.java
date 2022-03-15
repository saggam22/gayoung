package com.dev;

import java.util.Scanner;

public class ForExample3 {
	public static void main(String[] args) {
		//입력받는 두수 num1, num2
		//num1과 num2사이의 값을 더한 값을 구하시오
		
		Scanner scn = new Scanner(System.in);
		System.out.println("num1을 입력하시오");
		int num1 = scn.nextInt();
		
		System.out.println("num2를 입력하시오");
		int num2 = scn.nextInt();
		
		int sum = 0;
		for (int i = num1; i<=num2; i++) {
			sum += i;
		}
		System.out.println(num1 + "부터 " + num2 + "까지의 합: "+ sum);
	}
}
