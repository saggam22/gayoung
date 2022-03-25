package com.edu;

public class SwimMember extends Member {
	// 강습반의 강사이름.
	// 수영등급(A,B,C,D)
	private String swMemberName;
	private String swGrade;
	
	// 정보출력시 => 강사이름: 홍길동, 등급: A 
	public SwimMember(int memberId, String memberName, String phone, String swMemberName, String swGrade) {
		super(memberId, memberName, phone);
		this.swMemberName = swMemberName;
		this.swGrade = swGrade;
	}
	
	public String getSwMemberName() {
		return swMemberName;
	}
	
	public void setSwMemberName(String swMemberName) {
		this.swMemberName = swMemberName;
	}
	
	public String getSwGrade() {
		return swGrade;
	}
	
	public void setSwGrade(String swGrade) {
		this.swGrade = swGrade;
	}
	
	@Override
	public String toString() {
		return "Member [memberId=" + super.getMemberId() + ", memberName=" + super.getMemberName() + ", phone=" + super.getPhone() +  ", 강사이름=" +  this.getSwMemberName() + ", 수영등급=" + this.getSwGrade() +"]";
	}
	
}
