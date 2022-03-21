package com.edu;

public class UnivFriend extends Friend {
//학교이름, 전공
	private String university; 
	private String major;
	
	public UnivFriend() { //Uni~ 클래스의 기본 생성자 호출
		super(); //Friend 클래스의 기본생성자를 호출하겠다.
		// TODO Auto-generated constructor stub
	}
	
	public UnivFriend(String name, int age, double height, double weight, String phone) {
		super(name, age, height, weight, phone); //Friend(n,a,h,w,p) 생성자 호출
		// TODO Auto-generated constructor stub
	}
	
	public UnivFriend(String name, int age, double height, double weight, String phone, String unuiversity, String major) {
		super(name, age, height, weight, phone); //Friend(n,a,h,w,p) 생성자와 본인 클래스의 초기화 생성자 호출
		this.university = university;
		this.major = major;
		// TODO Auto-generated constructor stub
	}
	
	public String getUniversity() {
		return university;
	}
	public void setUniversity(String university) {
		this.university = university;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	
	@Override
	public String toString() {
		String str = "친구의 이름은 " + super.getName() + "이고 \n";
		str += "나이는 " + super.getAge() + "이고 \n";
		str += "연락처는 " + this.getPhone() + "입니다. \n";
		str += "=========<추가정보>=========\n";
		str += "학교이름은 " + this.getUniversity() + "이고 \n";
		str += "전공은 " + this.getMajor() + "입니다 \n";
		return str;
	} 	
}
