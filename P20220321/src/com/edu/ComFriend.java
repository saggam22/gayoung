package com.edu;

public class ComFriend extends Friend {
//회사 이름, 회사업무
	private String company;
	private String job;
	
	//public ComFriend() {} //따로 언급 없을 시 기본 생성자 호출된 상태
	

	public ComFriend() {
	} //super();
	public ComFriend(String name, int age, double height, double weight, String phone, String company, String job) {
		super(name, age, height, weight, phone);
		this.company = company;
		this.job = job;
	}
	
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	
	@Override
	public String toString() {
		String str = "친구의 이름은 " + super.getName() + "이고 \n";
		str += "나이는 " + super.getAge() + "이고 \n";
		str += "연락처는 " + this.getPhone() + "입니다. \n";
		str += "=========<추가정보>=========\n";
		str += "회사이름은 " + this.getCompany() + "이고 \n";
		str += "하는 일은 " + this.getJob() + "입니다 \n";
		return str;
	} 
}
