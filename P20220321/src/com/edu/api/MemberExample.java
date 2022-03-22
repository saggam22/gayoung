package com.edu.api;

import java.util.ArrayList;
import java.util.HashSet;

public class MemberExample {

	public static void main(String[] args) {
		Member obj1 = new Member("blue", "홍길동");
		Member obj2 = new Member("blue", "홍길동");
		Member obj3 = new Member("red", "박길동");
		
		
		
		//배열은 한번 크기가 정해지면 추가로 크기를 확장시키려면 새로운 배열을 선언한 후 복사해야함
		//배열 -> 컬렉션(ArrayList, HashSet, HashMap) :여러개의 값을 저장, 자동적으로 확장
		ArrayList<Member> memList = new ArrayList<Member>(); 
		memList.add(new Member("yellow", "이길동"));
		memList.add(new Member("yellow", "이길동"));
		for (int i = 0; i < memList.size(); i++) {  //.legth가 아닌 .size 이고, !=null을 조건으로 걸어주지 않아도된다.
			System.out.println(memList.get(i));
		}
		
		
		
		HashSet<Member> memSet = new HashSet<Member>(); //같은 값이면 중복으로 보고 저장을 하지 않음
		memSet.add(new Member("yellow", "이길동")); //논리적으로 같은 객체임을 판단하는 기준은 hashCode(), equals()
		memSet.add(new Member("yellow", "이길동"));
		System.out.println(memSet.size());
		
		
		
		if(obj1 == obj2) { //주소값을 비교하기 때문에 무조건 false
			System.out.println("obj1와 obj2는 동등합니다.");
		} else {
			System.out.println("obj1와 obj2는 동등하지 않습니다.");
		}
		
		
		//equals메소드
		if(obj1.equals(obj2)) {
			System.out.println("obj1와 obj2는 동등합니다.");
		} else {
			System.out.println("obj1와 obj2는 동등하지 않습니다.");
		}
		
		
		if(obj1.equals(obj3)) {
			System.out.println("obj1와 obj3는 동등합니다.");
		} else {
			System.out.println("obj1와 obj3는 동등하지 않습니다.");
		}
	}
}
