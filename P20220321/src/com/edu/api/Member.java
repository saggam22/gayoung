package com.edu.api;

public class Member {
	
	private String id;
	private String name;
	
	public Member(String id, String name) {
		this.id = id;
		this.name = name;
	}
	

	@Override
	public int hashCode() {
		return 1111;
	}


	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Member) { //Member member = null; 초기값을 if문 밖에 먼저 선언해주면 좋음
			Member member = (Member) obj;
			if(id.equals(member.id) && name.equals(member.name)) {  //.equals 대신 == 써도 무방
				return true;
			}
		}
		return false;
	}
}
