package com.dev;

import java.util.Scanner; //범용적으로 자바에서 구현해놓은 클래스

import com.edu.Student; //우리가 구현해놓은 클래스

public class ObjectExample {
	public static void main(String[] args) {
//		Student s1 = new Student();
//		s1.setStudNo(100); //default 일 경우 다른 패키지에서 사용 불가
//		s1.setStudName("김냥냥"); //public은 사용 가능

		Scanner scn = new Scanner(System.in); // 범용적으로 자바에서 구현해놓은 인스턴스
//		scn.nextInt(); //범용적으로 자바에서 구현해놓은 메소드

		Student s1 = new Student(100, "이가영"); // studNo = 100
		System.out.println(s1.getStudName());
		System.out.println(s1.getStudName());
		s1.setKorScore(100);
		s1.setEngScore(60); // set메소드 값을 지정
		s1.setMathScore(80);

		Student s2 = new Student(101, "이혜린", 80, 82, 85); // 생성자를 설정해둬서 매개값만 입력 가능
		// = 생성자를 통해서 필드값을 지정할수있음
		System.out.printf(s2.getStudName() + "의 평균: %.2f", s2.getAvgScore());
		System.out.println();

		Student s3 = new Student(102, "서현일", 70, 80, 90);
		Student s4 = new Student(102, "최규환", 77, 82, 83);

		Student[] students = { s1, s2, s3, s4 };

		while (true) {
			System.out.println("조회하려고 하는 학생의 이름(ex.홍길동) : ");
			String searchName = scn.next();
			if (searchName.equals("종료")) {
				break;
			}

			for (int i = 0; i < students.length; i++) {
				if (students[i].getStudName().equals(searchName)) {
					System.out.println(students[i].getStudInfo());
				}
			}
		}
		System.out.println("end of program");
	}
}
