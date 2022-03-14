package com.edu;

public class Variables {
	public static void main(String[] args) {
//		변수 : 메모리공간 이름 지정 값을 할당.
		int age = 20; // 20 == 30 같은 값을 나타낼때는 ==
		System.out.println("age변수: " + age);
		int num1 = 30;
		int num2 = 50;
		int result = num1 + num2;
		System.out.println(num1 + " + " + num2 + " = " + result);
		System.out.println("20 + 10 = 30");
		
		String name = "홍길동"; //string 문자열을 나타냄, 변수 선언은 1번만 하면된다 
		name = "최민규";
		System.out.println(name + "의 나이는 " + age + "입니다.");
		
		final String myName = "이가영"; //final을 붙이면 변수는 상수(Constance)가 되어 바꿀수 없다.
//		myName = "최가영";
		
		// 전화번호, 이메일 값을 담을 수 있는 변수.
		String phone = "010-2509-6382";
		String email = "saggm92@icloud.com";
		System.out.println(myName + "의 전화번호는 " + phone + "이고, " + "이메일은 " + email + "입니다.");
	}
}
