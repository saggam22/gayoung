package com.dev;

import java.util.Scanner;

public class ForExample5 {
	public static void main(String[] args) {
		//최대공약수 구하기
		Scanner scn = new Scanner(System.in);
		
		System.out.println("첫번째 수를 입력하시오");
		int num1 = scn.nextInt();
		System.out.println("두번째 수를 입력하시오");
		int num2 = scn.nextInt();
		
		int max = 0;
		
		for (int i=1, j=1; i<=num1 && j<=num2; i++,j++) {
			if(num1%i == 0 && num2%j == 0) {
				max = i;
			}
		}
		System.out.println("두수의 최대공약수는" + max);
		scn.close();
	}
}
