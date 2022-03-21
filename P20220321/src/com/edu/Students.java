package com.edu;

public class Students extends Person{ //Person 클래스가 가지고 있는 속성을 상속하겠다 Person은 부모클래스 Students는 자식클래스
	//이름 나이 키 몸무게(공통) 학교 학년
	private String school;
	private int grade;
	
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	
}
