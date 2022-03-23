package com.edu.generic;

import java.util.ArrayList;

public class BoxExample {
	public static void main(String[] args) {
//		Box box = new Box();
//		box.setObj("hello");
//		String result = (String) box.getObj(); //String -> 오브젝트 타입이므로 캐스팅 String
//		System.out.println(result);
//		
//		Integer result1 = (Integer) box.getObj(); //String -> Integer 오류
//		System.out.println(result);
		
		Box<String> stringBox = new Box<String>();
		stringBox.setObj("hello");
		stringBox.getObj();
		
		Box<Integer> intBox = new Box<Integer>();
		intBox.setObj(100); //int타입을 담아놨기에 String 타입은 올 수 없음
		Integer result1 = intBox.getObj();
		
		ArrayList<Integer> intAry = new ArrayList<Integer>(); //String타입만 담을 수 있도록 명확하게 알려줌
	}
}
