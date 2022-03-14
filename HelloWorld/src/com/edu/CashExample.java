package com.edu;

import java.util.Scanner;

public class CashExample {
	public static void main(String[] args) {
		// 두개의 값을 입력
		Scanner scn = new Scanner(System.in);
		int price, cash;
		
		// 가격을 입력하세요...
		System.out.println("가격을 입력하세요");
		price = scn.nextInt(); //5500원은 부가세 10% 포함된 금액
		
		// 손님이 낸 금액
		System.out.println("손님이 낸 금액");
		cash = scn.nextInt(); //10000원
		
		// 하나는 상품의 부가세, 하나는 거스름돈
//		price *= 0.1;
//		cash -= price;
//		System.out.println("상품의 부가세는" + price +"원이고, 거스름돈은 " + cash + "입니다.");
		System.out.println("상품의 부가세는" + (price*1/11) +"원이고, 거스름돈은 " + (cash-price) + "입니다.");
		//ex.5500원에 이미 부가세가 포함되어있으므로 5000원 + 500 이어서 500원을 구하려면 1/11 을 곱해줘야함
		scn.close();
	}
}
