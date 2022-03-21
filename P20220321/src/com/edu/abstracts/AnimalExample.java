package com.edu.abstracts;

public class AnimalExample {
	public static void main(String[] args) {
//		Animal animal = new Animal(); //추상클래스는 인스턴스를 생성(호출)할 수 없음 = 실체가 없으므로
		
		Animal animal = null;
		animal = new Dog();
		animal.setName("백구");
		animal.eat();
		animal.speak();
		
		animal = new Cat();
		animal.setName("나비");
		animal.eat();
		animal.speak();
	}
}
