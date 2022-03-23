package com.edu.collect;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapExample {
	public static void main(String[] args) {
		//Map : {key : value}, {key1 : value1}
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("전민욱", 80);
		map.put("김형민", 82);
		map.put("김영민", 85);
		map.put("김영민", 88);
		//컬렉션 : 여러값을 저장 => 여러요소 접근
		
		Integer val = map.get("김영민"); //key값을 지정해주면 value값을 반환, key값이 중복이 되면 안된다. 마지막 key값이 갖는 value값 반환
		System.out.println(val);
		
		Set<String> keySet = map.keySet(); //map컬렉션에 저장된 요소들의 키에 해당 값을 Set컬렉션에 담아줌
		
		Iterator<String> iter = keySet.iterator(); //반복자 : 내부요소를 순회하는 객체, 안의 항목들에 접근 할 수 있음
		
		while(iter.hasNext()) {
			String key = iter.next();
			Integer value = map.get(key);
			System.out.printf("key : %5s, value : %5d \n", key, value);
		}
		
		// 2) for( : ) 확장 for
		for(String key : keySet) { //keySet(컬렉션)값이 들어있는만큼 반복한다
			Integer value = map.get(key);
			System.out.printf("key : %5s, value : %5d \n", key, value);
		}
		
		System.out.println("end of prog");
	}
}
