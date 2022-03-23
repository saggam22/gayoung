package com.edu.collect;

import java.util.ArrayList;

public class ListExample {
	public static void main(String[] args) { 
		
		String[] strings = new String[10]; //배열은 크기가 고정
		
		for (int i = 0; i < strings.length; i++) {
			if (strings[i] == null ) {
				strings[i] = "hello";
				break;
			}
		}
		
		ArrayList<String> strAry = new ArrayList<String>(); //ArryList는 크기가 동적
		strAry.add("hello");
		strAry.add("world");
		
		strAry.get(1); //인덱스 1을 불러옴
		strAry.set(1, "월드"); //인덱스 1의 위치값을 수정
		strAry.remove(1); // 인덱스 1의 값을 삭제
		strAry.clear(); //전체 삭제 strAry.size() == 0 이 된다
		
		for (int i = 0; i < strAry.size(); i++) {
			String result = strAry.get(i);
			System.out.println(result);
		}
		
//		ArrayList<Integer> numAry = new ArrayList<Integer>();
//		for (int i = 0; i < numAry.size(); i++) {
//			int result = numAry.get(i); //Integer 대신 int를 사용하여도 된다 boxing과 unboxing을 자동으로 하므로
//		}
		
	}
}
