package com.edu.lambda;

interface Runnable {
	public void run(); //매개변수 값 없음
}
class RunImpl implements Runnable {

	@Override
	public void run() {
		System.out.println("run...");
	}
	
}
public class RunExample {
	public static void main(String[] args) {
		//람다표현식 (String s) -> {구현코드}; 클래스를 구현하지 않고도 인터페이스를 구현하는 익명의 객체에서 구현해야할 메소드가 하나일때 사용
		
		Runnable runnable = new RunImpl();  //인스턴스 생성
		runnable.run();
		
		
		runnable = new Runnable() { //인터페이스는 new를 이용해 인스턴스 객체를 만들 수 없으나 익명의 객체를 만들겠다는 뜻(메소드를 다르게 구현하고 싶은데 그때마다 클래스를 선언하지 않으려고)

			@Override
			public void run() {
				System.out.println("호랑이가 달립니다.");
			} 
		}; //익명구현 객체는 ; 표시 필요
		runnable.run();
		
		//람다표현식으로 나타냄
//		          (매개변수를 받아서) ->  {코드를 실행시킨다}
		runnable = () -> {System.out.println("사자가 달립니다."); };
		runnable.run();
	}
}
