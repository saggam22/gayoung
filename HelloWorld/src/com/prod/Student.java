package com.prod;

public class Student {
	//필드(field)
	String studentNo;
	String studentName;
	int korScore;
	int engScore;
	
	//메소드
	void study(String subject) { //매개변수 => 매개변수가 있는 메소드 선언
		System.out.println(subject + "(을)를 합니다.");
	}
	
	void eat(String food) { //아무값도 반환받고 싶지않을 때(리턴값이 없는) void 메소드 선언
		System.out.println(food + "을 먹습니다.");
	}
	
	int getKorScore() {
		return korScore;
	}
	
	int getEngScore() {
		return engScore;
	}
}