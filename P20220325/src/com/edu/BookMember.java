package com.edu;

public class BookMember extends Member {
	// 도서반의 반장이름.
	// 도서반의 강의실정보.(지혜실, 지식실, 모험실)
	private String bMemberName;
	private String bRoom;
	

	// 정보출력시 => 반장이름: 홍길동, 강의실: 모험실 
	
	public BookMember(int memberId, String memberName, String phone, String bMemberName, String bRoom) {
		super(memberId, memberName, phone);
		this.bMemberName = bMemberName;
		this.bRoom = bRoom;
	}


	public String getbMemberName() {
		return bMemberName;
	}


	public void setbMemberName(String bMemberName) {
		this.bMemberName = bMemberName;
	}


	public String getbRoom() {
		return bRoom;
	}


	public void setbRoom(String bRoom) {
		this.bRoom = bRoom;
	}


	@Override
	public String toString() {
		return "Member [memberId=" + super.getMemberId() + ", memberName=" + super.getMemberName() + ", phone=" + super.getPhone() +  ", 반장이름=" +  this.getbMemberName() + ", 강의실정보=" + this.getbRoom() +"]";
	}
	
	
}
