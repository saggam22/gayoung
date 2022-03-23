package com.edu.collect;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetExample {
	public static void main(String[] args) {
		
		Set<String> set = new HashSet<String>(); //Set : 중복값은 허용x, 순서없이 저장 마치 집합과 비슷
		set.add("hello");
		set.add("world");
		set.add("Good");
		set.add("world"); //중복된 요소는 추가 불가
		
		set.remove("Good");
		
		System.out.println("set 크기 : " + set.size());
		
		Iterator<String> iter = set.iterator(); //반복자
		while (iter.hasNext()) { //hasNext 가져올 값이 있으면 boolean타입으로 true, 없으면 false을 반환
			String result = iter.next();
			System.out.println(result);
		}
		System.out.println("end of prog");
	}
}
