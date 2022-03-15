package com.dev;

import java.util.Scanner;

public class WhileExample4 {
	public static void main(String[] args) {
		//은행 계좌를 만들어서 1.입금, 2.출금, 3.종료
		//입금일 경우 : 입금액을 입력하세요... account 값을 누적
		//출금일 경우 : 출금액을 입력하세요... account 값을 차감
		//종료일 경우 : 프로그램 종료
		
		Scanner scn = new Scanner(System.in);
		
		int account = 0, value;
		while (true) {
			System.out.println("1.입금, 2:출금, 3:종료");
			int menu = scn.nextInt();
			
			if(menu == 1) {
				System.out.println("입금금액을 입력하세요");
				account += scn.nextInt();

			} else if(menu ==2) { //마이너스 통장이 안되도록 처리
				System.out.println("출금금액을 입력하세요");
				value = scn.nextInt();
				
				if (account < value) {
					System.out.println("잔액이 부족합니다.");
					System.out.println("잔액은 " + account +"입니다.");	
					continue; //구문 아래를 무시 다음 순번으로 넘어감.
				} 
				account -= value;
				
			} else if (menu == 3) {
				System.out.println("프로그램을 종료합니다.");	
				break;
			}
		System.out.println("잔액은 " + account +"입니다.");	
		}
	}
}
