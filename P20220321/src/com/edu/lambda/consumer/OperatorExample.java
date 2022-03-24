package com.edu.lambda.consumer;

import java.util.function.IntBinaryOperator;

public class OperatorExample {
	public static void main(String[] args) {
		
		//1)원래식
//		IntBinaryOperator intBin = new IntBinaryOperator() {
//			@Override
//			public int applyAsInt(int left, int right) {
//			
//				return 0;
//			}	
//		};
		
		//2)람다식
		IntBinaryOperator intBin = (left, right) -> left + right; //주어진 수를 더하는 기능
		intBin.applyAsInt(10, 20);
			
//		intBin = (num1, num2) -> num1 > num2 ? num1 : num2; //삼항연산자 (최대값을 구하는 기능)
		intBin = (num1, num2) -> num1 < num2 ? num1 : num2; //삼항연산자 (최소값을 구하는 기능)
		int result = maxOrMin(intBin);
		System.out.println(result);
	}
	
	public static int maxOrMin(IntBinaryOperator intBin) { 
		//매개변수로 기능이 들어옴 이제까지 매개변수가 들어오면 메소드에서 결과를 도출했는데 기능이 매개값으로 들어오면 최소값, 최대값, 주어진 수를 더한 값 등 그때그때 바꿀 수 있음
		int[] intAry = {85, 47, 92};
		int result = intAry[0];  //주어진 수를 더한 값을 구할땐 0;
		for (int num : intAry) {
			result = intBin.applyAsInt(result, num);
		}
		return result;
	}
}
