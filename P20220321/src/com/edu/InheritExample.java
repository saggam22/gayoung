package com.edu;

public class InheritExample {
	//학생, 직장인, 친구 => 정보를 담아 놓는 정보
	//학생은 학교, 학년
	//직장명, 직급
	//출신지역
	
	public static void main(String[] args) {
		Students student = new Students();
		student.setName("홍길동");
		student.setAge(15);
		student.setSchool("중앙고");
		student.setGrade(2);
		
		Worker worker = new Worker();
		worker.setName("직장인");
		worker.setAge(35);
		worker.setCompany("카카오");
		worker.setJob("캐발팀장");
		
		//부모 클래스의 참조변수에 자식 클래스의 참조변수 자동형 변환(promotion)
		Person p1 = new Person();
		p1 = student; //자식클래스 변수가 부모 클래스 변수에 대입가능
		p1 = worker;
		
//		student = worker; //자식과 자식간에는 promotion 안됌
	}
}
