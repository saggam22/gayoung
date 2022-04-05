package personal.project2;

import java.util.Scanner;

public class SlotMachine {
	
	static Scanner scn = new Scanner(System.in);
	public static final int max = 5; //메뉴 최대 갯수 5개

	static String[] slot = new String[max]; //static을 사용하면 초기화해주지 않아도 0으로 초기화
	static int[] price = new int[max];
	static int[] stock = new int[max];
	
	
	public static void main(String[] args) {
		
	}
	
	public static void UserExcute() {
		
		int money;
		int buy;
		
		while (true) {
		System.out.println("===============자판기==============");
		System.out.println("1.음료수사기 2.로또사기 8.관리자용 9.프로그램 종료");
		int menu = scn.nextInt();
		if (menu == 1) {
			for(int i = 0; i<slot.length; i++) {
				System.out.println((i+1) + ". " + slot[i] + price[i] + "원 재고 : " + stock[i]);
			}
			
		} else if(menu == 2) {
			//(Math.random()*45)
		} else if(menu == 8) {
			
		} else if(menu == 9) {
			System.out.println("프로그램을 종료합니다.");
			break;
		}
	}
	System.out.println("end of prog");
	} 
	
	
	public static void AdminExcute() {
		Scanner scn = new Scanner(System.in);
		
		while (true) {
		System.out.println("===============자판기==============");
		System.out.println("1.음료수사기 2.로또사기 8.관리자용 9.프로그램 종료");
		int menu = scn.nextInt();
		if (menu == 1) {
			
		} else if(menu == 2) {
			//(Math.random()*45)
		} else if(menu == 8) {
			
		} else if(menu == 9) {
			System.out.println("프로그램을 종료합니다.");
			break;
		}
	}
	System.out.println("end of prog");
	} 
}
