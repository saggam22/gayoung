package com.edu.abstracts;

public abstract class Animal { //abstract 추상

		private String name;
		
		public Animal() {
			System.out.println("Animal() 생성자 호출");
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
		
		//추상메소드 정의
		public abstract void eat(); //{} 구현되는 코드가 없음 == 선언되는 부분만 있음 / 상속받는 하위클래스가 기능을 구현해야한다
		
		public abstract void speak();
		
}
