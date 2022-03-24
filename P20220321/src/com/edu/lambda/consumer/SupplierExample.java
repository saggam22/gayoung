package com.edu.lambda.consumer;

import java.util.function.IntSupplier;

public class SupplierExample {
	public static void main(String[] args) {
		
		//Supplier 인터페이스 : 매개값이 없고 반환값이 있음
		
		//1)원래식
//		IntSupplier intSup = new IntSupplier() {
//
//			@Override
//			public int getAsInt() {
//				return (int)(Math.random()*10);
//			}
//		};
		
		
		//2)람다식 표현
		IntSupplier intSup = () -> (int)(Math.random()*10);  //return구문에 return도 생략가능
		
		int result = intSup.getAsInt();
		System.out.println("결과값은 " + result);
	}
}
