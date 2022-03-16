package com.prod;

public class FriendExample {
	public static void main(String[] args) {
		//친구의 정보(이름, 전화번호, 이메일, 키, 몸무게)
		Friend f1 = new Friend();
		f1.friendName = "김가나";
		f1.friendPhone = "010-1234-5678";
		f1.email = "yedam1@yedam.com";
		f1.height = 167.5;
		f1.weight = 64.2;
		
		Friend f2 = new Friend();
		f2.friendName = "김다라";
		f2.friendPhone = "010-1234-5679";
		f2.email = "yedam2@yedam.com";
		f2.height = 158.5;
		f2.weight = 50.7;
		
		Friend f3 = new Friend();
		f3.friendName = "김마바";
		f3.friendPhone = "010-1234-5679";
		f3.email = "yedam3@yedam.com";
		f3.height = 170.3;
		f3.weight = 48.2;
		
		System.out.println(f1); //com.prod.Friend@34ce8af7 물리적 주소 위치를 알려줌
		
		Friend[] friends = { f1, f2, f3 };
		
		for(int i = 0; i < friends.length; i++) {
			if(friends[i].height < 170) {
				System.out.println("이름: " + friends[i].friendName);
				System.out.println("전화번호: " + friends[i].friendPhone);
				System.out.println("키: " + friends[i].height);
				System.out.println("================================");
			}
		}
	}
}
