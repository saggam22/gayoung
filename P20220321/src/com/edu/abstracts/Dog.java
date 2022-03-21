package com.edu.abstracts;

public class Dog extends Animal {
	
	public Dog() {
//		super();  //주석처리를 했음에도 부모클래스값도 호출
		System.out.println("Dog() 생성자 호출");
	}
	
	public void eat() {
		System.out.println("멍멍이가 먹습니다.");
	}
	
	public void speak() {
		System.out.println("멍멍멍");
	}
	
}
