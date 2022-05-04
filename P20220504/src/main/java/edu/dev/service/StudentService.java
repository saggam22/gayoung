package edu.dev.service;

import java.util.List;

import edu.dev.vo.StudentVO;

public interface StudentService {

		//전체 조회
		public List<StudentVO> studentList();
		//학생 이름 검색
		public List<StudentVO> searchName(String name);
		//학번 검색
		public StudentVO searchNo(int number);
		//학생 삭제
		public void delStudent(int number);
		//학생 정보 수정
		public void updateStudent(StudentVO student);
		//학생 정보 입력
		public void insertStudent(StudentVO student);
		
}
