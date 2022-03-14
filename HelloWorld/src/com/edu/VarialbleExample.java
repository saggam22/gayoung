package com.edu;

public class VarialbleExample {
	public static void main(String[] args) {
		//변수의 타입.
		int num1 = 100; //int 정수(4byte)
		double num2 = 100.5; //double 실수(8byte)
		double result = num1 * num2; // 10050의 결과라 int로 볼수있지만 크기가 큰 double로 처리
//		double result = (double) num1 * num2; 강제적으로 num1을 double로 처리해준다는 뜻이지만 자바에서는
//		자동으로 변환이된다 => 자동형변환(promotion): 작은범위 -> 큰범위 / 강제형변환(casting): 큰범위 -> 작은범위
		int val1 = 100;
		double val2 =20.5;
		int sum = val1 + (int) val2;
		System.out.println("자동형변환 결과: " + result);
		System.out.println("강제형변환 결과: " + sum);
		
		int n1 = 10;
		int n2 = 4;
		
		double n3 = (double) n1 / n2; // 10/4 = 2.5 -> int타입 결과 2 / double타입 결과 2.0
		// 2.5를 나타내려면 (double) 타입으로 캐스팅해줘야한다.
		System.out.println("나눈 결과: " + n3);
		
		// 10/4 의 나머지 = 2 나머지의 값은 모두 정수로 값을 가져옴
		int n4 = n1 % n2;
		System.out.println("나머지: " + n4);
	
		// 짝수, 홀수
		if(n1 % 2 == 0) {
			System.out.println(n1 + "의 값은 짝수입니다.");
		}
	}
}
