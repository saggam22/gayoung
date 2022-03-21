package com.edu;

public class Friend extends Person {
	//이름 나이 키 몸무게(공통) 연락처 -> 회사친구 : 회사이름, 업무 / 학교친구 : 학교이름, 전공
	private String phone;
	
	public Friend() {
		
	} //생성자는 중복이 가능해서 기본생성자, 목록생성자를 만들면 둘 다 상황에 따라 사용 가능
	
	public Friend(String name, int age, double height, double weight, String phone) {
		super(name, age, height, weight); // => super(); 부모클래스 생성자
		this.phone = phone;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	
	//overriding => 부모클래스의 메소드 - 자식클래스가 새롭게 정의.
	@Override //annotation
	public String toString() {
		String str = "친구의 이름은 " + super.getName() + "이고 \n";
		str += "나이는 " + super.getAge() + "이고 \n";
		str += "연락처는 " + this.getPhone() + "입니다. \n";
		return str;
	} 
}
