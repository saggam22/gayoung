package com.edu.collect;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentApp {

	List<Student> list = new ArrayList<Student>();
	Scanner scn = new Scanner(System.in);

	// 멤버클래스
	class StudentServiceImpl implements StudentService {

		@Override
		public void insertStudent(Student student) {
			list.add(student); // 추가
		}

		@Override
		public Student getStudent(int sno) { // 학생번호로 한 건 조회
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).getNumber() == sno) {
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

	} // end of StudentServiceImpl()

	public void execute() {
		// 메뉴 1.추가 2.리스트 3.한건조회 4.수정 9.종료
		while (true) {
			System.out.println("메뉴>> 1.추가 2.리스트 3.한건조회 4.수정 9.종료");
			System.out.print("선택>> ");

			int menu = scn.nextInt();
			
			StudentServiceImpl impl = new StudentServiceImpl();
			
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
				
				impl.insertStudent(s1);
				
			} else if (menu == 2) {
				System.out.println(impl.studentList());
			} else if (menu == 3) {
				System.out.println("조회할 학생번호>> ");
				int num = scn.nextInt();
				System.out.println(impl.getStudent(num));
			} else if (menu == 4) {
				System.out.print("학생번호를 입력하세요> ");
				int num = scn.nextInt();
				System.out.print("학생이름을 입력하세요> ");
				String name = scn.next();
				System.out.print("수정할 영어점수를 입력하세요> ");
				int eng = scn.nextInt();
				System.out.print("수정할 국어점수을 입력하세요> ");
				int kor = scn.nextInt();
				
				Student s1 = new Student(num, name, eng, kor);
				
				impl.modifyStudent(s1);
			} else if (menu == 9) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}
		} // end of while()
		System.out.println("end of prog");
	}
}
