package com.dev;

import java.util.Scanner;

public class Work2 {
	public static void main(String[] args) {
		//3가지 값을 입력받도록 한 후 작은수부터 큰수로 정렬하는 프로그램
		
		Scanner scn = new Scanner(System.in);
		
		System.out.println("첫 번째 수를 입력하세요");
		int num1 = scn.nextInt();
		System.out.println("두 번째 수를 입력하세요");
		int num2 = scn.nextInt();
		System.out.println("세 번째 수를 입력하세요");
		int num3 = scn.nextInt();
		
		if (num1 <= num2) {
			if (num2 <= num3) {
				System.out.println(num1 + " , " + num2 + " , "  + num3);
			} else if (num3 <= num1){
				System.out.println(num3 + " , " + num1 + " , "  + num2);
			} else {
				System.out.println(num1 + " , " + num3 + " , "  + num2);
			}
		} else {
			if (num1 <= num3) {
				System.out.println(num2 + " , " + num1 + " , "  + num3);
			} else if (num3 <= num2) {
				System.out.println(num3 + " , " + num2 + " , "  + num1);
			} else {
				System.out.println(num2 + " , " + num3 + " , "  + num1);
			}
		}
		scn.close();
	}
}
