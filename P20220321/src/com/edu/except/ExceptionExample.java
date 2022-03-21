package com.edu.except;

import java.util.InputMismatchException;

import java.util.Scanner;

public class ExceptionExample {
	public static void main(String[] args) {
		//오류 : Error, Exception
		//compile error, runtime error(실행시점에 에러가 난지 확인 가능);
		//예외 처리하기 try-catch
		try {
			double result = 13/0;
			System.out.println("결과 : " + result);
		} catch (ArithmeticException e) {
//			e.printStackTrace();
			System.out.println("0으로 나눌 수 없습니다.");
		}
		
		Scanner scn = new Scanner(System.in);
		System.out.println("숫자를 입력하세요...");
		try {
			int menu = scn.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("숫자를 입력하지 않으셨네요..");
		}
		scn.close();
		System.out.println("end of prog");
	}
}
