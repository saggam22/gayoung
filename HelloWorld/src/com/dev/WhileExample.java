package com.dev;

import java.util.Scanner;

public class WhileExample {
	public static void main(String[] args) {
		//for문 : 정해진 횟수만큼 만복
		for(int i = 1; i <= 5; i++) {
			System.out.println("i의 값 =>" + i);
		}
		
		//while문 : 조건식이 참일 경우 반복
		int i = 1; //초기화
		while(i <= 5) { //조건식
			System.out.println("i의 값=> " + i);
			i++; //증감식
		}
		//while
		int num = 0;
		while(true) {
			System.out.println("num의 값=> " + num);
			num++;
			if(num>5) {
				break; // 반복문을 빠져나옴
			}
		}
		
		//while
		while(true) {
			int rand = (int)(Math.random()*10)+1;
			System.out.println("임의의 생성된 값 : " + rand);
			if (rand == 8) {
				break;
			}
		}
		
		// 숫자를 맞출때까지 계속 반복
		Scanner scn = new Scanner(System.in);
		int randomVal, userVal;
		while(true) {
			randomVal = (int)(Math.random()*5)+1;
			System.out.println("임의의 값을 입력하세요(1~5)");
			userVal = scn.nextInt();
			if (randomVal == userVal) {
				System.out.println("생성된 임의의 값과 같습니다.");
				break;
			}
		}
		scn.close();
		System.out.println("end of prog");
	}
}
