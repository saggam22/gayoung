package com.test;

import java.util.Scanner;

// 문제5) Book클래스를 선언(필드:책제목, 저자, 출판사, 금액) private 으로 선언
//      생성자(책제목, 저자, 출판사, 금액)를 선언 후 Scanner클래스를 사용하여 사용자의 입력을 통하여 인스턴스를 생성하고 
//      입력한 내용을 책제목, 저자, 출판사, 금액 정보를 화면에 출력하는 기능 구현.
public class Exam05 {
	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		
		System.out.print("책제목을 입력하세요> ");
		String name = scn.next();
		System.out.print("작가를 입력하세요> ");
		String writer = scn.next();
		System.out.print("출판사를 입력하세요> ");
		String publisher = scn.next();
		System.out.print("금액을 입력하세요> ");
		int price = scn.nextInt();
		
		Book info = new Book(name, writer, publisher, price);
		
		System.out.println(info.getBookInfo());
		
		scn.close();
	}
}