package personal.project;

public class Member {
	
	private int memberId;
	private int password;
	private String memberName;
	private String memberPhone;
	
	public Member() {
		super();
	}
	
	public Member(int memberId, int password) {
		super();
		this.memberId = memberId;
		this.password = password;
	}
	
	public Member(int memberId, int password, String memberName, String memberPhone) {
		super();
		this.memberId = memberId;
		this.password = password;
		this.memberName = memberName;
		this.memberPhone = memberPhone;
	}

	public int getMemberId() {
		return memberId;
	}
	
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	
	public int getPassword() {
		return password;
	}

	public void setPassword(int password) {
		this.password = password;
	}

	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getMemberPhone() {
		return memberPhone;
	}
	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}
	
	@Override
	public String toString() {
		return "회원정보 [회원번호=" + memberId + ", 회원이름=" + memberName + ", 회원연락처=" + memberPhone + "]";
	}
}
