package com.prod;

public class ArrayExample6 {
	public static void main(String[] args) {
		int[] numbers = { 35, 22, 17, 40, 28, 33, 36 };
		//배열의 값이 30보다 크고 40보다 작은 값의 합, 평균
		
		int sum = 0, cnt = 0;
		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i]>30 && numbers[i] < 40) {
				sum += numbers[i];
				cnt++;
			}
		}
		System.out.println("합계 : " + sum);
		System.out.println("평균 : " + ((double) sum/cnt));
	}
}
