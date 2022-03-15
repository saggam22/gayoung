package com.dev;

import java.util.Scanner;

public class IfExample2 {
	public static void main(String[] args) {
		//물건가격이 5만원 이상이면 배송비 0
		//그외 배송비 3000원
		//최종 결재할 금액이 얼마인지 보여주는 코드
		Scanner scn = new Scanner(System.in);
		int price, shippingFee=3000;
		
		System.out.println("물건가격을 입력하세요");
		price = scn.nextInt();
		
		if(price>=50000) {
			System.out.println("결제금액은 " + price + "입니다.");
		} else {
			System.out.println("결제할 금액은 " + (price+shippingFee) + "입니다.");
		}
		
		price = (price >=50000) ? price : price+shippingFee; //삼항연산자
		scn.close();
	}
}
