package com.test;

//문제4) 1 ~ 6까지 임의의 정수를 생성하는 Math.random()을 사용하여 작성하세요.
//생성된 값을 정수배열(크기 5)를 선언 후 값을 저장 후 가장 큰 값을 구하는 코드를 작성.
public class Exam04 {
	public static void main(String[] args) {

		int[] randVals = new int[5];
		int max = randVals[0];

		for (int i = 0; i < 5; i++) {
			randVals[i] = (int) (Math.random() * 6) + 1;
			if (randVals[i] > max) {
				max = randVals[i];
			}
		}
		System.out.println("최대값 : " + max);
	}
}
