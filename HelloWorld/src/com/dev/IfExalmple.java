package com.dev;

public class IfExalmple { //클래스이름은 WhichExample처럼 camel case(낙타등처럼 시작은 대문자, 두단어 연결시 연결문자 대문자)
	public static void main(String[] args) {
		//조건문 if 
		//60점 이상이면 Pass
		int score = 75;
		if(score>60) {
			System.out.println("Pass입니다.");
		} else {
			System.out.println("Fail입니다.");
		}
		// 90점 이상이면 A, 80점 이상 B, 70이상 C, 60이상 D, 그외 F
		if(score>=90) {
			if(score>=95) {
				System.out.println("A+입니다.");
			} else {
				System.out.println("A입니다.");
			}
		} else if(score>=80) {
			if(score>=85) {
				System.out.println("B+입니다.");
			} else {
				System.out.println("B입니다.");
			}
		} else if(score>=70) {
			if(score>=75) {
				System.out.println("C+입니다.");
			} else {
				System.out.println("C입니다.");
			}
		} else if(score>=60) {
			if(score>=65) {
				System.out.println("D+입니다.");
			} else {
				System.out.println("D입니다.");
			}
		} else {
			System.out.println("F입니다.");
		}
		System.out.println("end of Program");
	}
}
