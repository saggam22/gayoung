package com.edu.except;

import java.util.Calendar;
import java.util.Scanner;

//class String2 extends String{
//	public final String{} 더 이상 상속불가능한 클래스
//}

public class ExceptionExample2 {
	public static void main(String[] args) {

		// Object 가장 상위에 존재하는 프로젝트
		Object obj = new String();
		obj = new Scanner(System.in);
		obj = Calendar.getInstance();
		
		obj = new Object();
		System.out.println("obj의 해시코드: " + obj.hashCode());

		
		// Exception : 아예 실행이 되지 않고 오류를 알려줌
		try {
			Class.forName("java.lang.String");
		} catch (ClassNotFoundException e1) {
//			e1.printStackTrace();
			System.out.println("해당 클래스가 존재하지 않습니다.");
		}

		
		// RuntimeException 런타임시 알게되는 구문(예측불가능)
		String str = null;
		str.charAt(0); // CharSequence interface의 추상메소드
		try {
			System.out.println(str.toString());
		} catch (NullPointerException e) {
			System.out.println("널포인트 예외발생");
			e.printStackTrace();
		}

		String nums1 = "백"; // 숫자 문자열
		String nums2 = "100"; // 숫자 문자열
		int num1, num2;
		try {
			num1 = Integer.parseInt(nums1); // int 변환
			num2 = Integer.parseInt(nums2); // int 변환

			str.charAt(0);
		} catch (Exception e) {
			num1 = 0;
			num2 = 0;

			System.out.println("상위의 예외발생...");

		}
		System.out.println(num1 + "" + " " + num2 + "=" + (num1 + num2));
		
		try {
		showError();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("end of prog");
	} //end of main()
	
	public static void showError() throws ClassNotFoundException{ //사용한 곳에서 예외처리
		Class.forName("java.lang.Strings");
		
//		try {
//			Class.forName("java.lang.Strings");
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//			System.out.println("예외발생");
//		}
	}
	
} //end of class
