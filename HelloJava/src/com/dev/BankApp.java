package com.dev;

import java.util.Scanner;

// BankApp(main method), Account(class-계좌번호, 예금주, 잔액)
public class BankApp {
	static Account[] banks = new Account[100];
	static Scanner scn = new Scanner(System.in);

	// 메뉴: 1.계좌생성(번호, 예금주, 예금액),
	// 2.예금(번호, 예금액) -> 최고예금액 10만원
	// 3.출금(번호, 출금액) -> 잔액보다 큰 금액 못하도록
	// 4.잔액조회(번호)
	// 5.종료

	public static void main(String[] args) {

		while (true) {
			printMenu();
			int menu = scn.nextInt();

			if (menu == 1) {
				createAccount();
			} else if (menu == 2) {
				deposit();
			} else if (menu == 3) {
				withdraw();
			} else if (menu == 4) {
				findAccountMoney();
			} else if (menu == 5) {
				System.out.println("프로그램을 종료합니다.");
				break;
			} else if (menu == 9 ) {
				showList();
			} 
			
		}
		System.out.println("===End of Prog===");
	}

	// 메뉴출력 기능
	public static void printMenu() {
		String menu = "============================\r\n" 
				+ "1.계좌생성(번호, 예금주, 예금액)\r\n" 
				+ "2.예금(번호, 예금액)\r\n"
				+ "3.출금(번호, 출금액)\r\n" 
				+ "4.잔액조회(번호)\r\n" 
				+ "5.종료\r\n" 
				+ "============================\r\n" 
				+ "선택 >  ";
		
		System.out.println(menu);
	}

	// 계좌생성 메소드
	public static void createAccount() {
		System.out.print("계좌번호 입력>> ");
		String accNo = scn.next();
		int checkCnt = 0; //계좌가 있는 건지 확인하는 변수
	
		for(int i=0; i<banks.length; i++) {
			if(banks[i] != null && banks[i].getAccNo().equals(accNo)) { //입력값이랑 저장값이 같을때
				checkCnt = 1;
				break;
			}
		}
		if(checkCnt == 1) {
			System.out.println("동일한 계좌번호가 있습니다.");
			
		} else if(checkCnt == 0) {
			System.out.println("예금주 입력>> ");
			String accName = scn.next();
			System.out.print("예금액 입력>> ");
			int accMoney = scn.nextInt();
			Account accnt = new Account(accNo, accName, accMoney);

			for (int i = 0; i < banks.length; i++) {
				if (banks[i] == null) {
					banks[i] = accnt;
					break;
				}
			}
			System.out.println("계좌가 정상적으로 생성되었습니다.");
		}
	}

	// 예금처리메소드
	public static void deposit() {
		System.out.print("계좌번호>> ");
		String ano = scn.next();
		System.out.print("예금액입력>> ");
		int amt = scn.nextInt();
		int checkCnt = 0; //계좌번호가 있는 건지 확인하는 변수
		for(int i=0; i<banks.length; i++) {
			if(banks[i] != null && banks[i].getAccNo().equals(ano)) { //계좌번호 확인
				//계좌번호 조회되었을때
				checkCnt = 1;
				int currAmt = banks[i].getMoney();
				if(currAmt + amt > 100000 ) {
					checkCnt = 2;
					break;
				}
				banks[i].setMoney(currAmt + amt); //기존에 입금한 금액과 새로 입금하는 금액을 합해야하므로
				break;
			}
		}
		if(checkCnt == 1) {
			System.out.println("정상적으로 처리되었습니다.");
		} else if(checkCnt == 2) {
			System.out.println("한도 금액을 초과했습니다.");
		} else {
			System.out.println("계좌번호가 없습니다.");
		}
	}

	// 출금처리 메소드
	public static void withdraw() {
		System.out.print("계좌번호>> ");
		String ano = scn.next();
		System.out.print("출금액입력>> ");
		int amt = scn.nextInt();
		int checkCnt = 0; //계좌번호가 있는 건지 확인하는 변수
		for(int i=0; i<banks.length; i++) {
			if(banks[i] != null && banks[i].getAccNo().equals(ano)) { //계좌번호 확인
				//계좌번호 조회되었을때
				checkCnt = 1;
				int currAmt = banks[i].getMoney();
				if(currAmt - amt < 0 ) {
					checkCnt = 2;
					break;
				}
				banks[i].setMoney(currAmt - amt); //기존에 입금한 금액과 새로 입금하는 금액을 빼야하므로
				break;
			}
		}
		if(checkCnt == 1) {
			System.out.println("정상적으로 처리되었습니다.");
		} else if(checkCnt == 2) {
			System.out.println("잔액이 부족합니다..");
		} else {
			System.out.println("계좌번호가 없습니다.");
		}
	}

	// 잔액조회 메소드
	public static void findAccountMoney() {
		System.out.print("계좌번호>> ");
		String ano = scn.next();
		int checkCnt = 0; //계좌번호가 있는 건지 확인하는 변수
		for(int i=0; i<banks.length; i++) {
			if(banks[i] != null && banks[i].getAccNo().equals(ano)) { //계좌번호 확인
				//계좌번호 조회되었을때
				checkCnt = 1;
				int currAmt = banks[i].getMoney();
				System.out.println("잔액은 " + currAmt + "원 입니다.");
					break;
			} else {
				checkCnt = 2;
			}
		}
		if(checkCnt == 1) {
			System.out.println("조회완료");
		} else if(checkCnt == 2) {
			System.out.println("계좌번호가 없습니다.");
		}
	}
	//전체 리스트 출력
	public static void showList() {
		for(int i=0; i<banks.length; i++) {
			if(banks[i] != null) {
				System.out.println(banks[i].toString());
			}
		}
	}
}
