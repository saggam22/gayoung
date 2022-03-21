package com.edu;

public class FriendListApp {
	public static void main(String[] args) {
		Friend[] friends = new Friend[10];
		
		Friend f1 = new Friend();
		f1.setName("진휘용");
		f1.setAge(25);
		f1.setHeight(178.3);
		f1.setWeight(68.9); //Person 클래스의 공통된 속성을 상속
		f1.setPhone("010-2323-9845");
		
		UnivFriend f2 = new UnivFriend("서현일", 29, 178.3, 69.2, "010-1111-2222");
		f2.setUniversity("대구대학교");
		f2.setMajor("컴퓨터공학과");
		
		ComFriend f3 = new ComFriend("최규완", 29, 179.3, 75.2, "010-1341-7349", "네이버", "지도app 개발 연구원");
		
		Friend f4 = new Friend();
		f4.setName("김뇽뇽");
		f4.setAge(25);
		f4.setHeight(178.3);
		f4.setWeight(68.9); //Person 클래스의 공통된 속성을 상속
		f4.setPhone("010-2323-9845");
		
		UnivFriend f5 = new UnivFriend("이영짱", 29, 178.3, 69.2, "010-1111-2222");
		f5.setUniversity("대구대학교");
		f5.setMajor("컴퓨터공학과");
		
		ComFriend f6 = new ComFriend("최총총", 29, 179.3, 75.2, "010-1341-7349", "네이버", "지도app 개발 연구원");
		
		friends[0] = f1;
		friends[1] = f2;
		friends[2] = f3;
		friends[4] = f4;
		friends[5] = f5;
		friends[6] = f6;
		
//		for(int i=0; i<friends.length; i++) {
//			if(friends[i] != null)
//			System.out.println(friends[i].toString()); //각각의 클래스의 인스턴스가 실행하는 것 => 다형성 : 동일한 기능이지만 인스턴스 종류에 따른 결과실행
//		}
		
		Friend friend = f2; //UnivFriend;에 해당되므로 getUniversity, getMajor 값을 할당가능하여 자식클래스의 참조변수값은 자동형변환
		friend = f1; //으로 변환가능하지만 getUniversitiy가 없으므로 casting을 해주려면
		
		UnivFriend uni = null; 
		if (friend instanceof UnivFriend) {//friend 변수 값이 UnivFriend 의 인스턴스인지 확인 후
			uni = (UnivFriend) friend; //맞으면 강제형변환(casting) 해야함
			uni.getUniversity(); //부모클래스의 참조변수 => 자식클래스의 참조변수 할당하여 실행
		}

		
		for(int i=0; i<friends.length; i++) {
			if(friends[i] != null && friends[i] instanceof UnivFriend)
			System.out.println(friends[i].toString()); //toString 
		}
	}
}
