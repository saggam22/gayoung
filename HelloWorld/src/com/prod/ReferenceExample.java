package com.prod;

public class ReferenceExample {
	public static void main(String[] args) {
		//참조타입 vs 기본(데이터)타입
		int num1 = 10; //리터럴
		int num2 = 10; 
		//int, double, byte, short, long, float, char, boolean : 기본타입
		//String, Scanner 클래스타입 => 클래스타입은 대문자로 시작, 클래스는 참조타입에 속함
		
		System.out.println(num1);
		System.out.println(num2);
		System.out.println(num1 == num2); //실제 값을 변수에 저장하므로 true
		
		String str1 = new String("hello");
		String str2 = new String("hello");
		
		System.out.println(str1);
		System.out.println(str2);
		System.out.println(str1 == str2); //메모리 번지를 변수에 저장하므로 false
		//번지를 통해 객체를 참조한다 = 객체 타입, 번지는 16진수
		System.out.println(str1.equals(str2)); //참조타입의 값을 비교하고 싶을 때 사용하는 메소드
	}
}