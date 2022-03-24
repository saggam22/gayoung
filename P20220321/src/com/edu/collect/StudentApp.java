package com.edu.collect;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentApp {

	List<Student> list = new ArrayList<Student>();
	Scanner scn = new Scanner(System.in);

	// 생성자
	public StudentApp() {
		list.add(new Student(101, "권가희", 50, 60));
		list.add(new Student(102, "유혜정", 70, 60));
		list.add(new Student(103, "이유빈", 90, 70));
	}

	// 멤버클래스
	class StudentServiceImpl implements StudentService {

		@Override
		public void insertStudent(Student student) {
			list.add(student); // 추가
		}

		@Override
		public Student getStudent(int sno) { // 학생번호로 한 건 조회
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).getNumber() == sno) { // 찾으면 종료
					return list.get(i);
				}
			}
			return null;
		}

		@Override
		public List<Student> studentList() { // 전체 학생 정보보 조회
			return list;
		}

		@Override
		public void modifyStudent(Student student) { // 수정
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).getNumber() == student.getNumber()) {
					list.get(i).setEngScore(student.getEngScore());
					list.get(i).setKorScore(student.getKorScore());
				}
			}
		}

		@Override
		public void removeStudent(int sno) { // 삭제
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).getNumber() == sno) {
					list.remove(i);
				}
			}
		}

		@Override
		public List<Student> searchStudent(String name) { // 이름이 같은 사람 확인
			List<Student> searchList = new ArrayList<Student>();
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).getName().equals(name)) { 	// String 타입은 equals써서 비교
					searchList.add(list.get(i));			// 찾았을때 종료하면 안되고 리스트에 추가 add하고 return값을 for문 밖에
				}
			}
			return searchList;
		}

	} // end of StudentServiceImpl()

	public void execute() {
		// 메뉴 1.추가 2.리스트 3.한건조회 4.수정 9.종료

		StudentService service = new StudentServiceImpl(); // 인터페이스에 담아 주면 추후 구현객체만 바꿔주면 된다
		// 클래스로 선언하면 list를 클래스마다 구현해야하지만 인터페이스에 담아두면 구현객체를 바꿨을때 나머지 기능 다 사용가능

		while (true) {
			System.out.println("메뉴>> 1.추가 2.리스트 3.한건조회 4.수정 5.삭제 6.이름 조회 9.종료");
			System.out.print("선택>> ");

			int menu = scn.nextInt();

			if (menu == 1) {
				System.out.print("학생번호를 입력하세요> ");
				int num = scn.nextInt();
				System.out.print("학생이름을 입력하세요> ");
				String name = scn.next();
				System.out.print("영어점수를 입력하세요> ");
				int eng = scn.nextInt();
				System.out.print("국어점수을 입력하세요> ");
				int kor = scn.nextInt();

				Student s1 = new Student(num, name, eng, kor);

				service.insertStudent(s1);

			} else if (menu == 2) {
				List<Student> list = service.studentList(); // 호출부분과 같은 값을 받아야하므로 list를 선언하면 목록을 조회(건별당 나옴)
				for (Student s : list) {
					System.out.println(s.toString());
				}
//				System.out.println(service.studentList()); //list 컬렉션에 의해 정의된 내용이 나오는 것(줄글로 나옴)

			} else if (menu == 3) {
				System.out.println("조회할 학생번호>> ");
				int num = scn.nextInt();
				Student student = service.getStudent(num);
				if (student == null) {
					System.out.println("조회된 결과가 없습니다.");
				} else {
					System.out.println(student.toString());
				}

			} else if (menu == 4) {
				System.out.print("수정할 학생번호를 입력하세요> ");
				int num = scn.nextInt();
				System.out.print("영어점수를 입력하세요> ");
				int eng = scn.nextInt();
				System.out.print("국어점수을 입력하세요> ");
				int kor = scn.nextInt();

				Student s1 = new Student(num, null, eng, kor);

				service.modifyStudent(s1);

			} else if (menu == 5) {
				System.out.print("삭제할 학생번호를 입력하세요> ");
				int num = scn.nextInt();
				if (service.getStudent(num) == null) {
					System.out.println("조회된 결과가 없습니다.");
				} else {
					service.removeStudent(num);
					System.out.println("정상적으로 처리됐습니다.");
				}

			} else if (menu == 6) {
				System.out.print("조회할 학생이름을 입력하세요> ");
				String name = scn.next();
				List<Student> list = service.searchStudent(name);
				if (list.size() == 0) {  //list가 없는지 보려면 size로 비교할 것!!
					System.out.println("조회된 결과가 없습니다.");
				} else {
					for (Student s : list) {
						System.out.println(s.toString());
					}
				}

			} else if (menu == 9) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}
		} // end of while()
		System.out.println("end of prog");
	}
}
