package com.edu.stream;

import java.util.ArrayList;
import java.util.List;

public class StreamExample2 {
	public static void main(String[] args) {
		List<Student> list = new ArrayList<Student>();
		list.add(new Student("홍길동", "남자", 70, 100));
		list.add(new Student("김순희", "여자", 80, 120));
		list.add(new Student("김부식", "남자", 85, 95));
		list.add(new Student("박한나", "여자", 88, 99));

		list //컬렉션으로 부터
		.stream() //스트림 생성
		.filter(student -> student.score >= 80) //80점 이상인 대상을 필터
		.filter(student -> student.gender.equals("여자"))  //여자를 필터
		.forEach(student -> System.out.println(student)); //필터링된 대상을 출력
		
		System.out.println("------------------------------------------");
		
		//남자, 여자 스코어 + 포인트 > 180점 이상인 학생들만 오름차순으로 출력
		list.stream()
		.filter(student -> (student.score + student.point) >=180)
		.sorted() //list는 크고 작은 개념이 없기에 순서값으로 구현하려면 comparable(=비교할만한) 인터페이스를 구현하는 클래스 메소드를 이용해야한다.
		.forEach(student -> System.out.println(student));
	}
}
