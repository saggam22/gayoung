package com.dev;

public class AccExmple {
	public static void main(String[] args) {
		
//		Account a1 = new Account(); //힙영역에 실체(인스턴스) 생성하면 스택영역에 값을 던져줌
		
		 System.out.println(Account.bankName); //인스턴스를 생성하지 않았는데도 값을 가져올 수 있는 이유 => (클래스에 소속되어져있는) 정적필드, 정적메소드는 인스턴스를 만들지 않아도 호출가능
		 Account.showBankName();
		 
		 //인스턴스를 생성해야할 때는 항상 다른 값을 가질 때
		 //ex.쉐어하우스 주방과 거실은 공용으로 사용하니 정적필드나 정적메소드 (static) vs 방 또는 침실은 각자 꾸밀수있으니 인스턴스를 생성
		 
		 Calcurator.sum(10, 20); //각각의 인스턴스가 가지는 기능으로 만들지 않아도 된다
		 
		 Calcurator c1 = new Calcurator();
		 c1.sum(10, 20); //인스턴스를 생성하여 값을 입력할 필요없이 위처럼 바로 활용가능
		 
		 Calcurator.getArea(10);
		 
		 //static 활용
		 
	}
}
