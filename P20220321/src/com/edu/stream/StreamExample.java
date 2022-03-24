package com.edu.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Stream;

class Student implements Comparable<Student> { // comparable 인터페이스가 가지는 추상메소드 추가시 크고 작음을 구분지어 줄 수 있음
	// 필드
	String name;
	String gender;
	int score;
	int point;

	// 생성자
	public Student(String name, String gender, int score) {
		super();
		this.name = name;
		this.gender = gender;
		this.score = score;
	}

	public Student(String name, String gender, int score, int point) {
		super();
		this.name = name;
		this.gender = gender;
		this.score = score;
		this.point = point;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", gender=" + gender + ", score=" + score + ", point=" + point + "]";
	}

	@Override
	public int compareTo(Student student) {
		// this 와 student 비교: this, student => 음수 : 오름차순 / 양수 : 내림차순
//		if (this.score < student.score) {
//			return -1;
//		} else {
//			return 1;
//		}
		return (this.score + this.point) - (student.score + student.point); // 또는 이렇게 표현도 가능 60, 70 => 음수가 나오므로 오름차순으로 정렬하겠다
	}

}

public class StreamExample {
	public static void main(String[] args) {

		List<Student> list = new ArrayList<Student>();
		list.add(new Student("홍길동", "남자", 70));
		list.add(new Student("김순희", "여자", 80));
		list.add(new Student("김부식", "남자", 85));
		list.add(new Student("박한나", "여자", 88));

		// 스트림 생성(스트림은 데이터의 흐름을 나타냄, 컬렉션을 바로 사용할 수 없으므로 스트림을 생성해서 활용 -> 배열과 컬렉션을 함수형으로 처리할 수 있음)
		Stream<Student> stream = list.stream();
//		stream.forEach(new Consumer<Student>() { // 스트림에 속해있는 각각의(forEach) 데이터에 대해서 기능을 수행하고 Consumer 타입으로 받음(매개변수만 있고 리턴값이 없음) / 인터페이스를 통해 매개변수로 넣고 메소드 실행
//
//			@Override
//			public void accept(Student t) {
//				System.out.println("이름 : " + t.name + "성별 : " + t.gender + "점수 : " + t.score); //
//			}
//		});

		// 람다식 표현
//		stream.forEach((Student t) -> { System.out.println("이름 : " + t.name + "성별 : " + t.gender + "점수 : " + t.score);});

		// stream을 사용하지 않고 평균을 구한다고 하면..
		int sum = 0, cnt = 0;
		double avg = 0;
		for (Student student : list) {
			if (student.gender.equals("남자")) {
				sum += student.score;
				cnt++;
			}
		}
		avg = sum / (double) cnt;
		System.out.println("컬렉션평균 : " + avg);

		// stream을 사용하여 평균을 구하면..
		OptionalDouble od = stream.filter((s) -> s.gender.equals("남자")).mapToInt(s -> s.score).average(); // 스트림은 메소드 중첩이 가능																			
		avg = od.getAsDouble();
		System.out.println("스트림평균 : " + avg);

	}
}
