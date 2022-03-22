package com.edu.nested;

public class Outer {
	private String field1;
	private int field2;
	
	class Inner { //클래스 안에 또 다른 클래스를 선언(클래스의 멤버로서 선언되므로 멤버클래스)
		String field3;
		int field4;
		
		void method2() {
			System.out.println("Inner.method2()");
		}
	}
	//함수적 인터페이스 : 구현해야할 메소드가 하나인 것
	interface Runnable {
		void run();
	}
	
	class Bus implements Runnable {

		@Override
		public void run() {
			System.out.println("Bus가 달립니다.");
			
		}
		
	}
	
	public String getField1() {
		return field1;
	}
	
	public void method1() {
		System.out.println("Outer.method1()");
		Inner inner = new Inner();
		inner.method2();
	}
	
	public void method3() {
		System.out.println("Outer.method3()");

		class Local { //로컬틀래스 : 생성자 또는 메소드 내부에서 선언되는 중첩클래스
			
			void method4() {
				System.out.println("Local.method4()");
			}
		}
		Local local = new Local();
		local.method4();
	}
	
	public void method4() {
		Runnable runnable = new Bus(); //인터페이스의 구현객체 가능 
		runnable.run();
		
		//익명구현객체 : 메소드 안에서만 구현할 수 있음
		//runnable = () -> syso~ 기능을 한번만 쓸수있다.
//		runnable = new Runnable() {

//			@Override
//			public void run() {  //추상메서드를 재구현
//				System.out.println("임의의 객체를 실행합니다.");
//			} 을 줄여서 람다표현식(Lambda)으로 나타낼 수 있음
			runnable = () -> System.out.println("임의의 객체를 실행합니다."); //function
			
//		};
		runnable.run();
	}

}
