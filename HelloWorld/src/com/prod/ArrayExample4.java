package com.prod;

public class ArrayExample4 {
	public static void main(String[] args) {
		int[] numbers = { 35, 22, 17, 40, 28, 33, 36 };
		
		int sum = 0;
		int cnt = 0;
		
		for(int i=0; i<numbers.length; i++) {//5보다 numbers.length를 쓰면 배열의 크기가 커져도 오류 발생x
			if(numbers[i] % 2 == 0) {
				sum += numbers[i];
				cnt++;
			}
		}
		System.out.println("짝수값의 합: " + sum);
		System.out.println("짝수값의 평균: " + (sum/(double)cnt));
	}
}