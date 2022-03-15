package com.dev;

public class ForExample4 {
	public static void main(String[] args) {
		//1~10까지 수중에서 짝수의 값 => evenSum, 홀수의 값 => oddSum
		
		int evenSum = 0, oddSum = 0;
		for (int i=1; i<=10; i++) {
			if (i % 2 == 0) {
				evenSum += i;
			} else {
				oddSum += i;
			}
		}
		//홀수의 합은 얼마이고, 짝수의 합은 얼마 입니다.
		System.out.println("홀수의 합은 " + oddSum + "이고, " + "짝수의 합은 " + evenSum + "입니다.");
		
		
		//약수의 모든 숫자를 구하는 프로그램
		
		int sum = 0, num = 48; //1,2,3,4,6,8,12,16,48
		for (int i=1; i<=num; i++) {
			if(num%i == 0) {
//				System.out.println(i);
				sum += i;
			}
		}
		System.out.println(num + "약수의 합은 " + sum);
	}
}
