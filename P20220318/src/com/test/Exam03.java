package com.test;

import java.util.Scanner;

//문제3) 정수형배열 선언하고 사용자로 세개의 정수값을 입력받아서 배열에 저장. 제일 큰값을 구하는 코드를 작성.
public class Exam03 {
	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		
		int[] numbers = new int[3];
		
		System.out.println("첫번째수를 입력하세요");
		numbers[0] = scn.nextInt();
		System.out.println("두번째 수를 입력하세요");
		numbers[1] = scn.nextInt();
		System.out.println("세번째 수를 입력하세요");
		numbers[2] = scn.nextInt();
		
		if (numbers[0] <= numbers[1]) {
			if (numbers[1] <= numbers[2]) {
				System.out.println("가장 큰 수 : " + numbers[2]);
			} else {
				System.out.println("가장 큰 수 : " + numbers[1]);
			}
		} else {
			if (numbers[0] >= numbers[2]) {
				System.out.println("가장 큰 수 : " + numbers[0]);
			} else {
				System.out.println("가장 큰 수 : " + numbers[2]);
			}
		}
		scn.close();
	}
}
