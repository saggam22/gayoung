package com.edu.collect;

import java.util.List;

public interface StudentService {

	public void insertStudent(Student student); //입력
	public Student getStudent(int sno); //학생 번호를 입력시 학생정보 뜨게
	public List<Student> studentList(); //전체목록
	public void modifyStudent(Student sudent); //한건 수정
	
}
