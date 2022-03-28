package com.edu;

public class SoccerMember extends Member {
	// 축구반의 코치이름.
	// 락커룸의 이름.(A, B, C, D)
	private String sMemberName;
	private String sRoom;
	
	// 정보출력시 => 코치이름: 홍길동, 락커룸: A 
	public SoccerMember(int memberId, String memberName, String phone, String sMemberName, String sRoom) {
		super(memberId, memberName, phone);
		this.sMemberName = sMemberName;
		this.sRoom = sRoom;
	}

	public String getsMemberName() {
		return sMemberName;
	}

	public void setsMemberName(String sMemberName) {
		this.sMemberName = sMemberName;
	}

	public String getsRoom() {
		return sRoom;
	}

	public void setsRoom(String sRoom) {
		this.sRoom = sRoom;
	}
	
	@Override
	public String toString() {
		//String info = super.toSting 으로 기술하고 info += 로 추가정보를 더하여 사용가능!
		return "Member [memberId=" + super.getMemberId() + ", memberName=" + super.getMemberName() + ", phone=" + super.getPhone() +  ", 코치이름=" +  this.getsMemberName() + ", 락커룸이름=" + this.getsRoom() +"]";
	}
	
}
