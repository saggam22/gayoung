package com.dev;

import java.util.Scanner;

public class WhileExample3 {
	public static void main(String[] args) {
		//입력을 계속 ...
		// -1 값을 입력하면 멈춤
		// sum 값에 입력
		
		Scanner scn = new Scanner(System.in);
		
		int sum = 0;
		while(true) {
			System.out.println("숫자를 입력하세요");
			int inputVal = scn.nextInt();
			
			if(inputVal == -1) {
				break;
			}
			sum += inputVal;
		}
		System.out.println("입력한 값의 합은 : " + sum + "입니다.");
		scn.close();
	}
}
