package com.prod;

public class StudentExample {
	public static void main(String[] args) {
		Student s1 = new Student(); //필드 초기화
		s1.studentName = "홍길동";
		s1.korScore = 80;
		s1.engScore = 85;
		
		//메소드 호출
		s1.study("수학"); //매개값 => 객체 외부에서 매개값을 주고 매소드 호출 
		s1.eat("급식");
		s1.eat("간식");
		s1.eat("초콜렛");
		
		int v1 = s1.getKorScore();
		int v2 = s1.getEngScore();
		
		System.out.println( "국어점수 : " + v1 + " , 영어점수 : " + v2 );
	}
	
	
}
