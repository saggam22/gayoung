package com.prod;

public class ArrayExample5 {
	public static void main(String[] args) {
		int[] numbers = { 35, 22, 17, 40, 28, 33, 36 };
		
		//홀수번째 위치의 값들만 더하고 그 놈들의 평균
		
		int sum = 0, cnt = 0;
		
		for (int i=0; i<numbers.length; i+=2) {
			sum += numbers[i];
			cnt++;
		}
		System.out.println("홀수번째 위치 값들의 합: " + sum);
		System.out.println("홀수번째 값들의 평균: " + (sum/(double)cnt));
	}
}

// 또는 for문안에 if문을 사용해서 가능
//if (i % 2 == 0) {
//sum += numbers[i];
//cnt++;
//}