package com.edu.lambda.consumer;

//import java.util.function.BiConsumer;
//import java.util.function.Consumer;  //하나나하 import

import java.util.function.*; //전체 import

public class ConsumerExample {
	public static void main(String[] args) {
		
		//functional interface (함수적 인터페이스) 중 consumer(= 매개변수만 있고 리턴값은 없음) : 람다표현식 가능
		
		//1)원래 모양
//		Consumer<String> consumer = new Consumer<String>() {
//			@Override
//			public void accept(String t) {
//			}
//		};
		
		//2)람다 표현식
		Consumer<String> consumer = (t) -> {   //consumer 라는 변수안에 기능을 담는다!
			System.out.println(t + "출력합니다.");
		};
		consumer.accept("메세지를 ");
		
		
		//3)매개변수가 2개
		BiConsumer<Integer, Integer> biCon = (t, u) -> {
				System.out.println("result => " + (t + u));
		};
		biCon.accept(20, 40);
	}
}
