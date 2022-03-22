package com.edu.except;

import java.util.InputMismatchException;
import java.util.Scanner;

public class LibraryExe {
	
	private static LibraryExe singleton = new LibraryExe();
	
	private LibraryExe() { //생성자를 접근제어자로 설정하면 다른 클래스에서 인스턴스 생성 불가
		
	}
	
	public static LibraryExe getInstance() { //인스턴스를 생성하는 메소드를 실행하여야만 인스턴스 생성/static 메소드는 인스턴스를 생성하지 않아도 사용가능
		return singleton;
	}
	
//	public static void main(String[] args) {
	public void run() {
		// 책제목, 저자, 가격 -> 저장
		// 리스트를 뿌려줌

		Scanner scn = new Scanner(System.in);
		Book[] library = new Book[5];

		while (true) {
			showMessage("메뉴선택: 1.책정보입력, 2.리스트보기, 3.종료");
			int menu = 0;

			while (true) {
				try {
					menu = scn.nextInt();
					break;
				} catch (InputMismatchException e) {
					System.out.println("숫자를 입력하세요.");
					scn.next();
				}
			}
			
			if (menu == 1) {
				showMessage("책제목을 입력>>> ");
				String title = scn.next();
				showMessage("저자를 입력>>> ");
				String author = scn.next();
				int price = 0;

				while (true) {
					try {
						showMessage("가격을 입력>>> ");
						price = scn.nextInt();
						break;
					} catch (InputMismatchException e) {
						System.out.println("숫자를 입력하세요.");
						scn.next();
					}
				}

				Book book = new Book(title, author, price);
				for (int i = 0; i < library.length; i++) {
					if (library[i] == null) {
						library[i] = book;
						break;
					}
				}
				showMessage("저장완료");

			} else if (menu == 2) {
				for (int i = 0; i < library.length; i++) {
					if (library[i] != null) {
						library[i].showInfo();
					}
				}
			} else if (menu == 3) {
				showMessage("프로그램을 종료합니다.");
				break;
			}
		} // end of while
		showMessage("===end of prog===");
	}

	public void showMessage(String str) {
		for (int i = 0; i < str.length(); i++) {
			System.out.print(str.charAt(i));
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
