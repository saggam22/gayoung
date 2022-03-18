package com.dev; //패키지는 실제로 폴더로 생성

public class SingletonExample {
	public static void main(String[] args) {
//		Singleton s1 = new Singleton();
//		Singleton s2 = new Singleton(); //생성자에 private로 막음
		
		Singleton s1 = Singleton.getInstance();
		Singleton s2 = Singleton.getInstance(); //출력시 메모리 주소가 같음. 외부에서 객체를 얻는 유일한 방법은 getInstance메소드를 호출해야함(단 하나의 객체만 리턴해서 주소값이 같음)
		
		System.out.println(s1);
		System.out.println(s2); //메모리 주소가 16진수로 서로 다르게 표기(새로운 인스턴스) 그러나 singleton사용시 둘의 주소가 같음 같은 메모리를 공유하게 되므로
	}
}
