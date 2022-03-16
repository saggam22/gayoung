package com.prod;

public class ArrayExample2 {
	public static void main(String[] args) {
		//정수를 담을 수 있는 배열, for 문을 써서 나이를 전체 나타내도록
		//sumAge
		
		int[] ages = new int[3];
		
		ages[0] = 20;
		ages[1] = 23;
		ages[2] = 27;
		
		ages[0] = 30;
		ages[1] = 32;
		ages[2] = 35;
		
		int sumAge = 0;
		for(int i=0; i<3; i++) {
			System.out.println(ages[i] + "살 입니다.");
			sumAge += ages[i];
		}
		double avgAge = (double) sumAge / 3;
		System.out.printf("%.2f", avgAge); //f는 format
	}
}
