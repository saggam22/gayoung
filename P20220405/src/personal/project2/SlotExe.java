package personal.project2;

import java.util.Scanner;

public class SlotExe {
	public void excute() {
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
