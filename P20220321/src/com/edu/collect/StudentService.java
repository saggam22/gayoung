package com.edu.collect;

import java.util.List;

public interface StudentService {  //추상메소드 정의(선언)을 해놨으니 다른 클래스에서 구현을 해주어야함

	public void insertStudent(Student student); //입력
	public Student getStudent(int sno); //학생 번호를 입력시 학생정보 뜨게
	public List<Student> studentList(); //전체목록
	public void modifyStudent(Student sudent); //한건 수정
	public void removeStudent(int sno); //한건 삭제
	public List<Student> searchStudent(String name); //이름조회
	public void saveToFile();
}
